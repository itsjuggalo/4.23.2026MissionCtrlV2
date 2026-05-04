package com.google.protobuf;

import com.google.protobuf.c0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k0 f7073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k0 f7074b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends k0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Class f7075c = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

        public b() {
            super();
        }

        public static List f(Object obj, long j10) {
            return (List) y1.G(obj, j10);
        }

        public static List g(Object obj, long j10, int i10) {
            List listF = f(obj, j10);
            if (listF.isEmpty()) {
                List i0Var = listF instanceof j0 ? new i0(i10) : ((listF instanceof f1) && (listF instanceof c0.e)) ? ((c0.e) listF).i(i10) : new ArrayList(i10);
                y1.V(obj, j10, i0Var);
                return i0Var;
            }
            if (f7075c.isAssignableFrom(listF.getClass())) {
                ArrayList arrayList = new ArrayList(listF.size() + i10);
                arrayList.addAll(listF);
                y1.V(obj, j10, arrayList);
                return arrayList;
            }
            if (listF instanceof x1) {
                i0 i0Var2 = new i0(listF.size() + i10);
                i0Var2.addAll((x1) listF);
                y1.V(obj, j10, i0Var2);
                return i0Var2;
            }
            if ((listF instanceof f1) && (listF instanceof c0.e)) {
                c0.e eVar = (c0.e) listF;
                if (!eVar.m()) {
                    c0.e eVarI = eVar.i(listF.size() + i10);
                    y1.V(obj, j10, eVarI);
                    return eVarI;
                }
            }
            return listF;
        }

        @Override // com.google.protobuf.k0
        public void c(Object obj, long j10) {
            Object objUnmodifiableList;
            List list = (List) y1.G(obj, j10);
            if (list instanceof j0) {
                objUnmodifiableList = ((j0) list).l();
            } else {
                if (f7075c.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof f1) && (list instanceof c0.e)) {
                    c0.e eVar = (c0.e) list;
                    if (eVar.m()) {
                        eVar.h();
                        return;
                    }
                    return;
                }
                objUnmodifiableList = Collections.unmodifiableList(list);
            }
            y1.V(obj, j10, objUnmodifiableList);
        }

        @Override // com.google.protobuf.k0
        public void d(Object obj, Object obj2, long j10) {
            List listF = f(obj2, j10);
            List listG = g(obj, j10, listF.size());
            int size = listG.size();
            int size2 = listF.size();
            if (size > 0 && size2 > 0) {
                listG.addAll(listF);
            }
            if (size > 0) {
                listF = listG;
            }
            y1.V(obj, j10, listF);
        }

        @Override // com.google.protobuf.k0
        public List e(Object obj, long j10) {
            return g(obj, j10, 10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends k0 {
        public c() {
            super();
        }

        public static c0.e f(Object obj, long j10) {
            return (c0.e) y1.G(obj, j10);
        }

        @Override // com.google.protobuf.k0
        public void c(Object obj, long j10) {
            f(obj, j10).h();
        }

        @Override // com.google.protobuf.k0
        public void d(Object obj, Object obj2, long j10) {
            c0.e eVarF = f(obj, j10);
            c0.e eVarF2 = f(obj2, j10);
            int size = eVarF.size();
            int size2 = eVarF2.size();
            if (size > 0 && size2 > 0) {
                if (!eVarF.m()) {
                    eVarF = eVarF.i(size2 + size);
                }
                eVarF.addAll(eVarF2);
            }
            if (size > 0) {
                eVarF2 = eVarF;
            }
            y1.V(obj, j10, eVarF2);
        }

        @Override // com.google.protobuf.k0
        public List e(Object obj, long j10) {
            c0.e eVarF = f(obj, j10);
            if (eVarF.m()) {
                return eVarF;
            }
            int size = eVarF.size();
            c0.e eVarI = eVarF.i(size == 0 ? 10 : size * 2);
            y1.V(obj, j10, eVarI);
            return eVarI;
        }
    }

    static {
        f7073a = new b();
        f7074b = new c();
    }

    public static k0 a() {
        return f7073a;
    }

    public static k0 b() {
        return f7074b;
    }

    public abstract void c(Object obj, long j10);

    public abstract void d(Object obj, Object obj2, long j10);

    public abstract List e(Object obj, long j10);

    public k0() {
    }
}
