package j8;

import o8.e;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e0 extends i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f13971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e8.s f13972e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o8.i f13973f;

    public e0(n nVar, e8.s sVar, o8.i iVar) {
        this.f13971d = nVar;
        this.f13972e = sVar;
        this.f13973f = iVar;
    }

    @Override // j8.i
    public i a(o8.i iVar) {
        return new e0(this.f13971d, this.f13972e, iVar);
    }

    @Override // j8.i
    public o8.d b(o8.c cVar, o8.i iVar) {
        return new o8.d(e.a.VALUE, this, e8.k.a(e8.k.c(this.f13971d, iVar.e()), cVar.k()), null);
    }

    @Override // j8.i
    public void c(e8.c cVar) {
        this.f13972e.onCancelled(cVar);
    }

    @Override // j8.i
    public void d(o8.d dVar) {
        if (h()) {
            return;
        }
        this.f13972e.onDataChange(dVar.e());
    }

    @Override // j8.i
    public o8.i e() {
        return this.f13973f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return e0Var.f13972e.equals(this.f13972e) && e0Var.f13971d.equals(this.f13971d) && e0Var.f13973f.equals(this.f13973f);
    }

    @Override // j8.i
    public boolean f(i iVar) {
        return (iVar instanceof e0) && ((e0) iVar).f13972e.equals(this.f13972e);
    }

    public int hashCode() {
        return (((this.f13972e.hashCode() * 31) + this.f13971d.hashCode()) * 31) + this.f13973f.hashCode();
    }

    @Override // j8.i
    public boolean i(e.a aVar) {
        return aVar == e.a.VALUE;
    }

    public String toString() {
        return "ValueEventRegistration";
    }
}
