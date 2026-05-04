package m9;

import bb.s;
import i9.n4;
import java.util.Map;
import n9.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a1 extends c {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final com.google.protobuf.i f16118t = com.google.protobuf.i.f6998b;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final o0 f16119s;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a extends u0 {
        void e(j9.v vVar, y0 y0Var);
    }

    public a1(y yVar, n9.g gVar, o0 o0Var, a aVar) {
        super(yVar, bb.r.c(), gVar, g.d.LISTEN_STREAM_CONNECTION_BACKOFF, g.d.LISTEN_STREAM_IDLE, g.d.HEALTH_CHECK_TIMEOUT, aVar);
        this.f16119s = o0Var;
    }

    public void A(n4 n4Var) {
        n9.b.d(m(), "Watching queries requires an open stream", new Object[0]);
        s.b bVarY = bb.s.h0().z(this.f16119s.a()).y(this.f16119s.V(n4Var));
        Map mapN = this.f16119s.N(n4Var);
        if (mapN != null) {
            bVarY.x(mapN);
        }
        w((bb.s) bVarY.n());
    }

    @Override // m9.c
    public /* bridge */ /* synthetic */ void l() {
        super.l();
    }

    @Override // m9.c
    public /* bridge */ /* synthetic */ boolean m() {
        return super.m();
    }

    @Override // m9.c
    public /* bridge */ /* synthetic */ boolean n() {
        return super.n();
    }

    @Override // m9.c
    public /* bridge */ /* synthetic */ void t() {
        super.t();
    }

    @Override // m9.c
    public /* bridge */ /* synthetic */ void u() {
        super.u();
    }

    @Override // m9.c
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void p(bb.t tVar) {
        q(tVar);
    }

    @Override // m9.c
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void q(bb.t tVar) {
        this.f16143l.e();
        y0 y0VarA = this.f16119s.A(tVar);
        ((a) this.f16144m).e(this.f16119s.z(tVar), y0VarA);
    }

    public void z(int i10) {
        n9.b.d(m(), "Unwatching targets requires an open stream", new Object[0]);
        w((bb.s) bb.s.h0().z(this.f16119s.a()).A(i10).n());
    }
}
