package X1;

import com.google.android.gms.common.internal.AbstractC1294n;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadFactory f9364b = Executors.defaultThreadFactory();

    public a(String str) {
        AbstractC1294n.k(str, "Name must not be null");
        this.f9363a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f9364b.newThread(new b(runnable, 0));
        threadNewThread.setName(this.f9363a);
        return threadNewThread;
    }
}
