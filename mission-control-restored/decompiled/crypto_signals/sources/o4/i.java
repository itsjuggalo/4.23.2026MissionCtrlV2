package o4;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f8702b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && i.class == obj.getClass()) {
            i iVar = (i) obj;
            if (this.f8701a.equals(iVar.f8701a) && Objects.equals(this.f8702b, iVar.f8702b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f8701a, this.f8702b);
    }
}
