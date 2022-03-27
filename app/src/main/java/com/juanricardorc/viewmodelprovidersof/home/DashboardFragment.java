package com.juanricardorc.viewmodelprovidersof.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.juanricardorc.viewmodelprovidersof.R;

public class DashboardFragment extends Fragment {

    // Referencia a la Factory de la App, a usar cuando el ViewModel no recibe parámetros y se usa su constructor por defecto
    private ViewModelProvider.AndroidViewModelFactory theAppFactory;

    private DashboardViewModel dashboardViewModel;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        // Con Factory,
        DashboardViewModelFactory factory = new DashboardViewModelFactory(getContext());

        // Sin Factory, cogiendo la Factory del objeto App.
        theAppFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication());
        dashboardViewModel = new ViewModelProvider(this,theAppFactory).get(DashboardViewModel.class);
        //dashboardViewModel = new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication())).get(DashboardViewModel.class);
        //viewModelProvider.get(DashboardViewModel.class);

        homeViewModel = new ViewModelProvider(this,theAppFactory).get(HomeViewModel.class);

        // Sin Factory,
/*      //esto no funciona, se necesita coger una factory, el de arriba si va
        dashboardViewModel = new ViewModelProvider(this)
                .get(DashboardViewModel.class);
*/

        // Con Factory, requireActivity().getViewModelStore()
/*
        dashboardViewModel = new ViewModelProvider(requireActivity()
                .getViewModelStore(), factory)
                .get(DashboardViewModel.class);
*/

        // Con Factory, requireParentFragment().getViewModelStore()
/*
        dashboardViewModel = new ViewModelProvider(requireParentFragment()
                .getViewModelStore(), factory)
                .get(DashboardViewModel.class);
*/

        // Cuando el ViewModel reciba parametros, creamos una Factory Propia,
        // entonces usamos esta forma
        // Con Factory, getViewModelStore()
/*
        dashboardViewModel = new ViewModelProvider(getViewModelStore(), factory)
                .get(DashboardViewModel.class);
*/

        //dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        TextView textFromHome = root.findViewById(R.id.text_from_home);

        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
                LiveData<String> strHome = homeViewModel.getText();
                textFromHome.setText(strHome.getValue() + " shared content");
            }
        });
        return root;
    }
}
