package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzli extends zzlj {
    private int zzb;
    private int zzc;
    private int zzd;

    public /* synthetic */ zzli(byte[] bArr, int i8, int i9, boolean z7, byte[] bArr2) {
        super(null);
        this.zzd = Integer.MAX_VALUE;
        this.zzb = 0;
    }

    public final int zza(int i8) {
        int i9 = this.zzd;
        this.zzd = 0;
        int i10 = this.zzb + this.zzc;
        this.zzb = i10;
        if (i10 > 0) {
            this.zzc = i10;
            this.zzb = 0;
        } else {
            this.zzc = 0;
        }
        return i9;
    }
}
