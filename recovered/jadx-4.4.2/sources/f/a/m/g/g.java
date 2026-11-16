package f.a.m.g;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static final int a;
    static final AtomicReference<ScheduledExecutorService> b = new AtomicReference<>();
    static final Map<ScheduledThreadPoolExecutor, Object> c = new ConcurrentHashMap();

    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                for (ScheduledThreadPoolExecutor scheduledThreadPoolExecutor : new ArrayList(g.c.keySet())) {
                    if (scheduledThreadPoolExecutor.isShutdown()) {
                        g.c.remove(scheduledThreadPoolExecutor);
                    } else {
                        scheduledThreadPoolExecutor.purge();
                    }
                }
            } catch (Throwable th) {
                f.a.n.a.j(th);
            }
        }
    }

    static {
        Properties properties = System.getProperties();
        int iIntValue = 1;
        if (properties.containsKey("rx2.purge-enabled") && Boolean.getBoolean("rx2.purge-enabled") && properties.containsKey("rx2.purge-period-seconds")) {
            iIntValue = Integer.getInteger("rx2.purge-period-seconds", 1).intValue();
        }
        a = iIntValue;
        b();
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (scheduledExecutorServiceNewScheduledThreadPool instanceof ScheduledThreadPoolExecutor) {
            c.put((ScheduledThreadPoolExecutor) scheduledExecutorServiceNewScheduledThreadPool, scheduledExecutorServiceNewScheduledThreadPool);
        }
        return scheduledExecutorServiceNewScheduledThreadPool;
    }

    public static void b() {
        while (true) {
            ScheduledExecutorService scheduledExecutorService = b.get();
            if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
                return;
            }
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new e("RxSchedulerPurge"));
            if (b.compareAndSet(scheduledExecutorService, scheduledExecutorServiceNewScheduledThreadPool)) {
                a aVar = new a();
                int i = a;
                scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(aVar, i, i, TimeUnit.SECONDS);
                return;
            }
            scheduledExecutorServiceNewScheduledThreadPool.shutdownNow();
        }
    }
}
