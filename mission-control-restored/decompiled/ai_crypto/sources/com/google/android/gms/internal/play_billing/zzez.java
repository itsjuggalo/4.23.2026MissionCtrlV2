package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzdy;

/* JADX INFO: loaded from: classes.dex */
final class zzez extends zzdy.zzi implements Runnable {
    private final Runnable zzc;

    public zzez(Runnable runnable) {
        runnable.getClass();
        this.zzc = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzc.run();
        } catch (Throwable th) {
            zzo(th);
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzdy
    public final String zzg() {
        return "task=[" + this.zzc.toString() + "]";
    }
}
