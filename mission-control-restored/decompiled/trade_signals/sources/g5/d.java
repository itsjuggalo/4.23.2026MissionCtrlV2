package g5;

import P4.r;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f18269c = new f("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadFactory f18270b;

    public d() {
        this(f18269c);
    }

    @Override // P4.r
    public r.b a() {
        return new e(this.f18270b);
    }

    public d(ThreadFactory threadFactory) {
        this.f18270b = threadFactory;
    }
}
