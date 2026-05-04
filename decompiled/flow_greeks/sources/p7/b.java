package p7;

import android.os.Process;
import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b implements ThreadFactory {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ThreadFactory f18355e = Executors.defaultThreadFactory();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f18356a = new AtomicLong();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StrictMode.ThreadPolicy f18359d;

    public b(String str, int i10, StrictMode.ThreadPolicy threadPolicy) {
        this.f18357b = str;
        this.f18358c = i10;
        this.f18359d = threadPolicy;
    }

    public static /* synthetic */ void a(b bVar, Runnable runnable) {
        Process.setThreadPriority(bVar.f18358c);
        StrictMode.ThreadPolicy threadPolicy = bVar.f18359d;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        runnable.run();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        Thread threadNewThread = f18355e.newThread(new Runnable() { // from class: p7.a
            @Override // java.lang.Runnable
            public final void run() {
                b.a(this.f18350a, runnable);
            }
        });
        threadNewThread.setName(String.format(Locale.ROOT, "%s Thread #%d", this.f18357b, Long.valueOf(this.f18356a.getAndIncrement())));
        return threadNewThread;
    }
}
