package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.a1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1308a1 implements InterfaceC1334f2 {
    protected int zza = 0;

    public static void d(Iterable iterable, List list) {
        Charset charset = P1.f15203a;
        int size = ((Collection) iterable).size();
        if (list instanceof ArrayList) {
            ((ArrayList) list).ensureCapacity(list.size() + size);
        } else if (list instanceof C1374n2) {
            ((C1374n2) list).e(list.size() + size);
        }
        int size2 = list.size();
        List list2 = (List) iterable;
        int size3 = list2.size();
        for (int i8 = 0; i8 < size3; i8++) {
            Object obj = list2.get(i8);
            if (obj == null) {
                String str = "Element at index " + (list.size() - size2) + " is null.";
                int size4 = list.size();
                while (true) {
                    size4--;
                    if (size4 < size2) {
                        throw new NullPointerException(str);
                    }
                    list.remove(size4);
                }
            } else {
                list.add(obj);
            }
        }
    }

    public final byte[] a() {
        try {
            int iZzj = zzj();
            byte[] bArr = new byte[iZzj];
            Logger logger = AbstractC1412v1.f15525b;
            C1397s1 c1397s1 = new C1397s1(bArr, 0, iZzj);
            b(c1397s1);
            c1397s1.e();
            return bArr;
        } catch (IOException e8) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e8);
        }
    }

    public abstract int c(InterfaceC1384p2 interfaceC1384p2);
}
