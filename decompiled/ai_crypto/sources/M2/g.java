package M2;

import java.lang.Thread;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3833a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f3834b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f3835c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f3836d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ThreadFactory f3837e = null;

    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ThreadFactory f3838a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f3839b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicLong f3840c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Boolean f3841d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Integer f3842e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f3843f;

        public a(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f3838a = threadFactory;
            this.f3839b = str;
            this.f3840c = atomicLong;
            this.f3841d = bool;
            this.f3842e = num;
            this.f3843f = uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = this.f3838a.newThread(runnable);
            Objects.requireNonNull(threadNewThread);
            String str = this.f3839b;
            if (str != null) {
                AtomicLong atomicLong = this.f3840c;
                Objects.requireNonNull(atomicLong);
                threadNewThread.setName(g.d(str, Long.valueOf(atomicLong.getAndIncrement())));
            }
            Boolean bool = this.f3841d;
            if (bool != null) {
                threadNewThread.setDaemon(bool.booleanValue());
            }
            Integer num = this.f3842e;
            if (num != null) {
                threadNewThread.setPriority(num.intValue());
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f3843f;
            if (uncaughtExceptionHandler != null) {
                threadNewThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
            }
            return threadNewThread;
        }
    }

    public static ThreadFactory c(g gVar) {
        String str = gVar.f3833a;
        Boolean bool = gVar.f3834b;
        Integer num = gVar.f3835c;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = gVar.f3836d;
        ThreadFactory threadFactoryDefaultThreadFactory = gVar.f3837e;
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

    public g e(boolean z7) {
        this.f3834b = Boolean.valueOf(z7);
        return this;
    }

    public g f(String str) {
        d(str, 0);
        this.f3833a = str;
        return this;
    }
}
