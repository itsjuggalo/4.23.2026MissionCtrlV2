package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzkv {
    public int zza;
    public long zzb;
    public Object zzc;
    public final zzlq zzd;
    public int zze;

    public zzkv() {
        int i4 = zzlq.zzb;
        int i5 = zznt.zza;
        this.zzd = zzlq.zza;
    }

    public static /* synthetic */ String zza(int i4, int i5, byte b4, String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + b4 + String.valueOf(i4).length());
        sb.append(str);
        sb.append(i5);
        sb.append(str2);
        sb.append(i4);
        return sb.toString();
    }

    public zzkv(zzlq zzlqVar) {
        zzlqVar.getClass();
        this.zzd = zzlqVar;
    }
}
