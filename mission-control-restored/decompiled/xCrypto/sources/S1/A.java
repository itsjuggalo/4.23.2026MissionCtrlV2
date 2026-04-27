package S1;

import android.os.Handler;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.measurement.zzcn;

/* JADX INFO: loaded from: classes.dex */
public abstract class A {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Handler f3831d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V3 f3832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Runnable f3833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f3834c;

    public A(V3 v32) {
        AbstractC0940s.k(v32);
        this.f3832a = v32;
        this.f3833b = new RunnableC0725z(this, v32);
    }

    public abstract void a();

    public final void b(long j4) {
        d();
        if (j4 >= 0) {
            V3 v32 = this.f3832a;
            this.f3834c = v32.f().currentTimeMillis();
            if (f().postDelayed(this.f3833b, j4)) {
                return;
            }
            v32.a().o().b("Failed to schedule delayed post. time", Long.valueOf(j4));
        }
    }

    public final boolean c() {
        return this.f3834c != 0;
    }

    public final void d() {
        this.f3834c = 0L;
        f().removeCallbacks(this.f3833b);
    }

    public final /* synthetic */ void e(long j4) {
        this.f3834c = 0L;
    }

    public final Handler f() {
        Handler handler;
        if (f3831d != null) {
            return f3831d;
        }
        synchronized (A.class) {
            try {
                if (f3831d == null) {
                    f3831d = new zzcn(this.f3832a.e().getMainLooper());
                }
                handler = f3831d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }
}
