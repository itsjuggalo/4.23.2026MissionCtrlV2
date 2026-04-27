package e3;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class l implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static l f17180a = new l();

    public static l b(Class cls) {
        return f17180a;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }
}
