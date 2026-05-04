package g5;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10053a = 1;

    public b a(Object obj) {
        this.f10053a = (this.f10053a * 31) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    public int b() {
        return this.f10053a;
    }

    public final b c(boolean z10) {
        this.f10053a = (this.f10053a * 31) + (z10 ? 1 : 0);
        return this;
    }
}
