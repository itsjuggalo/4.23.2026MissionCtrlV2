package qa;

import android.util.Log;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONException;
import pa.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Charset f18997e = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f18998f = Pattern.compile("^(1|true|t|yes|y|on)$", 2);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f18999g = Pattern.compile("^(0|false|f|no|n|off|)$", 2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f19000a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f19001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f19002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f19003d;

    public l(Executor executor, e eVar, e eVar2) {
        this.f19001b = executor;
        this.f19002c = eVar;
        this.f19003d = eVar2;
    }

    public static com.google.firebase.remoteconfig.internal.b e(e eVar) {
        return eVar.f();
    }

    public static Set f(e eVar) {
        HashSet hashSet = new HashSet();
        com.google.firebase.remoteconfig.internal.b bVarE = e(eVar);
        if (bVarE != null) {
            Iterator<String> itKeys = bVarE.g().keys();
            while (itKeys.hasNext()) {
                hashSet.add(itKeys.next());
            }
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

    public static void i(String str, String str2) {
        Log.w("FirebaseRemoteConfig", String.format("No value of type '%s' exists for parameter key '%s'.", str2, str));
    }

    public void b(t5.d dVar) {
        synchronized (this.f19000a) {
            this.f19000a.add(dVar);
        }
    }

    public final void c(final String str, final com.google.firebase.remoteconfig.internal.b bVar) {
        if (bVar == null) {
            return;
        }
        synchronized (this.f19000a) {
            try {
                for (final t5.d dVar : this.f19000a) {
                    this.f19001b.execute(new Runnable() { // from class: qa.k
                        @Override // java.lang.Runnable
                        public final void run() {
                            dVar.accept(str, bVar);
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
        hashSet.addAll(f(this.f19002c));
        hashSet.addAll(f(this.f19003d));
        HashMap map = new HashMap();
        for (String str : hashSet) {
            map.put(str, h(str));
        }
        return map;
    }

    public v h(String str) {
        String strG = g(this.f19002c, str);
        if (strG != null) {
            c(str, e(this.f19002c));
            return new q(strG, 2);
        }
        String strG2 = g(this.f19003d, str);
        if (strG2 != null) {
            return new q(strG2, 1);
        }
        i(str, "FirebaseRemoteConfigValue");
        return new q("", 0);
    }
}
