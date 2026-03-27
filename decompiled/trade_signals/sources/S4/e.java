package S4;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends d {
    public e(Runnable runnable) {
        super(runnable);
    }

    @Override // S4.d
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(Runnable runnable) {
        runnable.run();
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return "RunnableDisposable(disposed=" + g() + ", " + get() + ")";
    }
}
