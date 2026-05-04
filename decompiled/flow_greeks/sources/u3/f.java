package u3;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f22164a = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f22165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class f22166b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e f22167c;

        public a(Class cls, Class cls2, e eVar) {
            this.f22165a = cls;
            this.f22166b = cls2;
            this.f22167c = eVar;
        }

        public boolean a(Class cls, Class cls2) {
            return this.f22165a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f22166b);
        }
    }

    public synchronized e a(Class cls, Class cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.b();
        }
        for (a aVar : this.f22164a) {
            if (aVar.a(cls, cls2)) {
                return aVar.f22167c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized List b(Class cls, Class cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a aVar : this.f22164a) {
            if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f22166b)) {
                arrayList.add(aVar.f22166b);
            }
        }
        return arrayList;
    }

    public synchronized void c(Class cls, Class cls2, e eVar) {
        this.f22164a.add(new a(cls, cls2, eVar));
    }
}
