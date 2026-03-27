package o7;

import java.util.ArrayList;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: o7.f0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2504f0 {
    public static final void a(int i8, int i9, m7.e descriptor) {
        AbstractC2304t.f(descriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int i10 = (~i8) & i9;
        for (int i11 = 0; i11 < 32; i11++) {
            if ((i10 & 1) != 0) {
                arrayList.add(descriptor.f(i11));
            }
            i10 >>>= 1;
        }
        throw new k7.c(arrayList, descriptor.a());
    }
}
