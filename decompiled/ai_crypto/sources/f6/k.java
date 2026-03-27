package f6;

/* JADX INFO: loaded from: classes2.dex */
public interface k extends e6.d {

    public static final class a {
        public static /* synthetic */ e6.d a(k kVar, H5.g gVar, int i7, d6.a aVar, int i8, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
            }
            if ((i8 & 1) != 0) {
                gVar = H5.h.f2671a;
            }
            if ((i8 & 2) != 0) {
                i7 = -3;
            }
            if ((i8 & 4) != 0) {
                aVar = d6.a.SUSPEND;
            }
            return kVar.c(gVar, i7, aVar);
        }
    }

    e6.d c(H5.g gVar, int i7, d6.a aVar);
}
