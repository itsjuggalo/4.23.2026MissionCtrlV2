package d3;

import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzp;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s0 implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzp f7786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f7787b;

    public s0(d dVar, zzp zzpVar) {
        this.f7786a = zzpVar;
        Objects.requireNonNull(dVar);
        this.f7787b = dVar;
    }

    @Override // d3.e
    public final void onBillingServiceDisconnected() {
        zzc.zzm("BillingClient", "Reconnection attempt failed.");
        try {
            this.f7786a.zzb(com.android.billingclient.api.c.f5156j);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Exception setting completer.", th);
        }
        d dVar = this.f7787b;
        if (dVar.G != null) {
            dVar.Y(new Runnable() { // from class: d3.q0
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        this.f7783a.f7787b.G.onBillingServiceDisconnected();
                    } catch (Throwable th2) {
                        zzc.zzo("BillingClient", "Exception calling onBillingServiceDisconnected.", th2);
                    }
                }
            });
        }
    }

    @Override // d3.e
    public final void onBillingSetupFinished(final com.android.billingclient.api.a aVar) {
        zzc.zzm("BillingClient", "Reconnection finished with result: " + aVar.c());
        try {
            this.f7786a.zzb(aVar);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Exception setting completer.", th);
        }
        d dVar = this.f7787b;
        if (dVar.G != null) {
            dVar.Y(new Runnable() { // from class: d3.r0
                @Override // java.lang.Runnable
                public final void run() {
                    s0 s0Var = this.f7784a;
                    try {
                        s0Var.f7787b.G.onBillingSetupFinished(aVar);
                    } catch (Throwable th2) {
                        zzc.zzo("BillingClient", "Exception calling onBillingSetupFinished.", th2);
                    }
                }
            });
        }
    }
}
