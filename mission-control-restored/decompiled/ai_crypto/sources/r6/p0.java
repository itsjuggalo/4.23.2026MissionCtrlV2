package r6;

import F5.AbstractC0556n;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import q6.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p0 implements q6.e, q6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f22912a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f22913b;

    public static final class a extends kotlin.jvm.internal.s implements Function0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ n6.a f22915b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f22916c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(n6.a aVar, Object obj) {
            super(0);
            this.f22915b = aVar;
            this.f22916c = obj;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return p0.this.t() ? p0.this.I(this.f22915b, this.f22916c) : p0.this.m();
        }
    }

    public static final class b extends kotlin.jvm.internal.s implements Function0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ n6.a f22918b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f22919c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(n6.a aVar, Object obj) {
            super(0);
            this.f22918b = aVar;
            this.f22919c = obj;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return p0.this.I(this.f22918b, this.f22919c);
        }
    }

    @Override // q6.c
    public final Object A(p6.e descriptor, int i7, n6.a deserializer, Object obj) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        kotlin.jvm.internal.r.f(deserializer, "deserializer");
        return Y(V(descriptor, i7), new b(deserializer, obj));
    }

    @Override // q6.c
    public final short B(p6.e descriptor, int i7) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return S(V(descriptor, i7));
    }

    @Override // q6.c
    public final char C(p6.e descriptor, int i7) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return L(V(descriptor, i7));
    }

    @Override // q6.e
    public final byte D() {
        return K(W());
    }

    @Override // q6.e
    public final short E() {
        return S(W());
    }

    @Override // q6.e
    public final float F() {
        return O(W());
    }

    @Override // q6.e
    public final double G() {
        return M(W());
    }

    @Override // q6.c
    public final boolean H(p6.e descriptor, int i7) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return J(V(descriptor, i7));
    }

    public Object I(n6.a deserializer, Object obj) {
        kotlin.jvm.internal.r.f(deserializer, "deserializer");
        return l(deserializer);
    }

    public abstract boolean J(Object obj);

    public abstract byte K(Object obj);

    public abstract char L(Object obj);

    public abstract double M(Object obj);

    public abstract int N(Object obj, p6.e eVar);

    public abstract float O(Object obj);

    public q6.e P(Object obj, p6.e inlineDescriptor) {
        kotlin.jvm.internal.r.f(inlineDescriptor, "inlineDescriptor");
        X(obj);
        return this;
    }

    public abstract int Q(Object obj);

    public abstract long R(Object obj);

    public abstract short S(Object obj);

    public abstract String T(Object obj);

    public final Object U() {
        return F5.v.T(this.f22912a);
    }

    public abstract Object V(p6.e eVar, int i7);

    public final Object W() {
        ArrayList arrayList = this.f22912a;
        Object objRemove = arrayList.remove(AbstractC0556n.i(arrayList));
        this.f22913b = true;
        return objRemove;
    }

    public final void X(Object obj) {
        this.f22912a.add(obj);
    }

    public final Object Y(Object obj, Function0 function0) {
        X(obj);
        Object objInvoke = function0.invoke();
        if (!this.f22913b) {
            W();
        }
        this.f22913b = false;
        return objInvoke;
    }

    @Override // q6.c
    public final int e(p6.e descriptor, int i7) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return Q(V(descriptor, i7));
    }

    @Override // q6.e
    public final boolean f() {
        return J(W());
    }

    @Override // q6.e
    public final char g() {
        return L(W());
    }

    @Override // q6.e
    public final int h(p6.e enumDescriptor) {
        kotlin.jvm.internal.r.f(enumDescriptor, "enumDescriptor");
        return N(W(), enumDescriptor);
    }

    @Override // q6.c
    public final float i(p6.e descriptor, int i7) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return O(V(descriptor, i7));
    }

    @Override // q6.e
    public final int k() {
        return Q(W());
    }

    @Override // q6.e
    public abstract Object l(n6.a aVar);

    @Override // q6.e
    public final Void m() {
        return null;
    }

    @Override // q6.c
    public int n(p6.e eVar) {
        return c.a.a(this, eVar);
    }

    @Override // q6.e
    public final String o() {
        return T(W());
    }

    @Override // q6.c
    public final byte p(p6.e descriptor, int i7) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return K(V(descriptor, i7));
    }

    @Override // q6.e
    public final long r() {
        return R(W());
    }

    @Override // q6.c
    public final q6.e s(p6.e descriptor, int i7) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return P(V(descriptor, i7), descriptor.i(i7));
    }

    @Override // q6.e
    public abstract boolean t();

    @Override // q6.c
    public final double u(p6.e descriptor, int i7) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return M(V(descriptor, i7));
    }

    @Override // q6.c
    public final String v(p6.e descriptor, int i7) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return T(V(descriptor, i7));
    }

    @Override // q6.c
    public boolean w() {
        return c.a.b(this);
    }

    @Override // q6.e
    public q6.e x(p6.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return P(W(), descriptor);
    }

    @Override // q6.c
    public final Object y(p6.e descriptor, int i7, n6.a deserializer, Object obj) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        kotlin.jvm.internal.r.f(deserializer, "deserializer");
        return Y(V(descriptor, i7), new a(deserializer, obj));
    }

    @Override // q6.c
    public final long z(p6.e descriptor, int i7) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return R(V(descriptor, i7));
    }
}
