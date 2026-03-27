package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzkw {
    public int zza;
    public long zzb;
    public Object zzc;
    public final zzlr zzd;
    public int zze;

    public zzkw() {
        int i8 = zzlr.zzb;
        int i9 = zznu.zza;
        this.zzd = zzlr.zza;
    }

    public static /* synthetic */ String zza(int i8, int i9, byte b8, String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(i9).length() + b8 + String.valueOf(i8).length());
        sb.append(str);
        sb.append(i9);
        sb.append(str2);
        sb.append(i8);
        return sb.toString();
    }

    public zzkw(zzlr zzlrVar) {
        zzlrVar.getClass();
        this.zzd = zzlrVar;
    }
}
