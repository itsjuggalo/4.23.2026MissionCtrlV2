package com.google.android.play.core.integrity;

import X1.C0745f;
import android.app.Activity;
import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final X1.o f10112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final X1.o f10113b;

    public at(X1.o oVar, X1.o oVar2) {
        this.f10112a = oVar;
        this.f10113b = oVar2;
    }

    public final as a(Activity activity, TaskCompletionSource taskCompletionSource, C0745f c0745f) {
        Object objA = this.f10112a.a();
        objA.getClass();
        k kVar = (k) this.f10113b.a();
        kVar.getClass();
        activity.getClass();
        c0745f.getClass();
        return new as((Context) objA, kVar, activity, taskCompletionSource, c0745f);
    }
}
