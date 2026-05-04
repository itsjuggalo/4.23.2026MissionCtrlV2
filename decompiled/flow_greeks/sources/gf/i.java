package gf;

import gf.a;
import gf.h;
import gf.j;
import gf.p;
import gf.y;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i extends gf.a implements Serializable {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10665a;

        static {
            int[] iArr = new int[y.c.values().length];
            f10665a = iArr;
            try {
                iArr[y.c.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10665a[y.c.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class b extends a.AbstractC0191a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public gf.d f10666a = gf.d.f10630a;

        public final gf.d i() {
            return this.f10666a;
        }

        public abstract b j(i iVar);

        public final b k(gf.d dVar) {
            this.f10666a = dVar;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class c extends b implements q {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h f10667b = h.g();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f10668c;

        public final h m() {
            this.f10667b.q();
            this.f10668c = false;
            return this.f10667b;
        }

        public final void n() {
            if (this.f10668c) {
                return;
            }
            this.f10667b = this.f10667b.clone();
            this.f10668c = true;
        }

        public final void o(d dVar) {
            n();
            this.f10667b.r(dVar.f10669b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e implements h.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j.b f10674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f10675b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final y.b f10676c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f10677d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f10678e;

        public e(j.b bVar, int i10, y.b bVar2, boolean z10, boolean z11) {
            this.f10674a = bVar;
            this.f10675b = i10;
            this.f10676c = bVar2;
            this.f10677d = z10;
            this.f10678e = z11;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(e eVar) {
            return this.f10675b - eVar.f10675b;
        }

        public j.b b() {
            return this.f10674a;
        }

        @Override // gf.h.b
        public int d() {
            return this.f10675b;
        }

        @Override // gf.h.b
        public boolean e() {
            return this.f10677d;
        }

        @Override // gf.h.b
        public y.b f() {
            return this.f10676c;
        }

        @Override // gf.h.b
        public boolean g() {
            return this.f10678e;
        }

        @Override // gf.h.b
        public p.a p(p.a aVar, p pVar) {
            return ((b) aVar).j((i) pVar);
        }

        @Override // gf.h.b
        public y.c r() {
            return this.f10676c.a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p f10679a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f10680b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final p f10681c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final e f10682d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Class f10683e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Method f10684f;

        public f(p pVar, Object obj, p pVar2, e eVar, Class cls) {
            if (pVar == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (eVar.f() == y.b.f10746m && pVar2 == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            }
            this.f10679a = pVar;
            this.f10680b = obj;
            this.f10681c = pVar2;
            this.f10682d = eVar;
            this.f10683e = cls;
            if (j.a.class.isAssignableFrom(cls)) {
                this.f10684f = i.j(cls, "valueOf", Integer.TYPE);
            } else {
                this.f10684f = null;
            }
        }

        public Object a(Object obj) {
            if (!this.f10682d.e()) {
                return e(obj);
            }
            if (this.f10682d.r() != y.c.ENUM) {
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
            return this.f10679a;
        }

        public p c() {
            return this.f10681c;
        }

        public int d() {
            return this.f10682d.d();
        }

        public Object e(Object obj) {
            return this.f10682d.r() == y.c.ENUM ? i.k(this.f10684f, null, (Integer) obj) : obj;
        }

        public Object f(Object obj) {
            return this.f10682d.r() == y.c.ENUM ? Integer.valueOf(((j.a) obj).d()) : obj;
        }
    }

    public i() {
    }

    public static Method j(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e10) {
            String name = cls.getName();
            String strValueOf = String.valueOf(str);
            StringBuilder sb2 = new StringBuilder(name.length() + 45 + strValueOf.length());
            sb2.append("Generated message class \"");
            sb2.append(name);
            sb2.append("\" missing method \"");
            sb2.append(strValueOf);
            sb2.append("\".");
            throw new RuntimeException(sb2.toString(), e10);
        }
    }

    public static Object k(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static f m(p pVar, p pVar2, j.b bVar, int i10, y.b bVar2, boolean z10, Class cls) {
        return new f(pVar, Collections.EMPTY_LIST, pVar2, new e(bVar, i10, bVar2, true, z10), cls);
    }

    public static f n(p pVar, Object obj, p pVar2, j.b bVar, int i10, y.b bVar2, Class cls) {
        return new f(pVar, obj, pVar2, new e(bVar, i10, bVar2, false, false), cls);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean p(gf.h r5, gf.p r6, gf.e r7, gf.f r8, gf.g r9, int r10) throws gf.k {
        /*
            Method dump skipped, instruction units count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: gf.i.p(gf.h, gf.p, gf.e, gf.f, gf.g, int):boolean");
    }

    public boolean o(gf.e eVar, gf.f fVar, g gVar, int i10) {
        return eVar.O(i10, fVar);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class d extends i implements q {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h f10669b;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Iterator f10670a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Map.Entry f10671b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final boolean f10672c;

            public /* synthetic */ a(d dVar, boolean z10, a aVar) {
                this(z10);
            }

            public void a(int i10, gf.f fVar) {
                while (true) {
                    Map.Entry entry = this.f10671b;
                    if (entry == null || ((e) entry.getKey()).d() >= i10) {
                        return;
                    }
                    e eVar = (e) this.f10671b.getKey();
                    if (this.f10672c && eVar.r() == y.c.MESSAGE && !eVar.e()) {
                        fVar.e0(eVar.d(), (p) this.f10671b.getValue());
                    } else {
                        h.z(eVar, this.f10671b.getValue(), fVar);
                    }
                    if (this.f10670a.hasNext()) {
                        this.f10671b = (Map.Entry) this.f10670a.next();
                    } else {
                        this.f10671b = null;
                    }
                }
            }

            public a(boolean z10) {
                Iterator itP = d.this.f10669b.p();
                this.f10670a = itP;
                if (itP.hasNext()) {
                    this.f10671b = (Map.Entry) itP.next();
                }
                this.f10672c = z10;
            }
        }

        public d() {
            this.f10669b = h.t();
        }

        @Override // gf.i
        public void l() {
            this.f10669b.q();
        }

        @Override // gf.i
        public boolean o(gf.e eVar, gf.f fVar, g gVar, int i10) {
            return i.p(this.f10669b, a(), eVar, fVar, gVar, i10);
        }

        public boolean r() {
            return this.f10669b.n();
        }

        public int s() {
            return this.f10669b.k();
        }

        public final Object t(f fVar) {
            z(fVar);
            Object objH = this.f10669b.h(fVar.f10682d);
            return objH == null ? fVar.f10680b : fVar.a(objH);
        }

        public final Object v(f fVar, int i10) {
            z(fVar);
            return fVar.e(this.f10669b.i(fVar.f10682d, i10));
        }

        public final int w(f fVar) {
            z(fVar);
            return this.f10669b.j(fVar.f10682d);
        }

        public final boolean x(f fVar) {
            z(fVar);
            return this.f10669b.m(fVar.f10682d);
        }

        public a y() {
            return new a(this, false, null);
        }

        public final void z(f fVar) {
            if (fVar.b() != a()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public d(c cVar) {
            this.f10669b = cVar.m();
        }
    }

    public i(b bVar) {
    }

    public void l() {
    }
}
