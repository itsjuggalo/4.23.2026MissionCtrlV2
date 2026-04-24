package n7;

import k7.j;
import k7.k;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.O;
import n7.d;
import n7.f;
import o7.W;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements f, d {
    @Override // n7.f
    public void A(long j8) {
        I(Long.valueOf(j8));
    }

    @Override // n7.d
    public void B(m7.e descriptor, int i8, k serializer, Object obj) {
        AbstractC2304t.f(descriptor, "descriptor");
        AbstractC2304t.f(serializer, "serializer");
        if (G(descriptor, i8)) {
            C(serializer, obj);
        }
    }

    @Override // n7.f
    public void C(k kVar, Object obj) {
        f.a.d(this, kVar, obj);
    }

    @Override // n7.d
    public final f D(m7.e descriptor, int i8) {
        AbstractC2304t.f(descriptor, "descriptor");
        return G(descriptor, i8) ? e(descriptor.h(i8)) : W.f22146a;
    }

    @Override // n7.f
    public void E(String value) {
        AbstractC2304t.f(value, "value");
        I(value);
    }

    @Override // n7.d
    public final void F(m7.e descriptor, int i8, double d8) {
        AbstractC2304t.f(descriptor, "descriptor");
        if (G(descriptor, i8)) {
            h(d8);
        }
    }

    public boolean G(m7.e descriptor, int i8) {
        AbstractC2304t.f(descriptor, "descriptor");
        return true;
    }

    public void H(k kVar, Object obj) {
        f.a.c(this, kVar, obj);
    }

    public void I(Object value) {
        AbstractC2304t.f(value, "value");
        throw new j("Non-serializable " + O.b(value.getClass()) + " is not supported by " + O.b(getClass()) + " encoder");
    }

    @Override // n7.f
    public d c(m7.e descriptor) {
        AbstractC2304t.f(descriptor, "descriptor");
        return this;
    }

    @Override // n7.d
    public void d(m7.e descriptor) {
        AbstractC2304t.f(descriptor, "descriptor");
    }

    @Override // n7.f
    public f e(m7.e descriptor) {
        AbstractC2304t.f(descriptor, "descriptor");
        return this;
    }

    @Override // n7.f
    public void f() {
        throw new j("'null' is not supported by default");
    }

    @Override // n7.d
    public final void g(m7.e descriptor, int i8, String value) {
        AbstractC2304t.f(descriptor, "descriptor");
        AbstractC2304t.f(value, "value");
        if (G(descriptor, i8)) {
            E(value);
        }
    }

    @Override // n7.f
    public void h(double d8) {
        I(Double.valueOf(d8));
    }

    @Override // n7.f
    public void i(short s8) {
        I(Short.valueOf(s8));
    }

    @Override // n7.f
    public void j(byte b8) {
        I(Byte.valueOf(b8));
    }

    @Override // n7.f
    public void k(boolean z7) {
        I(Boolean.valueOf(z7));
    }

    @Override // n7.d
    public final void l(m7.e descriptor, int i8, int i9) {
        AbstractC2304t.f(descriptor, "descriptor");
        if (G(descriptor, i8)) {
            w(i9);
        }
    }

    @Override // n7.f
    public void m(float f8) {
        I(Float.valueOf(f8));
    }

    @Override // n7.f
    public void n(char c8) {
        I(Character.valueOf(c8));
    }

    @Override // n7.f
    public void o() {
        f.a.b(this);
    }

    @Override // n7.d
    public final void p(m7.e descriptor, int i8, byte b8) {
        AbstractC2304t.f(descriptor, "descriptor");
        if (G(descriptor, i8)) {
            j(b8);
        }
    }

    @Override // n7.d
    public boolean q(m7.e eVar, int i8) {
        return d.a.a(this, eVar, i8);
    }

    @Override // n7.d
    public final void r(m7.e descriptor, int i8, float f8) {
        AbstractC2304t.f(descriptor, "descriptor");
        if (G(descriptor, i8)) {
            m(f8);
        }
    }

    @Override // n7.f
    public void s(m7.e enumDescriptor, int i8) {
        AbstractC2304t.f(enumDescriptor, "enumDescriptor");
        I(Integer.valueOf(i8));
    }

    @Override // n7.d
    public final void t(m7.e descriptor, int i8, boolean z7) {
        AbstractC2304t.f(descriptor, "descriptor");
        if (G(descriptor, i8)) {
            k(z7);
        }
    }

    @Override // n7.d
    public void u(m7.e descriptor, int i8, k serializer, Object obj) {
        AbstractC2304t.f(descriptor, "descriptor");
        AbstractC2304t.f(serializer, "serializer");
        if (G(descriptor, i8)) {
            H(serializer, obj);
        }
    }

    @Override // n7.d
    public final void v(m7.e descriptor, int i8, short s8) {
        AbstractC2304t.f(descriptor, "descriptor");
        if (G(descriptor, i8)) {
            i(s8);
        }
    }

    @Override // n7.f
    public void w(int i8) {
        I(Integer.valueOf(i8));
    }

    @Override // n7.d
    public final void x(m7.e descriptor, int i8, long j8) {
        AbstractC2304t.f(descriptor, "descriptor");
        if (G(descriptor, i8)) {
            A(j8);
        }
    }

    @Override // n7.d
    public final void y(m7.e descriptor, int i8, char c8) {
        AbstractC2304t.f(descriptor, "descriptor");
        if (G(descriptor, i8)) {
            n(c8);
        }
    }

    @Override // n7.f
    public d z(m7.e eVar, int i8) {
        return f.a.a(this, eVar, i8);
    }
}
