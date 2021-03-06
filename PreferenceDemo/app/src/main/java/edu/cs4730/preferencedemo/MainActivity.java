package edu.cs4730.preferencedemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/*
 *  Note this example does not use any of the support library, except the AppCompateActivity
 *  If you need to support API 15 and below (like 2.3.3) and don't wasnt to use the support preference library see the legacy.
 *  This example assume basically everything is API 16+
 *
 *  So even the fragments are NOT support fragments.
 *
 */
public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener {
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getFragmentManager();
        //setup the mainFragment to show.
        fragmentManager.beginTransaction().replace(R.id.container, new MainFragment()).commit();

    }

    /*
 * This the callback interface for MainFragment.
 */
    @Override
    public void onFragmentInteraction(int which) {

        //now change to the SecondFragment, pressing the back button should go to main fragment.
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //Change to the correct fragment for perferences
        if (which == 1)
            transaction.replace(R.id.container, new myPreferenceFragment());
        else
            transaction.replace(R.id.container, new PreferenceupdateFragment());
        // and add the transaction to the back stack so the user can navigate back
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();

    }
}
