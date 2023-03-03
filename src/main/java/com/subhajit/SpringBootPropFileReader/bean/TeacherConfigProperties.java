package com.subhajit.SpringBootPropFileReader.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


public class TeacherConfigProperties {
    private Integer id;
    private String name;
    private String subject;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "ConfigProperties{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + subject + '\'' +
                '}';
    }
}
