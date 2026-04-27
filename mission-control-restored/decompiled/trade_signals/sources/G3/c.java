package G3;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f2200a;

    public c(int i8) {
        this.f2200a = a.b(i8);
    }

    public static c b(int i8) {
        return new c(i8);
    }

    public Map a() {
        return this.f2200a.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f2200a);
    }

    public c c(Object obj, Object obj2) {
        this.f2200a.put(obj, obj2);
        return this;
    }
}
