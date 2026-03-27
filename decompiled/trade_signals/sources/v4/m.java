package v4;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f23850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Runnable f23851b;

    public m(l lVar, Runnable runnable) {
        this.f23850a = lVar;
        this.f23851b = runnable;
    }

    public Integer a() {
        l lVar = this.f23850a;
        if (lVar != null) {
            return Integer.valueOf(lVar.a());
        }
        return null;
    }

    public boolean b() {
        l lVar = this.f23850a;
        return lVar != null && lVar.b();
    }
}
