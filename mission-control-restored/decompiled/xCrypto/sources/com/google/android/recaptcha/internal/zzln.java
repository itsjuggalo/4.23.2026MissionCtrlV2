package com.google.android.recaptcha.internal;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzln extends zzkw {
    private static final Logger zzb = Logger.getLogger(zzln.class.getName());
    private static final boolean zzc = zzps.zzx();
    zzlo zza;

    private zzln() {
        throw null;
    }

    public static int zzA(int i4) {
        return (352 - (Integer.numberOfLeadingZeros(i4) * 9)) >>> 6;
    }

    public static int zzB(long j4) {
        return (640 - (Long.numberOfLeadingZeros(j4) * 9)) >>> 6;
    }

    @Deprecated
    public static int zzw(int i4, zzoi zzoiVar, zzow zzowVar) {
        int iZzA = zzA(i4 << 3);
        return iZzA + iZzA + ((zzko) zzoiVar).zza(zzowVar);
    }

    public static int zzx(zzoi zzoiVar) {
        int iZzo = zzoiVar.zzo();
        return zzA(iZzo) + iZzo;
    }

    public static int zzy(zzoi zzoiVar, zzow zzowVar) {
        int iZza = ((zzko) zzoiVar).zza(zzowVar);
        return zzA(iZza) + iZza;
    }

    public static int zzz(String str) {
        int length;
        try {
            length = zzpv.zzc(str);
        } catch (zzpu unused) {
            length = str.getBytes(zznl.zza).length;
        }
        return zzA(length) + length;
    }

    public final void zzC() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzD(String str, zzpu zzpuVar) throws zzll {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzpuVar);
        byte[] bytes = str.getBytes(zznl.zza);
        try {
            int length = bytes.length;
            zzt(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzll(e4);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b4);

    public abstract void zzd(int i4, boolean z4);

    public abstract void zze(int i4, zzle zzleVar);

    public abstract void zzf(int i4, int i5);

    public abstract void zzg(int i4);

    public abstract void zzh(int i4, long j4);

    public abstract void zzi(long j4);

    public abstract void zzj(int i4, int i5);

    public abstract void zzk(int i4);

    public abstract void zzl(byte[] bArr, int i4, int i5);

    public abstract void zzm(int i4, zzoi zzoiVar, zzow zzowVar);

    public abstract void zzn(int i4, zzoi zzoiVar);

    public abstract void zzo(int i4, zzle zzleVar);

    public abstract void zzp(int i4, String str);

    public abstract void zzr(int i4, int i5);

    public abstract void zzs(int i4, int i5);

    public abstract void zzt(int i4);

    public abstract void zzu(int i4, long j4);

    public abstract void zzv(long j4);

    public /* synthetic */ zzln(zzlm zzlmVar) {
    }
}
