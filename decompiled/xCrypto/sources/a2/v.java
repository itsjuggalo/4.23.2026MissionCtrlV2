package a2;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class v extends k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k f6156e = new v(new Object[0], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object[] f6157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f6158d;

    public v(Object[] objArr, int i4) {
        this.f6157c = objArr;
        this.f6158d = i4;
    }

    @Override // a2.k, a2.j
    public int f(Object[] objArr, int i4) {
        System.arraycopy(this.f6157c, 0, objArr, i4, this.f6158d);
        return i4 + this.f6158d;
    }

    @Override // java.util.List
    public Object get(int i4) {
        Z1.m.l(i4, this.f6158d);
        Object obj = this.f6157c[i4];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // a2.j
    public Object[] i() {
        return this.f6157c;
    }

    @Override // a2.j
    public int k() {
        return this.f6158d;
    }

    @Override // a2.j
    public int l() {
        return 0;
    }

    @Override // a2.j
    public boolean m() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f6158d;
    }
}
