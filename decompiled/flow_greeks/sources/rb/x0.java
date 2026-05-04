package rb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rb.j1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class x0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f19740c = Logger.getLogger(x0.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static x0 f19741d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f19742a = new LinkedHashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f19743b = Collections.EMPTY_LIST;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(w0 w0Var, w0 w0Var2) {
            return w0Var.c() - w0Var2.c();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements j1.b {
        public b() {
        }

        @Override // rb.j1.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(w0 w0Var) {
            return w0Var.c();
        }

        @Override // rb.j1.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(w0 w0Var) {
            return w0Var.b();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static synchronized x0 b() {
        try {
            if (f19741d == null) {
                List<w0> listE = j1.e(w0.class, c(), w0.class.getClassLoader(), new b(null));
                f19741d = new x0();
                for (w0 w0Var : listE) {
                    f19740c.fine("Service loader found " + w0Var);
                    f19741d.a(w0Var);
                }
                f19741d.f();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f19741d;
    }

    public static List c() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(ub.g.class);
        } catch (ClassNotFoundException e10) {
            f19740c.log(Level.FINE, "Unable to find OkHttpChannelProvider", (Throwable) e10);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.NettyChannelProvider"));
        } catch (ClassNotFoundException e11) {
            f19740c.log(Level.FINE, "Unable to find NettyChannelProvider", (Throwable) e11);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.UdsNettyChannelProvider"));
        } catch (ClassNotFoundException e12) {
            f19740c.log(Level.FINE, "Unable to find UdsNettyChannelProvider", (Throwable) e12);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void a(w0 w0Var) {
        p6.n.e(w0Var.b(), "isAvailable() returned false");
        this.f19742a.add(w0Var);
    }

    public w0 d() {
        List listE = e();
        if (listE.isEmpty()) {
            return null;
        }
        return (w0) listE.get(0);
    }

    public synchronized List e() {
        return this.f19743b;
    }

    public final synchronized void f() {
        ArrayList arrayList = new ArrayList(this.f19742a);
        Collections.sort(arrayList, Collections.reverseOrder(new a()));
        this.f19743b = Collections.unmodifiableList(arrayList);
    }
}
