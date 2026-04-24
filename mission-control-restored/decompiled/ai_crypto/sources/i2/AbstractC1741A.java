package i2;

import android.os.Handler;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.measurement.zzcn;

/* JADX INFO: renamed from: i2.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1741A {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Handler f14990d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V3 f14991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Runnable f14992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f14993c;

    public AbstractC1741A(V3 v32) {
        AbstractC1207s.k(v32);
        this.f14991a = v32;
        this.f14992b = new RunnableC1966z(this, v32);
    }

    public abstract void a();

    public final void b(long j7) {
        d();
        if (j7 >= 0) {
            V3 v32 = this.f14991a;
            this.f14993c = v32.f().a();
            if (f().postDelayed(this.f14992b, j7)) {
                return;
            }
            v32.a().o().b("Failed to schedule delayed post. time", Long.valueOf(j7));
        }
    }

    public final boolean c() {
        return this.f14993c != 0;
    }

    public final void d() {
        this.f14993c = 0L;
        f().removeCallbacks(this.f14992b);
    }

    public final /* synthetic */ void e(long j7) {
        this.f14993c = 0L;
    }

    public final Handler f() {
        Handler handler;
        if (f14990d != null) {
            return f14990d;
        }
        synchronized (AbstractC1741A.class) {
            try {
                if (f14990d == null) {
                    f14990d = new zzcn(this.f14991a.e().getMainLooper());
                }
                handler = f14990d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }
}
