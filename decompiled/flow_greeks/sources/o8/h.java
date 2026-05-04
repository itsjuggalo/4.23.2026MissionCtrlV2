package o8;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import m8.m;
import r8.n;
import r8.o;
import r8.q;
import r8.r;
import r8.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final h f17629i = new h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f17630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f17631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f17632c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public r8.b f17633d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n f17634e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public r8.b f17635f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r8.h f17636g = q.j();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f17637h = null;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17638a;

        static {
            int[] iArr = new int[b.values().length];
            f17638a = iArr;
            try {
                iArr[b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17638a[b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum b {
        LEFT,
        RIGHT
    }

    public static h c(Map map) {
        h hVar = new h();
        hVar.f17630a = (Integer) map.get("l");
        if (map.containsKey("sp")) {
            hVar.f17632c = v(o.a(map.get("sp")));
            String str = (String) map.get("sn");
            if (str != null) {
                hVar.f17633d = r8.b.h(str);
            }
        }
        if (map.containsKey("ep")) {
            hVar.f17634e = v(o.a(map.get("ep")));
            String str2 = (String) map.get("en");
            if (str2 != null) {
                hVar.f17635f = r8.b.h(str2);
            }
        }
        String str3 = (String) map.get("vf");
        if (str3 != null) {
            hVar.f17631b = str3.equals("l") ? b.LEFT : b.RIGHT;
        }
        String str4 = (String) map.get("i");
        if (str4 != null) {
            hVar.f17636g = r8.h.b(str4);
        }
        return hVar;
    }

    public static n v(n nVar) {
        if ((nVar instanceof t) || (nVar instanceof r8.a) || (nVar instanceof r8.f) || (nVar instanceof r8.g)) {
            return nVar;
        }
        if (nVar instanceof r8.l) {
            return new r8.f(Double.valueOf(((Long) nVar.getValue()).doubleValue()), r.a());
        }
        throw new IllegalStateException("Unexpected value passed to normalizeValue: " + nVar.getValue());
    }

    public final h a() {
        h hVar = new h();
        hVar.f17630a = this.f17630a;
        hVar.f17632c = this.f17632c;
        hVar.f17633d = this.f17633d;
        hVar.f17634e = this.f17634e;
        hVar.f17635f = this.f17635f;
        hVar.f17631b = this.f17631b;
        hVar.f17636g = this.f17636g;
        return hVar;
    }

    public h b(n nVar, r8.b bVar) {
        m.f(nVar.J() || nVar.isEmpty());
        m.f(!(nVar instanceof r8.l));
        h hVarA = a();
        hVarA.f17634e = nVar;
        hVarA.f17635f = bVar;
        return hVarA;
    }

    public r8.h d() {
        return this.f17636g;
    }

    public r8.b e() {
        if (!m()) {
            throw new IllegalArgumentException("Cannot get index end name if start has not been set");
        }
        r8.b bVar = this.f17635f;
        return bVar != null ? bVar : r8.b.k();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        Integer num = this.f17630a;
        if (num == null ? hVar.f17630a != null : !num.equals(hVar.f17630a)) {
            return false;
        }
        r8.h hVar2 = this.f17636g;
        if (hVar2 == null ? hVar.f17636g != null : !hVar2.equals(hVar.f17636g)) {
            return false;
        }
        r8.b bVar = this.f17635f;
        if (bVar == null ? hVar.f17635f != null : !bVar.equals(hVar.f17635f)) {
            return false;
        }
        n nVar = this.f17634e;
        if (nVar == null ? hVar.f17634e != null : !nVar.equals(hVar.f17634e)) {
            return false;
        }
        r8.b bVar2 = this.f17633d;
        if (bVar2 == null ? hVar.f17633d != null : !bVar2.equals(hVar.f17633d)) {
            return false;
        }
        n nVar2 = this.f17632c;
        if (nVar2 == null ? hVar.f17632c == null : nVar2.equals(hVar.f17632c)) {
            return r() == hVar.r();
        }
        return false;
    }

    public n f() {
        if (m()) {
            return this.f17634e;
        }
        throw new IllegalArgumentException("Cannot get index end value if start has not been set");
    }

    public r8.b g() {
        if (!o()) {
            throw new IllegalArgumentException("Cannot get index start name if start has not been set");
        }
        r8.b bVar = this.f17633d;
        return bVar != null ? bVar : r8.b.l();
    }

    public n h() {
        if (o()) {
            return this.f17632c;
        }
        throw new IllegalArgumentException("Cannot get index start value if start has not been set");
    }

    public int hashCode() {
        Integer num = this.f17630a;
        int iIntValue = (((num != null ? num.intValue() : 0) * 31) + (r() ? 1231 : 1237)) * 31;
        n nVar = this.f17632c;
        int iHashCode = (iIntValue + (nVar != null ? nVar.hashCode() : 0)) * 31;
        r8.b bVar = this.f17633d;
        int iHashCode2 = (iHashCode + (bVar != null ? bVar.hashCode() : 0)) * 31;
        n nVar2 = this.f17634e;
        int iHashCode3 = (iHashCode2 + (nVar2 != null ? nVar2.hashCode() : 0)) * 31;
        r8.b bVar2 = this.f17635f;
        int iHashCode4 = (iHashCode3 + (bVar2 != null ? bVar2.hashCode() : 0)) * 31;
        r8.h hVar = this.f17636g;
        return iHashCode4 + (hVar != null ? hVar.hashCode() : 0);
    }

    public int i() {
        if (n()) {
            return this.f17630a.intValue();
        }
        throw new IllegalArgumentException("Cannot get limit if limit has not been set");
    }

    public p8.d j() {
        return u() ? new p8.b(d()) : n() ? new p8.c(this) : new p8.e(this);
    }

    public Map k() {
        HashMap map = new HashMap();
        if (o()) {
            map.put("sp", this.f17632c.getValue());
            r8.b bVar = this.f17633d;
            if (bVar != null) {
                map.put("sn", bVar.b());
            }
        }
        if (m()) {
            map.put("ep", this.f17634e.getValue());
            r8.b bVar2 = this.f17635f;
            if (bVar2 != null) {
                map.put("en", bVar2.b());
            }
        }
        Integer num = this.f17630a;
        if (num != null) {
            map.put("l", num);
            b bVar3 = this.f17631b;
            if (bVar3 == null) {
                bVar3 = o() ? b.LEFT : b.RIGHT;
            }
            int i10 = a.f17638a[bVar3.ordinal()];
            if (i10 == 1) {
                map.put("vf", "l");
            } else if (i10 == 2) {
                map.put("vf", "r");
            }
        }
        if (!this.f17636g.equals(q.j())) {
            map.put("i", this.f17636g.c());
        }
        return map;
    }

    public boolean l() {
        return n() && this.f17631b != null;
    }

    public boolean m() {
        return this.f17634e != null;
    }

    public boolean n() {
        return this.f17630a != null;
    }

    public boolean o() {
        return this.f17632c != null;
    }

    public boolean p() {
        return u() && this.f17636g.equals(q.j());
    }

    public boolean q() {
        return (o() && m() && n() && !l()) ? false : true;
    }

    public boolean r() {
        b bVar = this.f17631b;
        return bVar != null ? bVar == b.LEFT : o();
    }

    public h s(int i10) {
        h hVarA = a();
        hVarA.f17630a = Integer.valueOf(i10);
        hVarA.f17631b = b.LEFT;
        return hVarA;
    }

    public h t(int i10) {
        h hVarA = a();
        hVarA.f17630a = Integer.valueOf(i10);
        hVarA.f17631b = b.RIGHT;
        return hVarA;
    }

    public String toString() {
        return k().toString();
    }

    public boolean u() {
        return (o() || m() || n()) ? false : true;
    }

    public h w(r8.h hVar) {
        h hVarA = a();
        hVarA.f17636g = hVar;
        return hVarA;
    }

    public h x(n nVar, r8.b bVar) {
        m.f(nVar.J() || nVar.isEmpty());
        m.f(!(nVar instanceof r8.l));
        h hVarA = a();
        hVarA.f17632c = nVar;
        hVarA.f17633d = bVar;
        return hVarA;
    }

    public String y() {
        if (this.f17637h == null) {
            try {
                this.f17637h = t8.b.c(k());
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            }
        }
        return this.f17637h;
    }
}
