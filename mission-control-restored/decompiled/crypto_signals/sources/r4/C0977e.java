package r4;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: r4.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0977e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f9474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f9475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f9476c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0977e.class == obj.getClass()) {
            C0977e c0977e = (C0977e) obj;
            if (this.f9474a.equals(c0977e.f9474a) && this.f9475b.equals(c0977e.f9475b) && this.f9476c.equals(c0977e.f9476c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f9474a, this.f9475b, this.f9476c);
    }
}
