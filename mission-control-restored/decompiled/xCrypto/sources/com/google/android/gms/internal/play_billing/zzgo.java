package com.google.android.gms.internal.play_billing;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class zzgo extends zzgr {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;

    public zzgo(byte[] bArr, int i4, int i5) {
        super(null);
        int length = bArr.length;
        if (((length - i5) | i5) < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i5)));
        }
        this.zzb = bArr;
        this.zzd = 0;
        this.zzc = i5;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final int zza() {
        return this.zzc - this.zzd;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzb(byte b4) throws zzgp {
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i4 = this.zzd;
        try {
            int i5 = i4 + 1;
            try {
                this.zzb[i4] = b4;
                this.zzd = i5;
            } catch (IndexOutOfBoundsException e4) {
                indexOutOfBoundsException = e4;
                i4 = i5;
                throw new zzgp(i4, this.zzc, 1, indexOutOfBoundsException);
            }
        } catch (IndexOutOfBoundsException e5) {
            indexOutOfBoundsException = e5;
        }
    }

    public final void zzc(byte[] bArr, int i4, int i5) {
        try {
            System.arraycopy(bArr, 0, this.zzb, this.zzd, i5);
            this.zzd += i5;
        } catch (IndexOutOfBoundsException e4) {
            throw new zzgp(this.zzd, this.zzc, i5, e4);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzd(int i4, boolean z4) throws zzgp {
        zzt(i4 << 3);
        zzb(z4 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zze(int i4, zzgk zzgkVar) throws zzgp {
        zzt((i4 << 3) | 2);
        zzt(zzgkVar.zzd());
        zzgkVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzf(int i4, int i5) throws zzgp {
        zzt((i4 << 3) | 5);
        zzg(i5);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzg(int i4) throws zzgp {
        int i5 = this.zzd;
        try {
            byte[] bArr = this.zzb;
            bArr[i5] = (byte) (i4 & 255);
            bArr[i5 + 1] = (byte) ((i4 >> 8) & 255);
            bArr[i5 + 2] = (byte) ((i4 >> 16) & 255);
            bArr[i5 + 3] = (byte) ((i4 >> 24) & 255);
            this.zzd = i5 + 4;
        } catch (IndexOutOfBoundsException e4) {
            throw new zzgp(i5, this.zzc, 4, e4);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzh(int i4, long j4) throws zzgp {
        zzt((i4 << 3) | 1);
        zzi(j4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzi(long j4) throws zzgp {
        int i4 = this.zzd;
        try {
            byte[] bArr = this.zzb;
            bArr[i4] = (byte) (((int) j4) & 255);
            bArr[i4 + 1] = (byte) (((int) (j4 >> 8)) & 255);
            bArr[i4 + 2] = (byte) (((int) (j4 >> 16)) & 255);
            bArr[i4 + 3] = (byte) (((int) (j4 >> 24)) & 255);
            bArr[i4 + 4] = (byte) (((int) (j4 >> 32)) & 255);
            bArr[i4 + 5] = (byte) (((int) (j4 >> 40)) & 255);
            bArr[i4 + 6] = (byte) (((int) (j4 >> 48)) & 255);
            bArr[i4 + 7] = (byte) (((int) (j4 >> 56)) & 255);
            this.zzd = i4 + 8;
        } catch (IndexOutOfBoundsException e4) {
            throw new zzgp(i4, this.zzc, 8, e4);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzj(int i4, int i5) throws zzgp {
        zzt(i4 << 3);
        zzk(i5);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzk(int i4) throws zzgp {
        if (i4 >= 0) {
            zzt(i4);
        } else {
            zzv(i4);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzl(byte[] bArr, int i4, int i5) {
        zzc(bArr, 0, i5);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzm(int i4, zzim zzimVar, zzix zzixVar) throws zzgp {
        zzt((i4 << 3) | 2);
        zzt(((zzfv) zzimVar).zze(zzixVar));
        zzixVar.zzi(zzimVar, this.zza);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzn(int i4, zzim zzimVar) throws zzgp {
        zzt(11);
        zzs(2, i4);
        zzt(26);
        zzt(zzimVar.zzk());
        zzimVar.zzJ(this);
        zzt(12);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzo(int i4, zzgk zzgkVar) throws zzgp {
        zzt(11);
        zzs(2, i4);
        zze(3, zzgkVar);
        zzt(12);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzp(int i4, String str) throws zzgp {
        zzt((i4 << 3) | 2);
        zzq(str);
    }

    public final void zzq(String str) throws zzgp {
        int i4 = this.zzd;
        try {
            int iZzz = zzgr.zzz(str.length() * 3);
            int iZzz2 = zzgr.zzz(str.length());
            if (iZzz2 != iZzz) {
                zzt(zzjt.zzc(str));
                byte[] bArr = this.zzb;
                int i5 = this.zzd;
                this.zzd = zzjt.zzb(str, bArr, i5, this.zzc - i5);
                return;
            }
            int i6 = i4 + iZzz2;
            this.zzd = i6;
            int iZzb = zzjt.zzb(str, this.zzb, i6, this.zzc - i6);
            this.zzd = i4;
            zzt((iZzb - i4) - iZzz2);
            this.zzd = iZzb;
        } catch (zzjs e4) {
            this.zzd = i4;
            zzC(str, e4);
        } catch (IndexOutOfBoundsException e5) {
            throw new zzgp(e5);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzr(int i4, int i5) throws zzgp {
        zzt((i4 << 3) | i5);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzs(int i4, int i5) throws zzgp {
        zzt(i4 << 3);
        zzt(i5);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzt(int i4) throws zzgp {
        while ((i4 & (-128)) != 0) {
            try {
                byte[] bArr = this.zzb;
                int i5 = this.zzd;
                this.zzd = i5 + 1;
                bArr[i5] = (byte) ((i4 | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) & 255);
                i4 >>>= 7;
            } catch (IndexOutOfBoundsException e4) {
                throw new zzgp(this.zzd, this.zzc, 1, e4);
            }
        }
        byte[] bArr2 = this.zzb;
        int i6 = this.zzd;
        this.zzd = i6 + 1;
        bArr2[i6] = (byte) i4;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzu(int i4, long j4) throws zzgp {
        zzt(i4 << 3);
        zzv(j4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgr
    public final void zzv(long j4) throws zzgp {
        if (!zzgr.zzc || this.zzc - this.zzd < 10) {
            while ((j4 & (-128)) != 0) {
                try {
                    byte[] bArr = this.zzb;
                    int i4 = this.zzd;
                    this.zzd = i4 + 1;
                    bArr[i4] = (byte) ((((int) j4) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) & 255);
                    j4 >>>= 7;
                } catch (IndexOutOfBoundsException e4) {
                    throw new zzgp(this.zzd, this.zzc, 1, e4);
                }
            }
            byte[] bArr2 = this.zzb;
            int i5 = this.zzd;
            this.zzd = i5 + 1;
            bArr2[i5] = (byte) j4;
            return;
        }
        while (true) {
            int i6 = (int) j4;
            if ((j4 & (-128)) == 0) {
                byte[] bArr3 = this.zzb;
                int i7 = this.zzd;
                this.zzd = i7 + 1;
                zzjq.zzn(bArr3, i7, (byte) i6);
                return;
            }
            byte[] bArr4 = this.zzb;
            int i8 = this.zzd;
            this.zzd = i8 + 1;
            zzjq.zzn(bArr4, i8, (byte) ((i6 | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) & 255));
            j4 >>>= 7;
        }
    }
}
