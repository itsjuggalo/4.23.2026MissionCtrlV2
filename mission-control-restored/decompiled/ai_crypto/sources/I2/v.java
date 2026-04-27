package I2;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class v extends k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k f2985e = new v(new Object[0], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object[] f2986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f2987d;

    public v(Object[] objArr, int i7) {
        this.f2986c = objArr;
        this.f2987d = i7;
    }

    @Override // I2.k, I2.j
    public int b(Object[] objArr, int i7) {
        System.arraycopy(this.f2986c, 0, objArr, i7, this.f2987d);
        return i7 + this.f2987d;
    }

    @Override // I2.j
    public Object[] c() {
        return this.f2986c;
    }

    @Override // I2.j
    public int g() {
        return this.f2987d;
    }

    @Override // java.util.List
    public Object get(int i7) {
        H2.m.l(i7, this.f2987d);
        Object obj = this.f2986c[i7];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // I2.j
    public int h() {
        return 0;
    }

    @Override // I2.j
    public boolean j() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f2987d;
    }
}
