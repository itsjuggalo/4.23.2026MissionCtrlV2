package g5;

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

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f18281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f18282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference f18283c = new AtomicReference();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f18284d = new ConcurrentHashMap();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f18285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f18286b;

        public void a(Properties properties) {
            if (properties.containsKey("rx2.purge-enabled")) {
                this.f18285a = Boolean.parseBoolean(properties.getProperty("rx2.purge-enabled"));
            } else {
                this.f18285a = true;
            }
            if (this.f18285a && properties.containsKey("rx2.purge-period-seconds")) {
                try {
                    this.f18286b = Integer.parseInt(properties.getProperty("rx2.purge-period-seconds"));
                    return;
                } catch (NumberFormatException unused) {
                }
            }
            this.f18286b = 1;
        }
    }

    public static final class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            for (ScheduledThreadPoolExecutor scheduledThreadPoolExecutor : new ArrayList(i.f18284d.keySet())) {
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    i.f18284d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    static {
        Properties properties = System.getProperties();
        a aVar = new a();
        aVar.a(properties);
        f18281a = aVar.f18285a;
        f18282b = aVar.f18286b;
        b();
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        c(f18281a, scheduledExecutorServiceNewScheduledThreadPool);
        return scheduledExecutorServiceNewScheduledThreadPool;
    }

    public static void b() {
        d(f18281a);
    }

    public static void c(boolean z7, ScheduledExecutorService scheduledExecutorService) {
        if (z7 && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f18284d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    public static void d(boolean z7) {
        if (!z7) {
            return;
        }
        while (true) {
            AtomicReference atomicReference = f18283c;
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) atomicReference.get();
            if (scheduledExecutorService != null) {
                return;
            }
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new f("RxSchedulerPurge"));
            if (com.amazon.a.a.l.d.a(atomicReference, scheduledExecutorService, scheduledExecutorServiceNewScheduledThreadPool)) {
                b bVar = new b();
                int i8 = f18282b;
                scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(bVar, i8, i8, TimeUnit.SECONDS);
                return;
            }
            scheduledExecutorServiceNewScheduledThreadPool.shutdownNow();
        }
    }
}
