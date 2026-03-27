package v3;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g {
    public static final d a(int i4, a aVar, i3.k kVar) {
        if (i4 == -2) {
            return aVar == a.SUSPEND ? new b(d.f15360N.a(), kVar) : new p(1, aVar, kVar);
        }
        if (i4 != -1) {
            return i4 != 0 ? i4 != Integer.MAX_VALUE ? aVar == a.SUSPEND ? new b(i4, kVar) : new p(i4, aVar, kVar) : new b(Integer.MAX_VALUE, kVar) : aVar == a.SUSPEND ? new b(0, kVar) : new p(1, aVar, kVar);
        }
        if (aVar == a.SUSPEND) {
            return new p(1, a.DROP_OLDEST, kVar);
        }
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
    }

    public static /* synthetic */ d b(int i4, a aVar, i3.k kVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = 0;
        }
        if ((i5 & 2) != 0) {
            aVar = a.SUSPEND;
        }
        if ((i5 & 4) != 0) {
            kVar = null;
        }
        return a(i4, aVar, kVar);
    }
}
