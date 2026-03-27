package B6;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;
import p5.z;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f182g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f183h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f184i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f185j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f186k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f187l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f188m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f189n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final d f190o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final d f191p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final d f192q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final d f193r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final d f194s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final d f195t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final d f196u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final d f197v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final d f198w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final d f199x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final List f200y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final List f201z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f203b;

    public static final class a {

        /* JADX INFO: renamed from: B6.d$a$a, reason: collision with other inner class name */
        public static final class C0004a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f204a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f205b;

            public C0004a(int i8, String name) {
                AbstractC2304t.f(name, "name");
                this.f204a = i8;
                this.f205b = name;
            }

            public final int a() {
                return this.f204a;
            }

            public final String b() {
                return this.f205b;
            }
        }

        public a() {
        }

        public final int b() {
            return d.f186k;
        }

        public final int c() {
            return d.f187l;
        }

        public final int d() {
            return d.f184i;
        }

        public final int e() {
            return d.f180e;
        }

        public final int f() {
            return d.f183h;
        }

        public final int g() {
            return d.f181f;
        }

        public final int h() {
            return d.f182g;
        }

        public final int i() {
            return d.f185j;
        }

        public final int j() {
            int i8 = d.f179d;
            d.f179d <<= 1;
            return i8;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        a.C0004a c0004a;
        a.C0004a c0004a2;
        a aVar = new a(null);
        f178c = aVar;
        f179d = 1;
        int iJ = aVar.j();
        f180e = iJ;
        int iJ2 = aVar.j();
        f181f = iJ2;
        int iJ3 = aVar.j();
        f182g = iJ3;
        int iJ4 = aVar.j();
        f183h = iJ4;
        int iJ5 = aVar.j();
        f184i = iJ5;
        int iJ6 = aVar.j();
        f185j = iJ6;
        int iJ7 = aVar.j() - 1;
        f186k = iJ7;
        int i8 = iJ | iJ2 | iJ3;
        f187l = i8;
        int i9 = iJ2 | iJ5 | iJ6;
        f188m = i9;
        int i10 = iJ5 | iJ6;
        f189n = i10;
        int i11 = 2;
        f190o = new d(iJ7, 0 == true ? 1 : 0, i11, 0 == true ? 1 : 0);
        f191p = new d(i10, 0 == true ? 1 : 0, i11, 0 == true ? 1 : 0);
        f192q = new d(iJ, 0 == true ? 1 : 0, i11, 0 == true ? 1 : 0);
        f193r = new d(iJ2, 0 == true ? 1 : 0, i11, 0 == true ? 1 : 0);
        f194s = new d(iJ3, 0 == true ? 1 : 0, i11, 0 == true ? 1 : 0);
        f195t = new d(i8, 0 == true ? 1 : 0, i11, 0 == true ? 1 : 0);
        f196u = new d(iJ4, 0 == true ? 1 : 0, i11, 0 == true ? 1 : 0);
        f197v = new d(iJ5, 0 == true ? 1 : 0, i11, 0 == true ? 1 : 0);
        f198w = new d(iJ6, 0 == true ? 1 : 0, i11, 0 == true ? 1 : 0);
        f199x = new d(i9, 0 == true ? 1 : 0, i11, 0 == true ? 1 : 0);
        Field[] fields = d.class.getFields();
        AbstractC2304t.e(fields, "getFields(...)");
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
                int i12 = dVar.f203b;
                String name = field2.getName();
                AbstractC2304t.e(name, "getName(...)");
                c0004a2 = new a.C0004a(i12, name);
            } else {
                c0004a2 = null;
            }
            if (c0004a2 != null) {
                arrayList2.add(c0004a2);
            }
        }
        f200y = arrayList2;
        Field[] fields2 = d.class.getFields();
        AbstractC2304t.e(fields2, "getFields(...)");
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (AbstractC2304t.b(((Field) obj2).getType(), Integer.TYPE)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Field field4 : arrayList4) {
            Object obj3 = field4.get(null);
            AbstractC2304t.d(obj3, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) obj3).intValue();
            if (iIntValue == ((-iIntValue) & iIntValue)) {
                String name2 = field4.getName();
                AbstractC2304t.e(name2, "getName(...)");
                c0004a = new a.C0004a(iIntValue, name2);
            } else {
                c0004a = null;
            }
            if (c0004a != null) {
                arrayList5.add(c0004a);
            }
        }
        f201z = arrayList5;
    }

    public d(int i8, List excludes) {
        AbstractC2304t.f(excludes, "excludes");
        this.f202a = excludes;
        Iterator it = excludes.iterator();
        while (it.hasNext()) {
            i8 &= ~((c) it.next()).a();
        }
        this.f203b = i8;
    }

    public final boolean a(int i8) {
        return (i8 & this.f203b) != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC2304t.b(d.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC2304t.d(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
        d dVar = (d) obj;
        return AbstractC2304t.b(this.f202a, dVar.f202a) && this.f203b == dVar.f203b;
    }

    public int hashCode() {
        return (this.f202a.hashCode() * 31) + this.f203b;
    }

    public final List l() {
        return this.f202a;
    }

    public final int m() {
        return this.f203b;
    }

    public final d n(int i8) {
        int i9 = i8 & this.f203b;
        if (i9 == 0) {
            return null;
        }
        return new d(i9, this.f202a);
    }

    public String toString() {
        Object next;
        Iterator it = f200y.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((a.C0004a) next).a() == this.f203b) {
                break;
            }
        }
        a.C0004a c0004a = (a.C0004a) next;
        String strB = c0004a != null ? c0004a.b() : null;
        if (strB == null) {
            List<a.C0004a> list = f201z;
            ArrayList arrayList = new ArrayList();
            for (a.C0004a c0004a2 : list) {
                String strB2 = a(c0004a2.a()) ? c0004a2.b() : null;
                if (strB2 != null) {
                    arrayList.add(strB2);
                }
            }
            strB = z.h0(arrayList, " | ", null, null, 0, null, null, 62, null);
        }
        return "DescriptorKindFilter(" + strB + ", " + this.f202a + ')';
    }

    public /* synthetic */ d(int i8, List list, int i9, AbstractC2296k abstractC2296k) {
        this(i8, (i9 & 2) != 0 ? AbstractC2595q.i() : list);
    }
}
