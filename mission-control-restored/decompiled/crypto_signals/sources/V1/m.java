package V1;

import java.util.Objects;
import s3.D;

/* JADX INFO: loaded from: classes.dex */
public final class m extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object[] f3214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f3215d;
    public final transient int e;

    public m(Object[] objArr, int i, int i6) {
        this.f3214c = objArr;
        this.f3215d = i;
        this.e = i6;
    }

    @Override // java.util.List
    public final Object get(int i) {
        D.i(i, this.e);
        Object obj = this.f3214c[(i * 2) + this.f3215d];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // V1.a
    public final boolean k() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.e;
    }
}
