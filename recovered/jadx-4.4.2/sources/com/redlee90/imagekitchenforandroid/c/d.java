package com.redlee90.imagekitchenforandroid.c;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d extends androidx.fragment.app.c {
    private static final String n0 = Environment.getExternalStorageDirectory().getAbsolutePath();
    private File l0;
    private Comparator<File> m0 = new a(this);

    class a implements Comparator<File> {
        a(d dVar) {
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
            d.this.o1();
        }
    }

    public class c extends RecyclerView.g<b> {
        private File c = new File(d.n0);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List<File> f684d;

        class a implements View.OnClickListener {
            final /* synthetic */ File b;

            a(File file) {
                this.b = file;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.b.isDirectory()) {
                    c.this.x(this.b);
                } else {
                    ((MainActivity) d.this.i()).w0(this.b);
                    d.this.o1();
                }
            }
        }

        class b extends RecyclerView.d0 {
            View t;

            b(c cVar, View view) {
                super(view);
                this.t = view;
            }
        }

        c() {
            ArrayList arrayList = new ArrayList();
            this.f684d = arrayList;
            Collections.addAll(arrayList, this.c.listFiles());
            Collections.sort(this.f684d, d.this.m0);
            try {
                if (this.c.getCanonicalPath().equals(d.this.l0.getCanonicalPath())) {
                    return;
                }
                this.f684d.add(0, this.c.getParentFile());
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x(File file) {
            this.c = file;
            this.f684d.clear();
            Collections.addAll(this.f684d, this.c.listFiles());
            Collections.sort(this.f684d, d.this.m0);
            try {
                if (!this.c.getCanonicalPath().equals(d.this.l0.getCanonicalPath())) {
                    this.f684d.add(0, this.c.getParentFile());
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            h();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public int c() {
            return this.f684d.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public void j(b bVar, int i) {
            Resources resources;
            int i2;
            File file = this.f684d.get(i);
            bVar.t.setOnClickListener(new a(file));
            ImageView imageView = (ImageView) bVar.t.findViewById(R.id.iv_exportdialog_icon);
            TextView textView = (TextView) bVar.t.findViewById(R.id.tv_exportdialog_filename);
            if (file.isDirectory()) {
                resources = d.this.i().getResources();
                i2 = R.drawable.ic_folder_black_48dp;
            } else {
                resources = d.this.i().getResources();
                i2 = R.drawable.ic_insert_drive_file_black_48dp;
            }
            imageView.setImageDrawable(resources.getDrawable(i2));
            textView.setText(file.getName());
            if (i == 0) {
                try {
                    if (this.c.getCanonicalPath().equals(d.this.l0.getCanonicalPath())) {
                        return;
                    }
                    textView.setText("..");
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
        public b l(ViewGroup viewGroup, int i) {
            return new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_exportdialog, viewGroup, false));
        }
    }

    public static d z1() {
        return new d();
    }

    @Override // androidx.fragment.app.c
    public Dialog s1(Bundle bundle) {
        androidx.appcompat.app.b.a aVar = new androidx.appcompat.app.b.a(i());
        aVar.m("Select an image");
        View viewInflate = i().getLayoutInflater().inflate(R.layout.dialog_export, (ViewGroup) null);
        aVar.n(viewInflate);
        this.l0 = new File(n0);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.list_export);
        recyclerView.setLayoutManager(new LinearLayoutManager(i()));
        recyclerView.setAdapter(new c());
        aVar.g(android.R.string.cancel, new b());
        return aVar.a();
    }
}
