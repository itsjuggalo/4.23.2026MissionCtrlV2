package t2;

/* JADX INFO: renamed from: t2.Z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1137Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10048d;
    public byte e;

    public final C1139a0 a() {
        String str;
        if (this.e == 7 && (str = this.f10045a) != null) {
            return new C1139a0(this.f10046b, this.f10047c, str, this.f10048d);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f10045a == null) {
            sb.append(" processName");
        }
        if ((this.e & 1) == 0) {
            sb.append(" pid");
        }
        if ((this.e & 2) == 0) {
            sb.append(" importance");
        }
        if ((this.e & 4) == 0) {
            sb.append(" defaultProcess");
        }
        throw new IllegalStateException(a3.d.l("Missing required properties:", sb));
    }
}
