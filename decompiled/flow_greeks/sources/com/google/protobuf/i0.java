package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class i0 extends c implements j0, RandomAccess {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i0 f7010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j0 f7011d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f7012b;

    static {
        i0 i0Var = new i0(false);
        f7010c = i0Var;
        f7011d = i0Var;
    }

    public i0(boolean z10) {
        super(z10);
        this.f7012b = Collections.EMPTY_LIST;
    }

    public static String d(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof i ? ((i) obj).c0() : c0.i((byte[]) obj);
    }

    @Override // com.google.protobuf.j0
    public Object M(int i10) {
        return this.f7012b.get(i10);
    }

    @Override // com.google.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void add(int i10, String str) {
        a();
        this.f7012b.add(i10, str);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        a();
        this.f7012b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public String get(int i10) {
        Object obj = this.f7012b.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            String strC0 = iVar.c0();
            if (iVar.K()) {
                this.f7012b.set(i10, strC0);
            }
            return strC0;
        }
        byte[] bArr = (byte[]) obj;
        String strI = c0.i(bArr);
        if (c0.g(bArr)) {
            this.f7012b.set(i10, strI);
        }
        return strI;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.protobuf.c0.e
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public i0 i(int i10) {
        if (i10 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i10);
        arrayList.addAll(this.f7012b);
        return new i0(arrayList);
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public String remove(int i10) {
        a();
        Object objRemove = this.f7012b.remove(i10);
        ((AbstractList) this).modCount++;
        return d(objRemove);
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.protobuf.j0
    public List k() {
        return Collections.unmodifiableList(this.f7012b);
    }

    @Override // com.google.protobuf.j0
    public j0 l() {
        return m() ? new x1(this) : this;
    }

    @Override // com.google.protobuf.c, com.google.protobuf.c0.e
    public /* bridge */ /* synthetic */ boolean m() {
        return super.m();
    }

    @Override // com.google.protobuf.j0
    public void o(i iVar) {
        a();
        this.f7012b.add(iVar);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public String set(int i10, String str) {
        a();
        return d(this.f7012b.set(i10, str));
    }

    @Override // com.google.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f7012b.size();
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.List
    public boolean addAll(int i10, Collection collection) {
        a();
        if (collection instanceof j0) {
            collection = ((j0) collection).k();
        }
        boolean zAddAll = this.f7012b.addAll(i10, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public i0(int i10) {
        this(new ArrayList(i10));
    }

    public i0(ArrayList arrayList) {
        this.f7012b = arrayList;
    }
}
