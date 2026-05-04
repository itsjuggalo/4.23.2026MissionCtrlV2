package a5;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f83a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f84b;

    public f() {
        this.f83a = Boolean.FALSE;
    }

    public final f a(String str) {
        this.f84b = str;
        return this;
    }

    public f(g gVar) {
        this.f83a = Boolean.FALSE;
        this.f83a = Boolean.valueOf(gVar.b());
        this.f84b = gVar.c();
    }
}
