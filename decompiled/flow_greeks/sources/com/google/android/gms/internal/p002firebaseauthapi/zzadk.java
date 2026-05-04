package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.tasks.TaskCompletionSource;
import n7.i;
import n7.u1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzadk extends zzaff<Void, u1> {
    private final String zzv;
    private final String zzw;
    private final String zzx;
    private final String zzy;

    public zzadk(String str, String str2, String str3, String str4) {
        super(2);
        s.f(str, "email cannot be null or empty");
        s.f(str2, "password cannot be null or empty");
        this.zzv = str;
        this.zzw = str2;
        this.zzx = str3;
        this.zzy = str4;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafq
    public final String zza() {
        return "reauthenticateWithEmailPassword";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaff
    public final void zzb() {
        i iVarZza = zzacq.zza(this.zzc, this.zzk);
        if (!this.zzd.a().equalsIgnoreCase(iVarZza.a())) {
            zza(new Status(17024));
        } else {
            ((u1) this.zze).a(this.zzj, iVarZza);
            zzb(null);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafq
    public final void zza(TaskCompletionSource taskCompletionSource, zzaeo zzaeoVar) {
        this.zzg = new zzafp(this, taskCompletionSource);
        zzaeoVar.zzb(this.zzv, this.zzw, this.zzx, this.zzy, this.zzb);
    }
}
