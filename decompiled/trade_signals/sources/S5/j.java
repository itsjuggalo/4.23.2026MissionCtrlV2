package S5;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {
    public static final h a(h first, h second) {
        AbstractC2304t.f(first, "first");
        AbstractC2304t.f(second, "second");
        return first.isEmpty() ? second : second.isEmpty() ? first : new o(first, second);
    }
}
