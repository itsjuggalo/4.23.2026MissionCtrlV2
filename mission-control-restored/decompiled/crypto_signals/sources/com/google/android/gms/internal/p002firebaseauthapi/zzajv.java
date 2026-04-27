package com.google.android.gms.internal.p002firebaseauthapi;

import a3.d;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzajv implements Serializable, Iterable<Byte> {
    public static final zzajv zza = new zzakg(zzalh.zzb);
    private static final zzakc zzb = new zzakf();
    private int zzc = 0;

    static {
        new zzajx();
    }

    public static /* synthetic */ int zza(byte b3) {
        return b3 & 255;
    }

    public static zzajv zzb(byte[] bArr) {
        return new zzakg(bArr);
    }

    public static zzake zzc(int i) {
        return new zzake(i);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzb = this.zzc;
        if (iZzb == 0) {
            int iZzb2 = zzb();
            iZzb = zzb(iZzb2, 0, iZzb2);
            if (iZzb == 0) {
                iZzb = 1;
            }
            this.zzc = iZzb;
        }
        return iZzb;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzajy(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int iZzb = zzb();
        String strZza = zzb() <= 50 ? zzann.zza(this) : d.j(zzann.zza(zza(0, 47)), "...");
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(iZzb);
        sb.append(" contents=\"");
        return AbstractC1024h.d(sb, strZza, "\">");
    }

    public abstract byte zza(int i);

    public abstract zzajv zza(int i, int i6);

    public abstract void zza(zzajw zzajwVar);

    public abstract void zza(byte[] bArr, int i, int i6, int i7);

    public abstract byte zzb(int i);

    public abstract int zzb();

    public abstract int zzb(int i, int i6, int i7);

    public abstract zzakh zzc();

    public final byte[] zzd() {
        int iZzb = zzb();
        if (iZzb == 0) {
            return zzalh.zzb;
        }
        byte[] bArr = new byte[iZzb];
        zza(bArr, 0, 0, iZzb);
        return bArr;
    }

    public static int zza(int i, int i6, int i7) {
        int i8 = i6 - i;
        if ((i | i6 | i8 | (i7 - i6)) >= 0) {
            return i8;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(d.i("Beginning index: ", i, " < 0"));
        }
        if (i6 < i) {
            throw new IndexOutOfBoundsException(d.h("Beginning index larger than ending index: ", i, i6, ", "));
        }
        throw new IndexOutOfBoundsException(d.h("End index: ", i6, i7, " >= "));
    }

    public final int zza() {
        return this.zzc;
    }

    public static zzajv zza(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    public static zzajv zza(byte[] bArr, int i, int i6) {
        zza(i, i + i6, bArr.length);
        return new zzakg(zzb.zza(bArr, i, i6));
    }

    public static zzajv zza(String str) {
        return new zzakg(str.getBytes(zzalh.zza));
    }
}
