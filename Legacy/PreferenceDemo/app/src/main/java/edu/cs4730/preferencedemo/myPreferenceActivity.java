package edu.cs4730.preferencedemo;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.util.Log;

/*
 * this is the simplest version, it just shows the preference screen.
 *   If figures out when version and either ruse the add or shows fragment.
 */


@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class myPreferenceActivity extends PreferenceActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            addPreferencesFromResource(R.xml.preferences);
        } else {
            Log.d("pref", "api13+");
            getFragmentManager().beginTransaction().replace(android.R.id.content,
                    new PrefFrag()).commit();
        }
    }
}
