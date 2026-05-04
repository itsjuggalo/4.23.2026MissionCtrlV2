package dh;

import ch.c;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z1 implements ch.e, ch.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f8265a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8266b;

    public static final Object K(z1 z1Var, zg.a aVar, Object obj) {
        return (aVar.getDescriptor().j() || z1Var.t()) ? z1Var.M(aVar, obj) : z1Var.l();
    }

    public static final Object L(z1 z1Var, zg.a aVar, Object obj) {
        return z1Var.M(aVar, obj);
    }

    @Override // ch.e
    public ch.e A(bh.e descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return T(b0(), descriptor);
    }

    @Override // ch.c
    public final boolean B(bh.e descriptor, int i10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return N(Z(descriptor, i10));
    }

    @Override // ch.c
    public final int C(bh.e descriptor, int i10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return U(Z(descriptor, i10));
    }

    @Override // ch.e
    public final byte D() {
        return O(b0());
    }

    @Override // ch.e
    public abstract Object E(zg.a aVar);

    @Override // ch.e
    public final short F() {
        return W(b0());
    }

    @Override // ch.e
    public final float G() {
        return S(b0());
    }

    @Override // ch.e
    public final double H() {
        return Q(b0());
    }

    public Object M(zg.a deserializer, Object obj) {
        kotlin.jvm.internal.t.f(deserializer, "deserializer");
        return E(deserializer);
    }

    public abstract boolean N(Object obj);

    public abstract byte O(Object obj);

    public abstract char P(Object obj);

    public abstract double Q(Object obj);

    public abstract int R(Object obj, bh.e eVar);

    public abstract float S(Object obj);

    public ch.e T(Object obj, bh.e inlineDescriptor) {
        kotlin.jvm.internal.t.f(inlineDescriptor, "inlineDescriptor");
        c0(obj);
        return this;
    }

    public abstract int U(Object obj);

    public abstract long V(Object obj);

    public abstract short W(Object obj);

    public abstract String X(Object obj);

    public final Object Y() {
        return dd.a0.m0(this.f8265a);
    }

    public abstract Object Z(bh.e eVar, int i10);

    public final ArrayList a0() {
        return this.f8265a;
    }

    public final Object b0() {
        ArrayList arrayList = this.f8265a;
        Object objRemove = arrayList.remove(dd.r.m(arrayList));
        this.f8266b = true;
        return objRemove;
    }

    public final void c0(Object obj) {
        this.f8265a.add(obj);
    }

    public final Object d0(Object obj, Function0 function0) {
        c0(obj);
        Object objInvoke = function0.invoke();
        if (!this.f8266b) {
            b0();
        }
        this.f8266b = false;
        return objInvoke;
    }

    @Override // ch.e
    public final boolean e() {
        return N(b0());
    }

    @Override // ch.e
    public final char f() {
        return P(b0());
    }

    @Override // ch.c
    public final long g(bh.e descriptor, int i10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return V(Z(descriptor, i10));
    }

    @Override // ch.c
    public final Object h(bh.e descriptor, int i10, final zg.a deserializer, final Object obj) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        kotlin.jvm.internal.t.f(deserializer, "deserializer");
        return d0(Z(descriptor, i10), new Function0() { // from class: dh.x1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return z1.L(this.f8250a, deserializer, obj);
            }
        });
    }

    @Override // ch.e
    public final int j() {
        return U(b0());
    }

    @Override // ch.c
    public final double k(bh.e descriptor, int i10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return Q(Z(descriptor, i10));
    }

    @Override // ch.e
    public final Void l() {
        return null;
    }

    @Override // ch.e
    public final String m() {
        return X(b0());
    }

    @Override // ch.c
    public final Object n(bh.e descriptor, int i10, final zg.a deserializer, final Object obj) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        kotlin.jvm.internal.t.f(deserializer, "deserializer");
        return d0(Z(descriptor, i10), new Function0() { // from class: dh.y1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return z1.K(this.f8257a, deserializer, obj);
            }
        });
    }

    @Override // ch.c
    public int o(bh.e eVar) {
        return c.a.a(this, eVar);
    }

    @Override // ch.c
    public final float p(bh.e descriptor, int i10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return S(Z(descriptor, i10));
    }

    @Override // ch.e
    public final long q() {
        return V(b0());
    }

    @Override // ch.c
    public final byte r(bh.e descriptor, int i10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return O(Z(descriptor, i10));
    }

    @Override // ch.c
    public final String s(bh.e descriptor, int i10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return X(Z(descriptor, i10));
    }

    @Override // ch.c
    public final short u(bh.e descriptor, int i10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return W(Z(descriptor, i10));
    }

    @Override // ch.c
    public final ch.e v(bh.e descriptor, int i10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return T(Z(descriptor, i10), descriptor.o(i10));
    }

    @Override // ch.e
    public final int x(bh.e enumDescriptor) {
        kotlin.jvm.internal.t.f(enumDescriptor, "enumDescriptor");
        return R(b0(), enumDescriptor);
    }

    @Override // ch.c
    public final char y(bh.e descriptor, int i10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return P(Z(descriptor, i10));
    }

    @Override // ch.c
    public boolean z() {
        return c.a.b(this);
    }
}
