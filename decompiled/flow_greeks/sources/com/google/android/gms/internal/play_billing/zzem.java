package com.google.android.gms.internal.play_billing;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzem extends zzep {
    private final byte[] zzc;
    private final int zzd;
    private int zze;

    public zzem(byte[] bArr, int i10, int i11) {
        super(null);
        int length = bArr.length;
        if (((length - i11) | i11) < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i11)));
        }
        this.zzc = bArr;
        this.zze = 0;
        this.zzd = i11;
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final int zza() {
        return this.zzd - this.zze;
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzb(byte b10) throws zzen {
        int i10 = this.zze;
        try {
            int i11 = i10 + 1;
            try {
                this.zzc[i10] = b10;
                this.zze = i11;
            } catch (IndexOutOfBoundsException e10) {
                e = e10;
                i10 = i11;
                throw new zzen(i10, this.zzd, 1, e);
            }
        } catch (IndexOutOfBoundsException e11) {
            e = e11;
        }
    }

    public final void zzc(byte[] bArr, int i10, int i11) {
        try {
            System.arraycopy(bArr, 0, this.zzc, this.zze, i11);
            this.zze += i11;
        } catch (IndexOutOfBoundsException e10) {
            throw new zzen(this.zze, this.zzd, i11, e10);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzd(int i10, boolean z10) throws zzen {
        zzv(i10 << 3);
        zzb(z10 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zze(int i10, zzei zzeiVar) throws zzen {
        zzv((i10 << 3) | 2);
        zzf(zzeiVar);
    }

    public final void zzf(zzei zzeiVar) throws zzen {
        zzv(zzeiVar.zzd());
        zzeiVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzg(int i10, int i11) throws zzen {
        zzv((i10 << 3) | 5);
        zzh(i11);
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzh(int i10) throws zzen {
        int i11 = this.zze;
        try {
            byte[] bArr = this.zzc;
            bArr[i11] = (byte) i10;
            bArr[i11 + 1] = (byte) (i10 >> 8);
            bArr[i11 + 2] = (byte) (i10 >> 16);
            bArr[i11 + 3] = (byte) (i10 >> 24);
            this.zze = i11 + 4;
        } catch (IndexOutOfBoundsException e10) {
            throw new zzen(i11, this.zzd, 4, e10);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzi(int i10, long j10) throws zzen {
        zzv((i10 << 3) | 1);
        zzj(j10);
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzj(long j10) throws zzen {
        int i10 = this.zze;
        try {
            byte[] bArr = this.zzc;
            bArr[i10] = (byte) j10;
            bArr[i10 + 1] = (byte) (j10 >> 8);
            bArr[i10 + 2] = (byte) (j10 >> 16);
            bArr[i10 + 3] = (byte) (j10 >> 24);
            bArr[i10 + 4] = (byte) (j10 >> 32);
            bArr[i10 + 5] = (byte) (j10 >> 40);
            bArr[i10 + 6] = (byte) (j10 >> 48);
            bArr[i10 + 7] = (byte) (j10 >> 56);
            this.zze = i10 + 8;
        } catch (IndexOutOfBoundsException e10) {
            throw new zzen(i10, this.zzd, 8, e10);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzk(int i10, int i11) throws zzen {
        zzv(i10 << 3);
        zzl(i11);
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzl(int i10) throws zzen {
        if (i10 >= 0) {
            zzv(i10);
        } else {
            zzx(i10);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzm(byte[] bArr, int i10, int i11) {
        zzc(bArr, 0, i11);
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzn(int i10, zzgl zzglVar, zzgv zzgvVar) throws zzen {
        zzv((i10 << 3) | 2);
        zzv(((zzds) zzglVar).zze(zzgvVar));
        zzgvVar.zzi(zzglVar, this.zza);
    }

    public final void zzo(zzgl zzglVar) throws zzen {
        zzv(zzglVar.zzj());
        zzglVar.zzL(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzp(int i10, zzgl zzglVar) throws zzen {
        zzv(11);
        zzu(2, i10);
        zzv(26);
        zzo(zzglVar);
        zzv(12);
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzq(int i10, zzei zzeiVar) throws zzen {
        zzv(11);
        zzu(2, i10);
        zze(3, zzeiVar);
        zzv(12);
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzr(int i10, String str) throws zzen {
        zzv((i10 << 3) | 2);
        zzs(str);
    }

    public final void zzs(String str) throws zzen {
        int i10 = this.zze;
        try {
            int iZzC = zzep.zzC(str.length() * 3);
            int iZzC2 = zzep.zzC(str.length());
            if (iZzC2 != iZzC) {
                zzv(zzhr.zzc(str));
                byte[] bArr = this.zzc;
                int i11 = this.zze;
                this.zze = zzhr.zzb(str, bArr, i11, this.zzd - i11);
                return;
            }
            int i12 = i10 + iZzC2;
            this.zze = i12;
            int iZzb = zzhr.zzb(str, this.zzc, i12, this.zzd - i12);
            this.zze = i10;
            zzv((iZzb - i10) - iZzC2);
            this.zze = iZzb;
        } catch (zzhq e10) {
            this.zze = i10;
            zzF(str, e10);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzen(e11);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzt(int i10, int i11) throws zzen {
        zzv((i10 << 3) | i11);
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzu(int i10, int i11) throws zzen {
        zzv(i10 << 3);
        zzv(i11);
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzv(int i10) throws zzen {
        int i11;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i12 = this.zze;
        while ((i10 & (-128)) != 0) {
            try {
                i11 = i12 + 1;
                try {
                    this.zzc[i12] = (byte) (i10 | 128);
                    i10 >>>= 7;
                    i12 = i11;
                } catch (IndexOutOfBoundsException e10) {
                    indexOutOfBoundsException = e10;
                    i12 = i11;
                    throw new zzen(i12, this.zzd, 1, indexOutOfBoundsException);
                }
            } catch (IndexOutOfBoundsException e11) {
                indexOutOfBoundsException = e11;
                throw new zzen(i12, this.zzd, 1, indexOutOfBoundsException);
            }
        }
        i11 = i12 + 1;
        this.zzc[i12] = (byte) i10;
        this.zze = i11;
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzw(int i10, long j10) throws zzen {
        zzv(i10 << 3);
        zzx(j10);
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzx(long j10) throws zzen {
        int i10;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i11 = this.zze;
        if (!zzep.zzd || this.zzd - i11 < 10) {
            int i12 = i11;
            while ((j10 & (-128)) != 0) {
                try {
                    int i13 = i12 + 1;
                    try {
                        this.zzc[i12] = (byte) (((int) j10) | 128);
                        j10 >>>= 7;
                        i12 = i13;
                    } catch (IndexOutOfBoundsException e10) {
                        indexOutOfBoundsException = e10;
                        i12 = i13;
                        throw new zzen(i12, this.zzd, 1, indexOutOfBoundsException);
                    }
                } catch (IndexOutOfBoundsException e11) {
                    indexOutOfBoundsException = e11;
                }
            }
            i10 = i12 + 1;
            try {
                this.zzc[i12] = (byte) j10;
            } catch (IndexOutOfBoundsException e12) {
                indexOutOfBoundsException = e12;
                i12 = i10;
                throw new zzen(i12, this.zzd, 1, indexOutOfBoundsException);
            }
        } else {
            while ((j10 & (-128)) != 0) {
                zzho.zzn(this.zzc, i11, (byte) (((int) j10) | 128));
                j10 >>>= 7;
                i11++;
            }
            i10 = i11 + 1;
            zzho.zzn(this.zzc, i11, (byte) j10);
        }
        this.zze = i10;
    }
}
