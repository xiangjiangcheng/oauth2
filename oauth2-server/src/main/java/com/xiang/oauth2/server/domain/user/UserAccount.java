package com.xiang.oauth2.server.domain.user;

import com.xiang.oauth2.server.domain.DomainObject;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Jiangcheng Xiang
 */
@Data
@Entity
@Table(name = "user")
public class UserAccount extends DomainObject{

    private static final long serialVersionUID = -5382408503384136111L;

    @Column(name = "source", insertable = false, updatable = false)
    protected String source;

    @Column(name = "guid")
    protected String guid;

    @Column(name = "username")
    protected String username;

    @Column(name = "password", nullable = false)
    protected String password;

    @Column(name = "nick_name")
    protected String nickName;

    @Column(name = "avatar_url")
    protected String avatarUrl;

    @Column(name = "email")
    protected String email;

    @Column(name = "mobile")
    protected String mobile;

    @Column(name = "country")
    protected String country;

    @Column(name = "province")
    protected String province;

    @Column(name = "city")
    protected String city;

    @Column(name = "address")
    protected String address;

    @Column(name = "birthday")
    protected String birthday;

    @Column(name = "gender")
    protected String gender;

    //0.未激活，1.已激活
    @Column(name = "status")
    protected int status;

    // 类型，email,mobile
    @Column(name = "account_type")
    protected String accountType;

    // 最后一次登陆时间
    @Column(name = "last_login_time")
    protected String lastLoginTime;

    @Column(name = "salary")
    protected String salary;
}
