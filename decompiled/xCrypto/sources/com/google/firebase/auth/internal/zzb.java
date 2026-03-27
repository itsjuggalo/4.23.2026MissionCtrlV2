package com.google.firebase.auth.internal;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.p002firebaseauthapi.zzaei;
import com.google.android.gms.internal.p002firebaseauthapi.zzafr;
import com.google.android.gms.internal.p002firebaseauthapi.zzagd;
import com.google.android.gms.internal.p002firebaseauthapi.zzahj;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.IntegrityManager;
import com.google.android.play.core.integrity.IntegrityManagerFactory;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthMissingActivityForRecaptchaException;

/* JADX INFO: loaded from: classes.dex */
public class zzb {
    private static final String zza = "zzb";
    private static final zzb zzb = new zzb();
    private String zzc;

    private zzb() {
    }

    public final Task<zzj> zza(final FirebaseAuth firebaseAuth, final String str, final Activity activity, final boolean z4, boolean z5, boolean z6, final RecaptchaAction recaptchaAction) {
        zzac zzacVar = (zzac) firebaseAuth.getFirebaseAuthSettings();
        final zzcg zzcgVarZzc = zzcg.zzc();
        if (!zzagd.zza(firebaseAuth.getApp()) && !zzacVar.zze()) {
            String str2 = zza;
            Log.i(str2, "ForceRecaptchaV2Flow from phoneAuthOptions = " + z5 + ", ForceRecaptchav2Flow from firebaseSettings = " + zzacVar.zzc());
            boolean z7 = z5 || zzacVar.zzc();
            final TaskCompletionSource<zzj> taskCompletionSource = new TaskCompletionSource<>();
            Task<String> taskZzb = zzcgVarZzc.zzb();
            if (taskZzb != null) {
                if (taskZzb.isSuccessful()) {
                    return Tasks.forResult(new zzm().zzc(taskZzb.getResult()).zza());
                }
                Log.e(str2, "Error in previous reCAPTCHAV2 flow: " + taskZzb.getException().getMessage());
                Log.e(str2, "Continuing with application verification as normal");
            }
            if (!z7 && !z6) {
                Task<Void> taskInitializeRecaptchaConfig = firebaseAuth.initializeRecaptchaConfig();
                final boolean z8 = false;
                OnCompleteListener<Void> onCompleteListener = new OnCompleteListener() { // from class: com.google.firebase.auth.internal.zza
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        zzb.zza(this.zza, taskCompletionSource, firebaseAuth, recaptchaAction, str, activity, z4, z8, zzcgVarZzc, task);
                    }
                };
                taskCompletionSource = taskCompletionSource;
                taskInitializeRecaptchaConfig.addOnCompleteListener(onCompleteListener);
            } else {
                zza(firebaseAuth, str, activity, z4, z7, zzcgVarZzc, taskCompletionSource);
            }
            return taskCompletionSource.getTask();
        }
        return Tasks.forResult(new zzm().zza());
    }

    public static zzb zza() {
        return zzb;
    }

    public static /* synthetic */ void zza(zzb zzbVar, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, RecaptchaAction recaptchaAction, String str, Activity activity, boolean z4, boolean z5, zzcg zzcgVar, Task task) {
        if (!task.isSuccessful()) {
            Log.e(zza, "Failed to initialize reCAPTCHA config: " + task.getException().getMessage());
        }
        if (firebaseAuth.zzb() != null && firebaseAuth.zzb().zzb("PHONE_PROVIDER")) {
            firebaseAuth.zzb().zza(firebaseAuth.getTenantId(), Boolean.FALSE, recaptchaAction).addOnSuccessListener(new zzf(zzbVar, taskCompletionSource)).addOnFailureListener(new zzc(zzbVar, firebaseAuth, str, activity, z4, z5, zzcgVar, taskCompletionSource));
        } else {
            zzbVar.zza(firebaseAuth, str, activity, z4, z5, zzcgVar, (TaskCompletionSource<zzj>) taskCompletionSource);
        }
    }

    public static /* synthetic */ void zza(zzb zzbVar, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, zzcg zzcgVar, Activity activity, Task task) {
        if (task.isSuccessful() && task.getResult() != null && !TextUtils.isEmpty(((IntegrityTokenResponse) task.getResult()).token())) {
            taskCompletionSource.setResult(new zzm().zza(((IntegrityTokenResponse) task.getResult()).token()).zza());
            return;
        }
        String message = task.getException() == null ? "" : task.getException().getMessage();
        Log.e(zza, "Play Integrity Token fetch failed, falling back to Recaptcha" + message);
        zzbVar.zza(firebaseAuth, zzcgVar, activity, taskCompletionSource);
    }

    private final void zza(FirebaseAuth firebaseAuth, zzcg zzcgVar, Activity activity, TaskCompletionSource<zzj> taskCompletionSource) {
        Task<String> task;
        if (activity == null) {
            taskCompletionSource.setException(new FirebaseAuthMissingActivityForRecaptchaException());
            return;
        }
        zzbl.zza(firebaseAuth.getApp().getApplicationContext(), firebaseAuth);
        AbstractC0940s.k(activity);
        TaskCompletionSource<String> taskCompletionSource2 = new TaskCompletionSource<>();
        if (!zzax.zza().zza(activity, taskCompletionSource2)) {
            task = Tasks.forException(zzaei.zza(new Status(17057, "reCAPTCHA flow already in progress")));
        } else {
            new zzafr(firebaseAuth, activity).zza();
            task = taskCompletionSource2.getTask();
        }
        task.addOnSuccessListener(new zzg(this, taskCompletionSource)).addOnFailureListener(new zzh(this, taskCompletionSource));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(final FirebaseAuth firebaseAuth, String str, final Activity activity, boolean z4, boolean z5, final zzcg zzcgVar, final TaskCompletionSource<zzj> taskCompletionSource) {
        Task<zzahj> taskZza;
        if (z4 && !z5) {
            IntegrityManager integrityManagerCreate = IntegrityManagerFactory.create(firebaseAuth.getApp().getApplicationContext());
            if (!TextUtils.isEmpty(this.zzc)) {
                taskZza = Tasks.forResult(new zzahj(this.zzc));
            } else {
                taskZza = firebaseAuth.zza();
            }
            taskZza.continueWithTask(firebaseAuth.zzf(), new zze(this, str, integrityManagerCreate)).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.firebase.auth.internal.zzd
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    zzb.zza(this.zza, taskCompletionSource, firebaseAuth, zzcgVar, activity, task);
                }
            });
            return;
        }
        zza(firebaseAuth, zzcgVar, activity, taskCompletionSource);
    }

    public static boolean zza(Exception exc) {
        if (exc instanceof FirebaseAuthMissingActivityForRecaptchaException) {
            return true;
        }
        return (exc instanceof FirebaseAuthException) && ((FirebaseAuthException) exc).getErrorCode().endsWith("UNAUTHORIZED_DOMAIN");
    }
}
