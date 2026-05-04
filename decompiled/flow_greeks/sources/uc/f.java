package uc;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends AtomicLong implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f22952c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends Thread {
        public a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public f(String str) {
        this(str, 5, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = this.f22950a + '-' + incrementAndGet();
        Thread aVar = this.f22952c ? new a(runnable, str) : new Thread(runnable, str);
        aVar.setPriority(this.f22951b);
        aVar.setDaemon(true);
        return aVar;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.f22950a + "]";
    }

    public f(String str, int i10) {
        this(str, i10, false);
    }

    public f(String str, int i10, boolean z10) {
        this.f22950a = str;
        this.f22951b = i10;
        this.f22952c = z10;
    }
}
