package s6;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import s6.AbstractC2714a;
import s6.AbstractC2723j;
import s6.C2721h;
import s6.p;
import s6.y;

/* JADX INFO: renamed from: s6.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2722i extends AbstractC2714a implements Serializable {

    /* JADX INFO: renamed from: s6.i$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23163a;

        static {
            int[] iArr = new int[y.c.values().length];
            f23163a = iArr;
            try {
                iArr[y.c.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23163a[y.c.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: s6.i$b */
    public static abstract class b extends AbstractC2714a.AbstractC0396a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AbstractC2717d f23164a = AbstractC2717d.f23128a;

        public final AbstractC2717d j() {
            return this.f23164a;
        }

        public abstract b k(AbstractC2722i abstractC2722i);

        public final b l(AbstractC2717d abstractC2717d) {
            this.f23164a = abstractC2717d;
            return this;
        }
    }

    /* JADX INFO: renamed from: s6.i$c */
    public static abstract class c extends b implements q {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public C2721h f23165b = C2721h.g();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f23166c;

        public final C2721h o() {
            this.f23165b.q();
            this.f23166c = false;
            return this.f23165b;
        }

        public final void p() {
            if (this.f23166c) {
                return;
            }
            this.f23165b = this.f23165b.clone();
            this.f23166c = true;
        }

        public final void q(d dVar) {
            p();
            this.f23165b.r(dVar.f23167b);
        }
    }

    /* JADX INFO: renamed from: s6.i$d */
    public static abstract class d extends AbstractC2722i implements q {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C2721h f23167b;

        /* JADX INFO: renamed from: s6.i$d$a */
        public class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Iterator f23168a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Map.Entry f23169b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final boolean f23170c;

            public a(boolean z7) {
                Iterator itP = d.this.f23167b.p();
                this.f23168a = itP;
                if (itP.hasNext()) {
                    this.f23169b = (Map.Entry) itP.next();
                }
                this.f23170c = z7;
            }

            public void a(int i8, C2719f c2719f) {
                while (true) {
                    Map.Entry entry = this.f23169b;
                    if (entry == null || ((e) entry.getKey()).d() >= i8) {
                        return;
                    }
                    e eVar = (e) this.f23169b.getKey();
                    if (this.f23170c && eVar.C() == y.c.MESSAGE && !eVar.e()) {
                        c2719f.e0(eVar.d(), (p) this.f23169b.getValue());
                    } else {
                        C2721h.z(eVar, this.f23169b.getValue(), c2719f);
                    }
                    this.f23169b = this.f23168a.hasNext() ? (Map.Entry) this.f23168a.next() : null;
                }
            }

            public /* synthetic */ a(d dVar, boolean z7, a aVar) {
                this(z7);
            }
        }

        public d() {
            this.f23167b = C2721h.t();
        }

        public final void A(f fVar) {
            if (fVar.b() != b()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        @Override // s6.AbstractC2722i
        public void m() {
            this.f23167b.q();
        }

        @Override // s6.AbstractC2722i
        public boolean q(C2718e c2718e, C2719f c2719f, C2720g c2720g, int i8) {
            return AbstractC2722i.r(this.f23167b, b(), c2718e, c2719f, c2720g, i8);
        }

        public boolean t() {
            return this.f23167b.n();
        }

        public int u() {
            return this.f23167b.k();
        }

        public final Object v(f fVar) {
            A(fVar);
            Object objH = this.f23167b.h(fVar.f23180d);
            return objH == null ? fVar.f23178b : fVar.a(objH);
        }

        public final Object w(f fVar, int i8) {
            A(fVar);
            return fVar.e(this.f23167b.i(fVar.f23180d, i8));
        }

        public final int x(f fVar) {
            A(fVar);
            return this.f23167b.j(fVar.f23180d);
        }

        public final boolean y(f fVar) {
            A(fVar);
            return this.f23167b.m(fVar.f23180d);
        }

        public a z() {
            return new a(this, false, null);
        }

        public d(c cVar) {
            this.f23167b = cVar.o();
        }
    }

    /* JADX INFO: renamed from: s6.i$e */
    public static final class e implements C2721h.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC2723j.b f23172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f23173b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final y.b f23174c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f23175d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f23176e;

        public e(AbstractC2723j.b bVar, int i8, y.b bVar2, boolean z7, boolean z8) {
            this.f23172a = bVar;
            this.f23173b = i8;
            this.f23174c = bVar2;
            this.f23175d = z7;
            this.f23176e = z8;
        }

        @Override // s6.C2721h.b
        public y.c C() {
            return this.f23174c.a();
        }

        @Override // s6.C2721h.b
        public p.a F(p.a aVar, p pVar) {
            return ((b) aVar).k((AbstractC2722i) pVar);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(e eVar) {
            return this.f23173b - eVar.f23173b;
        }

        public AbstractC2723j.b b() {
            return this.f23172a;
        }

        @Override // s6.C2721h.b
        public int d() {
            return this.f23173b;
        }

        @Override // s6.C2721h.b
        public boolean e() {
            return this.f23175d;
        }

        @Override // s6.C2721h.b
        public y.b f() {
            return this.f23174c;
        }

        @Override // s6.C2721h.b
        public boolean h() {
            return this.f23176e;
        }
    }

    /* JADX INFO: renamed from: s6.i$f */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p f23177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f23178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final p f23179c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final e f23180d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Class f23181e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Method f23182f;

        public f(p pVar, Object obj, p pVar2, e eVar, Class cls) {
            if (pVar == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (eVar.f() == y.b.f23244m && pVar2 == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            }
            this.f23177a = pVar;
            this.f23178b = obj;
            this.f23179c = pVar2;
            this.f23180d = eVar;
            this.f23181e = cls;
            this.f23182f = AbstractC2723j.a.class.isAssignableFrom(cls) ? AbstractC2722i.k(cls, "valueOf", Integer.TYPE) : null;
        }

        public Object a(Object obj) {
            if (!this.f23180d.e()) {
                return e(obj);
            }
            if (this.f23180d.C() != y.c.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                arrayList.add(e(it.next()));
            }
            return arrayList;
        }

        public p b() {
            return this.f23177a;
        }

        public p c() {
            return this.f23179c;
        }

        public int d() {
            return this.f23180d.d();
        }

        public Object e(Object obj) {
            return this.f23180d.C() == y.c.ENUM ? AbstractC2722i.l(this.f23182f, null, (Integer) obj) : obj;
        }

        public Object f(Object obj) {
            return this.f23180d.C() == y.c.ENUM ? Integer.valueOf(((AbstractC2723j.a) obj).d()) : obj;
        }
    }

    public AbstractC2722i() {
    }

    public static Method k(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e8) {
            String name = cls.getName();
            String strValueOf = String.valueOf(str);
            StringBuilder sb = new StringBuilder(name.length() + 45 + strValueOf.length());
            sb.append("Generated message class \"");
            sb.append(name);
            sb.append("\" missing method \"");
            sb.append(strValueOf);
            sb.append("\".");
            throw new RuntimeException(sb.toString(), e8);
        }
    }

    public static Object l(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e8) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e8);
        } catch (InvocationTargetException e9) {
            Throwable cause = e9.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static f o(p pVar, p pVar2, AbstractC2723j.b bVar, int i8, y.b bVar2, boolean z7, Class cls) {
        return new f(pVar, Collections.emptyList(), pVar2, new e(bVar, i8, bVar2, true, z7), cls);
    }

    public static f p(p pVar, Object obj, p pVar2, AbstractC2723j.b bVar, int i8, y.b bVar2, Class cls) {
        return new f(pVar, obj, pVar2, new e(bVar, i8, bVar2, false, false), cls);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean r(s6.C2721h r5, s6.p r6, s6.C2718e r7, s6.C2719f r8, s6.C2720g r9, int r10) throws s6.C2724k {
        /*
            Method dump skipped, instruction units count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s6.AbstractC2722i.r(s6.h, s6.p, s6.e, s6.f, s6.g, int):boolean");
    }

    public boolean q(C2718e c2718e, C2719f c2719f, C2720g c2720g, int i8) {
        return c2718e.O(i8, c2719f);
    }

    public AbstractC2722i(b bVar) {
    }

    public void m() {
    }
}
