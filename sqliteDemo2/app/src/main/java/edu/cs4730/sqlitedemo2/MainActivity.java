package edu.cs4730.sqlitedemo2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
	String TAG = "MainActivity";

	SectionsPagerAdapter mSectionsPagerAdapter;
	ViewPager mViewPager;
	
	//database columns
	public static final String KEY_NAME = "Name";
	public static final String KEY_SCORE = "Score";
	public static final String KEY_ROWID = "_id";   //required field for the cursorAdapter
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Create the adapter that will return a fragment for each of the three
		// primary sections of the activity.
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		//mViewPager.setCurrentItem(7);// set to a specific page in the pager.
	}
	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case 0: return new sqlitedemo2Frag();
			case 1: return new loaderDemoFrag();
			default: return null;
			}
		}

		@Override
		public int getCount() {
			// Show X total pages.
			return 2;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
			case 0:
				return "sqlite2 Demo";
			case 1:
				return "loader Demo";
			}
			return null;
		}
	}	


}
