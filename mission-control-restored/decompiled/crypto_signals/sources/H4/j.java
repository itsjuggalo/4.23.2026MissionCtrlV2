package H4;

import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public abstract class j extends i {
    public static int d0(Iterable iterable, int i) {
        kotlin.jvm.internal.j.e(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }
}
