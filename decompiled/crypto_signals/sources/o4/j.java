package o4;

import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f8703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f8704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f8705c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && j.class == obj.getClass()) {
            j jVar = (j) obj;
            if (this.f8703a.equals(jVar.f8703a) && Objects.equals(this.f8704b, jVar.f8704b) && this.f8705c.equals(jVar.f8705c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f8703a, this.f8704b, this.f8705c);
    }
}
