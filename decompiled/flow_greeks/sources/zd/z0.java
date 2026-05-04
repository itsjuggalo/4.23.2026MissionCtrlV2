package zd;

import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public class z0 implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pd.o f25906a;

    public z0(pd.o oVar) {
        this.f25906a = oVar;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return c1.D(this.f25906a, obj, obj2);
    }
}
