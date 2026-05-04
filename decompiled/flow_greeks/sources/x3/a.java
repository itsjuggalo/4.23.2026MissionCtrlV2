package x3;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f24177a = new ArrayList();

    /* JADX INFO: renamed from: x3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0422a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f24178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g3.d f24179b;

        public C0422a(Class cls, g3.d dVar) {
            this.f24178a = cls;
            this.f24179b = dVar;
        }

        public boolean a(Class cls) {
            return this.f24178a.isAssignableFrom(cls);
        }
    }

    public synchronized void a(Class cls, g3.d dVar) {
        this.f24177a.add(new C0422a(cls, dVar));
    }

    public synchronized g3.d b(Class cls) {
        for (C0422a c0422a : this.f24177a) {
            if (c0422a.a(cls)) {
                return c0422a.f24179b;
            }
        }
        return null;
    }
}
