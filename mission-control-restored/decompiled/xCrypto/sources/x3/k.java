package x3;

/* JADX INFO: loaded from: classes3.dex */
public interface k extends w3.d {

    public static final class a {
        public static /* synthetic */ w3.d a(k kVar, Z2.i iVar, int i4, v3.a aVar, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
            }
            if ((i5 & 1) != 0) {
                iVar = Z2.j.f6012a;
            }
            if ((i5 & 2) != 0) {
                i4 = -3;
            }
            if ((i5 & 4) != 0) {
                aVar = v3.a.SUSPEND;
            }
            return kVar.b(iVar, i4, aVar);
        }
    }

    w3.d b(Z2.i iVar, int i4, v3.a aVar);
}
