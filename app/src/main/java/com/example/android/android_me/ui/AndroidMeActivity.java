/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.android_me.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    // TODO (1) Create a layout file that displays one body part image named fragment_body_part.xml
    // This layout should contain a single ImageView
    private static final String TAG = "AndroidMeActivity";
    // TODO (2) Create a new class called BodyPartFragment to display an image of an Android-Me body part
    // In this class, you'll need to implement an empty constructor and the onCreateView method
    // TODO (3) Show the first image in the list of head images
    // Soon, you'll update this image display code to show any image you want

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        Log.d(TAG, "OnCreate... "+getIntent());

        /*Toast.makeText(this, "OnCreate.. head"+getIntent().getIntExtra("head", 0)
                +"body: "+getIntent().getIntExtra("body", 0)
                +"leg: "+getIntent().getIntExtra("leg", 0)
                +"\n"+getIntent(), Toast.LENGTH_SHORT).show();*/

        if(savedInstanceState == null) {
            BodyPartFragment headFragment = new BodyPartFragment();
            BodyPartFragment bodyFragment = new BodyPartFragment();
            BodyPartFragment legsFragment = new BodyPartFragment();

            headFragment.setImageList(AndroidImageAssets.getHeads());
            headFragment.setImageIndex(getIntent().getIntExtra("head", 0));
            FragmentManager fragmentManager = getSupportFragmentManager();

            Log.d(TAG, "fragment? " + headFragment.isAdded());

            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container_head, headFragment)
                    .commit();

            bodyFragment.setImageList(AndroidImageAssets.getBodies());
            bodyFragment.setImageIndex(getIntent().getIntExtra("body", 0));
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container_body, bodyFragment)
                    .commit();

            legsFragment.setImageList(AndroidImageAssets.getLegs());
            legsFragment.setImageIndex(getIntent().getIntExtra("leg", 0));
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container_legs, legsFragment)
                    .commit();
        }
    }
}
