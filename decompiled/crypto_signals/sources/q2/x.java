package q2;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.tasks.Tasks;
import d.C0516t;
import i2.C0655a;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import n2.C0873b;
import r2.C0968c;
import r2.C0969d;

/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f9255g = Pattern.compile("[^\\p{Alnum}]");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f9256h = Pattern.quote("/");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f5.t f9257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f9258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Y2.e f9260d;
    public final C0655a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C0924c f9261f;

    public x(Context context, String str, Y2.e eVar, C0655a c0655a) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        this.f9258b = context;
        this.f9259c = str;
        this.f9260d = eVar;
        this.e = c0655a;
        this.f9257a = new f5.t();
    }

    public final synchronized String a(SharedPreferences sharedPreferences, String str) {
        String lowerCase;
        lowerCase = f9255g.matcher(UUID.randomUUID().toString()).replaceAll("").toLowerCase(Locale.US);
        String str2 = "Created new Crashlytics installation ID: " + lowerCase + " for FID: " + str;
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", str2, null);
        }
        sharedPreferences.edit().putString("crashlytics.installation.id", lowerCase).putString("firebase.installation.id", str).apply();
        return lowerCase;
    }

    public final w b(boolean z6) {
        String str;
        String str2 = null;
        if (!((Boolean) new C0516t(0, C0969d.f9461d, C0968c.class, "isNotMainThread", "isNotMainThread()Z", 0, 4).invoke()).booleanValue()) {
            String str3 = "Must not be called on a main thread, was called on " + Thread.currentThread().getName() + '.';
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", str3, null);
            }
        }
        Y2.e eVar = this.f9260d;
        if (z6) {
            try {
                str = ((Y2.a) Tasks.await(((Y2.d) eVar).d(), 10000L, TimeUnit.MILLISECONDS)).f3590a;
            } catch (Exception e) {
                Log.w("FirebaseCrashlytics", "Error getting Firebase authentication token.", e);
                str = null;
            }
        } else {
            str = null;
        }
        try {
            str2 = (String) Tasks.await(((Y2.d) eVar).c(), 10000L, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            Log.w("FirebaseCrashlytics", "Error getting Firebase installation id.", e2);
        }
        return new w(str2, str);
    }

    public final synchronized C0924c c() {
        String str;
        C0924c c0924c = this.f9261f;
        if (c0924c != null && (c0924c.f9167b != null || !this.e.a())) {
            return this.f9261f;
        }
        C0873b c0873b = C0873b.f8554a;
        c0873b.f("Determining Crashlytics installation ID...");
        SharedPreferences sharedPreferences = this.f9258b.getSharedPreferences("com.google.firebase.crashlytics", 0);
        String string = sharedPreferences.getString("firebase.installation.id", null);
        c0873b.f("Cached Firebase Installation ID: " + string);
        if (this.e.a()) {
            w wVarB = b(false);
            c0873b.f("Fetched Firebase Installation ID: " + wVarB.f9253a);
            if (wVarB.f9253a == null) {
                if (string == null) {
                    str = "SYN_" + UUID.randomUUID().toString();
                } else {
                    str = string;
                }
                wVarB = new w(str, null);
            }
            if (Objects.equals(wVarB.f9253a, string)) {
                this.f9261f = new C0924c(sharedPreferences.getString("crashlytics.installation.id", null), wVarB.f9253a, wVarB.f9254b);
            } else {
                this.f9261f = new C0924c(a(sharedPreferences, wVarB.f9253a), wVarB.f9253a, wVarB.f9254b);
            }
        } else if (string == null || !string.startsWith("SYN_")) {
            this.f9261f = new C0924c(a(sharedPreferences, "SYN_" + UUID.randomUUID().toString()), null, null);
        } else {
            this.f9261f = new C0924c(sharedPreferences.getString("crashlytics.installation.id", null), null, null);
        }
        c0873b.f("Install IDs: " + this.f9261f);
        return this.f9261f;
    }

    public final String d() {
        String str;
        f5.t tVar = this.f9257a;
        Context context = this.f9258b;
        synchronized (tVar) {
            try {
                if (tVar.f6534b == null) {
                    String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                    if (installerPackageName == null) {
                        installerPackageName = "";
                    }
                    tVar.f6534b = installerPackageName;
                }
                str = "".equals(tVar.f6534b) ? null : tVar.f6534b;
            } finally {
            }
        }
        return str;
    }
}
