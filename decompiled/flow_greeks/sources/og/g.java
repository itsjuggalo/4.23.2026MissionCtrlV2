package og;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import cd.r;
import cd.s;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f18146a;
    private static volatile Choreographer choreographer;

    static {
        Object objB;
        try {
            r.a aVar = r.f3870b;
            objB = r.b(new e(a(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            r.a aVar2 = r.f3870b;
            objB = r.b(s.a(th));
        }
        f18146a = (f) (r.g(objB) ? null : objB);
    }

    public static final Handler a(Looper looper, boolean z10) throws IllegalAccessException, InvocationTargetException {
        if (!z10) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
            t.d(objInvoke, "null cannot be cast to non-null type android.os.Handler");
            return (Handler) objInvoke;
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }
}
