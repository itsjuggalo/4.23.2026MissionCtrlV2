package n7;

import k7.j;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.O;
import n7.c;
import n7.e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements e, c {
    @Override // n7.c
    public final boolean A(m7.e descriptor, int i8) {
        AbstractC2304t.f(descriptor, "descriptor");
        return g();
    }

    @Override // n7.c
    public final char B(m7.e descriptor, int i8) {
        AbstractC2304t.f(descriptor, "descriptor");
        return h();
    }

    @Override // n7.c
    public final long C(m7.e descriptor, int i8) {
        AbstractC2304t.f(descriptor, "descriptor");
        return s();
    }

    @Override // n7.e
    public abstract byte D();

    @Override // n7.e
    public abstract short F();

    @Override // n7.e
    public float G() {
        Object objJ = J();
        AbstractC2304t.d(objJ, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) objJ).floatValue();
    }

    @Override // n7.e
    public double H() {
        Object objJ = J();
        AbstractC2304t.d(objJ, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) objJ).doubleValue();
    }

    public Object I(k7.a deserializer, Object obj) {
        AbstractC2304t.f(deserializer, "deserializer");
        return v(deserializer);
    }

    public Object J() {
        throw new j(O.b(getClass()) + " can't retrieve untyped values");
    }

    @Override // n7.e
    public c c(m7.e descriptor) {
        AbstractC2304t.f(descriptor, "descriptor");
        return this;
    }

    @Override // n7.c
    public void d(m7.e descriptor) {
        AbstractC2304t.f(descriptor, "descriptor");
    }

    @Override // n7.e
    public e e(m7.e descriptor) {
        AbstractC2304t.f(descriptor, "descriptor");
        return this;
    }

    @Override // n7.c
    public final double f(m7.e descriptor, int i8) {
        AbstractC2304t.f(descriptor, "descriptor");
        return H();
    }

    @Override // n7.e
    public boolean g() {
        Object objJ = J();
        AbstractC2304t.d(objJ, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) objJ).booleanValue();
    }

    @Override // n7.e
    public char h() {
        Object objJ = J();
        AbstractC2304t.d(objJ, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) objJ).charValue();
    }

    @Override // n7.e
    public int i(m7.e enumDescriptor) {
        AbstractC2304t.f(enumDescriptor, "enumDescriptor");
        Object objJ = J();
        AbstractC2304t.d(objJ, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objJ).intValue();
    }

    @Override // n7.c
    public final String j(m7.e descriptor, int i8) {
        AbstractC2304t.f(descriptor, "descriptor");
        return q();
    }

    @Override // n7.c
    public int k(m7.e eVar) {
        return c.a.a(this, eVar);
    }

    @Override // n7.e
    public abstract int m();

    @Override // n7.c
    public final float n(m7.e descriptor, int i8) {
        AbstractC2304t.f(descriptor, "descriptor");
        return G();
    }

    @Override // n7.e
    public Void o() {
        return null;
    }

    @Override // n7.c
    public e p(m7.e descriptor, int i8) {
        AbstractC2304t.f(descriptor, "descriptor");
        return e(descriptor.h(i8));
    }

    @Override // n7.e
    public String q() {
        Object objJ = J();
        AbstractC2304t.d(objJ, "null cannot be cast to non-null type kotlin.String");
        return (String) objJ;
    }

    @Override // n7.c
    public final byte r(m7.e descriptor, int i8) {
        AbstractC2304t.f(descriptor, "descriptor");
        return D();
    }

    @Override // n7.e
    public abstract long s();

    @Override // n7.e
    public boolean t() {
        return true;
    }

    @Override // n7.c
    public Object u(m7.e descriptor, int i8, k7.a deserializer, Object obj) {
        AbstractC2304t.f(descriptor, "descriptor");
        AbstractC2304t.f(deserializer, "deserializer");
        return I(deserializer, obj);
    }

    @Override // n7.e
    public Object v(k7.a aVar) {
        return e.a.a(this, aVar);
    }

    @Override // n7.c
    public boolean w() {
        return c.a.b(this);
    }

    @Override // n7.c
    public final short x(m7.e descriptor, int i8) {
        AbstractC2304t.f(descriptor, "descriptor");
        return F();
    }

    @Override // n7.c
    public final int y(m7.e descriptor, int i8) {
        AbstractC2304t.f(descriptor, "descriptor");
        return m();
    }

    @Override // n7.c
    public final Object z(m7.e descriptor, int i8, k7.a deserializer, Object obj) {
        AbstractC2304t.f(descriptor, "descriptor");
        AbstractC2304t.f(deserializer, "deserializer");
        return (deserializer.getDescriptor().c() || t()) ? I(deserializer, obj) : o();
    }
}
