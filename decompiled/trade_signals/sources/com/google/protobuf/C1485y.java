package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.google.protobuf.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1485y extends AbstractC1464c implements InterfaceC1486z, RandomAccess {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C1485y f16610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final InterfaceC1486z f16611d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f16612b;

    static {
        C1485y c1485y = new C1485y(false);
        f16610c = c1485y;
        f16611d = c1485y;
    }

    public C1485y(int i8) {
        this(new ArrayList(i8));
    }

    public static String e(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof AbstractC1467f ? ((AbstractC1467f) obj).Q() : AbstractC1481u.i((byte[]) obj);
    }

    @Override // com.google.protobuf.InterfaceC1486z
    public Object B(int i8) {
        return this.f16612b.get(i8);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public String set(int i8, String str) {
        a();
        return e(this.f16612b.set(i8, str));
    }

    @Override // com.google.protobuf.AbstractC1464c, java.util.AbstractList, java.util.List
    public boolean addAll(int i8, Collection collection) {
        a();
        if (collection instanceof InterfaceC1486z) {
            collection = ((InterfaceC1486z) collection).k();
        }
        boolean zAddAll = this.f16612b.addAll(i8, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.protobuf.AbstractC1464c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        a();
        this.f16612b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void add(int i8, String str) {
        a();
        this.f16612b.add(i8, str);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractC1464c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public String get(int i8) {
        Object obj = this.f16612b.get(i8);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof AbstractC1467f) {
            AbstractC1467f abstractC1467f = (AbstractC1467f) obj;
            String strQ = abstractC1467f.Q();
            if (abstractC1467f.H()) {
                this.f16612b.set(i8, strQ);
            }
            return strQ;
        }
        byte[] bArr = (byte[]) obj;
        String strI = AbstractC1481u.i(bArr);
        if (AbstractC1481u.g(bArr)) {
            this.f16612b.set(i8, strI);
        }
        return strI;
    }

    @Override // com.google.protobuf.AbstractC1481u.d
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public C1485y i(int i8) {
        if (i8 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i8);
        arrayList.addAll(this.f16612b);
        return new C1485y(arrayList);
    }

    @Override // com.google.protobuf.AbstractC1464c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.protobuf.InterfaceC1486z
    public List k() {
        return Collections.unmodifiableList(this.f16612b);
    }

    @Override // com.google.protobuf.InterfaceC1486z
    public InterfaceC1486z l() {
        return m() ? new i0(this) : this;
    }

    @Override // com.google.protobuf.AbstractC1464c, com.google.protobuf.AbstractC1481u.d
    public /* bridge */ /* synthetic */ boolean m() {
        return super.m();
    }

    @Override // com.google.protobuf.AbstractC1464c, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public String remove(int i8) {
        a();
        Object objRemove = this.f16612b.remove(i8);
        ((AbstractList) this).modCount++;
        return e(objRemove);
    }

    @Override // com.google.protobuf.InterfaceC1486z
    public void q(AbstractC1467f abstractC1467f) {
        a();
        this.f16612b.add(abstractC1467f);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractC1464c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.protobuf.AbstractC1464c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f16612b.size();
    }

    public C1485y(ArrayList arrayList) {
        this.f16612b = arrayList;
    }

    @Override // com.google.protobuf.AbstractC1464c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Override // com.google.protobuf.AbstractC1464c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.protobuf.AbstractC1464c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public C1485y(boolean z7) {
        super(z7);
        this.f16612b = Collections.emptyList();
    }
}
