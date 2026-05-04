package e8;

import j8.d0;
import j8.u;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f8504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j8.l f8505b;

    public m(r8.n nVar) {
        this(new u(nVar), new j8.l(""));
    }

    public String a() {
        if (this.f8505b.A() != null) {
            return this.f8505b.A().b();
        }
        return null;
    }

    public r8.n b() {
        return this.f8504a.a(this.f8505b);
    }

    public Object c() {
        return b().getValue();
    }

    public void d(Object obj) {
        d0.g(this.f8505b, obj);
        Object objB = n8.a.b(obj);
        m8.n.k(objB);
        this.f8504a.c(this.f8505b, r8.o.a(objB));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f8504a.equals(mVar.f8504a) && this.f8505b.equals(mVar.f8505b);
    }

    public String toString() {
        r8.b bVarK = this.f8505b.K();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("MutableData { key = ");
        sb2.append(bVarK != null ? bVarK.b() : "<none>");
        sb2.append(", value = ");
        sb2.append(this.f8504a.b().N(true));
        sb2.append(" }");
        return sb2.toString();
    }

    public m(u uVar, j8.l lVar) {
        this.f8504a = uVar;
        this.f8505b = lVar;
        d0.g(lVar, c());
    }
}
