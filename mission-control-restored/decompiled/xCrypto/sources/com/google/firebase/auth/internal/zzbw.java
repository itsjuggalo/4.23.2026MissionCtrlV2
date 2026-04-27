package com.google.firebase.auth.internal;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.p002firebaseauthapi.zzahk;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaTasksClient;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzbw implements Continuation<zzahk, Task<RecaptchaTasksClient>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzbx zzb;

    public zzbw(zzbx zzbxVar, String str) {
        this.zza = str;
        this.zzb = zzbxVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<RecaptchaTasksClient> then(Task<zzahk> task) {
        if (!task.isSuccessful()) {
            return Tasks.forException(new zzbu((String) AbstractC0940s.k(((Exception) AbstractC0940s.k(task.getException())).getMessage())));
        }
        zzahk result = task.getResult();
        String strZza = result.zza();
        if (com.google.android.gms.internal.p002firebaseauthapi.zzae.zzc(strZza)) {
            return Tasks.forException(new zzbu("No Recaptcha Enterprise siteKey configured for tenant/project " + this.zza));
        }
        List<String> listZza = com.google.android.gms.internal.p002firebaseauthapi.zzv.zza('/').zza((CharSequence) strZza);
        String str = listZza.size() != 4 ? null : listZza.get(3);
        if (TextUtils.isEmpty(str)) {
            return Tasks.forException(new Exception("Invalid siteKey format " + strZza));
        }
        if (Log.isLoggable("RecaptchaHandler", 4)) {
            Log.i("RecaptchaHandler", "Successfully obtained site key for tenant " + this.zza);
        }
        zzbx zzbxVar = this.zzb;
        Task<RecaptchaTasksClient> taskZza = zzbxVar.zzb.zza((Application) zzbxVar.zza.getApplicationContext(), str);
        zzbx.zza(this.zzb, result, taskZza, this.zza);
        return taskZza;
    }
}
