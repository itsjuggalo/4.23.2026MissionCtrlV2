package m1;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: m1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1604c extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f13535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f13536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CountDownLatch f13537c = new CountDownLatch(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13538d = false;

    public C1604c(C1602a c1602a, long j4) {
        this.f13535a = new WeakReference(c1602a);
        this.f13536b = j4;
        start();
    }

    public final void a() {
        C1602a c1602a = (C1602a) this.f13535a.get();
        if (c1602a != null) {
            c1602a.c();
            this.f13538d = true;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            if (this.f13537c.await(this.f13536b, TimeUnit.MILLISECONDS)) {
                return;
            }
            a();
        } catch (InterruptedException unused) {
            a();
        }
    }
}
