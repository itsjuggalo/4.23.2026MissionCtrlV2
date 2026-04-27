package H3;

import G3.y;
import K3.AbstractC0612b;
import Q2.s;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public class j implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C2105D f2651a;

    public j(C2105D c2105d) {
        AbstractC0612b.d(y.B(c2105d), "NumericIncrementTransformOperation expects a NumberValue operand", new Object[0]);
        this.f2651a = c2105d;
    }

    @Override // H3.p
    public C2105D a(C2105D c2105d) {
        return y.B(c2105d) ? c2105d : (C2105D) C2105D.y0().D(0L).n();
    }

    @Override // H3.p
    public C2105D c(C2105D c2105d, s sVar) {
        C2105D c2105dA = a(c2105d);
        if (y.w(c2105dA) && y.w(this.f2651a)) {
            return (C2105D) C2105D.y0().D(g(c2105dA.r0(), f())).n();
        }
        if (y.w(c2105dA)) {
            return (C2105D) C2105D.y0().B(c2105dA.r0() + e()).n();
        }
        AbstractC0612b.d(y.v(c2105dA), "Expected NumberValue to be of type DoubleValue, but was ", c2105d.getClass().getCanonicalName());
        return (C2105D) C2105D.y0().B(c2105dA.p0() + e()).n();
    }

    public C2105D d() {
        return this.f2651a;
    }

    public final double e() {
        if (y.v(this.f2651a)) {
            return this.f2651a.p0();
        }
        if (y.w(this.f2651a)) {
            return this.f2651a.r0();
        }
        throw AbstractC0612b.a("Expected 'operand' to be of Number type, but was " + this.f2651a.getClass().getCanonicalName(), new Object[0]);
    }

    public final long f() {
        if (y.v(this.f2651a)) {
            return (long) this.f2651a.p0();
        }
        if (y.w(this.f2651a)) {
            return this.f2651a.r0();
        }
        throw AbstractC0612b.a("Expected 'operand' to be of Number type, but was " + this.f2651a.getClass().getCanonicalName(), new Object[0]);
    }

    public final long g(long j7, long j8) {
        long j9 = j7 + j8;
        return ((j7 ^ j9) & (j8 ^ j9)) >= 0 ? j9 : j9 >= 0 ? Long.MIN_VALUE : Long.MAX_VALUE;
    }

    @Override // H3.p
    public C2105D b(C2105D c2105d, C2105D c2105d2) {
        return c2105d2;
    }
}
