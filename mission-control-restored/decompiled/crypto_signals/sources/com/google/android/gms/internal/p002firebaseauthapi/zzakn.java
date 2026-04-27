package com.google.android.gms.internal.p002firebaseauthapi;

import a3.d;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzakn extends zzajw {
    private static final Logger zzb = Logger.getLogger(zzakn.class.getName());
    private static final boolean zzc = zzanz.zzc();
    zzakp zza;

    public static class zza extends zzakn {
        private final byte[] zzb;
        private final int zzc;
        private int zzd;

        public zza(byte[] bArr, int i, int i6) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            if (((bArr.length - i6) | i6) < 0) {
                Locale locale = Locale.US;
                throw new IllegalArgumentException(d.h("Array range is invalid. Buffer.length=", bArr.length, i6, ", offset=0, length="));
            }
            this.zzb = bArr;
            this.zzd = 0;
            this.zzc = i6;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final int zza() {
            return this.zzc - this.zzd;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(int i, boolean z6) throws zzd {
            zzj(i, 0);
            zza(z6 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzc() {
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzd(int i, zzajv zzajvVar) throws zzd {
            zzj(1, 3);
            zzk(2, i);
            zzc(3, zzajvVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzf(int i, long j4) throws zzd {
            zzj(i, 1);
            zzf(j4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzg(int i, int i6) throws zzd {
            zzj(i, 5);
            zzj(i6);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzh(int i, int i6) throws zzd {
            zzj(i, 0);
            zzk(i6);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzj(int i) throws zzd {
            int i6 = this.zzd;
            try {
                byte[] bArr = this.zzb;
                bArr[i6] = (byte) i;
                bArr[i6 + 1] = (byte) (i >> 8);
                bArr[i6 + 2] = (byte) (i >> 16);
                bArr[i6 + 3] = i >> 24;
                this.zzd = i6 + 4;
            } catch (IndexOutOfBoundsException e) {
                throw new zzd(i6, this.zzc, 4, (Throwable) e);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzk(int i) throws zzd {
            if (i >= 0) {
                zzm(i);
            } else {
                zzh(i);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzm(int i) throws zzd {
            int i6;
            int i7 = this.zzd;
            while ((i & (-128)) != 0) {
                try {
                    i6 = i7 + 1;
                    try {
                        this.zzb[i7] = (byte) (i | 128);
                        i >>>= 7;
                        i7 = i6;
                    } catch (IndexOutOfBoundsException e) {
                        e = e;
                        i7 = i6;
                        throw new zzd(i7, this.zzc, 1, (Throwable) e);
                    }
                } catch (IndexOutOfBoundsException e2) {
                    e = e2;
                    throw new zzd(i7, this.zzc, 1, (Throwable) e);
                }
            }
            i6 = i7 + 1;
            this.zzb[i7] = (byte) i;
            this.zzd = i6;
        }

        private final void zzc(byte[] bArr, int i, int i6) throws zzd {
            try {
                System.arraycopy(bArr, i, this.zzb, this.zzd, i6);
                this.zzd += i6;
            } catch (IndexOutOfBoundsException e) {
                throw new zzd(this.zzd, this.zzc, i6, (Throwable) e);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zza(byte b3) throws zzd {
            int i = this.zzd;
            try {
                int i6 = i + 1;
                try {
                    this.zzb[i] = b3;
                    this.zzd = i6;
                } catch (IndexOutOfBoundsException e) {
                    e = e;
                    i = i6;
                    throw new zzd(i, this.zzc, 1, (Throwable) e);
                }
            } catch (IndexOutOfBoundsException e2) {
                e = e2;
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(byte[] bArr, int i, int i6) throws zzd {
            zzm(i6);
            zzc(bArr, 0, i6);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzf(long j4) throws zzd {
            int i = this.zzd;
            try {
                byte[] bArr = this.zzb;
                bArr[i] = (byte) j4;
                bArr[i + 1] = (byte) (j4 >> 8);
                bArr[i + 2] = (byte) (j4 >> 16);
                bArr[i + 3] = (byte) (j4 >> 24);
                bArr[i + 4] = (byte) (j4 >> 32);
                bArr[i + 5] = (byte) (j4 >> 40);
                bArr[i + 6] = (byte) (j4 >> 48);
                bArr[i + 7] = (byte) (j4 >> 56);
                this.zzd = i + 8;
            } catch (IndexOutOfBoundsException e) {
                throw new zzd(i, this.zzc, 8, (Throwable) e);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzh(int i, long j4) throws zzd {
            zzj(i, 0);
            zzh(j4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzk(int i, int i6) throws zzd {
            zzj(i, 0);
            zzm(i6);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(zzajv zzajvVar) throws zzd {
            zzm(zzajvVar.zzb());
            zzajvVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzc(int i, zzajv zzajvVar) throws zzd {
            zzj(i, 2);
            zzb(zzajvVar);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzh(long j4) throws zzd {
            int i;
            int i6;
            int i7 = this.zzd;
            if (zzakn.zzc && zza() >= 10) {
                while ((j4 & (-128)) != 0) {
                    zzanz.zza(this.zzb, i7, (byte) (((int) j4) | 128));
                    j4 >>>= 7;
                    i7++;
                }
                i = i7 + 1;
                zzanz.zza(this.zzb, i7, (byte) j4);
            } else {
                while ((j4 & (-128)) != 0) {
                    try {
                        i6 = i7 + 1;
                    } catch (IndexOutOfBoundsException e) {
                        e = e;
                    }
                    try {
                        this.zzb[i7] = (byte) (((int) j4) | 128);
                        j4 >>>= 7;
                        i7 = i6;
                    } catch (IndexOutOfBoundsException e2) {
                        e = e2;
                        i7 = i6;
                        throw new zzd(i7, this.zzc, 1, (Throwable) e);
                    }
                }
                i = i7 + 1;
                try {
                    this.zzb[i7] = (byte) j4;
                } catch (IndexOutOfBoundsException e6) {
                    e = e6;
                    i7 = i;
                    throw new zzd(i7, this.zzc, 1, (Throwable) e);
                }
            }
            this.zzd = i;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajw
        public final void zza(byte[] bArr, int i, int i6) throws zzd {
            zzc(bArr, i, i6);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(zzamm zzammVar) throws zzd {
            zzm(zzammVar.zzl());
            zzammVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzj(int i, int i6) throws zzd {
            zzm((i << 3) | i6);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(int i, zzamm zzammVar) throws zzd {
            zzj(1, 3);
            zzk(2, i);
            zzj(3, 2);
            zzb(zzammVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(int i, String str) throws zzd {
            zzj(i, 2);
            zzb(str);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(String str) throws zzd {
            int i = this.zzd;
            try {
                int iZzi = zzakn.zzi(str.length() * 3);
                int iZzi2 = zzakn.zzi(str.length());
                if (iZzi2 == iZzi) {
                    int i6 = i + iZzi2;
                    this.zzd = i6;
                    int iZza = zzaoa.zza(str, this.zzb, i6, zza());
                    this.zzd = i;
                    zzm((iZza - i) - iZzi2);
                    this.zzd = iZza;
                    return;
                }
                zzm(zzaoa.zza(str));
                this.zzd = zzaoa.zza(str, this.zzb, this.zzd, zza());
            } catch (zzaod e) {
                this.zzd = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzd(e2);
            }
        }
    }

    public static abstract class zzb extends zzakn {
        final byte[] zzb;
        final int zzc;
        int zzd;
        int zze;

        public zzb(int i) {
            super();
            if (i < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i, 20)];
            this.zzb = bArr;
            this.zzc = bArr.length;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final int zza() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        public final void zzb(byte b3) {
            int i = this.zzd;
            this.zzb[i] = b3;
            this.zzd = i + 1;
            this.zze++;
        }

        public final void zzi(long j4) {
            int i = this.zzd;
            byte[] bArr = this.zzb;
            bArr[i] = (byte) j4;
            bArr[i + 1] = (byte) (j4 >> 8);
            bArr[i + 2] = (byte) (j4 >> 16);
            bArr[i + 3] = (byte) (j4 >> 24);
            bArr[i + 4] = (byte) (j4 >> 32);
            bArr[i + 5] = (byte) (j4 >> 40);
            bArr[i + 6] = (byte) (j4 >> 48);
            bArr[i + 7] = (byte) (j4 >> 56);
            this.zzd = i + 8;
            this.zze += 8;
        }

        public final void zzj(long j4) {
            if (!zzakn.zzc) {
                while ((j4 & (-128)) != 0) {
                    byte[] bArr = this.zzb;
                    int i = this.zzd;
                    this.zzd = i + 1;
                    bArr[i] = (byte) (((int) j4) | 128);
                    this.zze++;
                    j4 >>>= 7;
                }
                byte[] bArr2 = this.zzb;
                int i6 = this.zzd;
                this.zzd = i6 + 1;
                bArr2[i6] = (byte) j4;
                this.zze++;
                return;
            }
            long j6 = this.zzd;
            while ((j4 & (-128)) != 0) {
                byte[] bArr3 = this.zzb;
                int i7 = this.zzd;
                this.zzd = i7 + 1;
                zzanz.zza(bArr3, i7, (byte) (((int) j4) | 128));
                j4 >>>= 7;
            }
            byte[] bArr4 = this.zzb;
            int i8 = this.zzd;
            this.zzd = i8 + 1;
            zzanz.zza(bArr4, i8, (byte) j4);
            this.zze += (int) (((long) this.zzd) - j6);
        }

        public final void zzl(int i, int i6) {
            zzo((i << 3) | i6);
        }

        public final void zzn(int i) {
            int i6 = this.zzd;
            byte[] bArr = this.zzb;
            bArr[i6] = (byte) i;
            bArr[i6 + 1] = (byte) (i >> 8);
            bArr[i6 + 2] = (byte) (i >> 16);
            bArr[i6 + 3] = i >> 24;
            this.zzd = i6 + 4;
            this.zze += 4;
        }

        public final void zzo(int i) {
            if (!zzakn.zzc) {
                while ((i & (-128)) != 0) {
                    byte[] bArr = this.zzb;
                    int i6 = this.zzd;
                    this.zzd = i6 + 1;
                    bArr[i6] = (byte) (i | 128);
                    this.zze++;
                    i >>>= 7;
                }
                byte[] bArr2 = this.zzb;
                int i7 = this.zzd;
                this.zzd = i7 + 1;
                bArr2[i7] = (byte) i;
                this.zze++;
                return;
            }
            long j4 = this.zzd;
            while ((i & (-128)) != 0) {
                byte[] bArr3 = this.zzb;
                int i8 = this.zzd;
                this.zzd = i8 + 1;
                zzanz.zza(bArr3, i8, (byte) (i | 128));
                i >>>= 7;
            }
            byte[] bArr4 = this.zzb;
            int i9 = this.zzd;
            this.zzd = i9 + 1;
            zzanz.zza(bArr4, i9, (byte) i);
            this.zze += (int) (((long) this.zzd) - j4);
        }
    }

    public static class zzd extends IOException {
        public zzd() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        public zzd(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        private zzd(String str, Throwable th) {
            super(AbstractC1024h.b("CodedOutputStream was writing to a flat byte array and ran out of space.: ", str), th);
        }

        public zzd(int i, int i6, int i7, Throwable th) {
            this(i, i6, i7, th);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        private zzd(long j4, long j6, int i, Throwable th) {
            this("Pos: " + j4 + ", limit: " + j6 + ", len: " + i, th);
            Locale locale = Locale.US;
        }
    }

    public static int zza(double d4) {
        return 8;
    }

    public static int zzb(int i) {
        return 4;
    }

    public static int zzc(long j4) {
        return 8;
    }

    public static int zze(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int zzf(int i) {
        return 4;
    }

    public static int zzg(int i) {
        return zzi(zzn(i));
    }

    public static int zzh(int i) {
        return zzi(i << 3);
    }

    private static long zzi(long j4) {
        return (j4 >> 63) ^ (j4 << 1);
    }

    private static int zzn(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public abstract int zza();

    public abstract void zza(byte b3);

    public abstract void zzb(int i, zzamm zzammVar);

    public abstract void zzb(int i, String str);

    public abstract void zzb(int i, boolean z6);

    public abstract void zzb(zzajv zzajvVar);

    public abstract void zzb(zzamm zzammVar);

    public abstract void zzb(String str);

    public abstract void zzb(byte[] bArr, int i, int i6);

    public abstract void zzc();

    public abstract void zzc(int i, zzajv zzajvVar);

    public abstract void zzd(int i, zzajv zzajvVar);

    public abstract void zzf(int i, long j4);

    public abstract void zzf(long j4);

    public abstract void zzg(int i, int i6);

    public abstract void zzh(int i, int i6);

    public abstract void zzh(int i, long j4);

    public abstract void zzh(long j4);

    public abstract void zzj(int i);

    public abstract void zzj(int i, int i6);

    public abstract void zzk(int i);

    public abstract void zzk(int i, int i6);

    public final void zzl(int i) {
        zzm(zzn(i));
    }

    public abstract void zzm(int i);

    public static final class zzc extends zzb {
        private final OutputStream zzf;

        public zzc(OutputStream outputStream, int i) {
            super(i);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.zzf = outputStream;
        }

        private final void zze() throws IOException {
            this.zzf.write(this.zzb, 0, this.zzd);
            this.zzd = 0;
        }

        private final void zzp(int i) throws IOException {
            if (this.zzc - this.zzd < i) {
                zze();
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zza(byte b3) throws IOException {
            if (this.zzd == this.zzc) {
                zze();
            }
            zzb(b3);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(int i, boolean z6) throws IOException {
            zzp(11);
            zzl(i, 0);
            zzb(z6 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzc() throws IOException {
            if (this.zzd > 0) {
                zze();
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzd(int i, zzajv zzajvVar) throws IOException {
            zzj(1, 3);
            zzk(2, i);
            zzc(3, zzajvVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzf(int i, long j4) throws IOException {
            zzp(18);
            zzl(i, 1);
            zzi(j4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzg(int i, int i6) throws IOException {
            zzp(14);
            zzl(i, 5);
            zzn(i6);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzh(int i, int i6) throws IOException {
            zzp(20);
            zzl(i, 0);
            if (i6 >= 0) {
                zzo(i6);
            } else {
                zzj(i6);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzj(int i) throws IOException {
            zzp(4);
            zzn(i);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzk(int i) throws IOException {
            if (i >= 0) {
                zzm(i);
            } else {
                zzh(i);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzm(int i) throws IOException {
            zzp(5);
            zzo(i);
        }

        private final void zzc(byte[] bArr, int i, int i6) throws IOException {
            int i7 = this.zzc;
            int i8 = this.zzd;
            if (i7 - i8 >= i6) {
                System.arraycopy(bArr, i, this.zzb, i8, i6);
                this.zzd += i6;
            } else {
                int i9 = i7 - i8;
                System.arraycopy(bArr, i, this.zzb, i8, i9);
                int i10 = i + i9;
                i6 -= i9;
                this.zzd = this.zzc;
                this.zze += i9;
                zze();
                if (i6 <= this.zzc) {
                    System.arraycopy(bArr, i10, this.zzb, 0, i6);
                    this.zzd = i6;
                } else {
                    this.zzf.write(bArr, i10, i6);
                }
            }
            this.zze += i6;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzj(int i, int i6) throws IOException {
            zzm((i << 3) | i6);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzk(int i, int i6) throws IOException {
            zzp(20);
            zzl(i, 0);
            zzo(i6);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajw
        public final void zza(byte[] bArr, int i, int i6) throws IOException {
            zzc(bArr, i, i6);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(byte[] bArr, int i, int i6) throws IOException {
            zzm(i6);
            zzc(bArr, 0, i6);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzf(long j4) throws IOException {
            zzp(8);
            zzi(j4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzh(int i, long j4) throws IOException {
            zzp(20);
            zzl(i, 0);
            zzj(j4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(zzajv zzajvVar) throws IOException {
            zzm(zzajvVar.zzb());
            zzajvVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(zzamm zzammVar) throws IOException {
            zzm(zzammVar.zzl());
            zzammVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzh(long j4) throws IOException {
            zzp(10);
            zzj(j4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(int i, zzamm zzammVar) throws IOException {
            zzj(1, 3);
            zzk(2, i);
            zzj(3, 2);
            zzb(zzammVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(int i, String str) throws IOException {
            zzj(i, 2);
            zzb(str);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzc(int i, zzajv zzajvVar) throws IOException {
            zzj(i, 2);
            zzb(zzajvVar);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(String str) throws IOException {
            int iZza;
            try {
                int length = str.length() * 3;
                int iZzi = zzakn.zzi(length);
                int i = iZzi + length;
                int i6 = this.zzc;
                if (i > i6) {
                    byte[] bArr = new byte[length];
                    int iZza2 = zzaoa.zza(str, bArr, 0, length);
                    zzm(iZza2);
                    zza(bArr, 0, iZza2);
                    return;
                }
                if (i > i6 - this.zzd) {
                    zze();
                }
                int iZzi2 = zzakn.zzi(str.length());
                int i7 = this.zzd;
                try {
                    if (iZzi2 == iZzi) {
                        int i8 = i7 + iZzi2;
                        this.zzd = i8;
                        int iZza3 = zzaoa.zza(str, this.zzb, i8, this.zzc - i8);
                        this.zzd = i7;
                        iZza = (iZza3 - i7) - iZzi2;
                        zzo(iZza);
                        this.zzd = iZza3;
                    } else {
                        iZza = zzaoa.zza(str);
                        zzo(iZza);
                        this.zzd = zzaoa.zza(str, this.zzb, this.zzd, iZza);
                    }
                    this.zze += iZza;
                } catch (zzaod e) {
                    this.zze -= this.zzd - i7;
                    this.zzd = i7;
                    throw e;
                } catch (ArrayIndexOutOfBoundsException e2) {
                    throw new zzd(e2);
                }
            } catch (zzaod e6) {
                zza(str, e6);
            }
        }
    }

    private zzakn() {
    }

    public static int zza(float f6) {
        return 4;
    }

    public static int zzb(int i, int i6) {
        return zzi(i << 3) + 4;
    }

    public static int zzc(int i, int i6) {
        return zze(i6) + zzi(i << 3);
    }

    public static int zzd(int i) {
        return zzi(i) + i;
    }

    public static int zze(int i, int i6) {
        return zzi(zzn(i6)) + zzi(i << 3);
    }

    public static int zzf(int i, int i6) {
        return zzi(i6) + zzi(i << 3);
    }

    public static int zzi(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public final void zzg(int i, long j4) {
        zzh(i, zzi(j4));
    }

    public static int zza(long j4) {
        return 8;
    }

    public static int zzb(int i, long j4) {
        return zze(j4) + zzi(i << 3);
    }

    public static int zzd(int i, int i6) {
        return zzi(i << 3) + 4;
    }

    public final void zzg(long j4) {
        zzh(zzi(j4));
    }

    public final void zzi(int i, int i6) {
        zzk(i, zzn(i6));
    }

    public static int zza(boolean z6) {
        return 1;
    }

    public static int zzc(int i) {
        return zze(i);
    }

    public static int zzd(int i, long j4) {
        return zze(zzi(j4)) + zzi(i << 3);
    }

    public static int zze(int i, long j4) {
        return zze(j4) + zzi(i << 3);
    }

    public static int zza(int i, boolean z6) {
        return zzi(i << 3) + 1;
    }

    public static int zzb(long j4) {
        return zze(j4);
    }

    public static int zzc(int i, long j4) {
        return zzi(i << 3) + 8;
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        return zzi(length) + length;
    }

    public static int zzb(int i, zzalu zzaluVar) {
        int iZzi = zzi(i << 3);
        int iZza = zzaluVar.zza();
        return zzi(iZza) + iZza + iZzi;
    }

    public static int zzd(long j4) {
        return zze(zzi(j4));
    }

    public static int zze(long j4) {
        return (640 - (Long.numberOfLeadingZeros(j4) * 9)) >>> 6;
    }

    public static int zza(int i, zzajv zzajvVar) {
        int iZzi = zzi(i << 3);
        int iZzb = zzajvVar.zzb();
        return zzi(iZzb) + iZzb + iZzi;
    }

    public static int zzb(int i, zzajv zzajvVar) {
        return zza(3, zzajvVar) + zzf(2, i) + (zzi(8) << 1);
    }

    public static int zza(zzajv zzajvVar) {
        int iZzb = zzajvVar.zzb();
        return zzi(iZzb) + iZzb;
    }

    public static zzakn zzb(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static int zza(int i, double d4) {
        return zzi(i << 3) + 8;
    }

    public static int zza(int i, int i6) {
        return zze(i6) + zzi(i << 3);
    }

    public final void zzb() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public static int zza(int i) {
        return zze(i);
    }

    public final void zzb(boolean z6) {
        zza(z6 ? (byte) 1 : (byte) 0);
    }

    public static int zza(int i, long j4) {
        return zzi(i << 3) + 8;
    }

    public final void zzb(int i, double d4) {
        zzf(i, Double.doubleToRawLongBits(d4));
    }

    public static int zza(int i, float f6) {
        return zzi(i << 3) + 4;
    }

    public final void zzb(double d4) {
        zzf(Double.doubleToRawLongBits(d4));
    }

    public static int zza(int i, zzalu zzaluVar) {
        return zzb(3, zzaluVar) + zzf(2, i) + (zzi(8) << 1);
    }

    public final void zzb(int i, float f6) {
        zzg(i, Float.floatToRawIntBits(f6));
    }

    public final void zzb(float f6) {
        zzj(Float.floatToRawIntBits(f6));
    }

    public static int zza(zzalu zzaluVar) {
        int iZza = zzaluVar.zza();
        return zzi(iZza) + iZza;
    }

    public static int zza(int i, zzamm zzammVar) {
        return zza(zzammVar) + zzi(24) + zzf(2, i) + (zzi(8) << 1);
    }

    public static int zza(zzamm zzammVar) {
        int iZzl = zzammVar.zzl();
        return zzi(iZzl) + iZzl;
    }

    public static int zza(int i, String str) {
        return zza(str) + zzi(i << 3);
    }

    public static int zza(String str) {
        int length;
        try {
            length = zzaoa.zza(str);
        } catch (zzaod unused) {
            length = str.getBytes(zzalh.zza).length;
        }
        return zzi(length) + length;
    }

    public static zzakn zza(OutputStream outputStream, int i) {
        return new zzc(outputStream, i);
    }

    public final void zza(String str, zzaod zzaodVar) throws zzd {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzaodVar);
        byte[] bytes = str.getBytes(zzalh.zza);
        try {
            zzm(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzd(e);
        }
    }
}
