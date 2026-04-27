package r5;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f22791b = Logger.getLogger(r.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r f22792c = new r();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22793a = 0;

    public interface a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f22794a;

        static {
            AtomicReference atomicReference = new AtomicReference();
            f22794a = a(atomicReference);
            Throwable th = (Throwable) atomicReference.get();
            if (th != null) {
                r.f22791b.log(Level.FINE, "Storage override doesn't exist. Using default", th);
            }
        }

        public static c a(AtomicReference atomicReference) {
            try {
                return (c) Class.forName("io.grpc.override.ContextStorageOverride").asSubclass(c.class).getConstructor(null).newInstance(null);
            } catch (ClassNotFoundException e7) {
                atomicReference.set(e7);
                return new q0();
            } catch (Exception e8) {
                throw new RuntimeException("Storage override failed to initialize", e8);
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
        return rVarA == null ? f22792c : rVarA;
    }

    public static c j() {
        return b.f22794a;
    }

    public static void k(int i7) {
        if (i7 == 1000) {
            f22791b.log(Level.SEVERE, "Context ancestry chain length is abnormally long. This suggests an error in application code. Length exceeded: 1000", (Throwable) new Exception());
        }
    }

    public void a(a aVar, Executor executor) {
        d(aVar, "cancellationListener");
        d(executor, "executor");
    }

    public r b() {
        r rVarC = j().c(this);
        return rVarC == null ? f22792c : rVarC;
    }

    public Throwable c() {
        return null;
    }

    public void f(r rVar) {
        d(rVar, "toAttach");
        j().b(this, rVar);
    }

    public C2603t g() {
        return null;
    }

    public boolean h() {
        return false;
    }

    public void i(a aVar) {
    }
}
