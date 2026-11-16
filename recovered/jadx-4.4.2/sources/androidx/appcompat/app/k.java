package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
class k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static k f43d;
    private final Context a;
    private final LocationManager b;
    private final a c = new a();

    private static class a {
        boolean a;
        long b;
        long c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f44d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f45e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f46f;

        a() {
        }
    }

    k(Context context, LocationManager locationManager) {
        this.a = context;
        this.b = locationManager;
    }

    static k a(Context context) {
        if (f43d == null) {
            Context applicationContext = context.getApplicationContext();
            f43d = new k(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f43d;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location locationC = androidx.core.content.b.b(this.a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        Location locationC2 = androidx.core.content.b.b(this.a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        if (locationC2 == null || locationC == null) {
            return locationC2 != null ? locationC2 : locationC;
        }
        return locationC2.getTime() > locationC.getTime() ? locationC2 : locationC;
    }

    private Location c(String str) {
        try {
            if (this.b.isProviderEnabled(str)) {
                return this.b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e2) {
            Log.d("TwilightManager", "Failed to get last known location", e2);
            return null;
        }
    }

    private boolean e() {
        return this.c.f46f > System.currentTimeMillis();
    }

    private void f(Location location) {
        long j;
        long j2;
        a aVar = this.c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        j jVarB = j.b();
        jVarB.a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j3 = jVarB.a;
        jVarB.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = jVarB.c == 1;
        long j4 = jVarB.b;
        long j5 = jVarB.a;
        boolean z2 = z;
        jVarB.a(86400000 + jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        long j6 = jVarB.b;
        if (j4 == -1 || j5 == -1) {
            j = 43200000 + jCurrentTimeMillis;
        } else {
            if (jCurrentTimeMillis > j5) {
                j2 = 0 + j6;
            } else {
                j2 = jCurrentTimeMillis > j4 ? 0 + j5 : 0 + j4;
            }
            j = j2 + 60000;
        }
        aVar.a = z2;
        aVar.b = j3;
        aVar.c = j4;
        aVar.f44d = j5;
        aVar.f45e = j6;
        aVar.f46f = j;
    }

    boolean d() {
        a aVar = this.c;
        if (e()) {
            return aVar.a;
        }
        Location locationB = b();
        if (locationB != null) {
            f(locationB);
            return aVar.a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }
}
