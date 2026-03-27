package I3;

import F3.g;
import I3.c;
import I3.e;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements e, c {
    @Override // I3.e
    public int A(H3.e enumDescriptor) {
        r.f(enumDescriptor, "enumDescriptor");
        Object objJ = J();
        r.d(objJ, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objJ).intValue();
    }

    @Override // I3.c
    public int B(H3.e eVar) {
        return c.a.a(this, eVar);
    }

    @Override // I3.e
    public abstract byte C();

    @Override // I3.c
    public final byte D(H3.e descriptor, int i4) {
        r.f(descriptor, "descriptor");
        return C();
    }

    @Override // I3.c
    public final float E(H3.e descriptor, int i4) {
        r.f(descriptor, "descriptor");
        return G();
    }

    @Override // I3.e
    public abstract short F();

    @Override // I3.e
    public float G() {
        Object objJ = J();
        r.d(objJ, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) objJ).floatValue();
    }

    @Override // I3.e
    public double H() {
        Object objJ = J();
        r.d(objJ, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) objJ).doubleValue();
    }

    public Object I(F3.a deserializer, Object obj) {
        r.f(deserializer, "deserializer");
        return p(deserializer);
    }

    public Object J() {
        throw new g(G.b(getClass()) + " can't retrieve untyped values");
    }

    @Override // I3.c
    public void c(H3.e descriptor) {
        r.f(descriptor, "descriptor");
    }

    @Override // I3.e
    public c d(H3.e descriptor) {
        r.f(descriptor, "descriptor");
        return this;
    }

    @Override // I3.e
    public boolean e() {
        Object objJ = J();
        r.d(objJ, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) objJ).booleanValue();
    }

    @Override // I3.e
    public char f() {
        Object objJ = J();
        r.d(objJ, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) objJ).charValue();
    }

    @Override // I3.e
    public e g(H3.e descriptor) {
        r.f(descriptor, "descriptor");
        return this;
    }

    @Override // I3.c
    public final int h(H3.e descriptor, int i4) {
        r.f(descriptor, "descriptor");
        return l();
    }

    @Override // I3.c
    public final long j(H3.e descriptor, int i4) {
        r.f(descriptor, "descriptor");
        return r();
    }

    @Override // I3.e
    public abstract int l();

    @Override // I3.c
    public Object m(H3.e descriptor, int i4, F3.a deserializer, Object obj) {
        r.f(descriptor, "descriptor");
        r.f(deserializer, "deserializer");
        return I(deserializer, obj);
    }

    @Override // I3.c
    public final boolean n(H3.e descriptor, int i4) {
        r.f(descriptor, "descriptor");
        return e();
    }

    @Override // I3.e
    public Void o() {
        return null;
    }

    @Override // I3.e
    public Object p(F3.a aVar) {
        return e.a.a(this, aVar);
    }

    @Override // I3.e
    public String q() {
        Object objJ = J();
        r.d(objJ, "null cannot be cast to non-null type kotlin.String");
        return (String) objJ;
    }

    @Override // I3.e
    public abstract long r();

    @Override // I3.c
    public e s(H3.e descriptor, int i4) {
        r.f(descriptor, "descriptor");
        return g(descriptor.i(i4));
    }

    @Override // I3.e
    public boolean t() {
        return true;
    }

    @Override // I3.c
    public final short u(H3.e descriptor, int i4) {
        r.f(descriptor, "descriptor");
        return F();
    }

    @Override // I3.c
    public final String v(H3.e descriptor, int i4) {
        r.f(descriptor, "descriptor");
        return q();
    }

    @Override // I3.c
    public boolean w() {
        return c.a.b(this);
    }

    @Override // I3.c
    public final char x(H3.e descriptor, int i4) {
        r.f(descriptor, "descriptor");
        return f();
    }

    @Override // I3.c
    public final Object y(H3.e descriptor, int i4, F3.a deserializer, Object obj) {
        r.f(descriptor, "descriptor");
        r.f(deserializer, "deserializer");
        return (deserializer.getDescriptor().c() || t()) ? I(deserializer, obj) : o();
    }

    @Override // I3.c
    public final double z(H3.e descriptor, int i4) {
        r.f(descriptor, "descriptor");
        return H();
    }
}
