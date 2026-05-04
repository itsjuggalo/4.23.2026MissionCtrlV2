package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import m7.o0;
import p5.a;
import v5.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzagc {
    private static final a zza = new a("FirebaseAuth", "SmsRetrieverHelper");
    private final Context zzb;
    private final ScheduledExecutorService zzc;
    private final HashMap<String, zzagj> zzd = new HashMap<>();

    public zzagc(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzb = context;
        this.zzc = scheduledExecutorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zze(String str) {
        zzagj zzagjVar = this.zzd.get(str);
        if (zzagjVar == null) {
            return;
        }
        if (!zzagjVar.zzi) {
            zzd(str);
        }
        zzb(str);
    }

    public final String zzb() {
        try {
            String packageName = this.zzb.getPackageName();
            String strZza = zza(packageName, (Build.VERSION.SDK_INT < 28 ? d.a(this.zzb).e(packageName, 64).signatures : d.a(this.zzb).e(packageName, 134217728).signingInfo.getApkContentsSigners())[0].toCharsString());
            if (strZza != null) {
                return strZza;
            }
            zza.c("Hash generation failed.", new Object[0]);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            zza.c("Unable to find package to obtain hash.", new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd(String str) {
        zzagj zzagjVar = this.zzd.get(str);
        if (zzagjVar == null || zzagjVar.zzh || zzac.zzc(zzagjVar.zzd)) {
            return;
        }
        zza.h("Timed out waiting for SMS.", new Object[0]);
        Iterator<zzael> it = zzagjVar.zzb.iterator();
        while (it.hasNext()) {
            it.next().zza(zzagjVar.zzd);
        }
        zzagjVar.zzi = true;
    }

    public final boolean zzc(String str) {
        return this.zzd.get(str) != null;
    }

    public final zzael zza(zzael zzaelVar, String str) {
        return new zzagh(this, zzaelVar, str);
    }

    public static String zza(String str) {
        Matcher matcher = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)").matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    private static String zza(String str, String str2) {
        String str3 = str + " " + str2;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str3.getBytes(StandardCharsets.UTF_8));
            String strSubstring = Base64.encodeToString(Arrays.copyOf(messageDigest.digest(), 9), 3).substring(0, 11);
            zza.a("Package: " + str + " -- Hash: " + strSubstring, new Object[0]);
            return strSubstring;
        } catch (NoSuchAlgorithmException e10) {
            zza.c("NoSuchAlgorithm: " + e10.getMessage(), new Object[0]);
            return null;
        }
    }

    public static /* synthetic */ void zzb(zzagc zzagcVar, String str) {
        zzagj zzagjVar = zzagcVar.zzd.get(str);
        if (zzagjVar == null || zzac.zzc(zzagjVar.zzd) || zzac.zzc(zzagjVar.zze) || zzagjVar.zzb.isEmpty()) {
            return;
        }
        Iterator<zzael> it = zzagjVar.zzb.iterator();
        while (it.hasNext()) {
            it.next().zza(o0.V(zzagjVar.zzd, zzagjVar.zze));
        }
        zzagjVar.zzh = true;
    }

    public final void zza(final String str, zzael zzaelVar, long j10, boolean z10) {
        this.zzd.put(str, new zzagj(j10, z10));
        zzb(zzaelVar, str);
        zzagj zzagjVar = this.zzd.get(str);
        if (zzagjVar.zza <= 0) {
            zza.h("Timeout of 0 specified; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzagjVar.zzf = this.zzc.schedule(new Runnable() { // from class: com.google.android.gms.internal.firebase-auth-api.zzagf
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zze(str);
            }
        }, zzagjVar.zza, TimeUnit.SECONDS);
        if (!zzagjVar.zzc) {
            zza.h("SMS auto-retrieval unavailable; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzagg zzaggVar = new zzagg(this, str);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.gms.auth.api.phone.SMS_RETRIEVED");
        i0.a.l(this.zzb.getApplicationContext(), zzaggVar, intentFilter, 2);
        d5.a.a(this.zzb).startSmsRetriever().addOnFailureListener(new zzage(this));
    }

    public final void zzb(zzael zzaelVar, String str) {
        zzagj zzagjVar = this.zzd.get(str);
        if (zzagjVar == null) {
            return;
        }
        zzagjVar.zzb.add(zzaelVar);
        if (zzagjVar.zzg) {
            zzaelVar.zzb(zzagjVar.zzd);
        }
        if (zzagjVar.zzh) {
            zzaelVar.zza(o0.V(zzagjVar.zzd, zzagjVar.zze));
        }
        if (zzagjVar.zzi) {
            zzaelVar.zza(zzagjVar.zzd);
        }
    }

    public final void zzb(String str) {
        zzagj zzagjVar = this.zzd.get(str);
        if (zzagjVar == null) {
            return;
        }
        ScheduledFuture<?> scheduledFuture = zzagjVar.zzf;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            zzagjVar.zzf.cancel(false);
        }
        zzagjVar.zzb.clear();
        this.zzd.remove(str);
    }
}
