package com.alfazid.guestbooks.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "guest")
@Entity
public class Guest implements Serializable {
    @Id
    @Column(name = "id_guest")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idGuest;
    @Column(name = "name",length = 30)
    private String name;
    @Column(name = "phone_number",length = 15)
    private String phoneNumber;

    public Integer getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(Integer idGuest) {
        this.idGuest = idGuest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
