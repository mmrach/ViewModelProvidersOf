package com.juanricardorc.viewmodelprovidersof.home;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel(Context context) {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    //Constructor sin parametros para usar la App Factory.
    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}