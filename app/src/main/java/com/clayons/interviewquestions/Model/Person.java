package com.clayons.interviewquestions.Model;

import java.io.Serializable;

/**
 * Created by jaychung on 11/16/15.
 */
public class Person implements Serializable {

    public String firstName;
    public String lastName;
    public  int age;
    public  String phoneNum;
    public String photoUrl;
    public  boolean isLiked;

    public Person(){}

    public Person(String firstName, String lastName, Integer age, String phoneNum, String photoUrl, boolean isLiked) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.age = age;
        this.photoUrl = photoUrl;
        this.isLiked = isLiked;
    }

}
