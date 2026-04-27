package d1;

import V4.j;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f13162c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Handler f13163d = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ExecutorService f13164e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j.d f13165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13166b;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final ExecutorService a() {
            return g.f13164e;
        }

        public a() {
        }
    }

    static {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(8);
        r.e(executorServiceNewFixedThreadPool, "newFixedThreadPool(...)");
        f13164e = executorServiceNewFixedThreadPool;
    }

    public g(j.d dVar) {
        this.f13165a = dVar;
    }

    public static final void d(j.d dVar, Object obj) {
        if (dVar != null) {
            dVar.a(obj);
        }
    }

    public final void c(final Object obj) {
        if (this.f13166b) {
            return;
        }
        this.f13166b = true;
        final j.d dVar = this.f13165a;
        this.f13165a = null;
        f13163d.post(new Runnable() { // from class: d1.f
            @Override // java.lang.Runnable
            public final void run() {
                g.d(dVar, obj);
            }
        });
    }
}
