package j8;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f0 {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends f0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y f13976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final l f13977b;

        public a(y yVar, l lVar) {
            this.f13976a = yVar;
            this.f13977b = lVar;
        }

        @Override // j8.f0
        public f0 a(r8.b bVar) {
            return new a(this.f13976a, this.f13977b.v(bVar));
        }

        @Override // j8.f0
        public r8.n b() {
            return this.f13976a.J(this.f13977b, new ArrayList());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends f0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r8.n f13978a;

        public b(r8.n nVar) {
            this.f13978a = nVar;
        }

        @Override // j8.f0
        public f0 a(r8.b bVar) {
            return new b(this.f13978a.z(bVar));
        }

        @Override // j8.f0
        public r8.n b() {
            return this.f13978a;
        }
    }

    public abstract f0 a(r8.b bVar);

    public abstract r8.n b();
}
