package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public class I extends AbstractC1233c implements J, RandomAccess {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final I f12580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final J f12581d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f12582b;

    static {
        I i7 = new I(false);
        f12580c = i7;
        f12581d = i7;
    }

    public I(boolean z7) {
        super(z7);
        this.f12582b = Collections.emptyList();
    }

    public static String c(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof AbstractC1240i ? ((AbstractC1240i) obj).J() : C.i((byte[]) obj);
    }

    @Override // com.google.protobuf.AbstractC1233c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void add(int i7, String str) {
        a();
        this.f12582b.add(i7, str);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractC1233c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        a();
        this.f12582b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractC1233c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.protobuf.AbstractC1233c, com.google.protobuf.C.e
    public /* bridge */ /* synthetic */ boolean f() {
        return super.f();
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public String get(int i7) {
        Object obj = this.f12582b.get(i7);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof AbstractC1240i) {
            AbstractC1240i abstractC1240i = (AbstractC1240i) obj;
            String strJ = abstractC1240i.J();
            if (abstractC1240i.w()) {
                this.f12582b.set(i7, strJ);
            }
            return strJ;
        }
        byte[] bArr = (byte[]) obj;
        String strI = C.i(bArr);
        if (C.g(bArr)) {
            this.f12582b.set(i7, strI);
        }
        return strI;
    }

    @Override // com.google.protobuf.C.e
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public I e(int i7) {
        if (i7 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i7);
        arrayList.addAll(this.f12582b);
        return new I(arrayList);
    }

    @Override // com.google.protobuf.AbstractC1233c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.protobuf.J
    public void i(AbstractC1240i abstractC1240i) {
        a();
        this.f12582b.add(abstractC1240i);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractC1233c, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public String remove(int i7) {
        a();
        Object objRemove = this.f12582b.remove(i7);
        ((AbstractList) this).modCount++;
        return c(objRemove);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public String set(int i7, String str) {
        a();
        return c(this.f12582b.set(i7, str));
    }

    @Override // com.google.protobuf.J
    public List o() {
        return Collections.unmodifiableList(this.f12582b);
    }

    @Override // com.google.protobuf.AbstractC1233c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.protobuf.AbstractC1233c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f12582b.size();
    }

    @Override // com.google.protobuf.J
    public J v() {
        return f() ? new y0(this) : this;
    }

    @Override // com.google.protobuf.J
    public Object z(int i7) {
        return this.f12582b.get(i7);
    }

    @Override // com.google.protobuf.AbstractC1233c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Override // com.google.protobuf.AbstractC1233c, java.util.AbstractList, java.util.List
    public boolean addAll(int i7, Collection collection) {
        a();
        if (collection instanceof J) {
            collection = ((J) collection).o();
        }
        boolean zAddAll = this.f12582b.addAll(i7, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.protobuf.AbstractC1233c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public I(int i7) {
        this(new ArrayList(i7));
    }

    public I(ArrayList arrayList) {
        this.f12582b = arrayList;
    }
}
