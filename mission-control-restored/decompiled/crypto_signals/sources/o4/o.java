package o4;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Double f8716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Double f8717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f8718c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && o.class == obj.getClass()) {
            o oVar = (o) obj;
            if (Objects.equals(this.f8716a, oVar.f8716a) && Objects.equals(this.f8717b, oVar.f8717b) && this.f8718c.equals(oVar.f8718c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f8716a, this.f8717b, this.f8718c);
    }
}
