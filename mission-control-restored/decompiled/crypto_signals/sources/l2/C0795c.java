package l2;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: l2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0795c implements InterfaceC0798f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ScheduledExecutorServiceC0797e f8076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Runnable f8077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f8078d;
    public final /* synthetic */ long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ TimeUnit f8079f;

    public /* synthetic */ C0795c(ScheduledExecutorServiceC0797e scheduledExecutorServiceC0797e, Runnable runnable, long j4, long j6, TimeUnit timeUnit, int i) {
        this.f8075a = i;
        this.f8076b = scheduledExecutorServiceC0797e;
        this.f8077c = runnable;
        this.f8078d = j4;
        this.e = j6;
        this.f8079f = timeUnit;
    }

    @Override // l2.InterfaceC0798f
    public final ScheduledFuture b(Y3.j jVar) {
        switch (this.f8075a) {
            case 0:
                ScheduledExecutorServiceC0797e scheduledExecutorServiceC0797e = this.f8076b;
                return scheduledExecutorServiceC0797e.f8085b.scheduleAtFixedRate(new RunnableC0796d(scheduledExecutorServiceC0797e, this.f8077c, jVar, 0), this.f8078d, this.e, this.f8079f);
            default:
                ScheduledExecutorServiceC0797e scheduledExecutorServiceC0797e2 = this.f8076b;
                return scheduledExecutorServiceC0797e2.f8085b.scheduleWithFixedDelay(new RunnableC0796d(scheduledExecutorServiceC0797e2, this.f8077c, jVar, 2), this.f8078d, this.e, this.f8079f);
        }
    }
}
