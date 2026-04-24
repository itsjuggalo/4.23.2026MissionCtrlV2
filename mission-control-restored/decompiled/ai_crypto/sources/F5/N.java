package F5;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class N {
    public static Set a(Object obj) {
        Set setSingleton = Collections.singleton(obj);
        kotlin.jvm.internal.r.e(setSingleton, "singleton(...)");
        return setSingleton;
    }
}
