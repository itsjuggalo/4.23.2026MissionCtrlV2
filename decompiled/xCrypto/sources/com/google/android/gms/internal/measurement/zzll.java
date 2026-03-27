package com.google.android.gms.internal.measurement;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzll extends zzky {
    public static final /* synthetic */ int zzb = 0;
    private static final Logger zzc = Logger.getLogger(zzll.class.getName());
    private static final boolean zzd = zzoo.zza();
    zzlm zza;

    private zzll() {
        throw null;
    }

    public static int zzA(long j4) {
        return (640 - (Long.numberOfLeadingZeros(j4) * 9)) >>> 6;
    }

    public static int zzB(String str) {
        int length;
        try {
            length = zzor.zzb(str);
        } catch (zzoq unused) {
            length = str.getBytes(zzmo.zza).length;
        }
        return zzz(length) + length;
    }

    public static int zzC(zznl zznlVar) {
        int iZzcn = zznlVar.zzcn();
        return zzz(iZzcn) + iZzcn;
    }

    public static int zzD(zznl zznlVar, zznw zznwVar) {
        int iZzcd = ((zzkr) zznlVar).zzcd(zznwVar);
        return zzz(iZzcd) + iZzcd;
    }

    @Deprecated
    public static int zzG(int i4, zznl zznlVar, zznw zznwVar) {
        int iZzz = zzz(i4 << 3);
        return iZzz + iZzz + ((zzkr) zznlVar).zzcd(zznwVar);
    }

    public static int zzz(int i4) {
        return (352 - (Integer.numberOfLeadingZeros(i4) * 9)) >>> 6;
    }

    public final void zzE() {
        if (zzy() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzF(String str, zzoq zzoqVar) throws zzlk {
        zzc.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzoqVar);
        byte[] bytes = str.getBytes(zzmo.zza);
        try {
            int length = bytes.length;
            zzr(length);
            zzw(bytes, 0, length);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzlk(e4);
        }
    }

    public abstract void zza(int i4, int i5);

    public abstract void zzb(int i4, int i5);

    public abstract void zzc(int i4, int i5);

    public abstract void zzd(int i4, int i5);

    public abstract void zze(int i4, long j4);

    public abstract void zzf(int i4, long j4);

    public abstract void zzg(int i4, boolean z4);

    public abstract void zzh(int i4, String str);

    public abstract void zzi(int i4, zzlg zzlgVar);

    public abstract void zzj(zzlg zzlgVar);

    public abstract void zzk(byte[] bArr, int i4, int i5);

    public abstract void zzl(int i4, zznl zznlVar, zznw zznwVar);

    public abstract void zzm(int i4, zznl zznlVar);

    public abstract void zzn(int i4, zzlg zzlgVar);

    public abstract void zzo(zznl zznlVar);

    public abstract void zzp(byte b4);

    public abstract void zzq(int i4);

    public abstract void zzr(int i4);

    public abstract void zzs(int i4);

    public abstract void zzt(long j4);

    public abstract void zzu(long j4);

    public abstract void zzw(byte[] bArr, int i4, int i5);

    public abstract void zzx(String str);

    public abstract int zzy();

    public /* synthetic */ zzll(byte[] bArr) {
    }
}
