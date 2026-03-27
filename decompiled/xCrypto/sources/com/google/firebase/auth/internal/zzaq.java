package com.google.firebase.auth.internal;

import C1.a;
import G1.g;
import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.FirebaseApp;

/* JADX INFO: loaded from: classes.dex */
public final class zzaq {
    private static a zzc = new a("TokenRefresher", "FirebaseAuth:");
    volatile long zza;
    volatile long zzb;
    private final FirebaseApp zzd;
    private long zze;
    private HandlerThread zzf;
    private Handler zzg;
    private Runnable zzh;

    public zzaq(FirebaseApp firebaseApp) {
        zzc.g("Initializing TokenRefresher", new Object[0]);
        FirebaseApp firebaseApp2 = (FirebaseApp) AbstractC0940s.k(firebaseApp);
        this.zzd = firebaseApp2;
        HandlerThread handlerThread = new HandlerThread("TokenRefresher", 10);
        this.zzf = handlerThread;
        handlerThread.start();
        this.zzg = new com.google.android.gms.internal.p002firebaseauthapi.zze(this.zzf.getLooper());
        this.zzh = new zzat(this, firebaseApp2.getName());
        this.zze = 300000L;
    }

    public final void zzb() {
        this.zzg.removeCallbacks(this.zzh);
    }

    public final void zzc() {
        zzc.g("Scheduling refresh for " + (this.zza - this.zze), new Object[0]);
        zzb();
        this.zzb = Math.max((this.zza - g.c().currentTimeMillis()) - this.zze, 0L) / 1000;
        this.zzg.postDelayed(this.zzh, this.zzb * 1000);
    }

    public final void zzd() {
        int i4 = (int) this.zzb;
        this.zzb = (i4 == 30 || i4 == 60 || i4 == 120 || i4 == 240 || i4 == 480) ? 2 * this.zzb : i4 != 960 ? 30L : 960L;
        this.zza = g.c().currentTimeMillis() + (this.zzb * 1000);
        zzc.g("Scheduling refresh for " + this.zza, new Object[0]);
        this.zzg.postDelayed(this.zzh, this.zzb * 1000);
    }
}
