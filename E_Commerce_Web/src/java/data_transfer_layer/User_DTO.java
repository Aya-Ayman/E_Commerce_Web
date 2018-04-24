/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_transfer_layer;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author abdalla
 */
public class User_DTO implements Serializable {

    private String first_name;
    private String last_name;
    private Date date;
    private String email;
    private String password;
    private String job;
    private Long credit_limit;
    private String address;
    private InputStream image;

    public User_DTO() {
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Long getCredit_limit() {
        return credit_limit;
    }

    public void setCredit_limit(Long credit_limit) {
        this.credit_limit = credit_limit;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }

}
