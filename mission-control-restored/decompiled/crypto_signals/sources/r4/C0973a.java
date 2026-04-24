package r4;

import java.util.Objects;

/* JADX INFO: renamed from: r4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0973a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f9469a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0973a.class != obj.getClass()) {
            return false;
        }
        return this.f9469a.equals(((C0973a) obj).f9469a);
    }

    public final int hashCode() {
        return Objects.hash(this.f9469a);
    }
}
