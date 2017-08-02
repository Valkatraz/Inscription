package com.inscription.samples.whatsnewdialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.inscription.WhatsNewHTMLDialog;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Launch what's new dialog (will only be shown once)
        final WhatsNewHTMLDialog whatsNewDialog = new WhatsNewHTMLDialog(this);
        whatsNewDialog.show();
    }

    public void onShowChangeLogClick(final View v) {
        //Launch what's new dialog
        final WhatsNewHTMLDialog whatsNewDialog = new WhatsNewHTMLDialog(this);
        whatsNewDialog.forceShow();
    }

    public void onCustomStyleClick(final View v) {
        //Launch what's new dialog
        final WhatsNewHTMLDialog whatsNewDialog = new WhatsNewHTMLDialog(this);
        whatsNewDialog.setStyle("h1 { margin-left: 10px; font-size: 12pt; color: #006b9a; margin-bottom: 0px;}"
                + "li { margin-left: 0px; font-size: 12pt; padding-top: 10px; }"
                + "ul { padding-left: 30px; margin-top: 0px; }");
        whatsNewDialog.forceShow();
    }
}
