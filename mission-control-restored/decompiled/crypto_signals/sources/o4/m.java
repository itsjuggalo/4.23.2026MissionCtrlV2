package o4;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f8711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f8712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f8713c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && m.class == obj.getClass()) {
            m mVar = (m) obj;
            if (this.f8711a.equals(mVar.f8711a) && this.f8712b.equals(mVar.f8712b) && Objects.equals(this.f8713c, mVar.f8713c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f8711a, this.f8712b, this.f8713c);
    }
}
