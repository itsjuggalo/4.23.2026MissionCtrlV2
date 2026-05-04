package m9;

import bb.f0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import n9.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b1 extends c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final com.google.protobuf.i f16123v = com.google.protobuf.i.f6998b;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final o0 f16124s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f16125t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public com.google.protobuf.i f16126u;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a extends u0 {
        void c(j9.v vVar, List list);

        void d();
    }

    public b1(y yVar, n9.g gVar, o0 o0Var, a aVar) {
        super(yVar, bb.r.e(), gVar, g.d.WRITE_STREAM_CONNECTION_BACKOFF, g.d.WRITE_STREAM_IDLE, g.d.HEALTH_CHECK_TIMEOUT, aVar);
        this.f16125t = false;
        this.f16126u = f16123v;
        this.f16124s = o0Var;
    }

    @Override // m9.c
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public void q(bb.g0 g0Var) {
        this.f16126u = g0Var.c0();
        this.f16143l.e();
        j9.v vVarY = this.f16124s.y(g0Var.a0());
        int iE0 = g0Var.e0();
        ArrayList arrayList = new ArrayList(iE0);
        for (int i10 = 0; i10 < iE0; i10++) {
            arrayList.add(this.f16124s.p(g0Var.d0(i10), vVarY));
        }
        ((a) this.f16144m).c(vVarY, arrayList);
    }

    public void B(com.google.protobuf.i iVar) {
        this.f16126u = (com.google.protobuf.i) n9.x.b(iVar);
    }

    public void C() {
        n9.b.d(m(), "Writing handshake requires an opened stream", new Object[0]);
        n9.b.d(!this.f16125t, "Handshake already completed", new Object[0]);
        w((bb.f0) bb.f0.g0().y(this.f16124s.a()).n());
    }

    public void D(List list) {
        n9.b.d(m(), "Writing mutations requires an opened stream", new Object[0]);
        n9.b.d(this.f16125t, "Handshake must be complete before writing mutations", new Object[0]);
        f0.b bVarG0 = bb.f0.g0();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            bVarG0.x(this.f16124s.O((k9.f) it.next()));
        }
        bVarG0.z(this.f16126u);
        w((bb.f0) bVarG0.n());
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
    public void t() {
        this.f16125t = false;
        super.t();
    }

    @Override // m9.c
    public /* bridge */ /* synthetic */ void u() {
        super.u();
    }

    @Override // m9.c
    public void v() {
        if (this.f16125t) {
            D(Collections.EMPTY_LIST);
        }
    }

    public com.google.protobuf.i x() {
        return this.f16126u;
    }

    public boolean y() {
        return this.f16125t;
    }

    @Override // m9.c
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void p(bb.g0 g0Var) {
        this.f16126u = g0Var.c0();
        this.f16125t = true;
        ((a) this.f16144m).d();
    }
}
