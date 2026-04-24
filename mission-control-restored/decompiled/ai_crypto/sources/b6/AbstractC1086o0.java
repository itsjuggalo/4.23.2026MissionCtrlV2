package b6;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: renamed from: b6.o0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1086o0 {
    public static final I a(Executor executor) {
        return new C1084n0(executor);
    }

    public static final AbstractC1082m0 b(ExecutorService executorService) {
        return new C1084n0(executorService);
    }
}
