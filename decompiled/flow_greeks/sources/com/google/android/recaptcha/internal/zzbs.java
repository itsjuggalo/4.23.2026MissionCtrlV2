package com.google.android.recaptcha.internal;

import android.content.Context;
import m5.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbs {
    private final f zza;

    public zzbs(f fVar) {
        this.zza = fVar;
    }

    public final int zza(Context context) {
        int iG = this.zza.g(context);
        return (iG == 1 || iG == 3 || iG == 9) ? 4 : 3;
    }

    public zzbs() {
        this.zza = f.f();
    }
}
