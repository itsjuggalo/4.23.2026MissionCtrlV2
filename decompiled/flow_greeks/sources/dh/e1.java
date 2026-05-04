package dh;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e1 {
    public static final void a(int i10, int i11, bh.e descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int i12 = (~i10) & i11;
        for (int i13 = 0; i13 < 32; i13++) {
            if ((i12 & 1) != 0) {
                arrayList.add(descriptor.m(i13));
            }
            i12 >>>= 1;
        }
        throw new zg.c(arrayList, descriptor.i());
    }
}
