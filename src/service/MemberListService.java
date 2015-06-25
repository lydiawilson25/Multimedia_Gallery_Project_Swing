package service;

import model.MemberDetail;
import javax.persistence.*;
import java.util.*;

public class MemberListService {

    private EntityManager manager;

    public MemberListService(EntityManager manager) {
        this.manager = manager;
    }

    public MemberDetail createMember(int memberID, int projectId, String memberName, String memberRole) {
        MemberDetail member = new MemberDetail();
        member.setMemberId(memberID);
        member.setProjectId(projectId);
        member.setMemberName(memberName);
        member.setMemberRole(memberRole);
        manager.persist(member);
        return member;
    }

    // method to read a record
    public MemberDetail readProject(int memberID) {
        MemberDetail media = manager.find(MemberDetail.class, memberID);
        return media;
    }

    // method to read all records
    public List<MemberDetail> readAll() {
        TypedQuery<MemberDetail> query = manager.createQuery("SELECT m FROM MemberDetail m", MemberDetail.class);
        List<MemberDetail> result = query.getResultList();
        return result;
    }

    // method to specific project records
    public List<MemberDetail> readMembers(int projectId) {
        
        Query q = manager.createQuery("SELECT m FROM MemberDetail m WHERE m.projectId = :projectId");
        q.setParameter("projectId", projectId);

        List<MemberDetail> result = q.getResultList();
        return result;
    }

    // method to update a record
    public void updateMember(int memberID, int projectId, String memberName, String memberRole) {
        MemberDetail member = manager.find(MemberDetail.class, memberID);
        if (member != null) {
        member.setMemberId(memberID);
        member.setProjectId(projectId);
        member.setMemberName(memberName);
        member.setMemberRole(memberRole);
        }
        manager.merge(member);

    }

    // method to delete a record
    public MemberDetail deleteMedia(int memberId) {
        MemberDetail member = manager.find(MemberDetail.class, memberId);
        if (member != null) {
            manager.remove(member);
        }
        return member;
    }

}
