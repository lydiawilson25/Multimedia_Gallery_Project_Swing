package model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the media_details database table.
 *
 */
@Entity
@Table(name = "media_details")
@NamedQuery(name = "MediaDetail.findAll", query = "SELECT m FROM MediaDetail m")
public class MediaDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "media_id")
    private int mediaId;

    @Column(name = "description")
    private String description;

    @Lob
    @Column(name = "media_file")
    private String mediaFile;

    @Column(name = "media_name")
    private String mediaName;

    @Column(name = "media_type")
    private String mediaType;

    @Column(name = "project_id")
    private int projectId;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false, insertable = false, updatable = false)
    private ProjectDetail project;

    public ProjectDetail getProject() {
        return project;
    }

    public void setProject(ProjectDetail project) {
        this.project = project;
    }

    public MediaDetail() {
    }

    public int getMediaId() {
        return this.mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMediaFile() {
        return this.mediaFile;
    }

    public void setMediaFile(String mediaFile) {
        this.mediaFile = mediaFile;
    }

    public String getMediaName() {
        return this.mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public String getMediaType() {
        return this.mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public int getProjectId() {
        return this.projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    // return number of columns in the table
    public int getNumberOfColumns() {
        return 6;
    }

    // return the data in column i
    public String getColumnData(int i) throws Exception {
        if (i == 0) {
            return Integer.toString(getMediaId());
        } else if (i == 1) {
            return Integer.toString(getProjectId());
        } else if (i == 2) {
            return getMediaType();
        } else if (i == 3) {
            return getMediaName();
        } else if (i == 4) {
            return getDescription();
        } else if (i == 5) {
            return getMediaFile();
        } else {
            throw new Exception("Error: invalid column index in media table");
        }
    }

    // return the name of column i
    public String getColumnName(int i) throws Exception {
        String colName = null;
        if (i == 0) {
            colName = "Media ID";
        } else if (i == 1) {
            colName = "Project ID";
        } else if (i == 2) {
            colName = "Media Type";
        } else if (i == 3) {
            colName = "Media Name";
        } else if (i == 4) {
            colName = "Description";
        } else if (i == 5) {
            colName = "Media Title";
        } else {
            throw new Exception(
                    "Access to invalid column number in media table");
        }

        return colName;
    }

    // set data column i to value
    public void setColumnData(int i, Object value) throws Exception {
        if (i == 0) {
            mediaId = Integer.parseInt((String) value);
        } else if (i == 1) {
            projectId = Integer.parseInt((String) value);
        } else if (i == 2) {
            mediaType = (String) value;
        } else if (i == 3) {
            mediaName = (String) value;
        } else if (i == 4) {
            description = (String) value;
        } else if (i == 5) {
            mediaFile = (String) value;
        } else {
            throw new Exception("Error: invalid column index in media table");
        }
    }

    @Override
    public String toString() {
        StringBuilder obj = new StringBuilder();
        obj.append("MediaDetail [project=").append(project).append(", mediaId=").append(mediaId)
                .append(", description=").append(description).append(", mediaFile=").append(mediaFile)
                .append(", mediaName=").append(mediaName).append(", mediaType=").append(mediaType)
                .append(", projectId=").append(projectId).append("]");
        return obj.toString();
    }

}
