package ng;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m0 {
    public static final void a(gd.i iVar, Throwable th) {
        try {
            l0 l0Var = (l0) iVar.get(l0.M);
            if (l0Var != null) {
                l0Var.o(iVar, th);
            } else {
                sg.f.a(iVar, th);
            }
        } catch (Throwable th2) {
            sg.f.a(iVar, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        cd.e.a(runtimeException, th);
        return runtimeException;
    }
}
