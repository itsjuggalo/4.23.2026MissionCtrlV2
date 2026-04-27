package q;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: q.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2547d extends AbstractC2548e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f22103a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f22104b = Executors.newFixedThreadPool(4, new a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Handler f22105c;

    /* JADX INFO: renamed from: q.d$a */
    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f22106a = new AtomicInteger(0);

        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("arch_disk_io_" + this.f22106a.getAndIncrement());
            return thread;
        }
    }

    /* JADX INFO: renamed from: q.d$b */
    public static class b {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public static Handler d(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return b.a(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }

    @Override // q.AbstractC2548e
    public void a(Runnable runnable) {
        this.f22104b.execute(runnable);
    }

    @Override // q.AbstractC2548e
    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override // q.AbstractC2548e
    public void c(Runnable runnable) {
        if (this.f22105c == null) {
            synchronized (this.f22103a) {
                try {
                    if (this.f22105c == null) {
                        this.f22105c = d(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        this.f22105c.post(runnable);
    }
}
