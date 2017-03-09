package com.clayons.interviewquestions;

import com.clayons.interviewquestions.Model.Person;

import java.util.List;
import java.util.Locale;

/**
 * Created by ojiofong on 3/7/17.
 *
 */

public class MainPresenterImpl implements MainPresenter, PersonInteractor.OnFinishedListener {

    private MainView mainView;
    private PersonInteractor personInteractor;

    public MainPresenterImpl(MainView mainView, PersonInteractor findItemsInteractor) {
        this.mainView = mainView;
        this.personInteractor = findItemsInteractor;
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onItemClicked(int position, Person person) {
        if (mainView != null) {
            mainView.showDetailView(person);
        }
    }

    @Override
    public void populateViewWithData() {
        personInteractor.getItems(this);
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onFinished(List<Person> persons) {
        if (mainView != null) {
            mainView.setItems(persons);
        }
    }

    public MainView getMainView() {
        return mainView;
    }

}