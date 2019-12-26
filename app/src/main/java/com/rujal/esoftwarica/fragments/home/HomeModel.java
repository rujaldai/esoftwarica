package com.rujal.esoftwarica.fragments.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }

}
