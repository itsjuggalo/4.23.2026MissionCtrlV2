package z;

import com.revenuecat.purchases.common.Constants;
import java.util.HashSet;
import java.util.Iterator;
import k4.C2105D;
import y.C2831c;
import y.i;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f25813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f25814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f25815d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public y.i f25818g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashSet f25812a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f25816e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f25817f = -1;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25819a;

        static {
            int[] iArr = new int[b.values().length];
            f25819a = iArr;
            try {
                iArr[b.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25819a[b.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25819a[b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25819a[b.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25819a[b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25819a[b.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25819a[b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f25819a[b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f25819a[b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public enum b {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public d(e eVar, b bVar) {
        this.f25813b = eVar;
        this.f25814c = bVar;
    }

    public boolean a(d dVar, int i7, int i8, boolean z7) {
        if (dVar == null) {
            k();
            return true;
        }
        if (!z7 && !j(dVar)) {
            return false;
        }
        this.f25815d = dVar;
        if (dVar.f25812a == null) {
            dVar.f25812a = new HashSet();
        }
        this.f25815d.f25812a.add(this);
        if (i7 > 0) {
            this.f25816e = i7;
        } else {
            this.f25816e = 0;
        }
        this.f25817f = i8;
        return true;
    }

    public int b() {
        d dVar;
        if (this.f25813b.M() == 8) {
            return 0;
        }
        return (this.f25817f <= -1 || (dVar = this.f25815d) == null || dVar.f25813b.M() != 8) ? this.f25816e : this.f25817f;
    }

    public final d c() {
        switch (a.f25819a[this.f25814c.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return null;
            case 2:
                return this.f25813b.f25834D;
            case 3:
                return this.f25813b.f25832B;
            case 4:
                return this.f25813b.f25835E;
            case 5:
                return this.f25813b.f25833C;
            default:
                throw new AssertionError(this.f25814c.name());
        }
    }

    public e d() {
        return this.f25813b;
    }

    public y.i e() {
        return this.f25818g;
    }

    public d f() {
        return this.f25815d;
    }

    public b g() {
        return this.f25814c;
    }

    public boolean h() {
        HashSet hashSet = this.f25812a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((d) it.next()).c().i()) {
                return true;
            }
        }
        return false;
    }

    public boolean i() {
        return this.f25815d != null;
    }

    public boolean j(d dVar) {
        if (dVar == null) {
            return false;
        }
        b bVarG = dVar.g();
        b bVar = this.f25814c;
        if (bVarG == bVar) {
            return bVar != b.BASELINE || (dVar.d().Q() && d().Q());
        }
        switch (a.f25819a[bVar.ordinal()]) {
            case 1:
                return (bVarG == b.BASELINE || bVarG == b.CENTER_X || bVarG == b.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z7 = bVarG == b.LEFT || bVarG == b.RIGHT;
                if (dVar.d() instanceof g) {
                    return z7 || bVarG == b.CENTER_X;
                }
                return z7;
            case 4:
            case 5:
                boolean z8 = bVarG == b.TOP || bVarG == b.BOTTOM;
                if (dVar.d() instanceof g) {
                    return z8 || bVarG == b.CENTER_Y;
                }
                return z8;
            case 6:
            case 7:
            case 8:
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return false;
            default:
                throw new AssertionError(this.f25814c.name());
        }
    }

    public void k() {
        HashSet hashSet;
        d dVar = this.f25815d;
        if (dVar != null && (hashSet = dVar.f25812a) != null) {
            hashSet.remove(this);
        }
        this.f25815d = null;
        this.f25816e = 0;
        this.f25817f = -1;
    }

    public void l(C2831c c2831c) {
        y.i iVar = this.f25818g;
        if (iVar == null) {
            this.f25818g = new y.i(i.a.UNRESTRICTED, null);
        } else {
            iVar.d();
        }
    }

    public String toString() {
        return this.f25813b.p() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.f25814c.toString();
    }
}
