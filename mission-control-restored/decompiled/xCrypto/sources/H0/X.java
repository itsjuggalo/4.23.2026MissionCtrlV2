package H0;

import com.google.android.gms.internal.play_billing.zze;
import com.google.android.gms.internal.play_billing.zzej;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public final class X implements zzej {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Consumer f653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.android.billingclient.api.j f655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f656d;

    public X(com.android.billingclient.api.j jVar, int i4, Consumer consumer, Runnable runnable) {
        this.f656d = i4;
        this.f653a = consumer;
        this.f654b = runnable;
        this.f655c = jVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzej
    public final void zza(Throwable th) {
        if (th instanceof TimeoutException) {
            this.f655c.o1(114, 28, com.android.billingclient.api.k.f9496G);
            zze.zzm("BillingClientTesting", "Asynchronous call to Billing Override Service timed out.", th);
        } else {
            this.f655c.o1(107, 28, com.android.billingclient.api.k.f9496G);
            zze.zzm("BillingClientTesting", "An error occurred while retrieving billing override.", th);
        }
        this.f654b.run();
    }

    @Override // com.google.android.gms.internal.play_billing.zzej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Integer num = (Integer) obj;
        int iIntValue = num.intValue();
        com.android.billingclient.api.j jVar = this.f655c;
        if (!com.android.billingclient.api.j.l1(iIntValue)) {
            this.f654b.run();
        } else {
            this.f653a.accept(jVar.m1(this.f656d, num.intValue()));
        }
    }
}
