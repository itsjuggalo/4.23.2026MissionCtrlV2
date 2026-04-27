package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
final class zzgl extends zzgn {
    private int zzb;
    private int zzc;
    private int zzd;

    public /* synthetic */ zzgl(byte[] bArr, int i4, int i5, boolean z4, zzgm zzgmVar) {
        super(null);
        this.zzd = Integer.MAX_VALUE;
        this.zzb = 0;
    }

    public final int zza(int i4) {
        int i5 = this.zzd;
        this.zzd = 0;
        int i6 = this.zzb + this.zzc;
        this.zzb = i6;
        if (i6 <= 0) {
            this.zzc = 0;
            return i5;
        }
        this.zzc = i6;
        this.zzb = 0;
        return i5;
    }
}
