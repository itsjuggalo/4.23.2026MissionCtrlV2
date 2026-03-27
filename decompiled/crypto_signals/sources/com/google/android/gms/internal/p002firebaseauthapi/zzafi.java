package com.google.android.gms.internal.p002firebaseauthapi;

import i2.u;
import i2.x;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzafi implements zzafm {
    private final /* synthetic */ u zza;

    public zzafi(zzafh zzafhVar, u uVar) {
        this.zza = uVar;
        Objects.requireNonNull(zzafhVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafm
    public final void zza(x xVar, Object... objArr) {
        xVar.onVerificationCompleted(this.zza);
    }
}
