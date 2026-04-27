package V4;

import kotlin.jvm.internal.j;

/* JADX INFO: loaded from: classes.dex */
public final class c extends a {
    static {
        new c((char) 1, (char) 0);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        char c6 = this.f3291a;
        char c7 = this.f3292b;
        if (j.f(c6, c7) > 0) {
            c cVar = (c) obj;
            if (j.f(cVar.f3291a, cVar.f3292b) > 0) {
                return true;
            }
        }
        c cVar2 = (c) obj;
        return c6 == cVar2.f3291a && c7 == cVar2.f3292b;
    }

    public final int hashCode() {
        char c6 = this.f3291a;
        char c7 = this.f3292b;
        if (j.f(c6, c7) > 0) {
            return -1;
        }
        return (c6 * 31) + c7;
    }

    public final String toString() {
        return this.f3291a + ".." + this.f3292b;
    }
}
