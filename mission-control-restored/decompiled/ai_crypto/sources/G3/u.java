package G3;

import com.google.protobuf.t0;
import k4.C2105D;
import k4.C2130u;

/* JADX INFO: loaded from: classes.dex */
public abstract class u {
    public static t0 a(C2105D c2105d) {
        return c2105d.s0().f0("__local_write_time__").v0();
    }

    public static C2105D b(C2105D c2105d) {
        C2105D c2105dE0 = c2105d.s0().e0("__previous_value__", null);
        return c(c2105dE0) ? b(c2105dE0) : c2105dE0;
    }

    public static boolean c(C2105D c2105d) {
        C2105D c2105dE0 = c2105d != null ? c2105d.s0().e0("__type__", null) : null;
        return c2105dE0 != null && "server_timestamp".equals(c2105dE0.u0());
    }

    public static C2105D d(Q2.s sVar, C2105D c2105d) {
        C2105D c2105d2 = (C2105D) C2105D.y0().I("server_timestamp").n();
        C2130u.b bVarY = C2130u.j0().y("__type__", c2105d2).y("__local_write_time__", (C2105D) C2105D.y0().J(t0.f0().x(sVar.h()).w(sVar.c())).n());
        if (c(c2105d)) {
            c2105d = b(c2105d);
        }
        if (c2105d != null) {
            bVarY.y("__previous_value__", c2105d);
        }
        return (C2105D) C2105D.y0().E(bVarY).n();
    }
}
