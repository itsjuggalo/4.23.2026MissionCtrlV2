package n4;

import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f8587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f8588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f8589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f8590d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Boolean f8591f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f8592g;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f.class == obj.getClass()) {
            f fVar = (f) obj;
            if (this.f8587a.equals(fVar.f8587a) && this.f8588b.equals(fVar.f8588b) && Objects.equals(this.f8589c, fVar.f8589c) && Objects.equals(this.f8590d, fVar.f8590d) && Objects.equals(this.e, fVar.e) && this.f8591f.equals(fVar.f8591f) && Objects.equals(this.f8592g, fVar.f8592g)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f8587a, this.f8588b, this.f8589c, this.f8590d, this.e, this.f8591f, this.f8592g);
    }
}
