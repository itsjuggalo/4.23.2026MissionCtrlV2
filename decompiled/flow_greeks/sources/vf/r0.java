package vf;

import fe.g1;
import fe.j1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tf.w0;
import ze.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class r0 extends ie.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final tf.p f23492k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ze.s f23493l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f23494m;

    /* JADX WARN: Illegal instructions before constructor call */
    public r0(tf.p c10, ze.s proto, int i10) {
        kotlin.jvm.internal.t.f(c10, "c");
        kotlin.jvm.internal.t.f(proto, "proto");
        wf.n nVarH = c10.h();
        fe.m mVarE = c10.e();
        ge.h hVarB = ge.h.L.b();
        ef.f fVarB = tf.l0.b(c10.g(), proto.N());
        tf.o0 o0Var = tf.o0.f22025a;
        s.c cVarT = proto.T();
        kotlin.jvm.internal.t.e(cVarT, "getVariance(...)");
        super(nVarH, mVarE, hVarB, fVarB, o0Var.d(cVarT), proto.O(), i10, g1.f9483a, j1.a.f9488a);
        this.f23492k = c10;
        this.f23493l = proto;
        this.f23494m = new a(c10.h(), new q0(this));
    }

    public static final List N0(r0 r0Var) {
        return dd.a0.I0(r0Var.f23492k.c().d().b(r0Var.f23493l, r0Var.f23492k.g()));
    }

    @Override // ie.h
    public List L0() {
        List listS = bf.f.s(this.f23493l, this.f23492k.j());
        if (listS.isEmpty()) {
            return dd.q.e(nf.e.m(this).z());
        }
        w0 w0VarI = this.f23492k.i();
        ArrayList arrayList = new ArrayList(dd.s.u(listS, 10));
        Iterator it = listS.iterator();
        while (it.hasNext()) {
            arrayList.add(w0VarI.u((ze.q) it.next()));
        }
        return arrayList;
    }

    @Override // ge.b, ge.a
    /* JADX INFO: renamed from: O0, reason: merged with bridge method [inline-methods] */
    public a getAnnotations() {
        return this.f23494m;
    }

    @Override // ie.h
    /* JADX INFO: renamed from: P0, reason: merged with bridge method [inline-methods] */
    public Void K0(xf.r0 type) {
        kotlin.jvm.internal.t.f(type, "type");
        throw new IllegalStateException("There should be no cycles for deserialized type parameters, but found for: " + this);
    }
}
