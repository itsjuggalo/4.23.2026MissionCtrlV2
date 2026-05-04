package mf;

import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements Comparable {
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a other) {
        t.f(other, "other");
        int iCompareTo = b().compareTo(other.b());
        if (iCompareTo == 0 && !c() && other.c()) {
            return 1;
        }
        return iCompareTo;
    }

    public abstract b b();

    public abstract boolean c();
}
