package D1;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class c extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f1108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CountDownLatch f1110c = new CountDownLatch(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1111d = false;

    public c(a aVar, long j7) {
        this.f1108a = new WeakReference(aVar);
        this.f1109b = j7;
        start();
    }

    public final void a() {
        a aVar = (a) this.f1108a.get();
        if (aVar != null) {
            aVar.c();
            this.f1111d = true;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            if (this.f1110c.await(this.f1109b, TimeUnit.MILLISECONDS)) {
                return;
            }
            a();
        } catch (InterruptedException unused) {
            a();
        }
    }
}
