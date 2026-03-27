package K2;

import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class B extends D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f823b;

    public B(int i, List list) {
        this.f822a = list;
        this.f823b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || B.class != obj.getClass()) {
            return false;
        }
        B b3 = (B) obj;
        return this.f823b == b3.f823b && Objects.equals(this.f822a, b3.f822a);
    }

    public final int hashCode() {
        List list = this.f822a;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        int i = this.f823b;
        return iHashCode + (i != 0 ? S.i.c(i) : 0);
    }
}
