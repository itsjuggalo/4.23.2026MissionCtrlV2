package f3;

import android.os.Bundle;
import e3.C1478g;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: f3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1603c implements InterfaceC1602b, InterfaceC1601a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1605e f14111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f14113c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CountDownLatch f14115e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f14114d = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f14116f = false;

    public C1603c(C1605e c1605e, int i7, TimeUnit timeUnit) {
        this.f14111a = c1605e;
        this.f14112b = i7;
        this.f14113c = timeUnit;
    }

    @Override // f3.InterfaceC1601a
    public void a(String str, Bundle bundle) {
        synchronized (this.f14114d) {
            try {
                C1478g.f().i("Logging event " + str + " to Firebase Analytics with params " + bundle);
                this.f14115e = new CountDownLatch(1);
                this.f14116f = false;
                this.f14111a.a(str, bundle);
                C1478g.f().i("Awaiting app exception callback from Analytics...");
                try {
                    if (this.f14115e.await(this.f14112b, this.f14113c)) {
                        this.f14116f = true;
                        C1478g.f().i("App exception callback received from Analytics listener.");
                    } else {
                        C1478g.f().k("Timeout exceeded while awaiting app exception callback from Analytics listener.");
                    }
                } catch (InterruptedException unused) {
                    C1478g.f().d("Interrupted while awaiting app exception callback from Analytics listener.");
                }
                this.f14115e = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // f3.InterfaceC1602b
    public void b(String str, Bundle bundle) {
        CountDownLatch countDownLatch = this.f14115e;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
