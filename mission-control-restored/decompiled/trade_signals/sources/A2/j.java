package A2;

import java.lang.Thread;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f75a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f76b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f77c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f78d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ThreadFactory f79e = null;

    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ThreadFactory f80a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f81b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicLong f82c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Boolean f83d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Integer f84e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f85f;

        public a(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f80a = threadFactory;
            this.f81b = str;
            this.f82c = atomicLong;
            this.f83d = bool;
            this.f84e = num;
            this.f85f = uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = this.f80a.newThread(runnable);
            Objects.requireNonNull(threadNewThread);
            String str = this.f81b;
            if (str != null) {
                AtomicLong atomicLong = this.f82c;
                Objects.requireNonNull(atomicLong);
                threadNewThread.setName(j.d(str, Long.valueOf(atomicLong.getAndIncrement())));
            }
            Boolean bool = this.f83d;
            if (bool != null) {
                threadNewThread.setDaemon(bool.booleanValue());
            }
            Integer num = this.f84e;
            if (num != null) {
                threadNewThread.setPriority(num.intValue());
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f85f;
            if (uncaughtExceptionHandler != null) {
                threadNewThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
            }
            return threadNewThread;
        }
    }

    public static ThreadFactory c(j jVar) {
        String str = jVar.f75a;
        Boolean bool = jVar.f76b;
        Integer num = jVar.f77c;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = jVar.f78d;
        ThreadFactory threadFactoryDefaultThreadFactory = jVar.f79e;
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

    public j e(boolean z7) {
        this.f76b = Boolean.valueOf(z7);
        return this;
    }

    public j f(String str) {
        d(str, 0);
        this.f75a = str;
        return this;
    }
}
