package c7;

import s5.C2712j;
import s5.InterfaceC2711i;

/* JADX INFO: loaded from: classes2.dex */
public interface k extends b7.d {

    public static final class a {
        public static /* synthetic */ b7.d a(k kVar, InterfaceC2711i interfaceC2711i, int i8, a7.a aVar, int i9, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
            }
            if ((i9 & 1) != 0) {
                interfaceC2711i = C2712j.f23116a;
            }
            if ((i9 & 2) != 0) {
                i8 = -3;
            }
            if ((i9 & 4) != 0) {
                aVar = a7.a.f10173a;
            }
            return kVar.a(interfaceC2711i, i8, aVar);
        }
    }

    b7.d a(InterfaceC2711i interfaceC2711i, int i8, a7.a aVar);
}
