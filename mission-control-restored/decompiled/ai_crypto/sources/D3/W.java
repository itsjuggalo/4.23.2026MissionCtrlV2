package D3;

/* JADX INFO: loaded from: classes.dex */
public class W {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f1239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final G3.k f1240b;

    public enum a {
        ADDED,
        REMOVED
    }

    public W(a aVar, G3.k kVar) {
        this.f1239a = aVar;
        this.f1240b = kVar;
    }

    public G3.k a() {
        return this.f1240b;
    }

    public a b() {
        return this.f1239a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof W)) {
            return false;
        }
        W w7 = (W) obj;
        return this.f1239a.equals(w7.b()) && this.f1240b.equals(w7.a());
    }

    public int hashCode() {
        return ((2077 + this.f1239a.hashCode()) * 31) + this.f1240b.hashCode();
    }
}
