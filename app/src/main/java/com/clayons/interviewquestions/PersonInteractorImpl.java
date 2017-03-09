package com.clayons.interviewquestions;

import android.os.Handler;

import com.clayons.interviewquestions.Model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ojiofong on 3/7/17.
 *
 */

public class PersonInteractorImpl implements PersonInteractor {

    public PersonInteractorImpl(){}

    @Override public void getItems(final OnFinishedListener listener) {
        // Purposely delaying for 2 seconds just for fun so it feels like we're doing some work
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                listener.onFinished(getPersons());
            }
        }, 2000);
    }


    private List<Person> getPersons() {
        final List<Person> persons = new ArrayList<>();
        persons.add(new Person("Shubhanshu", "Yadav", 5, "111-222-3337", "http://www.max2.com/img/SHUBHANSHU.png", false));
        persons.add(new Person("Atesh", "Yurdakul", 5, "111-222-3337", "http://www.max2.com/img/ATESH.png", false));
        persons.add(new Person("Daniel", "Yurdakul", 5, "111-222-3337", "http://www.max2.com/img/DANIEL.png", true));
        persons.add(new Person("Pranav", "Bhalla", 5, "111-222-3337", "http://www.max2.com/img/PRANAV.png", true));
        persons.add(new Person("Rohan", "Nagrani", 20, "111-222-3333", "http://www.max2.com/img/ROHAN.png", false));
        persons.add(new Person("Michael", "Salmasi", 30, "111-222-3334", "http://www.max2.com/img/MICHAEL.png", false));
        persons.add(new Person("Josh", "Williams", 24, "111-222-3335", "http://www.max2.com/img/josh.png", false));
        persons.add(new Person("Jing", "Guo", 15, "111-222-3336", "http://www.max2.com/img/jing.png", false));
        persons.add(new Person("Zhenyu", "Wen", 5, "111-222-3337", "http://www.max2.com/img/zhenyu.png", false));
        return persons;
    }
}