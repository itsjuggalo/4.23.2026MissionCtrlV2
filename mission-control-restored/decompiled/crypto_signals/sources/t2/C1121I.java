package t2;

import java.util.List;

/* JADX INFO: renamed from: t2.I, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1121I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f9961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f9962d;
    public Long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f9963f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public C1123K f9964g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public C1159k0 f9965h;
    public C1157j0 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public C1126N f9966j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f9967k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f9968l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte f9969m;

    public final C1122J a() {
        String str;
        String str2;
        C1123K c1123k;
        if (this.f9969m == 7 && (str = this.f9959a) != null && (str2 = this.f9960b) != null && (c1123k = this.f9964g) != null) {
            return new C1122J(str, str2, this.f9961c, this.f9962d, this.e, this.f9963f, c1123k, this.f9965h, this.i, this.f9966j, this.f9967k, this.f9968l);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f9959a == null) {
            sb.append(" generator");
        }
        if (this.f9960b == null) {
            sb.append(" identifier");
        }
        if ((this.f9969m & 1) == 0) {
            sb.append(" startedAt");
        }
        if ((this.f9969m & 2) == 0) {
            sb.append(" crashed");
        }
        if (this.f9964g == null) {
            sb.append(" app");
        }
        if ((this.f9969m & 4) == 0) {
            sb.append(" generatorType");
        }
        throw new IllegalStateException(a3.d.l("Missing required properties:", sb));
    }
}
