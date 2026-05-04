package d0;

import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p f7427d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7429f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f7430g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f7424a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7425b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7426c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f7428e = a.UNKNOWN;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f7431h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g f7432i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f7433j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f7434k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List f7435l = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public f(p pVar) {
        this.f7427d = pVar;
    }

    @Override // d0.d
    public void a(d dVar) {
        Iterator it = this.f7435l.iterator();
        while (it.hasNext()) {
            if (!((f) it.next()).f7433j) {
                return;
            }
        }
        this.f7426c = true;
        d dVar2 = this.f7424a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.f7425b) {
            this.f7427d.a(this);
            return;
        }
        f fVar = null;
        int i10 = 0;
        for (f fVar2 : this.f7435l) {
            if (!(fVar2 instanceof g)) {
                i10++;
                fVar = fVar2;
            }
        }
        if (fVar != null && i10 == 1 && fVar.f7433j) {
            g gVar = this.f7432i;
            if (gVar != null) {
                if (!gVar.f7433j) {
                    return;
                } else {
                    this.f7429f = this.f7431h * gVar.f7430g;
                }
            }
            d(fVar.f7430g + this.f7429f);
        }
        d dVar3 = this.f7424a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b(d dVar) {
        this.f7434k.add(dVar);
        if (this.f7433j) {
            dVar.a(dVar);
        }
    }

    public void c() {
        this.f7435l.clear();
        this.f7434k.clear();
        this.f7433j = false;
        this.f7430g = 0;
        this.f7426c = false;
        this.f7425b = false;
    }

    public void d(int i10) {
        if (this.f7433j) {
            return;
        }
        this.f7433j = true;
        this.f7430g = i10;
        for (d dVar : this.f7434k) {
            dVar.a(dVar);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f7427d.f7478b.r());
        sb2.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb2.append(this.f7428e);
        sb2.append("(");
        sb2.append(this.f7433j ? Integer.valueOf(this.f7430g) : "unresolved");
        sb2.append(") <t=");
        sb2.append(this.f7435l.size());
        sb2.append(":d=");
        sb2.append(this.f7434k.size());
        sb2.append(">");
        return sb2.toString();
    }
}
