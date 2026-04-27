package com.google.firebase.auth.internal;

import android.util.Log;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.p002firebaseauthapi.zzaei;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbo<T> {
    /* JADX WARN: Multi-variable type inference failed */
    private static <T> Task<T> zza(zzbx zzbxVar, RecaptchaAction recaptchaAction, String str, Continuation<String, Task<T>> continuation) {
        Task<String> taskZza = zzbxVar.zza(str, Boolean.FALSE, recaptchaAction);
        return taskZza.continueWithTask(continuation).continueWithTask(new zzbt(str, zzbxVar, recaptchaAction, continuation));
    }

    public abstract Task<T> zza(String str);

    public final Task<T> zza(final FirebaseAuth firebaseAuth, final String str, final RecaptchaAction recaptchaAction, String str2) {
        final Continuation continuation = new Continuation() { // from class: com.google.firebase.auth.internal.zzbq
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                zzbo zzboVar = this.zza;
                if (task.isSuccessful()) {
                    return zzboVar.zza((String) task.getResult());
                }
                Log.e("RecaptchaCallWrapper", "Failed to get Recaptcha token, error - " + ((Exception) AbstractC0940s.k(task.getException())).getMessage() + "\n\n Failing open with a fake token.");
                return zzboVar.zza("NO_RECAPTCHA");
            }
        };
        zzbx zzbxVarZzb = firebaseAuth.zzb();
        if (zzbxVarZzb != null && zzbxVarZzb.zzb(str2)) {
            return zza(zzbxVarZzb, recaptchaAction, str, continuation);
        }
        return (Task<T>) zza(null).continueWithTask(new Continuation() { // from class: com.google.firebase.auth.internal.zzbr
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return zzbo.zza(recaptchaAction, firebaseAuth, str, continuation, task);
            }
        });
    }

    public static /* synthetic */ Task zza(RecaptchaAction recaptchaAction, FirebaseAuth firebaseAuth, String str, Continuation continuation, Task task) {
        if (task.isSuccessful()) {
            return Tasks.forResult(task.getResult());
        }
        Exception exc = (Exception) AbstractC0940s.k(task.getException());
        if (zzaei.zzd(exc)) {
            if (Log.isLoggable("RecaptchaCallWrapper", 4)) {
                Log.i("RecaptchaCallWrapper", "Falling back to recaptcha enterprise flow for action " + String.valueOf(recaptchaAction));
            }
            if (firebaseAuth.zzb() == null) {
                firebaseAuth.zza(new zzbx(firebaseAuth.getApp(), firebaseAuth));
            }
            return zza(firebaseAuth.zzb(), recaptchaAction, str, continuation);
        }
        Log.e("RecaptchaCallWrapper", "Initial task failed for action " + String.valueOf(recaptchaAction) + "with exception - " + exc.getMessage());
        return Tasks.forException(exc);
    }
}
