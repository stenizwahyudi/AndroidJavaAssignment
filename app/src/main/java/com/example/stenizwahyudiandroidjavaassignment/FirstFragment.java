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

public class FirstFragment extends Fragment {

    EditText showEditTextFirst;
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
                             Bundle savedInstanceState) {
        layoutName = ((MainActivity)getActivity()).layoutName[0];
        layoutType = ((MainActivity)getActivity()).layoutType;
        editTextName = ((MainActivity)getActivity()).editTextName[0];
        editTextType = ((MainActivity)getActivity()).editTextType;
        buttonName = ((MainActivity)getActivity()).buttonName[0];
        buttonType = ((MainActivity)getActivity()).buttonType;

        View fragmentFirstLayout = inflater.inflate(getResources().getIdentifier(
                layoutName, layoutType, getActivity().getPackageName()),
                container, false);
        showEditTextFirst = fragmentFirstLayout.findViewById(getResources().getIdentifier(
                editTextName, editTextType, getActivity().getPackageName()));
        return fragmentFirstLayout;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        stringValue = ((MainActivity)getActivity()).stringValue;
        classNames = ((MainActivity)getActivity()).className;
        if (classNames.size() != 0) {
            combined = stringValue;
            for (int i = 0; i < classNames.size(); i++) {
                if (i == 0) {
                    combined = combined + classNames.get(i);
                } else {
                    combined = combined + "," + classNames.get(i);
                }
            }
            showEditTextFirst.setText(combined);
        }

        view.findViewById(getResources().getIdentifier(buttonName, buttonType,
                getActivity().getPackageName())).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringValue = showEditTextFirst.getText().toString();
                name = FirstFragment.class.getSimpleName();
//                showEditTextFirst.setText(stringValue);
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
