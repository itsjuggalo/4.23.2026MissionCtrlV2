package c3;

import android.os.Process;
import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: c3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class ThreadFactoryC1133b implements ThreadFactory {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ThreadFactory f9363e = Executors.defaultThreadFactory();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f9364a = new AtomicLong();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StrictMode.ThreadPolicy f9367d;

    public ThreadFactoryC1133b(String str, int i7, StrictMode.ThreadPolicy threadPolicy) {
        this.f9365b = str;
        this.f9366c = i7;
        this.f9367d = threadPolicy;
    }

    public final /* synthetic */ void b(Runnable runnable) {
        Process.setThreadPriority(this.f9366c);
        StrictMode.ThreadPolicy threadPolicy = this.f9367d;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        runnable.run();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        Thread threadNewThread = f9363e.newThread(new Runnable() { // from class: c3.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f9361a.b(runnable);
            }
        });
        threadNewThread.setName(String.format(Locale.ROOT, "%s Thread #%d", this.f9365b, Long.valueOf(this.f9364a.getAndIncrement())));
        return threadNewThread;
    }
}
