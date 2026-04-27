package t2;

import s3.AbstractC1024h;

/* JADX INFO: renamed from: t2.g0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1151g0 extends H0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10113b;

    public C1151g0(String str, String str2) {
        this.f10112a = str;
        this.f10113b = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof H0) {
            H0 h02 = (H0) obj;
            if (this.f10112a.equals(((C1151g0) h02).f10112a) && this.f10113b.equals(((C1151g0) h02).f10113b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f10112a.hashCode() ^ 1000003) * 1000003) ^ this.f10113b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RolloutVariant{rolloutId=");
        sb.append(this.f10112a);
        sb.append(", variantId=");
        return AbstractC1024h.d(sb, this.f10113b, "}");
    }
}
