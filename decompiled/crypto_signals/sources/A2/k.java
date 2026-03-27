package A2;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f57a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f58b;

    public k(int i) {
        int i6 = i + 1;
        int iFloor = (int) Math.floor(Math.log(i6) / Math.log(2.0d));
        this.f58b = iFloor;
        this.f57a = (((long) Math.pow(2.0d, iFloor)) - 1) & ((long) i6);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new a(this);
    }
}
