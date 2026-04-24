package w2;

import java.util.Comparator;
import v2.InterfaceC2840f;

/* JADX INFO: loaded from: classes.dex */
public abstract class t implements Comparator {
    public static t a(Comparator comparator) {
        return comparator instanceof t ? (t) comparator : new C2917f(comparator);
    }

    public t b(InterfaceC2840f interfaceC2840f) {
        return new C2914c(interfaceC2840f, this);
    }

    @Override // java.util.Comparator
    public abstract int compare(Object obj, Object obj2);
}
