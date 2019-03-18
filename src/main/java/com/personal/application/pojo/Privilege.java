package com.personal.application.pojo;

public class Privilege {
    private String moduleCode;
    private String moduleName;
    private String menuCode;
    private String menuName;
    private String menuGroup;

    public Privilege() {
    }

    public Privilege(String moduleCode, String moduleName, String menuCode, String menuName, String menuGroup) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuGroup = menuGroup;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuGroup() {
        return menuGroup;
    }

    public void setMenuGroup(String menuGroup) {
        this.menuGroup = menuGroup;
    }

}
