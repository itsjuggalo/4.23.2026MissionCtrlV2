package com.google.firebase.auth.internal;

import com.google.android.gms.common.api.internal.ComponentCallbacks2C0900d;

/* JADX INFO: loaded from: classes.dex */
final class zzcd implements ComponentCallbacks2C0900d.a {
    private final /* synthetic */ zzca zza;

    public zzcd(zzca zzcaVar) {
        this.zza = zzcaVar;
    }

    @Override // com.google.android.gms.common.api.internal.ComponentCallbacks2C0900d.a
    public final void onBackgroundStateChanged(boolean z4) {
        if (z4) {
            this.zza.zzc = true;
            this.zza.zza();
        } else {
            this.zza.zzc = false;
            if (this.zza.zzb()) {
                this.zza.zzb.zzc();
            }
        }
    }
}
