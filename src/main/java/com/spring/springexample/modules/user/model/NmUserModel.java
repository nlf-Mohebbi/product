package com.spring.springexample.modules.user.model;

import com.spring.springexample.common.NmBaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ums_user")

public class NmUserModel extends NmBaseModel {

    String username;
    String password;
    Boolean deleted;
    Long groupId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
