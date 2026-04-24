package o4;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f8723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r f8724b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && s.class == obj.getClass()) {
            s sVar = (s) obj;
            if (this.f8723a.equals(sVar.f8723a) && Objects.equals(this.f8724b, sVar.f8724b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f8723a, this.f8724b);
    }
}
