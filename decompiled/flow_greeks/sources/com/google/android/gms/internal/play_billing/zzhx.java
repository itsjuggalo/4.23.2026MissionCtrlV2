package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzhx extends zzfi implements zzgm {
    private static final zzhx zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;
    private zzig zzh;
    private int zzi;

    static {
        zzhx zzhxVar = new zzhx();
        zzb = zzhxVar;
        zzfi.zzw(zzhx.class, zzhxVar);
    }

    private zzhx() {
    }

    public static zzhx zzA(byte[] bArr, zzeu zzeuVar) {
        return (zzhx) zzfi.zzp(zzb, bArr, zzeuVar);
    }

    public static /* synthetic */ void zzC(zzhx zzhxVar, zzil zzilVar) {
        zzhxVar.zzi = zzilVar.zza();
        zzhxVar.zzd |= 4;
    }

    public static /* synthetic */ void zzD(zzhx zzhxVar, zzig zzigVar) {
        zzigVar.getClass();
        zzhxVar.zzh = zzigVar;
        zzhxVar.zzd |= 2;
    }

    public static /* synthetic */ void zzE(zzhx zzhxVar, zziz zzizVar) {
        zzizVar.getClass();
        zzhxVar.zzf = zzizVar;
        zzhxVar.zze = 4;
    }

    public static /* synthetic */ void zzF(zzhx zzhxVar, zzjf zzjfVar) {
        zzjfVar.getClass();
        zzhxVar.zzf = zzjfVar;
        zzhxVar.zze = 7;
    }

    public static /* synthetic */ void zzG(zzhx zzhxVar, zzjv zzjvVar) {
        zzjvVar.getClass();
        zzhxVar.zzf = zzjvVar;
        zzhxVar.zze = 6;
    }

    public static /* synthetic */ void zzH(zzhx zzhxVar, int i10) {
        zzhxVar.zzg = i10 - 1;
        zzhxVar.zzd |= 1;
    }

    public static zzhv zzc() {
        return (zzhv) zzb.zzl();
    }

    public final zzjf zzB() {
        return this.zze == 7 ? (zzjf) this.zzf : zzjf.zzd();
    }

    @Override // com.google.android.gms.internal.play_billing.zzfi
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzfi.zzt(zzb, "\u0004\u0006\u0001\u0001\u0001\u0007\u0006\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0004<\u0000\u0005᠌\u0002\u0006<\u0000\u0007<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zzhy.zza, "zzh", zziz.class, "zzi", zzik.zza, zzjv.class, zzjf.class});
        }
        if (i11 == 3) {
            return new zzhx();
        }
        zzhw zzhwVar = null;
        if (i11 == 4) {
            return new zzhv(zzhwVar);
        }
        if (i11 == 5) {
            return zzb;
        }
        throw null;
    }
}
