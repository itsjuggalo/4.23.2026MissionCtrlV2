package a2;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public abstract class t implements Comparator {
    public static t a(Comparator comparator) {
        return comparator instanceof t ? (t) comparator : new f(comparator);
    }

    public t b(Z1.e eVar) {
        return new C0784c(eVar, this);
    }

    @Override // java.util.Comparator
    public abstract int compare(Object obj, Object obj2);
}
