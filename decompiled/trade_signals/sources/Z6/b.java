package Z6;

import Y6.J;
import android.os.Build;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import s5.AbstractC2703a;
import s5.InterfaceC2711i;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends AbstractC2703a implements J {
    private volatile Object _preHandler;

    public b() {
        super(J.f9627K);
        this._preHandler = this;
    }

    @Override // Y6.J
    public void M(InterfaceC2711i interfaceC2711i, Throwable th) {
        int i8 = Build.VERSION.SDK_INT;
        if (26 > i8 || i8 >= 28) {
            return;
        }
        Method methodV0 = v0();
        Object objInvoke = methodV0 != null ? methodV0.invoke(null, null) : null;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = objInvoke instanceof Thread.UncaughtExceptionHandler ? (Thread.UncaughtExceptionHandler) objInvoke : null;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        }
    }

    public final Method v0() {
        Object obj = this._preHandler;
        if (obj != this) {
            return (Method) obj;
        }
        Method method = null;
        try {
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", null);
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
