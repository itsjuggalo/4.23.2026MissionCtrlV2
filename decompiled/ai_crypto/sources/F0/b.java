package F0;

import F0.d;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0963i;
import androidx.lifecycle.InterfaceC0965k;
import androidx.lifecycle.InterfaceC0967m;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class b implements InterfaceC0965k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f1877b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f1878a;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: F0.b$b, reason: collision with other inner class name */
    public static final class C0015b implements d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set f1879a;

        public C0015b(d registry) {
            r.f(registry, "registry");
            this.f1879a = new LinkedHashSet();
            registry.h("androidx.savedstate.Restarter", this);
        }

        @Override // F0.d.c
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f1879a));
            return bundle;
        }

        public final void b(String className) {
            r.f(className, "className");
            this.f1879a.add(className);
        }
    }

    public b(f owner) {
        r.f(owner, "owner");
        this.f1878a = owner;
    }

    @Override // androidx.lifecycle.InterfaceC0965k
    public void a(InterfaceC0967m source, AbstractC0963i.a event) {
        r.f(source, "source");
        r.f(event, "event");
        if (event != AbstractC0963i.a.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        source.a().c(this);
        Bundle bundleB = this.f1878a.v().b("androidx.savedstate.Restarter");
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
                Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                try {
                    Object objNewInstance = declaredConstructor.newInstance(null);
                    r.e(objNewInstance, "{\n                constr…wInstance()\n            }");
                    ((d.a) objNewInstance).a(this.f1878a);
                } catch (Exception e7) {
                    throw new RuntimeException("Failed to instantiate " + str, e7);
                }
            } catch (NoSuchMethodException e8) {
                throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e8);
            }
        } catch (ClassNotFoundException e9) {
            throw new RuntimeException("Class " + str + " wasn't found", e9);
        }
    }
}
