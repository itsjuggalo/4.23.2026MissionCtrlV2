package I6;

import R5.InterfaceC0856m;

/* JADX INFO: loaded from: classes2.dex */
public interface q0 {

    public static final class a {
        public static /* synthetic */ r0 a(q0 q0Var, S5.h hVar, v0 v0Var, InterfaceC0856m interfaceC0856m, int i8, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toAttributes");
            }
            if ((i8 & 2) != 0) {
                v0Var = null;
            }
            if ((i8 & 4) != 0) {
                interfaceC0856m = null;
            }
            return q0Var.a(hVar, v0Var, interfaceC0856m);
        }
    }

    r0 a(S5.h hVar, v0 v0Var, InterfaceC0856m interfaceC0856m);
}
