package g9;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class p extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f10323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bb.d0 f10324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j9.q f10325c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10326a;

        static {
            int[] iArr = new int[b.values().length];
            f10326a = iArr;
            try {
                iArr[b.LESS_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10326a[b.LESS_THAN_OR_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10326a[b.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10326a[b.NOT_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10326a[b.GREATER_THAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10326a[b.GREATER_THAN_OR_EQUAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum b {
        LESS_THAN("<"),
        LESS_THAN_OR_EQUAL("<="),
        EQUAL("=="),
        NOT_EQUAL("!="),
        GREATER_THAN(">"),
        GREATER_THAN_OR_EQUAL(">="),
        ARRAY_CONTAINS("array_contains"),
        ARRAY_CONTAINS_ANY("array_contains_any"),
        IN("in"),
        NOT_IN("not_in");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10338a;

        b(String str) {
            this.f10338a = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f10338a;
        }
    }

    public p(j9.q qVar, b bVar, bb.d0 d0Var) {
        this.f10325c = qVar;
        this.f10323a = bVar;
        this.f10324b = d0Var;
    }

    public static p e(j9.q qVar, b bVar, bb.d0 d0Var) {
        if (!qVar.G()) {
            return bVar == b.ARRAY_CONTAINS ? new f(qVar, d0Var) : bVar == b.IN ? new r0(qVar, d0Var) : bVar == b.ARRAY_CONTAINS_ANY ? new e(qVar, d0Var) : bVar == b.NOT_IN ? new y0(qVar, d0Var) : new p(qVar, bVar, d0Var);
        }
        if (bVar == b.IN) {
            return new t0(qVar, d0Var);
        }
        if (bVar == b.NOT_IN) {
            return new u0(qVar, d0Var);
        }
        n9.b.d((bVar == b.ARRAY_CONTAINS || bVar == b.ARRAY_CONTAINS_ANY) ? false : true, bVar.toString() + "queries don't make sense on document keys", new Object[0]);
        return new s0(qVar, bVar, d0Var);
    }

    @Override // g9.q
    public String a() {
        return f().c() + g().toString() + j9.y.b(h());
    }

    @Override // g9.q
    public List b() {
        return Collections.singletonList(this);
    }

    @Override // g9.q
    public List c() {
        return Collections.singletonList(this);
    }

    @Override // g9.q
    public boolean d(j9.h hVar) {
        bb.d0 d0VarH = hVar.h(this.f10325c);
        return this.f10323a == b.NOT_EQUAL ? (d0VarH == null || d0VarH.x0() || !j(j9.y.i(d0VarH, this.f10324b))) ? false : true : d0VarH != null && j9.y.I(d0VarH) == j9.y.I(this.f10324b) && j(j9.y.i(d0VarH, this.f10324b));
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof p)) {
            p pVar = (p) obj;
            if (this.f10323a == pVar.f10323a && this.f10325c.equals(pVar.f10325c) && this.f10324b.equals(pVar.f10324b)) {
                return true;
            }
        }
        return false;
    }

    public j9.q f() {
        return this.f10325c;
    }

    public b g() {
        return this.f10323a;
    }

    public bb.d0 h() {
        return this.f10324b;
    }

    public int hashCode() {
        return ((((1147 + this.f10323a.hashCode()) * 31) + this.f10325c.hashCode()) * 31) + this.f10324b.hashCode();
    }

    public boolean i() {
        return Arrays.asList(b.LESS_THAN, b.LESS_THAN_OR_EQUAL, b.GREATER_THAN, b.GREATER_THAN_OR_EQUAL, b.NOT_EQUAL, b.NOT_IN).contains(this.f10323a);
    }

    public boolean j(int i10) {
        switch (a.f10326a[this.f10323a.ordinal()]) {
            case 1:
                return i10 < 0;
            case 2:
                return i10 <= 0;
            case 3:
                return i10 == 0;
            case 4:
                return i10 != 0;
            case 5:
                return i10 > 0;
            case 6:
                return i10 >= 0;
            default:
                throw n9.b.a("Unknown FieldFilter operator: %s", this.f10323a);
        }
    }

    public String toString() {
        return a();
    }
}
