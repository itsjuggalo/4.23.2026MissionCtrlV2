package Y0;

import com.google.android.gms.internal.play_billing.zze;
import com.google.android.gms.internal.play_billing.zzej;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public final class X implements zzej {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Consumer f5580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f5581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.android.billingclient.api.j f5582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f5583d;

    public X(com.android.billingclient.api.j jVar, int i7, Consumer consumer, Runnable runnable) {
        this.f5583d = i7;
        this.f5580a = consumer;
        this.f5581b = runnable;
        this.f5582c = jVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzej
    public final void zza(Throwable th) {
        if (th instanceof TimeoutException) {
            this.f5582c.o1(114, 28, com.android.billingclient.api.k.f10681G);
            zze.zzm("BillingClientTesting", "Asynchronous call to Billing Override Service timed out.", th);
        } else {
            this.f5582c.o1(107, 28, com.android.billingclient.api.k.f10681G);
            zze.zzm("BillingClientTesting", "An error occurred while retrieving billing override.", th);
        }
        this.f5581b.run();
    }

    @Override // com.google.android.gms.internal.play_billing.zzej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Integer num = (Integer) obj;
        int iIntValue = num.intValue();
        com.android.billingclient.api.j jVar = this.f5582c;
        if (!com.android.billingclient.api.j.l1(iIntValue)) {
            this.f5581b.run();
        } else {
            this.f5580a.accept(jVar.m1(this.f5583d, num.intValue()));
        }
    }
}
