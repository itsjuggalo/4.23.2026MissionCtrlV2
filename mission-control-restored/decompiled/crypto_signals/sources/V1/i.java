package V1;

import java.util.Objects;
import s3.D;

/* JADX INFO: loaded from: classes.dex */
public final class i extends e {
    public static final i e = new i(new Object[0], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object[] f3208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f3209d;

    public i(Object[] objArr, int i) {
        this.f3208c = objArr;
        this.f3209d = i;
    }

    @Override // V1.e, V1.a
    public final int b(int i, Object[] objArr) {
        Object[] objArr2 = this.f3208c;
        int i6 = this.f3209d;
        System.arraycopy(objArr2, 0, objArr, i, i6);
        return i + i6;
    }

    @Override // V1.a
    public final Object[] c() {
        return this.f3208c;
    }

    @Override // V1.a
    public final int f() {
        return this.f3209d;
    }

    @Override // java.util.List
    public final Object get(int i) {
        D.i(i, this.f3209d);
        Object obj = this.f3208c[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // V1.a
    public final int h() {
        return 0;
    }

    @Override // V1.a
    public final boolean k() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3209d;
    }
}
