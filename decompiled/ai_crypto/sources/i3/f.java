package i3;

import Z5.u;
import android.os.Looper;
import e3.C1478g;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f16260e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f16261f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorC1978e f16262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorC1978e f16263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorC1978e f16264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ExecutorC1978e f16265d;

    public static final class a {

        /* JADX INFO: renamed from: i3.f$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0246a extends o implements Function0 {
            public C0246a(Object obj) {
                super(0, obj, a.class, "isBackgroundThread", "isBackgroundThread()Z", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke() {
                return Boolean.valueOf(((a) this.receiver).k());
            }
        }

        public static final class b extends s implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f16266a = new b();

            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Must be called on a background thread, was called on " + f.f16260e.j() + com.amazon.a.a.o.c.a.b.f10001a;
            }
        }

        public /* synthetic */ class c extends o implements Function0 {
            public c(Object obj) {
                super(0, obj, a.class, "isBlockingThread", "isBlockingThread()Z", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke() {
                return Boolean.valueOf(((a) this.receiver).l());
            }
        }

        public static final class d extends s implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f16267a = new d();

            public d() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Must be called on a blocking thread, was called on " + f.f16260e.j() + com.amazon.a.a.o.c.a.b.f10001a;
            }
        }

        public /* synthetic */ class e extends o implements Function0 {
            public e(Object obj) {
                super(0, obj, a.class, "isNotMainThread", "isNotMainThread()Z", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke() {
                return Boolean.valueOf(((a) this.receiver).m());
            }
        }

        /* JADX INFO: renamed from: i3.f$a$f, reason: collision with other inner class name */
        public static final class C0247f extends s implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0247f f16268a = new C0247f();

            public C0247f() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Must not be called on a main thread, was called on " + f.f16260e.j() + com.amazon.a.a.o.c.a.b.f10001a;
            }
        }

        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final void e() {
            h(new C0246a(this), b.f16266a);
        }

        public final void f() {
            h(new c(this), d.f16267a);
        }

        public final void g() {
            h(new e(this), C0247f.f16268a);
        }

        public final void h(Function0 function0, Function0 function02) {
            if (((Boolean) function0.invoke()).booleanValue()) {
                return;
            }
            C1478g.f().b((String) function02.invoke());
            i();
        }

        public final boolean i() {
            return f.f16261f;
        }

        public final String j() {
            return Thread.currentThread().getName();
        }

        public final boolean k() {
            String threadName = j();
            r.e(threadName, "threadName");
            return u.D(threadName, "Firebase Background Thread #", false, 2, null);
        }

        public final boolean l() {
            String threadName = j();
            r.e(threadName, "threadName");
            return u.D(threadName, "Firebase Blocking Thread #", false, 2, null);
        }

        public final boolean m() {
            return !Looper.getMainLooper().isCurrentThread();
        }

        public final void n(boolean z7) {
            f.f16261f = z7;
        }

        public a() {
        }
    }

    public f(ExecutorService backgroundExecutorService, ExecutorService blockingExecutorService) {
        r.f(backgroundExecutorService, "backgroundExecutorService");
        r.f(blockingExecutorService, "blockingExecutorService");
        this.f16262a = new ExecutorC1978e(backgroundExecutorService);
        this.f16263b = new ExecutorC1978e(backgroundExecutorService);
        this.f16264c = new ExecutorC1978e(backgroundExecutorService);
        this.f16265d = new ExecutorC1978e(blockingExecutorService);
    }

    public static final void c() {
        f16260e.e();
    }

    public static final void d() {
        f16260e.f();
    }

    public static final void e() {
        f16260e.g();
    }

    public static final void f(boolean z7) {
        f16260e.n(z7);
    }
}
