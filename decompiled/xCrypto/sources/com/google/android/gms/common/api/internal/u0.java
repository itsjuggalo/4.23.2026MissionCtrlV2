package com.google.android.gms.common.api.internal;

import android.app.Dialog;

/* JADX INFO: loaded from: classes.dex */
public final class u0 extends W {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Dialog f9823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v0 f9824b;

    public u0(v0 v0Var, Dialog dialog) {
        this.f9824b = v0Var;
        this.f9823a = dialog;
    }

    @Override // com.google.android.gms.common.api.internal.W
    public final void a() {
        this.f9824b.f9827b.d();
        if (this.f9823a.isShowing()) {
            this.f9823a.dismiss();
        }
    }
}
