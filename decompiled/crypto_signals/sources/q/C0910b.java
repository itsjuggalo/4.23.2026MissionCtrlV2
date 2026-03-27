package q;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: q.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0910b extends k implements Map {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public C0909a f9106l;

    public C0910b() {
    }

    @Override // java.util.Map
    public final Set entrySet() {
        if (this.f9106l == null) {
            this.f9106l = new C0909a(this, 0);
        }
        C0909a c0909a = this.f9106l;
        if (c0909a.f9102a == null) {
            c0909a.f9102a = new C0916h(c0909a, 0);
        }
        return c0909a.f9102a;
    }

    @Override // java.util.Map
    public final Set keySet() {
        if (this.f9106l == null) {
            this.f9106l = new C0909a(this, 0);
        }
        C0909a c0909a = this.f9106l;
        if (c0909a.f9103b == null) {
            c0909a.f9103b = new C0916h(c0909a, 1);
        }
        return c0909a.f9103b;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        int size = map.size() + this.f9138c;
        int i = this.f9138c;
        int[] iArr = this.f9136a;
        if (iArr.length < size) {
            Object[] objArr = this.f9137b;
            a(size);
            if (this.f9138c > 0) {
                System.arraycopy(iArr, 0, this.f9136a, 0, i);
                System.arraycopy(objArr, 0, this.f9137b, 0, i << 1);
            }
            k.c(iArr, objArr, i);
        }
        if (this.f9138c != i) {
            throw new ConcurrentModificationException();
        }
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        if (this.f9106l == null) {
            this.f9106l = new C0909a(this, 0);
        }
        C0909a c0909a = this.f9106l;
        if (c0909a.f9104c == null) {
            c0909a.f9104c = new C0918j(c0909a);
        }
        return c0909a.f9104c;
    }

    public C0910b(int i) {
        if (i == 0) {
            this.f9136a = AbstractC0912d.f9116a;
            this.f9137b = AbstractC0912d.f9117b;
        } else {
            a(i);
        }
        this.f9138c = 0;
    }
}
