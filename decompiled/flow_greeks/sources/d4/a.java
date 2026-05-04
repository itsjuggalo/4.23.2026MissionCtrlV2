package d4;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f7822a = new C0144a();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements d {
        @Override // d4.a.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public List a() {
            return new ArrayList();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements g {
        @Override // d4.a.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(List list) {
            list.clear();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface d {
        Object a();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e implements s0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f7823a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g f7824b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final s0.c f7825c;

        public e(s0.c cVar, d dVar, g gVar) {
            this.f7825c = cVar;
            this.f7823a = dVar;
            this.f7824b = gVar;
        }

        @Override // s0.c
        public boolean a(Object obj) {
            if (obj instanceof f) {
                ((f) obj).i().b(true);
            }
            this.f7824b.a(obj);
            return this.f7825c.a(obj);
        }

        @Override // s0.c
        public Object b() {
            Object objB = this.f7825c.b();
            if (objB == null) {
                objB = this.f7823a.a();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + objB.getClass());
                }
            }
            if (objB instanceof f) {
                ((f) objB).i().b(false);
            }
            return objB;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface f {
        d4.c i();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface g {
        void a(Object obj);
    }

    public static s0.c a(s0.c cVar, d dVar) {
        return b(cVar, dVar, c());
    }

    public static s0.c b(s0.c cVar, d dVar, g gVar) {
        return new e(cVar, dVar, gVar);
    }

    public static g c() {
        return f7822a;
    }

    public static s0.c d(int i10, d dVar) {
        return a(new s0.e(i10), dVar);
    }

    public static s0.c e() {
        return f(20);
    }

    public static s0.c f(int i10) {
        return b(new s0.e(i10), new b(), new c());
    }

    /* JADX INFO: renamed from: d4.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class C0144a implements g {
        @Override // d4.a.g
        public void a(Object obj) {
        }
    }
}
