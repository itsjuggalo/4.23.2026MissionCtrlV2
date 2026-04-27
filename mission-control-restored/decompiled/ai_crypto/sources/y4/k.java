package y4;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f25723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Runnable f25724b;

    public k(j jVar, Runnable runnable) {
        this.f25723a = jVar;
        this.f25724b = runnable;
    }

    public Integer a() {
        j jVar = this.f25723a;
        if (jVar != null) {
            return Integer.valueOf(jVar.a());
        }
        return null;
    }

    public boolean b() {
        j jVar = this.f25723a;
        return jVar != null && jVar.b();
    }
}
