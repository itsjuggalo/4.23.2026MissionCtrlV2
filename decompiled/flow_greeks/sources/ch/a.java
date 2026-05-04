package ch;

import ch.c;
import ch.e;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import zg.j;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements e, c {
    @Override // ch.e
    public e A(bh.e descriptor) {
        t.f(descriptor, "descriptor");
        return this;
    }

    @Override // ch.c
    public final boolean B(bh.e descriptor, int i10) {
        t.f(descriptor, "descriptor");
        return e();
    }

    @Override // ch.c
    public final int C(bh.e descriptor, int i10) {
        t.f(descriptor, "descriptor");
        return j();
    }

    @Override // ch.e
    public abstract byte D();

    @Override // ch.e
    public Object E(zg.a aVar) {
        return e.a.a(this, aVar);
    }

    @Override // ch.e
    public abstract short F();

    @Override // ch.e
    public float G() {
        Object objJ = J();
        t.d(objJ, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) objJ).floatValue();
    }

    @Override // ch.e
    public double H() {
        Object objJ = J();
        t.d(objJ, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) objJ).doubleValue();
    }

    public Object I(zg.a deserializer, Object obj) {
        t.f(deserializer, "deserializer");
        return E(deserializer);
    }

    public Object J() {
        throw new j(n0.b(getClass()) + " can't retrieve untyped values");
    }

    @Override // ch.e
    public c b(bh.e descriptor) {
        t.f(descriptor, "descriptor");
        return this;
    }

    @Override // ch.c
    public void c(bh.e descriptor) {
        t.f(descriptor, "descriptor");
    }

    @Override // ch.e
    public boolean e() {
        Object objJ = J();
        t.d(objJ, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) objJ).booleanValue();
    }

    @Override // ch.e
    public char f() {
        Object objJ = J();
        t.d(objJ, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) objJ).charValue();
    }

    @Override // ch.c
    public final long g(bh.e descriptor, int i10) {
        t.f(descriptor, "descriptor");
        return q();
    }

    @Override // ch.c
    public Object h(bh.e descriptor, int i10, zg.a deserializer, Object obj) {
        t.f(descriptor, "descriptor");
        t.f(deserializer, "deserializer");
        return I(deserializer, obj);
    }

    @Override // ch.e
    public abstract int j();

    @Override // ch.c
    public final double k(bh.e descriptor, int i10) {
        t.f(descriptor, "descriptor");
        return H();
    }

    @Override // ch.e
    public Void l() {
        return null;
    }

    @Override // ch.e
    public String m() {
        Object objJ = J();
        t.d(objJ, "null cannot be cast to non-null type kotlin.String");
        return (String) objJ;
    }

    @Override // ch.c
    public final Object n(bh.e descriptor, int i10, zg.a deserializer, Object obj) {
        t.f(descriptor, "descriptor");
        t.f(deserializer, "deserializer");
        return (deserializer.getDescriptor().j() || t()) ? I(deserializer, obj) : l();
    }

    @Override // ch.c
    public int o(bh.e eVar) {
        return c.a.a(this, eVar);
    }

    @Override // ch.c
    public final float p(bh.e descriptor, int i10) {
        t.f(descriptor, "descriptor");
        return G();
    }

    @Override // ch.e
    public abstract long q();

    @Override // ch.c
    public final byte r(bh.e descriptor, int i10) {
        t.f(descriptor, "descriptor");
        return D();
    }

    @Override // ch.c
    public final String s(bh.e descriptor, int i10) {
        t.f(descriptor, "descriptor");
        return m();
    }

    @Override // ch.e
    public boolean t() {
        return true;
    }

    @Override // ch.c
    public final short u(bh.e descriptor, int i10) {
        t.f(descriptor, "descriptor");
        return F();
    }

    @Override // ch.c
    public e v(bh.e descriptor, int i10) {
        t.f(descriptor, "descriptor");
        return A(descriptor.o(i10));
    }

    @Override // ch.e
    public int x(bh.e enumDescriptor) {
        t.f(enumDescriptor, "enumDescriptor");
        Object objJ = J();
        t.d(objJ, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objJ).intValue();
    }

    @Override // ch.c
    public final char y(bh.e descriptor, int i10) {
        t.f(descriptor, "descriptor");
        return f();
    }

    @Override // ch.c
    public boolean z() {
        return c.a.b(this);
    }
}
