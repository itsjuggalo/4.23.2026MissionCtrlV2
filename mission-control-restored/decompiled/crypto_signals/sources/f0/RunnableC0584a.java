package f0;

import N1.CallableC0112m0;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;
import s1.C0987d;

/* JADX INFO: renamed from: f0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0584a implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Handler f6392f;
    public final /* synthetic */ C0987d e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f6394b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f6395c = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f6396d = new AtomicBoolean();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f6393a = new b(this, new CallableC0112m0(this, 3));

    public RunnableC0584a(C0987d c0987d) {
        this.e = c0987d;
    }

    public final void a(Object obj) {
        Handler handler;
        synchronized (RunnableC0584a.class) {
            try {
                if (f6392f == null) {
                    f6392f = new Handler(Looper.getMainLooper());
                }
                handler = f6392f;
            } catch (Throwable th) {
                throw th;
            }
        }
        handler.post(new A.a(this, obj, 21, false));
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.e.b();
    }
}
