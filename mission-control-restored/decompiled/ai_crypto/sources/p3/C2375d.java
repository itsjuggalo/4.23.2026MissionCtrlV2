package p3;

/* JADX INFO: renamed from: p3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2375d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f21500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f21501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f21502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f21503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f21504e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double f21505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final double f21506g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f21507h;

    /* JADX INFO: renamed from: p3.d$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f21508a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f21509b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f21510c;

        public a(boolean z7, boolean z8, boolean z9) {
            this.f21508a = z7;
            this.f21509b = z8;
            this.f21510c = z9;
        }
    }

    /* JADX INFO: renamed from: p3.d$b */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f21512b;

        public b(int i7, int i8) {
            this.f21511a = i7;
            this.f21512b = i8;
        }
    }

    public C2375d(long j7, b bVar, a aVar, int i7, int i8, double d7, double d8, int i9) {
        this.f21502c = j7;
        this.f21500a = bVar;
        this.f21501b = aVar;
        this.f21503d = i7;
        this.f21504e = i8;
        this.f21505f = d7;
        this.f21506g = d8;
        this.f21507h = i9;
    }

    public boolean a(long j7) {
        return this.f21502c < j7;
    }
}
