package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzlg implements Iterable, Serializable {
    public static final zzlg zzb = new zzlf(zzmo.zzb);
    private int zza = 0;

    static {
        int i4 = zzku.zza;
    }

    public static zzlg zzh(byte[] bArr, int i4, int i5) {
        zzj(i4, i4 + i5, bArr.length);
        byte[] bArr2 = new byte[i5];
        System.arraycopy(bArr, i4, bArr2, 0, i5);
        return new zzlf(bArr2);
    }

    public static int zzj(int i4, int i5, int i6) {
        int i7 = i5 - i4;
        if ((i4 | i5 | i7 | (i6 - i5)) >= 0) {
            return i7;
        }
        if (i4 < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 21);
            sb.append("Beginning index: ");
            sb.append(i4);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i5 < i4) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(i4).length() + 44 + String.valueOf(i5).length());
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i4);
            sb2.append(", ");
            sb2.append(i5);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(String.valueOf(i5).length() + 15 + String.valueOf(i6).length());
        sb3.append("End index: ");
        sb3.append(i5);
        sb3.append(" >= ");
        sb3.append(i6);
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

    public abstract byte zza(int i4);

    public abstract byte zzb(int i4);

    public abstract int zzc();

    public abstract zzlg zze(int i4, int i5);

    public abstract void zzf(zzky zzkyVar);

    public abstract int zzg(int i4, int i5, int i6);

    public final int zzi() {
        return this.zza;
    }
}
