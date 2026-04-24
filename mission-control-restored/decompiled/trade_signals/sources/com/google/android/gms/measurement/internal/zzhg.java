package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.AbstractC1294n;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzhg {
    final /* synthetic */ zzhh zza;
    private final String zzb;
    private boolean zzc;
    private String zzd;

    public zzhg(zzhh zzhhVar, String str, String str2) {
        Objects.requireNonNull(zzhhVar);
        this.zza = zzhhVar;
        AbstractC1294n.d(str);
        this.zzb = str;
    }

    public final String zza() {
        if (!this.zzc) {
            this.zzc = true;
            zzhh zzhhVar = this.zza;
            this.zzd = zzhhVar.zzd().getString(this.zzb, null);
        }
        return this.zzd;
    }

    public final void zzb(String str) {
        SharedPreferences.Editor editorEdit = this.zza.zzd().edit();
        editorEdit.putString(this.zzb, str);
        editorEdit.apply();
        this.zzd = str;
    }
}
