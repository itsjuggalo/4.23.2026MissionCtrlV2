package H0;

import android.content.Context;
import com.google.android.gms.internal.play_billing.zze;
import com.google.android.gms.internal.play_billing.zzlk;

/* JADX INFO: loaded from: classes.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public X0.i f673b;

    public k0(Context context) {
        try {
            a1.u.f(context);
            this.f673b = a1.u.c().g(Y0.a.f5654g).a("PLAY_BILLING_LIBRARY", zzlk.class, X0.c.b("proto"), new X0.h() { // from class: H0.j0
                @Override // X0.h
                public final Object apply(Object obj) {
                    return ((zzlk) obj).zzh();
                }
            });
        } catch (Throwable unused) {
            this.f672a = true;
        }
    }

    public final void a(zzlk zzlkVar) {
        if (this.f672a) {
            zze.zzl("BillingLogger", "Skipping logging since initialization failed.");
            return;
        }
        try {
            this.f673b.a(X0.d.f(zzlkVar));
        } catch (Throwable unused) {
            zze.zzl("BillingLogger", "logging failed.");
        }
    }
}
