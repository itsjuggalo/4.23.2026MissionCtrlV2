package com.google.android.play.core.integrity;

import F2.C0468f;
import F2.E;
import F2.G;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivity;

/* JADX INFO: loaded from: classes.dex */
final class as extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final TaskCompletionSource f11889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final C0468f f11890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final G f11891c = new G("RequestDialogCallbackImpl");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f11892d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final k f11893e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Activity f11894f;

    public as(Context context, k kVar, Activity activity, TaskCompletionSource taskCompletionSource, C0468f c0468f) {
        this.f11892d = context.getPackageName();
        this.f11893e = kVar;
        this.f11889a = taskCompletionSource;
        this.f11894f = activity;
        this.f11890b = c0468f;
    }

    @Override // F2.F
    public final void b(Bundle bundle) {
        this.f11890b.v(this.f11889a);
        this.f11891c.d("onRequestDialog(%s)", this.f11892d);
        com.google.android.gms.common.api.b bVarA = this.f11893e.a(bundle);
        if (bVarA != null) {
            this.f11889a.trySetException(bVarA);
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("dialog.intent");
        if (pendingIntent == null) {
            this.f11891c.b("onRequestDialog(%s): got null dialog intent", this.f11892d);
            this.f11889a.trySetResult(0);
            return;
        }
        Intent intent = new Intent(this.f11894f, (Class<?>) PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", pendingIntent);
        intent.setFlags(536870912);
        intent.putExtra(ProxyAmazonBillingActivity.EXTRAS_RESULT_RECEIVER, new ar(this, this.f11890b.c()));
        this.f11891c.a("Starting dialog intent...", new Object[0]);
        this.f11894f.startActivityForResult(intent, 0);
    }
}
