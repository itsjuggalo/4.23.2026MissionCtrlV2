package a6;

import O5.o;
import i6.C1981l;
import i6.EnumC1975i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2489q;
import p5.AbstractC2592n;

/* JADX INFO: renamed from: a6.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1079b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f10124c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f10125d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D f10126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f10127b;

    /* JADX INFO: renamed from: a6.b$a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (EnumC1080c enumC1080c : EnumC1080c.values()) {
            String strB = enumC1080c.b();
            if (linkedHashMap.get(strB) == null) {
                linkedHashMap.put(strB, enumC1080c);
            }
        }
        f10125d = linkedHashMap;
    }

    public AbstractC1079b(D javaTypeEnhancementState) {
        AbstractC2304t.f(javaTypeEnhancementState, "javaTypeEnhancementState");
        this.f10126a = javaTypeEnhancementState;
        this.f10127b = new ConcurrentHashMap();
    }

    public static final boolean f(Object extractNullability) {
        AbstractC2304t.f(extractNullability, "$this$extractNullability");
        return false;
    }

    public final Set b(Set set) {
        return set.contains(EnumC1080c.f10131e) ? p5.T.l(p5.T.k(AbstractC2592n.w0(EnumC1080c.values()), EnumC1080c.f10132f), set) : set;
    }

    public abstract Iterable c(Object obj, boolean z7);

    public final E d(E e8, Iterable annotations) {
        EnumMap enumMapB;
        AbstractC2304t.f(annotations, "annotations");
        if (this.f10126a.b()) {
            return e8;
        }
        ArrayList<w> arrayList = new ArrayList();
        Iterator it = annotations.iterator();
        while (it.hasNext()) {
            w wVarE = e(it.next());
            if (wVarE != null) {
                arrayList.add(wVarE);
            }
        }
        if (arrayList.isEmpty()) {
            return e8;
        }
        EnumMap enumMap = new EnumMap(EnumC1080c.class);
        for (w wVar : arrayList) {
            for (EnumC1080c enumC1080c : wVar.e()) {
                if (enumMap.containsKey(enumC1080c) && o()) {
                    w wVar2 = (w) enumMap.get(enumC1080c);
                    if (wVar2 != null) {
                        C1981l c1981lD = wVar2.d();
                        C1981l c1981lD2 = wVar.d();
                        if (!AbstractC2304t.b(c1981lD2, c1981lD) && (!c1981lD2.d() || c1981lD.d())) {
                            wVar2 = (c1981lD2.d() || !c1981lD.d()) ? null : wVar;
                        }
                        enumMap.put(enumC1080c, wVar2);
                    }
                } else {
                    enumMap.put(enumC1080c, wVar);
                }
            }
        }
        EnumMap enumMap2 = (e8 == null || (enumMapB = e8.b()) == null) ? new EnumMap(EnumC1080c.class) : new EnumMap(enumMapB);
        boolean z7 = false;
        for (Map.Entry entry : enumMap.entrySet()) {
            EnumC1080c enumC1080c2 = (EnumC1080c) entry.getKey();
            w wVar3 = (w) entry.getValue();
            if (wVar3 != null) {
                enumMap2.put(enumC1080c2, wVar3);
                z7 = true;
            }
        }
        return !z7 ? e8 : new E(enumMap2);
    }

    public final w e(Object obj) {
        C1981l c1981lI;
        w wVarU = u(obj);
        if (wVarU != null) {
            return wVarU;
        }
        C2489q c2489qW = w(obj);
        if (c2489qW == null) {
            return null;
        }
        Object objA = c2489qW.a();
        Set set = (Set) c2489qW.b();
        O oT = t(obj);
        if (oT == null) {
            oT = s(objA);
        }
        if (oT.g() || (c1981lI = i(objA, C1078a.f10123a)) == null) {
            return null;
        }
        return new w(C1981l.b(c1981lI, null, oT.i(), 1, null), set, false, 4, null);
    }

    public final EnumC1975i g(Iterable annotations) {
        EnumC1975i enumC1975i;
        AbstractC2304t.f(annotations, "annotations");
        Iterator it = annotations.iterator();
        EnumC1975i enumC1975i2 = null;
        while (it.hasNext()) {
            q6.c cVarK = k(it.next());
            if (p5.z.Q(J.o(), cVarK)) {
                enumC1975i = EnumC1975i.f18888a;
            } else if (p5.z.Q(J.l(), cVarK)) {
                enumC1975i = EnumC1975i.f18889b;
            } else {
                continue;
            }
            if (enumC1975i2 != null && enumC1975i2 != enumC1975i) {
                return null;
            }
            enumC1975i2 = enumC1975i;
        }
        return enumC1975i2;
    }

    public final C1981l h(Iterable annotations, B5.k forceWarning) {
        AbstractC2304t.f(annotations, "annotations");
        AbstractC2304t.f(forceWarning, "forceWarning");
        Iterator it = annotations.iterator();
        C1981l c1981l = null;
        while (it.hasNext()) {
            C1981l c1981lI = i(it.next(), forceWarning);
            if (c1981l != null) {
                if (c1981lI != null && !AbstractC2304t.b(c1981lI, c1981l) && (!c1981lI.d() || c1981l.d())) {
                    if (c1981lI.d() || !c1981l.d()) {
                        return null;
                    }
                }
            }
            c1981l = c1981lI;
        }
        return c1981l;
    }

    public final C1981l i(Object obj, B5.k kVar) {
        C1981l c1981lQ;
        C1981l c1981lQ2 = q(obj, ((Boolean) kVar.invoke(obj)).booleanValue());
        if (c1981lQ2 != null) {
            return c1981lQ2;
        }
        Object objV = v(obj);
        if (objV == null) {
            return null;
        }
        O oS = s(obj);
        if (oS.g() || (c1981lQ = q(objV, ((Boolean) kVar.invoke(objV)).booleanValue())) == null) {
            return null;
        }
        return C1981l.b(c1981lQ, null, oS.i(), 1, null);
    }

    public final Object j(Object obj, q6.c cVar) {
        for (Object obj2 : m(obj)) {
            if (AbstractC2304t.b(k(obj2), cVar)) {
                return obj2;
            }
        }
        return null;
    }

    public abstract q6.c k(Object obj);

    public abstract Object l(Object obj);

    public abstract Iterable m(Object obj);

    public final boolean n(Object obj, q6.c cVar) {
        Iterable iterableM = m(obj);
        if ((iterableM instanceof Collection) && ((Collection) iterableM).isEmpty()) {
            return false;
        }
        Iterator it = iterableM.iterator();
        while (it.hasNext()) {
            if (AbstractC2304t.b(k(it.next()), cVar)) {
                return true;
            }
        }
        return false;
    }

    public abstract boolean o();

    public final boolean p(Object annotation) {
        AbstractC2304t.f(annotation, "annotation");
        Object objJ = j(annotation, o.a.f6135H);
        if (objJ == null) {
            return false;
        }
        Iterable iterableC = c(objJ, false);
        if ((iterableC instanceof Collection) && ((Collection) iterableC).isEmpty()) {
            return false;
        }
        Iterator it = iterableC.iterator();
        while (it.hasNext()) {
            if (AbstractC2304t.b((String) it.next(), "TYPE")) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0067, code lost:
    
        if (r6.equals("ALWAYS") != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0070, code lost:
    
        if (r6.equals("UNKNOWN") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0079, code lost:
    
        if (r6.equals("NEVER") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0082, code lost:
    
        if (r6.equals("MAYBE") == false) goto L35;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final i6.C1981l q(java.lang.Object r6, boolean r7) {
        /*
            r5 = this;
            q6.c r0 = r5.k(r6)
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            a6.D r2 = r5.f10126a
            B5.k r2 = r2.c()
            java.lang.Object r2 = r2.invoke(r0)
            a6.O r2 = (a6.O) r2
            boolean r3 = r2.g()
            if (r3 == 0) goto L1b
            return r1
        L1b:
            java.util.Set r3 = a6.J.m()
            boolean r3 = r3.contains(r0)
            r4 = 0
            if (r3 == 0) goto L29
        L26:
            i6.k r6 = i6.EnumC1979k.f18897c
            goto L85
        L29:
            java.util.Set r3 = a6.J.n()
            boolean r3 = r3.contains(r0)
            if (r3 == 0) goto L36
        L33:
            i6.k r6 = i6.EnumC1979k.f18896b
            goto L85
        L36:
            java.util.Set r3 = a6.J.b()
            boolean r3 = r3.contains(r0)
            if (r3 == 0) goto L43
        L40:
            i6.k r6 = i6.EnumC1979k.f18895a
            goto L85
        L43:
            q6.c r3 = a6.J.c()
            boolean r0 = kotlin.jvm.internal.AbstractC2304t.b(r0, r3)
            if (r0 == 0) goto L94
            java.lang.Iterable r6 = r5.c(r6, r4)
            java.lang.Object r6 = p5.z.Z(r6)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L26
            int r0 = r6.hashCode()
            switch(r0) {
                case 73135176: goto L7c;
                case 74175084: goto L73;
                case 433141802: goto L6a;
                case 1933739535: goto L61;
                default: goto L60;
            }
        L60:
            goto L84
        L61:
            java.lang.String r0 = "ALWAYS"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L84
            goto L26
        L6a:
            java.lang.String r0 = "UNKNOWN"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L40
            goto L84
        L73:
            java.lang.String r0 = "NEVER"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L33
            goto L84
        L7c:
            java.lang.String r0 = "MAYBE"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L33
        L84:
            return r1
        L85:
            i6.l r0 = new i6.l
            boolean r1 = r2.i()
            if (r1 != 0) goto L8f
            if (r7 == 0) goto L90
        L8f:
            r4 = 1
        L90:
            r0.<init>(r6, r4)
            return r0
        L94:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.AbstractC1079b.q(java.lang.Object, boolean):i6.l");
    }

    public final O r(Object obj) {
        q6.c cVarK = k(obj);
        return (cVarK == null || !x.b().containsKey(cVarK)) ? s(obj) : (O) this.f10126a.c().invoke(cVarK);
    }

    public final O s(Object obj) {
        O oT = t(obj);
        return oT != null ? oT : this.f10126a.d().c();
    }

    public final O t(Object obj) {
        Iterable iterableC;
        String str;
        O o8 = (O) this.f10126a.d().e().get(k(obj));
        if (o8 != null) {
            return o8;
        }
        Object objJ = j(obj, J.p());
        if (objJ == null || (iterableC = c(objJ, false)) == null || (str = (String) p5.z.Z(iterableC)) == null) {
            return null;
        }
        O oD = this.f10126a.d().d();
        if (oD != null) {
            return oD;
        }
        int iHashCode = str.hashCode();
        if (iHashCode == -2137067054) {
            if (str.equals("IGNORE")) {
                return O.f10081c;
            }
            return null;
        }
        if (iHashCode == -1838656823) {
            if (str.equals("STRICT")) {
                return O.f10083e;
            }
            return null;
        }
        if (iHashCode == 2656902 && str.equals("WARN")) {
            return O.f10082d;
        }
        return null;
    }

    public final w u(Object obj) {
        w wVar;
        if (this.f10126a.b() || (wVar = (w) x.a().get(k(obj))) == null) {
            return null;
        }
        O oR = r(obj);
        if (oR == O.f10081c) {
            oR = null;
        }
        if (oR == null) {
            return null;
        }
        return w.b(wVar, C1981l.b(wVar.d(), null, oR.i(), 1, null), null, false, 6, null);
    }

    public final Object v(Object annotation) {
        Object objV;
        AbstractC2304t.f(annotation, "annotation");
        if (this.f10126a.d().f()) {
            return null;
        }
        if (p5.z.Q(J.a(), k(annotation)) || n(annotation, J.f())) {
            return annotation;
        }
        if (!n(annotation, J.h())) {
            return null;
        }
        ConcurrentHashMap concurrentHashMap = this.f10127b;
        Object objL = l(annotation);
        Object obj = concurrentHashMap.get(objL);
        if (obj != null) {
            return obj;
        }
        Iterator it = m(annotation).iterator();
        while (true) {
            if (!it.hasNext()) {
                objV = null;
                break;
            }
            objV = v(it.next());
            if (objV != null) {
                break;
            }
        }
        if (objV == null) {
            return null;
        }
        Object objPutIfAbsent = concurrentHashMap.putIfAbsent(objL, objV);
        return objPutIfAbsent == null ? objV : objPutIfAbsent;
    }

    public final C2489q w(Object obj) {
        Object objJ;
        Object next;
        if (this.f10126a.d().f() || (objJ = j(obj, J.g())) == null) {
            return null;
        }
        Iterator it = m(obj).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (v(next) != null) {
                break;
            }
        }
        if (next == null) {
            return null;
        }
        Iterable iterableC = c(objJ, true);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it2 = iterableC.iterator();
        while (it2.hasNext()) {
            EnumC1080c enumC1080c = (EnumC1080c) f10125d.get((String) it2.next());
            if (enumC1080c != null) {
                linkedHashSet.add(enumC1080c);
            }
        }
        return new C2489q(next, b(linkedHashSet));
    }
}
