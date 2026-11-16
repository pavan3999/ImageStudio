package com.google.android.material.textfield;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import e.a.a.a.i;

/* JADX INFO: loaded from: classes.dex */
class h extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextWatcher f665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextInputLayout.f f666e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextInputLayout.g f667f;

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            h hVar = h.this;
            hVar.c.setChecked(!hVar.f());
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    class b implements TextInputLayout.f {
        b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            h hVar = h.this;
            hVar.c.setChecked(!hVar.f());
            editText.removeTextChangedListener(h.this.f665d);
            editText.addTextChangedListener(h.this.f665d);
        }
    }

    class c implements TextInputLayout.g {
        c(h hVar) {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i != 1) {
                return;
            }
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditText editText = h.this.a.getEditText();
            if (editText == null) {
                return;
            }
            int selectionEnd = editText.getSelectionEnd();
            editText.setTransformationMethod(h.this.f() ? null : PasswordTransformationMethod.getInstance());
            if (selectionEnd >= 0) {
                editText.setSelection(selectionEnd);
            }
        }
    }

    h(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f665d = new a();
        this.f666e = new b();
        this.f667f = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        EditText editText = this.a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        this.a.setEndIconDrawable(d.a.k.a.a.d(this.b, e.a.a.a.e.design_password_eye));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(i.password_toggle_content_description));
        this.a.setEndIconOnClickListener(new d());
        this.a.c(this.f666e);
        this.a.d(this.f667f);
    }
}
