package m2;

import m2.AbstractC2351d;

/* JADX INFO: renamed from: m2.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2343A extends AbstractC2351d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f21335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte f21336c;

    @Override // m2.AbstractC2351d.a
    public final AbstractC2351d a() {
        if (this.f21336c == 3) {
            return new C2345C(this.f21334a, this.f21335b, null);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f21336c & 1) == 0) {
            sb.append(" appUpdateType");
        }
        if ((this.f21336c & 2) == 0) {
            sb.append(" allowAssetPackDeletion");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // m2.AbstractC2351d.a
    public final AbstractC2351d.a b(boolean z7) {
        this.f21335b = z7;
        this.f21336c = (byte) (this.f21336c | 2);
        return this;
    }

    public final AbstractC2351d.a c(int i8) {
        this.f21334a = i8;
        this.f21336c = (byte) (this.f21336c | 1);
        return this;
    }
}
