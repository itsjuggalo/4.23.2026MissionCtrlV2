package F2;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f510b;

    public c(Map map, String str) {
        this.f509a = str;
        this.f510b = map;
    }

    public static c a(String str) {
        return new c(Collections.EMPTY_MAP, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f509a.equals(cVar.f509a) && this.f510b.equals(cVar.f510b);
    }

    public final int hashCode() {
        return this.f510b.hashCode() + (this.f509a.hashCode() * 31);
    }

    public final String toString() {
        return "FieldDescriptor{name=" + this.f509a + ", properties=" + this.f510b.values() + "}";
    }
}
