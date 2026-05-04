package m9;

import java.util.List;
import rb.k1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class y0 {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends y0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f16337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f16338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final j9.k f16339c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final j9.r f16340d;

        public b(List list, List list2, j9.k kVar, j9.r rVar) {
            super();
            this.f16337a = list;
            this.f16338b = list2;
            this.f16339c = kVar;
            this.f16340d = rVar;
        }

        public j9.k a() {
            return this.f16339c;
        }

        public j9.r b() {
            return this.f16340d;
        }

        public List c() {
            return this.f16338b;
        }

        public List d() {
            return this.f16337a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class == obj.getClass()) {
                b bVar = (b) obj;
                if (!this.f16337a.equals(bVar.f16337a) || !this.f16338b.equals(bVar.f16338b) || !this.f16339c.equals(bVar.f16339c)) {
                    return false;
                }
                j9.r rVar = this.f16340d;
                j9.r rVar2 = bVar.f16340d;
                if (rVar != null) {
                    return rVar.equals(rVar2);
                }
                if (rVar2 == null) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int iHashCode = ((((this.f16337a.hashCode() * 31) + this.f16338b.hashCode()) * 31) + this.f16339c.hashCode()) * 31;
            j9.r rVar = this.f16340d;
            return iHashCode + (rVar != null ? rVar.hashCode() : 0);
        }

        public String toString() {
            return "DocumentChange{updatedTargetIds=" + this.f16337a + ", removedTargetIds=" + this.f16338b + ", key=" + this.f16339c + ", newDocument=" + this.f16340d + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends y0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f16341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r f16342b;

        public c(int i10, r rVar) {
            super();
            this.f16341a = i10;
            this.f16342b = rVar;
        }

        public r a() {
            return this.f16342b;
        }

        public int b() {
            return this.f16341a;
        }

        public String toString() {
            return "ExistenceFilterWatchChange{targetId=" + this.f16341a + ", existenceFilter=" + this.f16342b + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends y0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f16343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f16344b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.google.protobuf.i f16345c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final k1 f16346d;

        public d(e eVar, List list, com.google.protobuf.i iVar, k1 k1Var) {
            super();
            n9.b.d(k1Var == null || eVar == e.Removed, "Got cause for a target change that was not a removal", new Object[0]);
            this.f16343a = eVar;
            this.f16344b = list;
            this.f16345c = iVar;
            if (k1Var == null || k1Var.p()) {
                this.f16346d = null;
            } else {
                this.f16346d = k1Var;
            }
        }

        public k1 a() {
            return this.f16346d;
        }

        public e b() {
            return this.f16343a;
        }

        public com.google.protobuf.i c() {
            return this.f16345c;
        }

        public List d() {
            return this.f16344b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && d.class == obj.getClass()) {
                d dVar = (d) obj;
                if (this.f16343a != dVar.f16343a || !this.f16344b.equals(dVar.f16344b) || !this.f16345c.equals(dVar.f16345c)) {
                    return false;
                }
                k1 k1Var = this.f16346d;
                if (k1Var != null) {
                    return dVar.f16346d != null && k1Var.n().equals(dVar.f16346d.n());
                }
                if (dVar.f16346d == null) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int iHashCode = ((((this.f16343a.hashCode() * 31) + this.f16344b.hashCode()) * 31) + this.f16345c.hashCode()) * 31;
            k1 k1Var = this.f16346d;
            return iHashCode + (k1Var != null ? k1Var.n().hashCode() : 0);
        }

        public String toString() {
            return "WatchTargetChange{changeType=" + this.f16343a + ", targetIds=" + this.f16344b + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum e {
        NoChange,
        Added,
        Removed,
        Current,
        Reset
    }

    public y0() {
    }
}
