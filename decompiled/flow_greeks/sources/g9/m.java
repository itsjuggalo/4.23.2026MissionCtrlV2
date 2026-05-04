package g9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f10277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j9.h f10278b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum a {
        REMOVED,
        ADDED,
        MODIFIED,
        METADATA
    }

    public m(a aVar, j9.h hVar) {
        this.f10277a = aVar;
        this.f10278b = hVar;
    }

    public static m a(a aVar, j9.h hVar) {
        return new m(aVar, hVar);
    }

    public j9.h b() {
        return this.f10278b;
    }

    public a c() {
        return this.f10277a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f10277a.equals(mVar.f10277a) && this.f10278b.equals(mVar.f10278b);
    }

    public int hashCode() {
        return ((((1891 + this.f10277a.hashCode()) * 31) + this.f10278b.getKey().hashCode()) * 31) + this.f10278b.getData().hashCode();
    }

    public String toString() {
        return "DocumentViewChange(" + this.f10278b + com.amazon.a.a.o.b.f.f4598a + this.f10277a + ")";
    }
}
