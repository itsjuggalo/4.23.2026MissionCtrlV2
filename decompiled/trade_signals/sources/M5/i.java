package M5;

import M5.h;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.T;
import o5.C2470H;
import p5.AbstractC2590l;
import p5.AbstractC2592n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i implements M5.h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f5397e = new d(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Member f5398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f5399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class f5400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f5401d;

    public static final class a extends i implements M5.g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Object f5402f;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(Constructor constructor, Object obj) {
            AbstractC2304t.f(constructor, "constructor");
            Class declaringClass = constructor.getDeclaringClass();
            AbstractC2304t.e(declaringClass, "getDeclaringClass(...)");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            AbstractC2304t.e(genericParameterTypes, "getGenericParameterTypes(...)");
            super(constructor, declaringClass, null, (Type[]) (genericParameterTypes.length <= 2 ? new Type[0] : AbstractC2590l.m(genericParameterTypes, 1, genericParameterTypes.length - 1)), null);
            this.f5402f = obj;
        }

        @Override // M5.h
        public Object call(Object[] args) {
            AbstractC2304t.f(args, "args");
            d(args);
            Constructor constructor = (Constructor) b();
            T t8 = new T(3);
            t8.a(this.f5402f);
            t8.b(args);
            t8.a(null);
            return constructor.newInstance(t8.d(new Object[t8.c()]));
        }
    }

    public static final class b extends i {
        /* JADX WARN: Illegal instructions before constructor call */
        public b(Constructor constructor) {
            AbstractC2304t.f(constructor, "constructor");
            Class declaringClass = constructor.getDeclaringClass();
            AbstractC2304t.e(declaringClass, "getDeclaringClass(...)");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            AbstractC2304t.e(genericParameterTypes, "getGenericParameterTypes(...)");
            super(constructor, declaringClass, null, (Type[]) (genericParameterTypes.length <= 1 ? new Type[0] : AbstractC2590l.m(genericParameterTypes, 0, genericParameterTypes.length - 1)), null);
        }

        @Override // M5.h
        public Object call(Object[] args) {
            AbstractC2304t.f(args, "args");
            d(args);
            Constructor constructor = (Constructor) b();
            T t8 = new T(2);
            t8.b(args);
            t8.a(null);
            return constructor.newInstance(t8.d(new Object[t8.c()]));
        }
    }

    public static final class c extends i implements M5.g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Object f5403f;

        /* JADX WARN: Illegal instructions before constructor call */
        public c(Constructor constructor, Object obj) {
            AbstractC2304t.f(constructor, "constructor");
            Class declaringClass = constructor.getDeclaringClass();
            AbstractC2304t.e(declaringClass, "getDeclaringClass(...)");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            AbstractC2304t.e(genericParameterTypes, "getGenericParameterTypes(...)");
            super(constructor, declaringClass, null, genericParameterTypes, null);
            this.f5403f = obj;
        }

        @Override // M5.h
        public Object call(Object[] args) {
            AbstractC2304t.f(args, "args");
            d(args);
            Constructor constructor = (Constructor) b();
            T t8 = new T(2);
            t8.a(this.f5403f);
            t8.b(args);
            return constructor.newInstance(t8.d(new Object[t8.c()]));
        }
    }

    public static final class d {
        public d() {
        }

        public /* synthetic */ d(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public static final class e extends i {
        /* JADX WARN: Illegal instructions before constructor call */
        public e(Constructor constructor) {
            AbstractC2304t.f(constructor, "constructor");
            Class declaringClass = constructor.getDeclaringClass();
            AbstractC2304t.e(declaringClass, "getDeclaringClass(...)");
            Class declaringClass2 = constructor.getDeclaringClass();
            Class<?> declaringClass3 = declaringClass2.getDeclaringClass();
            Class<?> cls = (declaringClass3 == null || Modifier.isStatic(declaringClass2.getModifiers())) ? null : declaringClass3;
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            AbstractC2304t.e(genericParameterTypes, "getGenericParameterTypes(...)");
            super(constructor, declaringClass, cls, genericParameterTypes, null);
        }

        @Override // M5.h
        public Object call(Object[] args) {
            AbstractC2304t.f(args, "args");
            d(args);
            return ((Constructor) b()).newInstance(Arrays.copyOf(args, args.length));
        }
    }

    public static abstract class f extends i {

        public static final class a extends f implements M5.g {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final Object f5404f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Field field, Object obj) {
                super(field, false, null);
                AbstractC2304t.f(field, "field");
                this.f5404f = obj;
            }

            @Override // M5.i.f, M5.h
            public Object call(Object[] args) {
                AbstractC2304t.f(args, "args");
                d(args);
                return ((Field) b()).get(this.f5404f);
            }
        }

        public static final class b extends f implements M5.g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Field field) {
                super(field, false, null);
                AbstractC2304t.f(field, "field");
            }
        }

        public static final class c extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Field field) {
                super(field, true, null);
                AbstractC2304t.f(field, "field");
            }
        }

        public static final class d extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Field field) {
                super(field, true, null);
                AbstractC2304t.f(field, "field");
            }

            @Override // M5.i
            public void d(Object[] args) {
                AbstractC2304t.f(args, "args");
                super.d(args);
                e(AbstractC2592n.D(args));
            }
        }

        public static final class e extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(Field field) {
                super(field, false, null);
                AbstractC2304t.f(field, "field");
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public f(Field field, boolean z7) {
            Type genericType = field.getGenericType();
            AbstractC2304t.e(genericType, "getGenericType(...)");
            super(field, genericType, z7 ? field.getDeclaringClass() : null, new Type[0], null);
        }

        @Override // M5.h
        public Object call(Object[] args) {
            AbstractC2304t.f(args, "args");
            d(args);
            return ((Field) b()).get(f() != null ? AbstractC2592n.C(args) : null);
        }

        public /* synthetic */ f(Field field, boolean z7, AbstractC2296k abstractC2296k) {
            this(field, z7);
        }
    }

    public static abstract class g extends i {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f5405f;

        public static final class a extends g implements M5.g {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final Object f5406g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Field field, boolean z7, Object obj) {
                super(field, z7, false, null);
                AbstractC2304t.f(field, "field");
                this.f5406g = obj;
            }

            @Override // M5.i.g, M5.h
            public Object call(Object[] args) throws IllegalAccessException {
                AbstractC2304t.f(args, "args");
                d(args);
                ((Field) b()).set(this.f5406g, AbstractC2592n.C(args));
                return C2470H.f21956a;
            }
        }

        public static final class b extends g implements M5.g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Field field, boolean z7) {
                super(field, z7, false, null);
                AbstractC2304t.f(field, "field");
            }

            @Override // M5.i.g, M5.h
            public Object call(Object[] args) throws IllegalAccessException {
                AbstractC2304t.f(args, "args");
                d(args);
                ((Field) b()).set(null, AbstractC2592n.V(args));
                return C2470H.f21956a;
            }
        }

        public static final class c extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Field field, boolean z7) {
                super(field, z7, true, null);
                AbstractC2304t.f(field, "field");
            }
        }

        public static final class d extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Field field, boolean z7) {
                super(field, z7, true, null);
                AbstractC2304t.f(field, "field");
            }

            @Override // M5.i.g, M5.i
            public void d(Object[] args) {
                AbstractC2304t.f(args, "args");
                super.d(args);
                e(AbstractC2592n.D(args));
            }
        }

        public static final class e extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(Field field, boolean z7) {
                super(field, z7, false, null);
                AbstractC2304t.f(field, "field");
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public g(Field field, boolean z7, boolean z8) {
            Class TYPE = Void.TYPE;
            AbstractC2304t.e(TYPE, "TYPE");
            super(field, TYPE, z8 ? field.getDeclaringClass() : null, new Type[]{field.getGenericType()}, null);
            this.f5405f = z7;
        }

        @Override // M5.h
        public Object call(Object[] args) throws IllegalAccessException {
            AbstractC2304t.f(args, "args");
            d(args);
            ((Field) b()).set(f() != null ? AbstractC2592n.C(args) : null, AbstractC2592n.V(args));
            return C2470H.f21956a;
        }

        @Override // M5.i
        public void d(Object[] args) {
            AbstractC2304t.f(args, "args");
            super.d(args);
            if (this.f5405f && AbstractC2592n.V(args) == null) {
                throw new IllegalArgumentException("null is not allowed as a value for this property.");
            }
        }

        public /* synthetic */ g(Field field, boolean z7, boolean z8, AbstractC2296k abstractC2296k) {
            this(field, z7, z8);
        }
    }

    public static abstract class h extends i {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f5407f;

        public static final class a extends h implements M5.g {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final Object f5408g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Method method, Object obj) {
                super(method, false, null, 4, null);
                AbstractC2304t.f(method, "method");
                this.f5408g = obj;
            }

            @Override // M5.h
            public Object call(Object[] args) {
                AbstractC2304t.f(args, "args");
                d(args);
                return g(this.f5408g, args);
            }
        }

        public static final class b extends h implements M5.g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Method method) {
                super(method, false, null, 4, null);
                AbstractC2304t.f(method, "method");
            }

            @Override // M5.h
            public Object call(Object[] args) {
                AbstractC2304t.f(args, "args");
                d(args);
                return g(null, args);
            }
        }

        public static final class c extends h implements M5.g {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final boolean f5409g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final Object f5410h;

            /* JADX WARN: Illegal instructions before constructor call */
            public c(Method method, boolean z7, Object obj) {
                AbstractC2304t.f(method, "method");
                Type[] genericParameterTypes = method.getGenericParameterTypes();
                AbstractC2304t.e(genericParameterTypes, "getGenericParameterTypes(...)");
                super(method, false, (Type[]) (genericParameterTypes.length <= 1 ? new Type[0] : AbstractC2590l.m(genericParameterTypes, 1, genericParameterTypes.length)), null);
                this.f5409g = z7;
                this.f5410h = obj;
            }

            @Override // M5.h
            public Object call(Object[] args) {
                AbstractC2304t.f(args, "args");
                d(args);
                T t8 = new T(2);
                t8.a(this.f5410h);
                t8.b(args);
                return g(null, t8.d(new Object[t8.c()]));
            }

            public final Object h() {
                return this.f5410h;
            }

            public final boolean i() {
                return this.f5409g;
            }
        }

        public static final class d extends h implements M5.g {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final Object[] f5411g;

            /* JADX WARN: Illegal instructions before constructor call */
            public d(Method method, Object[] boundReceiverComponents) {
                AbstractC2304t.f(method, "method");
                AbstractC2304t.f(boundReceiverComponents, "boundReceiverComponents");
                Type[] genericParameterTypes = method.getGenericParameterTypes();
                AbstractC2304t.e(genericParameterTypes, "getGenericParameterTypes(...)");
                super(method, false, (Type[]) AbstractC2592n.z(genericParameterTypes, boundReceiverComponents.length).toArray(new Type[0]), null);
                this.f5411g = boundReceiverComponents;
            }

            @Override // M5.h
            public Object call(Object[] args) {
                AbstractC2304t.f(args, "args");
                d(args);
                T t8 = new T(2);
                t8.b(this.f5411g);
                t8.b(args);
                return g(null, t8.d(new Object[t8.c()]));
            }

            public final Object[] h() {
                return this.f5411g;
            }

            public final int i() {
                return this.f5411g.length;
            }
        }

        public static final class e extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(Method method) {
                super(method, false, null, 6, null);
                AbstractC2304t.f(method, "method");
            }

            @Override // M5.h
            public Object call(Object[] args) {
                AbstractC2304t.f(args, "args");
                d(args);
                return g(args[0], args.length <= 1 ? new Object[0] : AbstractC2590l.m(args, 1, args.length));
            }
        }

        public static final class f extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(Method method) {
                super(method, true, null, 4, null);
                AbstractC2304t.f(method, "method");
            }

            @Override // M5.h
            public Object call(Object[] args) {
                AbstractC2304t.f(args, "args");
                d(args);
                e(AbstractC2592n.D(args));
                return g(null, args.length <= 1 ? new Object[0] : AbstractC2590l.m(args, 1, args.length));
            }
        }

        public static final class g extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public g(Method method) {
                super(method, false, null, 6, null);
                AbstractC2304t.f(method, "method");
            }

            @Override // M5.h
            public Object call(Object[] args) {
                AbstractC2304t.f(args, "args");
                d(args);
                return g(null, args);
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public h(Method method, boolean z7, Type[] typeArr) {
            Type genericReturnType = method.getGenericReturnType();
            AbstractC2304t.e(genericReturnType, "getGenericReturnType(...)");
            super(method, genericReturnType, z7 ? method.getDeclaringClass() : null, typeArr, null);
            this.f5407f = AbstractC2304t.b(getReturnType(), Void.TYPE);
        }

        public final Object g(Object obj, Object[] args) {
            AbstractC2304t.f(args, "args");
            return this.f5407f ? C2470H.f21956a : ((Method) b()).invoke(obj, Arrays.copyOf(args, args.length));
        }

        public /* synthetic */ h(Method method, boolean z7, Type[] typeArr, int i8, AbstractC2296k abstractC2296k) {
            this(method, (i8 & 2) != 0 ? !Modifier.isStatic(method.getModifiers()) : z7, (i8 & 4) != 0 ? method.getGenericParameterTypes() : typeArr, null);
        }

        public /* synthetic */ h(Method method, boolean z7, Type[] typeArr, AbstractC2296k abstractC2296k) {
            this(method, z7, typeArr);
        }
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
            r0.f5398a = r1
            r0.f5399b = r2
            r0.f5400c = r3
            if (r3 == 0) goto L27
            kotlin.jvm.internal.T r1 = new kotlin.jvm.internal.T
            r2 = 2
            r1.<init>(r2)
            r1.a(r3)
            r1.b(r4)
            int r2 = r1.c()
            java.lang.reflect.Type[] r2 = new java.lang.reflect.Type[r2]
            java.lang.Object[] r1 = r1.d(r2)
            java.util.List r1 = p5.AbstractC2595q.l(r1)
            if (r1 != 0) goto L2b
        L27:
            java.util.List r1 = p5.AbstractC2592n.k0(r4)
        L2b:
            r0.f5401d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M5.i.<init>(java.lang.reflect.Member, java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type[]):void");
    }

    @Override // M5.h
    public List a() {
        return this.f5401d;
    }

    @Override // M5.h
    public final Member b() {
        return this.f5398a;
    }

    @Override // M5.h
    public boolean c() {
        return h.a.b(this);
    }

    public void d(Object[] objArr) {
        h.a.a(this, objArr);
    }

    public final void e(Object obj) {
        if (obj == null || !this.f5398a.getDeclaringClass().isInstance(obj)) {
            throw new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
        }
    }

    public final Class f() {
        return this.f5400c;
    }

    @Override // M5.h
    public final Type getReturnType() {
        return this.f5399b;
    }

    public /* synthetic */ i(Member member, Type type, Class cls, Type[] typeArr, AbstractC2296k abstractC2296k) {
        this(member, type, cls, typeArr);
    }
}
