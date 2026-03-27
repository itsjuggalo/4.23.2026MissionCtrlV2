package R0;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.android.billingclient.api.ProxyBillingActivity;
import com.google.android.gms.internal.play_billing.AbstractBinderC1336g;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public final class Y extends AbstractBinderC1336g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f6904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ResultReceiver f6905b;

    public /* synthetic */ Y(WeakReference weakReference, ResultReceiver resultReceiver, AbstractC0803a0 abstractC0803a0) {
        this.f6904a = weakReference;
        this.f6905b = resultReceiver;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1341h
    public final void a(Bundle bundle) {
        ResultReceiver resultReceiver = this.f6905b;
        if (resultReceiver == null) {
            com.google.android.gms.internal.play_billing.V.m("BillingClient", "Unable to send result for in-app messaging");
            return;
        }
        if (bundle == null) {
            resultReceiver.send(0, null);
            return;
        }
        Activity activity = (Activity) this.f6904a.get();
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("KEY_LAUNCH_INTENT");
        if (activity == null || pendingIntent == null) {
            resultReceiver.send(0, null);
            com.google.android.gms.internal.play_billing.V.m("BillingClient", "Unable to launch intent for in-app messaging");
            return;
        }
        try {
            Intent intent = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
            intent.putExtra("in_app_message_result_receiver", resultReceiver);
            intent.putExtra("IN_APP_MESSAGE_INTENT", pendingIntent);
            activity.startActivity(intent);
        } catch (CancellationException e8) {
            this.f6905b.send(0, null);
            com.google.android.gms.internal.play_billing.V.n("BillingClient", "Exception caught while launching intent for in-app messaging.", e8);
        }
    }
}
