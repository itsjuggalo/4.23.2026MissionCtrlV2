package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.s;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzhc {
    final /* synthetic */ zzhh zza;
    private final String zzb;
    private final boolean zzc;
    private boolean zzd;
    private boolean zze;

    public zzhc(zzhh zzhhVar, String str, boolean z10) {
        Objects.requireNonNull(zzhhVar);
        this.zza = zzhhVar;
        s.e(str);
        this.zzb = str;
        this.zzc = z10;
    }

    public final boolean zza() {
        if (!this.zzd) {
            this.zzd = true;
            zzhh zzhhVar = this.zza;
            this.zze = zzhhVar.zzd().getBoolean(this.zzb, this.zzc);
        }
        return this.zze;
    }

    public final void zzb(boolean z10) {
        SharedPreferences.Editor editorEdit = this.zza.zzd().edit();
        editorEdit.putBoolean(this.zzb, z10);
        editorEdit.apply();
        this.zze = z10;
    }
}
