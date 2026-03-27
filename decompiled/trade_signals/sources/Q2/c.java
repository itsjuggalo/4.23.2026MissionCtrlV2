package Q2;

import P2.g;
import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class c implements b, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f6718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f6720c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CountDownLatch f6722e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f6721d = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f6723f = false;

    public c(e eVar, int i8, TimeUnit timeUnit) {
        this.f6718a = eVar;
        this.f6719b = i8;
        this.f6720c = timeUnit;
    }

    @Override // Q2.a
    public void a(String str, Bundle bundle) {
        synchronized (this.f6721d) {
            try {
                g.f().i("Logging event " + str + " to Firebase Analytics with params " + bundle);
                this.f6722e = new CountDownLatch(1);
                this.f6723f = false;
                this.f6718a.a(str, bundle);
                g.f().i("Awaiting app exception callback from Analytics...");
                try {
                    if (this.f6722e.await(this.f6719b, this.f6720c)) {
                        this.f6723f = true;
                        g.f().i("App exception callback received from Analytics listener.");
                    } else {
                        g.f().k("Timeout exceeded while awaiting app exception callback from Analytics listener.");
                    }
                } catch (InterruptedException unused) {
                    g.f().d("Interrupted while awaiting app exception callback from Analytics listener.");
                }
                this.f6722e = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // Q2.b
    public void b(String str, Bundle bundle) {
        CountDownLatch countDownLatch = this.f6722e;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
