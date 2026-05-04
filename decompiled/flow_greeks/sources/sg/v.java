package sg;

import ng.e1;
import ng.t0;
import ng.w0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends ng.k0 implements w0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w0 f20431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ng.k0 f20432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f20433e;

    /* JADX WARN: Multi-variable type inference failed */
    public v(ng.k0 k0Var, String str) {
        w0 w0Var = k0Var instanceof w0 ? (w0) k0Var : null;
        this.f20431c = w0Var == null ? t0.a() : w0Var;
        this.f20432d = k0Var;
        this.f20433e = str;
    }

    @Override // ng.w0
    public e1 K(long j10, Runnable runnable, gd.i iVar) {
        return this.f20431c.K(j10, runnable, iVar);
    }

    @Override // ng.k0
    public void Z(gd.i iVar, Runnable runnable) {
        this.f20432d.Z(iVar, runnable);
    }

    @Override // ng.k0
    public boolean a0(gd.i iVar) {
        return this.f20432d.a0(iVar);
    }

    @Override // ng.w0
    public void b(long j10, ng.n nVar) {
        this.f20431c.b(j10, nVar);
    }

    @Override // ng.k0
    public String toString() {
        return this.f20433e;
    }
}
