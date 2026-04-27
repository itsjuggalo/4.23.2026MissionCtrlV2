package com.google.android.gms.internal.measurement;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class zzlj extends zzll {
    private final byte[] zzc;
    private final int zzd;
    private int zze;

    public zzlj(byte[] bArr, int i4, int i5) {
        super(null);
        int length = bArr.length;
        if (((length - i5) | i5) < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i5)));
        }
        this.zzc = bArr;
        this.zze = 0;
        this.zzd = i5;
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zza(int i4, int i5) throws zzlk {
        zzr((i4 << 3) | i5);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzb(int i4, int i5) throws zzlk {
        zzr(i4 << 3);
        zzq(i5);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzc(int i4, int i5) throws zzlk {
        zzr(i4 << 3);
        zzr(i5);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzd(int i4, int i5) throws zzlk {
        zzr((i4 << 3) | 5);
        zzs(i5);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zze(int i4, long j4) throws zzlk {
        zzr(i4 << 3);
        zzt(j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzf(int i4, long j4) throws zzlk {
        zzr((i4 << 3) | 1);
        zzu(j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzg(int i4, boolean z4) throws zzlk {
        zzr(i4 << 3);
        zzp(z4 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzh(int i4, String str) throws zzlk {
        zzr((i4 << 3) | 2);
        zzx(str);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzi(int i4, zzlg zzlgVar) throws zzlk {
        zzr((i4 << 3) | 2);
        zzj(zzlgVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzj(zzlg zzlgVar) throws zzlk {
        zzr(zzlgVar.zzc());
        zzlgVar.zzf(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzk(byte[] bArr, int i4, int i5) throws zzlk {
        zzr(i5);
        zzv(bArr, 0, i5);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzl(int i4, zznl zznlVar, zznw zznwVar) throws zzlk {
        zzr((i4 << 3) | 2);
        zzr(((zzkr) zznlVar).zzcd(zznwVar));
        zznwVar.zzf(zznlVar, this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzm(int i4, zznl zznlVar) throws zzlk {
        zzr(11);
        zzc(2, i4);
        zzr(26);
        zzo(zznlVar);
        zzr(12);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzn(int i4, zzlg zzlgVar) throws zzlk {
        zzr(11);
        zzc(2, i4);
        zzi(3, zzlgVar);
        zzr(12);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzo(zznl zznlVar) throws zzlk {
        zzr(zznlVar.zzcn());
        zznlVar.zzcB(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzp(byte b4) throws zzlk {
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i4 = this.zze;
        try {
            int i5 = i4 + 1;
            try {
                this.zzc[i4] = b4;
                this.zze = i5;
            } catch (IndexOutOfBoundsException e4) {
                indexOutOfBoundsException = e4;
                i4 = i5;
                throw new zzlk(i4, this.zzd, 1, indexOutOfBoundsException);
            }
        } catch (IndexOutOfBoundsException e5) {
            indexOutOfBoundsException = e5;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzq(int i4) throws zzlk {
        if (i4 >= 0) {
            zzr(i4);
        } else {
            zzt(i4);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzr(int i4) throws zzlk {
        int i5;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i6 = this.zze;
        while ((i4 & (-128)) != 0) {
            try {
                i5 = i6 + 1;
                try {
                    this.zzc[i6] = (byte) (i4 | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                    i4 >>>= 7;
                    i6 = i5;
                } catch (IndexOutOfBoundsException e4) {
                    indexOutOfBoundsException = e4;
                    i6 = i5;
                    throw new zzlk(i6, this.zzd, 1, indexOutOfBoundsException);
                }
            } catch (IndexOutOfBoundsException e5) {
                indexOutOfBoundsException = e5;
                throw new zzlk(i6, this.zzd, 1, indexOutOfBoundsException);
            }
        }
        i5 = i6 + 1;
        this.zzc[i6] = (byte) i4;
        this.zze = i5;
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzs(int i4) throws zzlk {
        int i5 = this.zze;
        try {
            byte[] bArr = this.zzc;
            bArr[i5] = (byte) i4;
            bArr[i5 + 1] = (byte) (i4 >> 8);
            bArr[i5 + 2] = (byte) (i4 >> 16);
            bArr[i5 + 3] = (byte) (i4 >> 24);
            this.zze = i5 + 4;
        } catch (IndexOutOfBoundsException e4) {
            throw new zzlk(i5, this.zzd, 4, e4);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzt(long j4) throws zzlk {
        int i4;
        IndexOutOfBoundsException indexOutOfBoundsException;
        boolean z4 = zzll.zzd;
        int i5 = this.zze;
        if (!z4 || this.zzd - i5 < 10) {
            while ((j4 & (-128)) != 0) {
                try {
                    int i6 = i5 + 1;
                    try {
                        this.zzc[i5] = (byte) (((int) j4) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                        j4 >>>= 7;
                        i5 = i6;
                    } catch (IndexOutOfBoundsException e4) {
                        indexOutOfBoundsException = e4;
                        i5 = i6;
                        throw new zzlk(i5, this.zzd, 1, indexOutOfBoundsException);
                    }
                } catch (IndexOutOfBoundsException e5) {
                    indexOutOfBoundsException = e5;
                }
            }
            i4 = i5 + 1;
            try {
                this.zzc[i5] = (byte) j4;
            } catch (IndexOutOfBoundsException e6) {
                indexOutOfBoundsException = e6;
                i5 = i4;
                throw new zzlk(i5, this.zzd, 1, indexOutOfBoundsException);
            }
        } else {
            while ((j4 & (-128)) != 0) {
                zzoo.zzp(this.zzc, i5, (byte) (((int) j4) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS));
                j4 >>>= 7;
                i5++;
            }
            i4 = i5 + 1;
            zzoo.zzp(this.zzc, i5, (byte) j4);
        }
        this.zze = i4;
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzu(long j4) throws zzlk {
        int i4 = this.zze;
        try {
            byte[] bArr = this.zzc;
            bArr[i4] = (byte) j4;
            bArr[i4 + 1] = (byte) (j4 >> 8);
            bArr[i4 + 2] = (byte) (j4 >> 16);
            bArr[i4 + 3] = (byte) (j4 >> 24);
            bArr[i4 + 4] = (byte) (j4 >> 32);
            bArr[i4 + 5] = (byte) (j4 >> 40);
            bArr[i4 + 6] = (byte) (j4 >> 48);
            bArr[i4 + 7] = (byte) (j4 >> 56);
            this.zze = i4 + 8;
        } catch (IndexOutOfBoundsException e4) {
            throw new zzlk(i4, this.zzd, 8, e4);
        }
    }

    public final void zzv(byte[] bArr, int i4, int i5) {
        try {
            System.arraycopy(bArr, 0, this.zzc, this.zze, i5);
            this.zze += i5;
        } catch (IndexOutOfBoundsException e4) {
            throw new zzlk(this.zze, this.zzd, i5, e4);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzw(byte[] bArr, int i4, int i5) {
        zzv(bArr, 0, i5);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzx(String str) throws zzlk {
        int i4 = this.zze;
        try {
            int iZzz = zzll.zzz(str.length() * 3);
            int iZzz2 = zzll.zzz(str.length());
            if (iZzz2 != iZzz) {
                zzr(zzor.zzb(str));
                byte[] bArr = this.zzc;
                int i5 = this.zze;
                this.zze = zzor.zzc(str, bArr, i5, this.zzd - i5);
                return;
            }
            int i6 = i4 + iZzz2;
            this.zze = i6;
            int iZzc = zzor.zzc(str, this.zzc, i6, this.zzd - i6);
            this.zze = i4;
            zzr((iZzc - i4) - iZzz2);
            this.zze = iZzc;
        } catch (zzoq e4) {
            this.zze = i4;
            zzF(str, e4);
        } catch (IndexOutOfBoundsException e5) {
            throw new zzlk(e5);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final int zzy() {
        return this.zzd - this.zze;
    }
}
