package R0;

import android.content.Context;
import com.google.android.gms.internal.play_billing.w3;
import w1.AbstractC2901d;
import w1.C2900c;
import w1.InterfaceC2905h;
import w1.InterfaceC2906i;
import x1.C2952a;

/* JADX INFO: loaded from: classes.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f7083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC2906i f7084b;

    public w0(Context context) {
        try {
            z1.u.f(context);
            this.f7084b = z1.u.c().g(C2952a.f24150g).b("PLAY_BILLING_LIBRARY", w3.class, C2900c.b("proto"), new InterfaceC2905h() { // from class: R0.v0
                @Override // w1.InterfaceC2905h
                public final Object apply(Object obj) {
                    return ((w3) obj).a();
                }
            });
        } catch (Throwable unused) {
            this.f7083a = true;
        }
    }

    public final void a(w3 w3Var) {
        String str;
        if (this.f7083a) {
            str = "Skipping logging since initialization failed.";
        } else {
            try {
                this.f7084b.b(AbstractC2901d.f(w3Var));
                return;
            } catch (Throwable unused) {
                str = "logging failed.";
            }
        }
        com.google.android.gms.internal.play_billing.V.m("BillingLogger", str);
    }
}
