package com.google.firebase.auth.internal;

import a7.g;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.u;
import b2.a;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zza;
import com.google.android.gms.internal.p002firebaseauthapi.zzaeq;
import com.google.android.gms.internal.p002firebaseauthapi.zzaer;
import com.google.android.gms.internal.p002firebaseauthapi.zzaes;
import com.google.android.gms.internal.p002firebaseauthapi.zzafd;
import com.google.android.gms.internal.p002firebaseauthapi.zzagi;
import com.google.android.gms.internal.p002firebaseauthapi.zzagl;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.RecaptchaActivity;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import e7.d;
import fa.b;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import n7.j1;
import n7.l1;
import n7.p0;
import n7.r;
import n7.x1;
import n7.z1;
import t.c;
import t5.h;
import t5.j;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class RecaptchaActivity extends u implements zzaes {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f6094b = "RecaptchaActivity";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f6095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l1 f6096d = l1.f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6097a = false;

    private final Uri.Builder l(Uri.Builder builder, Intent intent, String str, String str2) {
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        String string = UUID.randomUUID().toString();
        String stringExtra2 = intent.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        String stringExtra3 = intent.getStringExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME");
        g gVarP = g.p(stringExtra3);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(gVarP);
        x1.b().d(getApplicationContext(), str, string, "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA", stringExtra3);
        String strA = z1.c(getApplicationContext(), gVarP.s()).a();
        if (TextUtils.isEmpty(strA)) {
            Log.e(f6094b, "Could not generate an encryption key for reCAPTCHA - cancelling flow.");
            n(r.a("Failed to generate/retrieve public encryption key for reCAPTCHA flow."));
            return null;
        }
        builder.appendQueryParameter("apiKey", stringExtra).appendQueryParameter("authType", "verifyApp").appendQueryParameter("apn", str).appendQueryParameter("hl", !TextUtils.isEmpty(firebaseAuth.p()) ? firebaseAuth.p() : zzafd.zza()).appendQueryParameter("eventId", string).appendQueryParameter("v", "X" + stringExtra2).appendQueryParameter("eid", "p").appendQueryParameter("appName", stringExtra3).appendQueryParameter("sha1Cert", str2).appendQueryParameter("publicKey", strA);
        return builder;
    }

    public static /* synthetic */ Uri m(Uri uri, Task task) {
        Uri.Builder builderBuildUpon = uri.buildUpon();
        if (task.isSuccessful()) {
            d dVar = (d) task.getResult();
            if (dVar.a() != null) {
                Log.w(f6094b, "Error getting App Check token; using placeholder token instead. Error: " + String.valueOf(dVar.a()));
            }
            builderBuildUpon.fragment("fac=" + dVar.b());
        } else {
            Log.e(f6094b, "Unexpected error getting App Check token: " + task.getException().getMessage());
        }
        return builderBuildUpon.build();
    }

    private final void n(Status status) {
        f6095c = 0L;
        this.f6097a = false;
        Intent intent = new Intent();
        j1.c(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        p(intent);
        f6096d.a(this);
        finish();
    }

    public static /* synthetic */ void o(RecaptchaActivity recaptchaActivity, String str, Task task) {
        if (recaptchaActivity.getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW"), 0) == null) {
            Log.e(f6094b, "Device cannot resolve intent for: android.intent.action.VIEW");
            zzaer.zzb(recaptchaActivity, str);
            return;
        }
        List<ResolveInfo> listQueryIntentServices = recaptchaActivity.getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
        if (listQueryIntentServices != null && !listQueryIntentServices.isEmpty()) {
            c cVarA = new c.d().a();
            cVarA.f20444a.addFlags(1073741824);
            cVarA.f20444a.addFlags(268435456);
            cVarA.a(recaptchaActivity, (Uri) task.getResult());
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", (Uri) task.getResult());
        intent.putExtra("com.android.browser.application_id", str);
        intent.addFlags(1073741824);
        intent.addFlags(268435456);
        recaptchaActivity.startActivity(intent);
    }

    private final boolean p(Intent intent) {
        return a.b(this).d(intent);
    }

    private final void q() {
        f6095c = 0L;
        this.f6097a = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        p(intent);
        f6096d.a(this);
        finish();
    }

    @Override // androidx.fragment.app.u, androidx.activity.h, h0.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if (!"com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA".equals(action) && !"android.intent.action.VIEW".equals(action)) {
            Log.e(f6094b, "Could not do operation - unknown action: " + action);
            q();
            return;
        }
        long jA = h.d().a();
        if (jA - f6095c < HTTPTimeoutManager.DEFAULT_TIMEOUT_MS) {
            Log.e(f6094b, "Could not start operation - already in progress");
            return;
        }
        f6095c = jA;
        if (bundle != null) {
            this.f6097a = bundle.getBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW");
        }
    }

    @Override // androidx.activity.h, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // androidx.fragment.app.u, android.app.Activity
    public void onResume() {
        RecaptchaActivity recaptchaActivity;
        super.onResume();
        if (!"android.intent.action.VIEW".equals(getIntent().getAction())) {
            if (this.f6097a) {
                q();
                return;
            }
            Intent intent = getIntent();
            String packageName = getPackageName();
            try {
                String lowerCase = j.b(t5.a.a(this, packageName)).toLowerCase(Locale.US);
                g gVarP = g.p(intent.getStringExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME"));
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(gVarP);
                if (zzagl.zza(gVarP)) {
                    recaptchaActivity = this;
                    zza(l(Uri.parse(zzagl.zza(gVarP.r().b())).buildUpon(), getIntent(), packageName, lowerCase).build(), packageName, firebaseAuth.v0());
                } else {
                    recaptchaActivity = this;
                    new zzaeq(packageName, lowerCase, intent, gVarP, recaptchaActivity).executeOnExecutor(firebaseAuth.B0(), new Void[0]);
                }
            } catch (PackageManager.NameNotFoundException e10) {
                recaptchaActivity = this;
                Log.e(f6094b, "Could not get package signature: " + packageName + " " + String.valueOf(e10));
                zzaer.zzb(this, packageName);
            }
            recaptchaActivity.f6097a = true;
            return;
        }
        Intent intent2 = getIntent();
        if (intent2.hasExtra("firebaseError")) {
            n(j1.b(intent2.getStringExtra("firebaseError")));
            return;
        }
        if (!intent2.hasExtra("link") || !intent2.hasExtra("eventId")) {
            q();
            return;
        }
        String stringExtra = intent2.getStringExtra("link");
        String strG = x1.b().g(getApplicationContext(), getPackageName(), intent2.getStringExtra("eventId"));
        if (TextUtils.isEmpty(strG)) {
            Log.e(f6094b, "Failed to find registration for this event - failing to prevent session injection.");
            n(r.a("Failed to find registration for this reCAPTCHA event"));
        }
        if (intent2.getBooleanExtra("encryptionEnabled", true)) {
            stringExtra = z1.c(getApplicationContext(), g.p(strG).s()).b(stringExtra);
        }
        String queryParameter = Uri.parse(stringExtra).getQueryParameter("recaptchaToken");
        f6095c = 0L;
        this.f6097a = false;
        Intent intent3 = new Intent();
        intent3.putExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN", queryParameter);
        intent3.putExtra("com.google.firebase.auth.internal.OPERATION", "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
        intent3.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (p(intent3)) {
            f6096d.a(this);
        } else {
            p0.f(getApplicationContext(), queryParameter, "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
        }
        finish();
    }

    @Override // androidx.activity.h, h0.f, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW", this.f6097a);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final Context zza() {
        return getApplicationContext();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final Uri.Builder zza(Intent intent, String str, String str2) {
        return l(new Uri.Builder().scheme("https").appendPath("__").appendPath("auth").appendPath("handler"), intent, str, str2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final String zza(String str) {
        String strZza = zzagi.zza("firebear.identityToolkit");
        if (TextUtils.isEmpty(strZza)) {
            return zzagl.zzb(str);
        }
        Log.e(f6094b, "Found hermetic configuration for identityToolkit URL: " + strZza);
        return strZza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final HttpURLConnection zza(URL url) {
        try {
            return (HttpURLConnection) zza.zza().zza(url, "client-firebase-auth-api");
        } catch (IOException unused) {
            zzaes.zza.c("Error generating connection", new Object[0]);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final void zza(String str, Status status) {
        if (status == null) {
            q();
        } else {
            n(status);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final void zza(final Uri uri, final String str, b bVar) {
        Task taskForResult;
        j7.b bVar2 = (j7.b) bVar.get();
        if (bVar2 != null) {
            taskForResult = bVar2.a(false).continueWith(new Continuation() { // from class: n7.t0
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return RecaptchaActivity.m(uri, task);
                }
            });
        } else {
            taskForResult = Tasks.forResult(uri);
        }
        taskForResult.addOnCompleteListener(new OnCompleteListener() { // from class: n7.r0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                RecaptchaActivity.o(this.f16847a, str, task);
            }
        });
    }
}
