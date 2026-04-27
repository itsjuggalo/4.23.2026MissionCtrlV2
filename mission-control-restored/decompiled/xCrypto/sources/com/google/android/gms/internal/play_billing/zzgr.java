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

    public static int zzA(long j4) {
        return (640 - (Long.numberOfLeadingZeros(j4) * 9)) >>> 6;
    }

    @Deprecated
    public static int zzw(int i4, zzim zzimVar, zzix zzixVar) {
        int iZzz = zzz(i4 << 3);
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

    public static int zzz(int i4) {
        return (352 - (Integer.numberOfLeadingZeros(i4) * 9)) >>> 6;
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
        } catch (IndexOutOfBoundsException e4) {
            throw new zzgp(e4);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b4);

    public abstract void zzd(int i4, boolean z4);

    public abstract void zze(int i4, zzgk zzgkVar);

    public abstract void zzf(int i4, int i5);

    public abstract void zzg(int i4);

    public abstract void zzh(int i4, long j4);

    public abstract void zzi(long j4);

    public abstract void zzj(int i4, int i5);

    public abstract void zzk(int i4);

    public abstract void zzl(byte[] bArr, int i4, int i5);

    public abstract void zzm(int i4, zzim zzimVar, zzix zzixVar);

    public abstract void zzn(int i4, zzim zzimVar);

    public abstract void zzo(int i4, zzgk zzgkVar);

    public abstract void zzp(int i4, String str);

    public abstract void zzr(int i4, int i5);

    public abstract void zzs(int i4, int i5);

    public abstract void zzt(int i4);

    public abstract void zzu(int i4, long j4);

    public abstract void zzv(long j4);

    public /* synthetic */ zzgr(zzgq zzgqVar) {
    }
}
