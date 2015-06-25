/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wilsteph
 */
@Entity
@Table(name = "login_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoginDetails.findAll", query = "SELECT l FROM LoginDetails l"),
    @NamedQuery(name = "LoginDetails.findByLoginId", query = "SELECT l FROM LoginDetails l WHERE l.loginId = :loginId"),
    @NamedQuery(name = "LoginDetails.findByUserName", query = "SELECT l FROM LoginDetails l WHERE l.userName = :userName"),
    @NamedQuery(name = "LoginDetails.findByPassword", query = "SELECT l FROM LoginDetails l WHERE l.password = :password"),
    @NamedQuery(name = "LoginDetails.findByRole", query = "SELECT l FROM LoginDetails l WHERE l.role = :role"),
    @NamedQuery(name = "LoginDetails.findByStatus", query = "SELECT l FROM LoginDetails l WHERE l.status = :status")})
public class LoginDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "login_id")
    private Integer loginId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
    @Column(name = "status")
    private String status;

    public LoginDetails() {
    }

    public LoginDetails(Integer loginId) {
        this.loginId = loginId;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loginId != null ? loginId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginDetails)) {
            return false;
        }
        LoginDetails other = (LoginDetails) object;
        if ((this.loginId == null && other.loginId != null) || (this.loginId != null && !this.loginId.equals(other.loginId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.LoginDetails[ loginId=" + loginId + " ]";
    }
    
}
