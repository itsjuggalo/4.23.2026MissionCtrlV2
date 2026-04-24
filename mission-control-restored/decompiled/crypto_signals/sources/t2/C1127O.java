package t2;

/* JADX INFO: renamed from: t2.O, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1127O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C1129Q f10002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C1143c0 f10003d;
    public C1145d0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C1153h0 f10004f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte f10005g;

    public final C1128P a() {
        String str;
        C1129Q c1129q;
        C1143c0 c1143c0;
        if (this.f10005g == 1 && (str = this.f10001b) != null && (c1129q = this.f10002c) != null && (c1143c0 = this.f10003d) != null) {
            return new C1128P(this.f10000a, str, c1129q, c1143c0, this.e, this.f10004f);
        }
        StringBuilder sb = new StringBuilder();
        if ((1 & this.f10005g) == 0) {
            sb.append(" timestamp");
        }
        if (this.f10001b == null) {
            sb.append(" type");
        }
        if (this.f10002c == null) {
            sb.append(" app");
        }
        if (this.f10003d == null) {
            sb.append(" device");
        }
        throw new IllegalStateException(a3.d.l("Missing required properties:", sb));
    }
}
