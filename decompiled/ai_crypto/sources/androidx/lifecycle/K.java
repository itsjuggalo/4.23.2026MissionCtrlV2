package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.AbstractC2148j;
import s0.AbstractC2640a;

/* JADX INFO: loaded from: classes.dex */
public class K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final M f7744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f7745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC2640a f7746c;

    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7752a = a.f7753a;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f7753a = new a();
        }

        default J a(Class modelClass) {
            kotlin.jvm.internal.r.f(modelClass, "modelClass");
            throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
        }

        default J b(Class modelClass, AbstractC2640a extras) {
            kotlin.jvm.internal.r.f(modelClass, "modelClass");
            kotlin.jvm.internal.r.f(extras, "extras");
            return a(modelClass);
        }
    }

    public static class c implements b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static c f7755c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f7754b = new a(null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AbstractC2640a.b f7756d = a.C0130a.f7757a;

        public static final class a {

            /* JADX INFO: renamed from: androidx.lifecycle.K$c$a$a, reason: collision with other inner class name */
            public static final class C0130a implements AbstractC2640a.b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final C0130a f7757a = new C0130a();
            }

            public /* synthetic */ a(AbstractC2148j abstractC2148j) {
                this();
            }

            public final c a() {
                if (c.f7755c == null) {
                    c.f7755c = new c();
                }
                c cVar = c.f7755c;
                kotlin.jvm.internal.r.c(cVar);
                return cVar;
            }

            public a() {
            }
        }

        @Override // androidx.lifecycle.K.b
        public J a(Class modelClass) throws InvocationTargetException {
            kotlin.jvm.internal.r.f(modelClass, "modelClass");
            try {
                Object objNewInstance = modelClass.getDeclaredConstructor(null).newInstance(null);
                kotlin.jvm.internal.r.e(objNewInstance, "{\n                modelC…wInstance()\n            }");
                return (J) objNewInstance;
            } catch (IllegalAccessException e7) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e7);
            } catch (InstantiationException e8) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e8);
            } catch (NoSuchMethodException e9) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e9);
            }
        }
    }

    public static class d {
        public abstract void c(J j7);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public K(M store, b factory) {
        this(store, factory, null, 4, null);
        kotlin.jvm.internal.r.f(store, "store");
        kotlin.jvm.internal.r.f(factory, "factory");
    }

    public J a(Class modelClass) {
        kotlin.jvm.internal.r.f(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, modelClass);
    }

    public J b(String key, Class modelClass) {
        J jA;
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(modelClass, "modelClass");
        J jB = this.f7744a.b(key);
        if (!modelClass.isInstance(jB)) {
            s0.b bVar = new s0.b(this.f7746c);
            bVar.c(c.f7756d, key);
            try {
                jA = this.f7745b.b(modelClass, bVar);
            } catch (AbstractMethodError unused) {
                jA = this.f7745b.a(modelClass);
            }
            this.f7744a.d(key, jA);
            return jA;
        }
        Object obj = this.f7745b;
        d dVar = obj instanceof d ? (d) obj : null;
        if (dVar != null) {
            kotlin.jvm.internal.r.c(jB);
            dVar.c(jB);
        }
        kotlin.jvm.internal.r.d(jB, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        return jB;
    }

    public static class a extends c {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static a f7748g;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Application f7750e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0128a f7747f = new C0128a(null);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final AbstractC2640a.b f7749h = C0128a.C0129a.f7751a;

        /* JADX INFO: renamed from: androidx.lifecycle.K$a$a, reason: collision with other inner class name */
        public static final class C0128a {

            /* JADX INFO: renamed from: androidx.lifecycle.K$a$a$a, reason: collision with other inner class name */
            public static final class C0129a implements AbstractC2640a.b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final C0129a f7751a = new C0129a();
            }

            public /* synthetic */ C0128a(AbstractC2148j abstractC2148j) {
                this();
            }

            public final a a(Application application) {
                kotlin.jvm.internal.r.f(application, "application");
                if (a.f7748g == null) {
                    a.f7748g = new a(application);
                }
                a aVar = a.f7748g;
                kotlin.jvm.internal.r.c(aVar);
                return aVar;
            }

            public C0128a() {
            }
        }

        public a(Application application, int i7) {
            this.f7750e = application;
        }

        @Override // androidx.lifecycle.K.c, androidx.lifecycle.K.b
        public J a(Class modelClass) {
            kotlin.jvm.internal.r.f(modelClass, "modelClass");
            Application application = this.f7750e;
            if (application != null) {
                return g(modelClass, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @Override // androidx.lifecycle.K.b
        public J b(Class modelClass, AbstractC2640a extras) {
            kotlin.jvm.internal.r.f(modelClass, "modelClass");
            kotlin.jvm.internal.r.f(extras, "extras");
            if (this.f7750e != null) {
                return a(modelClass);
            }
            Application application = (Application) extras.a(f7749h);
            if (application != null) {
                return g(modelClass, application);
            }
            if (AbstractC0955a.class.isAssignableFrom(modelClass)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return super.a(modelClass);
        }

        public final J g(Class cls, Application application) {
            if (!AbstractC0955a.class.isAssignableFrom(cls)) {
                return super.a(cls);
            }
            try {
                J j7 = (J) cls.getConstructor(Application.class).newInstance(application);
                kotlin.jvm.internal.r.e(j7, "{\n                try {\n…          }\n            }");
                return j7;
            } catch (IllegalAccessException e7) {
                throw new RuntimeException("Cannot create an instance of " + cls, e7);
            } catch (InstantiationException e8) {
                throw new RuntimeException("Cannot create an instance of " + cls, e8);
            } catch (NoSuchMethodException e9) {
                throw new RuntimeException("Cannot create an instance of " + cls, e9);
            } catch (InvocationTargetException e10) {
                throw new RuntimeException("Cannot create an instance of " + cls, e10);
            }
        }

        public a() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Application application) {
            this(application, 0);
            kotlin.jvm.internal.r.f(application, "application");
        }
    }

    public K(M store, b factory, AbstractC2640a defaultCreationExtras) {
        kotlin.jvm.internal.r.f(store, "store");
        kotlin.jvm.internal.r.f(factory, "factory");
        kotlin.jvm.internal.r.f(defaultCreationExtras, "defaultCreationExtras");
        this.f7744a = store;
        this.f7745b = factory;
        this.f7746c = defaultCreationExtras;
    }

    public /* synthetic */ K(M m7, b bVar, AbstractC2640a abstractC2640a, int i7, AbstractC2148j abstractC2148j) {
        this(m7, bVar, (i7 & 4) != 0 ? AbstractC2640a.C0354a.f22964b : abstractC2640a);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public K(N owner, b factory) {
        this(owner.f(), factory, L.a(owner));
        kotlin.jvm.internal.r.f(owner, "owner");
        kotlin.jvm.internal.r.f(factory, "factory");
    }
}
