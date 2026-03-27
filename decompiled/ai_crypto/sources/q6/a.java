package q6;

import kotlin.jvm.internal.H;
import kotlin.jvm.internal.r;
import n6.g;
import q6.c;
import q6.e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements e, c {
    @Override // q6.c
    public Object A(p6.e descriptor, int i7, n6.a deserializer, Object obj) {
        r.f(descriptor, "descriptor");
        r.f(deserializer, "deserializer");
        return I(deserializer, obj);
    }

    @Override // q6.c
    public final short B(p6.e descriptor, int i7) {
        r.f(descriptor, "descriptor");
        return E();
    }

    @Override // q6.c
    public final char C(p6.e descriptor, int i7) {
        r.f(descriptor, "descriptor");
        return g();
    }

    @Override // q6.e
    public abstract byte D();

    @Override // q6.e
    public abstract short E();

    @Override // q6.e
    public float F() {
        Object objJ = J();
        r.d(objJ, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) objJ).floatValue();
    }

    @Override // q6.e
    public double G() {
        Object objJ = J();
        r.d(objJ, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) objJ).doubleValue();
    }

    @Override // q6.c
    public final boolean H(p6.e descriptor, int i7) {
        r.f(descriptor, "descriptor");
        return f();
    }

    public Object I(n6.a deserializer, Object obj) {
        r.f(deserializer, "deserializer");
        return l(deserializer);
    }

    public Object J() {
        throw new g(H.b(getClass()) + " can't retrieve untyped values");
    }

    @Override // q6.c
    public void b(p6.e descriptor) {
        r.f(descriptor, "descriptor");
    }

    @Override // q6.e
    public c c(p6.e descriptor) {
        r.f(descriptor, "descriptor");
        return this;
    }

    @Override // q6.c
    public final int e(p6.e descriptor, int i7) {
        r.f(descriptor, "descriptor");
        return k();
    }

    @Override // q6.e
    public boolean f() {
        Object objJ = J();
        r.d(objJ, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) objJ).booleanValue();
    }

    @Override // q6.e
    public char g() {
        Object objJ = J();
        r.d(objJ, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) objJ).charValue();
    }

    @Override // q6.e
    public int h(p6.e enumDescriptor) {
        r.f(enumDescriptor, "enumDescriptor");
        Object objJ = J();
        r.d(objJ, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objJ).intValue();
    }

    @Override // q6.c
    public final float i(p6.e descriptor, int i7) {
        r.f(descriptor, "descriptor");
        return F();
    }

    @Override // q6.e
    public abstract int k();

    @Override // q6.e
    public Object l(n6.a aVar) {
        return e.a.a(this, aVar);
    }

    @Override // q6.e
    public Void m() {
        return null;
    }

    @Override // q6.c
    public int n(p6.e eVar) {
        return c.a.a(this, eVar);
    }

    @Override // q6.e
    public String o() {
        Object objJ = J();
        r.d(objJ, "null cannot be cast to non-null type kotlin.String");
        return (String) objJ;
    }

    @Override // q6.c
    public final byte p(p6.e descriptor, int i7) {
        r.f(descriptor, "descriptor");
        return D();
    }

    @Override // q6.e
    public abstract long r();

    @Override // q6.c
    public e s(p6.e descriptor, int i7) {
        r.f(descriptor, "descriptor");
        return x(descriptor.i(i7));
    }

    @Override // q6.e
    public boolean t() {
        return true;
    }

    @Override // q6.c
    public final double u(p6.e descriptor, int i7) {
        r.f(descriptor, "descriptor");
        return G();
    }

    @Override // q6.c
    public final String v(p6.e descriptor, int i7) {
        r.f(descriptor, "descriptor");
        return o();
    }

    @Override // q6.c
    public boolean w() {
        return c.a.b(this);
    }

    @Override // q6.e
    public e x(p6.e descriptor) {
        r.f(descriptor, "descriptor");
        return this;
    }

    @Override // q6.c
    public final Object y(p6.e descriptor, int i7, n6.a deserializer, Object obj) {
        r.f(descriptor, "descriptor");
        r.f(deserializer, "deserializer");
        return (deserializer.getDescriptor().c() || t()) ? I(deserializer, obj) : m();
    }

    @Override // q6.c
    public final long z(p6.e descriptor, int i7) {
        r.f(descriptor, "descriptor");
        return r();
    }
}
