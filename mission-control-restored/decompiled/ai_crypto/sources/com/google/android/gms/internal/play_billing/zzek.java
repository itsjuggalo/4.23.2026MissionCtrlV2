package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
final class zzek implements Runnable {
    final Future zza;
    final zzej zzb;

    public zzek(Future future, zzej zzejVar) {
        this.zza = future;
        this.zzb = zzejVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Throwable thZza;
        Object obj2 = this.zza;
        if ((obj2 instanceof zzfi) && (thZza = zzfj.zza((zzfi) obj2)) != null) {
            this.zzb.zza(thZza);
            return;
        }
        try {
            Future future = this.zza;
            if (!future.isDone()) {
                throw new IllegalStateException(zzbf.zza("Future was expected to be done: %s", future));
            }
            boolean z7 = false;
            while (true) {
                try {
                    obj = future.get();
                    break;
                } catch (InterruptedException unused) {
                    z7 = true;
                } catch (Throwable th) {
                    if (z7) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z7) {
                Thread.currentThread().interrupt();
            }
            this.zzb.zzb(obj);
        } catch (ExecutionException e7) {
            this.zzb.zza(e7.getCause());
        } catch (Throwable th2) {
            this.zzb.zza(th2);
        }
    }

    public final String toString() {
        zzba zzbaVarZza = zzbc.zza(this);
        zzbaVarZza.zza(this.zzb);
        return zzbaVarZza.toString();
    }
}
