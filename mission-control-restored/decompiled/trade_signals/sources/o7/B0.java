package o7;

import java.util.ArrayList;
import kotlin.jvm.internal.AbstractC2304t;
import n7.f;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class B0 implements n7.f, n7.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f22097a = new ArrayList();

    private final boolean G(m7.e eVar, int i8) {
        Y(W(eVar, i8));
        return true;
    }

    @Override // n7.f
    public final void A(long j8) {
        Q(X(), j8);
    }

    @Override // n7.d
    public void B(m7.e descriptor, int i8, k7.k serializer, Object obj) {
        AbstractC2304t.f(descriptor, "descriptor");
        AbstractC2304t.f(serializer, "serializer");
        if (G(descriptor, i8)) {
            C(serializer, obj);
        }
    }

    @Override // n7.f
    public abstract void C(k7.k kVar, Object obj);

    @Override // n7.d
    public final n7.f D(m7.e descriptor, int i8) {
        AbstractC2304t.f(descriptor, "descriptor");
        return O(W(descriptor, i8), descriptor.h(i8));
    }

    @Override // n7.f
    public final void E(String value) {
        AbstractC2304t.f(value, "value");
        S(X(), value);
    }

    @Override // n7.d
    public final void F(m7.e descriptor, int i8, double d8) {
        AbstractC2304t.f(descriptor, "descriptor");
        L(W(descriptor, i8), d8);
    }

    public void H(k7.k kVar, Object obj) {
        f.a.c(this, kVar, obj);
    }

    public abstract void I(Object obj, boolean z7);

    public abstract void J(Object obj, byte b8);

    public abstract void K(Object obj, char c8);

    public abstract void L(Object obj, double d8);

    public abstract void M(Object obj, m7.e eVar, int i8);

    public abstract void N(Object obj, float f8);

    public n7.f O(Object obj, m7.e inlineDescriptor) {
        AbstractC2304t.f(inlineDescriptor, "inlineDescriptor");
        Y(obj);
        return this;
    }

    public abstract void P(Object obj, int i8);

    public abstract void Q(Object obj, long j8);

    public abstract void R(Object obj, short s8);

    public abstract void S(Object obj, String str);

    public abstract void T(m7.e eVar);

    public final Object U() {
        return p5.z.j0(this.f22097a);
    }

    public final Object V() {
        return p5.z.l0(this.f22097a);
    }

    public abstract Object W(m7.e eVar, int i8);

    public final Object X() {
        if (!(!this.f22097a.isEmpty())) {
            throw new k7.j("No tag in stack for requested element");
        }
        ArrayList arrayList = this.f22097a;
        return arrayList.remove(AbstractC2595q.k(arrayList));
    }

    public final void Y(Object obj) {
        this.f22097a.add(obj);
    }

    @Override // n7.d
    public final void d(m7.e descriptor) {
        AbstractC2304t.f(descriptor, "descriptor");
        if (!this.f22097a.isEmpty()) {
            X();
        }
        T(descriptor);
    }

    @Override // n7.f
    public n7.f e(m7.e descriptor) {
        AbstractC2304t.f(descriptor, "descriptor");
        return O(X(), descriptor);
    }

    @Override // n7.d
    public final void g(m7.e descriptor, int i8, String value) {
        AbstractC2304t.f(descriptor, "descriptor");
        AbstractC2304t.f(value, "value");
        S(W(descriptor, i8), value);
    }

    @Override // n7.f
    public final void h(double d8) {
        L(X(), d8);
    }

    @Override // n7.f
    public final void i(short s8) {
        R(X(), s8);
    }

    @Override // n7.f
    public final void j(byte b8) {
        J(X(), b8);
    }

    @Override // n7.f
    public final void k(boolean z7) {
        I(X(), z7);
    }

    @Override // n7.d
    public final void l(m7.e descriptor, int i8, int i9) {
        AbstractC2304t.f(descriptor, "descriptor");
        P(W(descriptor, i8), i9);
    }

    @Override // n7.f
    public final void m(float f8) {
        N(X(), f8);
    }

    @Override // n7.f
    public final void n(char c8) {
        K(X(), c8);
    }

    @Override // n7.d
    public final void p(m7.e descriptor, int i8, byte b8) {
        AbstractC2304t.f(descriptor, "descriptor");
        J(W(descriptor, i8), b8);
    }

    @Override // n7.d
    public final void r(m7.e descriptor, int i8, float f8) {
        AbstractC2304t.f(descriptor, "descriptor");
        N(W(descriptor, i8), f8);
    }

    @Override // n7.f
    public final void s(m7.e enumDescriptor, int i8) {
        AbstractC2304t.f(enumDescriptor, "enumDescriptor");
        M(X(), enumDescriptor, i8);
    }

    @Override // n7.d
    public final void t(m7.e descriptor, int i8, boolean z7) {
        AbstractC2304t.f(descriptor, "descriptor");
        I(W(descriptor, i8), z7);
    }

    @Override // n7.d
    public void u(m7.e descriptor, int i8, k7.k serializer, Object obj) {
        AbstractC2304t.f(descriptor, "descriptor");
        AbstractC2304t.f(serializer, "serializer");
        if (G(descriptor, i8)) {
            H(serializer, obj);
        }
    }

    @Override // n7.d
    public final void v(m7.e descriptor, int i8, short s8) {
        AbstractC2304t.f(descriptor, "descriptor");
        R(W(descriptor, i8), s8);
    }

    @Override // n7.f
    public final void w(int i8) {
        P(X(), i8);
    }

    @Override // n7.d
    public final void x(m7.e descriptor, int i8, long j8) {
        AbstractC2304t.f(descriptor, "descriptor");
        Q(W(descriptor, i8), j8);
    }

    @Override // n7.d
    public final void y(m7.e descriptor, int i8, char c8) {
        AbstractC2304t.f(descriptor, "descriptor");
        K(W(descriptor, i8), c8);
    }

    @Override // n7.f
    public n7.d z(m7.e eVar, int i8) {
        return f.a.a(this, eVar, i8);
    }
}
