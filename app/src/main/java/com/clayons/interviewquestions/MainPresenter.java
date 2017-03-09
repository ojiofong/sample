package com.clayons.interviewquestions;

import android.os.Bundle;

import com.clayons.interviewquestions.Model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import nucleus.presenter.RxPresenter;
import rx.functions.Func0;

/**
 * Created by ojiofong on 3/7/17.
 *
 */


public interface MainPresenter {

    void onResume();

    void onItemClicked(int position, Person person);

    void populateViewWithData();

    void onDestroy();
}