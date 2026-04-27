package t2;

import java.util.List;

/* JADX INFO: renamed from: t2.C, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1115C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9938d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f9939f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f9940g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f9941h;
    public List i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte f9942j;

    public final C1116D a() {
        String str;
        if (this.f9942j == 63 && (str = this.f9936b) != null) {
            return new C1116D(this.f9935a, str, this.f9937c, this.f9938d, this.e, this.f9939f, this.f9940g, this.f9941h, this.i);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f9942j & 1) == 0) {
            sb.append(" pid");
        }
        if (this.f9936b == null) {
            sb.append(" processName");
        }
        if ((this.f9942j & 2) == 0) {
            sb.append(" reasonCode");
        }
        if ((this.f9942j & 4) == 0) {
            sb.append(" importance");
        }
        if ((this.f9942j & 8) == 0) {
            sb.append(" pss");
        }
        if ((this.f9942j & 16) == 0) {
            sb.append(" rss");
        }
        if ((this.f9942j & 32) == 0) {
            sb.append(" timestamp");
        }
        throw new IllegalStateException(a3.d.l("Missing required properties:", sb));
    }
}
