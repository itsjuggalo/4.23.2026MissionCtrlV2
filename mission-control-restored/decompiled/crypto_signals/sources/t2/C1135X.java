package t2;

/* JADX INFO: renamed from: t2.X, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1135X {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f10039d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte f10040f;

    public final C1136Y a() {
        String str;
        if (this.f10040f == 7 && (str = this.f10037b) != null) {
            return new C1136Y(this.f10036a, str, this.f10038c, this.f10039d, this.e);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f10040f & 1) == 0) {
            sb.append(" pc");
        }
        if (this.f10037b == null) {
            sb.append(" symbol");
        }
        if ((this.f10040f & 2) == 0) {
            sb.append(" offset");
        }
        if ((this.f10040f & 4) == 0) {
            sb.append(" importance");
        }
        throw new IllegalStateException(a3.d.l("Missing required properties:", sb));
    }
}
