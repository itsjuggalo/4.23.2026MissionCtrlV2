package u7;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.google.android.gms.tasks.Tasks;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import u7.i0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h0 implements i0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f22276g = Pattern.compile("[^\\p{Alnum}]");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f22277h = Pattern.quote("/");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f22278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f22279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ga.h f22281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c0 f22282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i0.a f22283f;

    public h0(Context context, String str, ga.h hVar, c0 c0Var) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        this.f22279b = context;
        this.f22280c = str;
        this.f22281d = hVar;
        this.f22282e = c0Var;
        this.f22278a = new j0();
    }

    public static String c() {
        return "SYN_" + UUID.randomUUID().toString();
    }

    public static String e(String str) {
        return f22276g.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    public static boolean k(String str) {
        return str != null && str.startsWith("SYN_");
    }

    @Override // u7.i0
    public synchronized i0.a a() {
        if (!n()) {
            return this.f22283f;
        }
        r7.g.f().i("Determining Crashlytics installation ID...");
        SharedPreferences sharedPreferencesQ = i.q(this.f22279b);
        String string = sharedPreferencesQ.getString("firebase.installation.id", null);
        r7.g.f().i("Cached Firebase Installation ID: " + string);
        if (this.f22282e.d()) {
            g0 g0VarD = d(false);
            r7.g.f().i("Fetched Firebase Installation ID: " + g0VarD.b());
            if (g0VarD.b() == null) {
                g0VarD = new g0(string == null ? c() : string, null);
            }
            if (Objects.equals(g0VarD.b(), string)) {
                this.f22283f = i0.a.a(l(sharedPreferencesQ), g0VarD);
            } else {
                this.f22283f = i0.a.a(b(g0VarD.b(), sharedPreferencesQ), g0VarD);
            }
        } else if (k(string)) {
            this.f22283f = i0.a.b(l(sharedPreferencesQ));
        } else {
            this.f22283f = i0.a.b(b(c(), sharedPreferencesQ));
        }
        r7.g.f().i("Install IDs: " + this.f22283f);
        return this.f22283f;
    }

    public final synchronized String b(String str, SharedPreferences sharedPreferences) {
        String strE;
        strE = e(UUID.randomUUID().toString());
        r7.g.f().i("Created new Crashlytics installation ID: " + strE + " for FID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", strE).putString("firebase.installation.id", str).apply();
        return strE;
    }

    public g0 d(boolean z10) {
        String strB;
        v7.i.e();
        String str = null;
        if (z10) {
            try {
                strB = ((ga.m) Tasks.await(this.f22281d.a(false), 10000L, TimeUnit.MILLISECONDS)).b();
            } catch (Exception e10) {
                r7.g.f().l("Error getting Firebase authentication token.", e10);
                strB = null;
            }
        } else {
            strB = null;
        }
        try {
            str = (String) Tasks.await(this.f22281d.getId(), 10000L, TimeUnit.MILLISECONDS);
        } catch (Exception e11) {
            r7.g.f().l("Error getting Firebase installation id.", e11);
        }
        return new g0(str, strB);
    }

    public String f() {
        return this.f22280c;
    }

    public String g() {
        return this.f22278a.a(this.f22279b);
    }

    public String h() {
        return String.format(Locale.US, "%s/%s", m(Build.MANUFACTURER), m(Build.MODEL));
    }

    public String i() {
        return m(Build.VERSION.INCREMENTAL);
    }

    public String j() {
        return m(Build.VERSION.RELEASE);
    }

    public final String l(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("crashlytics.installation.id", null);
    }

    public final String m(String str) {
        return str.replaceAll(f22277h, "");
    }

    public final boolean n() {
        i0.a aVar = this.f22283f;
        if (aVar != null) {
            return aVar.e() == null && this.f22282e.d();
        }
        return true;
    }
}
