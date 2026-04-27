package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzahn;

/* JADX INFO: loaded from: classes.dex */
final class zzz implements com.google.firebase.auth.internal.zzau, com.google.firebase.auth.internal.zzl {
    private final /* synthetic */ FirebaseAuth zza;

    public zzz(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    @Override // com.google.firebase.auth.internal.zzl
    public final void zza(zzahn zzahnVar, FirebaseUser firebaseUser) {
        this.zza.zza(firebaseUser, zzahnVar, true, true);
    }

    @Override // com.google.firebase.auth.internal.zzau
    public final void zza(Status status) {
        int iK = status.k();
        if (iK == 17011 || iK == 17021 || iK == 17005) {
            this.zza.signOut();
        }
    }
}
