package edu.cs4730.supportprefencedemo;

import android.app.FragmentTransaction;
import android.support.v14.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.PreferenceScreen;
import android.util.Log;

/*
 * This is the activity for the preference fragment.  Note, this activity is not using any other fragments
 * so the PrefFag is v14 instead of v7.  So it's a "real" fragment, so not using the support fragment manager.
 *
 * This now works with multiple preference screens.  This implements a callback to change between preference
 * screens.  Which basically a new fragment sending the correct screen to show (via a "rootkey")
 * Many thanks to the top answer
 * https://stackoverflow.com/questions/32487206/inner-preferencescreen-not-opens-with-preferencefragmentcompat
 * and their github example code at https://github.com/madlymad/PreferenceApp
 */


public class myPreferenceActivity extends AppCompatActivity  implements PreferenceFragment.OnPreferenceStartScreenCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //note, the v14 preference fragment is not a support fragment, so it's not using the supportFragmentManager.
        getFragmentManager().beginTransaction().replace(android.R.id.content,
                new PrefFrag()).commit();
    }
    @Override
    public boolean onPreferenceStartScreen(PreferenceFragment preferenceFragment, PreferenceScreen preferenceScreen) {
        Log.wtf("Hi", "i'm called.");

        //first get the new rootkey (ie, moving to the next screen, so which one if more then one.
        Bundle args = new Bundle();
        args.putString(PreferenceFragment.ARG_PREFERENCE_ROOT, preferenceScreen.getKey());  //get the new root key
        //now add that to the fragmenet
        PrefFrag fragment = new PrefFrag();
        fragment.setArguments(args);
        //now show the new fragment.
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(android.R.id.content, fragment, preferenceScreen.getKey());
        ft.addToBackStack(preferenceScreen.getKey());
        ft.commit();

        return true;
    }


}
