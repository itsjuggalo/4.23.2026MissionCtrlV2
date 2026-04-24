package Z2;

import a3.d;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f3987d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f3988f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f3989g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte f3990h;

    public final b a() {
        if (this.f3990h == 3 && this.f3985b != 0) {
            return new b(this.f3984a, this.f3985b, this.f3986c, this.f3987d, this.e, this.f3988f, this.f3989g);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f3985b == 0) {
            sb.append(" registrationStatus");
        }
        if ((this.f3990h & 1) == 0) {
            sb.append(" expiresInSecs");
        }
        if ((this.f3990h & 2) == 0) {
            sb.append(" tokenCreationEpochInSecs");
        }
        throw new IllegalStateException(d.l("Missing required properties:", sb));
    }
}
