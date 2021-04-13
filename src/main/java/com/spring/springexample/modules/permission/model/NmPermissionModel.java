package com.spring.springexample.modules.permission.model;

import com.spring.springexample.common.NmBaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ums_permission")
public class NmPermissionModel extends NmBaseModel {
    Long groupId;
    Long moduleId;
    Boolean readAction;
    Boolean createAction;
    Boolean updateAction;
    Boolean deleteAction;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Boolean getReadAction() {
        return readAction;
    }

    public void setReadAction(Boolean readAction) {
        this.readAction = readAction;
    }

    public Boolean getCreateAction() {
        return createAction;
    }

    public void setCreateAction(Boolean createAction) {
        this.createAction = createAction;
    }

    public Boolean getUpdateAction() {
        return updateAction;
    }

    public void setUpdateAction(Boolean updateAction) {
        this.updateAction = updateAction;
    }

    public Boolean getDeleteAction() {
        return deleteAction;
    }

    public void setDeleteAction(Boolean deleteAction) {
        this.deleteAction = deleteAction;
    }
}
