package n6;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class v extends t {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object[] f16676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final v f16677f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object[] f16678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient Object[] f16679d;

    static {
        Object[] objArr = new Object[0];
        f16676e = objArr;
        f16677f = new v(objArr, 0, objArr, 0, 0);
    }

    public v(Object[] objArr, int i10, Object[] objArr2, int i11, int i12) {
        this.f16678c = objArr;
        this.f16679d = objArr2;
    }

    @Override // n6.p
    public final int a(Object[] objArr, int i10) {
        System.arraycopy(this.f16678c, 0, objArr, 0, 0);
        return 0;
    }

    @Override // n6.p
    public final int c() {
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        int length = this.f16679d.length;
        return false;
    }

    @Override // n6.p
    public final int d() {
        return 0;
    }

    @Override // n6.p
    public final Object[] e() {
        return this.f16678c;
    }

    @Override // n6.t
    public final s g() {
        x xVar = s.f16672b;
        return u.f16674d;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return f().listIterator(0);
    }

    @Override // n6.t
    public final boolean q() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 0;
    }
}
