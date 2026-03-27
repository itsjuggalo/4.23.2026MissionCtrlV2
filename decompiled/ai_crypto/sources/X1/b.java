package X1;

import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class b implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadFactory f5481b = Executors.defaultThreadFactory();

    public b(String str) {
        AbstractC1207s.l(str, "Name must not be null");
        this.f5480a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f5481b.newThread(new c(runnable, 0));
        threadNewThread.setName(this.f5480a);
        return threadNewThread;
    }
}
