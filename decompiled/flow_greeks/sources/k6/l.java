package k6;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends k {
    public l(m mVar, TaskCompletionSource taskCompletionSource, String str) {
        super(mVar, new l6.i("OnRequestInstallCallback"), taskCompletionSource);
    }

    @Override // k6.k, l6.h
    public final void zzb(Bundle bundle) {
        super.zzb(bundle);
        this.f14740b.trySetResult(new e((PendingIntent) bundle.get("confirmation_intent"), bundle.getBoolean("is_review_no_op")));
    }
}
