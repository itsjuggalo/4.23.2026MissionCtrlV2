package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.measurement.internal.zzic;
import com.google.android.gms.measurement.internal.zzjp;
import com.google.android.gms.measurement.internal.zzjq;
import com.google.android.gms.measurement.internal.zzlj;
import com.google.android.gms.measurement.internal.zzpl;
import java.util.List;
import java.util.Map;
import w.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zza extends zzc {
    private final zzic zza;
    private final zzlj zzb;

    public zza(zzic zzicVar) {
        super(null);
        s.k(zzicVar);
        this.zza = zzicVar;
        this.zzb = zzicVar.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zza(String str, String str2, Bundle bundle) {
        this.zzb.zzB(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zzb(String str, String str2, Bundle bundle, long j10) {
        this.zzb.zzC(str, str2, bundle, true, false, j10);
    }

    @Override // com.google.android.gms.measurement.zzc
    public final Map zzc(boolean z10) {
        List<zzpl> listZzO = this.zzb.zzO(z10);
        a aVar = new a(listZzO.size());
        for (zzpl zzplVar : listZzO) {
            Object objZza = zzplVar.zza();
            if (objZza != null) {
                aVar.put(zzplVar.zzb, objZza);
            }
        }
        return aVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final Map zzd(String str, String str2, boolean z10) {
        return this.zzb.zzP(str, str2, z10);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zze(zzjp zzjpVar) {
        this.zzb.zzV(zzjpVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zzf(zzjq zzjqVar) {
        this.zzb.zzW(zzjqVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zzg(zzjq zzjqVar) {
        this.zzb.zzX(zzjqVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final String zzh() {
        return this.zzb.zzad();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final String zzi() {
        return this.zzb.zzae();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final String zzj() {
        return this.zzb.zzQ();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final String zzk() {
        return this.zzb.zzaf();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final long zzl() {
        return this.zza.zzk().zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zzm(String str) {
        zzic zzicVar = this.zza;
        zzicVar.zzw().zza(str, zzicVar.zzaZ().b());
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zzn(String str) {
        zzic zzicVar = this.zza;
        zzicVar.zzw().zzb(str, zzicVar.zzaZ().b());
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zzo(Bundle bundle) {
        this.zzb.zzZ(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zzp(String str, String str2, Bundle bundle) {
        this.zza.zzj().zzab(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final List zzq(String str, String str2) {
        return this.zzb.zzac(str, str2);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final int zzr(String str) {
        this.zzb.zzY(str);
        return 25;
    }

    @Override // com.google.android.gms.measurement.zzc
    public final Boolean zzs() {
        return this.zzb.zzi();
    }

    @Override // com.google.android.gms.measurement.zzc
    public final Integer zzt() {
        return this.zzb.zzl();
    }

    @Override // com.google.android.gms.measurement.zzc
    public final String zzu() {
        return this.zzb.zzj();
    }

    @Override // com.google.android.gms.measurement.zzc
    public final Long zzv() {
        return this.zzb.zzk();
    }

    @Override // com.google.android.gms.measurement.zzc
    public final Double zzw() {
        return this.zzb.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final Object zzx(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? this.zzb.zzi() : this.zzb.zzl() : this.zzb.zzm() : this.zzb.zzk() : this.zzb.zzj();
    }
}
