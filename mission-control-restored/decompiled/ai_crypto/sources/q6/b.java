package q6;

import kotlin.jvm.internal.H;
import kotlin.jvm.internal.r;
import n6.g;
import n6.h;
import q6.d;
import q6.f;
import r6.U;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements f, d {
    @Override // q6.f
    public void A(int i7) {
        I(Integer.valueOf(i7));
    }

    @Override // q6.f
    public void B(long j7) {
        I(Long.valueOf(j7));
    }

    @Override // q6.d
    public boolean C(p6.e eVar, int i7) {
        return d.a.a(this, eVar, i7);
    }

    @Override // q6.d
    public final f D(p6.e descriptor, int i7) {
        r.f(descriptor, "descriptor");
        return G(descriptor, i7) ? u(descriptor.i(i7)) : U.f22847a;
    }

    @Override // q6.d
    public final void E(p6.e descriptor, int i7, short s7) {
        r.f(descriptor, "descriptor");
        if (G(descriptor, i7)) {
            h(s7);
        }
    }

    @Override // q6.f
    public void F(String value) {
        r.f(value, "value");
        I(value);
    }

    public boolean G(p6.e descriptor, int i7) {
        r.f(descriptor, "descriptor");
        return true;
    }

    public void H(h hVar, Object obj) {
        f.a.c(this, hVar, obj);
    }

    public void I(Object value) {
        r.f(value, "value");
        throw new g("Non-serializable " + H.b(value.getClass()) + " is not supported by " + H.b(getClass()) + " encoder");
    }

    @Override // q6.d
    public void b(p6.e descriptor) {
        r.f(descriptor, "descriptor");
    }

    @Override // q6.f
    public d c(p6.e descriptor) {
        r.f(descriptor, "descriptor");
        return this;
    }

    @Override // q6.f
    public void e() {
        throw new g("'null' is not supported by default");
    }

    @Override // q6.d
    public final void f(p6.e descriptor, int i7, char c7) {
        r.f(descriptor, "descriptor");
        if (G(descriptor, i7)) {
            p(c7);
        }
    }

    @Override // q6.f
    public void g(double d7) {
        I(Double.valueOf(d7));
    }

    @Override // q6.f
    public void h(short s7) {
        I(Short.valueOf(s7));
    }

    @Override // q6.d
    public final void i(p6.e descriptor, int i7, byte b7) {
        r.f(descriptor, "descriptor");
        if (G(descriptor, i7)) {
            j(b7);
        }
    }

    @Override // q6.f
    public void j(byte b7) {
        I(Byte.valueOf(b7));
    }

    @Override // q6.f
    public void k(boolean z7) {
        I(Boolean.valueOf(z7));
    }

    @Override // q6.d
    public final void l(p6.e descriptor, int i7, double d7) {
        r.f(descriptor, "descriptor");
        if (G(descriptor, i7)) {
            g(d7);
        }
    }

    @Override // q6.d
    public final void m(p6.e descriptor, int i7, String value) {
        r.f(descriptor, "descriptor");
        r.f(value, "value");
        if (G(descriptor, i7)) {
            F(value);
        }
    }

    @Override // q6.f
    public void n(float f7) {
        I(Float.valueOf(f7));
    }

    @Override // q6.f
    public void o(p6.e enumDescriptor, int i7) {
        r.f(enumDescriptor, "enumDescriptor");
        I(Integer.valueOf(i7));
    }

    @Override // q6.f
    public void p(char c7) {
        I(Character.valueOf(c7));
    }

    @Override // q6.f
    public void q() {
        f.a.b(this);
    }

    @Override // q6.d
    public void r(p6.e descriptor, int i7, h serializer, Object obj) {
        r.f(descriptor, "descriptor");
        r.f(serializer, "serializer");
        if (G(descriptor, i7)) {
            H(serializer, obj);
        }
    }

    @Override // q6.f
    public void s(h hVar, Object obj) {
        f.a.d(this, hVar, obj);
    }

    @Override // q6.d
    public final void t(p6.e descriptor, int i7, int i8) {
        r.f(descriptor, "descriptor");
        if (G(descriptor, i7)) {
            A(i8);
        }
    }

    @Override // q6.f
    public f u(p6.e descriptor) {
        r.f(descriptor, "descriptor");
        return this;
    }

    @Override // q6.f
    public d v(p6.e eVar, int i7) {
        return f.a.a(this, eVar, i7);
    }

    @Override // q6.d
    public final void w(p6.e descriptor, int i7, boolean z7) {
        r.f(descriptor, "descriptor");
        if (G(descriptor, i7)) {
            k(z7);
        }
    }

    @Override // q6.d
    public void x(p6.e descriptor, int i7, h serializer, Object obj) {
        r.f(descriptor, "descriptor");
        r.f(serializer, "serializer");
        if (G(descriptor, i7)) {
            s(serializer, obj);
        }
    }

    @Override // q6.d
    public final void y(p6.e descriptor, int i7, long j7) {
        r.f(descriptor, "descriptor");
        if (G(descriptor, i7)) {
            B(j7);
        }
    }

    @Override // q6.d
    public final void z(p6.e descriptor, int i7, float f7) {
        r.f(descriptor, "descriptor");
        if (G(descriptor, i7)) {
            n(f7);
        }
    }
}
