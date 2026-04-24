package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public class J extends AbstractC1054c implements K, RandomAccess {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final J f10952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final K f10953d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f10954b;

    static {
        J j4 = new J(false);
        f10952c = j4;
        f10953d = j4;
    }

    public J(boolean z4) {
        super(z4);
        this.f10954b = Collections.EMPTY_LIST;
    }

    public static String i(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof AbstractC1062i ? ((AbstractC1062i) obj).K() : C.j((byte[]) obj);
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.protobuf.K
    public void b(AbstractC1062i abstractC1062i) {
        c();
        this.f10954b.add(abstractC1062i);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        c();
        this.f10954b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractC1054c, com.google.protobuf.C.i
    public /* bridge */ /* synthetic */ boolean e() {
        return super.e();
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void add(int i4, String str) {
        c();
        this.f10954b.add(i4, str);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.K
    public List g() {
        return Collections.unmodifiableList(this.f10954b);
    }

    @Override // com.google.protobuf.K
    public K h() {
        return e() ? new z0(this) : this;
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.protobuf.K
    public Object j(int i4) {
        return this.f10954b.get(i4);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public String get(int i4) {
        Object obj = this.f10954b.get(i4);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof AbstractC1062i) {
            AbstractC1062i abstractC1062i = (AbstractC1062i) obj;
            String strK = abstractC1062i.K();
            if (abstractC1062i.x()) {
                this.f10954b.set(i4, strK);
            }
            return strK;
        }
        byte[] bArr = (byte[]) obj;
        String strJ = C.j(bArr);
        if (C.g(bArr)) {
            this.f10954b.set(i4, strJ);
        }
        return strJ;
    }

    @Override // com.google.protobuf.C.i, com.google.protobuf.C.g
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public J a(int i4) {
        if (i4 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i4);
        arrayList.addAll(this.f10954b);
        return new J(arrayList);
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public String remove(int i4) {
        c();
        Object objRemove = this.f10954b.remove(i4);
        ((AbstractList) this).modCount++;
        return i(objRemove);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public String set(int i4, String str) {
        c();
        return i(this.f10954b.set(i4, str));
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f10954b.size();
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractList, java.util.List
    public boolean addAll(int i4, Collection collection) {
        c();
        if (collection instanceof K) {
            collection = ((K) collection).g();
        }
        boolean zAddAll = this.f10954b.addAll(i4, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public J(int i4) {
        this(new ArrayList(i4));
    }

    public J(ArrayList arrayList) {
        this.f10954b = arrayList;
    }
}
