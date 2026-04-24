package com.google.firebase.auth.internal;

import android.util.Log;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.p002firebaseauthapi.zzaei;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;

/* JADX INFO: loaded from: classes.dex */
final class zzbt implements Continuation {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzbx zzb;
    private final /* synthetic */ RecaptchaAction zzc;
    private final /* synthetic */ Continuation zzd;

    public zzbt(String str, zzbx zzbxVar, RecaptchaAction recaptchaAction, Continuation continuation) {
        this.zza = str;
        this.zzb = zzbxVar;
        this.zzc = recaptchaAction;
        this.zzd = continuation;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Object then(Task task) {
        if (task.isSuccessful() || !zzaei.zzc((Exception) AbstractC0940s.k(task.getException()))) {
            return task;
        }
        if (Log.isLoggable("RecaptchaCallWrapper", 4)) {
            Log.i("RecaptchaCallWrapper", "Invalid token - Refreshing Recaptcha Enterprise config and fetching new token for tenant " + this.zza);
        }
        return this.zzb.zza(this.zza, Boolean.TRUE, this.zzc).continueWithTask(this.zzd);
    }
}
