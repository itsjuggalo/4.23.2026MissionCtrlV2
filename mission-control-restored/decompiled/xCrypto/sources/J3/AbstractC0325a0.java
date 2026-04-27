package J3;

import java.util.ArrayList;

/* JADX INFO: renamed from: J3.a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0325a0 {
    public static final void a(int i4, int i5, H3.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int i6 = (~i4) & i5;
        for (int i7 = 0; i7 < 32; i7++) {
            if ((i6 & 1) != 0) {
                arrayList.add(descriptor.g(i7));
            }
            i6 >>>= 1;
        }
        throw new F3.c(arrayList, descriptor.a());
    }
}
