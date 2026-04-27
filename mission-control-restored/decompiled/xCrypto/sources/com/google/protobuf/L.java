package com.google.protobuf;

import com.google.protobuf.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final L f10955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final L f10956b;

    public static final class b extends L {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Class f10957c = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

        public b() {
            super();
        }

        public static List f(Object obj, long j4) {
            return (List) A0.G(obj, j4);
        }

        public static List g(Object obj, long j4, int i4) {
            List listF = f(obj, j4);
            if (listF.isEmpty()) {
                List j5 = listF instanceof K ? new J(i4) : ((listF instanceof h0) && (listF instanceof C.i)) ? ((C.i) listF).a(i4) : new ArrayList(i4);
                A0.V(obj, j4, j5);
                return j5;
            }
            if (f10957c.isAssignableFrom(listF.getClass())) {
                ArrayList arrayList = new ArrayList(listF.size() + i4);
                arrayList.addAll(listF);
                A0.V(obj, j4, arrayList);
                return arrayList;
            }
            if (listF instanceof z0) {
                J j6 = new J(listF.size() + i4);
                j6.addAll((z0) listF);
                A0.V(obj, j4, j6);
                return j6;
            }
            if ((listF instanceof h0) && (listF instanceof C.i)) {
                C.i iVar = (C.i) listF;
                if (!iVar.e()) {
                    C.i iVarA = iVar.a(listF.size() + i4);
                    A0.V(obj, j4, iVarA);
                    return iVarA;
                }
            }
            return listF;
        }

        @Override // com.google.protobuf.L
        public void c(Object obj, long j4) {
            Object objUnmodifiableList;
            List list = (List) A0.G(obj, j4);
            if (list instanceof K) {
                objUnmodifiableList = ((K) list).h();
            } else {
                if (f10957c.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof h0) && (list instanceof C.i)) {
                    C.i iVar = (C.i) list;
                    if (iVar.e()) {
                        iVar.d();
                        return;
                    }
                    return;
                }
                objUnmodifiableList = Collections.unmodifiableList(list);
            }
            A0.V(obj, j4, objUnmodifiableList);
        }

        @Override // com.google.protobuf.L
        public void d(Object obj, Object obj2, long j4) {
            List listF = f(obj2, j4);
            List listG = g(obj, j4, listF.size());
            int size = listG.size();
            int size2 = listF.size();
            if (size > 0 && size2 > 0) {
                listG.addAll(listF);
            }
            if (size > 0) {
                listF = listG;
            }
            A0.V(obj, j4, listF);
        }

        @Override // com.google.protobuf.L
        public List e(Object obj, long j4) {
            return g(obj, j4, 10);
        }
    }

    public static final class c extends L {
        public c() {
            super();
        }

        public static C.i f(Object obj, long j4) {
            return (C.i) A0.G(obj, j4);
        }

        @Override // com.google.protobuf.L
        public void c(Object obj, long j4) {
            f(obj, j4).d();
        }

        @Override // com.google.protobuf.L
        public void d(Object obj, Object obj2, long j4) {
            C.i iVarF = f(obj, j4);
            C.i iVarF2 = f(obj2, j4);
            int size = iVarF.size();
            int size2 = iVarF2.size();
            if (size > 0 && size2 > 0) {
                if (!iVarF.e()) {
                    iVarF = iVarF.a(size2 + size);
                }
                iVarF.addAll(iVarF2);
            }
            if (size > 0) {
                iVarF2 = iVarF;
            }
            A0.V(obj, j4, iVarF2);
        }

        @Override // com.google.protobuf.L
        public List e(Object obj, long j4) {
            C.i iVarF = f(obj, j4);
            if (iVarF.e()) {
                return iVarF;
            }
            int size = iVarF.size();
            C.i iVarA = iVarF.a(size == 0 ? 10 : size * 2);
            A0.V(obj, j4, iVarA);
            return iVarA;
        }
    }

    static {
        f10955a = new b();
        f10956b = new c();
    }

    public static L a() {
        return f10955a;
    }

    public static L b() {
        return f10956b;
    }

    public abstract void c(Object obj, long j4);

    public abstract void d(Object obj, Object obj2, long j4);

    public abstract List e(Object obj, long j4);

    public L() {
    }
}
