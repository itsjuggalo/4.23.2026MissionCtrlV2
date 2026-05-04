package r8;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f19428c = new m(b.l(), g.y());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f19429d = new m(b.k(), n.P);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f19430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f19431b;

    public m(b bVar, n nVar) {
        this.f19430a = bVar;
        this.f19431b = nVar;
    }

    public static m a() {
        return f19429d;
    }

    public static m b() {
        return f19428c;
    }

    public b c() {
        return this.f19430a;
    }

    public n d() {
        return this.f19431b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return this.f19430a.equals(mVar.f19430a) && this.f19431b.equals(mVar.f19431b);
    }

    public int hashCode() {
        return (this.f19430a.hashCode() * 31) + this.f19431b.hashCode();
    }

    public String toString() {
        return "NamedNode{name=" + this.f19430a + ", node=" + this.f19431b + '}';
    }
}
