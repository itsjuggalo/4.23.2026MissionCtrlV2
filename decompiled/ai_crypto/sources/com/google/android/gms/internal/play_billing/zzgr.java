package com.google.android.gms.internal.play_billing;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzgr extends zzgc {
    private static final Logger zzb = Logger.getLogger(zzgr.class.getName());
    private static final boolean zzc = zzjq.zzx();
    zzgs zza;

    private zzgr() {
        throw null;
    }

    public static int zzA(long j7) {
        return (640 - (Long.numberOfLeadingZeros(j7) * 9)) >>> 6;
    }

    @Deprecated
    public static int zzw(int i7, zzim zzimVar, zzix zzixVar) {
        int iZzz = zzz(i7 << 3);
        return iZzz + iZzz + ((zzfv) zzimVar).zze(zzixVar);
    }

    public static int zzx(zzim zzimVar, zzix zzixVar) {
        int iZze = ((zzfv) zzimVar).zze(zzixVar);
        return zzz(iZze) + iZze;
    }

    public static int zzy(String str) {
        int length;
        try {
            length = zzjt.zzc(str);
        } catch (zzjs unused) {
            length = str.getBytes(zzhp.zza).length;
        }
        return zzz(length) + length;
    }

    public static int zzz(int i7) {
        return (352 - (Integer.numberOfLeadingZeros(i7) * 9)) >>> 6;
    }

    public final void zzB() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzC(String str, zzjs zzjsVar) throws zzgp {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzjsVar);
        byte[] bytes = str.getBytes(zzhp.zza);
        try {
            int length = bytes.length;
            zzt(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e7) {
            throw new zzgp(e7);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b7);

    public abstract void zzd(int i7, boolean z7);

    public abstract void zze(int i7, zzgk zzgkVar);

    public abstract void zzf(int i7, int i8);

    public abstract void zzg(int i7);

    public abstract void zzh(int i7, long j7);

    public abstract void zzi(long j7);

    public abstract void zzj(int i7, int i8);

    public abstract void zzk(int i7);

    public abstract void zzl(byte[] bArr, int i7, int i8);

    public abstract void zzm(int i7, zzim zzimVar, zzix zzixVar);

    public abstract void zzn(int i7, zzim zzimVar);

    public abstract void zzo(int i7, zzgk zzgkVar);

    public abstract void zzp(int i7, String str);

    public abstract void zzr(int i7, int i8);

    public abstract void zzs(int i7, int i8);

    public abstract void zzt(int i7);

    public abstract void zzu(int i7, long j7);

    public abstract void zzv(long j7);

    public /* synthetic */ zzgr(zzgq zzgqVar) {
    }
}
