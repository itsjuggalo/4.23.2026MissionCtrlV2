package x6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: x6.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2960a implements Comparable {
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(AbstractC2960a other) {
        AbstractC2304t.f(other, "other");
        int iCompareTo = b().compareTo(other.b());
        if (iCompareTo == 0 && !g() && other.g()) {
            return 1;
        }
        return iCompareTo;
    }

    public abstract EnumC2961b b();

    public abstract boolean g();
}
