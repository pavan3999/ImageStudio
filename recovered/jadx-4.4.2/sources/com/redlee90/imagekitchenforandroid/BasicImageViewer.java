package com.redlee90.imagekitchenforandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import androidx.appcompat.app.c;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes.dex */
public class BasicImageViewer extends c {
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.d, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Bitmap bitmapDecodeStream;
        super.onCreate(bundle);
        setContentView(R.layout.activity_basicimageviewer);
        TouchImageView touchImageView = (TouchImageView) findViewById(R.id.imageview);
        try {
            bitmapDecodeStream = BitmapFactory.decodeStream(getContentResolver().openInputStream(getIntent().getData()));
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            bitmapDecodeStream = null;
        }
        touchImageView.setImageBitmap(bitmapDecodeStream);
    }
}
