package R5;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public interface H extends InterfaceC0856m {

    public static final class a {
        public static Object a(H h8, InterfaceC0858o visitor, Object obj) {
            AbstractC2304t.f(visitor, "visitor");
            return visitor.m(h8, obj);
        }

        public static InterfaceC0856m b(H h8) {
            return null;
        }
    }

    Object f0(G g8);

    O5.i q();

    boolean s0(H h8);

    V u0(q6.c cVar);

    Collection v(q6.c cVar, B5.k kVar);

    List v0();
}
