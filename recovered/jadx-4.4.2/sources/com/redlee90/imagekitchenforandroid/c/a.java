package com.redlee90.imagekitchenforandroid.c;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class a extends androidx.fragment.app.c {

    /* JADX INFO: renamed from: com.redlee90.imagekitchenforandroid.c.a$a, reason: collision with other inner class name */
    class DialogInterfaceOnClickListenerC0034a implements DialogInterface.OnClickListener {
        DialogInterfaceOnClickListenerC0034a(a aVar) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    @Override // androidx.fragment.app.c
    public Dialog s1(Bundle bundle) {
        androidx.appcompat.app.b.a aVar = new androidx.appcompat.app.b.a(i());
        TextView textView = new TextView(i());
        textView.setText(Html.fromHtml("Like it? If so, please consider donation to support further development.<br><br><a href='https://play.google.com/store/apps/details?id=com.redlee90.donation1&hl=en'>Donate 0.99USD</a> or <a href='https://play.google.com/store/apps/details?id=com.redlee90.donation2&hl=en'>Donate 1.99USD</a>"));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setClickable(true);
        aVar.n(textView);
        aVar.g(R.string.no, new DialogInterfaceOnClickListenerC0034a(this));
        return aVar.a();
    }
}
