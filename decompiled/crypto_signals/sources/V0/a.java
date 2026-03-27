package V0;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f3182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f3183c;

    public a(Object obj, d dVar, b bVar) {
        this.f3181a = obj;
        this.f3182b = dVar;
        this.f3183c = bVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            aVar.getClass();
            if (this.f3181a.equals(aVar.f3181a) && this.f3182b.equals(aVar.f3182b)) {
                b bVar = aVar.f3183c;
                b bVar2 = this.f3183c;
                if (bVar2 != null ? bVar2.equals(bVar) : bVar == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((((1000003 * 1000003) ^ this.f3181a.hashCode()) * 1000003) ^ this.f3182b.hashCode()) * 1000003;
        b bVar = this.f3183c;
        return (iHashCode ^ (bVar == null ? 0 : bVar.hashCode())) * 1000003;
    }

    public final String toString() {
        return "Event{code=null, payload=" + this.f3181a + ", priority=" + this.f3182b + ", productData=" + this.f3183c + ", eventContext=null}";
    }
}
