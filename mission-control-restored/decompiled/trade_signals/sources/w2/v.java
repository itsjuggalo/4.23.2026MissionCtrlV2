package w2;

import java.util.Objects;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes.dex */
public class v extends k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k f24033e = new v(new Object[0], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object[] f24034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f24035d;

    public v(Object[] objArr, int i8) {
        this.f24034c = objArr;
        this.f24035d = i8;
    }

    @Override // w2.k, w2.AbstractC2921j
    public int d(Object[] objArr, int i8) {
        System.arraycopy(this.f24034c, 0, objArr, i8, this.f24035d);
        return i8 + this.f24035d;
    }

    @Override // w2.AbstractC2921j
    public Object[] e() {
        return this.f24034c;
    }

    @Override // w2.AbstractC2921j
    public int f() {
        return this.f24035d;
    }

    @Override // java.util.List
    public Object get(int i8) {
        AbstractC2848n.l(i8, this.f24035d);
        Object obj = this.f24034c[i8];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // w2.AbstractC2921j
    public int h() {
        return 0;
    }

    @Override // w2.AbstractC2921j
    public boolean n() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f24035d;
    }
}
