package qf;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m {
    public static final Set a(Iterable iterable) {
        kotlin.jvm.internal.t.f(iterable, "<this>");
        HashSet hashSet = new HashSet();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Set setF = ((k) it.next()).f();
            if (setF == null) {
                return null;
            }
            dd.w.z(hashSet, setF);
        }
        return hashSet;
    }
}
