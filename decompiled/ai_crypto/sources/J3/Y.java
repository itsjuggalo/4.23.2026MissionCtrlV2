package J3;

import J3.a0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import k4.C2116g;

/* JADX INFO: loaded from: classes.dex */
public final class Y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Y f3162b = new Y();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f3163a = new CopyOnWriteArrayList();

    public static abstract class a {
        public static a d(C0598m c0598m, boolean z7, int i7, int i8, int i9) {
            return new C0596k(c0598m, z7, i7, i8, i9);
        }

        public static a e(C0598m c0598m, a0.b bVar, r rVar) {
            C2116g c2116gB = rVar.b();
            if (c2116gB == null) {
                return null;
            }
            return d(c0598m, bVar == a0.b.SUCCESS, c2116gB.c0(), c2116gB.a0().a0().size(), c2116gB.a0().c0());
        }

        public abstract boolean a();

        public abstract int b();

        public abstract C0598m c();

        public abstract int f();

        public abstract int g();
    }

    public static abstract class b {
        public static b b(int i7, int i8, String str, String str2, a aVar) {
            return new C0597l(i7, i8, str, str2, aVar);
        }

        public static b e(int i7, r rVar, G3.f fVar, C0598m c0598m, a0.b bVar) {
            return b(i7, rVar.a(), fVar.i(), fVar.h(), a.e(c0598m, bVar, rVar));
        }

        public abstract a a();

        public abstract String c();

        public abstract int d();

        public abstract int f();

        public abstract String g();
    }

    public static Y a() {
        return f3162b;
    }

    public void b(b bVar) {
        Iterator it = this.f3163a.iterator();
        while (it.hasNext()) {
            android.support.v4.media.session.b.a(((AtomicReference) it.next()).get());
        }
    }
}
