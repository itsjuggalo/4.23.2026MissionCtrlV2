package o7;

import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import n7.c;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class A0 implements n7.e, n7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f22093a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f22094b;

    public static final Object K(A0 a02, k7.a aVar, Object obj) {
        return (aVar.getDescriptor().c() || a02.t()) ? a02.M(aVar, obj) : a02.o();
    }

    public static final Object L(A0 a02, k7.a aVar, Object obj) {
        return a02.M(aVar, obj);
    }

    @Override // n7.c
    public final boolean A(m7.e descriptor, int i8) {
        AbstractC2304t.f(descriptor, "descriptor");
        return N(Z(descriptor, i8));
    }

    @Override // n7.c
    public final char B(m7.e descriptor, int i8) {
        AbstractC2304t.f(descriptor, "descriptor");
        return P(Z(descriptor, i8));
    }

    @Override // n7.c
    public final long C(m7.e descriptor, int i8) {
        AbstractC2304t.f(descriptor, "descriptor");
        return V(Z(descriptor, i8));
    }

    @Override // n7.e
    public final byte D() {
        return O(b0());
    }

    @Override // n7.e
    public final short F() {
        return W(b0());
    }

    @Override // n7.e
    public final float G() {
        return S(b0());
    }

    @Override // n7.e
    public final double H() {
        return Q(b0());
    }

    public Object M(k7.a deserializer, Object obj) {
        AbstractC2304t.f(deserializer, "deserializer");
        return v(deserializer);
    }

    public abstract boolean N(Object obj);

    public abstract byte O(Object obj);

    public abstract char P(Object obj);

    public abstract double Q(Object obj);

    public abstract int R(Object obj, m7.e eVar);

    public abstract float S(Object obj);

    public n7.e T(Object obj, m7.e inlineDescriptor) {
        AbstractC2304t.f(inlineDescriptor, "inlineDescriptor");
        c0(obj);
        return this;
    }

    public abstract int U(Object obj);

    public abstract long V(Object obj);

    public abstract short W(Object obj);

    public abstract String X(Object obj);

    public final Object Y() {
        return p5.z.l0(this.f22093a);
    }

    public abstract Object Z(m7.e eVar, int i8);

    public final ArrayList a0() {
        return this.f22093a;
    }

    public final Object b0() {
        ArrayList arrayList = this.f22093a;
        Object objRemove = arrayList.remove(AbstractC2595q.k(arrayList));
        this.f22094b = true;
        return objRemove;
    }

    public final void c0(Object obj) {
        this.f22093a.add(obj);
    }

    public final Object d0(Object obj, Function0 function0) {
        c0(obj);
        Object objInvoke = function0.invoke();
        if (!this.f22094b) {
            b0();
        }
        this.f22094b = false;
        return objInvoke;
    }

    @Override // n7.e
    public n7.e e(m7.e descriptor) {
        AbstractC2304t.f(descriptor, "descriptor");
        return T(b0(), descriptor);
    }

    @Override // n7.c
    public final double f(m7.e descriptor, int i8) {
        AbstractC2304t.f(descriptor, "descriptor");
        return Q(Z(descriptor, i8));
    }

    @Override // n7.e
    public final boolean g() {
        return N(b0());
    }

    @Override // n7.e
    public final char h() {
        return P(b0());
    }

    @Override // n7.e
    public final int i(m7.e enumDescriptor) {
        AbstractC2304t.f(enumDescriptor, "enumDescriptor");
        return R(b0(), enumDescriptor);
    }

    @Override // n7.c
    public final String j(m7.e descriptor, int i8) {
        AbstractC2304t.f(descriptor, "descriptor");
        return X(Z(descriptor, i8));
    }

    @Override // n7.c
    public int k(m7.e eVar) {
        return c.a.a(this, eVar);
    }

    @Override // n7.e
    public final int m() {
        return U(b0());
    }

    @Override // n7.c
    public final float n(m7.e descriptor, int i8) {
        AbstractC2304t.f(descriptor, "descriptor");
        return S(Z(descriptor, i8));
    }

    @Override // n7.e
    public final Void o() {
        return null;
    }

    @Override // n7.c
    public final n7.e p(m7.e descriptor, int i8) {
        AbstractC2304t.f(descriptor, "descriptor");
        return T(Z(descriptor, i8), descriptor.h(i8));
    }

    @Override // n7.e
    public final String q() {
        return X(b0());
    }

    @Override // n7.c
    public final byte r(m7.e descriptor, int i8) {
        AbstractC2304t.f(descriptor, "descriptor");
        return O(Z(descriptor, i8));
    }

    @Override // n7.e
    public final long s() {
        return V(b0());
    }

    @Override // n7.c
    public final Object u(m7.e descriptor, int i8, final k7.a deserializer, final Object obj) {
        AbstractC2304t.f(descriptor, "descriptor");
        AbstractC2304t.f(deserializer, "deserializer");
        return d0(Z(descriptor, i8), new Function0() { // from class: o7.y0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return A0.L(this.f22231a, deserializer, obj);
            }
        });
    }

    @Override // n7.e
    public abstract Object v(k7.a aVar);

    @Override // n7.c
    public boolean w() {
        return c.a.b(this);
    }

    @Override // n7.c
    public final short x(m7.e descriptor, int i8) {
        AbstractC2304t.f(descriptor, "descriptor");
        return W(Z(descriptor, i8));
    }

    @Override // n7.c
    public final int y(m7.e descriptor, int i8) {
        AbstractC2304t.f(descriptor, "descriptor");
        return U(Z(descriptor, i8));
    }

    @Override // n7.c
    public final Object z(m7.e descriptor, int i8, final k7.a deserializer, final Object obj) {
        AbstractC2304t.f(descriptor, "descriptor");
        AbstractC2304t.f(deserializer, "deserializer");
        return d0(Z(descriptor, i8), new Function0() { // from class: o7.z0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return A0.K(this.f22237a, deserializer, obj);
            }
        });
    }
}
