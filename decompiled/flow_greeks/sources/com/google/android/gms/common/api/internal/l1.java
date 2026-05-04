package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l1 extends o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Dialog f5602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m1 f5603b;

    public l1(m1 m1Var, Dialog dialog) {
        this.f5602a = dialog;
        Objects.requireNonNull(m1Var);
        this.f5603b = m1Var;
    }

    @Override // com.google.android.gms.common.api.internal.o0
    public final void a() {
        this.f5603b.f5606b.g();
        Dialog dialog = this.f5602a;
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
