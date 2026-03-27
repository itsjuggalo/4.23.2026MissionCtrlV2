package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class zzjz extends zzhk implements zzin {
    private static final zzjz zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;
    private zzki zzh;

    static {
        zzjz zzjzVar = new zzjz();
        zzb = zzjzVar;
        zzhk.zzx(zzjz.class, zzjzVar);
    }

    private zzjz() {
    }

    public static zzjz zzC(byte[] bArr, zzgw zzgwVar) {
        return (zzjz) zzhk.zzq(zzb, bArr, zzgwVar);
    }

    public static /* synthetic */ void zzD(zzjz zzjzVar, zzki zzkiVar) {
        zzkiVar.getClass();
        zzjzVar.zzh = zzkiVar;
        zzjzVar.zzd |= 2;
    }

    public static /* synthetic */ void zzE(zzjz zzjzVar, zzlb zzlbVar) {
        zzlbVar.getClass();
        zzjzVar.zzf = zzlbVar;
        zzjzVar.zze = 4;
    }

    public static /* synthetic */ void zzF(zzjz zzjzVar, int i7) {
        zzjzVar.zzg = i7 - 1;
        zzjzVar.zzd |= 1;
    }

    public static zzjx zzc() {
        return (zzjx) zzb.zzm();
    }

    @Override // com.google.android.gms.internal.play_billing.zzhk
    public final Object zzd(int i7, Object obj, Object obj2) {
        int i8 = i7 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzhk.zzu(zzb, "\u0004\u0003\u0001\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0004<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zzka.zza, "zzh", zzlb.class});
        }
        if (i8 == 3) {
            return new zzjz();
        }
        zzjy zzjyVar = null;
        if (i8 == 4) {
            return new zzjx(zzjyVar);
        }
        if (i8 != 5) {
            return null;
        }
        return zzb;
    }
}
