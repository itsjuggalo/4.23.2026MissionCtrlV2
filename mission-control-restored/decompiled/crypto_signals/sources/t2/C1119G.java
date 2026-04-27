package t2;

import java.util.List;
import s3.AbstractC1024h;

/* JADX INFO: renamed from: t2.G, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1119G extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f9955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9956b;

    public C1119G(String str, List list) {
        this.f9955a = list;
        this.f9956b = str;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof t0) {
            t0 t0Var = (t0) obj;
            if (this.f9955a.equals(((C1119G) t0Var).f9955a) && ((str = this.f9956b) != null ? str.equals(((C1119G) t0Var).f9956b) : ((C1119G) t0Var).f9956b == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f9955a.hashCode() ^ 1000003) * 1000003;
        String str = this.f9956b;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FilesPayload{files=");
        sb.append(this.f9955a);
        sb.append(", orgId=");
        return AbstractC1024h.d(sb, this.f9956b, "}");
    }
}
