package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.tasks.TaskCompletionSource;
import m7.a0;
import m7.i;
import m7.i0;
import n7.i2;
import n7.u1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzacy extends zzaff<i, u1> {
    private final i0 zzv;
    private final String zzw;
    private final String zzx;

    public zzacy(i0 i0Var, String str, String str2) {
        super(2);
        this.zzv = (i0) s.k(i0Var);
        this.zzw = s.e(str);
        this.zzx = str2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafq
    public final String zza() {
        return "finalizeMfaSignIn";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaff
    public final void zzb() {
        n7.i iVarZza = zzacq.zza(this.zzc, this.zzk);
        a0 a0Var = this.zzd;
        if (a0Var != null && !a0Var.a().equalsIgnoreCase(iVarZza.a())) {
            zza(new Status(17024));
        } else {
            ((u1) this.zze).a(this.zzj, iVarZza);
            zzb(new i2(iVarZza));
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafq
    public final void zza(TaskCompletionSource taskCompletionSource, zzaeo zzaeoVar) {
        this.zzg = new zzafp(this, taskCompletionSource);
        zzaeoVar.zza(this.zzw, this.zzv, this.zzx, this.zzb);
    }
}
