package com.google.android.gms.internal.play_billing;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzep extends zzdz {
    public static final /* synthetic */ int zzb = 0;
    private static final Logger zzc = Logger.getLogger(zzep.class.getName());
    private static final boolean zzd = zzho.zzx();
    zzeq zza;

    private zzep() {
        throw null;
    }

    public static int zzA(zzgl zzglVar, zzgv zzgvVar) {
        int iZze = ((zzds) zzglVar).zze(zzgvVar);
        return zzC(iZze) + iZze;
    }

    public static int zzB(String str) {
        int length;
        try {
            length = zzhr.zzc(str);
        } catch (zzhq unused) {
            length = str.getBytes(zzfo.zza).length;
        }
        return zzC(length) + length;
    }

    public static int zzC(int i10) {
        return (352 - (Integer.numberOfLeadingZeros(i10) * 9)) >>> 6;
    }

    public static int zzD(long j10) {
        return (640 - (Long.numberOfLeadingZeros(j10) * 9)) >>> 6;
    }

    @Deprecated
    public static int zzy(int i10, zzgl zzglVar, zzgv zzgvVar) {
        int iZzC = zzC(i10 << 3);
        return iZzC + iZzC + ((zzds) zzglVar).zze(zzgvVar);
    }

    public static int zzz(zzgl zzglVar) {
        int iZzj = zzglVar.zzj();
        return zzC(iZzj) + iZzj;
    }

    public final void zzE() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzF(String str, zzhq zzhqVar) throws zzen {
        zzc.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzhqVar);
        byte[] bytes = str.getBytes(zzfo.zza);
        try {
            int length = bytes.length;
            zzv(length);
            zzm(bytes, 0, length);
        } catch (IndexOutOfBoundsException e10) {
            throw new zzen(e10);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b10);

    public abstract void zzd(int i10, boolean z10);

    public abstract void zze(int i10, zzei zzeiVar);

    public abstract void zzg(int i10, int i11);

    public abstract void zzh(int i10);

    public abstract void zzi(int i10, long j10);

    public abstract void zzj(long j10);

    public abstract void zzk(int i10, int i11);

    public abstract void zzl(int i10);

    public abstract void zzm(byte[] bArr, int i10, int i11);

    public abstract void zzn(int i10, zzgl zzglVar, zzgv zzgvVar);

    public abstract void zzp(int i10, zzgl zzglVar);

    public abstract void zzq(int i10, zzei zzeiVar);

    public abstract void zzr(int i10, String str);

    public abstract void zzt(int i10, int i11);

    public abstract void zzu(int i10, int i11);

    public abstract void zzv(int i10);

    public abstract void zzw(int i10, long j10);

    public abstract void zzx(long j10);

    public /* synthetic */ zzep(zzeo zzeoVar) {
    }
}
