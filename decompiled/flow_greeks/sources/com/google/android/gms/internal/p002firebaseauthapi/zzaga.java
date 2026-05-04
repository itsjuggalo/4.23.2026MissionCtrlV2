package com.google.android.gms.internal.p002firebaseauthapi;

import a7.m;
import com.google.firebase.auth.b;
import m7.o0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzaga extends b.AbstractC0100b {
    private final /* synthetic */ b.AbstractC0100b zza;
    private final /* synthetic */ String zzb;

    public zzaga(b.AbstractC0100b abstractC0100b, String str) {
        this.zza = abstractC0100b;
        this.zzb = str;
    }

    @Override // com.google.firebase.auth.b.AbstractC0100b
    public final void onCodeAutoRetrievalTimeOut(String str) {
        zzagb.zza.remove(this.zzb);
        this.zza.onCodeAutoRetrievalTimeOut(str);
    }

    @Override // com.google.firebase.auth.b.AbstractC0100b
    public final void onCodeSent(String str, b.a aVar) {
        this.zza.onCodeSent(str, aVar);
    }

    @Override // com.google.firebase.auth.b.AbstractC0100b
    public final void onVerificationCompleted(o0 o0Var) {
        zzagb.zza.remove(this.zzb);
        this.zza.onVerificationCompleted(o0Var);
    }

    @Override // com.google.firebase.auth.b.AbstractC0100b
    public final void onVerificationFailed(m mVar) {
        zzagb.zza.remove(this.zzb);
        this.zza.onVerificationFailed(mVar);
    }
}
