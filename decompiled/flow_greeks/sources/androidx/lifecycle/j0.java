package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;
import y1.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0 f2432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f2433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y1.a f2434c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2440a = a.f2441a;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f2441a = new a();
        }

        default i0 a(Class modelClass) {
            kotlin.jvm.internal.t.f(modelClass, "modelClass");
            throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
        }

        default i0 b(Class modelClass, y1.a extras) {
            kotlin.jvm.internal.t.f(modelClass, "modelClass");
            kotlin.jvm.internal.t.f(extras, "extras");
            return a(modelClass);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c implements b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static c f2443c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f2442b = new a(null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a.b f2444d = a.C0035a.f2445a;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a {

            /* JADX INFO: renamed from: androidx.lifecycle.j0$c$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public static final class C0035a implements a.b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final C0035a f2445a = new C0035a();
            }

            public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
                this();
            }

            public final c a() {
                if (c.f2443c == null) {
                    c.f2443c = new c();
                }
                c cVar = c.f2443c;
                kotlin.jvm.internal.t.c(cVar);
                return cVar;
            }

            public a() {
            }
        }

        @Override // androidx.lifecycle.j0.b
        public i0 a(Class modelClass) throws InvocationTargetException {
            kotlin.jvm.internal.t.f(modelClass, "modelClass");
            try {
                Object objNewInstance = modelClass.getDeclaredConstructor(null).newInstance(null);
                kotlin.jvm.internal.t.e(objNewInstance, "{\n                modelC…wInstance()\n            }");
                return (i0) objNewInstance;
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e11);
            } catch (NoSuchMethodException e12) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e12);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d {
        public abstract void c(i0 i0Var);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j0(l0 store, b factory) {
        this(store, factory, null, 4, null);
        kotlin.jvm.internal.t.f(store, "store");
        kotlin.jvm.internal.t.f(factory, "factory");
    }

    public i0 a(Class modelClass) {
        kotlin.jvm.internal.t.f(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, modelClass);
    }

    public i0 b(String key, Class modelClass) {
        i0 i0VarA;
        kotlin.jvm.internal.t.f(key, "key");
        kotlin.jvm.internal.t.f(modelClass, "modelClass");
        i0 i0VarB = this.f2432a.b(key);
        if (!modelClass.isInstance(i0VarB)) {
            y1.b bVar = new y1.b(this.f2434c);
            bVar.c(c.f2444d, key);
            try {
                i0VarA = this.f2433b.b(modelClass, bVar);
            } catch (AbstractMethodError unused) {
                i0VarA = this.f2433b.a(modelClass);
            }
            this.f2432a.d(key, i0VarA);
            return i0VarA;
        }
        Object obj = this.f2433b;
        d dVar = obj instanceof d ? (d) obj : null;
        if (dVar != null) {
            kotlin.jvm.internal.t.c(i0VarB);
            dVar.c(i0VarB);
        }
        kotlin.jvm.internal.t.d(i0VarB, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        return i0VarB;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends c {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static a f2436g;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Application f2438e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0033a f2435f = new C0033a(null);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a.b f2437h = C0033a.C0034a.f2439a;

        /* JADX INFO: renamed from: androidx.lifecycle.j0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0033a {

            /* JADX INFO: renamed from: androidx.lifecycle.j0$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public static final class C0034a implements a.b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final C0034a f2439a = new C0034a();
            }

            public /* synthetic */ C0033a(kotlin.jvm.internal.k kVar) {
                this();
            }

            public final a a(Application application) {
                kotlin.jvm.internal.t.f(application, "application");
                if (a.f2436g == null) {
                    a.f2436g = new a(application);
                }
                a aVar = a.f2436g;
                kotlin.jvm.internal.t.c(aVar);
                return aVar;
            }

            public C0033a() {
            }
        }

        public a(Application application, int i10) {
            this.f2438e = application;
        }

        @Override // androidx.lifecycle.j0.c, androidx.lifecycle.j0.b
        public i0 a(Class modelClass) {
            kotlin.jvm.internal.t.f(modelClass, "modelClass");
            Application application = this.f2438e;
            if (application != null) {
                return g(modelClass, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @Override // androidx.lifecycle.j0.b
        public i0 b(Class modelClass, y1.a extras) {
            kotlin.jvm.internal.t.f(modelClass, "modelClass");
            kotlin.jvm.internal.t.f(extras, "extras");
            if (this.f2438e != null) {
                return a(modelClass);
            }
            Application application = (Application) extras.a(f2437h);
            if (application != null) {
                return g(modelClass, application);
            }
            if (androidx.lifecycle.a.class.isAssignableFrom(modelClass)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return super.a(modelClass);
        }

        public final i0 g(Class cls, Application application) {
            if (!androidx.lifecycle.a.class.isAssignableFrom(cls)) {
                return super.a(cls);
            }
            try {
                i0 i0Var = (i0) cls.getConstructor(Application.class).newInstance(application);
                kotlin.jvm.internal.t.e(i0Var, "{\n                try {\n…          }\n            }");
                return i0Var;
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("Cannot create an instance of " + cls, e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("Cannot create an instance of " + cls, e11);
            } catch (NoSuchMethodException e12) {
                throw new RuntimeException("Cannot create an instance of " + cls, e12);
            } catch (InvocationTargetException e13) {
                throw new RuntimeException("Cannot create an instance of " + cls, e13);
            }
        }

        public a() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Application application) {
            this(application, 0);
            kotlin.jvm.internal.t.f(application, "application");
        }
    }

    public j0(l0 store, b factory, y1.a defaultCreationExtras) {
        kotlin.jvm.internal.t.f(store, "store");
        kotlin.jvm.internal.t.f(factory, "factory");
        kotlin.jvm.internal.t.f(defaultCreationExtras, "defaultCreationExtras");
        this.f2432a = store;
        this.f2433b = factory;
        this.f2434c = defaultCreationExtras;
    }

    public /* synthetic */ j0(l0 l0Var, b bVar, y1.a aVar, int i10, kotlin.jvm.internal.k kVar) {
        this(l0Var, bVar, (i10 & 4) != 0 ? a.C0467a.f25165b : aVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j0(m0 owner, b factory) {
        this(owner.getViewModelStore(), factory, k0.a(owner));
        kotlin.jvm.internal.t.f(owner, "owner");
        kotlin.jvm.internal.t.f(factory, "factory");
    }
}
