package r6;

import F5.AbstractC0556n;
import java.util.ArrayList;
import q6.f;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q0 implements q6.f, q6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f22920a = new ArrayList();

    private final boolean G(p6.e eVar, int i7) {
        Y(W(eVar, i7));
        return true;
    }

    @Override // q6.f
    public final void A(int i7) {
        P(X(), i7);
    }

    @Override // q6.f
    public final void B(long j7) {
        Q(X(), j7);
    }

    @Override // q6.d
    public final q6.f D(p6.e descriptor, int i7) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return O(W(descriptor, i7), descriptor.i(i7));
    }

    @Override // q6.d
    public final void E(p6.e descriptor, int i7, short s7) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        R(W(descriptor, i7), s7);
    }

    @Override // q6.f
    public final void F(String value) {
        kotlin.jvm.internal.r.f(value, "value");
        S(X(), value);
    }

    public void H(n6.h hVar, Object obj) {
        f.a.c(this, hVar, obj);
    }

    public abstract void I(Object obj, boolean z7);

    public abstract void J(Object obj, byte b7);

    public abstract void K(Object obj, char c7);

    public abstract void L(Object obj, double d7);

    public abstract void M(Object obj, p6.e eVar, int i7);

    public abstract void N(Object obj, float f7);

    public q6.f O(Object obj, p6.e inlineDescriptor) {
        kotlin.jvm.internal.r.f(inlineDescriptor, "inlineDescriptor");
        Y(obj);
        return this;
    }

    public abstract void P(Object obj, int i7);

    public abstract void Q(Object obj, long j7);

    public abstract void R(Object obj, short s7);

    public abstract void S(Object obj, String str);

    public abstract void T(p6.e eVar);

    public final Object U() {
        return F5.v.S(this.f22920a);
    }

    public final Object V() {
        return F5.v.T(this.f22920a);
    }

    public abstract Object W(p6.e eVar, int i7);

    public final Object X() {
        if (this.f22920a.isEmpty()) {
            throw new n6.g("No tag in stack for requested element");
        }
        ArrayList arrayList = this.f22920a;
        return arrayList.remove(AbstractC0556n.i(arrayList));
    }

    public final void Y(Object obj) {
        this.f22920a.add(obj);
    }

    @Override // q6.d
    public final void b(p6.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        if (!this.f22920a.isEmpty()) {
            X();
        }
        T(descriptor);
    }

    @Override // q6.d
    public final void f(p6.e descriptor, int i7, char c7) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        K(W(descriptor, i7), c7);
    }

    @Override // q6.f
    public final void g(double d7) {
        L(X(), d7);
    }

    @Override // q6.f
    public final void h(short s7) {
        R(X(), s7);
    }

    @Override // q6.d
    public final void i(p6.e descriptor, int i7, byte b7) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        J(W(descriptor, i7), b7);
    }

    @Override // q6.f
    public final void j(byte b7) {
        J(X(), b7);
    }

    @Override // q6.f
    public final void k(boolean z7) {
        I(X(), z7);
    }

    @Override // q6.d
    public final void l(p6.e descriptor, int i7, double d7) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        L(W(descriptor, i7), d7);
    }

    @Override // q6.d
    public final void m(p6.e descriptor, int i7, String value) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        kotlin.jvm.internal.r.f(value, "value");
        S(W(descriptor, i7), value);
    }

    @Override // q6.f
    public final void n(float f7) {
        N(X(), f7);
    }

    @Override // q6.f
    public final void o(p6.e enumDescriptor, int i7) {
        kotlin.jvm.internal.r.f(enumDescriptor, "enumDescriptor");
        M(X(), enumDescriptor, i7);
    }

    @Override // q6.f
    public final void p(char c7) {
        K(X(), c7);
    }

    @Override // q6.d
    public void r(p6.e descriptor, int i7, n6.h serializer, Object obj) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        kotlin.jvm.internal.r.f(serializer, "serializer");
        if (G(descriptor, i7)) {
            H(serializer, obj);
        }
    }

    @Override // q6.f
    public abstract void s(n6.h hVar, Object obj);

    @Override // q6.d
    public final void t(p6.e descriptor, int i7, int i8) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        P(W(descriptor, i7), i8);
    }

    @Override // q6.f
    public q6.f u(p6.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return O(X(), descriptor);
    }

    @Override // q6.f
    public q6.d v(p6.e eVar, int i7) {
        return f.a.a(this, eVar, i7);
    }

    @Override // q6.d
    public final void w(p6.e descriptor, int i7, boolean z7) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        I(W(descriptor, i7), z7);
    }

    @Override // q6.d
    public void x(p6.e descriptor, int i7, n6.h serializer, Object obj) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        kotlin.jvm.internal.r.f(serializer, "serializer");
        if (G(descriptor, i7)) {
            s(serializer, obj);
        }
    }

    @Override // q6.d
    public final void y(p6.e descriptor, int i7, long j7) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        Q(W(descriptor, i7), j7);
    }

    @Override // q6.d
    public final void z(p6.e descriptor, int i7, float f7) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        N(W(descriptor, i7), f7);
    }
}
