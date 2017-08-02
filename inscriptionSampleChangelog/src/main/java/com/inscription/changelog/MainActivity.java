package com.inscription.changelog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.inscription.ChangeLogHTMLDialog;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void onShowChangeLogClick(final View v) {
		//Launch change log dialog
		final ChangeLogHTMLDialog changeLogHTMLDialog = new ChangeLogHTMLDialog(this);
		changeLogHTMLDialog.show();
	}

	public void onCustomStyleClick(final View v) {
		//Launch change log dialog
		final ChangeLogHTMLDialog changeLogHTMLDialog = new ChangeLogHTMLDialog(this);
		changeLogHTMLDialog.setStyle("h1 { margin-left: 10px; font-size: 12pt; color: #006b9a; margin-bottom: 0px;}"
                + "li { margin-left: 0px; font-size: 12pt; padding-top: 10px; }"
                + "ul { padding-left: 30px; margin-top: 0px; }"
                + ".summary { margin-left: 10px; font-size: 10pt; color: #006b9a; margin-top: 5px; display: block; clear: left; }"
                + ".date { margin-left: 10px; font-size: 10pt; color: #006b9a; margin-top: 5px; display: block; }");
		changeLogHTMLDialog.show();
	}	
	
	public void onShowChangeLogActivityClick(final View v) {
		//Launch custom changelog activity
		final Intent intent = new Intent(this, CustomChangelogActivity.class);
		startActivity(intent);
	}	
	
}
