package F0;

import F0.b;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0963i;
import androidx.lifecycle.InterfaceC0965k;
import androidx.lifecycle.InterfaceC0967m;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import r.C2571b;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f1881g = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f1884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b.C0015b f1886e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2571b f1882a = new C2571b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1887f = true;

    public interface a {
        void a(f fVar);
    }

    public static final class b {
        public /* synthetic */ b(AbstractC2148j abstractC2148j) {
            this();
        }

        public b() {
        }
    }

    public interface c {
        Bundle a();
    }

    public static final void d(d this$0, InterfaceC0967m interfaceC0967m, AbstractC0963i.a event) {
        r.f(this$0, "this$0");
        r.f(interfaceC0967m, "<anonymous parameter 0>");
        r.f(event, "event");
        if (event == AbstractC0963i.a.ON_START) {
            this$0.f1887f = true;
        } else if (event == AbstractC0963i.a.ON_STOP) {
            this$0.f1887f = false;
        }
    }

    public final Bundle b(String key) {
        r.f(key, "key");
        if (!this.f1885d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f1884c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.f1884c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f1884c;
        if (bundle4 == null || bundle4.isEmpty()) {
            this.f1884c = null;
        }
        return bundle2;
    }

    public final c c(String key) {
        r.f(key, "key");
        for (Map.Entry components : this.f1882a) {
            r.e(components, "components");
            String str = (String) components.getKey();
            c cVar = (c) components.getValue();
            if (r.b(str, key)) {
                return cVar;
            }
        }
        return null;
    }

    public final void e(AbstractC0963i lifecycle) {
        r.f(lifecycle, "lifecycle");
        if (this.f1883b) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        lifecycle.a(new InterfaceC0965k() { // from class: F0.c
            @Override // androidx.lifecycle.InterfaceC0965k
            public final void a(InterfaceC0967m interfaceC0967m, AbstractC0963i.a aVar) {
                d.d(this.f1880a, interfaceC0967m, aVar);
            }
        });
        this.f1883b = true;
    }

    public final void f(Bundle bundle) {
        if (!this.f1883b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (this.f1885d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        this.f1884c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        this.f1885d = true;
    }

    public final void g(Bundle outBundle) {
        r.f(outBundle, "outBundle");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1884c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        C2571b.d dVarC = this.f1882a.c();
        r.e(dVarC, "this.components.iteratorWithAdditions()");
        while (dVarC.hasNext()) {
            Map.Entry entry = (Map.Entry) dVarC.next();
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
        if (((c) this.f1882a.j(key, provider)) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public final void i(Class clazz) {
        r.f(clazz, "clazz");
        if (!this.f1887f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        b.C0015b c0015b = this.f1886e;
        if (c0015b == null) {
            c0015b = new b.C0015b(this);
        }
        this.f1886e = c0015b;
        try {
            clazz.getDeclaredConstructor(null);
            b.C0015b c0015b2 = this.f1886e;
            if (c0015b2 != null) {
                String name = clazz.getName();
                r.e(name, "clazz.name");
                c0015b2.b(name);
            }
        } catch (NoSuchMethodException e7) {
            throw new IllegalArgumentException("Class " + clazz.getSimpleName() + " must have default constructor in order to be automatically recreated", e7);
        }
    }
}
