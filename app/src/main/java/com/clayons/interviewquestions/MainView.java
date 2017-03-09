package com.clayons.interviewquestions;

import com.clayons.interviewquestions.Model.Person;

import java.util.List;

/**
 * Created by ojiofong on 3/7/17.
 *
 */

public interface MainView {

    void showDetailView(Person person);

    void setItems(List<Person> persons);

    void showMessage(String message);

}