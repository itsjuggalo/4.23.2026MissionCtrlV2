package p5;

import java.util.Collections;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;
import q5.C2641h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Q {
    public static Set a(Set builder) {
        AbstractC2304t.f(builder, "builder");
        return ((C2641h) builder).d();
    }

    public static Set b() {
        return new C2641h();
    }

    public static Set c(Object obj) {
        Set setSingleton = Collections.singleton(obj);
        AbstractC2304t.e(setSingleton, "singleton(...)");
        return setSingleton;
    }
}
