package x3;

import g3.k;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f24191a = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f24192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k f24193b;

        public a(Class cls, k kVar) {
            this.f24192a = cls;
            this.f24193b = kVar;
        }

        public boolean a(Class cls) {
            return this.f24192a.isAssignableFrom(cls);
        }
    }

    public synchronized void a(Class cls, k kVar) {
        this.f24191a.add(new a(cls, kVar));
    }

    public synchronized k b(Class cls) {
        int size = this.f24191a.size();
        for (int i10 = 0; i10 < size; i10++) {
            a aVar = (a) this.f24191a.get(i10);
            if (aVar.a(cls)) {
                return aVar.f24193b;
            }
        }
        return null;
    }
}
