package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class V extends W {
    @Override // com.google.protobuf.W
    public final void a(Object obj, long j4) {
        AbstractC0452b abstractC0452b = (AbstractC0452b) ((L) M0.f5656c.k(obj, j4));
        if (abstractC0452b.f5706a) {
            abstractC0452b.f5706a = false;
        }
    }

    @Override // com.google.protobuf.W
    public final void b(Object obj, long j4, Object obj2) {
        L0 l02 = M0.f5656c;
        L lD = (L) l02.k(obj, j4);
        L l6 = (L) l02.k(obj2, j4);
        int size = lD.size();
        int size2 = l6.size();
        if (size > 0 && size2 > 0) {
            if (!((AbstractC0452b) lD).f5706a) {
                lD = lD.d(size2 + size);
            }
            lD.addAll(l6);
        }
        if (size > 0) {
            l6 = lD;
        }
        M0.p(obj, j4, l6);
    }

    @Override // com.google.protobuf.W
    public final List c(Object obj, long j4) {
        L l6 = (L) M0.f5656c.k(obj, j4);
        if (((AbstractC0452b) l6).f5706a) {
            return l6;
        }
        int size = l6.size();
        L lD = l6.d(size == 0 ? 10 : size * 2);
        M0.p(obj, j4, lD);
        return lD;
    }
}
