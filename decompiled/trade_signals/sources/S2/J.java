package S2;

import S2.K;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import l2.AbstractC2331o;

/* JADX INFO: loaded from: classes.dex */
public class J implements K {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f7500g = Pattern.compile("[^\\p{Alnum}]");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f7501h = Pattern.quote("/");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L f7502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f7503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final T3.h f7505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final E f7506e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public K.a f7507f;

    public J(Context context, String str, T3.h hVar, E e8) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        this.f7503b = context;
        this.f7504c = str;
        this.f7505d = hVar;
        this.f7506e = e8;
        this.f7502a = new L();
    }

    public static String c() {
        return "SYN_" + UUID.randomUUID().toString();
    }

    public static String e(String str) {
        return f7500g.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    public static boolean k(String str) {
        return str != null && str.startsWith("SYN_");
    }

    @Override // S2.K
    public synchronized K.a a() {
        K.a aVarB;
        if (!n()) {
            return this.f7507f;
        }
        P2.g.f().i("Determining Crashlytics installation ID...");
        SharedPreferences sharedPreferencesQ = AbstractC0903j.q(this.f7503b);
        String string = sharedPreferencesQ.getString("firebase.installation.id", null);
        P2.g.f().i("Cached Firebase Installation ID: " + string);
        if (this.f7506e.d()) {
            I iD = d(false);
            P2.g.f().i("Fetched Firebase Installation ID: " + iD.b());
            if (iD.b() == null) {
                iD = new I(string == null ? c() : string, null);
            }
            aVarB = Objects.equals(iD.b(), string) ? K.a.a(l(sharedPreferencesQ), iD) : K.a.a(b(iD.b(), sharedPreferencesQ), iD);
        } else {
            aVarB = k(string) ? K.a.b(l(sharedPreferencesQ)) : K.a.b(b(c(), sharedPreferencesQ));
        }
        this.f7507f = aVarB;
        P2.g.f().i("Install IDs: " + this.f7507f);
        return this.f7507f;
    }

    public final synchronized String b(String str, SharedPreferences sharedPreferences) {
        String strE;
        strE = e(UUID.randomUUID().toString());
        P2.g.f().i("Created new Crashlytics installation ID: " + strE + " for FID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", strE).putString("firebase.installation.id", str).apply();
        return strE;
    }

    public I d(boolean z7) {
        String strB;
        T2.i.e();
        String str = null;
        if (z7) {
            try {
                strB = ((T3.m) AbstractC2331o.b(this.f7505d.a(false), 10000L, TimeUnit.MILLISECONDS)).b();
            } catch (Exception e8) {
                P2.g.f().l("Error getting Firebase authentication token.", e8);
                strB = null;
            }
        } else {
            strB = null;
        }
        try {
            str = (String) AbstractC2331o.b(this.f7505d.getId(), 10000L, TimeUnit.MILLISECONDS);
        } catch (Exception e9) {
            P2.g.f().l("Error getting Firebase installation id.", e9);
        }
        return new I(str, strB);
    }

    public String f() {
        return this.f7504c;
    }

    public String g() {
        return this.f7502a.a(this.f7503b);
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
        return str.replaceAll(f7501h, "");
    }

    public final boolean n() {
        K.a aVar = this.f7507f;
        return aVar == null || (aVar.e() == null && this.f7506e.d());
    }
}
