package t9;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f20840a;

    public c(int i10) {
        this.f20840a = a.b(i10);
    }

    public static c b(int i10) {
        return new c(i10);
    }

    public Map a() {
        return this.f20840a.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f20840a);
    }

    public c c(Object obj, Object obj2) {
        this.f20840a.put(obj, obj2);
        return this;
    }
}
