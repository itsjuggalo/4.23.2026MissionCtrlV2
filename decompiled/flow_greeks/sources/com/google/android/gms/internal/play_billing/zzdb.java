package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzdb implements Runnable {
    zzde zza;

    public zzdb(zzde zzdeVar) {
        this.zza = zzdeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcz zzczVar;
        zzde zzdeVar = this.zza;
        if (zzdeVar == null || (zzczVar = zzdeVar.zzd) == null) {
            return;
        }
        this.zza = null;
        if (zzczVar.isDone()) {
            zzdeVar.zzj(zzczVar);
            return;
        }
        try {
            ScheduledFuture scheduledFuture = zzdeVar.zze;
            zzdeVar.zze = null;
            String str = "Timed out";
            if (scheduledFuture != null) {
                try {
                    long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                    if (jAbs > 10) {
                        str = "Timed out (timeout delayed by " + jAbs + " ms after scheduled time)";
                    }
                } catch (Throwable th) {
                    zzdeVar.zzi(new zzdc(str, null));
                    throw th;
                }
            }
            zzdeVar.zzi(new zzdc(str + ": " + zzczVar.toString(), null));
        } finally {
            zzczVar.cancel(true);
        }
    }
}
