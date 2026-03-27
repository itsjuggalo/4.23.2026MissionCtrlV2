package g5;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends AtomicLong implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f18275c;

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
        String str = this.f18273a + '-' + incrementAndGet();
        Thread aVar = this.f18275c ? new a(runnable, str) : new Thread(runnable, str);
        aVar.setPriority(this.f18274b);
        aVar.setDaemon(true);
        return aVar;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.f18273a + "]";
    }

    public f(String str, int i8) {
        this(str, i8, false);
    }

    public f(String str, int i8, boolean z7) {
        this.f18273a = str;
        this.f18274b = i8;
        this.f18275c = z7;
    }
}
