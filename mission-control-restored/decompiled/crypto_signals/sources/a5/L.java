package a5;

import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes.dex */
public final class L implements M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledFuture f4088a;

    public L(ScheduledFuture scheduledFuture) {
        this.f4088a = scheduledFuture;
    }

    @Override // a5.M
    public final void a() {
        this.f4088a.cancel(false);
    }

    public final String toString() {
        return "DisposableFutureHandle[" + this.f4088a + ']';
    }
}
