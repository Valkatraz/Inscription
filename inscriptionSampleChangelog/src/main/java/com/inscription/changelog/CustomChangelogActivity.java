package com.inscription.changelog;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.inscription.ChangeLogHTMLDialog;

public class CustomChangelogActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_changelog);
		
		final ChangeLogHTMLDialog changeLog = new ChangeLogHTMLDialog(this);
		final WebView webView = (WebView) findViewById(R.id.webView1);
		webView.loadDataWithBaseURL(null, changeLog.getHTML(), "text/html", "utf-8", null);
	}
}
