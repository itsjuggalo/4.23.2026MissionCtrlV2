package Y0;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.android.billingclient.api.ProxyBillingActivity;
import com.google.android.gms.internal.play_billing.zzao;
import com.google.android.gms.internal.play_billing.zze;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public final class J extends zzao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f5554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ResultReceiver f5555b;

    public /* synthetic */ J(WeakReference weakReference, ResultReceiver resultReceiver, M m7) {
        this.f5554a = weakReference;
        this.f5555b = resultReceiver;
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    public final void zza(Bundle bundle) {
        ResultReceiver resultReceiver = this.f5555b;
        if (resultReceiver == null) {
            zze.zzl("BillingClient", "Unable to send result for in-app messaging");
            return;
        }
        if (bundle == null) {
            resultReceiver.send(0, null);
            return;
        }
        Activity activity = (Activity) this.f5554a.get();
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("KEY_LAUNCH_INTENT");
        if (activity == null || pendingIntent == null) {
            this.f5555b.send(0, null);
            zze.zzl("BillingClient", "Unable to launch intent for in-app messaging");
            return;
        }
        try {
            Intent intent = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
            intent.putExtra("in_app_message_result_receiver", this.f5555b);
            intent.putExtra("IN_APP_MESSAGE_INTENT", pendingIntent);
            activity.startActivity(intent);
        } catch (CancellationException e7) {
            this.f5555b.send(0, null);
            zze.zzm("BillingClient", "Exception caught while launching intent for in-app messaging.", e7);
        }
    }
}
