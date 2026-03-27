package com.google.android.recaptcha.internal;

import java.util.TimerTask;
import t3.AbstractC1822k;

/* JADX INFO: loaded from: classes.dex */
public final class zzai extends TimerTask {
    final /* synthetic */ zzan zza;

    public zzai(zzan zzanVar) {
        this.zza = zzanVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        zzan zzanVar = this.zza;
        AbstractC1822k.d(zzanVar.zzb, null, null, new zzaj(zzanVar, null), 3, null);
    }
}
