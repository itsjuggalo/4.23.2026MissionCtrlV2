package com.google.android.gms.internal.fido;

/* JADX INFO: loaded from: classes.dex */
final class zzdb extends zzdd {
    private final byte[] zzb;
    private int zzc;
    private int zzd;
    private int zze;

    public /* synthetic */ zzdb(byte[] bArr, int i4, int i5, boolean z4, zzda zzdaVar) {
        super(null);
        this.zze = Integer.MAX_VALUE;
        this.zzb = bArr;
        this.zzc = 0;
    }

    public final int zza(int i4) {
        int i5 = this.zze;
        this.zze = 0;
        int i6 = this.zzc + this.zzd;
        this.zzc = i6;
        if (i6 <= 0) {
            this.zzd = 0;
            return i5;
        }
        this.zzd = i6;
        this.zzc = 0;
        return i5;
    }
}
