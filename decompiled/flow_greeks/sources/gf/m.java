package gf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class m extends AbstractList implements RandomAccess, n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f10689b = new m().l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f10690a;

    public m() {
        this.f10690a = new ArrayList();
    }

    public static d c(Object obj) {
        return obj instanceof d ? (d) obj : obj instanceof String ? d.g((String) obj) : d.e((byte[]) obj);
    }

    public static String d(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof d ? ((d) obj).L() : j.b((byte[]) obj);
    }

    @Override // gf.n
    public void B(d dVar) {
        this.f10690a.add(dVar);
        ((AbstractList) this).modCount++;
    }

    @Override // gf.n
    public d H(int i10) {
        Object obj = this.f10690a.get(i10);
        d dVarC = c(obj);
        if (dVarC != obj) {
            this.f10690a.set(i10, dVarC);
        }
        return dVarC;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void add(int i10, String str) {
        this.f10690a.add(i10, str);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f10690a.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public String get(int i10) {
        Object obj = this.f10690a.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            String strL = dVar.L();
            if (dVar.u()) {
                this.f10690a.set(i10, strL);
            }
            return strL;
        }
        byte[] bArr = (byte[]) obj;
        String strB = j.b(bArr);
        if (j.a(bArr)) {
            this.f10690a.set(i10, strB);
        }
        return strB;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public String remove(int i10) {
        Object objRemove = this.f10690a.remove(i10);
        ((AbstractList) this).modCount++;
        return d(objRemove);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public String set(int i10, String str) {
        return d(this.f10690a.set(i10, str));
    }

    @Override // gf.n
    public List k() {
        return Collections.unmodifiableList(this.f10690a);
    }

    @Override // gf.n
    public n l() {
        return new w(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f10690a.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i10, Collection collection) {
        if (collection instanceof n) {
            collection = ((n) collection).k();
        }
        boolean zAddAll = this.f10690a.addAll(i10, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    public m(n nVar) {
        this.f10690a = new ArrayList(nVar.size());
        addAll(nVar);
    }
}
