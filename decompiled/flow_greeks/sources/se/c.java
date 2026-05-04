package se;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface c {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f20224a = new a();

        @Override // se.c
        public Set a() {
            return dd.u0.d();
        }

        @Override // se.c
        public ve.w b(ef.f name) {
            kotlin.jvm.internal.t.f(name, "name");
            return null;
        }

        @Override // se.c
        public Set c() {
            return dd.u0.d();
        }

        @Override // se.c
        public ve.n d(ef.f name) {
            kotlin.jvm.internal.t.f(name, "name");
            return null;
        }

        @Override // se.c
        public Set f() {
            return dd.u0.d();
        }

        @Override // se.c
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public List e(ef.f name) {
            kotlin.jvm.internal.t.f(name, "name");
            return dd.r.k();
        }
    }

    Set a();

    ve.w b(ef.f fVar);

    Set c();

    ve.n d(ef.f fVar);

    Collection e(ef.f fVar);

    Set f();
}
