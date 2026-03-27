package com.google.android.recaptcha.internal;

import android.content.Context;
import z1.C1989g;

/* JADX INFO: loaded from: classes.dex */
public final class zzbs {
    private final C1989g zza;

    public zzbs(C1989g c1989g) {
        this.zza = c1989g;
    }

    public final int zza(Context context) {
        int iG = this.zza.g(context);
        return (iG == 1 || iG == 3 || iG == 9) ? 4 : 3;
    }

    public zzbs() {
        this.zza = C1989g.f();
    }
}
