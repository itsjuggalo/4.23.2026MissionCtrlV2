package a3;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.p002firebaseauthapi.zze;

/* JADX INFO: renamed from: a3.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0877t {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static S1.a f6276h = new S1.a("TokenRefresher", "FirebaseAuth:");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Q2.g f6277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f6278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f6279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f6280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HandlerThread f6281e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f6282f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Runnable f6283g;

    public C0877t(Q2.g gVar) {
        f6276h.g("Initializing TokenRefresher", new Object[0]);
        Q2.g gVar2 = (Q2.g) AbstractC1207s.k(gVar);
        this.f6277a = gVar2;
        HandlerThread handlerThread = new HandlerThread("TokenRefresher", 10);
        this.f6281e = handlerThread;
        handlerThread.start();
        this.f6282f = new zze(this.f6281e.getLooper());
        this.f6283g = new RunnableC0883w(this, gVar2.q());
        this.f6280d = 300000L;
    }

    public final void b() {
        this.f6282f.removeCallbacks(this.f6283g);
    }

    public final void c() {
        f6276h.g("Scheduling refresh for " + (this.f6278b - this.f6280d), new Object[0]);
        b();
        this.f6279c = Math.max((this.f6278b - W1.g.d().a()) - this.f6280d, 0L) / 1000;
        this.f6282f.postDelayed(this.f6283g, this.f6279c * 1000);
    }

    public final void d() {
        int i7 = (int) this.f6279c;
        this.f6279c = (i7 == 30 || i7 == 60 || i7 == 120 || i7 == 240 || i7 == 480) ? 2 * this.f6279c : i7 != 960 ? 30L : 960L;
        this.f6278b = W1.g.d().a() + (this.f6279c * 1000);
        f6276h.g("Scheduling refresh for " + this.f6278b, new Object[0]);
        this.f6282f.postDelayed(this.f6283g, this.f6279c * 1000);
    }
}
