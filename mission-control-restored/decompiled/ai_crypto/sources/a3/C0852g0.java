package a3;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.api.internal.ComponentCallbacks2C1166c;
import com.google.android.gms.internal.p002firebaseauthapi.zzahn;

/* JADX INFO: renamed from: a3.g0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0852g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f6217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0877t f6218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f6219c;

    public C0852g0(Q2.g gVar) {
        this(gVar.m(), new C0877t(gVar));
    }

    public final void b() {
        this.f6218b.b();
    }

    public final void c(int i7) {
        if (i7 > 0 && this.f6217a == 0) {
            this.f6217a = i7;
            if (f()) {
                this.f6218b.c();
            }
        } else if (i7 == 0 && this.f6217a != 0) {
            this.f6218b.b();
        }
        this.f6217a = i7;
    }

    public final void e(zzahn zzahnVar) {
        if (zzahnVar == null) {
            return;
        }
        long jZza = zzahnVar.zza();
        if (jZza <= 0) {
            jZza = 3600;
        }
        long jZzb = zzahnVar.zzb() + (jZza * 1000);
        C0877t c0877t = this.f6218b;
        c0877t.f6278b = jZzb;
        c0877t.f6279c = -1L;
        if (f()) {
            this.f6218b.c();
        }
    }

    public final boolean f() {
        return this.f6217a > 0 && !this.f6219c;
    }

    public C0852g0(Context context, C0877t c0877t) {
        this.f6219c = false;
        this.f6217a = 0;
        this.f6218b = c0877t;
        ComponentCallbacks2C1166c.c((Application) context.getApplicationContext());
        ComponentCallbacks2C1166c.b().a(new C0858j0(this));
    }
}
