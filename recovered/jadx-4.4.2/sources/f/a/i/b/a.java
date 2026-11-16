package f.a.i.b;

import android.os.Handler;
import android.os.Looper;
import f.a.h;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final h a = f.a.i.a.a.d(new CallableC0075a());

    /* JADX INFO: renamed from: f.a.i.b.a$a, reason: collision with other inner class name */
    static class CallableC0075a implements Callable<h> {
        CallableC0075a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h call() {
            return b.a;
        }
    }

    private static final class b {
        static final h a = new f.a.i.b.b(new Handler(Looper.getMainLooper()));
    }

    public static h a() {
        return f.a.i.a.a.e(a);
    }
}
