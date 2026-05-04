package com.google.android.play.core.integrity;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;
import n6.e0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e0 f5929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e0 f5930b;

    public at(e0 e0Var, e0 e0Var2) {
        this.f5929a = e0Var;
        this.f5930b = e0Var2;
    }

    public final as a(Activity activity, TaskCompletionSource taskCompletionSource, n6.f fVar) {
        Context context = (Context) this.f5929a.a();
        context.getClass();
        k kVar = (k) this.f5930b.a();
        kVar.getClass();
        activity.getClass();
        fVar.getClass();
        return new as(context, kVar, activity, taskCompletionSource, fVar);
    }
}
