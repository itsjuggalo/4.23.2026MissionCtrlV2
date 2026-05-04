package com.google.android.gms.internal.measurement;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzlm extends zzkz {
    public static final /* synthetic */ int zzb = 0;
    private static final Logger zzc = Logger.getLogger(zzlm.class.getName());
    private static final boolean zzd = zzop.zza();
    zzln zza;

    private zzlm() {
        throw null;
    }

    public static int zzA(long j10) {
        return (640 - (Long.numberOfLeadingZeros(j10) * 9)) >>> 6;
    }

    public static int zzB(String str) {
        int length;
        try {
            length = zzos.zzb(str);
        } catch (zzor unused) {
            length = str.getBytes(zzmp.zza).length;
        }
        return zzz(length) + length;
    }

    public static int zzC(zznm zznmVar) {
        int iZzcn = zznmVar.zzcn();
        return zzz(iZzcn) + iZzcn;
    }

    public static int zzD(zznm zznmVar, zznx zznxVar) {
        int iZzcd = ((zzks) zznmVar).zzcd(zznxVar);
        return zzz(iZzcd) + iZzcd;
    }

    @Deprecated
    public static int zzG(int i10, zznm zznmVar, zznx zznxVar) {
        int iZzz = zzz(i10 << 3);
        return iZzz + iZzz + ((zzks) zznmVar).zzcd(zznxVar);
    }

    public static int zzz(int i10) {
        return (352 - (Integer.numberOfLeadingZeros(i10) * 9)) >>> 6;
    }

    public final void zzE() {
        if (zzy() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzF(String str, zzor zzorVar) throws zzll {
        zzc.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzorVar);
        byte[] bytes = str.getBytes(zzmp.zza);
        try {
            int length = bytes.length;
            zzr(length);
            zzw(bytes, 0, length);
        } catch (IndexOutOfBoundsException e10) {
            throw new zzll(e10);
        }
    }

    public abstract void zza(int i10, int i11);

    public abstract void zzb(int i10, int i11);

    public abstract void zzc(int i10, int i11);

    public abstract void zzd(int i10, int i11);

    public abstract void zze(int i10, long j10);

    public abstract void zzf(int i10, long j10);

    public abstract void zzg(int i10, boolean z10);

    public abstract void zzh(int i10, String str);

    public abstract void zzi(int i10, zzlh zzlhVar);

    public abstract void zzj(zzlh zzlhVar);

    public abstract void zzk(byte[] bArr, int i10, int i11);

    public abstract void zzl(int i10, zznm zznmVar, zznx zznxVar);

    public abstract void zzm(int i10, zznm zznmVar);

    public abstract void zzn(int i10, zzlh zzlhVar);

    public abstract void zzo(zznm zznmVar);

    public abstract void zzp(byte b10);

    public abstract void zzq(int i10);

    public abstract void zzr(int i10);

    public abstract void zzs(int i10);

    public abstract void zzt(long j10);

    public abstract void zzu(long j10);

    public abstract void zzw(byte[] bArr, int i10, int i11);

    public abstract void zzx(String str);

    public abstract int zzy();

    public /* synthetic */ zzlm(byte[] bArr) {
    }
}
