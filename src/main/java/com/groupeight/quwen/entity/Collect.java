package com.groupeight.quwen.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Collect {

    @Id
    @GeneratedValue
    private Long ID;

    private java.sql.Date time;

    public Collect(Date time) {
        this.time = time;
    }


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }



    public Date getTime() {
        return time;
    }

    public void setTime(Date colTime) {
        this.time = time;
    }
}

