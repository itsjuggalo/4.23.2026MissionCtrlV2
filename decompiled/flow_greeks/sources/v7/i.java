package v7;

import android.os.Looper;
import java.util.concurrent.ExecutorService;
import kg.c0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
import v7.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f23150e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f23151f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f23152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f23153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f23154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f23155d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: v7.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public /* synthetic */ class C0401a extends q implements Function0 {
            public C0401a(Object obj) {
                super(0, obj, a.class, "isBackgroundThread", "isBackgroundThread()Z", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke() {
                return Boolean.valueOf(((a) this.receiver).p());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public /* synthetic */ class b extends q implements Function0 {
            public b(Object obj) {
                super(0, obj, a.class, "isBlockingThread", "isBlockingThread()Z", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke() {
                return Boolean.valueOf(((a) this.receiver).q());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public /* synthetic */ class c extends q implements Function0 {
            public c(Object obj) {
                super(0, obj, a.class, "isNotMainThread", "isNotMainThread()Z", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke() {
                return Boolean.valueOf(((a) this.receiver).r());
            }
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        public static final String h() {
            return "Must be called on a background thread, was called on " + i.f23150e.o() + com.amazon.a.a.o.c.a.b.f4610a;
        }

        public static final String j() {
            return "Must be called on a blocking thread, was called on " + i.f23150e.o() + com.amazon.a.a.o.c.a.b.f4610a;
        }

        public static final String l() {
            return "Must not be called on a main thread, was called on " + i.f23150e.o() + com.amazon.a.a.o.c.a.b.f4610a;
        }

        public final void g() {
            m(new C0401a(this), new Function0() { // from class: v7.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return i.a.h();
                }
            });
        }

        public final void i() {
            m(new b(this), new Function0() { // from class: v7.h
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return i.a.j();
                }
            });
        }

        public final void k() {
            m(new c(this), new Function0() { // from class: v7.g
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
            r7.g.f().b((String) function02.invoke());
            n();
        }

        public final boolean n() {
            return i.f23151f;
        }

        public final String o() {
            return Thread.currentThread().getName();
        }

        public final boolean p() {
            String strO = o();
            t.e(strO, "<get-threadName>(...)");
            return c0.P(strO, "Firebase Background Thread #", false, 2, null);
        }

        public final boolean q() {
            String strO = o();
            t.e(strO, "<get-threadName>(...)");
            return c0.P(strO, "Firebase Blocking Thread #", false, 2, null);
        }

        public final boolean r() {
            return !Looper.getMainLooper().isCurrentThread();
        }

        public final void s(boolean z10) {
            i.f23151f = z10;
        }

        public a() {
        }
    }

    public i(ExecutorService backgroundExecutorService, ExecutorService blockingExecutorService) {
        t.f(backgroundExecutorService, "backgroundExecutorService");
        t.f(blockingExecutorService, "blockingExecutorService");
        this.f23152a = new e(backgroundExecutorService);
        this.f23153b = new e(backgroundExecutorService);
        this.f23154c = new e(backgroundExecutorService);
        this.f23155d = new e(blockingExecutorService);
    }

    public static final void c() {
        f23150e.g();
    }

    public static final void d() {
        f23150e.i();
    }

    public static final void e() {
        f23150e.k();
    }

    public static final void f(boolean z10) {
        f23150e.s(z10);
    }
}
