package K2;

import K2.k0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class Y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f1090c = Logger.getLogger(Y.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Y f1091d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f1092a = new LinkedHashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f1093b = Collections.EMPTY_LIST;

    public class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(X x4, X x5) {
            return x4.c() - x5.c();
        }
    }

    public static final class b implements k0.b {
        public b() {
        }

        @Override // K2.k0.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(X x4) {
            return x4.c();
        }

        @Override // K2.k0.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(X x4) {
            return x4.b();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static synchronized Y b() {
        try {
            if (f1091d == null) {
                List<X> listE = k0.e(X.class, c(), X.class.getClassLoader(), new b(null));
                f1091d = new Y();
                for (X x4 : listE) {
                    f1090c.fine("Service loader found " + x4);
                    f1091d.a(x4);
                }
                f1091d.f();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f1091d;
    }

    public static List c() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(N2.g.class);
        } catch (ClassNotFoundException e4) {
            f1090c.log(Level.FINE, "Unable to find OkHttpChannelProvider", (Throwable) e4);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.NettyChannelProvider"));
        } catch (ClassNotFoundException e5) {
            f1090c.log(Level.FINE, "Unable to find NettyChannelProvider", (Throwable) e5);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.UdsNettyChannelProvider"));
        } catch (ClassNotFoundException e6) {
            f1090c.log(Level.FINE, "Unable to find UdsNettyChannelProvider", (Throwable) e6);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void a(X x4) {
        Z1.m.e(x4.b(), "isAvailable() returned false");
        this.f1092a.add(x4);
    }

    public X d() {
        List listE = e();
        if (listE.isEmpty()) {
            return null;
        }
        return (X) listE.get(0);
    }

    public synchronized List e() {
        return this.f1093b;
    }

    public final synchronized void f() {
        ArrayList arrayList = new ArrayList(this.f1092a);
        Collections.sort(arrayList, Collections.reverseOrder(new a()));
        this.f1093b = Collections.unmodifiableList(arrayList);
    }
}
