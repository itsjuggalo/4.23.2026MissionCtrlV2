package R2;

import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f2776b = new f(new HashSet());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f2777a;

    public f(HashSet hashSet) {
        this.f2777a = hashSet;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        return this.f2777a.equals(((f) obj).f2777a);
    }

    public final int hashCode() {
        return this.f2777a.hashCode();
    }

    public final String toString() {
        return "FieldMask{mask=" + this.f2777a.toString() + "}";
    }
}
