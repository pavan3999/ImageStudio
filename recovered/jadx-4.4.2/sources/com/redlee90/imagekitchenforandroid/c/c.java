package com.redlee90.imagekitchenforandroid.c;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.redlee90.imagekitchenforandroid.MainActivity;
import com.redlee90.imagekitchenforandroid.R;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c extends androidx.fragment.app.c {
    private static final String p0 = Environment.getExternalStorageDirectory().getAbsolutePath();
    private File l0;
    private List<File> m0;
    private Map<File, Boolean> n0;
    private Comparator<File> o0 = new a(this);

    class a implements Comparator<File> {
        a(c cVar) {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return file.getName().toLowerCase().compareTo(file2.getName().toLowerCase());
        }
    }

    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            c.this.o1();
        }
    }

    /* JADX INFO: renamed from: com.redlee90.imagekitchenforandroid.c.c$c, reason: collision with other inner class name */
    class DialogInterfaceOnClickListenerC0037c implements DialogInterface.OnClickListener {
        final /* synthetic */ File b;

        DialogInterfaceOnClickListenerC0037c(File file) {
            this.b = file;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ArrayList arrayList = new ArrayList();
            for (File file : c.this.m0) {
                if (((Boolean) c.this.n0.get(file)).booleanValue()) {
                    arrayList.add(file);
                }
            }
            ((MainActivity) c.this.i()).i0(this.b, arrayList);
        }
    }

    public class d extends RecyclerView.g<C0038c> {
        private File c;

        class a implements View.OnClickListener {
            final /* synthetic */ File b;

            a(File file) {
                this.b = file;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.b.isDirectory()) {
                    d.this.x(this.b);
                }
            }
        }

        class b implements CompoundButton.OnCheckedChangeListener {
            final /* synthetic */ File a;

            b(File file) {
                this.a = file;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                c.this.n0.put(this.a, Boolean.valueOf(z));
            }
        }

        /* JADX INFO: renamed from: com.redlee90.imagekitchenforandroid.c.c$d$c, reason: collision with other inner class name */
        class C0038c extends RecyclerView.d0 {
            View t;

            C0038c(d dVar, View view) {
                super(view);
                this.t = view;
            }
        }

        private d() {
            this.c = new File(c.p0);
            Collections.addAll(c.this.m0, this.c.listFiles());
            Collections.sort(c.this.m0, c.this.o0);
            try {
                if (!this.c.getCanonicalPath().equals(c.this.l0.getCanonicalPath())) {
                    c.this.m0.add(0, this.c.getParentFile());
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            Iterator it = c.this.m0.iterator();
            while (it.hasNext()) {
                c.this.n0.put((File) it.next(), Boolean.FALSE);
            }
        }

        /* synthetic */ d(c cVar, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x(File file) {
            this.c = file;
            c.this.m0.clear();
            c.this.n0.clear();
            Collections.addAll(c.this.m0, this.c.listFiles());
            Collections.sort(c.this.m0, c.this.o0);
            try {
                if (!this.c.getCanonicalPath().equals(c.this.l0.getCanonicalPath())) {
                    c.this.m0.add(0, this.c.getParentFile());
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            Iterator it = c.this.m0.iterator();
            while (it.hasNext()) {
                c.this.n0.put((File) it.next(), Boolean.FALSE);
            }
            h();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public int c() {
            return c.this.m0.size();
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0090 A[Catch: IOException -> 0x0095, TRY_LEAVE, TryCatch #0 {IOException -> 0x0095, blocks: (B:8:0x0070, B:10:0x0086, B:11:0x0090), top: B:18:0x0070 }] */
        @Override // androidx.recyclerview.widget.RecyclerView.g
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public void j(C0038c c0038c, int i) {
            Resources resources;
            int i2;
            File file = (File) c.this.m0.get(i);
            c0038c.t.setOnClickListener(new a(file));
            ImageView imageView = (ImageView) c0038c.t.findViewById(R.id.iv_importdialog_icon);
            TextView textView = (TextView) c0038c.t.findViewById(R.id.tv_importdialog_filename);
            CheckBox checkBox = (CheckBox) c0038c.t.findViewById(R.id.checkbox_importdialog);
            if (file.isDirectory()) {
                resources = c.this.i().getResources();
                i2 = R.drawable.ic_folder_black_48dp;
            } else {
                resources = c.this.i().getResources();
                i2 = R.drawable.ic_insert_drive_file_black_48dp;
            }
            imageView.setImageDrawable(resources.getDrawable(i2));
            checkBox.setOnCheckedChangeListener(new b(file));
            textView.setText(file.getName());
            if (i == 0) {
                try {
                    if (this.c.getCanonicalPath().equals(c.this.l0.getCanonicalPath())) {
                        checkBox.setVisibility(0);
                    } else {
                        textView.setText("..");
                        checkBox.setVisibility(4);
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } else {
                checkBox.setVisibility(0);
            }
            checkBox.setChecked(((Boolean) c.this.n0.get(file)).booleanValue());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
        public C0038c l(ViewGroup viewGroup, int i) {
            return new C0038c(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_importdialog, viewGroup, false));
        }
    }

    public static c B1(String str) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putString("workingDir", str);
        cVar.f1(bundle);
        return cVar;
    }

    @Override // androidx.fragment.app.c
    public Dialog s1(Bundle bundle) {
        androidx.appcompat.app.b.a aVar = new androidx.appcompat.app.b.a(i());
        aVar.m("Select files to import");
        View viewInflate = i().getLayoutInflater().inflate(R.layout.dialog_import, (ViewGroup) null);
        aVar.n(viewInflate);
        this.l0 = new File(p0);
        this.m0 = new ArrayList();
        this.n0 = new HashMap();
        File file = new File(n().getString("workingDir", null));
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.list_import);
        recyclerView.setLayoutManager(new LinearLayoutManager(i()));
        recyclerView.setAdapter(new d(this, null));
        aVar.g(android.R.string.cancel, new b());
        aVar.j(android.R.string.ok, new DialogInterfaceOnClickListenerC0037c(file));
        return aVar.a();
    }
}
