package J4;

import O4.f;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f3320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f3321e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f3322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FlutterJNI.c f3323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ExecutorService f3324c;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f f3325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public FlutterJNI.c f3326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ExecutorService f3327c;

        /* JADX INFO: renamed from: J4.a$b$a, reason: collision with other inner class name */
        public class ThreadFactoryC0043a implements ThreadFactory {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f3328a;

            public ThreadFactoryC0043a() {
                this.f3328a = 0;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                StringBuilder sb = new StringBuilder();
                sb.append("flutter-worker-");
                int i7 = this.f3328a;
                this.f3328a = i7 + 1;
                sb.append(i7);
                thread.setName(sb.toString());
                return thread;
            }
        }

        public a a() {
            b();
            return new a(this.f3325a, null, this.f3326b, this.f3327c);
        }

        public final void b() {
            if (this.f3326b == null) {
                this.f3326b = new FlutterJNI.c();
            }
            if (this.f3327c == null) {
                this.f3327c = Executors.newCachedThreadPool(new ThreadFactoryC0043a());
            }
            if (this.f3325a == null) {
                this.f3325a = new f(this.f3326b.a(), this.f3327c);
            }
        }
    }

    public static a e() {
        f3321e = true;
        if (f3320d == null) {
            f3320d = new b().a();
        }
        return f3320d;
    }

    public N4.a a() {
        return null;
    }

    public ExecutorService b() {
        return this.f3324c;
    }

    public f c() {
        return this.f3322a;
    }

    public FlutterJNI.c d() {
        return this.f3323b;
    }

    public a(f fVar, N4.a aVar, FlutterJNI.c cVar, ExecutorService executorService) {
        this.f3322a = fVar;
        this.f3323b = cVar;
        this.f3324c = executorService;
    }
}
