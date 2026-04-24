package s6;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: renamed from: s6.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2726m extends AbstractList implements RandomAccess, n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f23187b = new C2726m().l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f23188a;

    public C2726m() {
        this.f23188a = new ArrayList();
    }

    public static AbstractC2717d d(Object obj) {
        return obj instanceof AbstractC2717d ? (AbstractC2717d) obj : obj instanceof String ? AbstractC2717d.n((String) obj) : AbstractC2717d.f((byte[]) obj);
    }

    public static String e(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof AbstractC2717d ? ((AbstractC2717d) obj).Q() : AbstractC2723j.b((byte[]) obj);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void add(int i8, String str) {
        this.f23188a.add(i8, str);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i8, Collection collection) {
        if (collection instanceof n) {
            collection = ((n) collection).k();
        }
        boolean zAddAll = this.f23188a.addAll(i8, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f23188a.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public String get(int i8) {
        Object obj = this.f23188a.get(i8);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof AbstractC2717d) {
            AbstractC2717d abstractC2717d = (AbstractC2717d) obj;
            String strQ = abstractC2717d.Q();
            if (abstractC2717d.J()) {
                this.f23188a.set(i8, strQ);
            }
            return strQ;
        }
        byte[] bArr = (byte[]) obj;
        String strB = AbstractC2723j.b(bArr);
        if (AbstractC2723j.a(bArr)) {
            this.f23188a.set(i8, strB);
        }
        return strB;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public String remove(int i8) {
        Object objRemove = this.f23188a.remove(i8);
        ((AbstractList) this).modCount++;
        return e(objRemove);
    }

    @Override // s6.n
    public List k() {
        return Collections.unmodifiableList(this.f23188a);
    }

    @Override // s6.n
    public n l() {
        return new w(this);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public String set(int i8, String str) {
        return e(this.f23188a.set(i8, str));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f23188a.size();
    }

    @Override // s6.n
    public void t(AbstractC2717d abstractC2717d) {
        this.f23188a.add(abstractC2717d);
        ((AbstractList) this).modCount++;
    }

    @Override // s6.n
    public AbstractC2717d w(int i8) {
        Object obj = this.f23188a.get(i8);
        AbstractC2717d abstractC2717dD = d(obj);
        if (abstractC2717dD != obj) {
            this.f23188a.set(i8, abstractC2717dD);
        }
        return abstractC2717dD;
    }

    public C2726m(n nVar) {
        this.f23188a = new ArrayList(nVar.size());
        addAll(nVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
