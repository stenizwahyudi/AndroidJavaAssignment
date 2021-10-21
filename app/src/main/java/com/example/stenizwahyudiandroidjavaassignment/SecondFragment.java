package com.example.stenizwahyudiandroidjavaassignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public class SecondFragment extends Fragment {

    EditText showEditTextSecond;
    String stringValue;
    ArrayList<String> classNames;
    String name;
    String layoutName;
    String layoutType;
    String editTextName;
    String editTextType;
    String buttonName;
    String buttonType;
    String combined;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        layoutName = ((MainActivity)getActivity()).layoutName[1];
        layoutType = ((MainActivity)getActivity()).layoutType;
        editTextName = ((MainActivity)getActivity()).editTextName[1];
        editTextType = ((MainActivity)getActivity()).editTextType;
        buttonName = ((MainActivity)getActivity()).buttonName[1];
        buttonType = ((MainActivity)getActivity()).buttonType;

        View fragmentSecondLayout = inflater.inflate(getResources().getIdentifier(layoutName,
                layoutType, getActivity().getPackageName()), container, false);
        showEditTextSecond = fragmentSecondLayout.findViewById(getResources().getIdentifier(
                editTextName, editTextType, getActivity().getPackageName()));

        return fragmentSecondLayout;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        stringValue = ((MainActivity)getActivity()).stringValue;
        classNames = ((MainActivity)getActivity()).className;
        combined = stringValue;
        for (int i = 0; i < classNames.size(); i++) {
            if (i == 0) {
                combined = combined + classNames.get(i);
            } else {
                combined = combined + "," + classNames.get(i);
            }
        }

        showEditTextSecond.setText(combined);

        view.findViewById(getResources().getIdentifier(buttonName, buttonType,
                getActivity().getPackageName())).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringValue = showEditTextSecond.getText().toString();
                name = SecondFragment.class.getSimpleName();
//                showEditTextSecond.setText(stringValue);
                ((MainActivity)getActivity()).textProcessor(stringValue, name);
                
                try {
                    ((MainActivity)getActivity()).addFragment();
                } catch (ClassNotFoundException | IllegalAccessException |
                        java.lang.InstantiationException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
