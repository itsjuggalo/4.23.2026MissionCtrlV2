package H4;

import java.util.AbstractCollection;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public abstract class n extends m {
    public static void e0(AbstractCollection abstractCollection, Collection elements) {
        kotlin.jvm.internal.j.e(elements, "elements");
        abstractCollection.addAll(elements);
    }
}
