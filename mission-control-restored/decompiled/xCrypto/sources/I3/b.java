package I3;

import F3.g;
import F3.h;
import I3.d;
import I3.f;
import J3.U;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements f, d {
    @Override // I3.d
    public final void A(H3.e descriptor, int i4, char c4) {
        r.f(descriptor, "descriptor");
        if (G(descriptor, i4)) {
            q(c4);
        }
    }

    @Override // I3.f
    public void B(int i4) {
        I(Integer.valueOf(i4));
    }

    @Override // I3.f
    public void C(H3.e enumDescriptor, int i4) {
        r.f(enumDescriptor, "enumDescriptor");
        I(Integer.valueOf(i4));
    }

    @Override // I3.f
    public void D(long j4) {
        I(Long.valueOf(j4));
    }

    @Override // I3.d
    public void E(H3.e descriptor, int i4, h serializer, Object obj) {
        r.f(descriptor, "descriptor");
        r.f(serializer, "serializer");
        if (G(descriptor, i4)) {
            H(serializer, obj);
        }
    }

    @Override // I3.f
    public void F(String value) {
        r.f(value, "value");
        I(value);
    }

    public boolean G(H3.e descriptor, int i4) {
        r.f(descriptor, "descriptor");
        return true;
    }

    public void H(h hVar, Object obj) {
        f.a.c(this, hVar, obj);
    }

    public void I(Object value) {
        r.f(value, "value");
        throw new g("Non-serializable " + G.b(value.getClass()) + " is not supported by " + G.b(getClass()) + " encoder");
    }

    @Override // I3.d
    public void c(H3.e descriptor) {
        r.f(descriptor, "descriptor");
    }

    @Override // I3.f
    public d d(H3.e descriptor) {
        r.f(descriptor, "descriptor");
        return this;
    }

    @Override // I3.f
    public void e() {
        throw new g("'null' is not supported by default");
    }

    @Override // I3.f
    public f f(H3.e descriptor) {
        r.f(descriptor, "descriptor");
        return this;
    }

    @Override // I3.d
    public final void g(H3.e descriptor, int i4, double d4) {
        r.f(descriptor, "descriptor");
        if (G(descriptor, i4)) {
            h(d4);
        }
    }

    @Override // I3.f
    public void h(double d4) {
        I(Double.valueOf(d4));
    }

    @Override // I3.f
    public void i(short s4) {
        I(Short.valueOf(s4));
    }

    @Override // I3.d
    public boolean j(H3.e eVar, int i4) {
        return d.a.a(this, eVar, i4);
    }

    @Override // I3.d
    public final void k(H3.e descriptor, int i4, int i5) {
        r.f(descriptor, "descriptor");
        if (G(descriptor, i4)) {
            B(i5);
        }
    }

    @Override // I3.d
    public final void l(H3.e descriptor, int i4, long j4) {
        r.f(descriptor, "descriptor");
        if (G(descriptor, i4)) {
            D(j4);
        }
    }

    @Override // I3.f
    public void m(byte b4) {
        I(Byte.valueOf(b4));
    }

    @Override // I3.f
    public void n(boolean z4) {
        I(Boolean.valueOf(z4));
    }

    @Override // I3.d
    public final void o(H3.e descriptor, int i4, String value) {
        r.f(descriptor, "descriptor");
        r.f(value, "value");
        if (G(descriptor, i4)) {
            F(value);
        }
    }

    @Override // I3.f
    public void p(float f4) {
        I(Float.valueOf(f4));
    }

    @Override // I3.f
    public void q(char c4) {
        I(Character.valueOf(c4));
    }

    @Override // I3.f
    public void r() {
        f.a.b(this);
    }

    @Override // I3.d
    public final f s(H3.e descriptor, int i4) {
        r.f(descriptor, "descriptor");
        return G(descriptor, i4) ? f(descriptor.i(i4)) : U.f890a;
    }

    @Override // I3.d
    public final void t(H3.e descriptor, int i4, float f4) {
        r.f(descriptor, "descriptor");
        if (G(descriptor, i4)) {
            p(f4);
        }
    }

    @Override // I3.d
    public void u(H3.e descriptor, int i4, h serializer, Object obj) {
        r.f(descriptor, "descriptor");
        r.f(serializer, "serializer");
        if (G(descriptor, i4)) {
            z(serializer, obj);
        }
    }

    @Override // I3.f
    public d v(H3.e eVar, int i4) {
        return f.a.a(this, eVar, i4);
    }

    @Override // I3.d
    public final void w(H3.e descriptor, int i4, byte b4) {
        r.f(descriptor, "descriptor");
        if (G(descriptor, i4)) {
            m(b4);
        }
    }

    @Override // I3.d
    public final void x(H3.e descriptor, int i4, short s4) {
        r.f(descriptor, "descriptor");
        if (G(descriptor, i4)) {
            i(s4);
        }
    }

    @Override // I3.d
    public final void y(H3.e descriptor, int i4, boolean z4) {
        r.f(descriptor, "descriptor");
        if (G(descriptor, i4)) {
            n(z4);
        }
    }

    @Override // I3.f
    public void z(h hVar, Object obj) {
        f.a.d(this, hVar, obj);
    }
}
