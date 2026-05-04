package qf;

import dd.a0;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f19046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f19047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f19048e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f19049f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f19050g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f19051h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f19052i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f19053j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f19054k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f19055l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f19056m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f19057n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final d f19058o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final d f19059p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final d f19060q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final d f19061r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final d f19062s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final d f19063t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final d f19064u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final d f19065v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final d f19066w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final d f19067x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final List f19068y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final List f19069z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f19070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19071b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: qf.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0330a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f19072a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f19073b;

            public C0330a(int i10, String name) {
                kotlin.jvm.internal.t.f(name, "name");
                this.f19072a = i10;
                this.f19073b = name;
            }

            public final int a() {
                return this.f19072a;
            }

            public final String b() {
                return this.f19073b;
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final int b() {
            return d.f19054k;
        }

        public final int c() {
            return d.f19055l;
        }

        public final int d() {
            return d.f19052i;
        }

        public final int e() {
            return d.f19048e;
        }

        public final int f() {
            return d.f19051h;
        }

        public final int g() {
            return d.f19049f;
        }

        public final int h() {
            return d.f19050g;
        }

        public final int i() {
            return d.f19053j;
        }

        public final int j() {
            int i10 = d.f19047d;
            d.f19047d <<= 1;
            return i10;
        }

        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        a.C0330a c0330a;
        a.C0330a c0330a2;
        a aVar = new a(null);
        f19046c = aVar;
        f19047d = 1;
        int iJ = aVar.j();
        f19048e = iJ;
        int iJ2 = aVar.j();
        f19049f = iJ2;
        int iJ3 = aVar.j();
        f19050g = iJ3;
        int iJ4 = aVar.j();
        f19051h = iJ4;
        int iJ5 = aVar.j();
        f19052i = iJ5;
        int iJ6 = aVar.j();
        f19053j = iJ6;
        int iJ7 = aVar.j() - 1;
        f19054k = iJ7;
        int i10 = iJ | iJ2 | iJ3;
        f19055l = i10;
        int i11 = iJ2 | iJ5 | iJ6;
        f19056m = i11;
        int i12 = iJ5 | iJ6;
        f19057n = i12;
        int i13 = 2;
        f19058o = new d(iJ7, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f19059p = new d(i12, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f19060q = new d(iJ, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f19061r = new d(iJ2, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f19062s = new d(iJ3, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f19063t = new d(i10, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f19064u = new d(iJ4, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f19065v = new d(iJ5, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f19066w = new d(iJ6, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        f19067x = new d(i11, 0 == true ? 1 : 0, i13, 0 == true ? 1 : 0);
        Field[] fields = d.class.getFields();
        kotlin.jvm.internal.t.e(fields, "getFields(...)");
        ArrayList<Field> arrayList = new ArrayList();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Field field2 : arrayList) {
            Object obj = field2.get(null);
            d dVar = obj instanceof d ? (d) obj : null;
            if (dVar != null) {
                int i14 = dVar.f19071b;
                String name = field2.getName();
                kotlin.jvm.internal.t.e(name, "getName(...)");
                c0330a2 = new a.C0330a(i14, name);
            } else {
                c0330a2 = null;
            }
            if (c0330a2 != null) {
                arrayList2.add(c0330a2);
            }
        }
        f19068y = arrayList2;
        Field[] fields2 = d.class.getFields();
        kotlin.jvm.internal.t.e(fields2, "getFields(...)");
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (kotlin.jvm.internal.t.b(((Field) obj2).getType(), Integer.TYPE)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Field field4 : arrayList4) {
            Object obj3 = field4.get(null);
            kotlin.jvm.internal.t.d(obj3, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) obj3).intValue();
            if (iIntValue == ((-iIntValue) & iIntValue)) {
                String name2 = field4.getName();
                kotlin.jvm.internal.t.e(name2, "getName(...)");
                c0330a = new a.C0330a(iIntValue, name2);
            } else {
                c0330a = null;
            }
            if (c0330a != null) {
                arrayList5.add(c0330a);
            }
        }
        f19069z = arrayList5;
    }

    public d(int i10, List excludes) {
        kotlin.jvm.internal.t.f(excludes, "excludes");
        this.f19070a = excludes;
        Iterator it = excludes.iterator();
        while (it.hasNext()) {
            i10 &= ~((c) it.next()).a();
        }
        this.f19071b = i10;
    }

    public final boolean a(int i10) {
        return (i10 & this.f19071b) != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!kotlin.jvm.internal.t.b(d.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
        d dVar = (d) obj;
        return kotlin.jvm.internal.t.b(this.f19070a, dVar.f19070a) && this.f19071b == dVar.f19071b;
    }

    public int hashCode() {
        return (this.f19070a.hashCode() * 31) + this.f19071b;
    }

    public final List l() {
        return this.f19070a;
    }

    public final int m() {
        return this.f19071b;
    }

    public final d n(int i10) {
        int i11 = i10 & this.f19071b;
        if (i11 == 0) {
            return null;
        }
        return new d(i11, this.f19070a);
    }

    public String toString() {
        Object next;
        Iterator it = f19068y.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((a.C0330a) next).a() == this.f19071b) {
                break;
            }
        }
        a.C0330a c0330a = (a.C0330a) next;
        String strB = c0330a != null ? c0330a.b() : null;
        if (strB == null) {
            List<a.C0330a> list = f19069z;
            ArrayList arrayList = new ArrayList();
            for (a.C0330a c0330a2 : list) {
                String strB2 = a(c0330a2.a()) ? c0330a2.b() : null;
                if (strB2 != null) {
                    arrayList.add(strB2);
                }
            }
            strB = a0.i0(arrayList, " | ", null, null, 0, null, null, 62, null);
        }
        return "DescriptorKindFilter(" + strB + ", " + this.f19070a + ')';
    }

    public /* synthetic */ d(int i10, List list, int i11, kotlin.jvm.internal.k kVar) {
        this(i10, (i11 & 2) != 0 ? dd.r.k() : list);
    }
}
