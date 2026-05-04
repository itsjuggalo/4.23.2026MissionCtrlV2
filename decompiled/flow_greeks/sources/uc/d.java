package uc;

import cc.r;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f22946d = new f("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThreadFactory f22947c;

    public d() {
        this(f22946d);
    }

    @Override // cc.r
    public r.b b() {
        return new e(this.f22947c);
    }

    public d(ThreadFactory threadFactory) {
        this.f22947c = threadFactory;
    }
}
