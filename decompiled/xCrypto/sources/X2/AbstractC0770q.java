package X2;

import java.util.Collection;

/* JADX INFO: renamed from: X2.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0770q extends AbstractC0769p {
    public static int q(Iterable iterable, int i4) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i4;
    }

    public static final Integer r(Iterable iterable) {
        kotlin.jvm.internal.r.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }
}
