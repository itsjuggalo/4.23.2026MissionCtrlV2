package r5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import r5.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class Y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f22580c = Logger.getLogger(Y.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Y f22581d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f22582a = new LinkedHashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f22583b = Collections.emptyList();

    public class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(X x7, X x8) {
            return x7.c() - x8.c();
        }
    }

    public static final class b implements k0.b {
        public b() {
        }

        @Override // r5.k0.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(X x7) {
            return x7.c();
        }

        @Override // r5.k0.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(X x7) {
            return x7.b();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static synchronized Y b() {
        try {
            if (f22581d == null) {
                List<X> listE = k0.e(X.class, c(), X.class.getClassLoader(), new b(null));
                f22581d = new Y();
                for (X x7 : listE) {
                    f22580c.fine("Service loader found " + x7);
                    f22581d.a(x7);
                }
                f22581d.f();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f22581d;
    }

    public static List c() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(u5.g.class);
        } catch (ClassNotFoundException e7) {
            f22580c.log(Level.FINE, "Unable to find OkHttpChannelProvider", (Throwable) e7);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.NettyChannelProvider"));
        } catch (ClassNotFoundException e8) {
            f22580c.log(Level.FINE, "Unable to find NettyChannelProvider", (Throwable) e8);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.UdsNettyChannelProvider"));
        } catch (ClassNotFoundException e9) {
            f22580c.log(Level.FINE, "Unable to find UdsNettyChannelProvider", (Throwable) e9);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void a(X x7) {
        H2.m.e(x7.b(), "isAvailable() returned false");
        this.f22582a.add(x7);
    }

    public X d() {
        List listE = e();
        if (listE.isEmpty()) {
            return null;
        }
        return (X) listE.get(0);
    }

    public synchronized List e() {
        return this.f22583b;
    }

    public final synchronized void f() {
        ArrayList arrayList = new ArrayList(this.f22582a);
        Collections.sort(arrayList, Collections.reverseOrder(new a()));
        this.f22583b = Collections.unmodifiableList(arrayList);
    }
}
