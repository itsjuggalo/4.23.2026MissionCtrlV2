package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
public final class zzig extends zzme implements zznm {
    private static final zzig zzf;
    private int zzb;
    private int zzd = 1;
    private zzmn zze = zzme.zzcv();

    static {
        zzig zzigVar = new zzig();
        zzf = zzigVar;
        zzme.zzcp(zzig.class, zzigVar);
    }

    private zzig() {
    }

    public static zzie zza() {
        return (zzie) zzf.zzck();
    }

    public final /* synthetic */ void zzb(zzhu zzhuVar) {
        zzhuVar.getClass();
        zzmn zzmnVar = this.zze;
        if (!zzmnVar.zza()) {
            this.zze = zzme.zzcw(zzmnVar);
        }
        this.zze.add(zzhuVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int i7, Object obj, Object obj2) {
        int i8 = i7 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzme.zzcq(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b", new Object[]{"zzb", "zzd", zzif.zza, "zze", zzhu.class});
        }
        if (i8 == 3) {
            return new zzig();
        }
        byte[] bArr = null;
        if (i8 == 4) {
            return new zzie(bArr);
        }
        if (i8 == 5) {
            return zzf;
        }
        throw null;
    }
}
