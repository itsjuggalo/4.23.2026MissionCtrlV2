package C2;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Runnable f203b;

    public k(j jVar, Runnable runnable) {
        this.f202a = jVar;
        this.f203b = runnable;
    }

    public Integer a() {
        j jVar = this.f202a;
        if (jVar != null) {
            return Integer.valueOf(jVar.a());
        }
        return null;
    }

    public boolean b() {
        j jVar = this.f202a;
        return jVar != null && jVar.b();
    }
}
