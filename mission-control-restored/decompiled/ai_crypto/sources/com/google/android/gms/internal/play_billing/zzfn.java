package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class zzfn extends zzhk implements zzin {
    private static final zzfn zzb;
    private zzho zzd = zzhk.zzs();

    static {
        zzfn zzfnVar = new zzfn();
        zzb = zzfnVar;
        zzhk.zzx(zzfn.class, zzfnVar);
    }

    private zzfn() {
    }

    public static zzfm zza() {
        return (zzfm) zzb.zzm();
    }

    public static /* synthetic */ void zzc(zzfn zzfnVar, Iterable iterable) {
        zzho zzhoVar = zzfnVar.zzd;
        if (!zzhoVar.zzc()) {
            int size = zzhoVar.size();
            zzfnVar.zzd = zzhoVar.zzd(size + size);
        }
        zzfv.zzg(iterable, zzfnVar.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhk
    public final Object zzd(int i7, Object obj, Object obj2) {
        int i8 = i7 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzhk.zzu(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzfl.class});
        }
        if (i8 == 3) {
            return new zzfn();
        }
        zzfo zzfoVar = null;
        if (i8 == 4) {
            return new zzfm(zzfoVar);
        }
        if (i8 != 5) {
            return null;
        }
        return zzb;
    }
}
