package h3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.google.android.gms.tasks.Tasks;
import e3.C1478g;
import h3.InterfaceC1684O;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: h3.N, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1683N implements InterfaceC1684O {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f14778g = Pattern.compile("[^\\p{Alnum}]");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f14779h = Pattern.quote("/");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1685P f14780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f14781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final O3.h f14783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C1678I f14784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InterfaceC1684O.a f14785f;

    public C1683N(Context context, String str, O3.h hVar, C1678I c1678i) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        this.f14781b = context;
        this.f14782c = str;
        this.f14783d = hVar;
        this.f14784e = c1678i;
        this.f14780a = new C1685P();
    }

    public static String c() {
        return "SYN_" + UUID.randomUUID().toString();
    }

    public static String e(String str) {
        return f14778g.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    public static boolean k(String str) {
        return str != null && str.startsWith("SYN_");
    }

    @Override // h3.InterfaceC1684O
    public synchronized InterfaceC1684O.a a() {
        if (!n()) {
            return this.f14785f;
        }
        C1478g.f().i("Determining Crashlytics installation ID...");
        SharedPreferences sharedPreferencesQ = AbstractC1695i.q(this.f14781b);
        String string = sharedPreferencesQ.getString("firebase.installation.id", null);
        C1478g.f().i("Cached Firebase Installation ID: " + string);
        if (this.f14784e.d()) {
            C1682M c1682mD = d(false);
            C1478g.f().i("Fetched Firebase Installation ID: " + c1682mD.b());
            if (c1682mD.b() == null) {
                c1682mD = new C1682M(string == null ? c() : string, null);
            }
            if (Objects.equals(c1682mD.b(), string)) {
                this.f14785f = InterfaceC1684O.a.a(l(sharedPreferencesQ), c1682mD);
            } else {
                this.f14785f = InterfaceC1684O.a.a(b(c1682mD.b(), sharedPreferencesQ), c1682mD);
            }
        } else if (k(string)) {
            this.f14785f = InterfaceC1684O.a.b(l(sharedPreferencesQ));
        } else {
            this.f14785f = InterfaceC1684O.a.b(b(c(), sharedPreferencesQ));
        }
        C1478g.f().i("Install IDs: " + this.f14785f);
        return this.f14785f;
    }

    public final synchronized String b(String str, SharedPreferences sharedPreferences) {
        String strE;
        strE = e(UUID.randomUUID().toString());
        C1478g.f().i("Created new Crashlytics installation ID: " + strE + " for FID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", strE).putString("firebase.installation.id", str).apply();
        return strE;
    }

    public C1682M d(boolean z7) {
        String strB;
        i3.f.e();
        String str = null;
        if (z7) {
            try {
                strB = ((O3.m) Tasks.await(this.f14783d.a(false), 10000L, TimeUnit.MILLISECONDS)).b();
            } catch (Exception e7) {
                C1478g.f().l("Error getting Firebase authentication token.", e7);
                strB = null;
            }
        } else {
            strB = null;
        }
        try {
            str = (String) Tasks.await(this.f14783d.getId(), 10000L, TimeUnit.MILLISECONDS);
        } catch (Exception e8) {
            C1478g.f().l("Error getting Firebase installation id.", e8);
        }
        return new C1682M(str, strB);
    }

    public String f() {
        return this.f14782c;
    }

    public String g() {
        return this.f14780a.a(this.f14781b);
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
        return str.replaceAll(f14779h, "");
    }

    public final boolean n() {
        InterfaceC1684O.a aVar = this.f14785f;
        return aVar == null || (aVar.e() == null && this.f14784e.d());
    }
}
