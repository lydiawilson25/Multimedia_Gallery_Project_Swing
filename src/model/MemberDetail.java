package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the member_details database table.
 * 
 */
@Entity
@Table(name="member_details")
@NamedQuery(name="MemberDetail.findAll", query="SELECT m FROM MemberDetail m")
public class MemberDetail implements Serializable {
    @Column(name = "project_id")
    private Integer projectId;
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="member_id")
	private int memberId;

	@Column(name="member_name")
	private String memberName;

	@Column(name="member_role")
	private String memberRole;


	public MemberDetail() {
	}

	public int getMemberId() {
		return this.memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return this.memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberRole() {
		return this.memberRole;
	}

	public void setMemberRole(String memberRole) {
		this.memberRole = memberRole;
	}

	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

            // return number of columns in the table
    public int getNumberOfColumns() {
        return 4;
    }

    // return the data in column i
    public String getColumnData(int i) throws Exception {
        if (i == 0) {
            return Integer.toString(getMemberId());
        } else if (i == 1) {
            return Integer.toString(getProjectId());
        } else if (i == 2) {
            return getMemberName();
        } else if (i == 3) {
            return getMemberRole();
        } else {
            throw new Exception("Error: invalid column index in media table");
        }
    }

    // return the name of column i
    public String getColumnName(int i) throws Exception {
        String colName = null;
        if (i == 0) {
            colName = "Member ID";
        } else if (i == 1) {
            colName = "Project ID";
        } else if (i == 2) {
            colName = "Member Name";
        } else if (i == 3) {
            colName = "Member Role";
        } else {
            throw new Exception(
                    "Access to invalid column number in media table");
        }

        return colName;
    }

    // set data column i to value
    public void setColumnData(int i, Object value) throws Exception {
        if (i == 0) {
            memberId = Integer.parseInt((String) value);
        } else if (i == 1) {
            projectId = Integer.parseInt((String) value);
        } else if (i == 2) {
            memberName = (String) value;
        } else if (i == 3) {
            memberRole = (String) value;
        } else {
            throw new Exception("Error: invalid column index in media table");
        }
    }

    @Override
    public String toString() {
        StringBuilder obj = new StringBuilder();
        obj.append("MemberDetail [memberID=").append(memberId).append(", projectId=").append(projectId)
                .append(", memberName=").append(memberName).append(", memberRole=").append(memberRole)
                .append(" ]");
        return obj.toString();
    }

}