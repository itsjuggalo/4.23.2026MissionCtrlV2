package D;

import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p f673d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f675f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f676g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f670a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f671b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f672c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f674e = a.UNKNOWN;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f677h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g f678i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f679j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f680k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List f681l = new ArrayList();

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
        this.f673d = pVar;
    }

    @Override // D.d
    public void a(d dVar) {
        Iterator it = this.f681l.iterator();
        while (it.hasNext()) {
            if (!((f) it.next()).f679j) {
                return;
            }
        }
        this.f672c = true;
        d dVar2 = this.f670a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.f671b) {
            this.f673d.a(this);
            return;
        }
        f fVar = null;
        int i8 = 0;
        for (f fVar2 : this.f681l) {
            if (!(fVar2 instanceof g)) {
                i8++;
                fVar = fVar2;
            }
        }
        if (fVar != null && i8 == 1 && fVar.f679j) {
            g gVar = this.f678i;
            if (gVar != null) {
                if (!gVar.f679j) {
                    return;
                } else {
                    this.f675f = this.f677h * gVar.f676g;
                }
            }
            d(fVar.f676g + this.f675f);
        }
        d dVar3 = this.f670a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b(d dVar) {
        this.f680k.add(dVar);
        if (this.f679j) {
            dVar.a(dVar);
        }
    }

    public void c() {
        this.f681l.clear();
        this.f680k.clear();
        this.f679j = false;
        this.f676g = 0;
        this.f672c = false;
        this.f671b = false;
    }

    public void d(int i8) {
        if (this.f679j) {
            return;
        }
        this.f679j = true;
        this.f676g = i8;
        for (d dVar : this.f680k) {
            dVar.a(dVar);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f673d.f724b.r());
        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb.append(this.f674e);
        sb.append("(");
        sb.append(this.f679j ? Integer.valueOf(this.f676g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f681l.size());
        sb.append(":d=");
        sb.append(this.f680k.size());
        sb.append(">");
        return sb.toString();
    }
}
