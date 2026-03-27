package M0;

import android.os.Handler;
import android.os.Looper;
import io.flutter.plugin.common.MethodChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f1597c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Handler f1598d = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ExecutorService f1599e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MethodChannel.Result f1600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1601b;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public final ExecutorService a() {
            return g.f1599e;
        }

        public a() {
        }
    }

    static {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(8);
        r.e(executorServiceNewFixedThreadPool, "newFixedThreadPool(...)");
        f1599e = executorServiceNewFixedThreadPool;
    }

    public g(MethodChannel.Result result) {
        this.f1600a = result;
    }

    public static final void d(MethodChannel.Result result, Object obj) {
        if (result != null) {
            result.success(obj);
        }
    }

    public final void c(final Object obj) {
        if (this.f1601b) {
            return;
        }
        this.f1601b = true;
        final MethodChannel.Result result = this.f1600a;
        this.f1600a = null;
        f1598d.post(new Runnable() { // from class: M0.f
            @Override // java.lang.Runnable
            public final void run() {
                g.d(result, obj);
            }
        });
    }
}
