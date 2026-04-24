package com.google.android.play.core.integrity;

import S1.C0236e;
import android.app.Activity;
import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final S1.j f5363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final S1.j f5364b;

    public at(S1.j jVar, S1.j jVar2) {
        this.f5363a = jVar;
        this.f5364b = jVar2;
    }

    public final as a(Activity activity, TaskCompletionSource taskCompletionSource, C0236e c0236e) {
        Object objA = this.f5363a.a();
        objA.getClass();
        k kVar = (k) this.f5364b.a();
        kVar.getClass();
        activity.getClass();
        c0236e.getClass();
        return new as((Context) objA, kVar, activity, taskCompletionSource, c0236e);
    }
}
