package t2;

/* JADX INFO: renamed from: t2.M, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1125M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f9988d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f9989f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9990g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f9991h;
    public String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte f9992j;

    public final C1126N a() {
        String str;
        String str2;
        String str3;
        if (this.f9992j == 63 && (str = this.f9986b) != null && (str2 = this.f9991h) != null && (str3 = this.i) != null) {
            return new C1126N(this.f9985a, str, this.f9987c, this.f9988d, this.e, this.f9989f, this.f9990g, str2, str3);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f9992j & 1) == 0) {
            sb.append(" arch");
        }
        if (this.f9986b == null) {
            sb.append(" model");
        }
        if ((this.f9992j & 2) == 0) {
            sb.append(" cores");
        }
        if ((this.f9992j & 4) == 0) {
            sb.append(" ram");
        }
        if ((this.f9992j & 8) == 0) {
            sb.append(" diskSpace");
        }
        if ((this.f9992j & 16) == 0) {
            sb.append(" simulator");
        }
        if ((this.f9992j & 32) == 0) {
            sb.append(" state");
        }
        if (this.f9991h == null) {
            sb.append(" manufacturer");
        }
        if (this.i == null) {
            sb.append(" modelClass");
        }
        throw new IllegalStateException(a3.d.l("Missing required properties:", sb));
    }
}
