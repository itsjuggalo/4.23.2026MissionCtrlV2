package u4;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

/* JADX INFO: renamed from: u4.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1231m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractC1232n f10460a;

    static {
        AbstractC1232n n0Var;
        AtomicReference atomicReference = new AtomicReference();
        try {
            n0Var = (AbstractC1232n) Class.forName("io.grpc.override.ContextStorageOverride").asSubclass(AbstractC1232n.class).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException e) {
            atomicReference.set(e);
            n0Var = new n0();
        } catch (Exception e2) {
            throw new RuntimeException("Storage override failed to initialize", e2);
        }
        f10460a = n0Var;
        Throwable th = (Throwable) atomicReference.get();
        if (th != null) {
            C1233o.f10466a.log(Level.FINE, "Storage override doesn't exist. Using default", th);
        }
    }
}
