package u4;

/* JADX INFO: loaded from: classes.dex */
public final class m0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f10461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10463c;

    public m0(Runnable runnable) {
        this.f10461a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f10462b) {
            return;
        }
        this.f10463c = true;
        this.f10461a.run();
    }
}
