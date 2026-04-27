package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.a;

/* JADX INFO: loaded from: classes.dex */
final class zzlh extends zzli {
    private int zzb;
    private int zzc;
    private int zzd;

    public /* synthetic */ zzlh(byte[] bArr, int i7, int i8, boolean z7, byte[] bArr2) {
        super(null);
        this.zzd = a.e.API_PRIORITY_OTHER;
        this.zzb = 0;
    }

    public final int zza(int i7) {
        int i8 = this.zzd;
        this.zzd = 0;
        int i9 = this.zzb + this.zzc;
        this.zzb = i9;
        if (i9 > 0) {
            this.zzc = i9;
            this.zzb = 0;
        } else {
            this.zzc = 0;
        }
        return i8;
    }
}
