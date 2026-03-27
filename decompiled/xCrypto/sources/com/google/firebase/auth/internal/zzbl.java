package com.google.firebase.auth.internal;

import A1.e;
import G1.g;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.p002firebaseauthapi.zzaei;
import com.google.android.gms.internal.p002firebaseauthapi.zzait;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/* JADX INFO: loaded from: classes.dex */
public final class zzbl {
    private static long zza = 3600000;
    private static final com.google.android.gms.internal.p002firebaseauthapi.zzaj<String> zzb = com.google.android.gms.internal.p002firebaseauthapi.zzaj.zza("firebaseAppName", "firebaseUserUid", "operation", "tenantId", "verifyAssertionRequest", "statusCode", "statusMessage", "timestamp");
    private static final zzbl zzc = new zzbl();
    private Task<AuthResult> zzd;
    private Task<String> zze;
    private long zzf = 0;

    private zzbl() {
    }

    public static zzbl zzc() {
        return zzc;
    }

    public final Task<AuthResult> zza() {
        if (g.c().currentTimeMillis() - this.zzf < zza) {
            return this.zzd;
        }
        return null;
    }

    public final Task<String> zzb() {
        if (g.c().currentTimeMillis() - this.zzf < zza) {
            return this.zze;
        }
        return null;
    }

    private static void zza(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        com.google.android.gms.internal.p002firebaseauthapi.zzaj<String> zzajVar = zzb;
        int size = zzajVar.size();
        int i4 = 0;
        while (i4 < size) {
            String str = zzajVar.get(i4);
            i4++;
            editorEdit.remove(str);
        }
        editorEdit.commit();
    }

    public final void zza(Context context) {
        AbstractC0940s.k(context);
        zza(context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        this.zzd = null;
        this.zzf = 0L;
    }

    public final void zza(FirebaseAuth firebaseAuth) {
        zzait zzaitVar;
        String string;
        AbstractC0940s.k(firebaseAuth);
        SharedPreferences sharedPreferences = firebaseAuth.getApp().getApplicationContext().getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0);
        if (firebaseAuth.getApp().getName().equals(sharedPreferences.getString("firebaseAppName", ""))) {
            if (sharedPreferences.contains("verifyAssertionRequest")) {
                zzaitVar = (zzait) e.c(sharedPreferences.getString("verifyAssertionRequest", ""), zzait.CREATOR);
                String string2 = sharedPreferences.getString("operation", "");
                String string3 = sharedPreferences.getString("tenantId", null);
                string = sharedPreferences.getString("firebaseUserUid", "");
                this.zzf = sharedPreferences.getLong("timestamp", 0L);
                if (string3 != null) {
                    firebaseAuth.setTenantId(string3);
                    zzaitVar.zzb(string3);
                }
                string2.getClass();
                switch (string2) {
                    case "com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE":
                        if (firebaseAuth.getCurrentUser().getUid().equals(string)) {
                            this.zzd = firebaseAuth.zzc(firebaseAuth.getCurrentUser(), com.google.firebase.auth.zzc.zza(zzaitVar));
                            break;
                        } else {
                            this.zzd = null;
                            break;
                        }
                        break;
                    case "com.google.firebase.auth.internal.NONGMSCORE_LINK":
                        if (firebaseAuth.getCurrentUser().getUid().equals(string)) {
                            this.zzd = firebaseAuth.zza(firebaseAuth.getCurrentUser(), com.google.firebase.auth.zzc.zza(zzaitVar));
                            break;
                        } else {
                            this.zzd = null;
                            break;
                        }
                        break;
                    case "com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN":
                        this.zzd = firebaseAuth.signInWithCredential(com.google.firebase.auth.zzc.zza(zzaitVar));
                        break;
                    default:
                        this.zzd = null;
                        break;
                }
                zza(sharedPreferences);
                return;
            }
            if (sharedPreferences.contains("recaptchaToken")) {
                String string4 = sharedPreferences.getString("recaptchaToken", "");
                String string5 = sharedPreferences.getString("operation", "");
                this.zzf = sharedPreferences.getLong("timestamp", 0L);
                string5.getClass();
                if (!string5.equals("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA")) {
                    this.zze = null;
                } else {
                    this.zze = Tasks.forResult(string4);
                }
                zza(sharedPreferences);
                return;
            }
            if (sharedPreferences.contains("statusCode")) {
                Status status = new Status(sharedPreferences.getInt("statusCode", 17062), sharedPreferences.getString("statusMessage", ""));
                this.zzf = sharedPreferences.getLong("timestamp", 0L);
                zza(sharedPreferences);
                this.zzd = Tasks.forException(zzaei.zza(status));
            }
        }
    }

    public static void zza(Context context, Status status) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putInt("statusCode", status.k());
        editorEdit.putString("statusMessage", status.l());
        editorEdit.putLong("timestamp", g.c().currentTimeMillis());
        editorEdit.commit();
    }

    public static void zza(Context context, FirebaseAuth firebaseAuth) {
        AbstractC0940s.k(context);
        AbstractC0940s.k(firebaseAuth);
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("firebaseAppName", firebaseAuth.getApp().getName());
        editorEdit.commit();
    }

    public static void zza(Context context, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        AbstractC0940s.k(context);
        AbstractC0940s.k(firebaseAuth);
        AbstractC0940s.k(firebaseUser);
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("firebaseAppName", firebaseAuth.getApp().getName());
        editorEdit.putString("firebaseUserUid", firebaseUser.getUid());
        editorEdit.commit();
    }

    public static void zza(Context context, zzait zzaitVar, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("verifyAssertionRequest", e.f(zzaitVar));
        editorEdit.putString("operation", str);
        editorEdit.putString("tenantId", str2);
        editorEdit.putLong("timestamp", g.c().currentTimeMillis());
        editorEdit.commit();
    }

    public static void zza(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("recaptchaToken", str);
        editorEdit.putString("operation", str2);
        editorEdit.putLong("timestamp", g.c().currentTimeMillis());
        editorEdit.commit();
    }
}
