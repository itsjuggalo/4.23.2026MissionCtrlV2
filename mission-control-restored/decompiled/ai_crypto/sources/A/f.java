package A;

import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m f30d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f32f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f33g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f27a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f28b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f29c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f31e = a.UNKNOWN;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f34h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g f35i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f36j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f37k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List f38l = new ArrayList();

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

    public f(m mVar) {
        this.f30d = mVar;
    }

    @Override // A.d
    public void a(d dVar) {
        Iterator it = this.f38l.iterator();
        while (it.hasNext()) {
            if (!((f) it.next()).f36j) {
                return;
            }
        }
        this.f29c = true;
        d dVar2 = this.f27a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.f28b) {
            this.f30d.a(this);
            return;
        }
        f fVar = null;
        int i7 = 0;
        for (f fVar2 : this.f38l) {
            if (!(fVar2 instanceof g)) {
                i7++;
                fVar = fVar2;
            }
        }
        if (fVar != null && i7 == 1 && fVar.f36j) {
            g gVar = this.f35i;
            if (gVar != null) {
                if (!gVar.f36j) {
                    return;
                } else {
                    this.f32f = this.f34h * gVar.f33g;
                }
            }
            d(fVar.f33g + this.f32f);
        }
        d dVar3 = this.f27a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b(d dVar) {
        this.f37k.add(dVar);
        if (this.f36j) {
            dVar.a(dVar);
        }
    }

    public void c() {
        this.f38l.clear();
        this.f37k.clear();
        this.f36j = false;
        this.f33g = 0;
        this.f29c = false;
        this.f28b = false;
    }

    public void d(int i7) {
        if (this.f36j) {
            return;
        }
        this.f36j = true;
        this.f33g = i7;
        for (d dVar : this.f37k) {
            dVar.a(dVar);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f30d.f63b.p());
        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb.append(this.f31e);
        sb.append("(");
        sb.append(this.f36j ? Integer.valueOf(this.f33g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f38l.size());
        sb.append(":d=");
        sb.append(this.f37k.size());
        sb.append(">");
        return sb.toString();
    }
}
