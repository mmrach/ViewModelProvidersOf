package com.juanricardorc.viewmodelprovidersof.home;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private Context context = null;

    public DashboardViewModel(Context context) {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
        this.context = context;
    }

    //Este constructor debe de existir si se llama al ViewModelProvider sin Factory pero utilizando
    //el de la App.
    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}