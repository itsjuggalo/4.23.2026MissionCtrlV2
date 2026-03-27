package com.google.android.gms.common.api.internal;

import android.app.Dialog;

/* JADX INFO: loaded from: classes.dex */
public final class r0 extends T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Dialog f10998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s0 f10999b;

    public r0(s0 s0Var, Dialog dialog) {
        this.f10999b = s0Var;
        this.f10998a = dialog;
    }

    @Override // com.google.android.gms.common.api.internal.T
    public final void a() {
        this.f10999b.f11001b.d();
        if (this.f10998a.isShowing()) {
            this.f10998a.dismiss();
        }
    }
}
