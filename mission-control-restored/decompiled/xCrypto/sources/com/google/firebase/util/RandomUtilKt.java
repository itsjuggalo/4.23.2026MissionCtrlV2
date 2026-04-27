package com.google.firebase.util;

import X2.AbstractC0770q;
import X2.G;
import X2.x;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.r;
import m3.AbstractC1608c;
import o3.AbstractC1681l;
import o3.C1676g;
import r3.C;

/* JADX INFO: loaded from: classes.dex */
public final class RandomUtilKt {
    private static final String ALPHANUMERIC_ALPHABET = "23456789abcdefghjkmnpqrstvwxyz";

    private static /* synthetic */ void getALPHANUMERIC_ALPHABET$annotations() {
    }

    public static final String nextAlphanumericString(AbstractC1608c abstractC1608c, int i4) {
        r.f(abstractC1608c, "<this>");
        if (i4 < 0) {
            throw new IllegalArgumentException(("invalid length: " + i4).toString());
        }
        C1676g c1676gL = AbstractC1681l.l(0, i4);
        ArrayList arrayList = new ArrayList(AbstractC0770q.q(c1676gL, 10));
        Iterator it = c1676gL.iterator();
        while (it.hasNext()) {
            ((G) it).b();
            arrayList.add(Character.valueOf(C.K0(ALPHANUMERIC_ALPHABET, abstractC1608c)));
        }
        return x.Q(arrayList, "", null, null, 0, null, null, 62, null);
    }
}
