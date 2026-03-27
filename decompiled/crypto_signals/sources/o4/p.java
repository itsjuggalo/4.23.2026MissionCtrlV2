package o4;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f8719a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        return this.f8719a.equals(((p) obj).f8719a);
    }

    public final int hashCode() {
        return Objects.hash(this.f8719a);
    }
}
