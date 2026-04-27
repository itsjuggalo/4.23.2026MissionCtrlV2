package com.google.android.gms.internal.p002firebaseauthapi;

import Z1.k;
import i2.u;
import i2.w;
import i2.x;

/* JADX INFO: loaded from: classes.dex */
final class zzaga extends x {
    private final /* synthetic */ x zza;
    private final /* synthetic */ String zzb;

    public zzaga(x xVar, String str) {
        this.zza = xVar;
        this.zzb = str;
    }

    @Override // i2.x
    public final void onCodeAutoRetrievalTimeOut(String str) {
        zzagb.zza.remove(this.zzb);
        this.zza.onCodeAutoRetrievalTimeOut(str);
    }

    @Override // i2.x
    public final void onCodeSent(String str, w wVar) {
        this.zza.onCodeSent(str, wVar);
    }

    @Override // i2.x
    public final void onVerificationCompleted(u uVar) {
        zzagb.zza.remove(this.zzb);
        this.zza.onVerificationCompleted(uVar);
    }

    @Override // i2.x
    public final void onVerificationFailed(k kVar) {
        zzagb.zza.remove(this.zzb);
        this.zza.onVerificationFailed(kVar);
    }
}
