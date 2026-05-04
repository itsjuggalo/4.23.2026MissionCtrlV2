package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzakn extends zzajw {
    private static final Logger zzb = Logger.getLogger(zzakn.class.getName());
    private static final boolean zzc = zzanz.zzc();
    zzakp zza;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class zza extends zzakn {
        private final byte[] zzb;
        private final int zzc;
        private int zzd;

        public zza(byte[] bArr, int i10, int i11) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            if (((bArr.length - i11) | i11) < 0) {
                throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i11)));
            }
            this.zzb = bArr;
            this.zzd = 0;
            this.zzc = i11;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final int zza() {
            return this.zzc - this.zzd;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(int i10, boolean z10) {
            zzj(i10, 0);
            zza(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzc() {
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzd(int i10, zzajv zzajvVar) {
            zzj(1, 3);
            zzk(2, i10);
            zzc(3, zzajvVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzf(int i10, long j10) {
            zzj(i10, 1);
            zzf(j10);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzg(int i10, int i11) {
            zzj(i10, 5);
            zzj(i11);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzh(int i10, int i11) {
            zzj(i10, 0);
            zzk(i11);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzj(int i10) throws zzd {
            int i11 = this.zzd;
            try {
                byte[] bArr = this.zzb;
                bArr[i11] = (byte) i10;
                bArr[i11 + 1] = (byte) (i10 >> 8);
                bArr[i11 + 2] = (byte) (i10 >> 16);
                bArr[i11 + 3] = i10 >> 24;
                this.zzd = i11 + 4;
            } catch (IndexOutOfBoundsException e10) {
                throw new zzd(i11, this.zzc, 4, (Throwable) e10);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzk(int i10) {
            if (i10 >= 0) {
                zzm(i10);
            } else {
                zzh(i10);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzm(int i10) throws zzd {
            int i11;
            int i12 = this.zzd;
            while ((i10 & (-128)) != 0) {
                try {
                    i11 = i12 + 1;
                    try {
                        this.zzb[i12] = (byte) (i10 | 128);
                        i10 >>>= 7;
                        i12 = i11;
                    } catch (IndexOutOfBoundsException e10) {
                        e = e10;
                        i12 = i11;
                        throw new zzd(i12, this.zzc, 1, (Throwable) e);
                    }
                } catch (IndexOutOfBoundsException e11) {
                    e = e11;
                    throw new zzd(i12, this.zzc, 1, (Throwable) e);
                }
            }
            i11 = i12 + 1;
            this.zzb[i12] = (byte) i10;
            this.zzd = i11;
        }

        private final void zzc(byte[] bArr, int i10, int i11) throws zzd {
            try {
                System.arraycopy(bArr, i10, this.zzb, this.zzd, i11);
                this.zzd += i11;
            } catch (IndexOutOfBoundsException e10) {
                throw new zzd(this.zzd, this.zzc, i11, (Throwable) e10);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zza(byte b10) throws zzd {
            int i10 = this.zzd;
            try {
                int i11 = i10 + 1;
                try {
                    this.zzb[i10] = b10;
                    this.zzd = i11;
                } catch (IndexOutOfBoundsException e10) {
                    e = e10;
                    i10 = i11;
                    throw new zzd(i10, this.zzc, 1, (Throwable) e);
                }
            } catch (IndexOutOfBoundsException e11) {
                e = e11;
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(byte[] bArr, int i10, int i11) throws zzd {
            zzm(i11);
            zzc(bArr, 0, i11);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzf(long j10) throws zzd {
            int i10 = this.zzd;
            try {
                byte[] bArr = this.zzb;
                bArr[i10] = (byte) j10;
                bArr[i10 + 1] = (byte) (j10 >> 8);
                bArr[i10 + 2] = (byte) (j10 >> 16);
                bArr[i10 + 3] = (byte) (j10 >> 24);
                bArr[i10 + 4] = (byte) (j10 >> 32);
                bArr[i10 + 5] = (byte) (j10 >> 40);
                bArr[i10 + 6] = (byte) (j10 >> 48);
                bArr[i10 + 7] = (byte) (j10 >> 56);
                this.zzd = i10 + 8;
            } catch (IndexOutOfBoundsException e10) {
                throw new zzd(i10, this.zzc, 8, (Throwable) e10);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzh(int i10, long j10) {
            zzj(i10, 0);
            zzh(j10);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzk(int i10, int i11) {
            zzj(i10, 0);
            zzm(i11);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(zzajv zzajvVar) {
            zzm(zzajvVar.zzb());
            zzajvVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzc(int i10, zzajv zzajvVar) {
            zzj(i10, 2);
            zzb(zzajvVar);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzh(long j10) throws zzd {
            int i10;
            int i11;
            int i12 = this.zzd;
            if (zzakn.zzc && zza() >= 10) {
                while ((j10 & (-128)) != 0) {
                    zzanz.zza(this.zzb, i12, (byte) (((int) j10) | 128));
                    j10 >>>= 7;
                    i12++;
                }
                i10 = i12 + 1;
                zzanz.zza(this.zzb, i12, (byte) j10);
            } else {
                while ((j10 & (-128)) != 0) {
                    try {
                        i11 = i12 + 1;
                    } catch (IndexOutOfBoundsException e10) {
                        e = e10;
                    }
                    try {
                        this.zzb[i12] = (byte) (((int) j10) | 128);
                        j10 >>>= 7;
                        i12 = i11;
                    } catch (IndexOutOfBoundsException e11) {
                        e = e11;
                        i12 = i11;
                        throw new zzd(i12, this.zzc, 1, (Throwable) e);
                    }
                }
                i10 = i12 + 1;
                try {
                    this.zzb[i12] = (byte) j10;
                } catch (IndexOutOfBoundsException e12) {
                    e = e12;
                    i12 = i10;
                    throw new zzd(i12, this.zzc, 1, (Throwable) e);
                }
            }
            this.zzd = i10;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajw
        public final void zza(byte[] bArr, int i10, int i11) throws zzd {
            zzc(bArr, i10, i11);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(zzamm zzammVar) {
            zzm(zzammVar.zzl());
            zzammVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzj(int i10, int i11) {
            zzm((i10 << 3) | i11);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(int i10, zzamm zzammVar) {
            zzj(1, 3);
            zzk(2, i10);
            zzj(3, 2);
            zzb(zzammVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(int i10, String str) {
            zzj(i10, 2);
            zzb(str);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(String str) throws zzd {
            int i10 = this.zzd;
            try {
                int iZzi = zzakn.zzi(str.length() * 3);
                int iZzi2 = zzakn.zzi(str.length());
                if (iZzi2 == iZzi) {
                    int i11 = i10 + iZzi2;
                    this.zzd = i11;
                    int iZza = zzaoa.zza(str, this.zzb, i11, zza());
                    this.zzd = i10;
                    zzm((iZza - i10) - iZzi2);
                    this.zzd = iZza;
                    return;
                }
                zzm(zzaoa.zza(str));
                this.zzd = zzaoa.zza(str, this.zzb, this.zzd, zza());
            } catch (zzaod e10) {
                this.zzd = i10;
                zza(str, e10);
            } catch (IndexOutOfBoundsException e11) {
                throw new zzd(e11);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class zzb extends zzakn {
        final byte[] zzb;
        final int zzc;
        int zzd;
        int zze;

        public zzb(int i10) {
            super();
            if (i10 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i10, 20)];
            this.zzb = bArr;
            this.zzc = bArr.length;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final int zza() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        public final void zzb(byte b10) {
            int i10 = this.zzd;
            this.zzb[i10] = b10;
            this.zzd = i10 + 1;
            this.zze++;
        }

        public final void zzi(long j10) {
            int i10 = this.zzd;
            byte[] bArr = this.zzb;
            bArr[i10] = (byte) j10;
            bArr[i10 + 1] = (byte) (j10 >> 8);
            bArr[i10 + 2] = (byte) (j10 >> 16);
            bArr[i10 + 3] = (byte) (j10 >> 24);
            bArr[i10 + 4] = (byte) (j10 >> 32);
            bArr[i10 + 5] = (byte) (j10 >> 40);
            bArr[i10 + 6] = (byte) (j10 >> 48);
            bArr[i10 + 7] = (byte) (j10 >> 56);
            this.zzd = i10 + 8;
            this.zze += 8;
        }

        public final void zzj(long j10) {
            if (!zzakn.zzc) {
                while ((j10 & (-128)) != 0) {
                    byte[] bArr = this.zzb;
                    int i10 = this.zzd;
                    this.zzd = i10 + 1;
                    bArr[i10] = (byte) (((int) j10) | 128);
                    this.zze++;
                    j10 >>>= 7;
                }
                byte[] bArr2 = this.zzb;
                int i11 = this.zzd;
                this.zzd = i11 + 1;
                bArr2[i11] = (byte) j10;
                this.zze++;
                return;
            }
            long j11 = this.zzd;
            while ((j10 & (-128)) != 0) {
                byte[] bArr3 = this.zzb;
                int i12 = this.zzd;
                this.zzd = i12 + 1;
                zzanz.zza(bArr3, i12, (byte) (((int) j10) | 128));
                j10 >>>= 7;
            }
            byte[] bArr4 = this.zzb;
            int i13 = this.zzd;
            this.zzd = i13 + 1;
            zzanz.zza(bArr4, i13, (byte) j10);
            this.zze += (int) (((long) this.zzd) - j11);
        }

        public final void zzl(int i10, int i11) {
            zzo((i10 << 3) | i11);
        }

        public final void zzn(int i10) {
            int i11 = this.zzd;
            byte[] bArr = this.zzb;
            bArr[i11] = (byte) i10;
            bArr[i11 + 1] = (byte) (i10 >> 8);
            bArr[i11 + 2] = (byte) (i10 >> 16);
            bArr[i11 + 3] = i10 >> 24;
            this.zzd = i11 + 4;
            this.zze += 4;
        }

        public final void zzo(int i10) {
            if (!zzakn.zzc) {
                while ((i10 & (-128)) != 0) {
                    byte[] bArr = this.zzb;
                    int i11 = this.zzd;
                    this.zzd = i11 + 1;
                    bArr[i11] = (byte) (i10 | 128);
                    this.zze++;
                    i10 >>>= 7;
                }
                byte[] bArr2 = this.zzb;
                int i12 = this.zzd;
                this.zzd = i12 + 1;
                bArr2[i12] = (byte) i10;
                this.zze++;
                return;
            }
            long j10 = this.zzd;
            while ((i10 & (-128)) != 0) {
                byte[] bArr3 = this.zzb;
                int i13 = this.zzd;
                this.zzd = i13 + 1;
                zzanz.zza(bArr3, i13, (byte) (i10 | 128));
                i10 >>>= 7;
            }
            byte[] bArr4 = this.zzb;
            int i14 = this.zzd;
            this.zzd = i14 + 1;
            zzanz.zza(bArr4, i14, (byte) i10);
            this.zze += (int) (((long) this.zzd) - j10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class zzd extends IOException {
        public zzd() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        public zzd(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        private zzd(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }

        public zzd(int i10, int i11, int i12, Throwable th) {
            this(i10, i11, i12, th);
        }

        private zzd(long j10, long j11, int i10, Throwable th) {
            this(String.format(Locale.US, "Pos: %d, limit: %d, len: %d", Long.valueOf(j10), Long.valueOf(j11), Integer.valueOf(i10)), th);
        }
    }

    public static int zza(double d10) {
        return 8;
    }

    public static int zzb(int i10) {
        return 4;
    }

    public static int zzc(long j10) {
        return 8;
    }

    public static int zze(int i10) {
        if (i10 > 4096) {
            return 4096;
        }
        return i10;
    }

    public static int zzf(int i10) {
        return 4;
    }

    public static int zzg(int i10) {
        return zzi(zzn(i10));
    }

    public static int zzh(int i10) {
        return zzi(i10 << 3);
    }

    private static long zzi(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    private static int zzn(int i10) {
        return (i10 >> 31) ^ (i10 << 1);
    }

    public abstract int zza();

    public abstract void zza(byte b10);

    public abstract void zzb(int i10, zzamm zzammVar);

    public abstract void zzb(int i10, String str);

    public abstract void zzb(int i10, boolean z10);

    public abstract void zzb(zzajv zzajvVar);

    public abstract void zzb(zzamm zzammVar);

    public abstract void zzb(String str);

    public abstract void zzb(byte[] bArr, int i10, int i11);

    public abstract void zzc();

    public abstract void zzc(int i10, zzajv zzajvVar);

    public abstract void zzd(int i10, zzajv zzajvVar);

    public abstract void zzf(int i10, long j10);

    public abstract void zzf(long j10);

    public abstract void zzg(int i10, int i11);

    public abstract void zzh(int i10, int i11);

    public abstract void zzh(int i10, long j10);

    public abstract void zzh(long j10);

    public abstract void zzj(int i10);

    public abstract void zzj(int i10, int i11);

    public abstract void zzk(int i10);

    public abstract void zzk(int i10, int i11);

    public final void zzl(int i10) {
        zzm(zzn(i10));
    }

    public abstract void zzm(int i10);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class zzc extends zzb {
        private final OutputStream zzf;

        public zzc(OutputStream outputStream, int i10) {
            super(i10);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.zzf = outputStream;
        }

        private final void zze() throws IOException {
            this.zzf.write(this.zzb, 0, this.zzd);
            this.zzd = 0;
        }

        private final void zzp(int i10) throws IOException {
            if (this.zzc - this.zzd < i10) {
                zze();
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zza(byte b10) throws IOException {
            if (this.zzd == this.zzc) {
                zze();
            }
            zzb(b10);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(int i10, boolean z10) throws IOException {
            zzp(11);
            zzl(i10, 0);
            zzb(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzc() throws IOException {
            if (this.zzd > 0) {
                zze();
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzd(int i10, zzajv zzajvVar) {
            zzj(1, 3);
            zzk(2, i10);
            zzc(3, zzajvVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzf(int i10, long j10) throws IOException {
            zzp(18);
            zzl(i10, 1);
            zzi(j10);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzg(int i10, int i11) throws IOException {
            zzp(14);
            zzl(i10, 5);
            zzn(i11);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzh(int i10, int i11) throws IOException {
            zzp(20);
            zzl(i10, 0);
            if (i11 >= 0) {
                zzo(i11);
            } else {
                zzj(i11);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzj(int i10) throws IOException {
            zzp(4);
            zzn(i10);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzk(int i10) {
            if (i10 >= 0) {
                zzm(i10);
            } else {
                zzh(i10);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzm(int i10) throws IOException {
            zzp(5);
            zzo(i10);
        }

        private final void zzc(byte[] bArr, int i10, int i11) throws IOException {
            int i12 = this.zzc;
            int i13 = this.zzd;
            if (i12 - i13 >= i11) {
                System.arraycopy(bArr, i10, this.zzb, i13, i11);
                this.zzd += i11;
            } else {
                int i14 = i12 - i13;
                System.arraycopy(bArr, i10, this.zzb, i13, i14);
                int i15 = i10 + i14;
                i11 -= i14;
                this.zzd = this.zzc;
                this.zze += i14;
                zze();
                if (i11 <= this.zzc) {
                    System.arraycopy(bArr, i15, this.zzb, 0, i11);
                    this.zzd = i11;
                } else {
                    this.zzf.write(bArr, i15, i11);
                }
            }
            this.zze += i11;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzj(int i10, int i11) {
            zzm((i10 << 3) | i11);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzk(int i10, int i11) throws IOException {
            zzp(20);
            zzl(i10, 0);
            zzo(i11);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajw
        public final void zza(byte[] bArr, int i10, int i11) throws IOException {
            zzc(bArr, i10, i11);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(byte[] bArr, int i10, int i11) throws IOException {
            zzm(i11);
            zzc(bArr, 0, i11);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzf(long j10) throws IOException {
            zzp(8);
            zzi(j10);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzh(int i10, long j10) throws IOException {
            zzp(20);
            zzl(i10, 0);
            zzj(j10);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(zzajv zzajvVar) {
            zzm(zzajvVar.zzb());
            zzajvVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(zzamm zzammVar) {
            zzm(zzammVar.zzl());
            zzammVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzh(long j10) throws IOException {
            zzp(10);
            zzj(j10);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(int i10, zzamm zzammVar) {
            zzj(1, 3);
            zzk(2, i10);
            zzj(3, 2);
            zzb(zzammVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(int i10, String str) {
            zzj(i10, 2);
            zzb(str);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzc(int i10, zzajv zzajvVar) {
            zzj(i10, 2);
            zzb(zzajvVar);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(String str) throws IOException {
            int iZza;
            try {
                int length = str.length() * 3;
                int iZzi = zzakn.zzi(length);
                int i10 = iZzi + length;
                int i11 = this.zzc;
                if (i10 > i11) {
                    byte[] bArr = new byte[length];
                    int iZza2 = zzaoa.zza(str, bArr, 0, length);
                    zzm(iZza2);
                    zza(bArr, 0, iZza2);
                    return;
                }
                if (i10 > i11 - this.zzd) {
                    zze();
                }
                int iZzi2 = zzakn.zzi(str.length());
                int i12 = this.zzd;
                try {
                    if (iZzi2 == iZzi) {
                        int i13 = i12 + iZzi2;
                        this.zzd = i13;
                        int iZza3 = zzaoa.zza(str, this.zzb, i13, this.zzc - i13);
                        this.zzd = i12;
                        iZza = (iZza3 - i12) - iZzi2;
                        zzo(iZza);
                        this.zzd = iZza3;
                    } else {
                        iZza = zzaoa.zza(str);
                        zzo(iZza);
                        this.zzd = zzaoa.zza(str, this.zzb, this.zzd, iZza);
                    }
                    this.zze += iZza;
                } catch (zzaod e10) {
                    this.zze -= this.zzd - i12;
                    this.zzd = i12;
                    throw e10;
                } catch (ArrayIndexOutOfBoundsException e11) {
                    throw new zzd(e11);
                }
            } catch (zzaod e12) {
                zza(str, e12);
            }
        }
    }

    private zzakn() {
    }

    public static int zza(float f10) {
        return 4;
    }

    public static int zzb(int i10, int i11) {
        return zzi(i10 << 3) + 4;
    }

    public static int zzc(int i10, int i11) {
        return zzi(i10 << 3) + zze(i11);
    }

    public static int zzd(int i10) {
        return zzi(i10) + i10;
    }

    public static int zze(int i10, int i11) {
        return zzi(i10 << 3) + zzi(zzn(i11));
    }

    public static int zzf(int i10, int i11) {
        return zzi(i10 << 3) + zzi(i11);
    }

    public static int zzi(int i10) {
        return (352 - (Integer.numberOfLeadingZeros(i10) * 9)) >>> 6;
    }

    public final void zzg(int i10, long j10) {
        zzh(i10, zzi(j10));
    }

    public static int zza(long j10) {
        return 8;
    }

    public static int zzb(int i10, long j10) {
        return zzi(i10 << 3) + zze(j10);
    }

    public static int zzd(int i10, int i11) {
        return zzi(i10 << 3) + 4;
    }

    public final void zzg(long j10) {
        zzh(zzi(j10));
    }

    public final void zzi(int i10, int i11) {
        zzk(i10, zzn(i11));
    }

    public static int zza(boolean z10) {
        return 1;
    }

    public static int zzc(int i10) {
        return zze(i10);
    }

    public static int zzd(int i10, long j10) {
        return zzi(i10 << 3) + zze(zzi(j10));
    }

    public static int zze(int i10, long j10) {
        return zzi(i10 << 3) + zze(j10);
    }

    public static int zza(int i10, boolean z10) {
        return zzi(i10 << 3) + 1;
    }

    public static int zzb(long j10) {
        return zze(j10);
    }

    public static int zzc(int i10, long j10) {
        return zzi(i10 << 3) + 8;
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        return zzi(length) + length;
    }

    public static int zzb(int i10, zzalu zzaluVar) {
        int iZzi = zzi(i10 << 3);
        int iZza = zzaluVar.zza();
        return iZzi + zzi(iZza) + iZza;
    }

    public static int zzd(long j10) {
        return zze(zzi(j10));
    }

    public static int zze(long j10) {
        return (640 - (Long.numberOfLeadingZeros(j10) * 9)) >>> 6;
    }

    public static int zza(int i10, zzajv zzajvVar) {
        int iZzi = zzi(i10 << 3);
        int iZzb = zzajvVar.zzb();
        return iZzi + zzi(iZzb) + iZzb;
    }

    public static int zzb(int i10, zzajv zzajvVar) {
        return (zzi(8) << 1) + zzf(2, i10) + zza(3, zzajvVar);
    }

    public static int zza(zzajv zzajvVar) {
        int iZzb = zzajvVar.zzb();
        return zzi(iZzb) + iZzb;
    }

    public static zzakn zzb(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static int zza(int i10, double d10) {
        return zzi(i10 << 3) + 8;
    }

    public static int zza(int i10, int i11) {
        return zzi(i10 << 3) + zze(i11);
    }

    public final void zzb() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public static int zza(int i10) {
        return zze(i10);
    }

    public final void zzb(boolean z10) {
        zza(z10 ? (byte) 1 : (byte) 0);
    }

    public static int zza(int i10, long j10) {
        return zzi(i10 << 3) + 8;
    }

    public final void zzb(int i10, double d10) {
        zzf(i10, Double.doubleToRawLongBits(d10));
    }

    public static int zza(int i10, float f10) {
        return zzi(i10 << 3) + 4;
    }

    public final void zzb(double d10) {
        zzf(Double.doubleToRawLongBits(d10));
    }

    public static int zza(int i10, zzalu zzaluVar) {
        return (zzi(8) << 1) + zzf(2, i10) + zzb(3, zzaluVar);
    }

    public final void zzb(int i10, float f10) {
        zzg(i10, Float.floatToRawIntBits(f10));
    }

    public final void zzb(float f10) {
        zzj(Float.floatToRawIntBits(f10));
    }

    public static int zza(zzalu zzaluVar) {
        int iZza = zzaluVar.zza();
        return zzi(iZza) + iZza;
    }

    public static int zza(int i10, zzamm zzammVar) {
        return (zzi(8) << 1) + zzf(2, i10) + zzi(24) + zza(zzammVar);
    }

    public static int zza(zzamm zzammVar) {
        int iZzl = zzammVar.zzl();
        return zzi(iZzl) + iZzl;
    }

    public static int zza(int i10, String str) {
        return zzi(i10 << 3) + zza(str);
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

    public static zzakn zza(OutputStream outputStream, int i10) {
        return new zzc(outputStream, i10);
    }

    public final void zza(String str, zzaod zzaodVar) throws zzd {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzaodVar);
        byte[] bytes = str.getBytes(zzalh.zza);
        try {
            zzm(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e10) {
            throw new zzd(e10);
        }
    }
}
