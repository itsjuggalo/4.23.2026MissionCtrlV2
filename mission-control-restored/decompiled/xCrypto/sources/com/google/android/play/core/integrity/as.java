package com.google.android.play.core.integrity;

import X1.C0745f;
import X1.E;
import X1.G;
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
    final TaskCompletionSource f10106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final C0745f f10107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final G f10108c = new G("RequestDialogCallbackImpl");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final k f10110e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Activity f10111f;

    public as(Context context, k kVar, Activity activity, TaskCompletionSource taskCompletionSource, C0745f c0745f) {
        this.f10109d = context.getPackageName();
        this.f10110e = kVar;
        this.f10106a = taskCompletionSource;
        this.f10111f = activity;
        this.f10107b = c0745f;
    }

    @Override // X1.F
    public final void b(Bundle bundle) {
        this.f10107b.v(this.f10106a);
        this.f10108c.d("onRequestDialog(%s)", this.f10109d);
        com.google.android.gms.common.api.b bVarA = this.f10110e.a(bundle);
        if (bVarA != null) {
            this.f10106a.trySetException(bVarA);
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("dialog.intent");
        if (pendingIntent == null) {
            this.f10108c.b("onRequestDialog(%s): got null dialog intent", this.f10109d);
            this.f10106a.trySetResult(0);
            return;
        }
        Intent intent = new Intent(this.f10111f, (Class<?>) PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", pendingIntent);
        intent.setFlags(536870912);
        intent.putExtra(ProxyAmazonBillingActivity.EXTRAS_RESULT_RECEIVER, new ar(this, this.f10107b.c()));
        this.f10108c.a("Starting dialog intent...", new Object[0]);
        this.f10111f.startActivityForResult(intent, 0);
    }
}
