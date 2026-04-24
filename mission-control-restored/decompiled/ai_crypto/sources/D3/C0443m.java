package D3;

/* JADX INFO: renamed from: D3.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0443m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f1363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final G3.h f1364b;

    /* JADX INFO: renamed from: D3.m$a */
    public enum a {
        REMOVED,
        ADDED,
        MODIFIED,
        METADATA
    }

    public C0443m(a aVar, G3.h hVar) {
        this.f1363a = aVar;
        this.f1364b = hVar;
    }

    public static C0443m a(a aVar, G3.h hVar) {
        return new C0443m(aVar, hVar);
    }

    public G3.h b() {
        return this.f1364b;
    }

    public a c() {
        return this.f1363a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0443m)) {
            return false;
        }
        C0443m c0443m = (C0443m) obj;
        return this.f1363a.equals(c0443m.f1363a) && this.f1364b.equals(c0443m.f1364b);
    }

    public int hashCode() {
        return ((((1891 + this.f1363a.hashCode()) * 31) + this.f1364b.getKey().hashCode()) * 31) + this.f1364b.getData().hashCode();
    }

    public String toString() {
        return "DocumentViewChange(" + this.f1364b + com.amazon.a.a.o.b.f.f9989a + this.f1363a + ")";
    }
}
