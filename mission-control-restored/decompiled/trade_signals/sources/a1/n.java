package a1;

import java.util.Collections;
import java.util.List;
import q1.AbstractC2628k;

/* JADX INFO: loaded from: classes.dex */
public interface n {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final U0.f f9865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f9866b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bumptech.glide.load.data.d f9867c;

        public a(U0.f fVar, com.bumptech.glide.load.data.d dVar) {
            this(fVar, Collections.emptyList(), dVar);
        }

        public a(U0.f fVar, List list, com.bumptech.glide.load.data.d dVar) {
            this.f9865a = (U0.f) AbstractC2628k.d(fVar);
            this.f9866b = (List) AbstractC2628k.d(list);
            this.f9867c = (com.bumptech.glide.load.data.d) AbstractC2628k.d(dVar);
        }
    }

    a a(Object obj, int i8, int i9, U0.h hVar);

    boolean b(Object obj);
}
