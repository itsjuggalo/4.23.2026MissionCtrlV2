package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzlh implements Iterable, Serializable {
    public static final zzlh zzb = new zzlg(zzmp.zzb);
    private int zza = 0;

    static {
        int i = zzkv.zza;
    }

    public static zzlh zzh(byte[] bArr, int i, int i6) {
        zzj(i, i + i6, bArr.length);
        byte[] bArr2 = new byte[i6];
        System.arraycopy(bArr, i, bArr2, 0, i6);
        return new zzlg(bArr2);
    }

    public static int zzj(int i, int i6, int i7) {
        int i8 = i6 - i;
        if ((i | i6 | i8 | (i7 - i6)) >= 0) {
            return i8;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i6 < i) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(i).length() + 44 + String.valueOf(i6).length());
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i6);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(String.valueOf(i6).length() + 15 + String.valueOf(i7).length());
        sb3.append("End index: ");
        sb3.append(i6);
        sb3.append(" >= ");
        sb3.append(i7);
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
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int iZzc = zzc();
        String strZza = zzc() <= 50 ? zzog.zza(this) : zzog.zza(zze(0, 47)).concat("...");
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(iZzc);
        sb.append(" contents=\"");
        return AbstractC1024h.d(sb, strZza, "\">");
    }

    public abstract byte zza(int i);

    public abstract byte zzb(int i);

    public abstract int zzc();

    public abstract zzlh zze(int i, int i6);

    public abstract void zzf(zzkz zzkzVar);

    public abstract int zzg(int i, int i6, int i7);

    public final int zzi() {
        return this.zza;
    }
}
