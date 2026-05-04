package fe;

import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface h0 extends m {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public static Object a(h0 h0Var, o visitor, Object obj) {
            kotlin.jvm.internal.t.f(visitor, "visitor");
            return visitor.m(h0Var, obj);
        }

        public static m b(h0 h0Var) {
            return null;
        }
    }

    boolean A0(h0 h0Var);

    Object B(g0 g0Var);

    u0 I0(ef.c cVar);

    ce.i p();

    List r0();

    Collection t(ef.c cVar, pd.k kVar);
}
