package m;

/* JADX INFO: renamed from: m.p0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0836p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8422d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8423f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8424g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8425h;

    public final void a(int i, int i6) {
        this.f8421c = i;
        this.f8422d = i6;
        this.f8425h = true;
        if (this.f8424g) {
            if (i6 != Integer.MIN_VALUE) {
                this.f8419a = i6;
            }
            if (i != Integer.MIN_VALUE) {
                this.f8420b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f8419a = i;
        }
        if (i6 != Integer.MIN_VALUE) {
            this.f8420b = i6;
        }
    }
}
