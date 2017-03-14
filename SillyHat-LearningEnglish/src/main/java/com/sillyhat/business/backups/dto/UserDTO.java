package com.sillyhat.business.backups.dto;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息
 *
 * @author 徐士宽
 * @date 2017/3/14 13:39
 */
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 785070109836209587L;

    /**
     *  主键
     */
    private String id;

    /**
     *  账号
     */
    private String login;

    /**
     *  密码
     */
    private String password;

    /**
     *  用户名
     */
    private String userName;

    /**
     *  是否删除；0：未删除；1：删除
     */
    private int isDelete;

    /**
     *  是否超管；0：不是；1：是
     */
    private int isAdministrators;

    /**
     *  创建人
     */
    private String createdUser;

    /**
     *  创建时间
     */
    private Date createdDate;

    /**
     *  修改人
     */
    private String updatedUser;

    /**
     *  修改时间
     */
    private Date updatedDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public int getIsAdministrators() {
        return isAdministrators;
    }

    public void setIsAdministrators(int isAdministrators) {
        this.isAdministrators = isAdministrators;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
