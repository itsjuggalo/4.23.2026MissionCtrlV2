package dh;

import ch.f;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a2 implements ch.f, ch.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f8121a = new ArrayList();

    private final boolean G(bh.e eVar, int i10) {
        Y(W(eVar, i10));
        return true;
    }

    @Override // ch.f
    public final void A(int i10) {
        P(X(), i10);
    }

    @Override // ch.f
    public abstract void B(zg.k kVar, Object obj);

    @Override // ch.d
    public final void C(bh.e descriptor, int i10, boolean z10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        I(W(descriptor, i10), z10);
    }

    @Override // ch.f
    public final void D(long j10) {
        Q(X(), j10);
    }

    @Override // ch.d
    public final void E(bh.e descriptor, int i10, byte b10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        J(W(descriptor, i10), b10);
    }

    @Override // ch.f
    public final void F(String value) {
        kotlin.jvm.internal.t.f(value, "value");
        S(X(), value);
    }

    public void H(zg.k kVar, Object obj) {
        f.a.c(this, kVar, obj);
    }

    public abstract void I(Object obj, boolean z10);

    public abstract void J(Object obj, byte b10);

    public abstract void K(Object obj, char c10);

    public abstract void L(Object obj, double d10);

    public abstract void M(Object obj, bh.e eVar, int i10);

    public abstract void N(Object obj, float f10);

    public ch.f O(Object obj, bh.e inlineDescriptor) {
        kotlin.jvm.internal.t.f(inlineDescriptor, "inlineDescriptor");
        Y(obj);
        return this;
    }

    public abstract void P(Object obj, int i10);

    public abstract void Q(Object obj, long j10);

    public abstract void R(Object obj, short s10);

    public abstract void S(Object obj, String str);

    public abstract void T(bh.e eVar);

    public final Object U() {
        return dd.a0.k0(this.f8121a);
    }

    public final Object V() {
        return dd.a0.m0(this.f8121a);
    }

    public abstract Object W(bh.e eVar, int i10);

    public final Object X() {
        if (this.f8121a.isEmpty()) {
            throw new zg.j("No tag in stack for requested element");
        }
        ArrayList arrayList = this.f8121a;
        return arrayList.remove(dd.r.m(arrayList));
    }

    public final void Y(Object obj) {
        this.f8121a.add(obj);
    }

    @Override // ch.d
    public final void c(bh.e descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        if (!this.f8121a.isEmpty()) {
            X();
        }
        T(descriptor);
    }

    @Override // ch.d
    public void e(bh.e descriptor, int i10, zg.k serializer, Object obj) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        kotlin.jvm.internal.t.f(serializer, "serializer");
        if (G(descriptor, i10)) {
            H(serializer, obj);
        }
    }

    @Override // ch.d
    public final void g(bh.e descriptor, int i10, float f10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        N(W(descriptor, i10), f10);
    }

    @Override // ch.d
    public final ch.f h(bh.e descriptor, int i10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return O(W(descriptor, i10), descriptor.o(i10));
    }

    @Override // ch.d
    public final void i(bh.e descriptor, int i10, short s10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        R(W(descriptor, i10), s10);
    }

    @Override // ch.f
    public final void j(double d10) {
        L(X(), d10);
    }

    @Override // ch.f
    public final void k(short s10) {
        R(X(), s10);
    }

    @Override // ch.f
    public final void l(byte b10) {
        J(X(), b10);
    }

    @Override // ch.f
    public final void m(boolean z10) {
        I(X(), z10);
    }

    @Override // ch.d
    public void n(bh.e descriptor, int i10, zg.k serializer, Object obj) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        kotlin.jvm.internal.t.f(serializer, "serializer");
        if (G(descriptor, i10)) {
            B(serializer, obj);
        }
    }

    @Override // ch.f
    public final void p(float f10) {
        N(X(), f10);
    }

    @Override // ch.d
    public final void q(bh.e descriptor, int i10, double d10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        L(W(descriptor, i10), d10);
    }

    @Override // ch.d
    public final void r(bh.e descriptor, int i10, long j10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        Q(W(descriptor, i10), j10);
    }

    @Override // ch.d
    public final void s(bh.e descriptor, int i10, char c10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        K(W(descriptor, i10), c10);
    }

    @Override // ch.f
    public final void t(char c10) {
        K(X(), c10);
    }

    @Override // ch.f
    public ch.f v(bh.e descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return O(X(), descriptor);
    }

    @Override // ch.d
    public final void w(bh.e descriptor, int i10, String value) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        kotlin.jvm.internal.t.f(value, "value");
        S(W(descriptor, i10), value);
    }

    @Override // ch.d
    public final void x(bh.e descriptor, int i10, int i11) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        P(W(descriptor, i10), i11);
    }

    @Override // ch.f
    public final void y(bh.e enumDescriptor, int i10) {
        kotlin.jvm.internal.t.f(enumDescriptor, "enumDescriptor");
        M(X(), enumDescriptor, i10);
    }

    @Override // ch.f
    public ch.d z(bh.e eVar, int i10) {
        return f.a.a(this, eVar, i10);
    }
}
