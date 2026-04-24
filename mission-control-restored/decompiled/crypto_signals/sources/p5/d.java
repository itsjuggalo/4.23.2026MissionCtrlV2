package p5;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final long[] e = new long[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n5.d f9069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r5.e f9070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f9071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long[] f9072d;

    public d(n5.d descriptor, r5.e eVar) {
        kotlin.jvm.internal.j.e(descriptor, "descriptor");
        this.f9069a = descriptor;
        this.f9070b = eVar;
        int iD = descriptor.d();
        if (iD <= 64) {
            this.f9071c = iD != 64 ? (-1) << iD : 0L;
            this.f9072d = e;
            return;
        }
        this.f9071c = 0L;
        int i = (iD - 1) >>> 6;
        long[] jArr = new long[i];
        if ((iD & 63) != 0) {
            jArr[i - 1] = (-1) << iD;
        }
        this.f9072d = jArr;
    }
}
