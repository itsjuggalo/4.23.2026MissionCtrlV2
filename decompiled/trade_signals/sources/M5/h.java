package M5;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public interface h {

    public static final class a {
        public static void a(h hVar, Object[] args) {
            AbstractC2304t.f(args, "args");
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
