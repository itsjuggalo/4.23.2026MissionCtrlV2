package q6;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class v extends k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k f18833e = new v(new Object[0], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object[] f18834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f18835d;

    public v(Object[] objArr, int i10) {
        this.f18834c = objArr;
        this.f18835d = i10;
    }

    @Override // q6.k, q6.j
    public int c(Object[] objArr, int i10) {
        System.arraycopy(this.f18834c, 0, objArr, i10, this.f18835d);
        return i10 + this.f18835d;
    }

    @Override // q6.j
    public Object[] d() {
        return this.f18834c;
    }

    @Override // q6.j
    public int e() {
        return this.f18835d;
    }

    @Override // q6.j
    public int f() {
        return 0;
    }

    @Override // q6.j
    public boolean g() {
        return false;
    }

    @Override // java.util.List
    public Object get(int i10) {
        p6.n.l(i10, this.f18835d);
        Object obj = this.f18834c[i10];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f18835d;
    }
}
