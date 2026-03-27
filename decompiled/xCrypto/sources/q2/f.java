package q2;

import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import s2.AbstractC1771a;
import t2.C1786c;
import w2.AbstractC1908d;
import x2.C1925a;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s2.v f14250a = s2.v.f14637g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r f14251b = r.f14274a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f14252c = EnumC1723b.f14201a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f14253d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f14254e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f14255f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f14256g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f14257h = e.f14215B;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14258i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14259j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f14260k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f14261l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f14262m = true;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public d f14263n = e.f14214A;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f14264o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public t f14265p = e.f14219z;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f14266q = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public v f14267r = e.f14217D;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public v f14268s = e.f14218E;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ArrayDeque f14269t = new ArrayDeque();

    public static void a(String str, int i4, int i5, List list) {
        x xVarB;
        x xVarB2;
        boolean z4 = AbstractC1908d.f15577a;
        x xVarA = null;
        if (str != null && !str.trim().isEmpty()) {
            xVarB = C1786c.b.f14757b.b(str);
            if (z4) {
                xVarA = AbstractC1908d.f15579c.b(str);
                xVarB2 = AbstractC1908d.f15578b.b(str);
            } else {
                xVarB2 = null;
            }
        } else {
            if (i4 == 2 && i5 == 2) {
                return;
            }
            x xVarA2 = C1786c.b.f14757b.a(i4, i5);
            if (z4) {
                xVarA = AbstractC1908d.f15579c.a(i4, i5);
                x xVarA3 = AbstractC1908d.f15578b.a(i4, i5);
                xVarB = xVarA2;
                xVarB2 = xVarA3;
            } else {
                xVarB = xVarA2;
                xVarB2 = null;
            }
        }
        list.add(xVarB);
        if (z4) {
            list.add(xVarA);
            list.add(xVarB2);
        }
    }

    public static boolean c(Type type) {
        return type == Object.class;
    }

    public e b() {
        ArrayList arrayList = new ArrayList(this.f14254e.size() + this.f14255f.size() + 3);
        arrayList.addAll(this.f14254e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f14255f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.f14257h, this.f14258i, this.f14259j, arrayList);
        return new e(this.f14250a, this.f14252c, new HashMap(this.f14253d), this.f14256g, this.f14260k, this.f14264o, this.f14262m, this.f14263n, this.f14265p, this.f14261l, this.f14266q, this.f14251b, this.f14257h, this.f14258i, this.f14259j, new ArrayList(this.f14254e), new ArrayList(this.f14255f), arrayList, this.f14267r, this.f14268s, new ArrayList(this.f14269t));
    }

    public f d(Type type, Object obj) {
        Objects.requireNonNull(type);
        AbstractC1771a.a((obj instanceof i) || (obj instanceof w));
        if (c(type)) {
            throw new IllegalArgumentException("Cannot override built-in adapter for " + type);
        }
        if (obj instanceof i) {
            this.f14254e.add(t2.n.h(C1925a.b(type), obj));
        }
        if (obj instanceof w) {
            this.f14254e.add(t2.p.c(C1925a.b(type), (w) obj));
        }
        return this;
    }

    public f e(x xVar) {
        Objects.requireNonNull(xVar);
        this.f14254e.add(xVar);
        return this;
    }
}
