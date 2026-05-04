package u7;

import va.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class m implements va.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f22303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f22304b;

    public m(c0 c0Var, a8.g gVar) {
        this.f22303a = c0Var;
        this.f22304b = new l(gVar);
    }

    @Override // va.c
    public boolean a() {
        return this.f22303a.d();
    }

    @Override // va.c
    public c.a b() {
        return c.a.f23219a;
    }

    @Override // va.c
    public void c(c.b bVar) {
        r7.g.f().b("App Quality Sessions session changed: " + bVar);
        this.f22304b.f(bVar.a());
    }

    public String d(String str) {
        return this.f22304b.c(str);
    }

    public void e(String str) {
        this.f22304b.g(str);
    }
}
