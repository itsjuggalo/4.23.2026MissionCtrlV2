package okhttp3.internal;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NamedRunnable implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20669a;

    public NamedRunnable(String str, Object... objArr) {
        this.f20669a = Util.q(str, objArr);
    }

    public abstract void c();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f20669a);
        try {
            c();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
