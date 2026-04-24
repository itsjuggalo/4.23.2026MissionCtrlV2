package com.google.android.recaptcha.internal;

import android.content.Context;
import u1.C1204f;

/* JADX INFO: loaded from: classes.dex */
public final class zzbs {
    private final C1204f zza;

    public zzbs() {
        this.zza = C1204f.f10286b;
    }

    public final int zza(Context context) {
        int iB = this.zza.b(context);
        return (iB == 1 || iB == 3 || iB == 9) ? 4 : 3;
    }

    public zzbs(C1204f c1204f) {
        this.zza = c1204f;
    }
}
