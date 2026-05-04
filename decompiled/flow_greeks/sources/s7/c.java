package s7;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import r7.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c implements b, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f20053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f20055c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CountDownLatch f20057e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f20056d = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f20058f = false;

    public c(e eVar, int i10, TimeUnit timeUnit) {
        this.f20053a = eVar;
        this.f20054b = i10;
        this.f20055c = timeUnit;
    }

    @Override // s7.a
    public void a(String str, Bundle bundle) {
        synchronized (this.f20056d) {
            try {
                g.f().i("Logging event " + str + " to Firebase Analytics with params " + bundle);
                this.f20057e = new CountDownLatch(1);
                this.f20058f = false;
                this.f20053a.a(str, bundle);
                g.f().i("Awaiting app exception callback from Analytics...");
                try {
                    if (this.f20057e.await(this.f20054b, this.f20055c)) {
                        this.f20058f = true;
                        g.f().i("App exception callback received from Analytics listener.");
                    } else {
                        g.f().k("Timeout exceeded while awaiting app exception callback from Analytics listener.");
                    }
                } catch (InterruptedException unused) {
                    g.f().d("Interrupted while awaiting app exception callback from Analytics listener.");
                }
                this.f20057e = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // s7.b
    public void b(String str, Bundle bundle) {
        CountDownLatch countDownLatch = this.f20057e;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
