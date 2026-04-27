package o0;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0846i;
import androidx.lifecycle.InterfaceC0848k;
import androidx.lifecycle.InterfaceC0850m;
import java.util.Map;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import o0.b;
import q.b;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f13902g = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f13905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b.C0219b f13907e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q.b f13903a = new q.b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f13908f = true;

    public interface a {
        void a(f fVar);
    }

    public static final class b {
        public /* synthetic */ b(AbstractC1585j abstractC1585j) {
            this();
        }

        public b() {
        }
    }

    public interface c {
        Bundle a();
    }

    public static final void d(d this$0, InterfaceC0850m interfaceC0850m, AbstractC0846i.a event) {
        r.f(this$0, "this$0");
        r.f(interfaceC0850m, "<anonymous parameter 0>");
        r.f(event, "event");
        if (event == AbstractC0846i.a.ON_START) {
            this$0.f13908f = true;
        } else if (event == AbstractC0846i.a.ON_STOP) {
            this$0.f13908f = false;
        }
    }

    public final Bundle b(String key) {
        r.f(key, "key");
        if (!this.f13906d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f13905c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.f13905c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f13905c;
        if (bundle4 != null && !bundle4.isEmpty()) {
            return bundle2;
        }
        this.f13905c = null;
        return bundle2;
    }

    public final c c(String key) {
        r.f(key, "key");
        for (Map.Entry components : this.f13903a) {
            r.e(components, "components");
            String str = (String) components.getKey();
            c cVar = (c) components.getValue();
            if (r.b(str, key)) {
                return cVar;
            }
        }
        return null;
    }

    public final void e(AbstractC0846i lifecycle) {
        r.f(lifecycle, "lifecycle");
        if (this.f13904b) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        lifecycle.a(new InterfaceC0848k() { // from class: o0.c
            @Override // androidx.lifecycle.InterfaceC0848k
            public final void a(InterfaceC0850m interfaceC0850m, AbstractC0846i.a aVar) {
                d.d(this.f13901a, interfaceC0850m, aVar);
            }
        });
        this.f13904b = true;
    }

    public final void f(Bundle bundle) {
        if (!this.f13904b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (this.f13906d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        this.f13905c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        this.f13906d = true;
    }

    public final void g(Bundle outBundle) {
        r.f(outBundle, "outBundle");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f13905c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        b.d dVarI = this.f13903a.i();
        r.e(dVarI, "this.components.iteratorWithAdditions()");
        while (dVarI.hasNext()) {
            Map.Entry entry = (Map.Entry) dVarI.next();
            bundle.putBundle((String) entry.getKey(), ((c) entry.getValue()).a());
        }
        if (bundle.isEmpty()) {
            return;
        }
        outBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle);
    }

    public final void h(String key, c provider) {
        r.f(key, "key");
        r.f(provider, "provider");
        if (((c) this.f13903a.m(key, provider)) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public final void i(Class clazz) {
        r.f(clazz, "clazz");
        if (!this.f13908f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        b.C0219b c0219b = this.f13907e;
        if (c0219b == null) {
            c0219b = new b.C0219b(this);
        }
        this.f13907e = c0219b;
        try {
            clazz.getDeclaredConstructor(new Class[0]);
            b.C0219b c0219b2 = this.f13907e;
            if (c0219b2 != null) {
                String name = clazz.getName();
                r.e(name, "clazz.name");
                c0219b2.b(name);
            }
        } catch (NoSuchMethodException e4) {
            throw new IllegalArgumentException("Class " + clazz.getSimpleName() + " must have default constructor in order to be automatically recreated", e4);
        }
    }
}
