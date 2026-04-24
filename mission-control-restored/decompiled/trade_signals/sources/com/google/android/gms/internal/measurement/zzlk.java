package com.google.android.gms.internal.measurement;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class zzlk extends zzlm {
    private final byte[] zzc;
    private final int zzd;
    private int zze;

    public zzlk(byte[] bArr, int i8, int i9) {
        super(null);
        int length = bArr.length;
        if (((length - i9) | i9) < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i9)));
        }
        this.zzc = bArr;
        this.zze = 0;
        this.zzd = i9;
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zza(int i8, int i9) throws zzll {
        zzr((i8 << 3) | i9);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzb(int i8, int i9) throws zzll {
        zzr(i8 << 3);
        zzq(i9);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzc(int i8, int i9) throws zzll {
        zzr(i8 << 3);
        zzr(i9);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzd(int i8, int i9) throws zzll {
        zzr((i8 << 3) | 5);
        zzs(i9);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zze(int i8, long j8) throws zzll {
        zzr(i8 << 3);
        zzt(j8);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzf(int i8, long j8) throws zzll {
        zzr((i8 << 3) | 1);
        zzu(j8);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzg(int i8, boolean z7) throws zzll {
        zzr(i8 << 3);
        zzp(z7 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzh(int i8, String str) throws zzll {
        zzr((i8 << 3) | 2);
        zzx(str);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzi(int i8, zzlh zzlhVar) throws zzll {
        zzr((i8 << 3) | 2);
        zzj(zzlhVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzj(zzlh zzlhVar) throws zzll {
        zzr(zzlhVar.zzc());
        zzlhVar.zzf(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzk(byte[] bArr, int i8, int i9) throws zzll {
        zzr(i9);
        zzv(bArr, 0, i9);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzl(int i8, zznm zznmVar, zznx zznxVar) throws zzll {
        zzr((i8 << 3) | 2);
        zzr(((zzks) zznmVar).zzcd(zznxVar));
        zznxVar.zzf(zznmVar, this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzm(int i8, zznm zznmVar) throws zzll {
        zzr(11);
        zzc(2, i8);
        zzr(26);
        zzo(zznmVar);
        zzr(12);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzn(int i8, zzlh zzlhVar) throws zzll {
        zzr(11);
        zzc(2, i8);
        zzi(3, zzlhVar);
        zzr(12);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzo(zznm zznmVar) throws zzll {
        zzr(zznmVar.zzcn());
        zznmVar.zzcB(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzp(byte b8) throws zzll {
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i8 = this.zze;
        try {
            int i9 = i8 + 1;
            try {
                this.zzc[i8] = b8;
                this.zze = i9;
            } catch (IndexOutOfBoundsException e8) {
                indexOutOfBoundsException = e8;
                i8 = i9;
                throw new zzll(i8, this.zzd, 1, indexOutOfBoundsException);
            }
        } catch (IndexOutOfBoundsException e9) {
            indexOutOfBoundsException = e9;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzq(int i8) throws zzll {
        if (i8 >= 0) {
            zzr(i8);
        } else {
            zzt(i8);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzr(int i8) throws zzll {
        int i9;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i10 = this.zze;
        while ((i8 & (-128)) != 0) {
            try {
                i9 = i10 + 1;
                try {
                    this.zzc[i10] = (byte) (i8 | 128);
                    i8 >>>= 7;
                    i10 = i9;
                } catch (IndexOutOfBoundsException e8) {
                    indexOutOfBoundsException = e8;
                    i10 = i9;
                    throw new zzll(i10, this.zzd, 1, indexOutOfBoundsException);
                }
            } catch (IndexOutOfBoundsException e9) {
                indexOutOfBoundsException = e9;
                throw new zzll(i10, this.zzd, 1, indexOutOfBoundsException);
            }
        }
        i9 = i10 + 1;
        this.zzc[i10] = (byte) i8;
        this.zze = i9;
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzs(int i8) throws zzll {
        int i9 = this.zze;
        try {
            byte[] bArr = this.zzc;
            bArr[i9] = (byte) i8;
            bArr[i9 + 1] = (byte) (i8 >> 8);
            bArr[i9 + 2] = (byte) (i8 >> 16);
            bArr[i9 + 3] = (byte) (i8 >> 24);
            this.zze = i9 + 4;
        } catch (IndexOutOfBoundsException e8) {
            throw new zzll(i9, this.zzd, 4, e8);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzt(long j8) throws zzll {
        int i8;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i9;
        boolean z7 = zzlm.zzd;
        int i10 = this.zze;
        if (!z7 || this.zzd - i10 < 10) {
            while ((j8 & (-128)) != 0) {
                try {
                    i9 = i10 + 1;
                } catch (IndexOutOfBoundsException e8) {
                    indexOutOfBoundsException = e8;
                }
                try {
                    this.zzc[i10] = (byte) (((int) j8) | 128);
                    j8 >>>= 7;
                    i10 = i9;
                } catch (IndexOutOfBoundsException e9) {
                    indexOutOfBoundsException = e9;
                    i10 = i9;
                    throw new zzll(i10, this.zzd, 1, indexOutOfBoundsException);
                }
            }
            i8 = i10 + 1;
            try {
                this.zzc[i10] = (byte) j8;
            } catch (IndexOutOfBoundsException e10) {
                indexOutOfBoundsException = e10;
                i10 = i8;
                throw new zzll(i10, this.zzd, 1, indexOutOfBoundsException);
            }
        } else {
            while ((j8 & (-128)) != 0) {
                zzop.zzp(this.zzc, i10, (byte) (((int) j8) | 128));
                j8 >>>= 7;
                i10++;
            }
            i8 = i10 + 1;
            zzop.zzp(this.zzc, i10, (byte) j8);
        }
        this.zze = i8;
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzu(long j8) throws zzll {
        int i8 = this.zze;
        try {
            byte[] bArr = this.zzc;
            bArr[i8] = (byte) j8;
            bArr[i8 + 1] = (byte) (j8 >> 8);
            bArr[i8 + 2] = (byte) (j8 >> 16);
            bArr[i8 + 3] = (byte) (j8 >> 24);
            bArr[i8 + 4] = (byte) (j8 >> 32);
            bArr[i8 + 5] = (byte) (j8 >> 40);
            bArr[i8 + 6] = (byte) (j8 >> 48);
            bArr[i8 + 7] = (byte) (j8 >> 56);
            this.zze = i8 + 8;
        } catch (IndexOutOfBoundsException e8) {
            throw new zzll(i8, this.zzd, 8, e8);
        }
    }

    public final void zzv(byte[] bArr, int i8, int i9) {
        try {
            System.arraycopy(bArr, 0, this.zzc, this.zze, i9);
            this.zze += i9;
        } catch (IndexOutOfBoundsException e8) {
            throw new zzll(this.zze, this.zzd, i9, e8);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzw(byte[] bArr, int i8, int i9) {
        zzv(bArr, 0, i9);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzx(String str) throws zzll {
        int i8 = this.zze;
        try {
            int iZzz = zzlm.zzz(str.length() * 3);
            int iZzz2 = zzlm.zzz(str.length());
            if (iZzz2 != iZzz) {
                zzr(zzos.zzb(str));
                byte[] bArr = this.zzc;
                int i9 = this.zze;
                this.zze = zzos.zzc(str, bArr, i9, this.zzd - i9);
                return;
            }
            int i10 = i8 + iZzz2;
            this.zze = i10;
            int iZzc = zzos.zzc(str, this.zzc, i10, this.zzd - i10);
            this.zze = i8;
            zzr((iZzc - i8) - iZzz2);
            this.zze = iZzc;
        } catch (zzor e8) {
            this.zze = i8;
            zzF(str, e8);
        } catch (IndexOutOfBoundsException e9) {
            throw new zzll(e9);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final int zzy() {
        return this.zzd - this.zze;
    }
}
