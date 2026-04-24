package com.google.firebase.auth.internal;

import A1.e;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.p002firebaseauthapi.zzait;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import f0.C1242a;

/* JADX INFO: loaded from: classes.dex */
public final class zzax {
    private static zzax zza;
    private boolean zzb = false;
    private BroadcastReceiver zzc;

    private zzax() {
    }

    private static AuthCredential zza(Intent intent) {
        AbstractC0940s.k(intent);
        return com.google.firebase.auth.zzc.zza(((zzait) e.b(intent, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST", zzait.CREATOR)).zzc(true));
    }

    public static zzax zza() {
        if (zza == null) {
            zza = new zzax();
        }
        return zza;
    }

    public static /* synthetic */ void zza(zzax zzaxVar, Intent intent, TaskCompletionSource taskCompletionSource, Context context) {
        taskCompletionSource.setResult(intent.getStringExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN"));
        zza(context);
    }

    public static void zza(Context context) {
        zzax zzaxVar = zza;
        zzaxVar.zzb = false;
        if (zzaxVar.zzc != null) {
            C1242a.b(context).e(zza.zzc);
        }
        zza.zzc = null;
    }

    private final void zza(Activity activity, BroadcastReceiver broadcastReceiver) {
        this.zzc = broadcastReceiver;
        C1242a.b(activity).c(broadcastReceiver, new IntentFilter("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT"));
    }

    public final boolean zza(Activity activity, TaskCompletionSource<AuthResult> taskCompletionSource, FirebaseAuth firebaseAuth) {
        return zza(activity, taskCompletionSource, firebaseAuth, (FirebaseUser) null);
    }

    public final boolean zza(Activity activity, TaskCompletionSource<AuthResult> taskCompletionSource, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        if (this.zzb) {
            return false;
        }
        zza(activity, new zzbc(this, activity, taskCompletionSource, firebaseAuth, firebaseUser));
        this.zzb = true;
        return true;
    }

    public final boolean zza(Activity activity, TaskCompletionSource<String> taskCompletionSource) {
        if (this.zzb) {
            return false;
        }
        zza(activity, new zzbe(this, activity, taskCompletionSource));
        this.zzb = true;
        return true;
    }
}
