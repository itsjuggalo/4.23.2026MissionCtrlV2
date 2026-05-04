package d3;

import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzcs;
import com.google.android.gms.internal.play_billing.zzie;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i1 implements zzcs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s0.a f7685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f7686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m1 f7687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7688d;

    public i1(m1 m1Var, int i10, s0.a aVar, Runnable runnable) {
        this.f7688d = i10;
        this.f7685a = aVar;
        this.f7686b = runnable;
        Objects.requireNonNull(m1Var);
        this.f7687c = m1Var;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcs
    public final void zza(Throwable th) {
        if (th instanceof TimeoutException) {
            this.f7687c.b1(zzie.BILLING_OVERRIDE_SERVICE_CALL_TIMEOUT, 28, com.android.billingclient.api.c.F);
            zzc.zzo("BillingClientTesting", "Asynchronous call to Billing Override Service timed out.", th);
        } else {
            this.f7687c.b1(zzie.BILLING_OVERRIDE_SERVICE_CALL_EXCEPTION, 28, com.android.billingclient.api.c.F);
            zzc.zzo("BillingClientTesting", "An error occurred while retrieving billing override.", th);
        }
        this.f7686b.run();
    }

    @Override // com.google.android.gms.internal.play_billing.zzcs
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Integer num = (Integer) obj;
        int iIntValue = num.intValue();
        m1 m1Var = this.f7687c;
        if (!m1.Y0(iIntValue)) {
            this.f7686b.run();
        } else {
            this.f7685a.accept(m1Var.Z0(this.f7688d, num.intValue()));
        }
    }
}
