package Z6;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2491s;
import o5.C2490r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f9803a;
    private static volatile Choreographer choreographer;

    static {
        Object objB;
        try {
            C2490r.a aVar = C2490r.f21981b;
            objB = C2490r.b(new d(a(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            C2490r.a aVar2 = C2490r.f21981b;
            objB = C2490r.b(AbstractC2491s.a(th));
        }
        f9803a = (e) (C2490r.g(objB) ? null : objB);
    }

    public static final Handler a(Looper looper, boolean z7) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        if (!z7) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            objNewInstance = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
            AbstractC2304t.d(objNewInstance, "null cannot be cast to non-null type android.os.Handler");
        } else {
            try {
                objNewInstance = Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        return (Handler) objNewInstance;
    }
}
