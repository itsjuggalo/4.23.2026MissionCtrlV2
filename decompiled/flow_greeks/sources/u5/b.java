package u5;

import com.google.android.gms.common.internal.s;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadFactory f22171b = Executors.defaultThreadFactory();

    public b(String str) {
        s.l(str, "Name must not be null");
        this.f22170a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f22171b.newThread(new c(runnable, 0));
        threadNewThread.setName(this.f22170a);
        return threadNewThread;
    }
}
