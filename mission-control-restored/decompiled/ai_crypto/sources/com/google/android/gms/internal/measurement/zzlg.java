package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzlg implements Iterable, Serializable {
    public static final zzlg zzb = new zzlf(zzmo.zzb);
    private int zza = 0;

    static {
        int i7 = zzku.zza;
    }

    public static zzlg zzh(byte[] bArr, int i7, int i8) {
        zzj(i7, i7 + i8, bArr.length);
        byte[] bArr2 = new byte[i8];
        System.arraycopy(bArr, i7, bArr2, 0, i8);
        return new zzlf(bArr2);
    }

    public static int zzj(int i7, int i8, int i9) {
        int i10 = i8 - i7;
        if ((i7 | i8 | i10 | (i9 - i8)) >= 0) {
            return i10;
        }
        if (i7 < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i7).length() + 21);
            sb.append("Beginning index: ");
            sb.append(i7);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i8 < i7) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(i7).length() + 44 + String.valueOf(i8).length());
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i7);
            sb2.append(", ");
            sb2.append(i8);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(String.valueOf(i8).length() + 15 + String.valueOf(i9).length());
        sb3.append("End index: ");
        sb3.append(i8);
        sb3.append(" >= ");
        sb3.append(i9);
        throw new IndexOutOfBoundsException(sb3.toString());
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzg = this.zza;
        if (iZzg == 0) {
            int iZzc = zzc();
            iZzg = zzg(iZzc, 0, iZzc);
            if (iZzg == 0) {
                iZzg = 1;
            }
            this.zza = iZzg;
        }
        return iZzg;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzkz(this);
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zzc()), zzc() <= 50 ? zzof.zza(this) : zzof.zza(zze(0, 47)).concat("..."));
    }

    public abstract byte zza(int i7);

    public abstract byte zzb(int i7);

    public abstract int zzc();

    public abstract zzlg zze(int i7, int i8);

    public abstract void zzf(zzky zzkyVar);

    public abstract int zzg(int i7, int i8, int i9);

    public final int zzi() {
        return this.zza;
    }
}
