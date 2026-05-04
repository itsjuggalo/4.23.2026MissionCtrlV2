package wf;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class d implements k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lock f24057b;

    public d(Lock lock) {
        t.f(lock, "lock");
        this.f24057b = lock;
    }

    public final Lock a() {
        return this.f24057b;
    }

    @Override // wf.k
    public void lock() {
        this.f24057b.lock();
    }

    @Override // wf.k
    public void unlock() {
        this.f24057b.unlock();
    }

    public /* synthetic */ d(Lock lock, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? new ReentrantLock() : lock);
    }
}
