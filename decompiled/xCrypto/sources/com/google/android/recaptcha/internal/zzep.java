package com.google.android.recaptcha.internal;

import java.util.TimerTask;
import t3.AbstractC1822k;

/* JADX INFO: loaded from: classes.dex */
public final class zzep extends TimerTask {
    final /* synthetic */ zzes zza;

    public zzep(zzes zzesVar) {
        this.zza = zzesVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        zzes zzesVar = this.zza;
        AbstractC1822k.d(zzesVar.zzd, null, null, new zzeq(zzesVar, null), 3, null);
    }
}
