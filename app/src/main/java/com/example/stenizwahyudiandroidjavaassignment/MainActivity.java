package com.example.stenizwahyudiandroidjavaassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    String stringValue;
    ArrayList<String> className = new ArrayList<>();
    String[] classpath = {"","",""};
    String[] layoutName = {"","",""};
    String[] editTextName = {"","",""};
    String[] buttonName = {"","",""};
    String layoutType;
    String editTextType;
    String buttonType;
    String animEnter;
    String animPopEnter;
    String animExit;
    String animPopExit;
    String animType;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            jsonProcessor("FirstFragment.json");
            jsonProcessor("SecondFragment.json");
            jsonProcessor("ThirdFragment.json");
            addDefaultFragment();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void jsonProcessor(String filename) throws JSONException {
        String json;
        try {
            InputStream is = this.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }
        JSONObject obj = new JSONObject(json);
        classpath[index] = obj.get("classpath").toString();
        layoutName[index] = obj.get("layoutName").toString();
        editTextName[index] = obj.get("editTextName").toString();
        buttonName[index] = obj.get("buttonName").toString();
        index ++;
        if (layoutType == null) {
            layoutType = obj.get("layoutType").toString();
        }
        if (editTextType == null) {
            editTextType = obj.get("editTextType").toString();
        }
        if (buttonType == null) {
            buttonType = obj.get("buttonType").toString();
        }
        if (animEnter == null) {
            animEnter = obj.get("animEnter").toString();
        }
        if (animPopEnter == null) {
            animPopEnter = obj.get("animPopEnter").toString();
        }
        if (animExit == null) {
            animExit = obj.get("animExit").toString();
        }
        if (animPopExit == null) {
            animPopExit = obj.get("animPopExit").toString();
        }
        if (animType == null) {
            animType = obj.get("animType").toString();
        }
    }

    private void addDefaultFragment() throws ClassNotFoundException, InstantiationException,
            IllegalAccessException {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = (Fragment)(Class.forName(
                classpath[0])).newInstance();
        fragmentTransaction.add(R.id.fragmentContainer, fragment, "fragment");
        fragmentTransaction.commit();
    }

    public void addFragment() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Fragment fragment;

        fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
        if (fragment instanceof FirstFragment) {
            fragment = (Fragment)(Class.forName(
                    classpath[1])).newInstance();
        } else if (fragment instanceof SecondFragment){
            fragment = (Fragment)(Class.forName(
                    classpath[2])).newInstance();
        } else if (fragment instanceof ThirdFragment) {
            fragment = (Fragment)(Class.forName(
                    classpath[0])).newInstance();
        } else {
            fragment = (Fragment)(Class.forName(
                    classpath[0])).newInstance();
        }

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                getResources().getIdentifier(animEnter, animType, getPackageName()),
                getResources().getIdentifier(animExit, animType, getPackageName()),
                getResources().getIdentifier(animPopEnter, animType, getPackageName()),
                getResources().getIdentifier(animPopExit, animType, getPackageName()));
        fragmentTransaction.replace(R.id.fragmentContainer,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void textProcessor(String stringValue, String name) {
        this.stringValue = stringValue;
        if (className != null) {
            className.add(name);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        className.remove(className.size() - 1);
    }
}