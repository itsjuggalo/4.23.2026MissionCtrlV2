package com.google.android.gms.internal.p002firebaseauthapi;

import D1.d;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Base64;
import com.google.android.gms.internal.p001authapiphone.zzab;
import i2.u;
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
import s3.AbstractC1024h;
import u.AbstractC1193h;
import x1.C1402a;

/* JADX INFO: loaded from: classes.dex */
final class zzagc {
    private static final C1402a zza = new C1402a("FirebaseAuth", "SmsRetrieverHelper");
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
            String strZza = zza(packageName, (Build.VERSION.SDK_INT < 28 ? d.a(this.zzb).b(64, packageName).signatures : d.a(this.zzb).b(134217728, packageName).signingInfo.getApkContentsSigners())[0].toCharsString());
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
        zza.f("Timed out waiting for SMS.", new Object[0]);
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
        String strK = a3.d.k(str, " ", str2);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(strK.getBytes(StandardCharsets.UTF_8));
            String strSubstring = Base64.encodeToString(Arrays.copyOf(messageDigest.digest(), 9), 3).substring(0, 11);
            zza.a("Package: " + str + " -- Hash: " + strSubstring, new Object[0]);
            return strSubstring;
        } catch (NoSuchAlgorithmException e) {
            zza.c(AbstractC1024h.b("NoSuchAlgorithm: ", e.getMessage()), new Object[0]);
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
            it.next().zza(u.p(zzagjVar.zzd, zzagjVar.zze));
        }
        zzagjVar.zzh = true;
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
            zzaelVar.zza(u.p(zzagjVar.zzd, zzagjVar.zze));
        }
        if (zzagjVar.zzi) {
            zzaelVar.zza(zzagjVar.zzd);
        }
    }

    public final void zza(final String str, zzael zzaelVar, long j4, boolean z6) {
        this.zzd.put(str, new zzagj(j4, z6));
        zzb(zzaelVar, str);
        zzagj zzagjVar = this.zzd.get(str);
        if (zzagjVar.zza <= 0) {
            zza.f("Timeout of 0 specified; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzagjVar.zzf = this.zzc.schedule(new Runnable() { // from class: com.google.android.gms.internal.firebase-auth-api.zzagf
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zze(str);
            }
        }, zzagjVar.zza, TimeUnit.SECONDS);
        if (!zzagjVar.zzc) {
            zza.f("SMS auto-retrieval unavailable; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzagg zzaggVar = new zzagg(this, str);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.gms.auth.api.phone.SMS_RETRIEVED");
        AbstractC1193h.registerReceiver(this.zzb.getApplicationContext(), zzaggVar, intentFilter, 2);
        new zzab(this.zzb).startSmsRetriever().addOnFailureListener(new zzage(this));
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
