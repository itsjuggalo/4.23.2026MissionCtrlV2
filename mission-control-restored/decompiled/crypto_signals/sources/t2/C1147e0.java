package t2;

/* JADX INFO: renamed from: t2.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1147e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C1151g0 f10094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f10097d;
    public byte e;

    public final C1149f0 a() {
        C1151g0 c1151g0;
        String str;
        String str2;
        if (this.e == 1 && (c1151g0 = this.f10094a) != null && (str = this.f10095b) != null && (str2 = this.f10096c) != null) {
            return new C1149f0(c1151g0, str, str2, this.f10097d);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f10094a == null) {
            sb.append(" rolloutVariant");
        }
        if (this.f10095b == null) {
            sb.append(" parameterKey");
        }
        if (this.f10096c == null) {
            sb.append(" parameterValue");
        }
        if ((1 & this.e) == 0) {
            sb.append(" templateVersion");
        }
        throw new IllegalStateException(a3.d.l("Missing required properties:", sb));
    }
}
