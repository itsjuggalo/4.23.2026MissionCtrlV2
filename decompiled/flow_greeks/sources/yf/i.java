package yf;

import fe.l1;
import java.util.List;
import xf.a2;
import xf.c1;
import xf.l2;
import xf.q1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends c1 implements bg.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bg.b f25406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f25407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l2 f25408d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q1 f25409e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f25410f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f25411g;

    public /* synthetic */ i(bg.b bVar, n nVar, l2 l2Var, q1 q1Var, boolean z10, boolean z11, int i10, kotlin.jvm.internal.k kVar) {
        this(bVar, nVar, l2Var, (i10 & 8) != 0 ? q1.f25042b.k() : q1Var, (i10 & 16) != 0 ? false : z10, (i10 & 32) != 0 ? false : z11);
    }

    @Override // xf.r0
    public List L0() {
        return dd.r.k();
    }

    @Override // xf.r0
    public q1 M0() {
        return this.f25409e;
    }

    @Override // xf.r0
    public boolean O0() {
        return this.f25410f;
    }

    @Override // xf.l2
    /* JADX INFO: renamed from: V0 */
    public c1 T0(q1 newAttributes) {
        kotlin.jvm.internal.t.f(newAttributes, "newAttributes");
        return new i(this.f25406b, N0(), this.f25408d, newAttributes, O0(), this.f25411g);
    }

    public final bg.b W0() {
        return this.f25406b;
    }

    @Override // xf.r0
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public n N0() {
        return this.f25407c;
    }

    public final l2 Y0() {
        return this.f25408d;
    }

    public final boolean Z0() {
        return this.f25411g;
    }

    @Override // xf.c1
    /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
    public i R0(boolean z10) {
        return new i(this.f25406b, N0(), this.f25408d, M0(), z10, false, 32, null);
    }

    @Override // xf.l2
    /* JADX INFO: renamed from: b1, reason: merged with bridge method [inline-methods] */
    public i X0(g kotlinTypeRefiner) {
        kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        bg.b bVar = this.f25406b;
        n nVarA = N0().a(kotlinTypeRefiner);
        l2 l2Var = this.f25408d;
        return new i(bVar, nVarA, l2Var != null ? kotlinTypeRefiner.a(l2Var).Q0() : null, M0(), O0(), false, 32, null);
    }

    @Override // xf.r0
    public qf.k q() {
        return zf.l.a(zf.h.f26477b, true, new String[0]);
    }

    public i(bg.b captureStatus, n constructor, l2 l2Var, q1 attributes, boolean z10, boolean z11) {
        kotlin.jvm.internal.t.f(captureStatus, "captureStatus");
        kotlin.jvm.internal.t.f(constructor, "constructor");
        kotlin.jvm.internal.t.f(attributes, "attributes");
        this.f25406b = captureStatus;
        this.f25407c = constructor;
        this.f25408d = l2Var;
        this.f25409e = attributes;
        this.f25410f = z10;
        this.f25411g = z11;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(bg.b captureStatus, l2 l2Var, a2 projection, l1 typeParameter) {
        this(captureStatus, new n(projection, null, null, typeParameter, 6, null), l2Var, null, false, false, 56, null);
        kotlin.jvm.internal.t.f(captureStatus, "captureStatus");
        kotlin.jvm.internal.t.f(projection, "projection");
        kotlin.jvm.internal.t.f(typeParameter, "typeParameter");
    }
}
