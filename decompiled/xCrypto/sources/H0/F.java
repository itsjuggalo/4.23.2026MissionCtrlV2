package H0;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zze;

/* JADX INFO: loaded from: classes.dex */
public final class F extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0308j f620a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F(com.android.billingclient.api.b bVar, Handler handler, InterfaceC0308j interfaceC0308j) {
        super(handler);
        this.f620a = interfaceC0308j;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i4, Bundle bundle) {
        this.f620a.a(zze.zzg(bundle, "BillingClient"));
    }
}
