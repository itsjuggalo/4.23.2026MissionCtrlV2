package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzkv {
    public int zza;
    public long zzb;
    public Object zzc;
    public final zzlq zzd;
    public int zze;

    public zzkv() {
        int i7 = zzlq.zzb;
        int i8 = zznt.zza;
        this.zzd = zzlq.zza;
    }

    public static /* synthetic */ String zza(int i7, int i8, byte b7, String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(i8).length() + b7 + String.valueOf(i7).length());
        sb.append(str);
        sb.append(i8);
        sb.append(str2);
        sb.append(i7);
        return sb.toString();
    }

    public zzkv(zzlq zzlqVar) {
        zzlqVar.getClass();
        this.zzd = zzlqVar;
    }
}
