package o4;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f8727a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || u.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f8727a, ((u) obj).f8727a);
    }

    public final int hashCode() {
        return Objects.hash(this.f8727a);
    }
}
