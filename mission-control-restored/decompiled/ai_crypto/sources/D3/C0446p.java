package D3;

import K3.AbstractC0612b;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import k4.C2105D;

/* JADX INFO: renamed from: D3.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0446p extends AbstractC0447q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f1399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2105D f1400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final G3.q f1401c;

    /* JADX INFO: renamed from: D3.p$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1402a;

        static {
            int[] iArr = new int[b.values().length];
            f1402a = iArr;
            try {
                iArr[b.LESS_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1402a[b.LESS_THAN_OR_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1402a[b.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1402a[b.NOT_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1402a[b.GREATER_THAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1402a[b.GREATER_THAN_OR_EQUAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: renamed from: D3.p$b */
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
        public final String f1414a;

        b(String str) {
            this.f1414a = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f1414a;
        }
    }

    public C0446p(G3.q qVar, b bVar, C2105D c2105d) {
        this.f1401c = qVar;
        this.f1399a = bVar;
        this.f1400b = c2105d;
    }

    public static C0446p e(G3.q qVar, b bVar, C2105D c2105d) {
        if (!qVar.x()) {
            return bVar == b.ARRAY_CONTAINS ? new C0436f(qVar, c2105d) : bVar == b.IN ? new S(qVar, c2105d) : bVar == b.ARRAY_CONTAINS_ANY ? new C0435e(qVar, c2105d) : bVar == b.NOT_IN ? new Z(qVar, c2105d) : new C0446p(qVar, bVar, c2105d);
        }
        if (bVar == b.IN) {
            return new U(qVar, c2105d);
        }
        if (bVar == b.NOT_IN) {
            return new V(qVar, c2105d);
        }
        AbstractC0612b.d((bVar == b.ARRAY_CONTAINS || bVar == b.ARRAY_CONTAINS_ANY) ? false : true, bVar.toString() + "queries don't make sense on document keys", new Object[0]);
        return new T(qVar, bVar, c2105d);
    }

    @Override // D3.AbstractC0447q
    public String a() {
        return f().c() + g().toString() + G3.y.b(h());
    }

    @Override // D3.AbstractC0447q
    public List b() {
        return Collections.singletonList(this);
    }

    @Override // D3.AbstractC0447q
    public List c() {
        return Collections.singletonList(this);
    }

    @Override // D3.AbstractC0447q
    public boolean d(G3.h hVar) {
        C2105D c2105dI = hVar.i(this.f1401c);
        return this.f1399a == b.NOT_EQUAL ? (c2105dI == null || c2105dI.x0() || !j(G3.y.i(c2105dI, this.f1400b))) ? false : true : c2105dI != null && G3.y.I(c2105dI) == G3.y.I(this.f1400b) && j(G3.y.i(c2105dI, this.f1400b));
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C0446p)) {
            return false;
        }
        C0446p c0446p = (C0446p) obj;
        return this.f1399a == c0446p.f1399a && this.f1401c.equals(c0446p.f1401c) && this.f1400b.equals(c0446p.f1400b);
    }

    public G3.q f() {
        return this.f1401c;
    }

    public b g() {
        return this.f1399a;
    }

    public C2105D h() {
        return this.f1400b;
    }

    public int hashCode() {
        return ((((1147 + this.f1399a.hashCode()) * 31) + this.f1401c.hashCode()) * 31) + this.f1400b.hashCode();
    }

    public boolean i() {
        return Arrays.asList(b.LESS_THAN, b.LESS_THAN_OR_EQUAL, b.GREATER_THAN, b.GREATER_THAN_OR_EQUAL, b.NOT_EQUAL, b.NOT_IN).contains(this.f1399a);
    }

    public boolean j(int i7) {
        switch (a.f1402a[this.f1399a.ordinal()]) {
            case 1:
                return i7 < 0;
            case 2:
                return i7 <= 0;
            case 3:
                return i7 == 0;
            case 4:
                return i7 != 0;
            case 5:
                return i7 > 0;
            case 6:
                return i7 >= 0;
            default:
                throw AbstractC0612b.a("Unknown FieldFilter operator: %s", this.f1399a);
        }
    }

    public String toString() {
        return a();
    }
}
