package com.xiang.oauth2.server.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Lang Yu
 */

@MappedSuperclass
public class DomainObject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @Version
    @Column(name = "version", length = 11)
    private int version = 0;


    @Column(name = "guid")
    String guid = GuidGenerator.createGuid();


    @Column(name = "archived", length = 1)
    boolean archived = false;

    @Column(name = "created_datetime")
    protected LocalDateTime createdDateTime = LocalDateTime.now();


    @Column(name = "last_modified_datetime")
    LocalDateTime lastModifiedDateTime;

    @PrePersist
    @PreUpdate
    public void updateLastModifiedDateTime() {
        lastModifiedDateTime = LocalDateTime.now();
    }

    public void updateLastModifiedDateTime(LocalDateTime localDateTime) {
        lastModifiedDateTime = localDateTime;
    }

    public void archive() {
        archived = true;
    }

    public void unarchive() {
        archived = false;
    }


    public boolean isArchived() {
        return archived;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DomainObject)) {
            return false;
        }

        DomainObject other = (DomainObject) obj;

        // if the id is missing, return false
        if (guid() == null) {
            return false;
        }

        // equivalence by guid
        return guid().equals(other.guid());
    }

    @Override
    public int hashCode() {
        return guid.hashCode();
    }

    public String guid() {
        return guid;
    }

    public int version() {
        return version;
    }

    public LocalDateTime createdDateTime() {
        return createdDateTime;
    }

    public LocalDateTime lastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    public boolean isNew() {
        return id == null;
    }

    // public String getID() {
    //     return NumberIncrementalUtils.fillToFixedSize(id);
    // }

    public boolean isPersisted() {
        return id != null;
    }

    public void copyFrom(DomainObject domainObject) {
//        this.id = domainObject.id;
        this.guid = domainObject.guid;
        this.archived = domainObject.archived;
        this.version = domainObject.version;
        this.createdDateTime = domainObject.createdDateTime;
        this.lastModifiedDateTime = domainObject.lastModifiedDateTime;
    }

    public void updateCreatedDateTime(LocalDateTime localDate) {
        this.createdDateTime = localDate;
    }

    // get set by xiang jiangcheng
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String createdDateTimeToStr() {
        if (this.createdDateTime != null) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return df.format(this.createdDateTime);
        }
        return null;
    }

    public String lastModifiedDateTimeToStr() {
        if (lastModifiedDateTime != null) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return df.format(this.lastModifiedDateTime);
        }
        return null;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
}
