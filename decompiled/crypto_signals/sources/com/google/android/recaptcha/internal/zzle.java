package com.google.android.recaptcha.internal;

import a3.d;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzle implements Iterable, Serializable {
    public static final zzle zzb = new zzlc(zznl.zzb);
    private int zza = 0;

    static {
        int i = zzks.zza;
    }

    public static int zzi(int i, int i6, int i7) {
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

    public static zzle zzk(byte[] bArr, int i, int i6) {
        zzi(i, i + i6, bArr.length);
        byte[] bArr2 = new byte[i6];
        System.arraycopy(bArr, i, bArr2, 0, i6);
        return new zzlc(bArr2);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzf = this.zza;
        if (iZzf == 0) {
            int iZzd = zzd();
            iZzf = zzf(iZzd, 0, iZzd);
            if (iZzf == 0) {
                iZzf = 1;
            }
            this.zza = iZzf;
        }
        return iZzf;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzkx(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int iZzd = zzd();
        String strZza = zzd() <= 50 ? zzpg.zza(this) : zzpg.zza(zzg(0, 47)).concat("...");
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(iZzd);
        sb.append(" contents=\"");
        return AbstractC1024h.d(sb, strZza, "\">");
    }

    public abstract byte zza(int i);

    public abstract byte zzb(int i);

    public abstract int zzd();

    public abstract void zze(byte[] bArr, int i, int i6, int i7);

    public abstract int zzf(int i, int i6, int i7);

    public abstract zzle zzg(int i, int i6);

    public abstract void zzh(zzkw zzkwVar);

    public final int zzj() {
        return this.zza;
    }

    public final byte[] zzl() {
        int iZzd = zzd();
        if (iZzd == 0) {
            return zznl.zzb;
        }
        byte[] bArr = new byte[iZzd];
        zze(bArr, 0, 0, iZzd);
        return bArr;
    }
}
