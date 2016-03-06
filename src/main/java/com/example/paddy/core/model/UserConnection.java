package com.example.paddy.core.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.NotNull;

@javax.persistence.Entity
@javax.persistence.Table(name = "connection")
public class UserConnection {

    /**
     * @generated
     *
     */
    private static final long serialVersionUID = -6338416107166703213L;

    @Column(name = "id")
    @GeneratedValue
    @Id
    private Integer id;

    @Column(name = "ip_address", length = 60)
    @NotNull
    private String ipAddress;

    @Column(name = "browser_name", length = 255)
    @NotNull
    private String browserName;

    @Column(name = "time")
    @NotNull
    private Timestamp time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}