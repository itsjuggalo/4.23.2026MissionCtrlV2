package d3;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zzc;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class o0 extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f7729a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(d dVar, Handler handler, m mVar) {
        super(handler);
        this.f7729a = mVar;
        Objects.requireNonNull(dVar);
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i10, Bundle bundle) {
        this.f7729a.a(zzc.zzi(bundle, "BillingClient"));
    }
}
