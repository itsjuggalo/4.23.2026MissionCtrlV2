package com.google.android.recaptcha.internal;

import P1.C0653g;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzbs {
    private final C0653g zza;

    public zzbs(C0653g c0653g) {
        this.zza = c0653g;
    }

    public final int zza(Context context) {
        int iG = this.zza.g(context);
        return (iG == 1 || iG == 3 || iG == 9) ? 4 : 3;
    }

    public zzbs() {
        this.zza = C0653g.f();
    }
}
