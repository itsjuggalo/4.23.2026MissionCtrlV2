package c8;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f3711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f3712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double f3716f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final double f3717g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f3718h;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f3719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f3720b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f3721c;

        public a(boolean z10, boolean z11, boolean z12) {
            this.f3719a = z10;
            this.f3720b = z11;
            this.f3721c = z12;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3723b;

        public b(int i10, int i11) {
            this.f3722a = i10;
            this.f3723b = i11;
        }
    }

    public d(long j10, b bVar, a aVar, int i10, int i11, double d10, double d11, int i12) {
        this.f3713c = j10;
        this.f3711a = bVar;
        this.f3712b = aVar;
        this.f3714d = i10;
        this.f3715e = i11;
        this.f3716f = d10;
        this.f3717g = d11;
        this.f3718h = i12;
    }

    public boolean a(long j10) {
        return this.f3713c < j10;
    }
}
