package com.redlee90.imagekitchenforandroid;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import androidx.appcompat.app.c;
import com.google.android.material.snackbar.Snackbar;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class BasicFileEditor extends c {
    private EditText t;
    private Uri u;
    private ProgressDialog v;

    class a extends Thread {

        /* JADX INFO: renamed from: com.redlee90.imagekitchenforandroid.BasicFileEditor$a$a, reason: collision with other inner class name */
        class RunnableC0031a implements Runnable {
            final /* synthetic */ StringBuilder b;

            RunnableC0031a(StringBuilder sb) {
                this.b = sb;
            }

            @Override // java.lang.Runnable
            public void run() {
                BasicFileEditor.this.t.setText(this.b.toString().trim());
                if (BasicFileEditor.this.v == null || !BasicFileEditor.this.v.isShowing()) {
                    return;
                }
                BasicFileEditor.this.v.dismiss();
            }
        }

        a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(BasicFileEditor.this.getContentResolver().openInputStream(BasicFileEditor.this.u)));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        bufferedReader.close();
                        new Handler(Looper.getMainLooper()).post(new RunnableC0031a(sb));
                        return;
                    } else {
                        sb.append(line);
                        sb.append("\n");
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                if (BasicFileEditor.this.v == null || !BasicFileEditor.this.v.isShowing()) {
                    return;
                }
                BasicFileEditor.this.v.dismiss();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.d, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_basicfileeditor);
        this.t = (EditText) findViewById(R.id.edittext_basicfileeditor);
        this.u = getIntent().getData();
        this.v = ProgressDialog.show(this, "", "loading...");
        new a().start();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_basicfileeditor, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_exit) {
            finish();
            return true;
        }
        if (itemId != R.id.action_save) {
            return true;
        }
        try {
            PrintWriter printWriter = new PrintWriter(getContentResolver().openOutputStream(this.u));
            printWriter.print(this.t.getText());
            printWriter.close();
            Snackbar.X(findViewById(R.id.layout_basicfileeditor), "Saved successfully!", -1).N();
        } catch (FileNotFoundException unused) {
            Snackbar.X(findViewById(R.id.layout_basicfileeditor), "File not found!", -1).N();
        }
        return true;
    }
}
