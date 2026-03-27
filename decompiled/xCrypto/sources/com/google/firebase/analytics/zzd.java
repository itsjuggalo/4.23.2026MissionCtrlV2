package com.google.firebase.analytics;

import S1.InterfaceC0548c5;
import S1.InterfaceC0563e4;
import S1.InterfaceC0571f4;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzfb;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzd implements InterfaceC0548c5 {
    final /* synthetic */ zzfb zza;

    public zzd(zzfb zzfbVar) {
        this.zza = zzfbVar;
    }

    @Override // S1.InterfaceC0548c5
    public final void zza(String str, String str2, Bundle bundle) {
        this.zza.zzi(str, str2, bundle);
    }

    public final void zzb(String str, String str2, Bundle bundle, long j4) {
        this.zza.zzj(str, str2, bundle, j4);
    }

    @Override // S1.InterfaceC0548c5
    public final Map zzd(String str, String str2, boolean z4) {
        return this.zza.zzC(str, str2, z4);
    }

    public final void zze(InterfaceC0563e4 interfaceC0563e4) {
        this.zza.zzd(interfaceC0563e4);
    }

    public final void zzf(InterfaceC0571f4 interfaceC0571f4) {
        this.zza.zzf(interfaceC0571f4);
    }

    public final void zzg(InterfaceC0571f4 interfaceC0571f4) {
        this.zza.zzg(interfaceC0571f4);
    }

    @Override // S1.InterfaceC0548c5
    public final String zzh() {
        return this.zza.zzA();
    }

    @Override // S1.InterfaceC0548c5
    public final String zzi() {
        return this.zza.zzB();
    }

    @Override // S1.InterfaceC0548c5
    public final String zzj() {
        return this.zza.zzy();
    }

    @Override // S1.InterfaceC0548c5
    public final String zzk() {
        return this.zza.zzx();
    }

    @Override // S1.InterfaceC0548c5
    public final long zzl() {
        return this.zza.zzz();
    }

    @Override // S1.InterfaceC0548c5
    public final void zzm(String str) {
        this.zza.zzu(str);
    }

    @Override // S1.InterfaceC0548c5
    public final void zzn(String str) {
        this.zza.zzv(str);
    }

    @Override // S1.InterfaceC0548c5
    public final void zzo(Bundle bundle) {
        this.zza.zzl(bundle);
    }

    @Override // S1.InterfaceC0548c5
    public final void zzp(String str, String str2, Bundle bundle) {
        this.zza.zzm(str, str2, bundle);
    }

    @Override // S1.InterfaceC0548c5
    public final List zzq(String str, String str2) {
        return this.zza.zzn(str, str2);
    }

    @Override // S1.InterfaceC0548c5
    public final int zzr(String str) {
        return this.zza.zzF(str);
    }

    public final Object zzx(int i4) {
        return this.zza.zzJ(i4);
    }
}
