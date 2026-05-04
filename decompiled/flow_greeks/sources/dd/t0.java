package dd;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class t0 {
    public static Set a(Set builder) {
        kotlin.jvm.internal.t.f(builder, "builder");
        return ((ed.h) builder).c();
    }

    public static Set b() {
        return new ed.h();
    }

    public static Set c(Object obj) {
        Set setSingleton = Collections.singleton(obj);
        kotlin.jvm.internal.t.e(setSingleton, "singleton(...)");
        return setSingleton;
    }
}
