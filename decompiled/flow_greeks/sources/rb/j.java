package rb;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import rb.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f19576a = new a();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f19577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h f19578b;

        public /* synthetic */ b(d dVar, h hVar, i iVar) {
            this(dVar, hVar);
        }

        @Override // rb.d
        public String a() {
            return this.f19577a.a();
        }

        @Override // rb.d
        public g e(z0 z0Var, c cVar) {
            return this.f19578b.a(z0Var, cVar, this.f19577a);
        }

        public b(d dVar, h hVar) {
            this.f19577a = dVar;
            this.f19578b = (h) p6.n.o(hVar, "interceptor");
        }
    }

    public static d a(d dVar, List list) {
        p6.n.o(dVar, "channel");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            dVar = new b(dVar, (h) it.next(), null);
        }
        return dVar;
    }

    public static d b(d dVar, h... hVarArr) {
        return a(dVar, Arrays.asList(hVarArr));
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends g {
        @Override // rb.g
        public void b() {
        }

        @Override // rb.g
        public void c(int i10) {
        }

        @Override // rb.g
        public void d(Object obj) {
        }

        @Override // rb.g
        public void a(String str, Throwable th) {
        }

        @Override // rb.g
        public void e(g.a aVar, y0 y0Var) {
        }
    }
}
