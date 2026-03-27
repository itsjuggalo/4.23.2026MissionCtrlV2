package m2;

/* JADX INFO: renamed from: m2.C, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2345C extends AbstractC2351d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21338b;

    public /* synthetic */ C2345C(int i8, boolean z7, AbstractC2344B abstractC2344B) {
        this.f21337a = i8;
        this.f21338b = z7;
    }

    @Override // m2.AbstractC2351d
    public final boolean a() {
        return this.f21338b;
    }

    @Override // m2.AbstractC2351d
    public final int b() {
        return this.f21337a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2351d) {
            AbstractC2351d abstractC2351d = (AbstractC2351d) obj;
            if (this.f21337a == abstractC2351d.b() && this.f21338b == abstractC2351d.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f21337a ^ 1000003) * 1000003) ^ (true != this.f21338b ? 1237 : 1231);
    }

    public final String toString() {
        return "AppUpdateOptions{appUpdateType=" + this.f21337a + ", allowAssetPackDeletion=" + this.f21338b + "}";
    }
}
