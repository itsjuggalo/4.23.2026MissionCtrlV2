package l8;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f15545a;

    public c(long j10) {
        this.f15545a = j10;
    }

    @Override // l8.a
    public boolean a(long j10, long j11) {
        return j10 > this.f15545a || j11 > 1000;
    }

    @Override // l8.a
    public long b() {
        return 1000L;
    }

    @Override // l8.a
    public float c() {
        return 0.2f;
    }

    @Override // l8.a
    public boolean d(long j10) {
        return j10 > 1000;
    }
}
