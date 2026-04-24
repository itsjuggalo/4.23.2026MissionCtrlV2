package G1;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f2418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2419b;

    public f() {
        this.f2418a = Boolean.FALSE;
    }

    public final f a(String str) {
        this.f2419b = str;
        return this;
    }

    public f(g gVar) {
        this.f2418a = Boolean.FALSE;
        g.b(gVar);
        this.f2418a = Boolean.valueOf(gVar.f2422b);
        this.f2419b = gVar.f2423c;
    }
}
