package com.rujal.esoftwarica.fragments.about_us;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AboutUsModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AboutUsModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}
