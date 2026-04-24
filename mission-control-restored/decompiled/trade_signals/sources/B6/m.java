package B6;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m {
    public static final Set a(Iterable iterable) {
        AbstractC2304t.f(iterable, "<this>");
        HashSet hashSet = new HashSet();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Set setF = ((k) it.next()).f();
            if (setF == null) {
                return null;
            }
            p5.v.x(hashSet, setF);
        }
        return hashSet;
    }
}
