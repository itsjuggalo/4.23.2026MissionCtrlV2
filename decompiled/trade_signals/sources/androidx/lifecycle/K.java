package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p0.AbstractC2539a;
import p0.C2540b;

/* JADX INFO: loaded from: classes.dex */
public class K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final M f11942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f11943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC2539a f11944c;

    public static class a extends c {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static a f11946g;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Application f11948e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0189a f11945f = new C0189a(null);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final AbstractC2539a.b f11947h = C0189a.C0190a.f11949a;

        /* JADX INFO: renamed from: androidx.lifecycle.K$a$a, reason: collision with other inner class name */
        public static final class C0189a {

            /* JADX INFO: renamed from: androidx.lifecycle.K$a$a$a, reason: collision with other inner class name */
            public static final class C0190a implements AbstractC2539a.b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final C0190a f11949a = new C0190a();
            }

            public C0189a() {
            }

            public final a a(Application application) {
                AbstractC2304t.f(application, "application");
                if (a.f11946g == null) {
                    a.f11946g = new a(application);
                }
                a aVar = a.f11946g;
                AbstractC2304t.c(aVar);
                return aVar;
            }

            public /* synthetic */ C0189a(AbstractC2296k abstractC2296k) {
                this();
            }
        }

        public a() {
            this(null, 0);
        }

        @Override // androidx.lifecycle.K.c, androidx.lifecycle.K.b
        public J a(Class modelClass) {
            AbstractC2304t.f(modelClass, "modelClass");
            Application application = this.f11948e;
            if (application != null) {
                return g(modelClass, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @Override // androidx.lifecycle.K.b
        public J b(Class modelClass, AbstractC2539a extras) {
            AbstractC2304t.f(modelClass, "modelClass");
            AbstractC2304t.f(extras, "extras");
            if (this.f11948e != null) {
                return a(modelClass);
            }
            Application application = (Application) extras.a(f11947h);
            if (application != null) {
                return g(modelClass, application);
            }
            if (AbstractC1149a.class.isAssignableFrom(modelClass)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return super.a(modelClass);
        }

        public final J g(Class cls, Application application) {
            if (!AbstractC1149a.class.isAssignableFrom(cls)) {
                return super.a(cls);
            }
            try {
                J j8 = (J) cls.getConstructor(Application.class).newInstance(application);
                AbstractC2304t.e(j8, "{\n                try {\n…          }\n            }");
                return j8;
            } catch (IllegalAccessException e8) {
                throw new RuntimeException("Cannot create an instance of " + cls, e8);
            } catch (InstantiationException e9) {
                throw new RuntimeException("Cannot create an instance of " + cls, e9);
            } catch (NoSuchMethodException e10) {
                throw new RuntimeException("Cannot create an instance of " + cls, e10);
            } catch (InvocationTargetException e11) {
                throw new RuntimeException("Cannot create an instance of " + cls, e11);
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Application application) {
            this(application, 0);
            AbstractC2304t.f(application, "application");
        }

        public a(Application application, int i8) {
            this.f11948e = application;
        }
    }

    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11950a = a.f11951a;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f11951a = new a();
        }

        default J a(Class modelClass) {
            AbstractC2304t.f(modelClass, "modelClass");
            throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
        }

        default J b(Class modelClass, AbstractC2539a extras) {
            AbstractC2304t.f(modelClass, "modelClass");
            AbstractC2304t.f(extras, "extras");
            return a(modelClass);
        }
    }

    public static class c implements b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static c f11953c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f11952b = new a(null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AbstractC2539a.b f11954d = a.C0191a.f11955a;

        public static final class a {

            /* JADX INFO: renamed from: androidx.lifecycle.K$c$a$a, reason: collision with other inner class name */
            public static final class C0191a implements AbstractC2539a.b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final C0191a f11955a = new C0191a();
            }

            public a() {
            }

            public final c a() {
                if (c.f11953c == null) {
                    c.f11953c = new c();
                }
                c cVar = c.f11953c;
                AbstractC2304t.c(cVar);
                return cVar;
            }

            public /* synthetic */ a(AbstractC2296k abstractC2296k) {
                this();
            }
        }

        @Override // androidx.lifecycle.K.b
        public J a(Class modelClass) throws InvocationTargetException {
            AbstractC2304t.f(modelClass, "modelClass");
            try {
                Object objNewInstance = modelClass.getDeclaredConstructor(null).newInstance(null);
                AbstractC2304t.e(objNewInstance, "{\n                modelC…wInstance()\n            }");
                return (J) objNewInstance;
            } catch (IllegalAccessException e8) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e8);
            } catch (InstantiationException e9) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e9);
            } catch (NoSuchMethodException e10) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e10);
            }
        }
    }

    public static class d {
        public abstract void c(J j8);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public K(M store, b factory) {
        this(store, factory, null, 4, null);
        AbstractC2304t.f(store, "store");
        AbstractC2304t.f(factory, "factory");
    }

    public J a(Class modelClass) {
        AbstractC2304t.f(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, modelClass);
    }

    public J b(String key, Class modelClass) {
        J jA;
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(modelClass, "modelClass");
        J jB = this.f11942a.b(key);
        if (!modelClass.isInstance(jB)) {
            C2540b c2540b = new C2540b(this.f11944c);
            c2540b.c(c.f11954d, key);
            try {
                jA = this.f11943b.b(modelClass, c2540b);
            } catch (AbstractMethodError unused) {
                jA = this.f11943b.a(modelClass);
            }
            this.f11942a.d(key, jA);
            return jA;
        }
        Object obj = this.f11943b;
        d dVar = obj instanceof d ? (d) obj : null;
        if (dVar != null) {
            AbstractC2304t.c(jB);
            dVar.c(jB);
        }
        AbstractC2304t.d(jB, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        return jB;
    }

    public K(M store, b factory, AbstractC2539a defaultCreationExtras) {
        AbstractC2304t.f(store, "store");
        AbstractC2304t.f(factory, "factory");
        AbstractC2304t.f(defaultCreationExtras, "defaultCreationExtras");
        this.f11942a = store;
        this.f11943b = factory;
        this.f11944c = defaultCreationExtras;
    }

    public /* synthetic */ K(M m8, b bVar, AbstractC2539a abstractC2539a, int i8, AbstractC2296k abstractC2296k) {
        this(m8, bVar, (i8 & 4) != 0 ? AbstractC2539a.C0373a.f22251b : abstractC2539a);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public K(N owner, b factory) {
        this(owner.getViewModelStore(), factory, L.a(owner));
        AbstractC2304t.f(owner, "owner");
        AbstractC2304t.f(factory, "factory");
    }
}
