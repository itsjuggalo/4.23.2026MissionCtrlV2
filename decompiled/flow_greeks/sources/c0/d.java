package c0;

import com.revenuecat.purchases.common.Constants;
import d0.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import z.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f3440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f3441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f3442f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public z.i f3445i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashSet f3437a = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3443g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3444h = Integer.MIN_VALUE;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3446a;

        static {
            int[] iArr = new int[b.values().length];
            f3446a = iArr;
            try {
                iArr[b.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3446a[b.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3446a[b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3446a[b.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3446a[b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3446a[b.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3446a[b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3446a[b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3446a[b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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
        this.f3440d = eVar;
        this.f3441e = bVar;
    }

    public boolean a(d dVar, int i10, int i11, boolean z10) {
        if (dVar == null) {
            p();
            return true;
        }
        if (!z10 && !o(dVar)) {
            return false;
        }
        this.f3442f = dVar;
        if (dVar.f3437a == null) {
            dVar.f3437a = new HashSet();
        }
        HashSet hashSet = this.f3442f.f3437a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f3443g = i10;
        this.f3444h = i11;
        return true;
    }

    public void b(int i10, ArrayList arrayList, o oVar) {
        HashSet hashSet = this.f3437a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                d0.i.a(((d) it.next()).f3440d, i10, arrayList, oVar);
            }
        }
    }

    public HashSet c() {
        return this.f3437a;
    }

    public int d() {
        if (this.f3439c) {
            return this.f3438b;
        }
        return 0;
    }

    public int e() {
        d dVar;
        if (this.f3440d.T() == 8) {
            return 0;
        }
        return (this.f3444h == Integer.MIN_VALUE || (dVar = this.f3442f) == null || dVar.f3440d.T() != 8) ? this.f3443g : this.f3444h;
    }

    public final d f() {
        switch (a.f3446a[this.f3441e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f3440d.Q;
            case 3:
                return this.f3440d.O;
            case 4:
                return this.f3440d.R;
            case 5:
                return this.f3440d.P;
            default:
                throw new AssertionError(this.f3441e.name());
        }
    }

    public e g() {
        return this.f3440d;
    }

    public z.i h() {
        return this.f3445i;
    }

    public d i() {
        return this.f3442f;
    }

    public b j() {
        return this.f3441e;
    }

    public boolean k() {
        HashSet hashSet = this.f3437a;
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
        HashSet hashSet = this.f3437a;
        return hashSet != null && hashSet.size() > 0;
    }

    public boolean m() {
        return this.f3439c;
    }

    public boolean n() {
        return this.f3442f != null;
    }

    public boolean o(d dVar) {
        if (dVar == null) {
            return false;
        }
        b bVarJ = dVar.j();
        b bVar = this.f3441e;
        if (bVarJ == bVar) {
            return bVar != b.BASELINE || (dVar.g().X() && g().X());
        }
        switch (a.f3446a[bVar.ordinal()]) {
            case 1:
                return (bVarJ == b.BASELINE || bVarJ == b.CENTER_X || bVarJ == b.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z10 = bVarJ == b.LEFT || bVarJ == b.RIGHT;
                return dVar.g() instanceof g ? z10 || bVarJ == b.CENTER_X : z10;
            case 4:
            case 5:
                boolean z11 = bVarJ == b.TOP || bVarJ == b.BOTTOM;
                return dVar.g() instanceof g ? z11 || bVarJ == b.CENTER_Y : z11;
            case 6:
                return (bVarJ == b.LEFT || bVarJ == b.RIGHT) ? false : true;
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f3441e.name());
        }
    }

    public void p() {
        HashSet hashSet;
        d dVar = this.f3442f;
        if (dVar != null && (hashSet = dVar.f3437a) != null) {
            hashSet.remove(this);
            if (this.f3442f.f3437a.size() == 0) {
                this.f3442f.f3437a = null;
            }
        }
        this.f3437a = null;
        this.f3442f = null;
        this.f3443g = 0;
        this.f3444h = Integer.MIN_VALUE;
        this.f3439c = false;
        this.f3438b = 0;
    }

    public void q() {
        this.f3439c = false;
        this.f3438b = 0;
    }

    public void r(z.c cVar) {
        z.i iVar = this.f3445i;
        if (iVar == null) {
            this.f3445i = new z.i(i.a.UNRESTRICTED, null);
        } else {
            iVar.i();
        }
    }

    public void s(int i10) {
        this.f3438b = i10;
        this.f3439c = true;
    }

    public String toString() {
        return this.f3440d.r() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.f3441e.toString();
    }
}
