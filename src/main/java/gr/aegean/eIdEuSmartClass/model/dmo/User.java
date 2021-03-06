/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.aegean.eIdEuSmartClass.model.dmo;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Dante
 */
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;

    private String eIDAS_id;
    private String name;
    private String surname;

    /**
     * new columns!!
     */
    private String email;
    private String mobile;
    private String affiliation;
    private String country;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @Column(name = "date_of_birth")
    private LocalDate birthday;

    @Column(name = "last_login")
    private Date lastLogin;

    protected User() {
    }

    public User(Role role, String eIDAS_id, String name, String surname, String email, String mobile, String affiliation, String country, Gender gender, LocalDate birthday, Date lastLogin) {

        this.role = role;
        this.eIDAS_id = eIDAS_id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.mobile = mobile;
        this.affiliation = affiliation;
        this.country = country;
        this.gender = gender;
        this.birthday = birthday;
        this.lastLogin = lastLogin;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the eIDAS_id
     */
    public String geteIDAS_id() {
        return eIDAS_id;
    }

    /**
     * @param eIDAS_id the eIDAS_id to set
     */
    public void seteIDAS_id(String eIDAS_id) {
        this.eIDAS_id = eIDAS_id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the birthday
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the lastLogin
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     * @param lastLogin the lastLogin to set
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        String result = String
                .format("User [id %d, "
                        + "name='%s',"
                        + " eIDASId='%s', "
                        + " birthday='%s', "
                        + " lastLogin='%s']",
                        this.id, this.name, this.eIDAS_id, this.birthday.toString(), this.lastLogin.toString());

        return result;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
