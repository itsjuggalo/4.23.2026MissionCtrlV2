package J3;

import I3.f;
import X2.AbstractC0769p;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q0 implements I3.f, I3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f963a = new ArrayList();

    private final boolean G(H3.e eVar, int i4) {
        Y(W(eVar, i4));
        return true;
    }

    @Override // I3.d
    public final void A(H3.e descriptor, int i4, char c4) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        K(W(descriptor, i4), c4);
    }

    @Override // I3.f
    public final void B(int i4) {
        P(X(), i4);
    }

    @Override // I3.f
    public final void C(H3.e enumDescriptor, int i4) {
        kotlin.jvm.internal.r.f(enumDescriptor, "enumDescriptor");
        M(X(), enumDescriptor, i4);
    }

    @Override // I3.f
    public final void D(long j4) {
        Q(X(), j4);
    }

    @Override // I3.d
    public void E(H3.e descriptor, int i4, F3.h serializer, Object obj) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        kotlin.jvm.internal.r.f(serializer, "serializer");
        if (G(descriptor, i4)) {
            H(serializer, obj);
        }
    }

    @Override // I3.f
    public final void F(String value) {
        kotlin.jvm.internal.r.f(value, "value");
        S(X(), value);
    }

    public void H(F3.h hVar, Object obj) {
        f.a.c(this, hVar, obj);
    }

    public abstract void I(Object obj, boolean z4);

    public abstract void J(Object obj, byte b4);

    public abstract void K(Object obj, char c4);

    public abstract void L(Object obj, double d4);

    public abstract void M(Object obj, H3.e eVar, int i4);

    public abstract void N(Object obj, float f4);

    public I3.f O(Object obj, H3.e inlineDescriptor) {
        kotlin.jvm.internal.r.f(inlineDescriptor, "inlineDescriptor");
        Y(obj);
        return this;
    }

    public abstract void P(Object obj, int i4);

    public abstract void Q(Object obj, long j4);

    public abstract void R(Object obj, short s4);

    public abstract void S(Object obj, String str);

    public abstract void T(H3.e eVar);

    public final Object U() {
        return X2.x.R(this.f963a);
    }

    public final Object V() {
        return X2.x.S(this.f963a);
    }

    public abstract Object W(H3.e eVar, int i4);

    public final Object X() {
        if (this.f963a.isEmpty()) {
            throw new F3.g("No tag in stack for requested element");
        }
        ArrayList arrayList = this.f963a;
        return arrayList.remove(AbstractC0769p.i(arrayList));
    }

    public final void Y(Object obj) {
        this.f963a.add(obj);
    }

    @Override // I3.d
    public final void c(H3.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        if (!this.f963a.isEmpty()) {
            X();
        }
        T(descriptor);
    }

    @Override // I3.f
    public I3.f f(H3.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return O(X(), descriptor);
    }

    @Override // I3.d
    public final void g(H3.e descriptor, int i4, double d4) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        L(W(descriptor, i4), d4);
    }

    @Override // I3.f
    public final void h(double d4) {
        L(X(), d4);
    }

    @Override // I3.f
    public final void i(short s4) {
        R(X(), s4);
    }

    @Override // I3.d
    public final void k(H3.e descriptor, int i4, int i5) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        P(W(descriptor, i4), i5);
    }

    @Override // I3.d
    public final void l(H3.e descriptor, int i4, long j4) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        Q(W(descriptor, i4), j4);
    }

    @Override // I3.f
    public final void m(byte b4) {
        J(X(), b4);
    }

    @Override // I3.f
    public final void n(boolean z4) {
        I(X(), z4);
    }

    @Override // I3.d
    public final void o(H3.e descriptor, int i4, String value) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        kotlin.jvm.internal.r.f(value, "value");
        S(W(descriptor, i4), value);
    }

    @Override // I3.f
    public final void p(float f4) {
        N(X(), f4);
    }

    @Override // I3.f
    public final void q(char c4) {
        K(X(), c4);
    }

    @Override // I3.d
    public final I3.f s(H3.e descriptor, int i4) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return O(W(descriptor, i4), descriptor.i(i4));
    }

    @Override // I3.d
    public final void t(H3.e descriptor, int i4, float f4) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        N(W(descriptor, i4), f4);
    }

    @Override // I3.d
    public void u(H3.e descriptor, int i4, F3.h serializer, Object obj) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        kotlin.jvm.internal.r.f(serializer, "serializer");
        if (G(descriptor, i4)) {
            z(serializer, obj);
        }
    }

    @Override // I3.f
    public I3.d v(H3.e eVar, int i4) {
        return f.a.a(this, eVar, i4);
    }

    @Override // I3.d
    public final void w(H3.e descriptor, int i4, byte b4) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        J(W(descriptor, i4), b4);
    }

    @Override // I3.d
    public final void x(H3.e descriptor, int i4, short s4) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        R(W(descriptor, i4), s4);
    }

    @Override // I3.d
    public final void y(H3.e descriptor, int i4, boolean z4) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        I(W(descriptor, i4), z4);
    }

    @Override // I3.f
    public abstract void z(F3.h hVar, Object obj);
}
