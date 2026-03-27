package R4;

import P4.r;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f7185a = Q4.a.d(new CallableC0103a());

    /* JADX INFO: renamed from: R4.a$a, reason: collision with other inner class name */
    public static class CallableC0103a implements Callable {
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public r call() {
            return b.f7186a;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r f7186a = new R4.b(new Handler(Looper.getMainLooper()));
    }

    public static r a() {
        return Q4.a.e(f7185a);
    }
}
