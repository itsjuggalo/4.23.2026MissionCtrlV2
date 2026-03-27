package z0;

import android.os.Bundle;
import androidx.lifecycle.AbstractC1157i;
import androidx.lifecycle.InterfaceC1159k;
import androidx.lifecycle.InterfaceC1161m;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import z0.d;

/* JADX INFO: renamed from: z0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2999b implements InterfaceC1159k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f24620b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f24621a;

    /* JADX INFO: renamed from: z0.b$a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    /* JADX INFO: renamed from: z0.b$b, reason: collision with other inner class name */
    public static final class C0437b implements d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set f24622a;

        public C0437b(d registry) {
            AbstractC2304t.f(registry, "registry");
            this.f24622a = new LinkedHashSet();
            registry.h("androidx.savedstate.Restarter", this);
        }

        @Override // z0.d.c
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f24622a));
            return bundle;
        }

        public final void b(String className) {
            AbstractC2304t.f(className, "className");
            this.f24622a.add(className);
        }
    }

    public C2999b(f owner) {
        AbstractC2304t.f(owner, "owner");
        this.f24621a = owner;
    }

    public final void a(String str) {
        try {
            Class<? extends U> clsAsSubclass = Class.forName(str, false, C2999b.class.getClassLoader()).asSubclass(d.a.class);
            AbstractC2304t.e(clsAsSubclass, "{\n                Class.…class.java)\n            }");
            try {
                Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                try {
                    Object objNewInstance = declaredConstructor.newInstance(null);
                    AbstractC2304t.e(objNewInstance, "{\n                constr…wInstance()\n            }");
                    ((d.a) objNewInstance).a(this.f24621a);
                } catch (Exception e8) {
                    throw new RuntimeException("Failed to instantiate " + str, e8);
                }
            } catch (NoSuchMethodException e9) {
                throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e9);
            }
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException("Class " + str + " wasn't found", e10);
        }
    }

    @Override // androidx.lifecycle.InterfaceC1159k
    public void b(InterfaceC1161m source, AbstractC1157i.a event) {
        AbstractC2304t.f(source, "source");
        AbstractC2304t.f(event, "event");
        if (event != AbstractC1157i.a.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        source.getLifecycle().c(this);
        Bundle bundleB = this.f24621a.getSavedStateRegistry().b("androidx.savedstate.Restarter");
        if (bundleB == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleB.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }
}
