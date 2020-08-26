package com.itiandou.entity;

/**
 * @author Mr.Herry
 * @Title:
 * @Description:
 * @date 2019/12/25 15:51
 */

public class Customer {

    private long id;

    private String name;

    private String sex;

    private String introduction;

    private Integer attackPower;

    private Integer attackSpell;

    private long sendTime;

    public Customer() {
    }

    public Customer(long id, String name, String sex, long sendTime) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.sendTime = sendTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(Integer attackPower) {
        this.attackPower = attackPower;
    }

    public Integer getAttackSpell() {
        return attackSpell;
    }

    public void setAttackSpell(Integer attackSpell) {
        this.attackSpell = attackSpell;
    }

    public long getSendTime() {
        return sendTime;
    }

    public void setSendTime(long sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", introduction='" + introduction + '\'' +
                ", attackPower=" + attackPower +
                ", attackSpell=" + attackSpell +
                ", sendTime=" + sendTime +
                '}';
    }
}
