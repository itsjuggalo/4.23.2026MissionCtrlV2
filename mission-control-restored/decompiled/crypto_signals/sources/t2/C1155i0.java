package t2;

/* JADX INFO: renamed from: t2.i0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1155i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10127d;
    public byte e;

    public final C1157j0 a() {
        String str;
        String str2;
        if (this.e == 3 && (str = this.f10125b) != null && (str2 = this.f10126c) != null) {
            return new C1157j0(this.f10124a, str, str2, this.f10127d);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.e & 1) == 0) {
            sb.append(" platform");
        }
        if (this.f10125b == null) {
            sb.append(" version");
        }
        if (this.f10126c == null) {
            sb.append(" buildVersion");
        }
        if ((this.e & 2) == 0) {
            sb.append(" jailbroken");
        }
        throw new IllegalStateException(a3.d.l("Missing required properties:", sb));
    }
}
