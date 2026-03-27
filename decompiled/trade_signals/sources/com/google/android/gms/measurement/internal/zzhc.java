package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.AbstractC1294n;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzhc {
    final /* synthetic */ zzhh zza;
    private final String zzb;
    private final boolean zzc;
    private boolean zzd;
    private boolean zze;

    public zzhc(zzhh zzhhVar, String str, boolean z7) {
        Objects.requireNonNull(zzhhVar);
        this.zza = zzhhVar;
        AbstractC1294n.d(str);
        this.zzb = str;
        this.zzc = z7;
    }

    public final boolean zza() {
        if (!this.zzd) {
            this.zzd = true;
            zzhh zzhhVar = this.zza;
            this.zze = zzhhVar.zzd().getBoolean(this.zzb, this.zzc);
        }
        return this.zze;
    }

    public final void zzb(boolean z7) {
        SharedPreferences.Editor editorEdit = this.zza.zzd().edit();
        editorEdit.putBoolean(this.zzb, z7);
        editorEdit.apply();
        this.zze = z7;
    }
}
