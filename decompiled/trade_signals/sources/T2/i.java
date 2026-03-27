package T2;

import T2.i;
import V6.C;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2302q;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f7944e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f7945f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f7946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f7947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f7948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f7949d;

    public static final class a {

        /* JADX INFO: renamed from: T2.i$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0113a extends AbstractC2302q implements Function0 {
            public C0113a(Object obj) {
                super(0, obj, a.class, "isBackgroundThread", "isBackgroundThread()Z", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke() {
                return Boolean.valueOf(((a) this.receiver).p());
            }
        }

        public /* synthetic */ class b extends AbstractC2302q implements Function0 {
            public b(Object obj) {
                super(0, obj, a.class, "isBlockingThread", "isBlockingThread()Z", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke() {
                return Boolean.valueOf(((a) this.receiver).q());
            }
        }

        public /* synthetic */ class c extends AbstractC2302q implements Function0 {
            public c(Object obj) {
                super(0, obj, a.class, "isNotMainThread", "isNotMainThread()Z", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke() {
                return Boolean.valueOf(((a) this.receiver).r());
            }
        }

        public a() {
        }

        public static final String h() {
            return "Must be called on a background thread, was called on " + i.f7944e.o() + com.amazon.a.a.o.c.a.b.f14112a;
        }

        public static final String j() {
            return "Must be called on a blocking thread, was called on " + i.f7944e.o() + com.amazon.a.a.o.c.a.b.f14112a;
        }

        public static final String l() {
            return "Must not be called on a main thread, was called on " + i.f7944e.o() + com.amazon.a.a.o.c.a.b.f14112a;
        }

        public final void g() {
            m(new C0113a(this), new Function0() { // from class: T2.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return i.a.h();
                }
            });
        }

        public final void i() {
            m(new b(this), new Function0() { // from class: T2.h
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return i.a.j();
                }
            });
        }

        public final void k() {
            m(new c(this), new Function0() { // from class: T2.g
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return i.a.l();
                }
            });
        }

        public final void m(Function0 function0, Function0 function02) {
            if (((Boolean) function0.invoke()).booleanValue()) {
                return;
            }
            P2.g.f().b((String) function02.invoke());
            n();
        }

        public final boolean n() {
            return i.f7945f;
        }

        public final String o() {
            return Thread.currentThread().getName();
        }

        public final boolean p() {
            String strO = o();
            AbstractC2304t.e(strO, "<get-threadName>(...)");
            return C.L(strO, "Firebase Background Thread #", false, 2, null);
        }

        public final boolean q() {
            String strO = o();
            AbstractC2304t.e(strO, "<get-threadName>(...)");
            return C.L(strO, "Firebase Blocking Thread #", false, 2, null);
        }

        public final boolean r() {
            return !Looper.getMainLooper().isCurrentThread();
        }

        public final void s(boolean z7) {
            i.f7945f = z7;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public i(ExecutorService backgroundExecutorService, ExecutorService blockingExecutorService) {
        AbstractC2304t.f(backgroundExecutorService, "backgroundExecutorService");
        AbstractC2304t.f(blockingExecutorService, "blockingExecutorService");
        this.f7946a = new e(backgroundExecutorService);
        this.f7947b = new e(backgroundExecutorService);
        this.f7948c = new e(backgroundExecutorService);
        this.f7949d = new e(blockingExecutorService);
    }

    public static final void c() {
        f7944e.g();
    }

    public static final void d() {
        f7944e.i();
    }

    public static final void e() {
        f7944e.k();
    }

    public static final void f(boolean z7) {
        f7944e.s(z7);
    }
}
