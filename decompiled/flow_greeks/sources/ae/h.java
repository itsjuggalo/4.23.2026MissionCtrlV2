package ae;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface h {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public static void a(h hVar, Object[] args) {
            t.f(args, "args");
            if (j.a(hVar) == args.length) {
                return;
            }
            throw new IllegalArgumentException("Callable expects " + j.a(hVar) + " arguments, but " + args.length + " were provided.");
        }

        public static boolean b(h hVar) {
            return false;
        }
    }

    List a();

    Member b();

    boolean c();

    Object call(Object[] objArr);

    Type getReturnType();
}
