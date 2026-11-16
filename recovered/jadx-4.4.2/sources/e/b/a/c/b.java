package e.b.a.c;

import android.os.Build;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static b w;
    private static b x;
    private static b y;
    private int a;
    private e b;
    private d c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Process f948e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BufferedReader f949f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final BufferedReader f950g;
    private final OutputStreamWriter h;
    public boolean m;
    public boolean n;
    private static String[] z = {null, null};
    public static d A = d.NORMAL;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f947d = "";
    private final List<e.b.a.c.a> i = new ArrayList();
    private boolean j = false;
    private Boolean k = null;
    public boolean l = false;
    private int o = 5000;
    private int p = 0;
    private int q = 0;
    private int r = 0;
    private int s = 0;
    private boolean t = false;
    private Runnable u = new a();
    private Runnable v = new c();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    try {
                        synchronized (b.this.i) {
                            while (!b.this.j && b.this.q >= b.this.i.size()) {
                                b.this.l = false;
                                b.this.i.wait();
                            }
                        }
                        if (b.this.q >= b.this.o) {
                            while (b.this.p != b.this.q) {
                                e.b.a.a.d("Waiting for read and write to catch up before cleanup.");
                            }
                            b.this.x();
                        }
                        if (b.this.q < b.this.i.size()) {
                            b.this.l = true;
                            e.b.a.c.a aVar = (e.b.a.c.a) b.this.i.get(b.this.q);
                            aVar.k();
                            e.b.a.a.d("Executing: " + aVar.g() + " with context: " + b.this.c);
                            b.this.h.write(aVar.g());
                            b.this.h.flush();
                            b.this.h.write("\necho F*D^W@#FGF " + b.this.r + " $?\n");
                            b.this.h.flush();
                            b.m(b.this);
                            b.v(b.this);
                        } else if (b.this.j) {
                            b.this.l = false;
                            b.this.h.write("\nexit 0\n");
                            b.this.h.flush();
                            e.b.a.a.d("Closing shell");
                            b.this.q = 0;
                            b bVar = b.this;
                            bVar.C(bVar.h);
                            return;
                        }
                    } catch (Throwable th) {
                        b.this.q = 0;
                        b bVar2 = b.this;
                        bVar2.C(bVar2.h);
                        throw th;
                    }
                } catch (IOException | InterruptedException e2) {
                    e.b.a.a.e(e2.getMessage(), e.b.a.a.b.ERROR, e2);
                    b.this.q = 0;
                    b bVar3 = b.this;
                    bVar3.C(bVar3.h);
                    return;
                }
            }
        }
    }

    /* JADX INFO: renamed from: e.b.a.c.b$b, reason: collision with other inner class name */
    class C0074b extends Thread {
        C0074b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (b.this.i) {
                b.this.i.notifyAll();
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.b.a.c.a aVar;
            int i;
            int i2;
            String str;
            loop0: while (true) {
                aVar = null;
                while (true) {
                    try {
                        try {
                            if (b.this.j && !b.this.f949f.ready() && b.this.p >= b.this.i.size()) {
                                break loop0;
                            }
                            b.this.m = false;
                            String line = b.this.f949f.readLine();
                            b.this.m = true;
                            if (line == null) {
                                break loop0;
                            }
                            if (aVar == null) {
                                if (b.this.p < b.this.i.size()) {
                                    aVar = (e.b.a.c.a) b.this.i.get(b.this.p);
                                } else if (b.this.j) {
                                    break loop0;
                                }
                            }
                            int iIndexOf = line.indexOf("F*D^W@#FGF");
                            i = -1;
                            if (iIndexOf == -1) {
                                aVar.i(aVar.m, line);
                            } else if (iIndexOf > 0) {
                                e.b.a.a.d("Found token, line: " + line);
                                aVar.i(aVar.m, line.substring(0, iIndexOf));
                            }
                            if (iIndexOf >= 0) {
                                String[] strArrSplit = line.substring(iIndexOf).split(" ");
                                if (strArrSplit.length >= 2 && strArrSplit[1] != null) {
                                    try {
                                        i2 = Integer.parseInt(strArrSplit[1]);
                                    } catch (NumberFormatException unused) {
                                        i2 = 0;
                                    }
                                    try {
                                        i = Integer.parseInt(strArrSplit[2]);
                                    } catch (NumberFormatException unused2) {
                                    }
                                    if (i2 == b.this.s) {
                                        break;
                                    }
                                }
                            } else {
                                continue;
                            }
                        } catch (Throwable th) {
                            b bVar = b.this;
                            bVar.C(bVar.h);
                            b bVar2 = b.this;
                            bVar2.B(bVar2.f950g);
                            b bVar3 = b.this;
                            bVar3.B(bVar3.f949f);
                            e.b.a.a.d("Shell destroyed");
                            b bVar4 = b.this;
                            bVar4.n = true;
                            bVar4.m = false;
                            throw th;
                        }
                    } catch (IOException e2) {
                        e.b.a.a.e(e2.getMessage(), e.b.a.a.b.ERROR, e2);
                    }
                }
                b.this.I(aVar);
                int i3 = 0;
                while (aVar.c > aVar.f943d) {
                    if (i3 == 0) {
                        i3++;
                        e.b.a.a.d("Waiting for output to be processed. " + aVar.f943d + " Of " + aVar.c);
                    }
                    try {
                        synchronized (this) {
                            try {
                                wait(2000L);
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    } catch (Exception e3) {
                        e.b.a.a.d(e3.getMessage());
                    }
                }
                e.b.a.a.d("Read all output");
                aVar.j(i);
                aVar.b();
                b.q(b.this);
                b.e(b.this);
            }
            try {
                b.this.f948e.waitFor();
                b.this.f948e.destroy();
            } catch (Exception unused3) {
            }
            while (b.this.p < b.this.i.size()) {
                if (aVar == null) {
                    aVar = (e.b.a.c.a) b.this.i.get(b.this.p);
                }
                if (aVar.c < aVar.f943d) {
                    aVar.m("All output not processed!");
                    str = "Did you forget the super.commandOutput call or are you waiting on the command object?";
                } else {
                    str = "Unexpected Termination.";
                }
                aVar.m(str);
                b.q(b.this);
                aVar = null;
            }
            b.this.p = 0;
            b bVar5 = b.this;
            bVar5.C(bVar5.h);
            b bVar6 = b.this;
            bVar6.B(bVar6.f950g);
            b bVar7 = b.this;
            bVar7.B(bVar7.f949f);
            e.b.a.a.d("Shell destroyed");
            b bVar8 = b.this;
            bVar8.n = true;
            bVar8.m = false;
        }
    }

    public enum d {
        NORMAL("normal"),
        SHELL("u:r:shell:s0"),
        SYSTEM_SERVER("u:r:system_server:s0"),
        SYSTEM_APP("u:r:system_app:s0"),
        PLATFORM_APP("u:r:platform_app:s0"),
        UNTRUSTED_APP("u:r:untrusted_app:s0"),
        RECOVERY("u:r:recovery:s0");

        private String b;

        d(String str) {
            this.b = str;
        }

        public String a() {
            return this.b;
        }
    }

    public enum e {
        NORMAL,
        ROOT,
        CUSTOM
    }

    protected static class f extends Thread {
        public int b;
        public b c;

        private f(b bVar) {
            this.b = -911;
            this.c = bVar;
        }

        /* synthetic */ f(b bVar, a aVar) {
            this(bVar);
        }

        private void a() {
            Field declaredField;
            try {
                Class<?> cls = this.c.f948e.getClass();
                try {
                    declaredField = cls.getDeclaredField("pid");
                } catch (NoSuchFieldException unused) {
                    declaredField = cls.getDeclaredField("id");
                }
                declaredField.setAccessible(true);
                int iIntValue = ((Integer) declaredField.get(this.c.f948e)).intValue();
                this.c.h.write("(echo -17 > /proc/" + iIntValue + "/oom_adj) &> /dev/null\n");
                this.c.h.write("(echo -17 > /proc/$$/oom_adj) &> /dev/null\n");
                this.c.h.flush();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.c.h.write("echo Started\n");
                this.c.h.flush();
                while (true) {
                    String line = this.c.f949f.readLine();
                    if (line == null) {
                        throw new EOFException();
                    }
                    if (!"".equals(line)) {
                        if ("Started".equals(line)) {
                            this.b = 1;
                            a();
                            return;
                        }
                        this.c.f947d = "unknown error occurred.";
                    }
                }
            } catch (IOException e2) {
                this.b = -42;
                if (e2.getMessage() == null) {
                    this.c.f947d = "RootAccess denied?.";
                } else {
                    this.c.f947d = e2.getMessage();
                }
            }
        }
    }

    private b(String str, e eVar, d dVar, int i) throws e.b.a.b.a, TimeoutException {
        this.a = 25000;
        a aVar = null;
        this.b = null;
        this.c = d.NORMAL;
        e.b.a.a.d("Starting shell: " + str);
        e.b.a.a.d("Context: " + dVar.a());
        e.b.a.a.d("Timeout: " + i);
        this.b = eVar;
        this.a = i <= 0 ? this.a : i;
        this.c = dVar;
        if (dVar != d.NORMAL) {
            String strF = F(false);
            String strF2 = F(true);
            if (!G() || strF == null || strF2 == null || !strF.endsWith("SUPERSU") || Integer.valueOf(strF2).intValue() < 190) {
                e.b.a.a.d("Su binary --context switch not supported!");
                e.b.a.a.d("Su binary display version: " + strF);
                e.b.a.a.d("Su binary internal version: " + strF2);
                e.b.a.a.d("SELinuxEnforcing: " + G());
            } else {
                str = str + " --context " + this.c.a();
            }
        }
        this.f948e = Runtime.getRuntime().exec(str);
        this.f949f = new BufferedReader(new InputStreamReader(this.f948e.getInputStream(), "UTF-8"));
        this.f950g = new BufferedReader(new InputStreamReader(this.f948e.getErrorStream(), "UTF-8"));
        this.h = new OutputStreamWriter(this.f948e.getOutputStream(), "UTF-8");
        f fVar = new f(this, aVar);
        fVar.start();
        try {
            fVar.join(this.a);
            if (fVar.b == -911) {
                try {
                    this.f948e.destroy();
                } catch (Exception unused) {
                }
                B(this.f949f);
                B(this.f950g);
                C(this.h);
                throw new TimeoutException(this.f947d);
            }
            if (fVar.b == -42) {
                try {
                    this.f948e.destroy();
                } catch (Exception unused2) {
                }
                B(this.f949f);
                B(this.f950g);
                C(this.h);
                throw new e.b.a.b.a("Root Access Denied");
            }
            Thread thread = new Thread(this.u, "Shell Input");
            thread.setPriority(5);
            thread.start();
            Thread thread2 = new Thread(this.v, "Shell Output");
            thread2.setPriority(5);
            thread2.start();
        } catch (InterruptedException unused3) {
            fVar.interrupt();
            Thread.currentThread().interrupt();
            throw new TimeoutException();
        }
    }

    public static void A() {
        e.b.a.a.d("Request to close custom shell!");
        b bVar = y;
        if (bVar == null) {
            return;
        }
        bVar.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void D() {
        e.b.a.a.d("Request to close root shell!");
        b bVar = w;
        if (bVar == null) {
            return;
        }
        bVar.y();
    }

    public static void E() {
        e.b.a.a.d("Request to close normal shell!");
        b bVar = x;
        if (bVar == null) {
            return;
        }
        bVar.y();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004c A[Catch: all -> 0x007b, TryCatch #3 {all -> 0x007b, blocks: (B:6:0x0006, B:9:0x000d, B:13:0x0018, B:14:0x001f, B:15:0x0032, B:17:0x0038, B:19:0x003c, B:20:0x003f, B:21:0x0046, B:23:0x004c, B:25:0x0054, B:28:0x005d, B:31:0x0064, B:33:0x006a, B:37:0x0070, B:40:0x0075), top: B:55:0x0006, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x0063 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x0054 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x0063 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x0046 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x0046 A[SYNTHETIC] */
    private synchronized String F(boolean z2) {
        char c2;
        String str;
        c2 = z2 ? (char) 0 : (char) 1;
        try {
            if (z[c2] == null) {
                str = null;
                try {
                    Process processExec = Runtime.getRuntime().exec(z2 ? "su -V" : "su -v", (String[]) null);
                    processExec.waitFor();
                    ArrayList<String> arrayList = new ArrayList();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            arrayList.add(line);
                        } catch (IOException unused) {
                        }
                    }
                    bufferedReader.close();
                    processExec.destroy();
                    for (String str2 : arrayList) {
                        if (z2) {
                            if (str2.contains(".")) {
                                str = str2;
                                break;
                            }
                        } else {
                            try {
                                if (Integer.parseInt(str2) > 0) {
                                    str = str2;
                                    break;
                                }
                            } catch (NumberFormatException unused2) {
                                continue;
                            }
                        }
                    }
                    z[c2] = str;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return null;
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                    return null;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return z[c2];
        try {
            bufferedReader.close();
        } catch (IOException unused3) {
        }
        processExec.destroy();
        while (r2.hasNext()) {
            if (z2) {
                if (Integer.parseInt(str2) > 0) {
                    str = str2;
                    break;
                }
            } else {
                if (str2.contains(".")) {
                    str = str2;
                    break;
                }
            }
        }
        z[c2] = str;
        return z[c2];
    }

    public static b J(int i, d dVar, int i2) throws e.b.a.b.a, TimeoutException, IOException {
        int i3;
        b bVar = w;
        if (bVar == null) {
            e.b.a.a.d("Starting Root Shell!");
            int i4 = 0;
            while (w == null) {
                try {
                    e.b.a.a.d("Trying to open Root Shell, attempt #" + i4);
                    w = new b("su", e.ROOT, dVar, i);
                } catch (e.b.a.b.a e2) {
                    i3 = i4 + 1;
                    if (i4 >= i2) {
                        e.b.a.a.d("RootDeniedException, could not start shell");
                        throw e2;
                    }
                    i4 = i3;
                } catch (IOException e3) {
                    i3 = i4 + 1;
                    if (i4 >= i2) {
                        e.b.a.a.d("IOException, could not start shell");
                        throw e3;
                    }
                    i4 = i3;
                } catch (TimeoutException e4) {
                    i3 = i4 + 1;
                    if (i4 >= i2) {
                        e.b.a.a.d("TimeoutException, could not start shell");
                        throw e4;
                    }
                    i4 = i3;
                }
            }
        } else if (bVar.c != dVar) {
            try {
                e.b.a.a.d("Context is different than open shell, switching context... " + w.c + " VS " + dVar);
                w.L(dVar);
            } catch (e.b.a.b.a e5) {
                if (i2 <= 0) {
                    e.b.a.a.d("RootDeniedException, could not switch context!");
                    throw e5;
                }
            } catch (IOException e6) {
                if (i2 <= 0) {
                    e.b.a.a.d("IOException, could not switch context!");
                    throw e6;
                }
            } catch (TimeoutException e7) {
                if (i2 <= 0) {
                    e.b.a.a.d("TimeoutException, could not switch context!");
                    throw e7;
                }
            }
        } else {
            e.b.a.a.d("Using Existing Root Shell!");
        }
        return w;
    }

    public static b K(int i) throws IOException {
        try {
            if (x == null) {
                e.b.a.a.d("Starting Shell!");
                x = new b("/system/bin/sh", e.NORMAL, d.NORMAL, i);
            } else {
                e.b.a.a.d("Using Existing Shell!");
            }
            return x;
        } catch (e.b.a.b.a unused) {
            throw new IOException();
        }
    }

    static /* synthetic */ int e(b bVar) {
        int i = bVar.s;
        bVar.s = i + 1;
        return i;
    }

    static /* synthetic */ int m(b bVar) {
        int i = bVar.q;
        bVar.q = i + 1;
        return i;
    }

    static /* synthetic */ int q(b bVar) {
        int i = bVar.p;
        bVar.p = i + 1;
        return i;
    }

    static /* synthetic */ int v(b bVar) {
        int i = bVar.r;
        bVar.r = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.t = true;
        int i = this.o;
        int iAbs = Math.abs(i - (i / 4));
        e.b.a.a.d("Cleaning up: " + iAbs);
        for (int i2 = 0; i2 < iAbs; i2++) {
            this.i.remove(0);
        }
        this.p = this.i.size() - 1;
        this.q = this.i.size() - 1;
        this.t = false;
    }

    public static void z() {
        e.b.a.a.d("Request to close all shells!");
        E();
        D();
        A();
    }

    public synchronized boolean G() {
        if (this.k == null) {
            Boolean boolValueOf = null;
            if (Build.VERSION.SDK_INT >= 17) {
                boolean z2 = true;
                if (new File("/sys/fs/selinux/enforce").exists()) {
                    try {
                        FileInputStream fileInputStream = new FileInputStream("/sys/fs/selinux/enforce");
                        try {
                            boolValueOf = Boolean.valueOf(fileInputStream.read() == 49);
                            fileInputStream.close();
                        } catch (Throwable th) {
                            fileInputStream.close();
                            throw th;
                        }
                    } catch (Exception unused) {
                    }
                }
                if (boolValueOf == null) {
                    if (Build.VERSION.SDK_INT < 19) {
                        z2 = false;
                    }
                    boolValueOf = Boolean.valueOf(z2);
                }
            }
            if (boolValueOf == null) {
                boolValueOf = Boolean.FALSE;
            }
            this.k = boolValueOf;
        }
        return this.k.booleanValue();
    }

    protected void H() {
        new C0074b().start();
    }

    public void I(e.b.a.c.a aVar) {
        String line;
        while (this.f950g.ready() && aVar != null && (line = this.f950g.readLine()) != null) {
            try {
                aVar.i(aVar.m, line);
            } catch (Exception e2) {
                e.b.a.a.e(e2.getMessage(), e.b.a.a.b.ERROR, e2);
                return;
            }
        }
    }

    public b L(d dVar) {
        if (this.b != e.ROOT) {
            e.b.a.a.d("Can only switch context on a root shell!");
            return this;
        }
        try {
            D();
        } catch (Exception unused) {
            e.b.a.a.d("Problem closing shell while trying to switch context...");
        }
        return J(this.a, dVar, 3);
    }

    public e.b.a.c.a w(e.b.a.c.a aVar) {
        if (this.j) {
            throw new IllegalStateException("Unable to add commands to a closed shell");
        }
        if (aVar.f946g) {
            throw new IllegalStateException("This command has already been executed. (Don't re-use command instances.)");
        }
        while (this.t) {
        }
        this.i.add(aVar);
        H();
        return aVar;
    }

    public void y() {
        e.b.a.a.d("Request to close shell!");
        int i = 0;
        while (this.l) {
            e.b.a.a.d("Waiting on shell to finish executing before closing...");
            i++;
            if (i > 10000) {
                break;
            }
        }
        synchronized (this.i) {
            this.j = true;
            H();
        }
        e.b.a.a.d("Shell Closed!");
        if (this == w) {
            w = null;
        } else if (this == x) {
            x = null;
        } else if (this == y) {
            y = null;
        }
    }
}
