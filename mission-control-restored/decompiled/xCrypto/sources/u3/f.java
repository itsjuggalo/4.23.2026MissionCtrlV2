package u3;

import W2.p;
import W2.q;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f15111a;
    private static volatile Choreographer choreographer;

    static {
        Object objB;
        try {
            p.a aVar = p.f5487b;
            objB = p.b(new d(a(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            p.a aVar2 = p.f5487b;
            objB = p.b(q.a(th));
        }
        f15111a = (e) (p.g(objB) ? null : objB);
    }

    public static final Handler a(Looper looper, boolean z4) throws IllegalAccessException, InvocationTargetException {
        if (!z4) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
            r.d(objInvoke, "null cannot be cast to non-null type android.os.Handler");
            return (Handler) objInvoke;
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }
}
