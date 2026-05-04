package d3;

import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.zzbt;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzie;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f7722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f7724c;

    public n0(d dVar, r rVar, String str, boolean z10) {
        this.f7722a = rVar;
        this.f7723b = str;
        Objects.requireNonNull(dVar);
        this.f7724c = dVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        d dVar = this.f7724c;
        if (!dVar.P(HTTPTimeoutManager.DEFAULT_TIMEOUT_MS)) {
            zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
            com.android.billingclient.api.a aVar = com.android.billingclient.api.c.f5156j;
            dVar.t0(zzieVar, 9, aVar);
            this.f7722a.a(aVar, zzbt.zzk());
            return null;
        }
        String str = this.f7723b;
        if (TextUtils.isEmpty(str)) {
            zzc.zzn("BillingClient", "Please provide a valid product type.");
            zzie zzieVar2 = zzie.EMPTY_PRODUCT_TYPE;
            com.android.billingclient.api.a aVar2 = com.android.billingclient.api.c.f5151e;
            dVar.t0(zzieVar2, 9, aVar2);
            this.f7722a.a(aVar2, zzbt.zzk());
            return null;
        }
        d2 d2VarR0 = dVar.r0(str, false, 9);
        if (d2VarR0.b() != null) {
            this.f7722a.a(d2VarR0.a(), d2VarR0.b());
            return null;
        }
        this.f7722a.a(d2VarR0.a(), zzbt.zzk());
        return null;
    }
}
