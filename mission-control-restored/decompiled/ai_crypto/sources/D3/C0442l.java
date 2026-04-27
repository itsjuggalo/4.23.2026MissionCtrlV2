package D3;

/* JADX INFO: renamed from: D3.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0442l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G3.f f1352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f1355d;

    public C0442l(G3.f fVar, String str, String str2, boolean z7) {
        this.f1352a = fVar;
        this.f1353b = str;
        this.f1354c = str2;
        this.f1355d = z7;
    }

    public G3.f a() {
        return this.f1352a;
    }

    public String b() {
        return this.f1354c;
    }

    public String c() {
        return this.f1353b;
    }

    public boolean d() {
        return this.f1355d;
    }

    public String toString() {
        return "DatabaseInfo(databaseId:" + this.f1352a + " host:" + this.f1354c + ")";
    }
}
