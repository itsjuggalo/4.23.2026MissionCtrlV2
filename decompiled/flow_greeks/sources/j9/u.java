package j9;

import bb.d0;
import bb.u;
import com.google.protobuf.s1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class u {
    public static s1 a(d0 d0Var) {
        return d0Var.s0().f0("__local_write_time__").v0();
    }

    public static d0 b(d0 d0Var) {
        d0 d0VarE0 = d0Var.s0().e0("__previous_value__", null);
        return c(d0VarE0) ? b(d0VarE0) : d0VarE0;
    }

    public static boolean c(d0 d0Var) {
        d0 d0VarE0 = d0Var != null ? d0Var.s0().e0("__type__", null) : null;
        return d0VarE0 != null && "server_timestamp".equals(d0VarE0.u0());
    }

    public static d0 d(a7.s sVar, d0 d0Var) {
        d0 d0Var2 = (d0) d0.y0().J("server_timestamp").n();
        u.b bVarZ = bb.u.j0().z("__type__", d0Var2).z("__local_write_time__", (d0) d0.y0().K(s1.f0().y(sVar.h()).x(sVar.b())).n());
        if (c(d0Var)) {
            d0Var = b(d0Var);
        }
        if (d0Var != null) {
            bVarZ.z("__previous_value__", d0Var);
        }
        return (d0) d0.y0().F(bVarZ).n();
    }
}
