package t2;

/* JADX INFO: renamed from: t2.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1141b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Double f10065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10068d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f10069f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte f10070g;

    public final C1143c0 a() {
        if (this.f10070g == 31) {
            return new C1143c0(this.f10065a, this.f10066b, this.f10067c, this.f10068d, this.e, this.f10069f);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f10070g & 1) == 0) {
            sb.append(" batteryVelocity");
        }
        if ((this.f10070g & 2) == 0) {
            sb.append(" proximityOn");
        }
        if ((this.f10070g & 4) == 0) {
            sb.append(" orientation");
        }
        if ((this.f10070g & 8) == 0) {
            sb.append(" ramUsed");
        }
        if ((this.f10070g & 16) == 0) {
            sb.append(" diskUsed");
        }
        throw new IllegalStateException(a3.d.l("Missing required properties:", sb));
    }
}
