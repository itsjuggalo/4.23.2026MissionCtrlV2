package com.google.protobuf;

import com.google.protobuf.AbstractC1481u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final A f16272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final A f16273b;

    public static final class b extends A {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Class f16274c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        public b() {
            super();
        }

        public static List f(Object obj, long j8) {
            return (List) j0.C(obj, j8);
        }

        public static List g(Object obj, long j8, int i8) {
            List list;
            List listF = f(obj, j8);
            if (listF.isEmpty()) {
                List c1485y = listF instanceof InterfaceC1486z ? new C1485y(i8) : new ArrayList(i8);
                j0.R(obj, j8, c1485y);
                return c1485y;
            }
            if (f16274c.isAssignableFrom(listF.getClass())) {
                ArrayList arrayList = new ArrayList(listF.size() + i8);
                arrayList.addAll(listF);
                list = arrayList;
            } else {
                if (!(listF instanceof i0)) {
                    return listF;
                }
                C1485y c1485y2 = new C1485y(listF.size() + i8);
                c1485y2.addAll((i0) listF);
                list = c1485y2;
            }
            j0.R(obj, j8, list);
            return list;
        }

        @Override // com.google.protobuf.A
        public void c(Object obj, long j8) {
            Object objUnmodifiableList;
            List list = (List) j0.C(obj, j8);
            if (list instanceof InterfaceC1486z) {
                objUnmodifiableList = ((InterfaceC1486z) list).l();
            } else if (f16274c.isAssignableFrom(list.getClass())) {
                return;
            } else {
                objUnmodifiableList = Collections.unmodifiableList(list);
            }
            j0.R(obj, j8, objUnmodifiableList);
        }

        @Override // com.google.protobuf.A
        public void d(Object obj, Object obj2, long j8) {
            List listF = f(obj2, j8);
            List listG = g(obj, j8, listF.size());
            int size = listG.size();
            int size2 = listF.size();
            if (size > 0 && size2 > 0) {
                listG.addAll(listF);
            }
            if (size > 0) {
                listF = listG;
            }
            j0.R(obj, j8, listF);
        }

        @Override // com.google.protobuf.A
        public List e(Object obj, long j8) {
            return g(obj, j8, 10);
        }
    }

    public static final class c extends A {
        public c() {
            super();
        }

        public static AbstractC1481u.d f(Object obj, long j8) {
            return (AbstractC1481u.d) j0.C(obj, j8);
        }

        @Override // com.google.protobuf.A
        public void c(Object obj, long j8) {
            f(obj, j8).g();
        }

        @Override // com.google.protobuf.A
        public void d(Object obj, Object obj2, long j8) {
            AbstractC1481u.d dVarF = f(obj, j8);
            AbstractC1481u.d dVarF2 = f(obj2, j8);
            int size = dVarF.size();
            int size2 = dVarF2.size();
            if (size > 0 && size2 > 0) {
                if (!dVarF.m()) {
                    dVarF = dVarF.i(size2 + size);
                }
                dVarF.addAll(dVarF2);
            }
            if (size > 0) {
                dVarF2 = dVarF;
            }
            j0.R(obj, j8, dVarF2);
        }

        @Override // com.google.protobuf.A
        public List e(Object obj, long j8) {
            AbstractC1481u.d dVarF = f(obj, j8);
            if (dVarF.m()) {
                return dVarF;
            }
            int size = dVarF.size();
            AbstractC1481u.d dVarI = dVarF.i(size == 0 ? 10 : size * 2);
            j0.R(obj, j8, dVarI);
            return dVarI;
        }
    }

    static {
        f16272a = new b();
        f16273b = new c();
    }

    public A() {
    }

    public static A a() {
        return f16272a;
    }

    public static A b() {
        return f16273b;
    }

    public abstract void c(Object obj, long j8);

    public abstract void d(Object obj, Object obj2, long j8);

    public abstract List e(Object obj, long j8);
}
