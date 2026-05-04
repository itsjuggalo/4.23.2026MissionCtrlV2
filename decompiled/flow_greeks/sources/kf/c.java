package kf;

import ce.i;
import dd.q;
import dd.r;
import fe.h;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.t;
import xf.a2;
import xf.m2;
import xf.r0;
import yf.g;
import yf.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a2 f14848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f14849b;

    public c(a2 projection) {
        t.f(projection, "projection");
        this.f14848a = projection;
        e().b();
        m2 m2Var = m2.f25015e;
    }

    @Override // xf.u1
    public /* bridge */ /* synthetic */ h b() {
        return (h) f();
    }

    @Override // xf.u1
    public Collection c() {
        r0 type = e().b() == m2.f25017g ? e().getType() : p().J();
        t.c(type);
        return q.e(type);
    }

    @Override // xf.u1
    public boolean d() {
        return false;
    }

    @Override // kf.b
    public a2 e() {
        return this.f14848a;
    }

    public Void f() {
        return null;
    }

    public final n g() {
        return this.f14849b;
    }

    @Override // xf.u1
    public List getParameters() {
        return r.k();
    }

    @Override // xf.u1
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public c a(g kotlinTypeRefiner) {
        t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        a2 a2VarA = e().a(kotlinTypeRefiner);
        t.e(a2VarA, "refine(...)");
        return new c(a2VarA);
    }

    public final void i(n nVar) {
        this.f14849b = nVar;
    }

    @Override // xf.u1
    public i p() {
        i iVarP = e().getType().N0().p();
        t.e(iVarP, "getBuiltIns(...)");
        return iVarP;
    }

    public String toString() {
        return "CapturedTypeConstructor(" + e() + ')';
    }
}
