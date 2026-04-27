package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.internal.zzav;

/* JADX INFO: loaded from: classes.dex */
final class zzt implements zzav {
    private final /* synthetic */ FirebaseUser zza;
    private final /* synthetic */ FirebaseAuth zzb;

    public zzt(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        this.zza = firebaseUser;
        this.zzb = firebaseAuth;
    }

    @Override // com.google.firebase.auth.internal.zzav
    public final void zza() {
        if (this.zzb.zzf == null || !this.zzb.zzf.getUid().equalsIgnoreCase(this.zza.getUid())) {
            return;
        }
        this.zzb.zzh();
    }

    @Override // com.google.firebase.auth.internal.zzau
    public final void zza(Status status) {
        if (status.k() == 17011 || status.k() == 17021 || status.k() == 17005) {
            this.zzb.signOut();
        }
    }
}
