package e2;

import java.lang.Thread;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: e2.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1235g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11504a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f11505b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f11506c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f11507d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ThreadFactory f11508e = null;

    /* JADX INFO: renamed from: e2.g$a */
    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ThreadFactory f11509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f11510b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicLong f11511c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Boolean f11512d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Integer f11513e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f11514f;

        public a(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f11509a = threadFactory;
            this.f11510b = str;
            this.f11511c = atomicLong;
            this.f11512d = bool;
            this.f11513e = num;
            this.f11514f = uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = this.f11509a.newThread(runnable);
            Objects.requireNonNull(threadNewThread);
            String str = this.f11510b;
            if (str != null) {
                AtomicLong atomicLong = this.f11511c;
                Objects.requireNonNull(atomicLong);
                threadNewThread.setName(C1235g.d(str, Long.valueOf(atomicLong.getAndIncrement())));
            }
            Boolean bool = this.f11512d;
            if (bool != null) {
                threadNewThread.setDaemon(bool.booleanValue());
            }
            Integer num = this.f11513e;
            if (num != null) {
                threadNewThread.setPriority(num.intValue());
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f11514f;
            if (uncaughtExceptionHandler != null) {
                threadNewThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
            }
            return threadNewThread;
        }
    }

    public static ThreadFactory c(C1235g c1235g) {
        String str = c1235g.f11504a;
        Boolean bool = c1235g.f11505b;
        Integer num = c1235g.f11506c;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = c1235g.f11507d;
        ThreadFactory threadFactoryDefaultThreadFactory = c1235g.f11508e;
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

    public C1235g e(boolean z4) {
        this.f11505b = Boolean.valueOf(z4);
        return this;
    }

    public C1235g f(String str) {
        d(str, 0);
        this.f11504a = str;
        return this;
    }
}
