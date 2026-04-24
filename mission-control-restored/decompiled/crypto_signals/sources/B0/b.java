package B0;

/* JADX INFO: loaded from: classes.dex */
public final class b implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f77c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f78d;
    public static final b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f79f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f80k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b f81l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f82a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f83b;

    static {
        int i = 0;
        f77c = new b("NONE", i);
        f78d = new b("FULL", i);
        int i6 = 1;
        e = new b("FLAT", i6);
        f79f = new b("HALF_OPENED", i6);
        int i7 = 2;
        f80k = new b("FOLD", i7);
        f81l = new b("HINGE", i7);
    }

    public /* synthetic */ b(String str, int i) {
        this.f82a = i;
        this.f83b = str;
    }

    public String toString() {
        switch (this.f82a) {
            case 0:
                return (String) this.f83b;
            case 1:
                return (String) this.f83b;
            case 2:
                return (String) this.f83b;
            default:
                return super.toString();
        }
    }

    public b(C0.a aVar) {
        this.f82a = 3;
        int i = o.f110b;
        this.f83b = aVar;
    }
}
