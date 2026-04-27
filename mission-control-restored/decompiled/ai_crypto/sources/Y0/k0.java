package Y0;

import android.content.Context;
import com.google.android.gms.internal.play_billing.zze;
import com.google.android.gms.internal.play_billing.zzlk;
import o1.AbstractC2292d;
import o1.C2291c;
import o1.InterfaceC2296h;
import o1.InterfaceC2297i;
import p1.C2366a;

/* JADX INFO: loaded from: classes.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC2297i f5600b;

    public k0(Context context) {
        try {
            r1.u.f(context);
            this.f5600b = r1.u.c().g(C2366a.f21454g).a("PLAY_BILLING_LIBRARY", zzlk.class, C2291c.b("proto"), new InterfaceC2296h() { // from class: Y0.j0
                @Override // o1.InterfaceC2296h
                public final Object apply(Object obj) {
                    return ((zzlk) obj).zzh();
                }
            });
        } catch (Throwable unused) {
            this.f5599a = true;
        }
    }

    public final void a(zzlk zzlkVar) {
        if (this.f5599a) {
            zze.zzl("BillingLogger", "Skipping logging since initialization failed.");
            return;
        }
        try {
            this.f5600b.a(AbstractC2292d.f(zzlkVar));
        } catch (Throwable unused) {
            zze.zzl("BillingLogger", "logging failed.");
        }
    }
}
