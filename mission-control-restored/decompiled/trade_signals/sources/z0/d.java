package z0;

import android.os.Bundle;
import androidx.lifecycle.AbstractC1157i;
import androidx.lifecycle.InterfaceC1159k;
import androidx.lifecycle.InterfaceC1161m;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import q.C2616b;
import z0.C2999b;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f24624g = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f24626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f24627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f24628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C2999b.C0437b f24629e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2616b f24625a = new C2616b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f24630f = true;

    public interface a {
        void a(f fVar);
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public interface c {
        Bundle a();
    }

    public static final void d(d this$0, InterfaceC1161m interfaceC1161m, AbstractC1157i.a event) {
        boolean z7;
        AbstractC2304t.f(this$0, "this$0");
        AbstractC2304t.f(interfaceC1161m, "<anonymous parameter 0>");
        AbstractC2304t.f(event, "event");
        if (event == AbstractC1157i.a.ON_START) {
            z7 = true;
        } else if (event != AbstractC1157i.a.ON_STOP) {
            return;
        } else {
            z7 = false;
        }
        this$0.f24630f = z7;
    }

    public final Bundle b(String key) {
        AbstractC2304t.f(key, "key");
        if (!this.f24628d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
        }
        Bundle bundle = this.f24627c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.f24627c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f24627c;
        if (bundle4 == null || bundle4.isEmpty()) {
            this.f24627c = null;
        }
        return bundle2;
    }

    public final c c(String key) {
        AbstractC2304t.f(key, "key");
        for (Map.Entry components : this.f24625a) {
            AbstractC2304t.e(components, "components");
            String str = (String) components.getKey();
            c cVar = (c) components.getValue();
            if (AbstractC2304t.b(str, key)) {
                return cVar;
            }
        }
        return null;
    }

    public final void e(AbstractC1157i lifecycle) {
        AbstractC2304t.f(lifecycle, "lifecycle");
        if (!(!this.f24626b)) {
            throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
        }
        lifecycle.a(new InterfaceC1159k() { // from class: z0.c
            @Override // androidx.lifecycle.InterfaceC1159k
            public final void b(InterfaceC1161m interfaceC1161m, AbstractC1157i.a aVar) {
                d.d(this.f24623a, interfaceC1161m, aVar);
            }
        });
        this.f24626b = true;
    }

    public final void f(Bundle bundle) {
        if (!this.f24626b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        }
        if (!(!this.f24628d)) {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
        this.f24627c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        this.f24628d = true;
    }

    public final void g(Bundle outBundle) {
        AbstractC2304t.f(outBundle, "outBundle");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f24627c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        C2616b.d dVarE = this.f24625a.e();
        AbstractC2304t.e(dVarE, "this.components.iteratorWithAdditions()");
        while (dVarE.hasNext()) {
            Map.Entry entry = (Map.Entry) dVarE.next();
            bundle.putBundle((String) entry.getKey(), ((c) entry.getValue()).a());
        }
        if (bundle.isEmpty()) {
            return;
        }
        outBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle);
    }

    public final void h(String key, c provider) {
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(provider, "provider");
        if (((c) this.f24625a.n(key, provider)) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    public final void i(Class clazz) {
        AbstractC2304t.f(clazz, "clazz");
        if (!this.f24630f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
        C2999b.C0437b c0437b = this.f24629e;
        if (c0437b == null) {
            c0437b = new C2999b.C0437b(this);
        }
        this.f24629e = c0437b;
        try {
            clazz.getDeclaredConstructor(null);
            C2999b.C0437b c0437b2 = this.f24629e;
            if (c0437b2 != null) {
                String name = clazz.getName();
                AbstractC2304t.e(name, "clazz.name");
                c0437b2.b(name);
            }
        } catch (NoSuchMethodException e8) {
            throw new IllegalArgumentException("Class " + clazz.getSimpleName() + " must have default constructor in order to be automatically recreated", e8);
        }
    }
}
