package k4;

import Z3.p;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: renamed from: k4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0776b implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f7882a;

    public C0776b(CountDownLatch countDownLatch) {
        this.f7882a = countDownLatch;
    }

    @Override // Z3.p
    public final void a(Object obj, String str, String str2) {
        this.f7882a.countDown();
    }

    @Override // Z3.p
    public final void b() {
        this.f7882a.countDown();
    }

    @Override // Z3.p
    public final void c(Object obj) {
        this.f7882a.countDown();
    }
}
