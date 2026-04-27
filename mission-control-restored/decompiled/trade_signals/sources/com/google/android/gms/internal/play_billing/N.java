package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public abstract class N extends K implements List, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC1327e0 f15185b = new L(W.f15368e, 0);

    public static N F(Object[] objArr, int i8) {
        return i8 == 0 ? W.f15368e : new W(objArr, i8);
    }

    public static N H(Collection collection) {
        if (!(collection instanceof K)) {
            Object[] array = collection.toArray();
            int length = array.length;
            U.a(array, length);
            return F(array, length);
        }
        N nF = ((K) collection).f();
        if (!nF.h()) {
            return nF;
        }
        Object[] array2 = nF.toArray();
        return F(array2, array2.length);
    }

    public static N I() {
        return W.f15368e;
    }

    public static N J(Object obj) {
        Object[] objArr = {"inapp"};
        U.a(objArr, 1);
        return F(objArr, 1);
    }

    public static N K(Object obj, Object obj2) {
        Object[] objArr = {"subs", "inapp"};
        U.a(objArr, 2);
        return F(objArr, 2);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public N subList(int i8, int i9) {
        A.d(i8, i9, size());
        int i10 = i9 - i8;
        return i10 == size() ? this : i10 == 0 ? W.f15368e : new M(this, i8, i10);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public final AbstractC1327e0 listIterator(int i8) {
        A.b(i8, size(), FirebaseAnalytics.Param.INDEX);
        return isEmpty() ? f15185b : new L(this, i8);
    }

    @Override // com.google.android.gms.internal.play_billing.K
    public int a(Object[] objArr, int i8) {
        int size = size();
        for (int i9 = 0; i9 < size; i9++) {
            objArr[i9] = get(i9);
        }
        return size;
    }

    @Override // java.util.List
    public final void add(int i8, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i8, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.play_billing.K, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i8 = 0; i8 < size; i8++) {
                        if (AbstractC1426z.a(get(i8), list.get(i8))) {
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!it2.hasNext() || !AbstractC1426z.a(it.next(), it2.next())) {
                            break;
                        }
                    } else if (!it2.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.K
    public final N f() {
        return this;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i8 = 0; i8 < size; i8++) {
            iHashCode = (iHashCode * 31) + get(i8).hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            if (obj.equals(get(i8))) {
                return i8;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final Object remove(int i8) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int i8, Object obj) {
        throw new UnsupportedOperationException();
    }
}
