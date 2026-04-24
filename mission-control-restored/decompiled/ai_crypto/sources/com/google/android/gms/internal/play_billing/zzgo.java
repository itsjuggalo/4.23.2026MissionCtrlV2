package com.google.android.gms.internal.play_billing;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class zzgo extends zzgr {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;

    public zzgo(byte[] bArr, int i7, int i8) {
        super(null);
        int length = bArr.length;
        if (((length - i8) | i8) < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i8)));
        }
        this.zzb = bArr;
        this.zzd = 0;
        this.zzc = i8;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final int zza() {
        return this.zzc - this.zzd;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzb(byte b7) throws zzgp {
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i7 = this.zzd;
        try {
            int i8 = i7 + 1;
            try {
                this.zzb[i7] = b7;
                this.zzd = i8;
            } catch (IndexOutOfBoundsException e7) {
                indexOutOfBoundsException = e7;
                i7 = i8;
                throw new zzgp(i7, this.zzc, 1, indexOutOfBoundsException);
            }
        } catch (IndexOutOfBoundsException e8) {
            indexOutOfBoundsException = e8;
        }
    }

    public final void zzc(byte[] bArr, int i7, int i8) {
        try {
            System.arraycopy(bArr, 0, this.zzb, this.zzd, i8);
            this.zzd += i8;
        } catch (IndexOutOfBoundsException e7) {
            throw new zzgp(this.zzd, this.zzc, i8, e7);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzd(int i7, boolean z7) throws zzgp {
        zzt(i7 << 3);
        zzb(z7 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zze(int i7, zzgk zzgkVar) throws zzgp {
        zzt((i7 << 3) | 2);
        zzt(zzgkVar.zzd());
        zzgkVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzf(int i7, int i8) throws zzgp {
        zzt((i7 << 3) | 5);
        zzg(i8);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzg(int i7) throws zzgp {
        int i8 = this.zzd;
        try {
            byte[] bArr = this.zzb;
            bArr[i8] = (byte) (i7 & 255);
            bArr[i8 + 1] = (byte) ((i7 >> 8) & 255);
            bArr[i8 + 2] = (byte) ((i7 >> 16) & 255);
            bArr[i8 + 3] = (byte) ((i7 >> 24) & 255);
            this.zzd = i8 + 4;
        } catch (IndexOutOfBoundsException e7) {
            throw new zzgp(i8, this.zzc, 4, e7);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzh(int i7, long j7) throws zzgp {
        zzt((i7 << 3) | 1);
        zzi(j7);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzi(long j7) throws zzgp {
        int i7 = this.zzd;
        try {
            byte[] bArr = this.zzb;
            bArr[i7] = (byte) (((int) j7) & 255);
            bArr[i7 + 1] = (byte) (((int) (j7 >> 8)) & 255);
            bArr[i7 + 2] = (byte) (((int) (j7 >> 16)) & 255);
            bArr[i7 + 3] = (byte) (((int) (j7 >> 24)) & 255);
            bArr[i7 + 4] = (byte) (((int) (j7 >> 32)) & 255);
            bArr[i7 + 5] = (byte) (((int) (j7 >> 40)) & 255);
            bArr[i7 + 6] = (byte) (((int) (j7 >> 48)) & 255);
            bArr[i7 + 7] = (byte) (((int) (j7 >> 56)) & 255);
            this.zzd = i7 + 8;
        } catch (IndexOutOfBoundsException e7) {
            throw new zzgp(i7, this.zzc, 8, e7);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzj(int i7, int i8) throws zzgp {
        zzt(i7 << 3);
        zzk(i8);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzk(int i7) throws zzgp {
        if (i7 >= 0) {
            zzt(i7);
        } else {
            zzv(i7);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzl(byte[] bArr, int i7, int i8) {
        zzc(bArr, 0, i8);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzm(int i7, zzim zzimVar, zzix zzixVar) throws zzgp {
        zzt((i7 << 3) | 2);
        zzt(((zzfv) zzimVar).zze(zzixVar));
        zzixVar.zzi(zzimVar, this.zza);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzn(int i7, zzim zzimVar) throws zzgp {
        zzt(11);
        zzs(2, i7);
        zzt(26);
        zzt(zzimVar.zzk());
        zzimVar.zzJ(this);
        zzt(12);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzo(int i7, zzgk zzgkVar) throws zzgp {
        zzt(11);
        zzs(2, i7);
        zze(3, zzgkVar);
        zzt(12);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzp(int i7, String str) throws zzgp {
        zzt((i7 << 3) | 2);
        zzq(str);
    }

    public final void zzq(String str) throws zzgp {
        int i7 = this.zzd;
        try {
            int iZzz = zzgr.zzz(str.length() * 3);
            int iZzz2 = zzgr.zzz(str.length());
            if (iZzz2 != iZzz) {
                zzt(zzjt.zzc(str));
                byte[] bArr = this.zzb;
                int i8 = this.zzd;
                this.zzd = zzjt.zzb(str, bArr, i8, this.zzc - i8);
                return;
            }
            int i9 = i7 + iZzz2;
            this.zzd = i9;
            int iZzb = zzjt.zzb(str, this.zzb, i9, this.zzc - i9);
            this.zzd = i7;
            zzt((iZzb - i7) - iZzz2);
            this.zzd = iZzb;
        } catch (zzjs e7) {
            this.zzd = i7;
            zzC(str, e7);
        } catch (IndexOutOfBoundsException e8) {
            throw new zzgp(e8);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzr(int i7, int i8) throws zzgp {
        zzt((i7 << 3) | i8);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzs(int i7, int i8) throws zzgp {
        zzt(i7 << 3);
        zzt(i8);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzt(int i7) throws zzgp {
        while ((i7 & (-128)) != 0) {
            try {
                byte[] bArr = this.zzb;
                int i8 = this.zzd;
                this.zzd = i8 + 1;
                bArr[i8] = (byte) ((i7 | 128) & 255);
                i7 >>>= 7;
            } catch (IndexOutOfBoundsException e7) {
                throw new zzgp(this.zzd, this.zzc, 1, e7);
            }
        }
        byte[] bArr2 = this.zzb;
        int i9 = this.zzd;
        this.zzd = i9 + 1;
        bArr2[i9] = (byte) i7;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzu(int i7, long j7) throws zzgp {
        zzt(i7 << 3);
        zzv(j7);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzv(long j7) throws zzgp {
        if (!zzgr.zzc || this.zzc - this.zzd < 10) {
            while ((j7 & (-128)) != 0) {
                try {
                    byte[] bArr = this.zzb;
                    int i7 = this.zzd;
                    this.zzd = i7 + 1;
                    bArr[i7] = (byte) ((((int) j7) | 128) & 255);
                    j7 >>>= 7;
                } catch (IndexOutOfBoundsException e7) {
                    throw new zzgp(this.zzd, this.zzc, 1, e7);
                }
            }
            byte[] bArr2 = this.zzb;
            int i8 = this.zzd;
            this.zzd = i8 + 1;
            bArr2[i8] = (byte) j7;
            return;
        }
        while (true) {
            int i9 = (int) j7;
            if ((j7 & (-128)) == 0) {
                byte[] bArr3 = this.zzb;
                int i10 = this.zzd;
                this.zzd = i10 + 1;
                zzjq.zzn(bArr3, i10, (byte) i9);
                return;
            }
            byte[] bArr4 = this.zzb;
            int i11 = this.zzd;
            this.zzd = i11 + 1;
            zzjq.zzn(bArr4, i11, (byte) ((i9 | 128) & 255));
            j7 >>>= 7;
        }
    }
}
