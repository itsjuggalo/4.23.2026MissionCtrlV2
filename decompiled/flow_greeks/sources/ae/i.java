package ae;

import ae.h;
import cd.h0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.r0;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i implements ae.h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f774e = new d(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Member f775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class f777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f778d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends i implements ae.g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Object f779f;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(Constructor constructor, Object obj) {
            t.f(constructor, "constructor");
            Class declaringClass = constructor.getDeclaringClass();
            t.e(declaringClass, "getDeclaringClass(...)");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            t.e(genericParameterTypes, "getGenericParameterTypes(...)");
            super(constructor, declaringClass, null, (Type[]) (genericParameterTypes.length <= 2 ? new Type[0] : dd.l.m(genericParameterTypes, 1, genericParameterTypes.length - 1)), null);
            this.f779f = obj;
        }

        @Override // ae.h
        public Object call(Object[] args) {
            t.f(args, "args");
            d(args);
            Constructor constructor = (Constructor) b();
            r0 r0Var = new r0(3);
            r0Var.a(this.f779f);
            r0Var.b(args);
            r0Var.a(null);
            return constructor.newInstance(r0Var.d(new Object[r0Var.c()]));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends i {
        /* JADX WARN: Illegal instructions before constructor call */
        public b(Constructor constructor) {
            t.f(constructor, "constructor");
            Class declaringClass = constructor.getDeclaringClass();
            t.e(declaringClass, "getDeclaringClass(...)");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            t.e(genericParameterTypes, "getGenericParameterTypes(...)");
            super(constructor, declaringClass, null, (Type[]) (genericParameterTypes.length <= 1 ? new Type[0] : dd.l.m(genericParameterTypes, 0, genericParameterTypes.length - 1)), null);
        }

        @Override // ae.h
        public Object call(Object[] args) {
            t.f(args, "args");
            d(args);
            Constructor constructor = (Constructor) b();
            r0 r0Var = new r0(2);
            r0Var.b(args);
            r0Var.a(null);
            return constructor.newInstance(r0Var.d(new Object[r0Var.c()]));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends i implements ae.g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Object f780f;

        /* JADX WARN: Illegal instructions before constructor call */
        public c(Constructor constructor, Object obj) {
            t.f(constructor, "constructor");
            Class declaringClass = constructor.getDeclaringClass();
            t.e(declaringClass, "getDeclaringClass(...)");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            t.e(genericParameterTypes, "getGenericParameterTypes(...)");
            super(constructor, declaringClass, null, genericParameterTypes, null);
            this.f780f = obj;
        }

        @Override // ae.h
        public Object call(Object[] args) {
            t.f(args, "args");
            d(args);
            Constructor constructor = (Constructor) b();
            r0 r0Var = new r0(2);
            r0Var.a(this.f780f);
            r0Var.b(args);
            return constructor.newInstance(r0Var.d(new Object[r0Var.c()]));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d {
        public /* synthetic */ d(kotlin.jvm.internal.k kVar) {
            this();
        }

        public d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e extends i {
        /* JADX WARN: Illegal instructions before constructor call */
        public e(Constructor constructor) {
            t.f(constructor, "constructor");
            Class declaringClass = constructor.getDeclaringClass();
            t.e(declaringClass, "getDeclaringClass(...)");
            Class declaringClass2 = constructor.getDeclaringClass();
            Class<?> declaringClass3 = declaringClass2.getDeclaringClass();
            Class<?> cls = (declaringClass3 == null || Modifier.isStatic(declaringClass2.getModifiers())) ? null : declaringClass3;
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            t.e(genericParameterTypes, "getGenericParameterTypes(...)");
            super(constructor, declaringClass, cls, genericParameterTypes, null);
        }

        @Override // ae.h
        public Object call(Object[] args) {
            t.f(args, "args");
            d(args);
            return ((Constructor) b()).newInstance(Arrays.copyOf(args, args.length));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class f extends i {

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends f implements ae.g {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final Object f781f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Field field, Object obj) {
                super(field, false, null);
                t.f(field, "field");
                this.f781f = obj;
            }

            @Override // ae.i.f, ae.h
            public Object call(Object[] args) {
                t.f(args, "args");
                d(args);
                return ((Field) b()).get(this.f781f);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class b extends f implements ae.g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Field field) {
                super(field, false, null);
                t.f(field, "field");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class c extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Field field) {
                super(field, true, null);
                t.f(field, "field");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class d extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Field field) {
                super(field, true, null);
                t.f(field, "field");
            }

            @Override // ae.i
            public void d(Object[] args) {
                t.f(args, "args");
                super.d(args);
                e(dd.n.D(args));
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class e extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(Field field) {
                super(field, false, null);
                t.f(field, "field");
            }
        }

        public /* synthetic */ f(Field field, boolean z10, kotlin.jvm.internal.k kVar) {
            this(field, z10);
        }

        @Override // ae.h
        public Object call(Object[] args) {
            t.f(args, "args");
            d(args);
            return ((Field) b()).get(f() != null ? dd.n.C(args) : null);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public f(Field field, boolean z10) {
            Type genericType = field.getGenericType();
            t.e(genericType, "getGenericType(...)");
            super(field, genericType, z10 ? field.getDeclaringClass() : null, new Type[0], null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class g extends i {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f782f;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends g implements ae.g {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final Object f783g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Field field, boolean z10, Object obj) {
                super(field, z10, false, null);
                t.f(field, "field");
                this.f783g = obj;
            }

            @Override // ae.i.g, ae.h
            public Object call(Object[] args) throws IllegalAccessException {
                t.f(args, "args");
                d(args);
                ((Field) b()).set(this.f783g, dd.n.C(args));
                return h0.f3852a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class b extends g implements ae.g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Field field, boolean z10) {
                super(field, z10, false, null);
                t.f(field, "field");
            }

            @Override // ae.i.g, ae.h
            public Object call(Object[] args) throws IllegalAccessException {
                t.f(args, "args");
                d(args);
                ((Field) b()).set(null, dd.n.k0(args));
                return h0.f3852a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class c extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Field field, boolean z10) {
                super(field, z10, true, null);
                t.f(field, "field");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class d extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Field field, boolean z10) {
                super(field, z10, true, null);
                t.f(field, "field");
            }

            @Override // ae.i.g, ae.i
            public void d(Object[] args) {
                t.f(args, "args");
                super.d(args);
                e(dd.n.D(args));
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class e extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(Field field, boolean z10) {
                super(field, z10, false, null);
                t.f(field, "field");
            }
        }

        public /* synthetic */ g(Field field, boolean z10, boolean z11, kotlin.jvm.internal.k kVar) {
            this(field, z10, z11);
        }

        @Override // ae.h
        public Object call(Object[] args) throws IllegalAccessException {
            t.f(args, "args");
            d(args);
            ((Field) b()).set(f() != null ? dd.n.C(args) : null, dd.n.k0(args));
            return h0.f3852a;
        }

        @Override // ae.i
        public void d(Object[] args) {
            t.f(args, "args");
            super.d(args);
            if (this.f782f && dd.n.k0(args) == null) {
                throw new IllegalArgumentException("null is not allowed as a value for this property.");
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public g(Field field, boolean z10, boolean z11) {
            Class TYPE = Void.TYPE;
            t.e(TYPE, "TYPE");
            super(field, TYPE, z11 ? field.getDeclaringClass() : null, new Type[]{field.getGenericType()}, null);
            this.f782f = z10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class h extends i {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f784f;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends h implements ae.g {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final Object f785g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Method method, Object obj) {
                super(method, false, null, 4, null);
                t.f(method, "method");
                this.f785g = obj;
            }

            @Override // ae.h
            public Object call(Object[] args) {
                t.f(args, "args");
                d(args);
                return g(this.f785g, args);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class b extends h implements ae.g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Method method) {
                super(method, false, null, 4, null);
                t.f(method, "method");
            }

            @Override // ae.h
            public Object call(Object[] args) {
                t.f(args, "args");
                d(args);
                return g(null, args);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class c extends h implements ae.g {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final boolean f786g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final Object f787h;

            /* JADX WARN: Illegal instructions before constructor call */
            public c(Method method, boolean z10, Object obj) {
                t.f(method, "method");
                Type[] genericParameterTypes = method.getGenericParameterTypes();
                t.e(genericParameterTypes, "getGenericParameterTypes(...)");
                super(method, false, (Type[]) (genericParameterTypes.length <= 1 ? new Type[0] : dd.l.m(genericParameterTypes, 1, genericParameterTypes.length)), null);
                this.f786g = z10;
                this.f787h = obj;
            }

            @Override // ae.h
            public Object call(Object[] args) {
                t.f(args, "args");
                d(args);
                r0 r0Var = new r0(2);
                r0Var.a(this.f787h);
                r0Var.b(args);
                return g(null, r0Var.d(new Object[r0Var.c()]));
            }

            public final Object h() {
                return this.f787h;
            }

            public final boolean i() {
                return this.f786g;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class d extends h implements ae.g {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final Object[] f788g;

            /* JADX WARN: Illegal instructions before constructor call */
            public d(Method method, Object[] boundReceiverComponents) {
                t.f(method, "method");
                t.f(boundReceiverComponents, "boundReceiverComponents");
                Type[] genericParameterTypes = method.getGenericParameterTypes();
                t.e(genericParameterTypes, "getGenericParameterTypes(...)");
                super(method, false, (Type[]) dd.n.z(genericParameterTypes, boundReceiverComponents.length).toArray(new Type[0]), null);
                this.f788g = boundReceiverComponents;
            }

            @Override // ae.h
            public Object call(Object[] args) {
                t.f(args, "args");
                d(args);
                r0 r0Var = new r0(2);
                r0Var.b(this.f788g);
                r0Var.b(args);
                return g(null, r0Var.d(new Object[r0Var.c()]));
            }

            public final Object[] h() {
                return this.f788g;
            }

            public final int i() {
                return this.f788g.length;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class e extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(Method method) {
                super(method, false, null, 6, null);
                t.f(method, "method");
            }

            @Override // ae.h
            public Object call(Object[] args) {
                t.f(args, "args");
                d(args);
                return g(args[0], args.length <= 1 ? new Object[0] : dd.l.m(args, 1, args.length));
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class f extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(Method method) {
                super(method, true, null, 4, null);
                t.f(method, "method");
            }

            @Override // ae.h
            public Object call(Object[] args) {
                t.f(args, "args");
                d(args);
                e(dd.n.D(args));
                return g(null, args.length <= 1 ? new Object[0] : dd.l.m(args, 1, args.length));
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class g extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public g(Method method) {
                super(method, false, null, 6, null);
                t.f(method, "method");
            }

            @Override // ae.h
            public Object call(Object[] args) {
                t.f(args, "args");
                d(args);
                return g(null, args);
            }
        }

        public /* synthetic */ h(Method method, boolean z10, Type[] typeArr, kotlin.jvm.internal.k kVar) {
            this(method, z10, typeArr);
        }

        public final Object g(Object obj, Object[] args) {
            t.f(args, "args");
            return this.f784f ? h0.f3852a : ((Method) b()).invoke(obj, Arrays.copyOf(args, args.length));
        }

        public /* synthetic */ h(Method method, boolean z10, Type[] typeArr, int i10, kotlin.jvm.internal.k kVar) {
            this(method, (i10 & 2) != 0 ? !Modifier.isStatic(method.getModifiers()) : z10, (i10 & 4) != 0 ? method.getGenericParameterTypes() : typeArr, null);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public h(Method method, boolean z10, Type[] typeArr) {
            Type genericReturnType = method.getGenericReturnType();
            t.e(genericReturnType, "getGenericReturnType(...)");
            super(method, genericReturnType, z10 ? method.getDeclaringClass() : null, typeArr, null);
            this.f784f = t.b(getReturnType(), Void.TYPE);
        }
    }

    public /* synthetic */ i(Member member, Type type, Class cls, Type[] typeArr, kotlin.jvm.internal.k kVar) {
        this(member, type, cls, typeArr);
    }

    @Override // ae.h
    public List a() {
        return this.f778d;
    }

    @Override // ae.h
    public final Member b() {
        return this.f775a;
    }

    @Override // ae.h
    public boolean c() {
        return h.a.b(this);
    }

    public void d(Object[] objArr) {
        h.a.a(this, objArr);
    }

    public final void e(Object obj) {
        if (obj == null || !this.f775a.getDeclaringClass().isInstance(obj)) {
            throw new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
        }
    }

    public final Class f() {
        return this.f777c;
    }

    @Override // ae.h
    public final Type getReturnType() {
        return this.f776b;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public i(java.lang.reflect.Member r1, java.lang.reflect.Type r2, java.lang.Class r3, java.lang.reflect.Type[] r4) {
        /*
            r0 = this;
            r0.<init>()
            r0.f775a = r1
            r0.f776b = r2
            r0.f777c = r3
            if (r3 == 0) goto L27
            kotlin.jvm.internal.r0 r1 = new kotlin.jvm.internal.r0
            r2 = 2
            r1.<init>(r2)
            r1.a(r3)
            r1.b(r4)
            int r2 = r1.c()
            java.lang.reflect.Type[] r2 = new java.lang.reflect.Type[r2]
            java.lang.Object[] r1 = r1.d(r2)
            java.util.List r1 = dd.r.n(r1)
            if (r1 != 0) goto L2b
        L27:
            java.util.List r1 = dd.n.z0(r4)
        L2b:
            r0.f778d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ae.i.<init>(java.lang.reflect.Member, java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type[]):void");
    }
}
