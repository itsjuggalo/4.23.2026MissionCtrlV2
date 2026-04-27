package P3;

/* JADX INFO: loaded from: classes.dex */
public final class D implements io.flutter.embedding.engine.renderer.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f2512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ F f2513b;

    public D(F f6, Runnable runnable) {
        this.f2513b = f6;
        this.f2512a = runnable;
    }

    @Override // io.flutter.embedding.engine.renderer.l
    public final void b() {
        this.f2512a.run();
        io.flutter.embedding.engine.renderer.k kVar = this.f2513b.f2515b;
        if (kVar != null) {
            kVar.g(this);
        }
    }

    @Override // io.flutter.embedding.engine.renderer.l
    public final void a() {
    }
}
