package com.rujal.esoftwarica.fragments.add_students;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddStudentModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AddStudentModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}
