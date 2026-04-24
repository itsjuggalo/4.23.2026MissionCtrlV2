package X2;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class P {
    public static Set a(Object obj) {
        Set setSingleton = Collections.singleton(obj);
        kotlin.jvm.internal.r.e(setSingleton, "singleton(...)");
        return setSingleton;
    }
}
