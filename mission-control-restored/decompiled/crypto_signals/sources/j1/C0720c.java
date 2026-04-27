package j1;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: j1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0720c extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f7617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f7618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CountDownLatch f7619c = new CountDownLatch(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7620d = false;

    public C0720c(C0718a c0718a, long j4) {
        this.f7617a = new WeakReference(c0718a);
        this.f7618b = j4;
        start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        C0718a c0718a;
        WeakReference weakReference = this.f7617a;
        try {
            if (this.f7619c.await(this.f7618b, TimeUnit.MILLISECONDS) || (c0718a = (C0718a) weakReference.get()) == null) {
                return;
            }
            c0718a.b();
            this.f7620d = true;
        } catch (InterruptedException unused) {
            C0718a c0718a2 = (C0718a) weakReference.get();
            if (c0718a2 != null) {
                c0718a2.b();
                this.f7620d = true;
            }
        }
    }
}
