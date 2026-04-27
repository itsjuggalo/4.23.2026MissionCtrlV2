package F5;

import java.util.Collection;

/* JADX INFO: renamed from: F5.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0557o extends AbstractC0556n {
    public static int q(Iterable iterable, int i7) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i7;
    }

    public static final Integer r(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }
}
