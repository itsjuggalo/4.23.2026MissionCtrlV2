package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class S extends AbstractC0452b implements T, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f5682b;

    static {
        new S();
    }

    public S(ArrayList arrayList) {
        super(true);
        this.f5682b = arrayList;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        a();
        this.f5682b.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractC0452b, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(this.f5682b.size(), collection);
    }

    @Override // com.google.protobuf.AbstractC0452b, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        a();
        this.f5682b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.L
    public final L d(int i) {
        List list = this.f5682b;
        if (i < list.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(list);
        return new S(arrayList);
    }

    @Override // com.google.protobuf.T
    public final void e(AbstractC0472l abstractC0472l) {
        a();
        this.f5682b.add(abstractC0472l);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.T
    public final T g() {
        return this.f5706a ? new H0(this) : this;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        List list = this.f5682b;
        Object obj = list.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof AbstractC0472l) {
            AbstractC0472l abstractC0472l = (AbstractC0472l) obj;
            abstractC0472l.getClass();
            String strV = abstractC0472l.size() == 0 ? "" : abstractC0472l.v(M.f5651a);
            if (abstractC0472l.p()) {
                list.set(i, strV);
            }
            return strV;
        }
        byte[] bArr = (byte[]) obj;
        String str = new String(bArr, M.f5651a);
        y0 y0Var = P0.f5671a;
        if (P0.f5671a.s(bArr, 0, bArr.length)) {
            list.set(i, str);
        }
        return str;
    }

    @Override // com.google.protobuf.T
    public final Object i(int i) {
        return this.f5682b.get(i);
    }

    @Override // com.google.protobuf.T
    public final List j() {
        return Collections.unmodifiableList(this.f5682b);
    }

    @Override // com.google.protobuf.AbstractC0452b, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        a();
        Object objRemove = this.f5682b.remove(i);
        ((AbstractList) this).modCount++;
        if (objRemove instanceof String) {
            return (String) objRemove;
        }
        if (!(objRemove instanceof AbstractC0472l)) {
            return new String((byte[]) objRemove, M.f5651a);
        }
        AbstractC0472l abstractC0472l = (AbstractC0472l) objRemove;
        abstractC0472l.getClass();
        return abstractC0472l.size() == 0 ? "" : abstractC0472l.v(M.f5651a);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        a();
        Object obj2 = this.f5682b.set(i, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (!(obj2 instanceof AbstractC0472l)) {
            return new String((byte[]) obj2, M.f5651a);
        }
        AbstractC0472l abstractC0472l = (AbstractC0472l) obj2;
        abstractC0472l.getClass();
        return abstractC0472l.size() == 0 ? "" : abstractC0472l.v(M.f5651a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f5682b.size();
    }

    public S() {
        super(false);
        this.f5682b = Collections.EMPTY_LIST;
    }

    @Override // com.google.protobuf.AbstractC0452b, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        a();
        if (collection instanceof T) {
            collection = ((T) collection).j();
        }
        boolean zAddAll = this.f5682b.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    public S(int i) {
        this(new ArrayList(i));
    }
}
