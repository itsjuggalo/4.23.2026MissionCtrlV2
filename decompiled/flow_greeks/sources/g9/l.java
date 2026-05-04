package g9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j9.f f10271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f10274d;

    public l(j9.f fVar, String str, String str2, boolean z10) {
        this.f10271a = fVar;
        this.f10272b = str;
        this.f10273c = str2;
        this.f10274d = z10;
    }

    public j9.f a() {
        return this.f10271a;
    }

    public String b() {
        return this.f10273c;
    }

    public String c() {
        return this.f10272b;
    }

    public boolean d() {
        return this.f10274d;
    }

    public String toString() {
        return "DatabaseInfo(databaseId:" + this.f10271a + " host:" + this.f10273c + ")";
    }
}
