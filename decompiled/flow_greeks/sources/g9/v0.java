package g9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f10386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j9.k f10387b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum a {
        ADDED,
        REMOVED
    }

    public v0(a aVar, j9.k kVar) {
        this.f10386a = aVar;
        this.f10387b = kVar;
    }

    public j9.k a() {
        return this.f10387b;
    }

    public a b() {
        return this.f10386a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof v0)) {
            return false;
        }
        v0 v0Var = (v0) obj;
        return this.f10386a.equals(v0Var.b()) && this.f10387b.equals(v0Var.a());
    }

    public int hashCode() {
        return ((2077 + this.f10386a.hashCode()) * 31) + this.f10387b.hashCode();
    }
}
