package l2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class s implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CountDownLatch f20579a = new CountDownLatch(1);

    public /* synthetic */ s(r rVar) {
    }

    @Override // l2.InterfaceC2321e
    public final void a() {
        this.f20579a.countDown();
    }

    public final void b() throws InterruptedException {
        this.f20579a.await();
    }

    public final boolean c(long j8, TimeUnit timeUnit) {
        return this.f20579a.await(j8, timeUnit);
    }

    @Override // l2.InterfaceC2323g
    public final void onFailure(Exception exc) {
        this.f20579a.countDown();
    }

    @Override // l2.InterfaceC2324h
    public final void onSuccess(Object obj) {
        this.f20579a.countDown();
    }
}
