package com.google.android.gms.internal.p002firebaseauthapi;

import i2.x;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzafl implements zzafm {
    private final /* synthetic */ String zza;

    public zzafl(zzafh zzafhVar, String str) {
        this.zza = str;
        Objects.requireNonNull(zzafhVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafm
    public final void zza(x xVar, Object... objArr) {
        xVar.onCodeAutoRetrievalTimeOut(this.zza);
    }
}
