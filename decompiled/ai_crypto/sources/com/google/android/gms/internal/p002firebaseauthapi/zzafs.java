package com.google.android.gms.internal.p002firebaseauthapi;

import Q2.m;
import Z2.O;
import com.google.firebase.auth.b;

/* JADX INFO: loaded from: classes.dex */
final class zzafs extends b.AbstractC0192b {
    private final /* synthetic */ b.AbstractC0192b zza;
    private final /* synthetic */ String zzb;

    public zzafs(b.AbstractC0192b abstractC0192b, String str) {
        this.zza = abstractC0192b;
        this.zzb = str;
    }

    @Override // com.google.firebase.auth.b.AbstractC0192b
    public final void onCodeAutoRetrievalTimeOut(String str) {
        zzaft.zza.remove(this.zzb);
        this.zza.onCodeAutoRetrievalTimeOut(str);
    }

    @Override // com.google.firebase.auth.b.AbstractC0192b
    public final void onCodeSent(String str, b.a aVar) {
        this.zza.onCodeSent(str, aVar);
    }

    @Override // com.google.firebase.auth.b.AbstractC0192b
    public final void onVerificationCompleted(O o7) {
        zzaft.zza.remove(this.zzb);
        this.zza.onVerificationCompleted(o7);
    }

    @Override // com.google.firebase.auth.b.AbstractC0192b
    public final void onVerificationFailed(m mVar) {
        zzaft.zza.remove(this.zzb);
        this.zza.onVerificationFailed(mVar);
    }
}
