package H6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public class d implements k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lock f3976b;

    public d(Lock lock) {
        AbstractC2304t.f(lock, "lock");
        this.f3976b = lock;
    }

    public final Lock a() {
        return this.f3976b;
    }

    @Override // H6.k
    public void lock() {
        this.f3976b.lock();
    }

    @Override // H6.k
    public void unlock() {
        this.f3976b.unlock();
    }

    public /* synthetic */ d(Lock lock, int i8, AbstractC2296k abstractC2296k) {
        this((i8 & 1) != 0 ? new ReentrantLock() : lock);
    }
}
