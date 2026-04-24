package t2;

/* JADX INFO: renamed from: t2.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1113A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f9917d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f9918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f9919g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f9920h;
    public String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public C1122J f9921j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public C1119G f9922k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public C1116D f9923l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte f9924m;

    public final C1114B a() {
        if (this.f9924m == 1 && this.f9914a != null && this.f9915b != null && this.f9917d != null && this.f9920h != null && this.i != null) {
            return new C1114B(this.f9914a, this.f9915b, this.f9916c, this.f9917d, this.e, this.f9918f, this.f9919g, this.f9920h, this.i, this.f9921j, this.f9922k, this.f9923l);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f9914a == null) {
            sb.append(" sdkVersion");
        }
        if (this.f9915b == null) {
            sb.append(" gmpAppId");
        }
        if ((1 & this.f9924m) == 0) {
            sb.append(" platform");
        }
        if (this.f9917d == null) {
            sb.append(" installationUuid");
        }
        if (this.f9920h == null) {
            sb.append(" buildVersion");
        }
        if (this.i == null) {
            sb.append(" displayVersion");
        }
        throw new IllegalStateException(a3.d.l("Missing required properties:", sb));
    }
}
