package p1;

/* JADX INFO: renamed from: p1.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1691f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f13989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13990b;

    public C1691f() {
        this.f13989a = Boolean.FALSE;
    }

    public final C1691f a(String str) {
        this.f13990b = str;
        return this;
    }

    public C1691f(C1692g c1692g) {
        this.f13989a = Boolean.FALSE;
        C1692g.b(c1692g);
        this.f13989a = Boolean.valueOf(c1692g.f13993b);
        this.f13990b = c1692g.f13994c;
    }
}
