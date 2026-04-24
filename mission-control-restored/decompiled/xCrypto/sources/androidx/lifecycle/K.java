package androidx.lifecycle;

import android.app.Application;
import c0.AbstractC0870a;
import c0.C0871b;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes.dex */
public class K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final M f7646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f7647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC0870a f7648c;

    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7654a = a.f7655a;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f7655a = new a();
        }

        default J a(Class modelClass) {
            kotlin.jvm.internal.r.f(modelClass, "modelClass");
            throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
        }

        default J b(Class modelClass, AbstractC0870a extras) {
            kotlin.jvm.internal.r.f(modelClass, "modelClass");
            kotlin.jvm.internal.r.f(extras, "extras");
            return a(modelClass);
        }
    }

    public static class c implements b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static c f7657c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f7656b = new a(null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AbstractC0870a.b f7658d = a.C0108a.f7659a;

        public static final class a {

            /* JADX INFO: renamed from: androidx.lifecycle.K$c$a$a, reason: collision with other inner class name */
            public static final class C0108a implements AbstractC0870a.b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final C0108a f7659a = new C0108a();
            }

            public /* synthetic */ a(AbstractC1585j abstractC1585j) {
                this();
            }

            public final c a() {
                if (c.f7657c == null) {
                    c.f7657c = new c();
                }
                c cVar = c.f7657c;
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
                Object objNewInstance = modelClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                kotlin.jvm.internal.r.e(objNewInstance, "{\n                modelC…wInstance()\n            }");
                return (J) objNewInstance;
            } catch (IllegalAccessException e4) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e4);
            } catch (InstantiationException e5) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e5);
            } catch (NoSuchMethodException e6) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e6);
            }
        }
    }

    public static class d {
        public abstract void c(J j4);
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
        J jB = this.f7646a.b(key);
        if (!modelClass.isInstance(jB)) {
            C0871b c0871b = new C0871b(this.f7648c);
            c0871b.c(c.f7658d, key);
            try {
                jA = this.f7647b.b(modelClass, c0871b);
            } catch (AbstractMethodError unused) {
                jA = this.f7647b.a(modelClass);
            }
            this.f7646a.d(key, jA);
            return jA;
        }
        Object obj = this.f7647b;
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
        public static a f7650g;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Application f7652e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0106a f7649f = new C0106a(null);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final AbstractC0870a.b f7651h = C0106a.C0107a.f7653a;

        /* JADX INFO: renamed from: androidx.lifecycle.K$a$a, reason: collision with other inner class name */
        public static final class C0106a {

            /* JADX INFO: renamed from: androidx.lifecycle.K$a$a$a, reason: collision with other inner class name */
            public static final class C0107a implements AbstractC0870a.b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final C0107a f7653a = new C0107a();
            }

            public /* synthetic */ C0106a(AbstractC1585j abstractC1585j) {
                this();
            }

            public final a a(Application application) {
                kotlin.jvm.internal.r.f(application, "application");
                if (a.f7650g == null) {
                    a.f7650g = new a(application);
                }
                a aVar = a.f7650g;
                kotlin.jvm.internal.r.c(aVar);
                return aVar;
            }

            public C0106a() {
            }
        }

        public a(Application application, int i4) {
            this.f7652e = application;
        }

        @Override // androidx.lifecycle.K.c, androidx.lifecycle.K.b
        public J a(Class modelClass) {
            kotlin.jvm.internal.r.f(modelClass, "modelClass");
            Application application = this.f7652e;
            if (application != null) {
                return g(modelClass, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @Override // androidx.lifecycle.K.b
        public J b(Class modelClass, AbstractC0870a extras) {
            kotlin.jvm.internal.r.f(modelClass, "modelClass");
            kotlin.jvm.internal.r.f(extras, "extras");
            if (this.f7652e != null) {
                return a(modelClass);
            }
            Application application = (Application) extras.a(f7651h);
            if (application != null) {
                return g(modelClass, application);
            }
            if (AbstractC0838a.class.isAssignableFrom(modelClass)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return super.a(modelClass);
        }

        public final J g(Class cls, Application application) {
            if (!AbstractC0838a.class.isAssignableFrom(cls)) {
                return super.a(cls);
            }
            try {
                J j4 = (J) cls.getConstructor(Application.class).newInstance(application);
                kotlin.jvm.internal.r.e(j4, "{\n                try {\n…          }\n            }");
                return j4;
            } catch (IllegalAccessException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            } catch (InstantiationException e5) {
                throw new RuntimeException("Cannot create an instance of " + cls, e5);
            } catch (NoSuchMethodException e6) {
                throw new RuntimeException("Cannot create an instance of " + cls, e6);
            } catch (InvocationTargetException e7) {
                throw new RuntimeException("Cannot create an instance of " + cls, e7);
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

    public K(M store, b factory, AbstractC0870a defaultCreationExtras) {
        kotlin.jvm.internal.r.f(store, "store");
        kotlin.jvm.internal.r.f(factory, "factory");
        kotlin.jvm.internal.r.f(defaultCreationExtras, "defaultCreationExtras");
        this.f7646a = store;
        this.f7647b = factory;
        this.f7648c = defaultCreationExtras;
    }

    public /* synthetic */ K(M m4, b bVar, AbstractC0870a abstractC0870a, int i4, AbstractC1585j abstractC1585j) {
        this(m4, bVar, (i4 & 4) != 0 ? AbstractC0870a.C0128a.f8302b : abstractC0870a);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public K(N owner, b factory) {
        this(owner.getViewModelStore(), factory, L.a(owner));
        kotlin.jvm.internal.r.f(owner, "owner");
        kotlin.jvm.internal.r.f(factory, "factory");
    }
}
