package oe;

import ce.o;
import dd.v0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f17932c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f17933d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f17934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f17935b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (c cVar : c.values()) {
            String strB = cVar.b();
            if (linkedHashMap.get(strB) == null) {
                linkedHashMap.put(strB, cVar);
            }
        }
        f17933d = linkedHashMap;
    }

    public b(d0 javaTypeEnhancementState) {
        kotlin.jvm.internal.t.f(javaTypeEnhancementState, "javaTypeEnhancementState");
        this.f17934a = javaTypeEnhancementState;
        this.f17935b = new ConcurrentHashMap();
    }

    public static final boolean f(Object extractNullability) {
        kotlin.jvm.internal.t.f(extractNullability, "$this$extractNullability");
        return false;
    }

    public final Set b(Set set) {
        return set.contains(c.f17947e) ? v0.l(v0.k(dd.n.L0(c.values()), c.f17948f), set) : set;
    }

    public abstract Iterable c(Object obj, boolean z10);

    public final e0 d(e0 e0Var, Iterable annotations) {
        EnumMap enumMapB;
        kotlin.jvm.internal.t.f(annotations, "annotations");
        if (!this.f17934a.b()) {
            ArrayList<w> arrayList = new ArrayList();
            Iterator it = annotations.iterator();
            while (it.hasNext()) {
                w wVarE = e(it.next());
                if (wVarE != null) {
                    arrayList.add(wVarE);
                }
            }
            if (!arrayList.isEmpty()) {
                EnumMap enumMap = new EnumMap(c.class);
                for (w wVar : arrayList) {
                    for (c cVar : wVar.e()) {
                        if (enumMap.containsKey(cVar) && o()) {
                            w wVar2 = (w) enumMap.get(cVar);
                            if (wVar2 != null) {
                                we.l lVarD = wVar2.d();
                                we.l lVarD2 = wVar.d();
                                if (!kotlin.jvm.internal.t.b(lVarD2, lVarD) && (!lVarD2.d() || lVarD.d())) {
                                    wVar2 = (lVarD2.d() || !lVarD.d()) ? null : wVar;
                                }
                                enumMap.put(cVar, wVar2);
                            }
                        } else {
                            enumMap.put(cVar, wVar);
                        }
                    }
                }
                EnumMap enumMap2 = (e0Var == null || (enumMapB = e0Var.b()) == null) ? new EnumMap(c.class) : new EnumMap(enumMapB);
                boolean z10 = false;
                for (Map.Entry entry : enumMap.entrySet()) {
                    c cVar2 = (c) entry.getKey();
                    w wVar3 = (w) entry.getValue();
                    if (wVar3 != null) {
                        enumMap2.put(cVar2, wVar3);
                        z10 = true;
                    }
                }
                if (z10) {
                    return new e0(enumMap2);
                }
            }
        }
        return e0Var;
    }

    public final w e(Object obj) {
        we.l lVarI;
        w wVarU = u(obj);
        if (wVarU != null) {
            return wVarU;
        }
        cd.q qVarW = w(obj);
        if (qVarW == null) {
            return null;
        }
        Object objA = qVarW.a();
        Set set = (Set) qVarW.b();
        o0 o0VarT = t(obj);
        if (o0VarT == null) {
            o0VarT = s(objA);
        }
        if (o0VarT.c() || (lVarI = i(objA, oe.a.f17931a)) == null) {
            return null;
        }
        return new w(we.l.b(lVarI, null, o0VarT.h(), 1, null), set, false, 4, null);
    }

    public final we.i g(Iterable annotations) {
        we.i iVar;
        kotlin.jvm.internal.t.f(annotations, "annotations");
        Iterator it = annotations.iterator();
        we.i iVar2 = null;
        while (it.hasNext()) {
            ef.c cVarK = k(it.next());
            if (dd.a0.R(j0.o(), cVarK)) {
                iVar = we.i.f23983a;
            } else if (dd.a0.R(j0.l(), cVarK)) {
                iVar = we.i.f23984b;
            } else {
                continue;
            }
            if (iVar2 != null && iVar2 != iVar) {
                return null;
            }
            iVar2 = iVar;
        }
        return iVar2;
    }

    public final we.l h(Iterable annotations, pd.k forceWarning) {
        kotlin.jvm.internal.t.f(annotations, "annotations");
        kotlin.jvm.internal.t.f(forceWarning, "forceWarning");
        Iterator it = annotations.iterator();
        we.l lVar = null;
        while (it.hasNext()) {
            we.l lVarI = i(it.next(), forceWarning);
            if (lVar != null) {
                if (lVarI != null && !kotlin.jvm.internal.t.b(lVarI, lVar) && (!lVarI.d() || lVar.d())) {
                    if (lVarI.d() || !lVar.d()) {
                        return null;
                    }
                }
            }
            lVar = lVarI;
        }
        return lVar;
    }

    public final we.l i(Object obj, pd.k kVar) {
        we.l lVarQ;
        we.l lVarQ2 = q(obj, ((Boolean) kVar.invoke(obj)).booleanValue());
        if (lVarQ2 != null) {
            return lVarQ2;
        }
        Object objV = v(obj);
        if (objV == null) {
            return null;
        }
        o0 o0VarS = s(obj);
        if (o0VarS.c() || (lVarQ = q(objV, ((Boolean) kVar.invoke(objV)).booleanValue())) == null) {
            return null;
        }
        return we.l.b(lVarQ, null, o0VarS.h(), 1, null);
    }

    public final Object j(Object obj, ef.c cVar) {
        for (Object obj2 : m(obj)) {
            if (kotlin.jvm.internal.t.b(k(obj2), cVar)) {
                return obj2;
            }
        }
        return null;
    }

    public abstract ef.c k(Object obj);

    public abstract Object l(Object obj);

    public abstract Iterable m(Object obj);

    public final boolean n(Object obj, ef.c cVar) {
        Iterable iterableM = m(obj);
        if ((iterableM instanceof Collection) && ((Collection) iterableM).isEmpty()) {
            return false;
        }
        Iterator it = iterableM.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.t.b(k(it.next()), cVar)) {
                return true;
            }
        }
        return false;
    }

    public abstract boolean o();

    public final boolean p(Object annotation) {
        kotlin.jvm.internal.t.f(annotation, "annotation");
        Object objJ = j(annotation, o.a.H);
        if (objJ == null) {
            return false;
        }
        Iterable iterableC = c(objJ, false);
        if ((iterableC instanceof Collection) && ((Collection) iterableC).isEmpty()) {
            return false;
        }
        Iterator it = iterableC.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.t.b((String) it.next(), "TYPE")) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0067, code lost:
    
        if (r6.equals("ALWAYS") != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
    
        if (r6.equals("NEVER") == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0085, code lost:
    
        if (r6.equals("MAYBE") == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0088, code lost:
    
        r6 = we.k.f23993b;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final we.l q(java.lang.Object r6, boolean r7) {
        /*
            r5 = this;
            ef.c r0 = r5.k(r6)
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            oe.d0 r2 = r5.f17934a
            pd.k r2 = r2.c()
            java.lang.Object r2 = r2.invoke(r0)
            oe.o0 r2 = (oe.o0) r2
            boolean r3 = r2.c()
            if (r3 == 0) goto L1b
            return r1
        L1b:
            java.util.Set r3 = oe.j0.m()
            boolean r3 = r3.contains(r0)
            r4 = 0
            if (r3 == 0) goto L29
            we.k r6 = we.k.f23994c
            goto L8d
        L29:
            java.util.Set r3 = oe.j0.n()
            boolean r3 = r3.contains(r0)
            if (r3 == 0) goto L36
            we.k r6 = we.k.f23993b
            goto L8d
        L36:
            java.util.Set r3 = oe.j0.b()
            boolean r3 = r3.contains(r0)
            if (r3 == 0) goto L43
            we.k r6 = we.k.f23992a
            goto L8d
        L43:
            ef.c r3 = oe.j0.c()
            boolean r0 = kotlin.jvm.internal.t.b(r0, r3)
            if (r0 == 0) goto L9c
            java.lang.Iterable r6 = r5.c(r6, r4)
            java.lang.Object r6 = dd.a0.a0(r6)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L8b
            int r0 = r6.hashCode()
            switch(r0) {
                case 73135176: goto L7f;
                case 74175084: goto L76;
                case 433141802: goto L6a;
                case 1933739535: goto L61;
                default: goto L60;
            }
        L60:
            goto L87
        L61:
            java.lang.String r0 = "ALWAYS"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L87
            goto L8b
        L6a:
            java.lang.String r0 = "UNKNOWN"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L73
            goto L87
        L73:
            we.k r6 = we.k.f23992a
            goto L8d
        L76:
            java.lang.String r0 = "NEVER"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L88
            goto L87
        L7f:
            java.lang.String r0 = "MAYBE"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L88
        L87:
            return r1
        L88:
            we.k r6 = we.k.f23993b
            goto L8d
        L8b:
            we.k r6 = we.k.f23994c
        L8d:
            we.l r0 = new we.l
            boolean r1 = r2.h()
            if (r1 != 0) goto L97
            if (r7 == 0) goto L98
        L97:
            r4 = 1
        L98:
            r0.<init>(r6, r4)
            return r0
        L9c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: oe.b.q(java.lang.Object, boolean):we.l");
    }

    public final o0 r(Object obj) {
        ef.c cVarK = k(obj);
        return (cVarK == null || !x.b().containsKey(cVarK)) ? s(obj) : (o0) this.f17934a.c().invoke(cVarK);
    }

    public final o0 s(Object obj) {
        o0 o0VarT = t(obj);
        return o0VarT != null ? o0VarT : this.f17934a.d().c();
    }

    public final o0 t(Object obj) {
        Iterable iterableC;
        String str;
        o0 o0Var = (o0) this.f17934a.d().e().get(k(obj));
        if (o0Var != null) {
            return o0Var;
        }
        Object objJ = j(obj, j0.p());
        if (objJ == null || (iterableC = c(objJ, false)) == null || (str = (String) dd.a0.a0(iterableC)) == null) {
            return null;
        }
        o0 o0VarD = this.f17934a.d().d();
        if (o0VarD != null) {
            return o0VarD;
        }
        int iHashCode = str.hashCode();
        if (iHashCode != -2137067054) {
            if (iHashCode != -1838656823) {
                if (iHashCode == 2656902 && str.equals("WARN")) {
                    return o0.f18047d;
                }
            } else if (str.equals("STRICT")) {
                return o0.f18048e;
            }
        } else if (str.equals("IGNORE")) {
            return o0.f18046c;
        }
        return null;
    }

    public final w u(Object obj) {
        w wVar;
        if (this.f17934a.b() || (wVar = (w) x.a().get(k(obj))) == null) {
            return null;
        }
        o0 o0VarR = r(obj);
        if (o0VarR == o0.f18046c) {
            o0VarR = null;
        }
        if (o0VarR == null) {
            return null;
        }
        return w.b(wVar, we.l.b(wVar.d(), null, o0VarR.h(), 1, null), null, false, 6, null);
    }

    public final Object v(Object annotation) {
        Object objV;
        kotlin.jvm.internal.t.f(annotation, "annotation");
        if (this.f17934a.d().f()) {
            return null;
        }
        if (dd.a0.R(j0.a(), k(annotation)) || n(annotation, j0.f())) {
            return annotation;
        }
        if (!n(annotation, j0.h())) {
            return null;
        }
        ConcurrentHashMap concurrentHashMap = this.f17935b;
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

    public final cd.q w(Object obj) {
        Object objJ;
        Object next;
        if (this.f17934a.d().f() || (objJ = j(obj, j0.g())) == null) {
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
            c cVar = (c) f17933d.get((String) it2.next());
            if (cVar != null) {
                linkedHashSet.add(cVar);
            }
        }
        return new cd.q(next, b(linkedHashSet));
    }
}
