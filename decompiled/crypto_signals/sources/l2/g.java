package l2;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import r.C0958a;

/* JADX INFO: loaded from: classes.dex */
public final class g extends r.h implements ScheduledFuture {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ScheduledFuture f8086l;

    public g(InterfaceC0798f interfaceC0798f) {
        this.f8086l = interfaceC0798f.b(new Y3.j(this, 14));
    }

    @Override // r.h
    public final void c() {
        ScheduledFuture scheduledFuture = this.f8086l;
        Object obj = this.f9429a;
        scheduledFuture.cancel((obj instanceof C0958a) && ((C0958a) obj).f9410a);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Delayed delayed) {
        return this.f8086l.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.f8086l.getDelay(timeUnit);
    }
}
