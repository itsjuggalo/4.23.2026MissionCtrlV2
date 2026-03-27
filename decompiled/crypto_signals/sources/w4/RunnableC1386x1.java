package w4;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: w4.x1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1386x1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ T3.d f11425b;

    public /* synthetic */ RunnableC1386x1(T3.d dVar, int i) {
        this.f11424a = i;
        this.f11425b = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f11424a) {
            case 0:
                T3.d dVar = this.f11425b;
                if (!dVar.f3042b) {
                    dVar.f3046g = null;
                } else {
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    long jA = dVar.f3041a - ((U1.k) dVar.f3045f).a();
                    if (jA <= 0) {
                        dVar.f3042b = false;
                        dVar.f3046g = null;
                        ((D0) dVar.e).run();
                    } else {
                        dVar.f3046g = ((ScheduledExecutorService) dVar.f3043c).schedule(new RunnableC1386x1(dVar, 1), jA, timeUnit);
                    }
                }
                break;
            default:
                T3.d dVar2 = this.f11425b;
                ((l2.h) dVar2.f3044d).execute(new RunnableC1386x1(dVar2, 0));
                break;
        }
    }
}
