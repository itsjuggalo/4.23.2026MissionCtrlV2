package I;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f596d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f597f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f598g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f599h;
    public int i;

    public final float a(long j4) {
        if (j4 < this.e) {
            return 0.0f;
        }
        long j6 = this.f598g;
        if (j6 < 0 || j4 < j6) {
            return e.b((j4 - r0) / this.f593a, 0.0f, 1.0f) * 0.5f;
        }
        float f6 = this.f599h;
        return (e.b((j4 - j6) / this.i, 0.0f, 1.0f) * f6) + (1.0f - f6);
    }
}
