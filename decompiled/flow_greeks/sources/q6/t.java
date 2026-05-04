package q6;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class t implements Comparator {
    public static t a(Comparator comparator) {
        return comparator instanceof t ? (t) comparator : new f(comparator);
    }

    public t b(p6.f fVar) {
        return new c(fVar, this);
    }

    @Override // java.util.Comparator
    public abstract int compare(Object obj, Object obj2);
}
