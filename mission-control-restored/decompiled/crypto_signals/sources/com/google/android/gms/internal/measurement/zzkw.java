package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzkw {
    public int zza;
    public long zzb;
    public Object zzc;
    public final zzlr zzd;
    public int zze;

    public zzkw() {
        int i = zzlr.zzb;
        int i6 = zznu.zza;
        this.zzd = zzlr.zza;
    }

    public static /* synthetic */ String zza(int i, int i6, byte b3, String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(i6).length() + b3 + String.valueOf(i).length());
        sb.append(str);
        sb.append(i6);
        sb.append(str2);
        sb.append(i);
        return sb.toString();
    }

    public zzkw(zzlr zzlrVar) {
        zzlrVar.getClass();
        this.zzd = zzlrVar;
    }
}
