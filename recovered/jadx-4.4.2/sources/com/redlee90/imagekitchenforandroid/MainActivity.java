package com.redlee90.imagekitchenforandroid;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import com.github.clans.fab.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends androidx.appcompat.app.c {
    private static final String K = MainActivity.class.getSimpleName();
    private static int L;
    private com.redlee90.imagekitchenforandroid.b.a C;
    private LinearLayout D;
    private FloatingActionButton E;
    private FloatingActionButton F;
    private FloatingActionButton G;
    private int H;
    private ProgressDialog I;
    private SharedPreferences J;
    private File u;
    private String v;
    private ListView w;
    private s x;
    private File y;
    private boolean t = false;
    private List<File> z = new ArrayList();
    private HashMap<String, String> A = new HashMap<>();
    private HashMap<String, String> B = new HashMap<>();

    class a extends Thread {
        final /* synthetic */ File b;

        /* JADX INFO: renamed from: com.redlee90.imagekitchenforandroid.MainActivity$a$a, reason: collision with other inner class name */
        class C0032a extends e.b.a.c.a {
            C0032a(int i, String... strArr) {
                super(i, strArr);
            }

            @Override // e.b.a.c.a
            public void a(int i, int i2) throws Throwable {
                s sVar = MainActivity.this.x;
                if (i2 == 0) {
                    sVar.sendEmptyMessage(16);
                    a aVar = a.this;
                    MainActivity.this.k0(aVar.b);
                } else {
                    sVar.sendEmptyMessage(13);
                }
                super.a(i, i2);
            }

            @Override // e.b.a.c.a
            public void c(int i, String str) {
                super.c(i, str);
            }
        }

        a(File file) {
            this.b = file;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws Throwable {
            if (!MainActivity.this.t) {
                MainActivity.this.k0(this.b);
                return;
            }
            MainActivity.this.x.sendEmptyMessage(21);
            try {
                e.b.a.a.a(true).w(new C0032a(100, "losetup -d /dev/block/loop1", "umount " + MainActivity.this.u.getCanonicalPath()));
            } catch (e.b.a.b.a | IOException | TimeoutException e2) {
                MainActivity.this.x.sendMessage(MainActivity.this.e0(13, e2.getLocalizedMessage()));
            }
        }
    }

    class b extends e.b.a.c.a {
        StringBuilder o;

        b(int i, String... strArr) {
            super(i, strArr);
            this.o = new StringBuilder();
        }

        @Override // e.b.a.c.a
        public void a(int i, int i2) {
            s sVar = MainActivity.this.x;
            if (i2 == 0) {
                sVar.sendEmptyMessage(1);
            } else {
                sVar.sendMessage(MainActivity.this.e0(4, this.o.toString()));
            }
            super.a(i, i2);
        }

        @Override // e.b.a.c.a
        public void c(int i, String str) {
            if (i == 101) {
                this.o.append(str);
                this.o.append("\n");
            }
            super.c(i, str);
        }
    }

    class c extends e.b.a.c.a {
        final /* synthetic */ File o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i, int i2, String[] strArr, File file) {
            super(i, i2, strArr);
            this.o = file;
        }

        @Override // e.b.a.c.a
        public void a(int i, int i2) {
            s sVar = MainActivity.this.x;
            if (i2 == 0) {
                sVar.sendEmptyMessage(25);
                MainActivity.this.j0(this.o);
            } else {
                sVar.sendEmptyMessage(24);
            }
            super.a(i, i2);
        }

        @Override // e.b.a.c.a
        public void c(int i, String str) {
            super.c(i, str);
        }
    }

    class d extends e.b.a.c.a {
        d(int i, String... strArr) {
            super(i, strArr);
        }

        @Override // e.b.a.c.a
        public void a(int i, int i2) {
            MainActivity.this.x.sendEmptyMessage(i2 == 0 ? 14 : 15);
            super.a(i, i2);
        }

        @Override // e.b.a.c.a
        public void c(int i, String str) {
            super.c(i, str);
        }
    }

    class e extends e.b.a.c.a {
        e(int i, boolean z, String... strArr) {
            super(i, z, strArr);
        }

        @Override // e.b.a.c.a
        public void a(int i, int i2) {
            if (i == 105 && i2 == 0) {
                MainActivity.this.x.post(new Runnable() { // from class: com.redlee90.imagekitchenforandroid.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.b.n();
                    }
                });
            }
            super.a(i, i2);
        }

        @Override // e.b.a.c.a
        public void c(int i, String str) {
            String[] strArrSplit = str.split(" ");
            if (strArrSplit.length == 2) {
                MainActivity.this.A.put(strArrSplit[1], strArrSplit[0]);
            } else if (strArrSplit.length == 3) {
                MainActivity.this.A.put(strArrSplit[1], strArrSplit[0]);
                MainActivity.this.B.put(strArrSplit[1], strArrSplit[2]);
            }
            super.c(i, str);
        }

        public /* synthetic */ void n() {
            MainActivity mainActivity;
            String strReplace;
            try {
                if (MainActivity.this.y.getCanonicalPath().equals(MainActivity.this.u.getCanonicalPath())) {
                    mainActivity = MainActivity.this;
                    strReplace = MainActivity.this.getString(R.string.app_name);
                } else {
                    mainActivity = MainActivity.this;
                    strReplace = MainActivity.this.y.getCanonicalPath().replace(MainActivity.this.getFilesDir().getCanonicalPath() + "/data", "");
                }
                mainActivity.setTitle(strReplace);
            } catch (IOException e2) {
                e2.printStackTrace();
                MainActivity mainActivity2 = MainActivity.this;
                mainActivity2.setTitle(mainActivity2.getString(R.string.app_name));
            }
            MainActivity.this.C.notifyDataSetChanged();
            try {
                if (MainActivity.this.y.getCanonicalPath().equals(MainActivity.this.u.getCanonicalPath())) {
                    if (MainActivity.this.z.size() == 0) {
                        MainActivity.this.D.setVisibility(0);
                        MainActivity.this.w.setVisibility(8);
                    } else {
                        MainActivity.this.D.setVisibility(8);
                        MainActivity.this.w.setVisibility(0);
                    }
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    class f implements f.a.e<File> {
        final /* synthetic */ File a;
        final /* synthetic */ File b;

        f(MainActivity mainActivity, File file, File file2) {
            this.a = file;
            this.b = file2;
        }

        @Override // f.a.e
        public void a(f.a.d<File> dVar) throws IOException {
            if (this.a.isDirectory()) {
                g.a.a.a.b.f(this.a, this.b);
            } else {
                g.a.a.a.b.i(this.a, this.b);
            }
            dVar.b(this.a);
            if (this.a.isDirectory()) {
                g.a.a.a.b.f(this.a, this.b);
            } else {
                g.a.a.a.b.i(this.a, this.b);
            }
            dVar.b(this.a);
            dVar.a();
        }
    }

    class g implements f.a.g<File> {
        g() {
        }

        @Override // f.a.g
        public void a() {
            MainActivity.this.f0();
            MainActivity.this.q0();
        }

        @Override // f.a.g
        public void c(Throwable th) {
            MainActivity.this.f0();
            MainActivity.this.p0(th.getLocalizedMessage());
        }

        @Override // f.a.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(File file) {
        }

        @Override // f.a.g
        public void f(f.a.j.b bVar) {
        }
    }

    class h implements f.a.e<File> {
        final /* synthetic */ List a;
        final /* synthetic */ File b;

        h(MainActivity mainActivity, List list, File file) {
            this.a = list;
            this.b = file;
        }

        @Override // f.a.e
        public void a(f.a.d<File> dVar) throws IOException {
            for (File file : this.a) {
                if (file.isDirectory()) {
                    g.a.a.a.b.f(file, this.b);
                } else {
                    g.a.a.a.b.i(file, this.b);
                }
                dVar.b(file);
            }
            dVar.a();
        }
    }

    class i implements f.a.g<File> {
        i() {
        }

        @Override // f.a.g
        public void a() {
            MainActivity.this.f0();
            MainActivity.this.s0();
        }

        @Override // f.a.g
        public void c(Throwable th) {
            MainActivity.this.f0();
            MainActivity.this.r0(th.getLocalizedMessage());
        }

        @Override // f.a.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(File file) {
        }

        @Override // f.a.g
        public void f(f.a.j.b bVar) {
        }
    }

    class j implements DialogInterface.OnClickListener {
        final /* synthetic */ AdapterView.AdapterContextMenuInfo b;
        final /* synthetic */ EditText c;

        j(AdapterView.AdapterContextMenuInfo adapterContextMenuInfo, EditText editText) {
            this.b = adapterContextMenuInfo;
            this.c = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            File file = (File) MainActivity.this.z.get(this.b.position);
            String name = file.getName();
            String absolutePath = file.getAbsolutePath();
            try {
                g.a.a.a.b.q(file, new File(absolutePath.substring(0, absolutePath.length() - name.length()) + this.c.getText().toString()));
                MainActivity.this.t0(MainActivity.this.y);
                dialogInterface.dismiss();
            } catch (IOException e2) {
                Toast.makeText(MainActivity.this, e2.getLocalizedMessage(), 0).show();
            }
        }
    }

    class k implements DialogInterface.OnClickListener {
        k(MainActivity mainActivity) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    class l extends e.b.a.c.a {
        l(int i, String... strArr) {
            super(i, strArr);
        }

        @Override // e.b.a.c.a
        public void a(int i, int i2) {
            s sVar;
            int i3;
            if (i == 99 && i2 == 0) {
                MainActivity.this.J.edit().putBoolean("initialized", true).apply();
                sVar = MainActivity.this.x;
                i3 = 26;
            } else {
                sVar = MainActivity.this.x;
                i3 = 27;
            }
            sVar.sendEmptyMessage(i3);
            MainActivity.this.f0();
            super.a(i, i2);
        }

        @Override // e.b.a.c.a
        public void c(int i, String str) {
            Log.d(MainActivity.K, "INITIALIZATION: " + str);
            super.c(i, str);
        }
    }

    class m implements AdapterView.OnItemClickListener {

        class a extends e.b.a.c.a {
            final /* synthetic */ Intent o;
            final /* synthetic */ Uri p;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(int i, String[] strArr, Intent intent, Uri uri) {
                super(i, strArr);
                this.o = intent;
                this.p = uri;
            }

            @Override // e.b.a.c.a
            public void a(int i, int i2) {
                PackageManager packageManager;
                Intent intent;
                int i3;
                super.a(i, i2);
                if (Build.VERSION.SDK_INT >= 23) {
                    packageManager = MainActivity.this.getPackageManager();
                    intent = this.o;
                    i3 = 131072;
                } else {
                    packageManager = MainActivity.this.getPackageManager();
                    intent = this.o;
                    i3 = 65536;
                }
                List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, i3);
                Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
                while (it.hasNext()) {
                    MainActivity.this.grantUriPermission(it.next().activityInfo.packageName, this.p, 3);
                }
                if (listQueryIntentActivities.size() > 0) {
                    MainActivity.this.startActivity(this.o);
                } else {
                    Snackbar.X(MainActivity.this.findViewById(R.id.layout_coordinator), "No application installed can handle this binary file", -1).N();
                }
            }

            @Override // e.b.a.c.a
            public void c(int i, String str) {
                Intent intent;
                Uri uri;
                String str2;
                super.c(i, str);
                if (str.toLowerCase().contains("text")) {
                    this.o.setAction("android.intent.action.EDIT");
                    intent = this.o;
                    uri = this.p;
                    str2 = "text/*";
                } else if (str.toLowerCase().contains("executable")) {
                    this.o.setAction("android.intent.action.EDIT");
                    intent = this.o;
                    uri = this.p;
                    str2 = "application/octet-stream";
                } else {
                    this.o.setAction("android.intent.action.EDIT");
                    intent = this.o;
                    uri = this.p;
                    str2 = "*/*";
                }
                intent.setDataAndType(uri, str2);
            }
        }

        m() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:32:0x0097  */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x015f, code lost:
        
            if (r11.size() > 0) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0190, code lost:
        
            if (r11.size() > 0) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x0198, code lost:
        
            r11 = com.google.android.material.snackbar.Snackbar.X(r10.b.findViewById(com.redlee90.imagekitchenforandroid.R.id.layout_coordinator), "No third party application installed to handle binary file", -1);
         */
        @Override // android.widget.AdapterView.OnItemClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            View viewFindViewById;
            String str;
            Uri uriE;
            byte b;
            File file = (File) MainActivity.this.z.get(i);
            if (file.canRead()) {
                if (!file.isFile()) {
                    MainActivity.this.t0(file);
                    return;
                }
                Intent intent = new Intent();
                try {
                    uriE = FileProvider.e(MainActivity.this, MainActivity.this.getResources().getString(R.string.provider_authority), file);
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                    uriE = null;
                }
                if (uriE == null) {
                    Snackbar.X(MainActivity.this.findViewById(R.id.layout_coordinator), "File is outside the paths supported", -1).N();
                    return;
                }
                switch (MimeTypeMap.getFileExtensionFromUrl(Uri.encode(file.getAbsolutePath()))) {
                    case "apk":
                        b = 4;
                        break;
                    case "bmp":
                        b = 0;
                        break;
                    case "jpg":
                        b = 1;
                        break;
                    case "png":
                        b = 3;
                        break;
                    case "jpeg":
                        b = 2;
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b != 0 && b != 1 && b != 2 && b != 3) {
                    if (b != 4) {
                        try {
                            e.b.a.a.a(false).w(new a(107, new String[]{"file " + file.getCanonicalPath()}, intent, uriE));
                            return;
                        } catch (e.b.a.b.a | IOException | TimeoutException e3) {
                            e3.printStackTrace();
                            intent.setAction("android.intent.action.EDIT");
                            intent.setDataAndType(uriE, "*/*");
                            List<ResolveInfo> listQueryIntentActivities = Build.VERSION.SDK_INT >= 23 ? MainActivity.this.getPackageManager().queryIntentActivities(intent, 131072) : MainActivity.this.getPackageManager().queryIntentActivities(intent, 65536);
                            Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
                            while (it.hasNext()) {
                                MainActivity.this.grantUriPermission(it.next().activityInfo.packageName, uriE, 3);
                            }
                            if (listQueryIntentActivities.size() <= 0) {
                                viewFindViewById = MainActivity.this.findViewById(R.id.layout_coordinator);
                                str = "No application installed can handle this binary file";
                            }
                        }
                    } else {
                        intent.setAction("android.intent.action.VIEW");
                        intent.setDataAndType(uriE, "application/vnd.android.package-archive");
                        List<ResolveInfo> listQueryIntentActivities2 = MainActivity.this.getPackageManager().queryIntentActivities(intent, 65536);
                        Iterator<ResolveInfo> it2 = listQueryIntentActivities2.iterator();
                        while (it2.hasNext()) {
                            MainActivity.this.grantUriPermission(it2.next().activityInfo.packageName, uriE, 3);
                        }
                    }
                    MainActivity.this.startActivity(intent);
                    return;
                }
                intent.setAction("android.intent.action.VIEW");
                intent.setData(uriE);
                List<ResolveInfo> listQueryIntentActivities3 = MainActivity.this.getPackageManager().queryIntentActivities(intent, 65536);
                Iterator<ResolveInfo> it3 = listQueryIntentActivities3.iterator();
                while (it3.hasNext()) {
                    MainActivity.this.grantUriPermission(it3.next().activityInfo.packageName, uriE, 3);
                }
                snackbarX.N();
            }
            viewFindViewById = MainActivity.this.findViewById(R.id.layout_coordinator);
            str = "Permission denied";
            Snackbar snackbarX = Snackbar.X(viewFindViewById, str, -1);
            snackbarX.N();
        }
    }

    class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.redlee90.imagekitchenforandroid.c.d.z1().v1(MainActivity.this.o(), "unpack");
        }
    }

    class o implements View.OnClickListener {

        class a extends Thread {

            /* JADX INFO: renamed from: com.redlee90.imagekitchenforandroid.MainActivity$o$a$a, reason: collision with other inner class name */
            class C0033a extends e.b.a.c.a {
                StringBuilder o;

                C0033a(int i, String... strArr) {
                    super(i, strArr);
                    this.o = new StringBuilder();
                }

                @Override // e.b.a.c.a
                public void a(int i, int i2) {
                    s sVar = MainActivity.this.x;
                    if (i2 == 0) {
                        sVar.sendEmptyMessage(16);
                    } else {
                        sVar.sendMessage(MainActivity.this.e0(13, this.o.toString()));
                    }
                    super.a(i, i2);
                }

                @Override // e.b.a.c.a
                public void c(int i, String str) {
                    if (i == 100) {
                        this.o.append(str);
                    }
                    super.c(i, str);
                }
            }

            class b extends e.b.a.c.a {
                StringBuilder o;

                b(int i, String... strArr) {
                    super(i, strArr);
                    this.o = new StringBuilder();
                }

                @Override // e.b.a.c.a
                public void a(int i, int i2) {
                    s sVar = MainActivity.this.x;
                    if (i2 == 0) {
                        sVar.sendEmptyMessage(2);
                    } else {
                        sVar.sendMessage(MainActivity.this.e0(5, this.o.toString()));
                    }
                    super.a(i, i2);
                }

                @Override // e.b.a.c.a
                public void c(int i, String str) {
                    if (i == 104) {
                        this.o.append(str);
                    }
                    super.c(i, str);
                }
            }

            a() {
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                s sVar;
                MainActivity mainActivity;
                int i;
                if (MainActivity.this.t) {
                    MainActivity.this.x.sendEmptyMessage(21);
                    try {
                        e.b.a.a.a(true).w(new C0033a(100, "losetup -d /dev/block/loop1", "umount " + MainActivity.this.u.getCanonicalPath()));
                        return;
                    } catch (e.b.a.b.a | IOException | TimeoutException e2) {
                        e = e2;
                        sVar = MainActivity.this.x;
                        mainActivity = MainActivity.this;
                        i = 13;
                    }
                } else {
                    MainActivity.this.x.sendEmptyMessage(18);
                    try {
                        e.b.a.a.a(false).w(new b(104, "sh " + MainActivity.this.v + File.separator + "repackimg.sh " + MainActivity.this.v + " " + MainActivity.this.u.getCanonicalPath()));
                        return;
                    } catch (e.b.a.b.a | IOException | TimeoutException e3) {
                        e = e3;
                        sVar = MainActivity.this.x;
                        mainActivity = MainActivity.this;
                        i = 5;
                    }
                }
                sVar.sendMessage(mainActivity.e0(i, e.getLocalizedMessage()));
            }
        }

        o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new a().start();
        }
    }

    class p implements View.OnClickListener {

        class a extends e.b.a.c.a {
            a(int i, String... strArr) {
                super(i, strArr);
            }

            @Override // e.b.a.c.a
            public void a(int i, int i2) {
                MainActivity.this.x.sendEmptyMessage(3);
                super.a(i, i2);
            }

            @Override // e.b.a.c.a
            public void d(int i, String str) {
                MainActivity.this.x.sendEmptyMessage(3);
                super.d(i, str);
            }
        }

        p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.x.sendEmptyMessage(22);
            try {
                e.b.a.a.a(false).w(new a(106, "rm -r " + MainActivity.this.u.getCanonicalPath() + "/*"));
            } catch (e.b.a.b.a | IOException | TimeoutException e2) {
                e2.printStackTrace();
                MainActivity.this.x.sendMessage(MainActivity.this.e0(6, e2.getLocalizedMessage()));
            }
        }
    }

    class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                com.redlee90.imagekitchenforandroid.c.b.A1(MainActivity.this.u.getCanonicalPath() + File.separator + "image-new.img").v1(MainActivity.this.o(), "export-new-image");
            } catch (IOException e2) {
                MainActivity.this.p0(e2.getMessage());
            }
        }
    }

    class r implements View.OnClickListener {
        r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.redlee90.imagekitchenforandroid.c.c cVarB1;
            try {
                cVarB1 = com.redlee90.imagekitchenforandroid.c.c.B1(MainActivity.this.y.getCanonicalPath());
            } catch (IOException e2) {
                e2.printStackTrace();
                cVarB1 = null;
            }
            cVarB1.v1(MainActivity.this.o(), "import");
        }
    }

    static class s extends Handler {
        private WeakReference<MainActivity> a;
        private ProgressDialog b;

        class a implements DialogInterface.OnClickListener {
            a(s sVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }

        class b implements DialogInterface.OnClickListener {
            b(s sVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }

        class c implements DialogInterface.OnClickListener {
            c(s sVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }

        class d implements DialogInterface.OnClickListener {
            d(s sVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }

        public s(MainActivity mainActivity) {
            this.a = new WeakReference<>(mainActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            View viewFindViewById;
            String str;
            androidx.appcompat.app.b.a aVar;
            DialogInterface.OnClickListener bVar;
            View viewFindViewById2;
            String string;
            Snackbar snackbarX;
            String str2;
            MainActivity mainActivity = this.a.get();
            if (mainActivity != null) {
                int i = message.what;
                switch (i) {
                    case 1:
                        mainActivity.t0(mainActivity.u);
                        this.b.dismiss();
                        viewFindViewById = mainActivity.findViewById(R.id.layout_coordinator);
                        str = "Unpack successfully!";
                        snackbarX = Snackbar.X(viewFindViewById, str, -1);
                        snackbarX.N();
                        break;
                    case 2:
                        mainActivity.t0(mainActivity.u);
                        this.b.dismiss();
                        viewFindViewById = mainActivity.findViewById(R.id.layout_coordinator);
                        str = "Repack successfully!";
                        snackbarX = Snackbar.X(viewFindViewById, str, -1);
                        snackbarX.N();
                        break;
                    case 3:
                        mainActivity.t0(mainActivity.u);
                        mainActivity.D.setVisibility(0);
                        mainActivity.w.setVisibility(8);
                        this.b.dismiss();
                        viewFindViewById = mainActivity.findViewById(R.id.layout_coordinator);
                        str = "Cleanup successfully!";
                        snackbarX = Snackbar.X(viewFindViewById, str, -1);
                        snackbarX.N();
                        break;
                    case 4:
                        mainActivity.t0(mainActivity.u);
                        this.b.dismiss();
                        String string2 = message.getData().getString("errorMsg", "unpack error!");
                        aVar = new androidx.appcompat.app.b.a(mainActivity);
                        TextView textView = new TextView(mainActivity);
                        textView.setText(string2);
                        textView.setPadding(MainActivity.L, MainActivity.L, MainActivity.L, MainActivity.L);
                        aVar.n(textView);
                        aVar.k("OK", new a(this));
                        bVar = new b(this);
                        aVar.h("Cancel", bVar);
                        aVar.a().show();
                        break;
                    case 5:
                        mainActivity.t0(mainActivity.u);
                        this.b.dismiss();
                        String string3 = message.getData().getString("errorMsg", "repack error!");
                        aVar = new androidx.appcompat.app.b.a(mainActivity);
                        TextView textView2 = new TextView(mainActivity);
                        textView2.setText(string3);
                        textView2.setPadding(MainActivity.L, MainActivity.L, MainActivity.L, MainActivity.L);
                        aVar.n(textView2);
                        aVar.k("OK", new c(this));
                        bVar = new d(this);
                        aVar.h("Cancel", bVar);
                        aVar.a().show();
                        break;
                    case 6:
                        mainActivity.t0(mainActivity.u);
                        this.b.dismiss();
                        viewFindViewById2 = mainActivity.findViewById(R.id.layout_coordinator);
                        string = message.getData().getString("errorMsg", "clean error!");
                        snackbarX = Snackbar.X(viewFindViewById2, string, -1);
                        snackbarX.N();
                        break;
                    default:
                        switch (i) {
                            case 13:
                                this.b.dismiss();
                                viewFindViewById2 = mainActivity.findViewById(R.id.layout_coordinator);
                                string = "Unmount error: " + message.getData().get("errorMsg");
                                snackbarX = Snackbar.X(viewFindViewById2, string, -1);
                                snackbarX.N();
                                break;
                            case 14:
                                mainActivity.t0(mainActivity.u);
                                mainActivity.v0();
                                this.b.dismiss();
                                viewFindViewById = mainActivity.findViewById(R.id.layout_coordinator);
                                str = "Mount successfully!";
                                snackbarX = Snackbar.X(viewFindViewById, str, -1);
                                snackbarX.N();
                                break;
                            case 15:
                                mainActivity.t0(mainActivity.u);
                                this.b.dismiss();
                                viewFindViewById = mainActivity.findViewById(R.id.layout_coordinator);
                                str = "Mount failed!";
                                snackbarX = Snackbar.X(viewFindViewById, str, -1);
                                snackbarX.N();
                                break;
                            case 16:
                                mainActivity.t0(mainActivity.u);
                                mainActivity.u0();
                                this.b.dismiss();
                                viewFindViewById = mainActivity.findViewById(R.id.layout_coordinator);
                                str = "Unmount successfully!";
                                snackbarX = Snackbar.X(viewFindViewById, str, -1);
                                snackbarX.N();
                                break;
                            case 17:
                                str2 = "Unpacking ... ";
                                this.b = ProgressDialog.show(mainActivity, null, str2);
                                break;
                            case 18:
                                str2 = "Repacking ...";
                                this.b = ProgressDialog.show(mainActivity, null, str2);
                                break;
                            case 19:
                                str2 = "Converting sparse image ...";
                                this.b = ProgressDialog.show(mainActivity, null, str2);
                                break;
                            case 20:
                                str2 = "Mounting system image ...";
                                this.b = ProgressDialog.show(mainActivity, null, str2);
                                break;
                            case 21:
                                str2 = "Unmounting system image ...";
                                this.b = ProgressDialog.show(mainActivity, null, str2);
                                break;
                            case 22:
                                str2 = "Cleaning up ...";
                                this.b = ProgressDialog.show(mainActivity, null, str2);
                                break;
                            case 23:
                                viewFindViewById = mainActivity.findViewById(R.id.layout_coordinator);
                                str = "Unsupported image type!";
                                snackbarX = Snackbar.X(viewFindViewById, str, -1);
                                snackbarX.N();
                                break;
                            case 24:
                                this.b.dismiss();
                                viewFindViewById = mainActivity.findViewById(R.id.layout_coordinator);
                                str = "Convert failed!";
                                snackbarX = Snackbar.X(viewFindViewById, str, -1);
                                snackbarX.N();
                                break;
                            case 25:
                                this.b.dismiss();
                                viewFindViewById = mainActivity.findViewById(R.id.layout_coordinator);
                                str = "Convert successfully!";
                                snackbarX = Snackbar.X(viewFindViewById, str, -1);
                                snackbarX.N();
                                break;
                            case 26:
                                viewFindViewById = mainActivity.findViewById(R.id.layout_coordinator);
                                str = "Initialize successfully!";
                                snackbarX = Snackbar.X(viewFindViewById, str, -1);
                                snackbarX.N();
                                break;
                            case 27:
                                Toast.makeText(mainActivity, "Initialization failed, please uninstall or clear app data!", 1).show();
                                mainActivity.finish();
                                break;
                        }
                        break;
                }
            }
        }
    }

    static {
        Pattern.compile("[d-][rwx-]{9}");
        L = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Message e0(int i2, String str) {
        Message message = new Message();
        message.what = i2;
        Bundle bundle = new Bundle();
        bundle.putString("errorMsg", str);
        message.setData(bundle);
        return message;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        ProgressDialog progressDialog = this.I;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        this.I.dismiss();
    }

    private void g0(File file) {
        this.x.sendEmptyMessage(19);
        try {
            File file2 = new File(file.getCanonicalPath() + ".raw");
            try {
                e.b.a.a.a(false).w(new c(102, 100000, new String[]{this.v + File.separator + "simg2img " + file.getCanonicalPath() + " " + file2.getCanonicalPath()}, file2));
            } catch (e.b.a.b.a | IOException | TimeoutException unused) {
                this.x.sendEmptyMessage(24);
            }
        } catch (IOException unused2) {
            this.x.sendEmptyMessage(24);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(File file) {
        this.x.sendEmptyMessage(20);
        try {
            e.b.a.a.a(true).w(new d(103, "losetup /dev/block/loop1 " + file.getCanonicalPath(), "mount -t ext4 /dev/block/loop1 " + this.u.getCanonicalPath(), "chown -R " + this.H + ":" + this.H + " " + this.u.getCanonicalPath()));
        } catch (e.b.a.b.a | IOException | TimeoutException unused) {
            this.x.sendEmptyMessage(15);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(File file) throws Throwable {
        int iN0 = n0(file);
        if (iN0 == 1) {
            l0(file);
            return;
        }
        if (iN0 == 2) {
            g0(file);
        } else if (iN0 != 3) {
            this.x.sendEmptyMessage(23);
        } else {
            j0(file);
        }
    }

    private void l0(File file) {
        this.x.sendEmptyMessage(17);
        try {
            e.b.a.a.a(false).w(new b(101, "sh " + this.v + File.separator + "unpackimg.sh " + this.v + " " + this.u.getCanonicalPath() + " " + file.getCanonicalPath()));
        } catch (e.b.a.b.a | IOException | TimeoutException e2) {
            this.x.sendMessage(e0(4, e2.getLocalizedMessage()));
        }
    }

    private boolean m0() {
        if (this.u.listFiles().length <= 9) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.u.getAbsolutePath());
        sb.append(File.separator);
        sb.append("split_image");
        return !new File(sb.toString()).exists();
    }

    private int n0(File file) throws Throwable {
        byte[] bArr = new byte[1082];
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileInputStream2.read(bArr);
                try {
                    fileInputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                if (Arrays.equals(Arrays.copyOfRange(bArr, 0, 8), new byte[]{65, 78, 68, 82, 79, 73, 68, 33})) {
                    return 1;
                }
                if (Arrays.equals(Arrays.copyOfRange(bArr, 0, 4), new byte[]{58, -1, 38, -19})) {
                    return 2;
                }
                return Arrays.equals(Arrays.copyOfRange(bArr, 1080, 1082), new byte[]{83, -17}) ? 3 : -1;
            } catch (FileNotFoundException unused) {
                fileInputStream = fileInputStream2;
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return -1;
            } catch (IOException unused2) {
                fileInputStream = fileInputStream2;
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return -1;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                throw th;
            }
        } catch (FileNotFoundException unused3) {
        } catch (IOException unused4) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void o0() {
        this.J = androidx.preference.b.a(this);
        this.H = getApplicationInfo().uid;
        this.v = getApplicationInfo().dataDir;
        File file = new File(getFilesDir(), "data");
        this.u = file;
        if (!file.exists() && !this.u.mkdir()) {
            Toast.makeText(this, "Error creating working directory, please uninstall app then reinstall", 1).show();
            finish();
            return;
        }
        if (!this.J.getBoolean("initialized", false)) {
            String str = getApplicationInfo().nativeLibraryDir;
            this.I = ProgressDialog.show(this, null, "initializing ...");
            try {
                e.b.a.a.a(false).w(new l(99, "ln -s " + str + File.separator + "libbusybox.so " + this.v + File.separator + "busybox", "ln -s " + str + File.separator + "libfile.so " + this.v + File.separator + "file", "ln -s " + str + File.separator + "liblz4.so " + this.v + File.separator + "lz4", "ln -s " + str + File.separator + "libmkbootfs.so " + this.v + File.separator + "mkbootfs", "ln -s " + str + File.separator + "librepack.so " + this.v + File.separator + "repack", "ln -s " + str + File.separator + "libunpack.so " + this.v + File.separator + "unpack", "ln -s " + str + File.separator + "libxz.so " + this.v + File.separator + "xz", "ln -s " + str + File.separator + "libmagic.so " + this.v + File.separator + "magic", "ln -s " + str + File.separator + "libsimg2img.so " + this.v + File.separator + "simg2img", "ln -s " + str + File.separator + "libunpackimg.so " + this.v + File.separator + "unpackimg.sh", "ln -s " + str + File.separator + "librepackimg.so " + this.v + File.separator + "repackimg.sh"));
            } catch (e.b.a.b.a | IOException | TimeoutException unused) {
                f0();
                this.x.sendEmptyMessage(27);
            }
        }
        setContentView(R.layout.activity_main);
        D((Toolbar) findViewById(R.id.toolbar));
        this.x = new s(this);
        this.w = (ListView) findViewById(R.id.main_list_view);
        this.D = (LinearLayout) findViewById(R.id.welcome_layout);
        registerForContextMenu(this.w);
        this.t = m0();
        com.redlee90.imagekitchenforandroid.b.a aVar = new com.redlee90.imagekitchenforandroid.b.a(this, this.z, this.A, this.B);
        this.C = aVar;
        this.w.setAdapter((ListAdapter) aVar);
        t0(this.u);
        this.w.setOnItemClickListener(new m());
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.menu_unpack);
        this.E = (FloatingActionButton) findViewById(R.id.menu_repack);
        this.F = (FloatingActionButton) findViewById(R.id.menu_export);
        this.G = (FloatingActionButton) findViewById(R.id.menu_cleanup);
        FloatingActionButton floatingActionButton2 = (FloatingActionButton) findViewById(R.id.menu_import);
        if (this.t) {
            v0();
        } else {
            u0();
        }
        floatingActionButton.setOnClickListener(new n());
        this.E.setOnClickListener(new o());
        this.G.setOnClickListener(new p());
        this.F.setOnClickListener(new q());
        floatingActionButton2.setOnClickListener(new r());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(String str) {
        Snackbar.X(findViewById(R.id.layout_coordinator), str, -1).N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(String str) {
        Snackbar.X(findViewById(R.id.layout_coordinator), str, -1).N();
        t0(this.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        Snackbar.X(findViewById(R.id.layout_coordinator), "Import successfully!", -1).N();
        t0(this.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(File file) {
        this.y = file;
        this.z.clear();
        Collections.addAll(this.z, this.y.listFiles());
        this.A.clear();
        this.B.clear();
        try {
            e.b.a.a.a(false).w(new e(105, false, "ls -al " + this.y.getCanonicalPath() + "| tr -s ' '| cut -d ' ' -f 1,8,10"));
        } catch (e.b.a.b.a | IOException | TimeoutException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        this.E.setLabelText("Repack");
        this.F.setEnabled(true);
        this.G.setEnabled(true);
        this.t = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        this.E.setLabelText("Unmount");
        this.F.setEnabled(false);
        this.G.setEnabled(false);
        this.t = true;
    }

    public void h0(File file, File file2) {
        this.I = ProgressDialog.show(this, null, "Exporting ...");
        f.a.c.c(new f(this, file, file2)).g(f.a.o.a.a()).d(f.a.i.b.a.a()).a(new g());
    }

    public void i0(File file, List<File> list) {
        this.I = ProgressDialog.show(this, null, "Importing ...");
        f.a.c.c(new h(this, list, file)).g(f.a.o.a.a()).d(f.a.i.b.a.a()).a(new i());
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            if (this.y.getCanonicalPath().equals(this.u.getCanonicalPath())) {
                finish();
            } else {
                t0(this.y.getParentFile());
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
        int itemId = menuItem.getItemId();
        if (itemId != R.id.action_delete) {
            if (itemId == R.id.action_export) {
                com.redlee90.imagekitchenforandroid.c.b.A1(this.z.get(adapterContextMenuInfo.position).getAbsolutePath()).v1(o(), "export");
                return true;
            }
            if (itemId != R.id.action_rename) {
                return true;
            }
            androidx.appcompat.app.b.a aVar = new androidx.appcompat.app.b.a(this);
            EditText editText = new EditText(this);
            aVar.f("Enter new name");
            aVar.n(editText);
            aVar.j(android.R.string.ok, new j(adapterContextMenuInfo, editText));
            aVar.g(android.R.string.cancel, new k(this));
            aVar.a().show();
            return true;
        }
        File file = this.z.get(adapterContextMenuInfo.position);
        try {
            if (file.isDirectory()) {
                g.a.a.a.b.k(file);
                Snackbar.X(findViewById(R.id.layout_coordinator), "Delete directory successfully!", -1).N();
                this.z.remove(adapterContextMenuInfo.position);
                this.C.notifyDataSetChanged();
                if (this.z.size() == 0) {
                    this.w.setVisibility(8);
                    this.D.setVisibility(0);
                }
            } else {
                g.a.a.a.b.o(file);
                Snackbar.X(findViewById(R.id.layout_coordinator), "Delete file successfully!", -1).N();
                this.z.remove(adapterContextMenuInfo.position);
                this.C.notifyDataSetChanged();
                if (this.z.size() == 0) {
                    this.w.setVisibility(8);
                    this.D.setVisibility(0);
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            Snackbar.X(findViewById(R.id.layout_coordinator), "Delete failed!", -1).N();
        }
        return true;
    }

    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.d, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (androidx.core.content.a.a(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            androidx.core.app.a.k(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        } else {
            o0();
        }
        L = ((int) getResources().getDisplayMetrics().density) * 16;
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        getMenuInflater().inflate(R.menu.menu_context_main, contextMenu);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_donate) {
            new com.redlee90.imagekitchenforandroid.c.a().v1(o(), "donation");
            return true;
        }
        if (itemId != R.id.action_rate) {
            return true;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName()));
        intent.addFlags(1207959552);
        try {
            startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
            return true;
        }
    }

    @Override // androidx.fragment.app.d, android.app.Activity, androidx.core.app.a.b
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 1) {
            if (iArr.length > 0 && iArr[0] == 0) {
                o0();
            } else {
                Toast.makeText(this, "Storage permission is required to access local storage on this device", 1).show();
                finish();
            }
        }
    }

    public void q0() {
        Snackbar.X(findViewById(R.id.layout_coordinator), "Export successfully!", -1).N();
    }

    public void w0(File file) {
        new a(file).start();
    }
}
