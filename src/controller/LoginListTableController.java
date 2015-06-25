/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import gui.ProjectListGUI;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.LoginDetails;
import tablemodel.ProjectListTableModel;

/**
 *
 * @author wilsteph
 */
public class LoginListTableController implements Serializable {
    private ProjectListGUI gui;

    private static final String PERSISTENCE_UNIT_NAME = "Temp_GUI";
    
    public LoginListTableController(ProjectListGUI gui) {
		this.gui = gui;
	}

    public LoginListTableController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        return emf.createEntityManager();
    }

    public void create(LoginDetails loginDetails) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(loginDetails);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLoginDetails(loginDetails.getLoginId()) != null) {
                throw new PreexistingEntityException("LoginDetails " + loginDetails + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(LoginDetails loginDetails) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            loginDetails = em.merge(loginDetails);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = loginDetails.getLoginId();
                if (findLoginDetails(id) == null) {
                    throw new NonexistentEntityException("The loginDetails with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LoginDetails loginDetails;
            try {
                loginDetails = em.getReference(LoginDetails.class, id);
                loginDetails.getLoginId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The loginDetails with id " + id + " no longer exists.", enfe);
            }
            em.remove(loginDetails);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<LoginDetails> findLoginDetailsEntities() {
        return findLoginDetailsEntities(true, -1, -1);
    }

    public List<LoginDetails> findLoginDetailsEntities(int maxResults, int firstResult) {
        return findLoginDetailsEntities(false, maxResults, firstResult);
    }

    private List<LoginDetails> findLoginDetailsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(LoginDetails.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public LoginDetails findLoginDetails(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LoginDetails.class, id);
        } finally {
            em.close();
        }
    }

    public int getLoginDetailsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<LoginDetails> rt = cq.from(LoginDetails.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public String validate(String userName, String password) {
        String flag = "failure";
        EntityManager em = getEntityManager();
        Query q = em.createQuery("SELECT l FROM LoginDetails l WHERE l.userName = :userName AND l.password = :password");
        q.setParameter("userName", userName);
        q.setParameter("password", password);
        try {
            LoginDetails user = (LoginDetails) q.getSingleResult();
            if (userName.equalsIgnoreCase(user.getUserName()) && password.equals(user.getPassword())) {
                flag = "success";
                
            }
        } catch (Exception e) {
            return null;
        }

        return flag;
    }

}
