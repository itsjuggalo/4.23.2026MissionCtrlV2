package k2;

import android.os.Bundle;
import androidx.lifecycle.i;
import androidx.lifecycle.m;
import java.util.Map;
import k2.b;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import q.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f14479g = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f14481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f14482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b.C0250b f14484e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q.b f14480a = new q.b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f14485f = true;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        void a(f fVar);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {
        public /* synthetic */ b(k kVar) {
            this();
        }

        public b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface c {
        Bundle a();
    }

    public static final void d(d this$0, m mVar, i.a event) {
        t.f(this$0, "this$0");
        t.f(mVar, "<anonymous parameter 0>");
        t.f(event, "event");
        if (event == i.a.ON_START) {
            this$0.f14485f = true;
        } else if (event == i.a.ON_STOP) {
            this$0.f14485f = false;
        }
    }

    public final Bundle b(String key) {
        t.f(key, "key");
        if (!this.f14483d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f14482c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.f14482c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f14482c;
        if (bundle4 != null && !bundle4.isEmpty()) {
            return bundle2;
        }
        this.f14482c = null;
        return bundle2;
    }

    public final c c(String key) {
        t.f(key, "key");
        for (Map.Entry components : this.f14480a) {
            t.e(components, "components");
            String str = (String) components.getKey();
            c cVar = (c) components.getValue();
            if (t.b(str, key)) {
                return cVar;
            }
        }
        return null;
    }

    public final void e(i lifecycle) {
        t.f(lifecycle, "lifecycle");
        if (this.f14481b) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        lifecycle.a(new androidx.lifecycle.k() { // from class: k2.c
            @Override // androidx.lifecycle.k
            public final void b(m mVar, i.a aVar) {
                d.d(this.f14478a, mVar, aVar);
            }
        });
        this.f14481b = true;
    }

    public final void f(Bundle bundle) {
        if (!this.f14481b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (this.f14483d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        this.f14482c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        this.f14483d = true;
    }

    public final void g(Bundle outBundle) {
        t.f(outBundle, "outBundle");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f14482c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        b.d dVarD = this.f14480a.d();
        t.e(dVarD, "this.components.iteratorWithAdditions()");
        while (dVarD.hasNext()) {
            Map.Entry entry = (Map.Entry) dVarD.next();
            bundle.putBundle((String) entry.getKey(), ((c) entry.getValue()).a());
        }
        if (bundle.isEmpty()) {
            return;
        }
        outBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle);
    }

    public final void h(String key, c provider) {
        t.f(key, "key");
        t.f(provider, "provider");
        if (((c) this.f14480a.g(key, provider)) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public final void i(Class clazz) {
        t.f(clazz, "clazz");
        if (!this.f14485f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        b.C0250b c0250b = this.f14484e;
        if (c0250b == null) {
            c0250b = new b.C0250b(this);
        }
        this.f14484e = c0250b;
        try {
            clazz.getDeclaredConstructor(null);
            b.C0250b c0250b2 = this.f14484e;
            if (c0250b2 != null) {
                String name = clazz.getName();
                t.e(name, "clazz.name");
                c0250b2.b(name);
            }
        } catch (NoSuchMethodException e10) {
            throw new IllegalArgumentException("Class " + clazz.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
        }
    }
}
