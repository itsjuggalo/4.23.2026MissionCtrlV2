package t2;

import s3.AbstractC1024h;

/* JADX INFO: renamed from: t2.F, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1118F extends r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9954b;

    public C1118F(String str, String str2) {
        this.f9953a = str;
        this.f9954b = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r0) {
            r0 r0Var = (r0) obj;
            if (this.f9953a.equals(((C1118F) r0Var).f9953a) && this.f9954b.equals(((C1118F) r0Var).f9954b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f9953a.hashCode() ^ 1000003) * 1000003) ^ this.f9954b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CustomAttribute{key=");
        sb.append(this.f9953a);
        sb.append(", value=");
        return AbstractC1024h.d(sb, this.f9954b, "}");
    }
}
