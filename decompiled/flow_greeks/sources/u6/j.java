package u6;

import java.lang.Thread;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22208a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f22209b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f22210c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f22211d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ThreadFactory f22212e = null;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ThreadFactory f22213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f22214b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicLong f22215c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Boolean f22216d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Integer f22217e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f22218f;

        public a(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f22213a = threadFactory;
            this.f22214b = str;
            this.f22215c = atomicLong;
            this.f22216d = bool;
            this.f22217e = num;
            this.f22218f = uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = this.f22213a.newThread(runnable);
            Objects.requireNonNull(threadNewThread);
            String str = this.f22214b;
            if (str != null) {
                AtomicLong atomicLong = this.f22215c;
                Objects.requireNonNull(atomicLong);
                threadNewThread.setName(j.d(str, Long.valueOf(atomicLong.getAndIncrement())));
            }
            Boolean bool = this.f22216d;
            if (bool != null) {
                threadNewThread.setDaemon(bool.booleanValue());
            }
            Integer num = this.f22217e;
            if (num != null) {
                threadNewThread.setPriority(num.intValue());
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f22218f;
            if (uncaughtExceptionHandler != null) {
                threadNewThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
            }
            return threadNewThread;
        }
    }

    public static ThreadFactory c(j jVar) {
        String str = jVar.f22208a;
        Boolean bool = jVar.f22209b;
        Integer num = jVar.f22210c;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = jVar.f22211d;
        ThreadFactory threadFactoryDefaultThreadFactory = jVar.f22212e;
        if (threadFactoryDefaultThreadFactory == null) {
            threadFactoryDefaultThreadFactory = Executors.defaultThreadFactory();
        }
        return new a(threadFactoryDefaultThreadFactory, str, str != null ? new AtomicLong(0L) : null, bool, num, uncaughtExceptionHandler);
    }

    public static String d(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    public ThreadFactory b() {
        return c(this);
    }

    public j e(boolean z10) {
        this.f22209b = Boolean.valueOf(z10);
        return this;
    }

    public j f(String str) {
        d(str, 0);
        this.f22208a = str;
        return this;
    }
}
