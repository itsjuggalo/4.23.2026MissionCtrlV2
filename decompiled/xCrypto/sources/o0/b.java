package o0;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0846i;
import androidx.lifecycle.InterfaceC0848k;
import androidx.lifecycle.InterfaceC0850m;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import o0.d;

/* JADX INFO: loaded from: classes.dex */
public final class b implements InterfaceC0848k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f13898b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f13899a;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: o0.b$b, reason: collision with other inner class name */
    public static final class C0219b implements d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set f13900a;

        public C0219b(d registry) {
            r.f(registry, "registry");
            this.f13900a = new LinkedHashSet();
            registry.h("androidx.savedstate.Restarter", this);
        }

        @Override // o0.d.c
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f13900a));
            return bundle;
        }

        public final void b(String className) {
            r.f(className, "className");
            this.f13900a.add(className);
        }
    }

    public b(f owner) {
        r.f(owner, "owner");
        this.f13899a = owner;
    }

    @Override // androidx.lifecycle.InterfaceC0848k
    public void a(InterfaceC0850m source, AbstractC0846i.a event) {
        r.f(source, "source");
        r.f(event, "event");
        if (event != AbstractC0846i.a.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        source.getLifecycle().c(this);
        Bundle bundleB = this.f13899a.getSavedStateRegistry().b("androidx.savedstate.Restarter");
        if (bundleB == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleB.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    public final void b(String str) {
        try {
            Class<? extends U> clsAsSubclass = Class.forName(str, false, b.class.getClassLoader()).asSubclass(d.a.class);
            r.e(clsAsSubclass, "{\n                Class.…class.java)\n            }");
            try {
                Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    Object objNewInstance = declaredConstructor.newInstance(new Object[0]);
                    r.e(objNewInstance, "{\n                constr…wInstance()\n            }");
                    ((d.a) objNewInstance).a(this.f13899a);
                } catch (Exception e4) {
                    throw new RuntimeException("Failed to instantiate " + str, e4);
                }
            } catch (NoSuchMethodException e5) {
                throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e5);
            }
        } catch (ClassNotFoundException e6) {
            throw new RuntimeException("Class " + str + " wasn't found", e6);
        }
    }
}
