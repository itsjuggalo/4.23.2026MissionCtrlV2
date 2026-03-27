package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzakg extends zzajm {
    private static final Logger zza = Logger.getLogger(zzakg.class.getName());
    private static final boolean zzb = zzanp.zzc();
    zzakj zze;

    public static abstract class zza extends zzakg {
        final byte[] zza;
        final int zzb;
        int zzc;
        int zzd;

        public zza(int i7) {
            super();
            if (i7 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i7, 20)];
            this.zza = bArr;
            this.zzb = bArr.length;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final int zza() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        public final void zzb(int i7) {
            if (!zzakg.zzb) {
                while ((i7 & (-128)) != 0) {
                    byte[] bArr = this.zza;
                    int i8 = this.zzc;
                    this.zzc = i8 + 1;
                    bArr[i8] = (byte) (i7 | 128);
                    this.zzd++;
                    i7 >>>= 7;
                }
                byte[] bArr2 = this.zza;
                int i9 = this.zzc;
                this.zzc = i9 + 1;
                bArr2[i9] = (byte) i7;
                this.zzd++;
                return;
            }
            long j7 = this.zzc;
            while ((i7 & (-128)) != 0) {
                byte[] bArr3 = this.zza;
                int i10 = this.zzc;
                this.zzc = i10 + 1;
                zzanp.zza(bArr3, i10, (byte) (i7 | 128));
                i7 >>>= 7;
            }
            byte[] bArr4 = this.zza;
            int i11 = this.zzc;
            this.zzc = i11 + 1;
            zzanp.zza(bArr4, i11, (byte) i7);
            this.zzd += (int) (((long) this.zzc) - j7);
        }

        public final void zza(byte b7) {
            int i7 = this.zzc;
            this.zza[i7] = b7;
            this.zzc = i7 + 1;
            this.zzd++;
        }

        public final void zza(int i7) {
            int i8 = this.zzc;
            byte[] bArr = this.zza;
            bArr[i8] = (byte) i7;
            bArr[i8 + 1] = (byte) (i7 >> 8);
            bArr[i8 + 2] = (byte) (i7 >> 16);
            bArr[i8 + 3] = i7 >> 24;
            this.zzc = i8 + 4;
            this.zzd += 4;
        }

        public final void zzb(long j7) {
            if (zzakg.zzb) {
                long j8 = this.zzc;
                while ((j7 & (-128)) != 0) {
                    byte[] bArr = this.zza;
                    int i7 = this.zzc;
                    this.zzc = i7 + 1;
                    zzanp.zza(bArr, i7, (byte) (((int) j7) | 128));
                    j7 >>>= 7;
                }
                byte[] bArr2 = this.zza;
                int i8 = this.zzc;
                this.zzc = i8 + 1;
                zzanp.zza(bArr2, i8, (byte) j7);
                this.zzd += (int) (((long) this.zzc) - j8);
                return;
            }
            while ((j7 & (-128)) != 0) {
                byte[] bArr3 = this.zza;
                int i9 = this.zzc;
                this.zzc = i9 + 1;
                bArr3[i9] = (byte) (((int) j7) | 128);
                this.zzd++;
                j7 >>>= 7;
            }
            byte[] bArr4 = this.zza;
            int i10 = this.zzc;
            this.zzc = i10 + 1;
            bArr4[i10] = (byte) j7;
            this.zzd++;
        }

        public final void zza(long j7) {
            int i7 = this.zzc;
            byte[] bArr = this.zza;
            bArr[i7] = (byte) j7;
            bArr[i7 + 1] = (byte) (j7 >> 8);
            bArr[i7 + 2] = (byte) (j7 >> 16);
            bArr[i7 + 3] = (byte) (j7 >> 24);
            bArr[i7 + 4] = (byte) (j7 >> 32);
            bArr[i7 + 5] = (byte) (j7 >> 40);
            bArr[i7 + 6] = (byte) (j7 >> 48);
            bArr[i7 + 7] = (byte) (j7 >> 56);
            this.zzc = i7 + 8;
            this.zzd += 8;
        }

        public final void zza(int i7, int i8) {
            zzb((i7 << 3) | i8);
        }
    }

    public static class zzb extends IOException {
        public zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        public zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        private zzb(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }

        public zzb(int i7, int i8, int i9, Throwable th) {
            this(i7, i8, i9, th);
        }

        private zzb(long j7, long j8, int i7, Throwable th) {
            this(String.format(Locale.US, "Pos: %d, limit: %d, len: %d", Long.valueOf(j7), Long.valueOf(j8), Integer.valueOf(i7)), th);
        }
    }

    public static class zzc extends zzakg {
        private final byte[] zza;
        private final int zzb;
        private int zzc;

        public zzc(byte[] bArr, int i7, int i8) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            if (((bArr.length - i8) | i8) < 0) {
                throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i8)));
            }
            this.zza = bArr;
            this.zzc = 0;
            this.zzb = i8;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final int zza() {
            return this.zzb - this.zzc;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(byte b7) throws zzb {
            int i7 = this.zzc;
            try {
                int i8 = i7 + 1;
                try {
                    this.zza[i7] = b7;
                    this.zzc = i8;
                } catch (IndexOutOfBoundsException e7) {
                    e = e7;
                    i7 = i8;
                    throw new zzb(i7, this.zzb, 1, (Throwable) e);
                }
            } catch (IndexOutOfBoundsException e8) {
                e = e8;
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzc() {
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzd(int i7, zzajp zzajpVar) {
            zzk(1, 3);
            zzl(2, i7);
            zzc(3, zzajpVar);
            zzk(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzf(int i7, long j7) {
            zzk(i7, 1);
            zzh(j7);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzh(int i7, int i8) {
            zzk(i7, 5);
            zzk(i8);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzi(int i7, int i8) {
            zzk(i7, 0);
            zzl(i8);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzj(long j7) throws zzb {
            int i7;
            int i8;
            int i9 = this.zzc;
            if (!zzakg.zzb || zza() < 10) {
                while ((j7 & (-128)) != 0) {
                    try {
                        i8 = i9 + 1;
                    } catch (IndexOutOfBoundsException e7) {
                        e = e7;
                    }
                    try {
                        this.zza[i9] = (byte) (((int) j7) | 128);
                        j7 >>>= 7;
                        i9 = i8;
                    } catch (IndexOutOfBoundsException e8) {
                        e = e8;
                        i9 = i8;
                        throw new zzb(i9, this.zzb, 1, (Throwable) e);
                    }
                }
                i7 = i9 + 1;
                try {
                    this.zza[i9] = (byte) j7;
                } catch (IndexOutOfBoundsException e9) {
                    e = e9;
                    i9 = i7;
                    throw new zzb(i9, this.zzb, 1, (Throwable) e);
                }
            } else {
                while ((j7 & (-128)) != 0) {
                    zzanp.zza(this.zza, i9, (byte) (((int) j7) | 128));
                    j7 >>>= 7;
                    i9++;
                }
                i7 = i9 + 1;
                zzanp.zza(this.zza, i9, (byte) j7);
            }
            this.zzc = i7;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzk(int i7) throws zzb {
            int i8 = this.zzc;
            try {
                byte[] bArr = this.zza;
                bArr[i8] = (byte) i7;
                bArr[i8 + 1] = (byte) (i7 >> 8);
                bArr[i8 + 2] = (byte) (i7 >> 16);
                bArr[i8 + 3] = i7 >> 24;
                this.zzc = i8 + 4;
            } catch (IndexOutOfBoundsException e7) {
                throw new zzb(i8, this.zzb, 4, (Throwable) e7);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzl(int i7) {
            if (i7 >= 0) {
                zzn(i7);
            } else {
                zzj(i7);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzn(int i7) throws zzb {
            int i8;
            int i9 = this.zzc;
            while ((i7 & (-128)) != 0) {
                try {
                    i8 = i9 + 1;
                    try {
                        this.zza[i9] = (byte) (i7 | 128);
                        i7 >>>= 7;
                        i9 = i8;
                    } catch (IndexOutOfBoundsException e7) {
                        e = e7;
                        i9 = i8;
                        throw new zzb(i9, this.zzb, 1, (Throwable) e);
                    }
                } catch (IndexOutOfBoundsException e8) {
                    e = e8;
                    throw new zzb(i9, this.zzb, 1, (Throwable) e);
                }
            }
            i8 = i9 + 1;
            this.zza[i9] = (byte) i7;
            this.zzc = i8;
        }

        private final void zzc(byte[] bArr, int i7, int i8) throws zzb {
            try {
                System.arraycopy(bArr, i7, this.zza, this.zzc, i8);
                this.zzc += i8;
            } catch (IndexOutOfBoundsException e7) {
                throw new zzb(this.zzc, this.zzb, i8, (Throwable) e7);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajm
        public final void zza(byte[] bArr, int i7, int i8) throws zzb {
            zzc(bArr, i7, i8);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzh(long j7) throws zzb {
            int i7 = this.zzc;
            try {
                byte[] bArr = this.zza;
                bArr[i7] = (byte) j7;
                bArr[i7 + 1] = (byte) (j7 >> 8);
                bArr[i7 + 2] = (byte) (j7 >> 16);
                bArr[i7 + 3] = (byte) (j7 >> 24);
                bArr[i7 + 4] = (byte) (j7 >> 32);
                bArr[i7 + 5] = (byte) (j7 >> 40);
                bArr[i7 + 6] = (byte) (j7 >> 48);
                bArr[i7 + 7] = (byte) (j7 >> 56);
                this.zzc = i7 + 8;
            } catch (IndexOutOfBoundsException e7) {
                throw new zzb(i7, this.zzb, 8, (Throwable) e7);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzl(int i7, int i8) {
            zzk(i7, 0);
            zzn(i8);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(int i7, boolean z7) {
            zzk(i7, 0);
            zzb(z7 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzc(int i7, zzajp zzajpVar) {
            zzk(i7, 2);
            zzb(zzajpVar);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(byte[] bArr, int i7, int i8) throws zzb {
            zzn(i8);
            zzc(bArr, 0, i8);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzc(int i7, zzamc zzamcVar, zzamv zzamvVar) {
            zzk(i7, 2);
            zzn(((zzajf) zzamcVar).zza(zzamvVar));
            zzamvVar.zza(zzamcVar, this.zze);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzk(int i7, int i8) {
            zzn((i7 << 3) | i8);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(zzajp zzajpVar) {
            zzn(zzajpVar.zzb());
            zzajpVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzc(zzamc zzamcVar) {
            zzn(zzamcVar.zzl());
            zzamcVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(zzamc zzamcVar, zzamv zzamvVar) {
            zzn(((zzajf) zzamcVar).zza(zzamvVar));
            zzamvVar.zza(zzamcVar, this.zze);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(int i7, zzamc zzamcVar) {
            zzk(1, 3);
            zzl(2, i7);
            zzk(3, 2);
            zzc(zzamcVar);
            zzk(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzh(int i7, long j7) {
            zzk(i7, 0);
            zzj(j7);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(int i7, String str) {
            zzk(i7, 2);
            zzb(str);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(String str) throws zzb {
            int i7 = this.zzc;
            try {
                int iZzj = zzakg.zzj(str.length() * 3);
                int iZzj2 = zzakg.zzj(str.length());
                if (iZzj2 == iZzj) {
                    int i8 = i7 + iZzj2;
                    this.zzc = i8;
                    int iZza = zzant.zza(str, this.zza, i8, zza());
                    this.zzc = i7;
                    zzn((iZza - i7) - iZzj2);
                    this.zzc = iZza;
                    return;
                }
                zzn(zzant.zza(str));
                this.zzc = zzant.zza(str, this.zza, this.zzc, zza());
            } catch (zzanx e7) {
                this.zzc = i7;
                zza(str, e7);
            } catch (IndexOutOfBoundsException e8) {
                throw new zzb(e8);
            }
        }
    }

    public static int zza(double d7) {
        return 8;
    }

    public static int zzb(int i7, int i8) {
        return zzj(i7 << 3) + zzg(i8);
    }

    public static int zzc(long j7) {
        return 8;
    }

    public static int zzd(int i7) {
        return 4;
    }

    public static int zze(long j7) {
        return 8;
    }

    public static int zzf(int i7) {
        if (i7 > 4096) {
            return 4096;
        }
        return i7;
    }

    public static int zzg(int i7) {
        return 4;
    }

    public static int zzh(int i7) {
        return zzj(zza(i7));
    }

    public static int zzi(int i7) {
        return zzj(i7 << 3);
    }

    public static int zzj(int i7) {
        return (352 - (Integer.numberOfLeadingZeros(i7) * 9)) >>> 6;
    }

    public abstract int zza();

    public abstract void zzb(byte b7);

    public abstract void zzb(int i7, zzamc zzamcVar);

    public abstract void zzb(int i7, String str);

    public abstract void zzb(int i7, boolean z7);

    public abstract void zzb(zzajp zzajpVar);

    public abstract void zzb(zzamc zzamcVar, zzamv zzamvVar);

    public abstract void zzb(String str);

    public abstract void zzb(byte[] bArr, int i7, int i8);

    public abstract void zzc();

    public abstract void zzc(int i7, zzajp zzajpVar);

    public abstract void zzc(int i7, zzamc zzamcVar, zzamv zzamvVar);

    public abstract void zzc(zzamc zzamcVar);

    public abstract void zzd(int i7, zzajp zzajpVar);

    public abstract void zzf(int i7, long j7);

    public abstract void zzh(int i7, int i8);

    public abstract void zzh(int i7, long j7);

    public abstract void zzh(long j7);

    public abstract void zzi(int i7, int i8);

    public abstract void zzj(long j7);

    public abstract void zzk(int i7);

    public abstract void zzk(int i7, int i8);

    public abstract void zzl(int i7);

    public abstract void zzl(int i7, int i8);

    public final void zzm(int i7) {
        zzn(zza(i7));
    }

    public abstract void zzn(int i7);

    public static final class zzd extends zza {
        private final OutputStream zzf;

        public zzd(OutputStream outputStream, int i7) {
            super(i7);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.zzf = outputStream;
        }

        private final void zze() throws IOException {
            this.zzf.write(this.zza, 0, this.zzc);
            this.zzc = 0;
        }

        private final void zzo(int i7) throws IOException {
            if (this.zzb - this.zzc < i7) {
                zze();
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajm
        public final void zza(byte[] bArr, int i7, int i8) throws IOException {
            zzc(bArr, i7, i8);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(byte b7) throws IOException {
            if (this.zzc == this.zzb) {
                zze();
            }
            zza(b7);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzc() throws IOException {
            if (this.zzc > 0) {
                zze();
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzd(int i7, zzajp zzajpVar) {
            zzk(1, 3);
            zzl(2, i7);
            zzc(3, zzajpVar);
            zzk(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzf(int i7, long j7) throws IOException {
            zzo(18);
            zza(i7, 1);
            zza(j7);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzh(int i7, int i8) throws IOException {
            zzo(14);
            zza(i7, 5);
            zza(i8);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzi(int i7, int i8) throws IOException {
            zzo(20);
            zza(i7, 0);
            if (i8 >= 0) {
                zzb(i8);
            } else {
                zzb(i8);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzj(long j7) throws IOException {
            zzo(10);
            zzb(j7);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzk(int i7) throws IOException {
            zzo(4);
            zza(i7);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzl(int i7) {
            if (i7 >= 0) {
                zzn(i7);
            } else {
                zzj(i7);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzn(int i7) throws IOException {
            zzo(5);
            zzb(i7);
        }

        private final void zzc(byte[] bArr, int i7, int i8) throws IOException {
            int i9 = this.zzb;
            int i10 = this.zzc;
            if (i9 - i10 >= i8) {
                System.arraycopy(bArr, i7, this.zza, i10, i8);
                this.zzc += i8;
            } else {
                int i11 = i9 - i10;
                System.arraycopy(bArr, i7, this.zza, i10, i11);
                int i12 = i7 + i11;
                i8 -= i11;
                this.zzc = this.zzb;
                this.zzd += i11;
                zze();
                if (i8 <= this.zzb) {
                    System.arraycopy(bArr, i12, this.zza, 0, i8);
                    this.zzc = i8;
                } else {
                    this.zzf.write(bArr, i12, i8);
                }
            }
            this.zzd += i8;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzk(int i7, int i8) {
            zzn((i7 << 3) | i8);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzl(int i7, int i8) throws IOException {
            zzo(20);
            zza(i7, 0);
            zzb(i8);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(int i7, boolean z7) throws IOException {
            zzo(11);
            zza(i7, 0);
            zza(z7 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzh(long j7) throws IOException {
            zzo(8);
            zza(j7);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzh(int i7, long j7) throws IOException {
            zzo(20);
            zza(i7, 0);
            zzb(j7);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(byte[] bArr, int i7, int i8) throws IOException {
            zzn(i8);
            zzc(bArr, 0, i8);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(zzajp zzajpVar) {
            zzn(zzajpVar.zzb());
            zzajpVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(zzamc zzamcVar, zzamv zzamvVar) {
            zzn(((zzajf) zzamcVar).zza(zzamvVar));
            zzamvVar.zza(zzamcVar, this.zze);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(int i7, zzamc zzamcVar) {
            zzk(1, 3);
            zzl(2, i7);
            zzk(3, 2);
            zzc(zzamcVar);
            zzk(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzc(int i7, zzajp zzajpVar) {
            zzk(i7, 2);
            zzb(zzajpVar);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzc(int i7, zzamc zzamcVar, zzamv zzamvVar) {
            zzk(i7, 2);
            zzb(zzamcVar, zzamvVar);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(int i7, String str) {
            zzk(i7, 2);
            zzb(str);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzc(zzamc zzamcVar) {
            zzn(zzamcVar.zzl());
            zzamcVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(String str) throws IOException {
            int iZza;
            try {
                int length = str.length() * 3;
                int iZzj = zzakg.zzj(length);
                int i7 = iZzj + length;
                int i8 = this.zzb;
                if (i7 > i8) {
                    byte[] bArr = new byte[length];
                    int iZza2 = zzant.zza(str, bArr, 0, length);
                    zzn(iZza2);
                    zza(bArr, 0, iZza2);
                    return;
                }
                if (i7 > i8 - this.zzc) {
                    zze();
                }
                int iZzj2 = zzakg.zzj(str.length());
                int i9 = this.zzc;
                try {
                    if (iZzj2 == iZzj) {
                        int i10 = i9 + iZzj2;
                        this.zzc = i10;
                        int iZza3 = zzant.zza(str, this.zza, i10, this.zzb - i10);
                        this.zzc = i9;
                        iZza = (iZza3 - i9) - iZzj2;
                        zzb(iZza);
                        this.zzc = iZza3;
                    } else {
                        iZza = zzant.zza(str);
                        zzb(iZza);
                        this.zzc = zzant.zza(str, this.zza, this.zzc, iZza);
                    }
                    this.zzd += iZza;
                } catch (zzanx e7) {
                    this.zzd -= this.zzc - i9;
                    this.zzc = i9;
                    throw e7;
                } catch (ArrayIndexOutOfBoundsException e8) {
                    throw new zzb(e8);
                }
            } catch (zzanx e9) {
                zza(str, e9);
            }
        }
    }

    private zzakg() {
    }

    public static int zza(float f7) {
        return 4;
    }

    public static int zzc(int i7) {
        return zzg(i7);
    }

    public static int zze(int i7) {
        return zzg(i7);
    }

    public static int zzf(int i7, int i8) {
        return zzj(i7 << 3) + zzj(zza(i8));
    }

    public static int zzg(int i7, int i8) {
        return zzj(i7 << 3) + zzj(i8);
    }

    public final void zzi(long j7) {
        zzj(zza(j7));
    }

    public final void zzj(int i7, int i8) {
        zzl(i7, zza(i8));
    }

    private static int zza(int i7) {
        return (i7 >> 31) ^ (i7 << 1);
    }

    public static int zzb(int i7, long j7) {
        return zzj(i7 << 3) + zzg(j7);
    }

    public static int zzc(int i7, int i8) {
        return zzj(i7 << 3) + 4;
    }

    public static int zzd(int i7, int i8) {
        return zzj(i7 << 3) + zzg(i8);
    }

    public static int zze(int i7, int i8) {
        return zzj(i7 << 3) + 4;
    }

    public static int zza(boolean z7) {
        return 1;
    }

    public static int zzc(int i7, long j7) {
        return zzj(i7 << 3) + 8;
    }

    public static int zze(int i7, long j7) {
        return zzj(i7 << 3) + zzg(j7);
    }

    public static int zzf(long j7) {
        return zzg(zza(j7));
    }

    public static int zzg(long j7) {
        return (640 - (Long.numberOfLeadingZeros(j7) * 9)) >>> 6;
    }

    private static long zza(long j7) {
        return (j7 >> 63) ^ (j7 << 1);
    }

    public static int zzb(int i7, zzalk zzalkVar) {
        int iZzj = zzj(i7 << 3);
        int iZza = zzalkVar.zza();
        return iZzj + zzj(iZza) + iZza;
    }

    public static int zzd(long j7) {
        return zzg(j7);
    }

    public final void zzg(int i7, long j7) {
        zzh(i7, zza(j7));
    }

    public static int zza(int i7, boolean z7) {
        return zzj(i7 << 3) + 1;
    }

    public static int zzd(int i7, long j7) {
        return zzj(i7 << 3) + zzg(zza(j7));
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        return zzj(length) + length;
    }

    public static int zzb(int i7, zzamc zzamcVar, zzamv zzamvVar) {
        return zzj(i7 << 3) + zza(zzamcVar, zzamvVar);
    }

    public static int zza(int i7, zzajp zzajpVar) {
        int iZzj = zzj(i7 << 3);
        int iZzb = zzajpVar.zzb();
        return iZzj + zzj(iZzb) + iZzb;
    }

    public static int zzb(zzamc zzamcVar) {
        int iZzl = zzamcVar.zzl();
        return zzj(iZzl) + iZzl;
    }

    public static int zza(zzajp zzajpVar) {
        int iZzb = zzajpVar.zzb();
        return zzj(iZzb) + iZzb;
    }

    public static int zzb(int i7, zzajp zzajpVar) {
        return (zzj(8) << 1) + zzg(2, i7) + zza(3, zzajpVar);
    }

    public static int zza(int i7, double d7) {
        return zzj(i7 << 3) + 8;
    }

    public static int zza(int i7, long j7) {
        return zzj(i7 << 3) + 8;
    }

    public static zzakg zzb(byte[] bArr) {
        return new zzc(bArr, 0, bArr.length);
    }

    public static int zza(int i7, float f7) {
        return zzj(i7 << 3) + 4;
    }

    @Deprecated
    public static int zza(int i7, zzamc zzamcVar, zzamv zzamvVar) {
        return (zzj(i7 << 3) << 1) + ((zzajf) zzamcVar).zza(zzamvVar);
    }

    public final void zzb() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    @Deprecated
    public static int zza(zzamc zzamcVar) {
        return zzamcVar.zzl();
    }

    public final void zzb(boolean z7) {
        zzb(z7 ? (byte) 1 : (byte) 0);
    }

    public static int zza(int i7, zzalk zzalkVar) {
        return (zzj(8) << 1) + zzg(2, i7) + zzb(3, zzalkVar);
    }

    public final void zzb(int i7, double d7) {
        zzf(i7, Double.doubleToRawLongBits(d7));
    }

    public final void zzb(double d7) {
        zzh(Double.doubleToRawLongBits(d7));
    }

    public final void zzb(int i7, float f7) {
        zzh(i7, Float.floatToRawIntBits(f7));
    }

    public static int zza(zzalk zzalkVar) {
        int iZza = zzalkVar.zza();
        return zzj(iZza) + iZza;
    }

    public final void zzb(float f7) {
        zzk(Float.floatToRawIntBits(f7));
    }

    public static int zza(int i7, zzamc zzamcVar) {
        return (zzj(8) << 1) + zzg(2, i7) + zzj(24) + zzb(zzamcVar);
    }

    public static int zza(zzamc zzamcVar, zzamv zzamvVar) {
        int iZza = ((zzajf) zzamcVar).zza(zzamvVar);
        return zzj(iZza) + iZza;
    }

    public static int zza(int i7, String str) {
        return zzj(i7 << 3) + zza(str);
    }

    public static int zza(String str) {
        int length;
        try {
            length = zzant.zza(str);
        } catch (zzanx unused) {
            length = str.getBytes(zzalb.zza).length;
        }
        return zzj(length) + length;
    }

    public static zzakg zza(OutputStream outputStream, int i7) {
        return new zzd(outputStream, i7);
    }

    public final void zza(String str, zzanx zzanxVar) throws zzb {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzanxVar);
        byte[] bytes = str.getBytes(zzalb.zza);
        try {
            zzn(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e7) {
            throw new zzb(e7);
        }
    }
}
