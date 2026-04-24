package r6;

import java.util.ArrayList;

/* JADX INFO: renamed from: r6.a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2611a0 {
    public static final void a(int i7, int i8, p6.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int i9 = (~i7) & i8;
        for (int i10 = 0; i10 < 32; i10++) {
            if ((i9 & 1) != 0) {
                arrayList.add(descriptor.g(i10));
            }
            i9 >>>= 1;
        }
        throw new n6.c(arrayList, descriptor.a());
    }
}
