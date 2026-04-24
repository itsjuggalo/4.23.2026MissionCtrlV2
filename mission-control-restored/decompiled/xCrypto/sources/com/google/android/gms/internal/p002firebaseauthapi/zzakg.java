package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
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

        public zza(int i4) {
            super();
            if (i4 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i4, 20)];
            this.zza = bArr;
            this.zzb = bArr.length;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final int zza() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        public final void zzb(int i4) {
            if (!zzakg.zzb) {
                while ((i4 & (-128)) != 0) {
                    byte[] bArr = this.zza;
                    int i5 = this.zzc;
                    this.zzc = i5 + 1;
                    bArr[i5] = (byte) (i4 | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                    this.zzd++;
                    i4 >>>= 7;
                }
                byte[] bArr2 = this.zza;
                int i6 = this.zzc;
                this.zzc = i6 + 1;
                bArr2[i6] = (byte) i4;
                this.zzd++;
                return;
            }
            long j4 = this.zzc;
            while ((i4 & (-128)) != 0) {
                byte[] bArr3 = this.zza;
                int i7 = this.zzc;
                this.zzc = i7 + 1;
                zzanp.zza(bArr3, i7, (byte) (i4 | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS));
                i4 >>>= 7;
            }
            byte[] bArr4 = this.zza;
            int i8 = this.zzc;
            this.zzc = i8 + 1;
            zzanp.zza(bArr4, i8, (byte) i4);
            this.zzd += (int) (((long) this.zzc) - j4);
        }

        public final void zza(byte b4) {
            int i4 = this.zzc;
            this.zza[i4] = b4;
            this.zzc = i4 + 1;
            this.zzd++;
        }

        public final void zza(int i4) {
            int i5 = this.zzc;
            byte[] bArr = this.zza;
            bArr[i5] = (byte) i4;
            bArr[i5 + 1] = (byte) (i4 >> 8);
            bArr[i5 + 2] = (byte) (i4 >> 16);
            bArr[i5 + 3] = i4 >> 24;
            this.zzc = i5 + 4;
            this.zzd += 4;
        }

        public final void zzb(long j4) {
            if (zzakg.zzb) {
                long j5 = this.zzc;
                while ((j4 & (-128)) != 0) {
                    byte[] bArr = this.zza;
                    int i4 = this.zzc;
                    this.zzc = i4 + 1;
                    zzanp.zza(bArr, i4, (byte) (((int) j4) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS));
                    j4 >>>= 7;
                }
                byte[] bArr2 = this.zza;
                int i5 = this.zzc;
                this.zzc = i5 + 1;
                zzanp.zza(bArr2, i5, (byte) j4);
                this.zzd += (int) (((long) this.zzc) - j5);
                return;
            }
            while ((j4 & (-128)) != 0) {
                byte[] bArr3 = this.zza;
                int i6 = this.zzc;
                this.zzc = i6 + 1;
                bArr3[i6] = (byte) (((int) j4) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                this.zzd++;
                j4 >>>= 7;
            }
            byte[] bArr4 = this.zza;
            int i7 = this.zzc;
            this.zzc = i7 + 1;
            bArr4[i7] = (byte) j4;
            this.zzd++;
        }

        public final void zza(long j4) {
            int i4 = this.zzc;
            byte[] bArr = this.zza;
            bArr[i4] = (byte) j4;
            bArr[i4 + 1] = (byte) (j4 >> 8);
            bArr[i4 + 2] = (byte) (j4 >> 16);
            bArr[i4 + 3] = (byte) (j4 >> 24);
            bArr[i4 + 4] = (byte) (j4 >> 32);
            bArr[i4 + 5] = (byte) (j4 >> 40);
            bArr[i4 + 6] = (byte) (j4 >> 48);
            bArr[i4 + 7] = (byte) (j4 >> 56);
            this.zzc = i4 + 8;
            this.zzd += 8;
        }

        public final void zza(int i4, int i5) {
            zzb((i4 << 3) | i5);
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

        public zzb(int i4, int i5, int i6, Throwable th) {
            this(i4, i5, i6, th);
        }

        private zzb(long j4, long j5, int i4, Throwable th) {
            this(String.format(Locale.US, "Pos: %d, limit: %d, len: %d", Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i4)), th);
        }
    }

    public static class zzc extends zzakg {
        private final byte[] zza;
        private final int zzb;
        private int zzc;

        public zzc(byte[] bArr, int i4, int i5) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            if (((bArr.length - i5) | i5) < 0) {
                throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i5)));
            }
            this.zza = bArr;
            this.zzc = 0;
            this.zzb = i5;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final int zza() {
            return this.zzb - this.zzc;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(byte b4) throws zzb {
            int i4 = this.zzc;
            try {
                int i5 = i4 + 1;
                try {
                    this.zza[i4] = b4;
                    this.zzc = i5;
                } catch (IndexOutOfBoundsException e4) {
                    e = e4;
                    i4 = i5;
                    throw new zzb(i4, this.zzb, 1, (Throwable) e);
                }
            } catch (IndexOutOfBoundsException e5) {
                e = e5;
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzc() {
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzd(int i4, zzajp zzajpVar) {
            zzk(1, 3);
            zzl(2, i4);
            zzc(3, zzajpVar);
            zzk(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzf(int i4, long j4) {
            zzk(i4, 1);
            zzh(j4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzh(int i4, int i5) {
            zzk(i4, 5);
            zzk(i5);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzi(int i4, int i5) {
            zzk(i4, 0);
            zzl(i5);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzj(long j4) throws zzb {
            int i4;
            int i5;
            int i6 = this.zzc;
            if (!zzakg.zzb || zza() < 10) {
                while ((j4 & (-128)) != 0) {
                    try {
                        i5 = i6 + 1;
                    } catch (IndexOutOfBoundsException e4) {
                        e = e4;
                    }
                    try {
                        this.zza[i6] = (byte) (((int) j4) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                        j4 >>>= 7;
                        i6 = i5;
                    } catch (IndexOutOfBoundsException e5) {
                        e = e5;
                        i6 = i5;
                        throw new zzb(i6, this.zzb, 1, (Throwable) e);
                    }
                }
                i4 = i6 + 1;
                try {
                    this.zza[i6] = (byte) j4;
                } catch (IndexOutOfBoundsException e6) {
                    e = e6;
                    i6 = i4;
                    throw new zzb(i6, this.zzb, 1, (Throwable) e);
                }
            } else {
                while ((j4 & (-128)) != 0) {
                    zzanp.zza(this.zza, i6, (byte) (((int) j4) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS));
                    j4 >>>= 7;
                    i6++;
                }
                i4 = i6 + 1;
                zzanp.zza(this.zza, i6, (byte) j4);
            }
            this.zzc = i4;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzk(int i4) throws zzb {
            int i5 = this.zzc;
            try {
                byte[] bArr = this.zza;
                bArr[i5] = (byte) i4;
                bArr[i5 + 1] = (byte) (i4 >> 8);
                bArr[i5 + 2] = (byte) (i4 >> 16);
                bArr[i5 + 3] = i4 >> 24;
                this.zzc = i5 + 4;
            } catch (IndexOutOfBoundsException e4) {
                throw new zzb(i5, this.zzb, 4, (Throwable) e4);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzl(int i4) {
            if (i4 >= 0) {
                zzn(i4);
            } else {
                zzj(i4);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzn(int i4) throws zzb {
            int i5;
            int i6 = this.zzc;
            while ((i4 & (-128)) != 0) {
                try {
                    i5 = i6 + 1;
                    try {
                        this.zza[i6] = (byte) (i4 | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                        i4 >>>= 7;
                        i6 = i5;
                    } catch (IndexOutOfBoundsException e4) {
                        e = e4;
                        i6 = i5;
                        throw new zzb(i6, this.zzb, 1, (Throwable) e);
                    }
                } catch (IndexOutOfBoundsException e5) {
                    e = e5;
                    throw new zzb(i6, this.zzb, 1, (Throwable) e);
                }
            }
            i5 = i6 + 1;
            this.zza[i6] = (byte) i4;
            this.zzc = i5;
        }

        private final void zzc(byte[] bArr, int i4, int i5) throws zzb {
            try {
                System.arraycopy(bArr, i4, this.zza, this.zzc, i5);
                this.zzc += i5;
            } catch (IndexOutOfBoundsException e4) {
                throw new zzb(this.zzc, this.zzb, i5, (Throwable) e4);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajm
        public final void zza(byte[] bArr, int i4, int i5) throws zzb {
            zzc(bArr, i4, i5);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzh(long j4) throws zzb {
            int i4 = this.zzc;
            try {
                byte[] bArr = this.zza;
                bArr[i4] = (byte) j4;
                bArr[i4 + 1] = (byte) (j4 >> 8);
                bArr[i4 + 2] = (byte) (j4 >> 16);
                bArr[i4 + 3] = (byte) (j4 >> 24);
                bArr[i4 + 4] = (byte) (j4 >> 32);
                bArr[i4 + 5] = (byte) (j4 >> 40);
                bArr[i4 + 6] = (byte) (j4 >> 48);
                bArr[i4 + 7] = (byte) (j4 >> 56);
                this.zzc = i4 + 8;
            } catch (IndexOutOfBoundsException e4) {
                throw new zzb(i4, this.zzb, 8, (Throwable) e4);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzl(int i4, int i5) {
            zzk(i4, 0);
            zzn(i5);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(int i4, boolean z4) {
            zzk(i4, 0);
            zzb(z4 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzc(int i4, zzajp zzajpVar) {
            zzk(i4, 2);
            zzb(zzajpVar);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(byte[] bArr, int i4, int i5) throws zzb {
            zzn(i5);
            zzc(bArr, 0, i5);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzc(int i4, zzamc zzamcVar, zzamv zzamvVar) {
            zzk(i4, 2);
            zzn(((zzajf) zzamcVar).zza(zzamvVar));
            zzamvVar.zza(zzamcVar, this.zze);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzk(int i4, int i5) {
            zzn((i4 << 3) | i5);
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
        public final void zzb(int i4, zzamc zzamcVar) {
            zzk(1, 3);
            zzl(2, i4);
            zzk(3, 2);
            zzc(zzamcVar);
            zzk(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzh(int i4, long j4) {
            zzk(i4, 0);
            zzj(j4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(int i4, String str) {
            zzk(i4, 2);
            zzb(str);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(String str) throws zzb {
            int i4 = this.zzc;
            try {
                int iZzj = zzakg.zzj(str.length() * 3);
                int iZzj2 = zzakg.zzj(str.length());
                if (iZzj2 == iZzj) {
                    int i5 = i4 + iZzj2;
                    this.zzc = i5;
                    int iZza = zzant.zza(str, this.zza, i5, zza());
                    this.zzc = i4;
                    zzn((iZza - i4) - iZzj2);
                    this.zzc = iZza;
                    return;
                }
                zzn(zzant.zza(str));
                this.zzc = zzant.zza(str, this.zza, this.zzc, zza());
            } catch (zzanx e4) {
                this.zzc = i4;
                zza(str, e4);
            } catch (IndexOutOfBoundsException e5) {
                throw new zzb(e5);
            }
        }
    }

    public static int zza(double d4) {
        return 8;
    }

    public static int zzb(int i4, int i5) {
        return zzj(i4 << 3) + zzg(i5);
    }

    public static int zzc(long j4) {
        return 8;
    }

    public static int zzd(int i4) {
        return 4;
    }

    public static int zze(long j4) {
        return 8;
    }

    public static int zzf(int i4) {
        if (i4 > 4096) {
            return 4096;
        }
        return i4;
    }

    public static int zzg(int i4) {
        return 4;
    }

    public static int zzh(int i4) {
        return zzj(zza(i4));
    }

    public static int zzi(int i4) {
        return zzj(i4 << 3);
    }

    public static int zzj(int i4) {
        return (352 - (Integer.numberOfLeadingZeros(i4) * 9)) >>> 6;
    }

    public abstract int zza();

    public abstract void zzb(byte b4);

    public abstract void zzb(int i4, zzamc zzamcVar);

    public abstract void zzb(int i4, String str);

    public abstract void zzb(int i4, boolean z4);

    public abstract void zzb(zzajp zzajpVar);

    public abstract void zzb(zzamc zzamcVar, zzamv zzamvVar);

    public abstract void zzb(String str);

    public abstract void zzb(byte[] bArr, int i4, int i5);

    public abstract void zzc();

    public abstract void zzc(int i4, zzajp zzajpVar);

    public abstract void zzc(int i4, zzamc zzamcVar, zzamv zzamvVar);

    public abstract void zzc(zzamc zzamcVar);

    public abstract void zzd(int i4, zzajp zzajpVar);

    public abstract void zzf(int i4, long j4);

    public abstract void zzh(int i4, int i5);

    public abstract void zzh(int i4, long j4);

    public abstract void zzh(long j4);

    public abstract void zzi(int i4, int i5);

    public abstract void zzj(long j4);

    public abstract void zzk(int i4);

    public abstract void zzk(int i4, int i5);

    public abstract void zzl(int i4);

    public abstract void zzl(int i4, int i5);

    public final void zzm(int i4) {
        zzn(zza(i4));
    }

    public abstract void zzn(int i4);

    public static final class zzd extends zza {
        private final OutputStream zzf;

        public zzd(OutputStream outputStream, int i4) {
            super(i4);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.zzf = outputStream;
        }

        private final void zze() throws IOException {
            this.zzf.write(this.zza, 0, this.zzc);
            this.zzc = 0;
        }

        private final void zzo(int i4) throws IOException {
            if (this.zzb - this.zzc < i4) {
                zze();
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajm
        public final void zza(byte[] bArr, int i4, int i5) throws IOException {
            zzc(bArr, i4, i5);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(byte b4) throws IOException {
            if (this.zzc == this.zzb) {
                zze();
            }
            zza(b4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzc() throws IOException {
            if (this.zzc > 0) {
                zze();
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzd(int i4, zzajp zzajpVar) {
            zzk(1, 3);
            zzl(2, i4);
            zzc(3, zzajpVar);
            zzk(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzf(int i4, long j4) throws IOException {
            zzo(18);
            zza(i4, 1);
            zza(j4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzh(int i4, int i5) throws IOException {
            zzo(14);
            zza(i4, 5);
            zza(i5);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzi(int i4, int i5) throws IOException {
            zzo(20);
            zza(i4, 0);
            if (i5 >= 0) {
                zzb(i5);
            } else {
                zzb(i5);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzj(long j4) throws IOException {
            zzo(10);
            zzb(j4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzk(int i4) throws IOException {
            zzo(4);
            zza(i4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzl(int i4) {
            if (i4 >= 0) {
                zzn(i4);
            } else {
                zzj(i4);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzn(int i4) throws IOException {
            zzo(5);
            zzb(i4);
        }

        private final void zzc(byte[] bArr, int i4, int i5) throws IOException {
            int i6 = this.zzb;
            int i7 = this.zzc;
            if (i6 - i7 >= i5) {
                System.arraycopy(bArr, i4, this.zza, i7, i5);
                this.zzc += i5;
            } else {
                int i8 = i6 - i7;
                System.arraycopy(bArr, i4, this.zza, i7, i8);
                int i9 = i4 + i8;
                i5 -= i8;
                this.zzc = this.zzb;
                this.zzd += i8;
                zze();
                if (i5 <= this.zzb) {
                    System.arraycopy(bArr, i9, this.zza, 0, i5);
                    this.zzc = i5;
                } else {
                    this.zzf.write(bArr, i9, i5);
                }
            }
            this.zzd += i5;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzk(int i4, int i5) {
            zzn((i4 << 3) | i5);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzl(int i4, int i5) throws IOException {
            zzo(20);
            zza(i4, 0);
            zzb(i5);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(int i4, boolean z4) throws IOException {
            zzo(11);
            zza(i4, 0);
            zza(z4 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzh(long j4) throws IOException {
            zzo(8);
            zza(j4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzh(int i4, long j4) throws IOException {
            zzo(20);
            zza(i4, 0);
            zzb(j4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(byte[] bArr, int i4, int i5) throws IOException {
            zzn(i5);
            zzc(bArr, 0, i5);
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
        public final void zzb(int i4, zzamc zzamcVar) {
            zzk(1, 3);
            zzl(2, i4);
            zzk(3, 2);
            zzc(zzamcVar);
            zzk(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzc(int i4, zzajp zzajpVar) {
            zzk(i4, 2);
            zzb(zzajpVar);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzc(int i4, zzamc zzamcVar, zzamv zzamvVar) {
            zzk(i4, 2);
            zzb(zzamcVar, zzamvVar);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final void zzb(int i4, String str) {
            zzk(i4, 2);
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
                int i4 = iZzj + length;
                int i5 = this.zzb;
                if (i4 > i5) {
                    byte[] bArr = new byte[length];
                    int iZza2 = zzant.zza(str, bArr, 0, length);
                    zzn(iZza2);
                    zza(bArr, 0, iZza2);
                    return;
                }
                if (i4 > i5 - this.zzc) {
                    zze();
                }
                int iZzj2 = zzakg.zzj(str.length());
                int i6 = this.zzc;
                try {
                    if (iZzj2 == iZzj) {
                        int i7 = i6 + iZzj2;
                        this.zzc = i7;
                        int iZza3 = zzant.zza(str, this.zza, i7, this.zzb - i7);
                        this.zzc = i6;
                        iZza = (iZza3 - i6) - iZzj2;
                        zzb(iZza);
                        this.zzc = iZza3;
                    } else {
                        iZza = zzant.zza(str);
                        zzb(iZza);
                        this.zzc = zzant.zza(str, this.zza, this.zzc, iZza);
                    }
                    this.zzd += iZza;
                } catch (zzanx e4) {
                    this.zzd -= this.zzc - i6;
                    this.zzc = i6;
                    throw e4;
                } catch (ArrayIndexOutOfBoundsException e5) {
                    throw new zzb(e5);
                }
            } catch (zzanx e6) {
                zza(str, e6);
            }
        }
    }

    private zzakg() {
    }

    public static int zza(float f4) {
        return 4;
    }

    public static int zzc(int i4) {
        return zzg(i4);
    }

    public static int zze(int i4) {
        return zzg(i4);
    }

    public static int zzf(int i4, int i5) {
        return zzj(i4 << 3) + zzj(zza(i5));
    }

    public static int zzg(int i4, int i5) {
        return zzj(i4 << 3) + zzj(i5);
    }

    public final void zzi(long j4) {
        zzj(zza(j4));
    }

    public final void zzj(int i4, int i5) {
        zzl(i4, zza(i5));
    }

    private static int zza(int i4) {
        return (i4 >> 31) ^ (i4 << 1);
    }

    public static int zzb(int i4, long j4) {
        return zzj(i4 << 3) + zzg(j4);
    }

    public static int zzc(int i4, int i5) {
        return zzj(i4 << 3) + 4;
    }

    public static int zzd(int i4, int i5) {
        return zzj(i4 << 3) + zzg(i5);
    }

    public static int zze(int i4, int i5) {
        return zzj(i4 << 3) + 4;
    }

    public static int zza(boolean z4) {
        return 1;
    }

    public static int zzc(int i4, long j4) {
        return zzj(i4 << 3) + 8;
    }

    public static int zze(int i4, long j4) {
        return zzj(i4 << 3) + zzg(j4);
    }

    public static int zzf(long j4) {
        return zzg(zza(j4));
    }

    public static int zzg(long j4) {
        return (640 - (Long.numberOfLeadingZeros(j4) * 9)) >>> 6;
    }

    private static long zza(long j4) {
        return (j4 >> 63) ^ (j4 << 1);
    }

    public static int zzb(int i4, zzalk zzalkVar) {
        int iZzj = zzj(i4 << 3);
        int iZza = zzalkVar.zza();
        return iZzj + zzj(iZza) + iZza;
    }

    public static int zzd(long j4) {
        return zzg(j4);
    }

    public final void zzg(int i4, long j4) {
        zzh(i4, zza(j4));
    }

    public static int zza(int i4, boolean z4) {
        return zzj(i4 << 3) + 1;
    }

    public static int zzd(int i4, long j4) {
        return zzj(i4 << 3) + zzg(zza(j4));
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        return zzj(length) + length;
    }

    public static int zzb(int i4, zzamc zzamcVar, zzamv zzamvVar) {
        return zzj(i4 << 3) + zza(zzamcVar, zzamvVar);
    }

    public static int zza(int i4, zzajp zzajpVar) {
        int iZzj = zzj(i4 << 3);
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

    public static int zzb(int i4, zzajp zzajpVar) {
        return (zzj(8) << 1) + zzg(2, i4) + zza(3, zzajpVar);
    }

    public static int zza(int i4, double d4) {
        return zzj(i4 << 3) + 8;
    }

    public static int zza(int i4, long j4) {
        return zzj(i4 << 3) + 8;
    }

    public static zzakg zzb(byte[] bArr) {
        return new zzc(bArr, 0, bArr.length);
    }

    public static int zza(int i4, float f4) {
        return zzj(i4 << 3) + 4;
    }

    @Deprecated
    public static int zza(int i4, zzamc zzamcVar, zzamv zzamvVar) {
        return (zzj(i4 << 3) << 1) + ((zzajf) zzamcVar).zza(zzamvVar);
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

    public final void zzb(boolean z4) {
        zzb(z4 ? (byte) 1 : (byte) 0);
    }

    public static int zza(int i4, zzalk zzalkVar) {
        return (zzj(8) << 1) + zzg(2, i4) + zzb(3, zzalkVar);
    }

    public final void zzb(int i4, double d4) {
        zzf(i4, Double.doubleToRawLongBits(d4));
    }

    public final void zzb(double d4) {
        zzh(Double.doubleToRawLongBits(d4));
    }

    public final void zzb(int i4, float f4) {
        zzh(i4, Float.floatToRawIntBits(f4));
    }

    public static int zza(zzalk zzalkVar) {
        int iZza = zzalkVar.zza();
        return zzj(iZza) + iZza;
    }

    public final void zzb(float f4) {
        zzk(Float.floatToRawIntBits(f4));
    }

    public static int zza(int i4, zzamc zzamcVar) {
        return (zzj(8) << 1) + zzg(2, i4) + zzj(24) + zzb(zzamcVar);
    }

    public static int zza(zzamc zzamcVar, zzamv zzamvVar) {
        int iZza = ((zzajf) zzamcVar).zza(zzamvVar);
        return zzj(iZza) + iZza;
    }

    public static int zza(int i4, String str) {
        return zzj(i4 << 3) + zza(str);
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

    public static zzakg zza(OutputStream outputStream, int i4) {
        return new zzd(outputStream, i4);
    }

    public final void zza(String str, zzanx zzanxVar) throws zzb {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzanxVar);
        byte[] bytes = str.getBytes(zzalb.zza);
        try {
            zzn(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzb(e4);
        }
    }
}
