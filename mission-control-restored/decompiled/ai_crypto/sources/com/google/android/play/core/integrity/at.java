package com.google.android.play.core.integrity;

import F2.C0468f;
import android.app.Activity;
import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final F2.o f11895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final F2.o f11896b;

    public at(F2.o oVar, F2.o oVar2) {
        this.f11895a = oVar;
        this.f11896b = oVar2;
    }

    public final as a(Activity activity, TaskCompletionSource taskCompletionSource, C0468f c0468f) {
        Object objA = this.f11895a.a();
        objA.getClass();
        k kVar = (k) this.f11896b.a();
        kVar.getClass();
        activity.getClass();
        c0468f.getClass();
        return new as((Context) objA, kVar, activity, taskCompletionSource, c0468f);
    }
}
