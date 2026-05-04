package m5;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f15944a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f15945b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f15946c = null;

    public /* synthetic */ l0(byte[] bArr) {
    }

    public final l0 a(String str) {
        this.f15944a = str;
        return this;
    }

    public final l0 b(boolean z10) {
        this.f15945b = Boolean.valueOf(z10);
        return this;
    }

    public final l0 c(boolean z10) {
        this.f15946c = Boolean.valueOf(z10);
        return this;
    }

    public final m0 d() {
        Boolean bool = this.f15945b;
        if (bool == null) {
            throw new IllegalStateException("allowTestKeys must be set");
        }
        if (this.f15946c != null) {
            return new m0(this.f15944a, bool.booleanValue(), false, false, this.f15946c.booleanValue(), false, null);
        }
        throw new IllegalStateException("isGoogleOrPlatformOnly must be set");
    }
}
