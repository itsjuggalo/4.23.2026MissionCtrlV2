package com.google.android.play.core.integrity;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivity;
import n6.t0;
import n6.v0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class as extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final TaskCompletionSource f5923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final n6.f f5924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final v0 f5925c = new v0("RequestDialogCallbackImpl");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f5926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final k f5927e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Activity f5928f;

    public as(Context context, k kVar, Activity activity, TaskCompletionSource taskCompletionSource, n6.f fVar) {
        this.f5926d = context.getPackageName();
        this.f5927e = kVar;
        this.f5923a = taskCompletionSource;
        this.f5928f = activity;
        this.f5924b = fVar;
    }

    @Override // n6.u0
    public final void b(Bundle bundle) {
        this.f5924b.v(this.f5923a);
        this.f5925c.d("onRequestDialog(%s)", this.f5926d);
        com.google.android.gms.common.api.b bVarA = this.f5927e.a(bundle);
        if (bVarA != null) {
            this.f5923a.trySetException(bVarA);
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("dialog.intent");
        if (pendingIntent == null) {
            this.f5925c.b("onRequestDialog(%s): got null dialog intent", this.f5926d);
            this.f5923a.trySetResult(0);
            return;
        }
        Intent intent = new Intent(this.f5928f, (Class<?>) PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", pendingIntent);
        intent.setFlags(536870912);
        intent.putExtra(ProxyAmazonBillingActivity.EXTRAS_RESULT_RECEIVER, new ar(this, this.f5924b.c()));
        this.f5925c.a("Starting dialog intent...", new Object[0]);
        this.f5928f.startActivityForResult(intent, 0);
    }
}
