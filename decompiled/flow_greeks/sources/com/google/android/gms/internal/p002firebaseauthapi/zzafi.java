package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.b;
import java.util.Objects;
import m7.o0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzafi implements zzafm {
    private final /* synthetic */ o0 zza;

    public zzafi(zzafh zzafhVar, o0 o0Var) {
        this.zza = o0Var;
        Objects.requireNonNull(zzafhVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafm
    public final void zza(b.AbstractC0100b abstractC0100b, Object... objArr) {
        abstractC0100b.onVerificationCompleted(this.zza);
    }
}
