package J3;

import K3.AbstractC0612b;
import com.google.protobuf.AbstractC1240i;
import java.util.List;
import r5.l0;

/* JADX INFO: loaded from: classes.dex */
public abstract class Z {

    public static final class b extends Z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f3164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f3165b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final G3.k f3166c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final G3.r f3167d;

        public b(List list, List list2, G3.k kVar, G3.r rVar) {
            super();
            this.f3164a = list;
            this.f3165b = list2;
            this.f3166c = kVar;
            this.f3167d = rVar;
        }

        public G3.k a() {
            return this.f3166c;
        }

        public G3.r b() {
            return this.f3167d;
        }

        public List c() {
            return this.f3165b;
        }

        public List d() {
            return this.f3164a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (!this.f3164a.equals(bVar.f3164a) || !this.f3165b.equals(bVar.f3165b) || !this.f3166c.equals(bVar.f3166c)) {
                return false;
            }
            G3.r rVar = this.f3167d;
            G3.r rVar2 = bVar.f3167d;
            return rVar != null ? rVar.equals(rVar2) : rVar2 == null;
        }

        public int hashCode() {
            int iHashCode = ((((this.f3164a.hashCode() * 31) + this.f3165b.hashCode()) * 31) + this.f3166c.hashCode()) * 31;
            G3.r rVar = this.f3167d;
            return iHashCode + (rVar != null ? rVar.hashCode() : 0);
        }

        public String toString() {
            return "DocumentChange{updatedTargetIds=" + this.f3164a + ", removedTargetIds=" + this.f3165b + ", key=" + this.f3166c + ", newDocument=" + this.f3167d + '}';
        }
    }

    public static final class c extends Z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r f3169b;

        public c(int i7, r rVar) {
            super();
            this.f3168a = i7;
            this.f3169b = rVar;
        }

        public r a() {
            return this.f3169b;
        }

        public int b() {
            return this.f3168a;
        }

        public String toString() {
            return "ExistenceFilterWatchChange{targetId=" + this.f3168a + ", existenceFilter=" + this.f3169b + '}';
        }
    }

    public static final class d extends Z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f3170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f3171b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AbstractC1240i f3172c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final l0 f3173d;

        public d(e eVar, List list, AbstractC1240i abstractC1240i, l0 l0Var) {
            super();
            AbstractC0612b.d(l0Var == null || eVar == e.Removed, "Got cause for a target change that was not a removal", new Object[0]);
            this.f3170a = eVar;
            this.f3171b = list;
            this.f3172c = abstractC1240i;
            if (l0Var == null || l0Var.o()) {
                this.f3173d = null;
            } else {
                this.f3173d = l0Var;
            }
        }

        public l0 a() {
            return this.f3173d;
        }

        public e b() {
            return this.f3170a;
        }

        public AbstractC1240i c() {
            return this.f3172c;
        }

        public List d() {
            return this.f3171b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f3170a != dVar.f3170a || !this.f3171b.equals(dVar.f3171b) || !this.f3172c.equals(dVar.f3172c)) {
                return false;
            }
            l0 l0Var = this.f3173d;
            return l0Var != null ? dVar.f3173d != null && l0Var.m().equals(dVar.f3173d.m()) : dVar.f3173d == null;
        }

        public int hashCode() {
            int iHashCode = ((((this.f3170a.hashCode() * 31) + this.f3171b.hashCode()) * 31) + this.f3172c.hashCode()) * 31;
            l0 l0Var = this.f3173d;
            return iHashCode + (l0Var != null ? l0Var.m().hashCode() : 0);
        }

        public String toString() {
            return "WatchTargetChange{changeType=" + this.f3170a + ", targetIds=" + this.f3171b + '}';
        }
    }

    public enum e {
        NoChange,
        Added,
        Removed,
        Current,
        Reset
    }

    public Z() {
    }
}
