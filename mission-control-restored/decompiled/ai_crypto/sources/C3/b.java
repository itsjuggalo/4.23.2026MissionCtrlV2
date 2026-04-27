package C3;

import G3.k;
import G3.r;

/* JADX INFO: loaded from: classes.dex */
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r f1032a;

    public b(r rVar) {
        this.f1032a = rVar;
    }

    public r a() {
        return this.f1032a;
    }

    public k b() {
        return this.f1032a.getKey();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f1032a.equals(((b) obj).f1032a);
    }

    public int hashCode() {
        return this.f1032a.hashCode();
    }
}
