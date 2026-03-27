package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class U extends W {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Class f5683c = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

    public static List d(Object obj, long j4, int i) {
        List list = (List) M0.f5656c.k(obj, j4);
        if (list.isEmpty()) {
            List s6 = list instanceof T ? new S(i) : ((list instanceof InterfaceC0477n0) && (list instanceof L)) ? ((L) list).d(i) : new ArrayList(i);
            M0.p(obj, j4, s6);
            return s6;
        }
        if (f5683c.isAssignableFrom(list.getClass())) {
            ArrayList arrayList = new ArrayList(list.size() + i);
            arrayList.addAll(list);
            M0.p(obj, j4, arrayList);
            return arrayList;
        }
        if (list instanceof H0) {
            S s7 = new S(list.size() + i);
            s7.addAll((H0) list);
            M0.p(obj, j4, s7);
            return s7;
        }
        if ((list instanceof InterfaceC0477n0) && (list instanceof L)) {
            L l6 = (L) list;
            if (!((AbstractC0452b) l6).f5706a) {
                L lD = l6.d(list.size() + i);
                M0.p(obj, j4, lD);
                return lD;
            }
        }
        return list;
    }

    @Override // com.google.protobuf.W
    public final void a(Object obj, long j4) {
        Object objUnmodifiableList;
        List list = (List) M0.f5656c.k(obj, j4);
        if (list instanceof T) {
            objUnmodifiableList = ((T) list).g();
        } else {
            if (f5683c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof InterfaceC0477n0) && (list instanceof L)) {
                AbstractC0452b abstractC0452b = (AbstractC0452b) ((L) list);
                boolean z6 = abstractC0452b.f5706a;
                if (z6 && z6) {
                    abstractC0452b.f5706a = false;
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        M0.p(obj, j4, objUnmodifiableList);
    }

    @Override // com.google.protobuf.W
    public final void b(Object obj, long j4, Object obj2) {
        List list = (List) M0.f5656c.k(obj2, j4);
        List listD = d(obj, j4, list.size());
        int size = listD.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            listD.addAll(list);
        }
        if (size > 0) {
            list = listD;
        }
        M0.p(obj, j4, list);
    }

    @Override // com.google.protobuf.W
    public final List c(Object obj, long j4) {
        return d(obj, j4, 10);
    }
}
