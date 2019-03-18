package com.personal.application.pojo;

public class EmpMst {
    private String roleId;
    private String menuCode;
    private String actionFlg;

    public EmpMst(String roleId, String menuCode, String action_flg) {
        this.roleId = roleId;
        this.menuCode = menuCode;
        this.actionFlg = actionFlg;
    }

    public EmpMst() {
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getActionFlg() {
        return actionFlg;
    }

    public void setActionFlg(String actionFlg) {
        this.actionFlg = actionFlg;
    }

    @Override
    public String toString() {
        return "EmpMst{" +
                "roleId='" + roleId + '\'' +
                ", menuCode='" + menuCode + '\'' +
                ", action_flg='" + actionFlg + '\'' +
                '}';
    }
}
