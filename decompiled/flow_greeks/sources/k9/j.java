package k9;

import a7.s;
import bb.d0;
import j9.y;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class j implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d0 f14790a;

    public j(d0 d0Var) {
        n9.b.d(y.B(d0Var), "NumericIncrementTransformOperation expects a NumberValue operand", new Object[0]);
        this.f14790a = d0Var;
    }

    @Override // k9.p
    public d0 a(d0 d0Var) {
        return y.B(d0Var) ? d0Var : (d0) d0.y0().E(0L).n();
    }

    @Override // k9.p
    public d0 c(d0 d0Var, s sVar) {
        d0 d0VarA = a(d0Var);
        if (y.w(d0VarA) && y.w(this.f14790a)) {
            return (d0) d0.y0().E(g(d0VarA.r0(), f())).n();
        }
        if (y.w(d0VarA)) {
            return (d0) d0.y0().C(d0VarA.r0() + e()).n();
        }
        n9.b.d(y.v(d0VarA), "Expected NumberValue to be of type DoubleValue, but was ", d0Var.getClass().getCanonicalName());
        return (d0) d0.y0().C(d0VarA.p0() + e()).n();
    }

    public d0 d() {
        return this.f14790a;
    }

    public final double e() {
        if (y.v(this.f14790a)) {
            return this.f14790a.p0();
        }
        if (y.w(this.f14790a)) {
            return this.f14790a.r0();
        }
        throw n9.b.a("Expected 'operand' to be of Number type, but was " + this.f14790a.getClass().getCanonicalName(), new Object[0]);
    }

    public final long f() {
        if (y.v(this.f14790a)) {
            return (long) this.f14790a.p0();
        }
        if (y.w(this.f14790a)) {
            return this.f14790a.r0();
        }
        throw n9.b.a("Expected 'operand' to be of Number type, but was " + this.f14790a.getClass().getCanonicalName(), new Object[0]);
    }

    public final long g(long j10, long j11) {
        long j12 = j10 + j11;
        return ((j10 ^ j12) & (j11 ^ j12)) >= 0 ? j12 : j12 >= 0 ? Long.MIN_VALUE : Long.MAX_VALUE;
    }

    @Override // k9.p
    public d0 b(d0 d0Var, d0 d0Var2) {
        return d0Var2;
    }
}
