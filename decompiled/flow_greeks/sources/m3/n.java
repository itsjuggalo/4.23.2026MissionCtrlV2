package m3;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public interface n {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g3.f f15803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f15804b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bumptech.glide.load.data.d f15805c;

        public a(g3.f fVar, com.bumptech.glide.load.data.d dVar) {
            this(fVar, Collections.EMPTY_LIST, dVar);
        }

        public a(g3.f fVar, List list, com.bumptech.glide.load.data.d dVar) {
            this.f15803a = (g3.f) c4.k.e(fVar);
            this.f15804b = (List) c4.k.e(list);
            this.f15805c = (com.bumptech.glide.load.data.d) c4.k.e(dVar);
        }
    }

    boolean a(Object obj);

    a b(Object obj, int i10, int i11, g3.h hVar);
}
