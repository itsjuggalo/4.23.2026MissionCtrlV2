package J3;

import I3.c;
import X2.AbstractC0769p;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p0 implements I3.e, I3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f955a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f956b;

    public static final class a extends kotlin.jvm.internal.s implements Function0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ F3.a f958b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f959c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(F3.a aVar, Object obj) {
            super(0);
            this.f958b = aVar;
            this.f959c = obj;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return p0.this.t() ? p0.this.I(this.f958b, this.f959c) : p0.this.o();
        }
    }

    public static final class b extends kotlin.jvm.internal.s implements Function0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ F3.a f961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f962c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(F3.a aVar, Object obj) {
            super(0);
            this.f961b = aVar;
            this.f962c = obj;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return p0.this.I(this.f961b, this.f962c);
        }
    }

    @Override // I3.e
    public final int A(H3.e enumDescriptor) {
        kotlin.jvm.internal.r.f(enumDescriptor, "enumDescriptor");
        return N(W(), enumDescriptor);
    }

    @Override // I3.c
    public int B(H3.e eVar) {
        return c.a.a(this, eVar);
    }

    @Override // I3.e
    public final byte C() {
        return K(W());
    }

    @Override // I3.c
    public final byte D(H3.e descriptor, int i4) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return K(V(descriptor, i4));
    }

    @Override // I3.c
    public final float E(H3.e descriptor, int i4) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return O(V(descriptor, i4));
    }

    @Override // I3.e
    public final short F() {
        return S(W());
    }

    @Override // I3.e
    public final float G() {
        return O(W());
    }

    @Override // I3.e
    public final double H() {
        return M(W());
    }

    public Object I(F3.a deserializer, Object obj) {
        kotlin.jvm.internal.r.f(deserializer, "deserializer");
        return p(deserializer);
    }

    public abstract boolean J(Object obj);

    public abstract byte K(Object obj);

    public abstract char L(Object obj);

    public abstract double M(Object obj);

    public abstract int N(Object obj, H3.e eVar);

    public abstract float O(Object obj);

    public I3.e P(Object obj, H3.e inlineDescriptor) {
        kotlin.jvm.internal.r.f(inlineDescriptor, "inlineDescriptor");
        X(obj);
        return this;
    }

    public abstract int Q(Object obj);

    public abstract long R(Object obj);

    public abstract short S(Object obj);

    public abstract String T(Object obj);

    public final Object U() {
        return X2.x.S(this.f955a);
    }

    public abstract Object V(H3.e eVar, int i4);

    public final Object W() {
        ArrayList arrayList = this.f955a;
        Object objRemove = arrayList.remove(AbstractC0769p.i(arrayList));
        this.f956b = true;
        return objRemove;
    }

    public final void X(Object obj) {
        this.f955a.add(obj);
    }

    public final Object Y(Object obj, Function0 function0) {
        X(obj);
        Object objInvoke = function0.invoke();
        if (!this.f956b) {
            W();
        }
        this.f956b = false;
        return objInvoke;
    }

    @Override // I3.e
    public final boolean e() {
        return J(W());
    }

    @Override // I3.e
    public final char f() {
        return L(W());
    }

    @Override // I3.e
    public I3.e g(H3.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return P(W(), descriptor);
    }

    @Override // I3.c
    public final int h(H3.e descriptor, int i4) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return Q(V(descriptor, i4));
    }

    @Override // I3.c
    public final long j(H3.e descriptor, int i4) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return R(V(descriptor, i4));
    }

    @Override // I3.e
    public final int l() {
        return Q(W());
    }

    @Override // I3.c
    public final Object m(H3.e descriptor, int i4, F3.a deserializer, Object obj) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        kotlin.jvm.internal.r.f(deserializer, "deserializer");
        return Y(V(descriptor, i4), new b(deserializer, obj));
    }

    @Override // I3.c
    public final boolean n(H3.e descriptor, int i4) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return J(V(descriptor, i4));
    }

    @Override // I3.e
    public final Void o() {
        return null;
    }

    @Override // I3.e
    public abstract Object p(F3.a aVar);

    @Override // I3.e
    public final String q() {
        return T(W());
    }

    @Override // I3.e
    public final long r() {
        return R(W());
    }

    @Override // I3.c
    public final I3.e s(H3.e descriptor, int i4) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return P(V(descriptor, i4), descriptor.i(i4));
    }

    @Override // I3.e
    public abstract boolean t();

    @Override // I3.c
    public final short u(H3.e descriptor, int i4) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return S(V(descriptor, i4));
    }

    @Override // I3.c
    public final String v(H3.e descriptor, int i4) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return T(V(descriptor, i4));
    }

    @Override // I3.c
    public boolean w() {
        return c.a.b(this);
    }

    @Override // I3.c
    public final char x(H3.e descriptor, int i4) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return L(V(descriptor, i4));
    }

    @Override // I3.c
    public final Object y(H3.e descriptor, int i4, F3.a deserializer, Object obj) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        kotlin.jvm.internal.r.f(deserializer, "deserializer");
        return Y(V(descriptor, i4), new a(deserializer, obj));
    }

    @Override // I3.c
    public final double z(H3.e descriptor, int i4) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return M(V(descriptor, i4));
    }
}
