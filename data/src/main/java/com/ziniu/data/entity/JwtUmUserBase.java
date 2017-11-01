package com.ziniu.data.entity;


import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class JwtUmUserBase implements UserDetails{
    @Id
    private String Id;

    private String loginName;
    private String showName;
    private String cellNum;
    private String Password;
    private Byte sex;
    private Integer age;
    private Byte stage;
    private String rank;
    private List<String> Roles;   //一个用户拥有的角色用一个list数组保存
    private Integer jc;           //节操
    private Res avatar;        //虚拟信息
    private Date gmtModfiy;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getCellNum() {
        return cellNum;
    }

    public void setCellNum(String cellNum) {
        this.cellNum = cellNum;
    }

    public Res getAvatar() {
        return avatar;
    }

    public void setAvatar(Res avatar) {
        this.avatar = avatar;
    }

    @Override
    public String getPassword() {
        return Password;
    }

    @Override
    public String getUsername() {
        return loginName;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Byte getStage() {
        return stage;
    }

    public void setStage(Byte stage) {
        this.stage = stage;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public List<String> getRoles() {
        return Roles;
    }

    public void setRoles(List<String> roles) {
        Roles = roles;
    }

    public Integer getJc() {
        return jc;
    }

    public void setJc(Integer jc) {
        this.jc = jc;
    }

    public Date getGmtModfiy() {
        return gmtModfiy;
    }

    public void setGmtModfiy(Date gmtModfiy) {
        this.gmtModfiy = gmtModfiy;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        List<String> umSecUserRoles = this.getRoles();
        for (String secUserRole : umSecUserRoles){
            auths.add(new SimpleGrantedAuthority(secUserRole));
        }

        return auths;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String toString() {
        return "JwtUmUserBase{" +
                "loginName='" + loginName + '\'' +
                ", showName='" + showName + '\'' +
                ", cellNum='" + cellNum + '\'' +
                ", Password='" + Password + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", stage=" + stage +
                ", rank='" + rank + '\'' +
                ", Roles=" + Roles +
                ", jc=" + jc +
                ", avatar=" + avatar +
                ", gmtModfiy=" + gmtModfiy +
                '}';
    }
}
