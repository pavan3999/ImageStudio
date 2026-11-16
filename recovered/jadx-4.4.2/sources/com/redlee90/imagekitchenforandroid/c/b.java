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
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b extends androidx.fragment.app.c {
    private static final String o0 = Environment.getExternalStorageDirectory().getAbsolutePath();
    private File l0;
    private File m0;
    private Comparator<File> n0 = new a(this);

    class a implements Comparator<File> {
        a(b bVar) {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return file.getName().toLowerCase().compareTo(file2.getName().toLowerCase());
        }
    }

    /* JADX INFO: renamed from: com.redlee90.imagekitchenforandroid.c.b$b, reason: collision with other inner class name */
    class DialogInterfaceOnClickListenerC0035b implements DialogInterface.OnClickListener {
        DialogInterfaceOnClickListenerC0035b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            b.this.o1();
        }
    }

    class c implements DialogInterface.OnClickListener {
        final /* synthetic */ File b;

        c(File file) {
            this.b = file;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ((MainActivity) b.this.i()).h0(this.b, b.this.m0);
        }
    }

    public class d extends RecyclerView.g<C0036b> {
        private List<File> c;

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

        /* JADX INFO: renamed from: com.redlee90.imagekitchenforandroid.c.b$d$b, reason: collision with other inner class name */
        class C0036b extends RecyclerView.d0 {
            View t;

            C0036b(d dVar, View view) {
                super(view);
                this.t = view;
            }
        }

        d() {
            ArrayList arrayList = new ArrayList(Arrays.asList(b.this.m0.listFiles()));
            this.c = arrayList;
            Collections.sort(arrayList, b.this.n0);
            try {
                if (b.this.m0.getCanonicalPath().equals(b.this.l0.getCanonicalPath())) {
                    return;
                }
                this.c.add(0, b.this.m0.getParentFile());
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x(File file) {
            b.this.m0 = file;
            this.c.clear();
            Collections.addAll(this.c, b.this.m0.listFiles());
            Collections.sort(this.c, b.this.n0);
            try {
                if (!b.this.m0.getCanonicalPath().equals(b.this.l0.getCanonicalPath())) {
                    this.c.add(0, b.this.m0.getParentFile());
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            h();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public int c() {
            return this.c.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public void j(C0036b c0036b, int i) {
            Resources resources;
            int i2;
            File file = this.c.get(i);
            c0036b.t.setOnClickListener(new a(file));
            ImageView imageView = (ImageView) c0036b.t.findViewById(R.id.iv_exportdialog_icon);
            TextView textView = (TextView) c0036b.t.findViewById(R.id.tv_exportdialog_filename);
            if (file.isDirectory()) {
                resources = b.this.i().getResources();
                i2 = R.drawable.ic_folder_black_48dp;
            } else {
                resources = b.this.i().getResources();
                i2 = R.drawable.ic_insert_drive_file_black_48dp;
            }
            imageView.setImageDrawable(resources.getDrawable(i2));
            textView.setText(file.getName());
            if (i == 0) {
                try {
                    if (b.this.m0.getCanonicalPath().equals(b.this.l0.getCanonicalPath())) {
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
        public C0036b l(ViewGroup viewGroup, int i) {
            return new C0036b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_exportdialog, viewGroup, false));
        }
    }

    public static b A1(String str) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("sourceDirStr", str);
        bVar.f1(bundle);
        return bVar;
    }

    @Override // androidx.fragment.app.c
    public Dialog s1(Bundle bundle) {
        androidx.appcompat.app.b.a aVar = new androidx.appcompat.app.b.a(i());
        aVar.m("Export to directory");
        View viewInflate = i().getLayoutInflater().inflate(R.layout.dialog_export, (ViewGroup) null);
        aVar.n(viewInflate);
        this.l0 = new File(o0);
        this.m0 = new File(o0);
        File file = new File(n().getString("sourceDirStr", null));
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.list_export);
        recyclerView.setLayoutManager(new LinearLayoutManager(i()));
        recyclerView.setAdapter(new d());
        aVar.g(android.R.string.cancel, new DialogInterfaceOnClickListenerC0035b());
        aVar.j(android.R.string.ok, new c(file));
        return aVar.a();
    }
}
