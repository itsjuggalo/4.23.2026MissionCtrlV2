package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.f;

/* JADX INFO: loaded from: classes.dex */
final class zzli extends zzlj {
    private int zzb;
    private int zzc;
    private int zzd;

    public /* synthetic */ zzli(byte[] bArr, int i, int i6, boolean z6, byte[] bArr2) {
        super(null);
        this.zzd = f.API_PRIORITY_OTHER;
        this.zzb = 0;
    }

    public final int zza(int i) {
        int i6 = this.zzd;
        this.zzd = 0;
        int i7 = this.zzb + this.zzc;
        this.zzb = i7;
        if (i7 <= 0) {
            this.zzc = 0;
            return i6;
        }
        this.zzc = i7;
        this.zzb = 0;
        return i6;
    }
}
