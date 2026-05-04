package h7;

import i7.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f11088b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f11089c = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i7.a f11087a = new a.C0224a();

    public static int b(int i10) {
        return (i10 == 400 || i10 == 404) ? 1 : 0;
    }

    public boolean a() {
        return this.f11089c <= this.f11087a.a();
    }

    public void c() {
        this.f11088b = 0L;
        this.f11089c = -1L;
    }

    public void d(int i10) {
        this.f11088b++;
        if (b(i10) == 1) {
            this.f11089c = this.f11087a.a() + 86400000;
            return;
        }
        this.f11089c = this.f11087a.a() + Math.min((long) (Math.pow(2.0d, this.f11088b * ((Math.random() * 0.5d) + 1.0d)) * 1000.0d), 14400000L);
    }
}
