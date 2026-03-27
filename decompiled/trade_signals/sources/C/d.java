package C;

import D.o;
import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import z.i;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f270e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f271f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public z.i f274i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashSet f266a = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f272g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f273h = Integer.MIN_VALUE;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f275a;

        static {
            int[] iArr = new int[b.values().length];
            f275a = iArr;
            try {
                iArr[b.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f275a[b.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f275a[b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f275a[b.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f275a[b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f275a[b.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f275a[b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f275a[b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f275a[b.NONE.ordinal()] = 9;
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
        this.f269d = eVar;
        this.f270e = bVar;
    }

    public boolean a(d dVar, int i8, int i9, boolean z7) {
        if (dVar == null) {
            p();
            return true;
        }
        if (!z7 && !o(dVar)) {
            return false;
        }
        this.f271f = dVar;
        if (dVar.f266a == null) {
            dVar.f266a = new HashSet();
        }
        HashSet hashSet = this.f271f.f266a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f272g = i8;
        this.f273h = i9;
        return true;
    }

    public void b(int i8, ArrayList arrayList, o oVar) {
        HashSet hashSet = this.f266a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                D.i.a(((d) it.next()).f269d, i8, arrayList, oVar);
            }
        }
    }

    public HashSet c() {
        return this.f266a;
    }

    public int d() {
        if (this.f268c) {
            return this.f267b;
        }
        return 0;
    }

    public int e() {
        d dVar;
        if (this.f269d.T() == 8) {
            return 0;
        }
        return (this.f273h == Integer.MIN_VALUE || (dVar = this.f271f) == null || dVar.f269d.T() != 8) ? this.f272g : this.f273h;
    }

    public final d f() {
        switch (a.f275a[this.f270e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f269d.f313Q;
            case 3:
                return this.f269d.f311O;
            case 4:
                return this.f269d.f314R;
            case 5:
                return this.f269d.f312P;
            default:
                throw new AssertionError(this.f270e.name());
        }
    }

    public e g() {
        return this.f269d;
    }

    public z.i h() {
        return this.f274i;
    }

    public d i() {
        return this.f271f;
    }

    public b j() {
        return this.f270e;
    }

    public boolean k() {
        HashSet hashSet = this.f266a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((d) it.next()).f().n()) {
                return true;
            }
        }
        return false;
    }

    public boolean l() {
        HashSet hashSet = this.f266a;
        return hashSet != null && hashSet.size() > 0;
    }

    public boolean m() {
        return this.f268c;
    }

    public boolean n() {
        return this.f271f != null;
    }

    public boolean o(d dVar) {
        if (dVar == null) {
            return false;
        }
        b bVarJ = dVar.j();
        b bVar = this.f270e;
        if (bVarJ == bVar) {
            return bVar != b.BASELINE || (dVar.g().X() && g().X());
        }
        switch (a.f275a[bVar.ordinal()]) {
            case 1:
                return (bVarJ == b.BASELINE || bVarJ == b.CENTER_X || bVarJ == b.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z7 = bVarJ == b.LEFT || bVarJ == b.RIGHT;
                if (dVar.g() instanceof g) {
                    return z7 || bVarJ == b.CENTER_X;
                }
                return z7;
            case 4:
            case 5:
                boolean z8 = bVarJ == b.TOP || bVarJ == b.BOTTOM;
                if (dVar.g() instanceof g) {
                    return z8 || bVarJ == b.CENTER_Y;
                }
                return z8;
            case 6:
                return (bVarJ == b.LEFT || bVarJ == b.RIGHT) ? false : true;
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f270e.name());
        }
    }

    public void p() {
        HashSet hashSet;
        d dVar = this.f271f;
        if (dVar != null && (hashSet = dVar.f266a) != null) {
            hashSet.remove(this);
            if (this.f271f.f266a.size() == 0) {
                this.f271f.f266a = null;
            }
        }
        this.f266a = null;
        this.f271f = null;
        this.f272g = 0;
        this.f273h = Integer.MIN_VALUE;
        this.f268c = false;
        this.f267b = 0;
    }

    public void q() {
        this.f268c = false;
        this.f267b = 0;
    }

    public void r(z.c cVar) {
        z.i iVar = this.f274i;
        if (iVar == null) {
            this.f274i = new z.i(i.a.UNRESTRICTED, null);
        } else {
            iVar.k();
        }
    }

    public void s(int i8) {
        this.f267b = i8;
        this.f268c = true;
    }

    public String toString() {
        return this.f269d.r() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.f270e.toString();
    }
}
