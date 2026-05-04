package n7;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.internal.p002firebaseauthapi.zzahv;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f16758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f16759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f16760c;

    public f1(a7.g gVar) {
        this(gVar.m(), new t(gVar));
    }

    public final void b() {
        this.f16759b.b();
    }

    public final void c(int i10) {
        if (i10 > 0 && this.f16758a == 0) {
            this.f16758a = i10;
            if (f()) {
                this.f16759b.c();
            }
        } else if (i10 == 0 && this.f16758a != 0) {
            this.f16759b.b();
        }
        this.f16758a = i10;
    }

    public final void d(zzahv zzahvVar) {
        if (zzahvVar == null) {
            return;
        }
        long jZza = zzahvVar.zza();
        if (jZza <= 0) {
            jZza = 3600;
        }
        long jZzb = zzahvVar.zzb() + (jZza * 1000);
        t tVar = this.f16759b;
        tVar.f16851b = jZzb;
        tVar.f16852c = -1L;
        if (f()) {
            this.f16759b.c();
        }
    }

    public final boolean f() {
        return this.f16758a > 0 && !this.f16760c;
    }

    public f1(Context context, t tVar) {
        this.f16760c = false;
        this.f16758a = 0;
        this.f16759b = tVar;
        com.google.android.gms.common.api.internal.c.c((Application) context.getApplicationContext());
        com.google.android.gms.common.api.internal.c.b().a(new i1(this));
    }
}
