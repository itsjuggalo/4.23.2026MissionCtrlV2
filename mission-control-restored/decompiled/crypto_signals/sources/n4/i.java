package n4;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f8597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f8598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f8599d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f8600f;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && i.class == obj.getClass()) {
            i iVar = (i) obj;
            if (Objects.equals(this.f8596a, iVar.f8596a) && this.f8597b.equals(iVar.f8597b) && this.f8598c.equals(iVar.f8598c) && Objects.equals(this.f8599d, iVar.f8599d) && Objects.equals(this.e, iVar.e) && Objects.equals(this.f8600f, iVar.f8600f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f8596a, this.f8597b, this.f8598c, this.f8599d, this.e, this.f8600f);
    }
}
