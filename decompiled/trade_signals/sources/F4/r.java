package F4;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f1893b = Logger.getLogger(r.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r f1894c = new r();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1895a = 0;

    public interface a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f1896a;

        static {
            AtomicReference atomicReference = new AtomicReference();
            f1896a = a(atomicReference);
            Throwable th = (Throwable) atomicReference.get();
            if (th != null) {
                r.f1893b.log(Level.FINE, "Storage override doesn't exist. Using default", th);
            }
        }

        public static c a(AtomicReference atomicReference) {
            try {
                return (c) Class.forName("io.grpc.override.ContextStorageOverride").asSubclass(c.class).getConstructor(null).newInstance(null);
            } catch (ClassNotFoundException e8) {
                atomicReference.set(e8);
                return new o0();
            } catch (Exception e9) {
                throw new RuntimeException("Storage override failed to initialize", e9);
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
        return rVarA == null ? f1894c : rVarA;
    }

    public static c j() {
        return b.f1896a;
    }

    public static void k(int i8) {
        if (i8 == 1000) {
            f1893b.log(Level.SEVERE, "Context ancestry chain length is abnormally long. This suggests an error in application code. Length exceeded: 1000", (Throwable) new Exception());
        }
    }

    public void a(a aVar, Executor executor) {
        d(aVar, "cancellationListener");
        d(executor, "executor");
    }

    public r b() {
        r rVarC = j().c(this);
        return rVarC == null ? f1894c : rVarC;
    }

    public Throwable c() {
        return null;
    }

    public void f(r rVar) {
        d(rVar, "toAttach");
        j().b(this, rVar);
    }

    public C0505t g() {
        return null;
    }

    public boolean h() {
        return false;
    }

    public void i(a aVar) {
    }
}
