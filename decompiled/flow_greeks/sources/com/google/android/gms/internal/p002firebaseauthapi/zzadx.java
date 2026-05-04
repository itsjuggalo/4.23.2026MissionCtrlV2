package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.s;
import com.google.android.gms.tasks.TaskCompletionSource;
import n7.p;
import n7.u1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzadx extends zzaff<Void, u1> {
    private final boolean zzaa;
    private final String zzab;
    private final String zzac;
    private final String zzad;
    private final boolean zzae;
    private final String zzv;
    private final String zzw;
    private final String zzx;
    private final long zzy;
    private final boolean zzz;

    public zzadx(p pVar, String str, String str2, long j10, boolean z10, boolean z11, String str3, String str4, String str5, boolean z12) {
        super(8);
        s.k(pVar);
        s.e(str);
        this.zzv = s.e(pVar.U());
        this.zzw = str;
        this.zzx = str2;
        this.zzy = j10;
        this.zzz = z10;
        this.zzaa = z11;
        this.zzab = str3;
        this.zzac = str4;
        this.zzad = str5;
        this.zzae = z12;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafq
    public final String zza() {
        return "startMfaEnrollment";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafq
    public final void zza(TaskCompletionSource taskCompletionSource, zzaeo zzaeoVar) {
        this.zzg = new zzafp(this, taskCompletionSource);
        zzaeoVar.zza(this.zzv, this.zzw, this.zzx, this.zzy, this.zzz, this.zzaa, this.zzab, this.zzac, this.zzad, this.zzae, this.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaff
    public final void zzb() {
    }
}
