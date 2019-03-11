package com.xiang.oauth2.server.domain.user;

import com.xiang.oauth2.server.domain.DomainObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Jiangcheng Xiang
 */
@Entity
@Table(name = "test")
public class Test extends DomainObject{

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
