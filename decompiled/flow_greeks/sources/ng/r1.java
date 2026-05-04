package ng;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r1 {
    public static final Executor a(k0 k0Var) {
        Executor executorE0;
        p1 p1Var = k0Var instanceof p1 ? (p1) k0Var : null;
        return (p1Var == null || (executorE0 = p1Var.e0()) == null) ? new b1(k0Var) : executorE0;
    }

    public static final k0 b(Executor executor) {
        k0 k0Var;
        b1 b1Var = executor instanceof b1 ? (b1) executor : null;
        return (b1Var == null || (k0Var = b1Var.f17075a) == null) ? new q1(executor) : k0Var;
    }

    public static final p1 c(ExecutorService executorService) {
        return new q1(executorService);
    }
}
