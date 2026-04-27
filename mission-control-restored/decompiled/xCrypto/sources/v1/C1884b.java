package v1;

/* JADX INFO: renamed from: v1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1884b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15291a = 1;

    public C1884b a(Object obj) {
        this.f15291a = (this.f15291a * 31) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    public int b() {
        return this.f15291a;
    }

    public final C1884b c(boolean z4) {
        this.f15291a = (this.f15291a * 31) + (z4 ? 1 : 0);
        return this;
    }
}
