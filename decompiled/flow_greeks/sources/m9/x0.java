package m9;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import m9.z0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class x0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x0 f16314b = new x0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f16315a = new CopyOnWriteArrayList();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class a {
        public static a d(m mVar, boolean z10, int i10, int i11, int i12) {
            return new k(mVar, z10, i10, i11, i12);
        }

        public static a e(m mVar, z0.b bVar, r rVar) {
            bb.g gVarB = rVar.b();
            if (gVarB == null) {
                return null;
            }
            return d(mVar, bVar == z0.b.SUCCESS, gVarB.c0(), gVarB.a0().a0().size(), gVarB.a0().c0());
        }

        public abstract boolean a();

        public abstract int b();

        public abstract m c();

        public abstract int f();

        public abstract int g();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class b {
        public static b b(int i10, int i11, String str, String str2, a aVar) {
            return new l(i10, i11, str, str2, aVar);
        }

        public static b e(int i10, r rVar, j9.f fVar, m mVar, z0.b bVar) {
            return b(i10, rVar.a(), fVar.i(), fVar.h(), a.e(mVar, bVar, rVar));
        }

        public abstract a a();

        public abstract String c();

        public abstract int d();

        public abstract int f();

        public abstract String g();
    }

    public static x0 a() {
        return f16314b;
    }

    public void b(b bVar) {
        Iterator it = this.f16315a.iterator();
        while (it.hasNext()) {
            android.support.v4.media.session.b.a(((AtomicReference) it.next()).get());
        }
    }
}
