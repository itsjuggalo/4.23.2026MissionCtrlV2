package d3;

import android.content.Context;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzji;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f7800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i4.i f7801b;

    public u1(Context context) {
        try {
            l4.u.f(context);
            this.f7801b = l4.u.c().g(j4.a.f13880g).b("PLAY_BILLING_LIBRARY", zzji.class, i4.c.b("proto"), new i4.h() { // from class: d3.t1
                @Override // i4.h
                public final Object apply(Object obj) {
                    return ((zzji) obj).zzM();
                }
            });
        } catch (Throwable unused) {
            this.f7800a = true;
        }
    }

    public final void a(zzji zzjiVar) {
        if (this.f7800a) {
            zzc.zzn("BillingLogger", "Skipping logging since initialization failed.");
            return;
        }
        try {
            this.f7801b.a(i4.d.f(zzjiVar));
        } catch (Throwable unused) {
            zzc.zzn("BillingLogger", "logging failed.");
        }
    }
}
