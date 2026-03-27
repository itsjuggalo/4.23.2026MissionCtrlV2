package C1;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadFactory f183b = Executors.defaultThreadFactory();

    public a(String str) {
        this.f182a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f183b.newThread(new b(runnable, 0));
        threadNewThread.setName(this.f182a);
        return threadNewThread;
    }
}
