package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzlh implements Iterable, Serializable {
    public static final zzlh zzb = new zzlg(zzmp.zzb);
    private int zza = 0;

    static {
        int i8 = zzkv.zza;
    }

    public static zzlh zzh(byte[] bArr, int i8, int i9) {
        zzj(i8, i8 + i9, bArr.length);
        byte[] bArr2 = new byte[i9];
        System.arraycopy(bArr, i8, bArr2, 0, i9);
        return new zzlg(bArr2);
    }

    public static int zzj(int i8, int i9, int i10) {
        int i11 = i9 - i8;
        if ((i8 | i9 | i11 | (i10 - i9)) >= 0) {
            return i11;
        }
        if (i8 < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i8).length() + 21);
            sb.append("Beginning index: ");
            sb.append(i8);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i9 < i8) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(i8).length() + 44 + String.valueOf(i9).length());
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i8);
            sb2.append(", ");
            sb2.append(i9);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(String.valueOf(i9).length() + 15 + String.valueOf(i10).length());
        sb3.append("End index: ");
        sb3.append(i9);
        sb3.append(" >= ");
        sb3.append(i10);
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
        return new zzla(this);
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zzc()), zzc() <= 50 ? zzog.zza(this) : zzog.zza(zze(0, 47)).concat("..."));
    }

    public abstract byte zza(int i8);

    public abstract byte zzb(int i8);

    public abstract int zzc();

    public abstract zzlh zze(int i8, int i9);

    public abstract void zzf(zzkz zzkzVar);

    public abstract int zzg(int i8, int i9, int i10);

    public final int zzi() {
        return this.zza;
    }
}
