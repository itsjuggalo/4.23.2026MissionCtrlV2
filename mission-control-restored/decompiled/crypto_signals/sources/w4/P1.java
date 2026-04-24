package w4;

import N1.C0094g0;
import a.AbstractC0284a;
import u4.AbstractC1222d;
import u4.AbstractC1240w;
import u4.C1219a;

/* JADX INFO: loaded from: classes.dex */
public final class P1 extends AbstractC1222d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C1219a f10985g = new C1219a("io.grpc.internal.RetryingNameResolver.RESOLUTION_RESULT_LISTENER_KEY");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractC1222d f10986d;
    public final C1340i e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l2.h f10987f;

    public P1(S s6, C1340i c1340i, l2.h hVar) {
        this.f10986d = s6;
        this.e = c1340i;
        this.f10987f = hVar;
    }

    @Override // u4.AbstractC1222d
    public String k() {
        return this.f10986d.k();
    }

    @Override // u4.AbstractC1222d
    public final void p() {
        this.f10986d.p();
    }

    @Override // u4.AbstractC1222d
    public final void r() {
        this.f10986d.r();
        C1340i c1340i = this.e;
        l2.h hVar = c1340i.f11281b;
        hVar.e();
        hVar.execute(new E3.d(c1340i, 25));
    }

    @Override // u4.AbstractC1222d
    public final void s(AbstractC1240w abstractC1240w) {
        this.f10986d.s(new O1(this, abstractC1240w));
    }

    public final String toString() {
        C0094g0 c0094g0J = AbstractC0284a.J(this);
        c0094g0J.a(this.f10986d, "delegate");
        return c0094g0J.toString();
    }
}
