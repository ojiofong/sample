package com.clayons.interviewquestions;

import com.clayons.interviewquestions.Model.Person;

import java.util.List;

/**
 * Created by ojiofong on 3/7/17.
 *
 */


public interface PersonInteractor {

    interface OnFinishedListener {
        void onFinished(List<Person> persons);
    }

    void getItems(OnFinishedListener listener);
}