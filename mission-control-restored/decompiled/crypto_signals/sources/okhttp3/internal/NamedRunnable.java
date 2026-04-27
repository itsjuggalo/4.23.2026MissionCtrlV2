package okhttp3.internal;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class NamedRunnable implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8826a;

    public NamedRunnable(String str, Object... objArr) {
        byte[] bArr = Util.f8827a;
        this.f8826a = String.format(Locale.US, str, objArr);
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f8826a);
        try {
            a();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
