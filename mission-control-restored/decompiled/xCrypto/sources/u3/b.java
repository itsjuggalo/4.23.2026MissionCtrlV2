package u3;

import Z2.i;
import android.os.Build;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import t3.J;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends Z2.a implements J {
    private volatile Object _preHandler;

    public b() {
        super(J.f14949L);
        this._preHandler = this;
    }

    @Override // t3.J
    public void A(i iVar, Throwable th) {
        int i4 = Build.VERSION.SDK_INT;
        if (26 > i4 || i4 >= 28) {
            return;
        }
        Method methodD0 = d0();
        Object objInvoke = methodD0 != null ? methodD0.invoke(null, new Object[0]) : null;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = objInvoke instanceof Thread.UncaughtExceptionHandler ? (Thread.UncaughtExceptionHandler) objInvoke : null;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        }
    }

    public final Method d0() {
        Object obj = this._preHandler;
        if (obj != this) {
            return (Method) obj;
        }
        Method method = null;
        try {
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
            if (Modifier.isPublic(declaredMethod.getModifiers())) {
                if (Modifier.isStatic(declaredMethod.getModifiers())) {
                    method = declaredMethod;
                }
            }
        } catch (Throwable unused) {
        }
        this._preHandler = method;
        return method;
    }
}
