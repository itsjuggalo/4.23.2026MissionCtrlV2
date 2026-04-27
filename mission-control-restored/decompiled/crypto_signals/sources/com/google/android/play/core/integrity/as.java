package com.google.android.play.core.integrity;

import S1.C0236e;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;

/* JADX INFO: loaded from: classes.dex */
final class as extends S1.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final TaskCompletionSource f5358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final C0236e f5359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final S1.z f5360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f5361d;
    private final k e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Activity f5362f;

    public as(Context context, k kVar, Activity activity, TaskCompletionSource taskCompletionSource, C0236e c0236e) {
        super("com.google.android.play.core.integrity.protocol.IRequestDialogCallback");
        this.f5360c = new S1.z("RequestDialogCallbackImpl");
        this.f5361d = context.getPackageName();
        this.e = kVar;
        this.f5358a = taskCompletionSource;
        this.f5362f = activity;
        this.f5359b = c0236e;
    }

    @Override // S1.y
    public final void b(Bundle bundle) {
        this.f5359b.d(this.f5358a);
        this.f5360c.b("onRequestDialog(%s)", this.f5361d);
        com.google.android.gms.common.api.j jVarA = this.e.a(bundle);
        if (jVarA != null) {
            this.f5358a.trySetException(jVarA);
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("dialog.intent");
        if (pendingIntent == null) {
            S1.z zVar = this.f5360c;
            Object[] objArr = {this.f5361d};
            zVar.getClass();
            if (Log.isLoggable("PlayCore", 6)) {
                Log.e("PlayCore", S1.z.c(zVar.f2879a, "onRequestDialog(%s): got null dialog intent", objArr));
            }
            this.f5358a.trySetResult(0);
            return;
        }
        Intent intent = new Intent(this.f5362f, (Class<?>) PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", pendingIntent);
        intent.setFlags(536870912);
        intent.putExtra("result_receiver", new ar(this, this.f5359b.a()));
        S1.z zVar2 = this.f5360c;
        Object[] objArr2 = new Object[0];
        zVar2.getClass();
        if (Log.isLoggable("PlayCore", 3)) {
            Log.d("PlayCore", S1.z.c(zVar2.f2879a, "Starting dialog intent...", objArr2));
        }
        this.f5362f.startActivityForResult(intent, 0);
    }
}
