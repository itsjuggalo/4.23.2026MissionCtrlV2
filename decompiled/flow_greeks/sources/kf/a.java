package kf;

import dd.r;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import xf.a2;
import xf.c1;
import xf.q1;
import yf.g;
import zf.h;
import zf.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends c1 implements bg.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a2 f14844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f14845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f14846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q1 f14847e;

    public /* synthetic */ a(a2 a2Var, b bVar, boolean z10, q1 q1Var, int i10, k kVar) {
        this(a2Var, (i10 & 2) != 0 ? new c(a2Var) : bVar, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? q1.f25042b.k() : q1Var);
    }

    @Override // xf.r0
    public List L0() {
        return r.k();
    }

    @Override // xf.r0
    public q1 M0() {
        return this.f14847e;
    }

    @Override // xf.r0
    public boolean O0() {
        return this.f14846d;
    }

    @Override // xf.l2
    /* JADX INFO: renamed from: V0 */
    public c1 T0(q1 newAttributes) {
        t.f(newAttributes, "newAttributes");
        return new a(this.f14844b, N0(), O0(), newAttributes);
    }

    @Override // xf.r0
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public b N0() {
        return this.f14845c;
    }

    @Override // xf.c1
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public a R0(boolean z10) {
        return z10 == O0() ? this : new a(this.f14844b, N0(), z10, M0());
    }

    @Override // xf.l2
    /* JADX INFO: renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public a X0(g kotlinTypeRefiner) {
        t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        a2 a2VarA = this.f14844b.a(kotlinTypeRefiner);
        t.e(a2VarA, "refine(...)");
        return new a(a2VarA, N0(), O0(), M0());
    }

    @Override // xf.r0
    public qf.k q() {
        return l.a(h.f26477b, true, new String[0]);
    }

    @Override // xf.c1
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Captured(");
        sb2.append(this.f14844b);
        sb2.append(')');
        sb2.append(O0() ? "?" : "");
        return sb2.toString();
    }

    public a(a2 typeProjection, b constructor, boolean z10, q1 attributes) {
        t.f(typeProjection, "typeProjection");
        t.f(constructor, "constructor");
        t.f(attributes, "attributes");
        this.f14844b = typeProjection;
        this.f14845c = constructor;
        this.f14846d = z10;
        this.f14847e = attributes;
    }
}
