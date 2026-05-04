package x4;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f24204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f24205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CountDownLatch f24206c = new CountDownLatch(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f24207d = false;

    public c(a aVar, long j10) {
        this.f24204a = new WeakReference(aVar);
        this.f24205b = j10;
        start();
    }

    public final void a() {
        a aVar = (a) this.f24204a.get();
        if (aVar != null) {
            aVar.c();
            this.f24207d = true;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            if (this.f24206c.await(this.f24205b, TimeUnit.MILLISECONDS)) {
                return;
            }
            a();
        } catch (InterruptedException unused) {
            a();
        }
    }
}
