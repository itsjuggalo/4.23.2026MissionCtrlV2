package sg;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w {
    public static final void a(pd.k kVar, Object obj, gd.i iVar) throws IllegalAccessException, InvocationTargetException {
        p0 p0VarB = b(kVar, obj, null);
        if (p0VarB != null) {
            ng.m0.a(iVar, p0VarB);
        }
    }

    public static final p0 b(pd.k kVar, Object obj, p0 p0Var) throws IllegalAccessException, InvocationTargetException {
        try {
            kVar.invoke(obj);
            return p0Var;
        } catch (Throwable th) {
            if (p0Var != null && p0Var.getCause() != th) {
                cd.e.a(p0Var, th);
                return p0Var;
            }
            return new p0("Exception in undelivered element handler for " + obj, th);
        }
    }

    public static /* synthetic */ p0 c(pd.k kVar, Object obj, p0 p0Var, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            p0Var = null;
        }
        return b(kVar, obj, p0Var);
    }
}
