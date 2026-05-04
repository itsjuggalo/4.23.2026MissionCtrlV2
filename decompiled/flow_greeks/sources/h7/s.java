package h7;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.api.internal.c;
import i7.a;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f11098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i7.a f11099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f11100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f11101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f11102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f11103f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f11104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i7.a f11105b;

        public a(m mVar, i7.a aVar) {
            this.f11104a = mVar;
            this.f11105b = aVar;
        }

        @Override // com.google.android.gms.common.api.internal.c.a
        public void a(boolean z10) {
            s.this.f11100c = z10;
            if (z10) {
                this.f11104a.c();
            } else if (s.this.g()) {
                this.f11104a.f(s.this.f11102e - this.f11105b.a());
            }
        }
    }

    public s(Context context, j jVar, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this((Context) com.google.android.gms.common.internal.s.k(context), new m((j) com.google.android.gms.common.internal.s.k(jVar), executor, scheduledExecutorService), new a.C0224a());
    }

    public void d(e7.c cVar) {
        b bVarD = cVar instanceof b ? (b) cVar : b.d(cVar.b());
        this.f11102e = bVarD.h() + ((long) (bVarD.f() * 0.5d)) + 300000;
        if (this.f11102e > bVarD.a()) {
            this.f11102e = bVarD.a() - 60000;
        }
        if (g()) {
            this.f11098a.f(this.f11102e - this.f11099b.a());
        }
    }

    public void e(int i10) {
        if (this.f11101d == 0 && i10 > 0) {
            this.f11101d = i10;
            if (g()) {
                this.f11098a.f(this.f11102e - this.f11099b.a());
            }
        } else if (this.f11101d > 0 && i10 == 0) {
            this.f11098a.c();
        }
        this.f11101d = i10;
    }

    public void f(boolean z10) {
        this.f11103f = z10;
    }

    public final boolean g() {
        return this.f11103f && !this.f11100c && this.f11101d > 0 && this.f11102e != -1;
    }

    public s(Context context, m mVar, i7.a aVar) {
        this.f11098a = mVar;
        this.f11099b = aVar;
        this.f11102e = -1L;
        com.google.android.gms.common.api.internal.c.c((Application) context.getApplicationContext());
        com.google.android.gms.common.api.internal.c.b().a(new a(mVar, aVar));
    }
}
