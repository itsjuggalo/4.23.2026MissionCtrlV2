package com.google.android.recaptcha.internal;

import android.content.Context;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzek {
    private final String zza;
    private String zzb;
    private String zzc;
    private final Context zzd;
    private final zzeo zze;
    private String zzf;
    private Integer zzg;
    private final int zzh;

    private zzek(String str, String str2, String str3, int i10, Context context, zzeo zzeoVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzh = i10;
        this.zzd = context;
        this.zze = zzeoVar;
    }

    public final zzek zza() {
        return new zzek(this);
    }

    public final zzek zzb(int i10) {
        this.zzg = Integer.valueOf(i10);
        return this;
    }

    public final zzek zzc(String str) {
        this.zzf = str;
        return this;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final void zze(zztx zztxVar) {
        this.zze.zza(zztxVar);
    }

    public final zzen zzf(int i10) {
        String str = this.zzb;
        String str2 = this.zzc;
        String str3 = this.zzf;
        zzcc zzccVar = new zzcc();
        Context context = this.zzd;
        Integer num = this.zzg;
        return new zzen(i10, this.zza, this.zzh, str, str2, str3, null, this.zze, zzccVar, context, num);
    }

    public /* synthetic */ zzek(String str, String str2, String str3, int i10, Context context, zzeo zzeoVar, k kVar) {
        this(str, str2, str3, i10, context, zzeoVar);
    }

    private zzek(zzek zzekVar) {
        this(zzekVar.zza, zzekVar.zzb, zzekVar.zzc, zzekVar.zzh, zzekVar.zzd, zzekVar.zze);
        this.zzf = zzekVar.zzf;
        this.zzg = zzekVar.zzg;
    }
}
