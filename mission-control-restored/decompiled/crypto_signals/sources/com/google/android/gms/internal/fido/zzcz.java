package com.google.android.gms.internal.fido;

import a3.d;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzcz implements Iterable, Serializable {
    private static final Comparator zza;
    public static final zzcz zzb = new zzcw(zzde.zzd);
    private static final zzcy zzd;
    private int zzc = 0;

    static {
        int i = zzcp.zza;
        zzd = new zzcy(null);
        zza = new zzcr();
    }

    public static int zzj(int i, int i6, int i7) {
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

    public static zzcz zzl(byte[] bArr, int i, int i6) {
        zzj(0, i6, bArr.length);
        byte[] bArr2 = new byte[i6];
        System.arraycopy(bArr, 0, bArr2, 0, i6);
        return new zzcw(bArr2);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzf = this.zzc;
        if (iZzf == 0) {
            int iZzd = zzd();
            iZzf = zzf(iZzd, 0, iZzd);
            if (iZzf == 0) {
                iZzf = 1;
            }
            this.zzc = iZzf;
        }
        return iZzf;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzcq(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int iZzd = zzd();
        String strZza = zzd() <= 50 ? zzdg.zza(this) : zzdg.zza(zzg(0, 47)).concat("...");
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

    public abstract zzcz zzg(int i, int i6);

    public abstract InputStream zzh();

    public abstract ByteBuffer zzi();

    public final int zzk() {
        return this.zzc;
    }

    public final byte[] zzm() {
        int iZzd = zzd();
        if (iZzd == 0) {
            return zzde.zzd;
        }
        byte[] bArr = new byte[iZzd];
        zze(bArr, 0, 0, iZzd);
        return bArr;
    }
}
