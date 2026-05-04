package zd;

import df.d;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f25785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f25786b;

        /* JADX INFO: renamed from: zd.n$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0489a implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return fd.a.a(((Method) obj).getName(), ((Method) obj2).getName());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class jClass) {
            super(null);
            kotlin.jvm.internal.t.f(jClass, "jClass");
            this.f25785a = jClass;
            Method[] declaredMethods = jClass.getDeclaredMethods();
            kotlin.jvm.internal.t.e(declaredMethods, "getDeclaredMethods(...)");
            this.f25786b = dd.n.q0(declaredMethods, new C0489a());
        }

        public static final CharSequence c(Method method) {
            Class<?> returnType = method.getReturnType();
            kotlin.jvm.internal.t.e(returnType, "getReturnType(...)");
            return le.f.f(returnType);
        }

        @Override // zd.n
        public String a() {
            return dd.a0.i0(this.f25786b, "", "<init>(", ")V", 0, null, m.f25781a, 24, null);
        }

        public final List d() {
            return this.f25786b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Constructor f25787a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Constructor constructor) {
            super(null);
            kotlin.jvm.internal.t.f(constructor, "constructor");
            this.f25787a = constructor;
        }

        public static final CharSequence c(Class cls) {
            kotlin.jvm.internal.t.c(cls);
            return le.f.f(cls);
        }

        @Override // zd.n
        public String a() {
            Class<?>[] parameterTypes = this.f25787a.getParameterTypes();
            kotlin.jvm.internal.t.e(parameterTypes, "getParameterTypes(...)");
            return dd.n.i0(parameterTypes, "", "<init>(", ")V", 0, null, o.f25797a, 24, null);
        }

        public final Constructor d() {
            return this.f25787a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f25788a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Method method) {
            super(null);
            kotlin.jvm.internal.t.f(method, "method");
            this.f25788a = method;
        }

        @Override // zd.n
        public String a() {
            return g3.d(this.f25788a);
        }

        public final Method b() {
            return this.f25788a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d.b f25789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f25790b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(d.b signature) {
            super(null);
            kotlin.jvm.internal.t.f(signature, "signature");
            this.f25789a = signature;
            this.f25790b = signature.a();
        }

        @Override // zd.n
        public String a() {
            return this.f25790b;
        }

        public final String b() {
            return this.f25789a.d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e extends n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d.b f25791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f25792b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(d.b signature) {
            super(null);
            kotlin.jvm.internal.t.f(signature, "signature");
            this.f25791a = signature;
            this.f25792b = signature.a();
        }

        @Override // zd.n
        public String a() {
            return this.f25792b;
        }

        public final String b() {
            return this.f25791a.d();
        }

        public final String c() {
            return this.f25791a.e();
        }
    }

    public /* synthetic */ n(kotlin.jvm.internal.k kVar) {
        this();
    }

    public abstract String a();

    public n() {
    }
}
