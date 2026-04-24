package K2;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f1301b = Logger.getLogger(r.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r f1302c = new r();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1303a = 0;

    public interface a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f1304a;

        static {
            AtomicReference atomicReference = new AtomicReference();
            f1304a = a(atomicReference);
            Throwable th = (Throwable) atomicReference.get();
            if (th != null) {
                r.f1301b.log(Level.FINE, "Storage override doesn't exist. Using default", th);
            }
        }

        public static c a(AtomicReference atomicReference) {
            try {
                return (c) Class.forName("io.grpc.override.ContextStorageOverride").asSubclass(c.class).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e4) {
                atomicReference.set(e4);
                return new q0();
            } catch (Exception e5) {
                throw new RuntimeException("Storage override failed to initialize", e5);
            }
        }
    }

    public static abstract class c {
        public abstract r a();

        public abstract void b(r rVar, r rVar2);

        public abstract r c(r rVar);
    }

    public r() {
        k(0);
    }

    public static Object d(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public static r e() {
        r rVarA = j().a();
        return rVarA == null ? f1302c : rVarA;
    }

    public static c j() {
        return b.f1304a;
    }

    public static void k(int i4) {
        if (i4 == 1000) {
            f1301b.log(Level.SEVERE, "Context ancestry chain length is abnormally long. This suggests an error in application code. Length exceeded: 1000", (Throwable) new Exception());
        }
    }

    public void a(a aVar, Executor executor) {
        d(aVar, "cancellationListener");
        d(executor, "executor");
    }

    public r b() {
        r rVarC = j().c(this);
        return rVarC == null ? f1302c : rVarC;
    }

    public Throwable c() {
        return null;
    }

    public void f(r rVar) {
        d(rVar, "toAttach");
        j().b(this, rVar);
    }

    public C0371t g() {
        return null;
    }

    public boolean h() {
        return false;
    }

    public void i(a aVar) {
    }
}
