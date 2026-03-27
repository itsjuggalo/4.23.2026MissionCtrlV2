package c4;

import android.util.Log;
import b4.v;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Charset f13443e = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f13444f = Pattern.compile("^(1|true|t|yes|y|on)$", 2);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f13445g = Pattern.compile("^(0|false|f|no|n|off|)$", 2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f13446a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f13447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f13448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f13449d;

    public l(Executor executor, e eVar, e eVar2) {
        this.f13447b = executor;
        this.f13448c = eVar;
        this.f13449d = eVar2;
    }

    public static com.google.firebase.remoteconfig.internal.b e(e eVar) {
        return eVar.f();
    }

    public static Set f(e eVar) {
        HashSet hashSet = new HashSet();
        com.google.firebase.remoteconfig.internal.b bVarE = e(eVar);
        if (bVarE == null) {
            return hashSet;
        }
        Iterator<String> itKeys = bVarE.g().keys();
        while (itKeys.hasNext()) {
            hashSet.add(itKeys.next());
        }
        return hashSet;
    }

    public static String g(e eVar, String str) {
        com.google.firebase.remoteconfig.internal.b bVarE = e(eVar);
        if (bVarE == null) {
            return null;
        }
        try {
            return bVarE.g().getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static void j(String str, String str2) {
        Log.w("FirebaseRemoteConfig", String.format("No value of type '%s' exists for parameter key '%s'.", str2, str));
    }

    public void b(W1.d dVar) {
        synchronized (this.f13446a) {
            this.f13446a.add(dVar);
        }
    }

    public final void c(final String str, final com.google.firebase.remoteconfig.internal.b bVar) {
        if (bVar == null) {
            return;
        }
        synchronized (this.f13446a) {
            try {
                for (final W1.d dVar : this.f13446a) {
                    this.f13447b.execute(new Runnable() { // from class: c4.k
                        @Override // java.lang.Runnable
                        public final void run() {
                            dVar.a(str, bVar);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Map d() {
        HashSet<String> hashSet = new HashSet();
        hashSet.addAll(f(this.f13448c));
        hashSet.addAll(f(this.f13449d));
        HashMap map = new HashMap();
        for (String str : hashSet) {
            map.put(str, h(str));
        }
        return map;
    }

    public v h(String str) {
        String strG = g(this.f13448c, str);
        if (strG != null) {
            c(str, e(this.f13448c));
            return new q(strG, 2);
        }
        String strG2 = g(this.f13449d, str);
        if (strG2 != null) {
            return new q(strG2, 1);
        }
        j(str, "FirebaseRemoteConfigValue");
        return new q("", 0);
    }
}
