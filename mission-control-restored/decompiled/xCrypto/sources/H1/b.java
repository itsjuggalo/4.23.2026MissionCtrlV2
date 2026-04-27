package H1;

import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class b implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadFactory f712b = Executors.defaultThreadFactory();

    public b(String str) {
        AbstractC0940s.l(str, "Name must not be null");
        this.f711a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f712b.newThread(new c(runnable, 0));
        threadNewThread.setName(this.f711a);
        return threadNewThread;
    }
}
