package n7;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.internal.p002firebaseauthapi.zze;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static p5.a f16849h = new p5.a("TokenRefresher", "FirebaseAuth:");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a7.g f16850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f16851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f16852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f16853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HandlerThread f16854e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f16855f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Runnable f16856g;

    public t(a7.g gVar) {
        f16849h.g("Initializing TokenRefresher", new Object[0]);
        a7.g gVar2 = (a7.g) com.google.android.gms.common.internal.s.k(gVar);
        this.f16850a = gVar2;
        HandlerThread handlerThread = new HandlerThread("TokenRefresher", 10);
        this.f16854e = handlerThread;
        handlerThread.start();
        this.f16855f = new zze(this.f16854e.getLooper());
        this.f16856g = new w(this, gVar2.q());
        this.f16853d = 300000L;
    }

    public final void b() {
        this.f16855f.removeCallbacks(this.f16856g);
    }

    public final void c() {
        f16849h.g("Scheduling refresh for " + (this.f16851b - this.f16853d), new Object[0]);
        b();
        this.f16852c = Math.max((this.f16851b - t5.h.d().a()) - this.f16853d, 0L) / 1000;
        this.f16855f.postDelayed(this.f16856g, this.f16852c * 1000);
    }

    public final void d() {
        int i10 = (int) this.f16852c;
        this.f16852c = (i10 == 30 || i10 == 60 || i10 == 120 || i10 == 240 || i10 == 480) ? 2 * this.f16852c : i10 != 960 ? 30L : 960L;
        this.f16851b = t5.h.d().a() + (this.f16852c * 1000);
        f16849h.g("Scheduling refresh for " + this.f16851b, new Object[0]);
        this.f16855f.postDelayed(this.f16856g, this.f16852c * 1000);
    }
}
