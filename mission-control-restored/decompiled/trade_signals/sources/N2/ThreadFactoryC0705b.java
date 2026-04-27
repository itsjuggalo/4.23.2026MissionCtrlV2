package N2;

import android.os.Process;
import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: N2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class ThreadFactoryC0705b implements ThreadFactory {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ThreadFactory f5484e = Executors.defaultThreadFactory();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f5485a = new AtomicLong();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StrictMode.ThreadPolicy f5488d;

    public ThreadFactoryC0705b(String str, int i8, StrictMode.ThreadPolicy threadPolicy) {
        this.f5486b = str;
        this.f5487c = i8;
        this.f5488d = threadPolicy;
    }

    public final /* synthetic */ void b(Runnable runnable) {
        Process.setThreadPriority(this.f5487c);
        StrictMode.ThreadPolicy threadPolicy = this.f5488d;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        runnable.run();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        Thread threadNewThread = f5484e.newThread(new Runnable() { // from class: N2.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f5482a.b(runnable);
            }
        });
        threadNewThread.setName(String.format(Locale.ROOT, "%s Thread #%d", this.f5486b, Long.valueOf(this.f5485a.getAndIncrement())));
        return threadNewThread;
    }
}
