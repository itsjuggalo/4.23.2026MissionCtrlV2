package com.google.firebase.auth.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.api.internal.ComponentCallbacks2C0900d;
import com.google.android.gms.internal.p002firebaseauthapi.zzahn;
import com.google.firebase.FirebaseApp;

/* JADX INFO: loaded from: classes.dex */
public final class zzca {
    private volatile int zza;
    private final zzaq zzb;
    private volatile boolean zzc;

    public zzca(FirebaseApp firebaseApp) {
        this(firebaseApp.getApplicationContext(), new zzaq(firebaseApp));
    }

    private zzca(Context context, zzaq zzaqVar) {
        this.zzc = false;
        this.zza = 0;
        this.zzb = zzaqVar;
        ComponentCallbacks2C0900d.c((Application) context.getApplicationContext());
        ComponentCallbacks2C0900d.b().a(new zzcd(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzb() {
        return this.zza > 0 && !this.zzc;
    }

    public final void zza() {
        this.zzb.zzb();
    }

    public final void zza(int i4) {
        if (i4 > 0 && this.zza == 0) {
            this.zza = i4;
            if (zzb()) {
                this.zzb.zzc();
            }
        } else if (i4 == 0 && this.zza != 0) {
            this.zzb.zzb();
        }
        this.zza = i4;
    }

    public final void zza(zzahn zzahnVar) {
        if (zzahnVar == null) {
            return;
        }
        long jZza = zzahnVar.zza();
        if (jZza <= 0) {
            jZza = 3600;
        }
        long jZzb = zzahnVar.zzb() + (jZza * 1000);
        zzaq zzaqVar = this.zzb;
        zzaqVar.zza = jZzb;
        zzaqVar.zzb = -1L;
        if (zzb()) {
            this.zzb.zzc();
        }
    }
}
