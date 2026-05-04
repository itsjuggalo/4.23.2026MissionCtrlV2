package ch;

import ch.d;
import ch.f;
import dh.v0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import zg.j;
import zg.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements f, d {
    @Override // ch.f
    public void A(int i10) {
        I(Integer.valueOf(i10));
    }

    @Override // ch.f
    public void B(k kVar, Object obj) {
        f.a.d(this, kVar, obj);
    }

    @Override // ch.d
    public final void C(bh.e descriptor, int i10, boolean z10) {
        t.f(descriptor, "descriptor");
        if (G(descriptor, i10)) {
            m(z10);
        }
    }

    @Override // ch.f
    public void D(long j10) {
        I(Long.valueOf(j10));
    }

    @Override // ch.d
    public final void E(bh.e descriptor, int i10, byte b10) {
        t.f(descriptor, "descriptor");
        if (G(descriptor, i10)) {
            l(b10);
        }
    }

    @Override // ch.f
    public void F(String value) {
        t.f(value, "value");
        I(value);
    }

    public boolean G(bh.e descriptor, int i10) {
        t.f(descriptor, "descriptor");
        return true;
    }

    public void H(k kVar, Object obj) {
        f.a.c(this, kVar, obj);
    }

    public void I(Object value) {
        t.f(value, "value");
        throw new j("Non-serializable " + n0.b(value.getClass()) + " is not supported by " + n0.b(getClass()) + " encoder");
    }

    @Override // ch.f
    public d b(bh.e descriptor) {
        t.f(descriptor, "descriptor");
        return this;
    }

    @Override // ch.d
    public void c(bh.e descriptor) {
        t.f(descriptor, "descriptor");
    }

    @Override // ch.d
    public void e(bh.e descriptor, int i10, k serializer, Object obj) {
        t.f(descriptor, "descriptor");
        t.f(serializer, "serializer");
        if (G(descriptor, i10)) {
            H(serializer, obj);
        }
    }

    @Override // ch.f
    public void f() {
        throw new j("'null' is not supported by default");
    }

    @Override // ch.d
    public final void g(bh.e descriptor, int i10, float f10) {
        t.f(descriptor, "descriptor");
        if (G(descriptor, i10)) {
            p(f10);
        }
    }

    @Override // ch.d
    public final f h(bh.e descriptor, int i10) {
        t.f(descriptor, "descriptor");
        return G(descriptor, i10) ? v(descriptor.o(i10)) : v0.f8234a;
    }

    @Override // ch.d
    public final void i(bh.e descriptor, int i10, short s10) {
        t.f(descriptor, "descriptor");
        if (G(descriptor, i10)) {
            k(s10);
        }
    }

    @Override // ch.f
    public void j(double d10) {
        I(Double.valueOf(d10));
    }

    @Override // ch.f
    public void k(short s10) {
        I(Short.valueOf(s10));
    }

    @Override // ch.f
    public void l(byte b10) {
        I(Byte.valueOf(b10));
    }

    @Override // ch.f
    public void m(boolean z10) {
        I(Boolean.valueOf(z10));
    }

    @Override // ch.d
    public void n(bh.e descriptor, int i10, k serializer, Object obj) {
        t.f(descriptor, "descriptor");
        t.f(serializer, "serializer");
        if (G(descriptor, i10)) {
            B(serializer, obj);
        }
    }

    @Override // ch.d
    public boolean o(bh.e eVar, int i10) {
        return d.a.a(this, eVar, i10);
    }

    @Override // ch.f
    public void p(float f10) {
        I(Float.valueOf(f10));
    }

    @Override // ch.d
    public final void q(bh.e descriptor, int i10, double d10) {
        t.f(descriptor, "descriptor");
        if (G(descriptor, i10)) {
            j(d10);
        }
    }

    @Override // ch.d
    public final void r(bh.e descriptor, int i10, long j10) {
        t.f(descriptor, "descriptor");
        if (G(descriptor, i10)) {
            D(j10);
        }
    }

    @Override // ch.d
    public final void s(bh.e descriptor, int i10, char c10) {
        t.f(descriptor, "descriptor");
        if (G(descriptor, i10)) {
            t(c10);
        }
    }

    @Override // ch.f
    public void t(char c10) {
        I(Character.valueOf(c10));
    }

    @Override // ch.f
    public void u() {
        f.a.b(this);
    }

    @Override // ch.f
    public f v(bh.e descriptor) {
        t.f(descriptor, "descriptor");
        return this;
    }

    @Override // ch.d
    public final void w(bh.e descriptor, int i10, String value) {
        t.f(descriptor, "descriptor");
        t.f(value, "value");
        if (G(descriptor, i10)) {
            F(value);
        }
    }

    @Override // ch.d
    public final void x(bh.e descriptor, int i10, int i11) {
        t.f(descriptor, "descriptor");
        if (G(descriptor, i10)) {
            A(i11);
        }
    }

    @Override // ch.f
    public void y(bh.e enumDescriptor, int i10) {
        t.f(enumDescriptor, "enumDescriptor");
        I(Integer.valueOf(i10));
    }

    @Override // ch.f
    public d z(bh.e eVar, int i10) {
        return f.a.a(this, eVar, i10);
    }
}
