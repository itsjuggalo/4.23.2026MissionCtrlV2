package F4;

import F4.i0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes.dex */
public final class W {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f1679c = Logger.getLogger(W.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static W f1680d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f1681a = new LinkedHashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f1682b = Collections.emptyList();

    public class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(V v8, V v9) {
            return v8.c() - v9.c();
        }
    }

    public static final class b implements i0.b {
        public b() {
        }

        @Override // F4.i0.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(V v8) {
            return v8.c();
        }

        @Override // F4.i0.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(V v8) {
            return v8.b();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static synchronized W b() {
        try {
            if (f1680d == null) {
                List<V> listE = i0.e(V.class, c(), V.class.getClassLoader(), new b(null));
                f1680d = new W();
                for (V v8 : listE) {
                    f1679c.fine("Service loader found " + v8);
                    f1680d.a(v8);
                }
                f1680d.f();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f1680d;
    }

    public static List c() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(H4.g.class);
        } catch (ClassNotFoundException e8) {
            f1679c.log(Level.FINE, "Unable to find OkHttpChannelProvider", (Throwable) e8);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.NettyChannelProvider"));
        } catch (ClassNotFoundException e9) {
            f1679c.log(Level.FINE, "Unable to find NettyChannelProvider", (Throwable) e9);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.UdsNettyChannelProvider"));
        } catch (ClassNotFoundException e10) {
            f1679c.log(Level.FINE, "Unable to find UdsNettyChannelProvider", (Throwable) e10);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void a(V v8) {
        AbstractC2848n.e(v8.b(), "isAvailable() returned false");
        this.f1681a.add(v8);
    }

    public V d() {
        List listE = e();
        if (listE.isEmpty()) {
            return null;
        }
        return (V) listE.get(0);
    }

    public synchronized List e() {
        return this.f1682b;
    }

    public final synchronized void f() {
        ArrayList arrayList = new ArrayList(this.f1681a);
        Collections.sort(arrayList, Collections.reverseOrder(new a()));
        this.f1682b = Collections.unmodifiableList(arrayList);
    }
}
