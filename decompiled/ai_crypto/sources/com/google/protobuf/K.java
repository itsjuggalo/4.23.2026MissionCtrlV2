package com.google.protobuf;

import com.google.protobuf.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final K f12583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final K f12584b;

    public static final class b extends K {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Class f12585c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        public b() {
            super();
        }

        public static List f(Object obj, long j7) {
            return (List) z0.G(obj, j7);
        }

        public static List g(Object obj, long j7, int i7) {
            List list;
            List listF = f(obj, j7);
            if (listF.isEmpty()) {
                List i8 = listF instanceof J ? new I(i7) : ((listF instanceof g0) && (listF instanceof C.e)) ? ((C.e) listF).e(i7) : new ArrayList(i7);
                z0.V(obj, j7, i8);
                return i8;
            }
            if (f12585c.isAssignableFrom(listF.getClass())) {
                ArrayList arrayList = new ArrayList(listF.size() + i7);
                arrayList.addAll(listF);
                z0.V(obj, j7, arrayList);
                list = arrayList;
            } else {
                if (!(listF instanceof y0)) {
                    if (!(listF instanceof g0) || !(listF instanceof C.e)) {
                        return listF;
                    }
                    C.e eVar = (C.e) listF;
                    if (eVar.f()) {
                        return listF;
                    }
                    C.e eVarE = eVar.e(listF.size() + i7);
                    z0.V(obj, j7, eVarE);
                    return eVarE;
                }
                I i9 = new I(listF.size() + i7);
                i9.addAll((y0) listF);
                z0.V(obj, j7, i9);
                list = i9;
            }
            return list;
        }

        @Override // com.google.protobuf.K
        public void c(Object obj, long j7) {
            Object objUnmodifiableList;
            List list = (List) z0.G(obj, j7);
            if (list instanceof J) {
                objUnmodifiableList = ((J) list).v();
            } else {
                if (f12585c.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof g0) && (list instanceof C.e)) {
                    C.e eVar = (C.e) list;
                    if (eVar.f()) {
                        eVar.d();
                        return;
                    }
                    return;
                }
                objUnmodifiableList = Collections.unmodifiableList(list);
            }
            z0.V(obj, j7, objUnmodifiableList);
        }

        @Override // com.google.protobuf.K
        public void d(Object obj, Object obj2, long j7) {
            List listF = f(obj2, j7);
            List listG = g(obj, j7, listF.size());
            int size = listG.size();
            int size2 = listF.size();
            if (size > 0 && size2 > 0) {
                listG.addAll(listF);
            }
            if (size > 0) {
                listF = listG;
            }
            z0.V(obj, j7, listF);
        }

        @Override // com.google.protobuf.K
        public List e(Object obj, long j7) {
            return g(obj, j7, 10);
        }
    }

    public static final class c extends K {
        public c() {
            super();
        }

        public static C.e f(Object obj, long j7) {
            return (C.e) z0.G(obj, j7);
        }

        @Override // com.google.protobuf.K
        public void c(Object obj, long j7) {
            f(obj, j7).d();
        }

        @Override // com.google.protobuf.K
        public void d(Object obj, Object obj2, long j7) {
            C.e eVarF = f(obj, j7);
            C.e eVarF2 = f(obj2, j7);
            int size = eVarF.size();
            int size2 = eVarF2.size();
            if (size > 0 && size2 > 0) {
                if (!eVarF.f()) {
                    eVarF = eVarF.e(size2 + size);
                }
                eVarF.addAll(eVarF2);
            }
            if (size > 0) {
                eVarF2 = eVarF;
            }
            z0.V(obj, j7, eVarF2);
        }

        @Override // com.google.protobuf.K
        public List e(Object obj, long j7) {
            C.e eVarF = f(obj, j7);
            if (eVarF.f()) {
                return eVarF;
            }
            int size = eVarF.size();
            C.e eVarE = eVarF.e(size == 0 ? 10 : size * 2);
            z0.V(obj, j7, eVarE);
            return eVarE;
        }
    }

    static {
        f12583a = new b();
        f12584b = new c();
    }

    public static K a() {
        return f12583a;
    }

    public static K b() {
        return f12584b;
    }

    public abstract void c(Object obj, long j7);

    public abstract void d(Object obj, Object obj2, long j7);

    public abstract List e(Object obj, long j7);

    public K() {
    }
}
