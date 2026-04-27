package Y0;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f3550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f3551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f3552d;
    public Long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HashMap f3553f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f3554g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f3555h;
    public byte[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte[] f3556j;

    public final void a(String str, String str2) {
        HashMap map = this.f3553f;
        if (map == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map.put(str, str2);
    }

    public final i b() {
        String strJ = this.f3549a == null ? " transportName" : "";
        if (this.f3551c == null) {
            strJ = strJ.concat(" encodedPayload");
        }
        if (this.f3552d == null) {
            strJ = a3.d.j(strJ, " eventMillis");
        }
        if (this.e == null) {
            strJ = a3.d.j(strJ, " uptimeMillis");
        }
        if (this.f3553f == null) {
            strJ = a3.d.j(strJ, " autoMetadata");
        }
        if (strJ.isEmpty()) {
            return new i(this.f3549a, this.f3550b, this.f3551c, this.f3552d.longValue(), this.e.longValue(), this.f3553f, this.f3554g, this.f3555h, this.i, this.f3556j);
        }
        throw new IllegalStateException("Missing required properties:".concat(strJ));
    }
}
