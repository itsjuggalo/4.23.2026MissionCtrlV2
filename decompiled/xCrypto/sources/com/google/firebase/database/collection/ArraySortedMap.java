package com.google.firebase.database.collection;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.LLRBNode;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ArraySortedMap<K, V> extends ImmutableSortedMap<K, V> {
    private final Comparator<K> comparator;
    private final K[] keys;
    private final V[] values;

    public ArraySortedMap(Comparator<K> comparator) {
        this.keys = (K[]) new Object[0];
        this.values = (V[]) new Object[0];
        this.comparator = comparator;
    }

    private static <T> T[] addToArray(T[] tArr, int i4, T t4) {
        T[] tArr2 = (T[]) new Object[tArr.length + 1];
        System.arraycopy(tArr, 0, tArr2, 0, i4);
        tArr2[i4] = t4;
        System.arraycopy(tArr, i4, tArr2, i4 + 1, (r0 - i4) - 1);
        return tArr2;
    }

    public static <A, B, C> ArraySortedMap<A, C> buildFrom(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator, Comparator<A> comparator) {
        Collections.sort(list, comparator);
        int size = list.size();
        Object[] objArr = new Object[size];
        Object[] objArr2 = new Object[size];
        int i4 = 0;
        for (A a4 : list) {
            objArr[i4] = a4;
            objArr2[i4] = map.get(keyTranslator.translate(a4));
            i4++;
        }
        return new ArraySortedMap<>(comparator, objArr, objArr2);
    }

    private int findKey(K k4) {
        int i4 = 0;
        for (K k5 : this.keys) {
            if (this.comparator.compare(k4, k5) == 0) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    private int findKeyOrInsertPosition(K k4) {
        int i4 = 0;
        while (true) {
            K[] kArr = this.keys;
            if (i4 >= kArr.length || this.comparator.compare(kArr[i4], k4) >= 0) {
                break;
            }
            i4++;
        }
        return i4;
    }

    public static <K, V> ArraySortedMap<K, V> fromMap(Map<K, V> map, Comparator<K> comparator) {
        return buildFrom(new ArrayList(map.keySet()), map, ImmutableSortedMap.Builder.identityTranslator(), comparator);
    }

    private Iterator<Map.Entry<K, V>> iterator(int i4, boolean z4) {
        return new Iterator<Map.Entry<K, V>>(i4, z4) { // from class: com.google.firebase.database.collection.ArraySortedMap.1
            int currentPos;
            final /* synthetic */ int val$pos;
            final /* synthetic */ boolean val$reverse;

            {
                this.val$pos = i4;
                this.val$reverse = z4;
                this.currentPos = i4;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.val$reverse ? this.currentPos >= 0 : this.currentPos < ArraySortedMap.this.keys.length;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Can't remove elements from ImmutableSortedMap");
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                Object obj = ArraySortedMap.this.keys[this.currentPos];
                Object[] objArr = ArraySortedMap.this.values;
                int i5 = this.currentPos;
                Object obj2 = objArr[i5];
                this.currentPos = this.val$reverse ? i5 - 1 : i5 + 1;
                return new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
        };
    }

    private static <T> T[] removeFromArray(T[] tArr, int i4) {
        int length = tArr.length - 1;
        T[] tArr2 = (T[]) new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, i4);
        System.arraycopy(tArr, i4 + 1, tArr2, i4, length - i4);
        return tArr2;
    }

    private static <T> T[] replaceInArray(T[] tArr, int i4, T t4) {
        int length = tArr.length;
        T[] tArr2 = (T[]) new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, length);
        tArr2[i4] = t4;
        return tArr2;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public boolean containsKey(K k4) {
        return findKey(k4) != -1;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public V get(K k4) {
        int iFindKey = findKey(k4);
        if (iFindKey != -1) {
            return this.values[iFindKey];
        }
        return null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Comparator<K> getComparator() {
        return this.comparator;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getMaxKey() {
        K[] kArr = this.keys;
        if (kArr.length > 0) {
            return kArr[kArr.length - 1];
        }
        return null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getMinKey() {
        K[] kArr = this.keys;
        if (kArr.length > 0) {
            return kArr[0];
        }
        return null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getPredecessorKey(K k4) {
        int iFindKey = findKey(k4);
        if (iFindKey == -1) {
            throw new IllegalArgumentException("Can't find predecessor of nonexistent key");
        }
        if (iFindKey > 0) {
            return this.keys[iFindKey - 1];
        }
        return null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getSuccessorKey(K k4) {
        int iFindKey = findKey(k4);
        if (iFindKey == -1) {
            throw new IllegalArgumentException("Can't find successor of nonexistent key");
        }
        K[] kArr = this.keys;
        if (iFindKey < kArr.length - 1) {
            return kArr[iFindKey + 1];
        }
        return null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public void inOrderTraversal(LLRBNode.NodeVisitor<K, V> nodeVisitor) {
        int i4 = 0;
        while (true) {
            K[] kArr = this.keys;
            if (i4 >= kArr.length) {
                return;
            }
            nodeVisitor.visitEntry(kArr[i4], this.values[i4]);
            i4++;
        }
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public int indexOf(K k4) {
        return findKey(k4);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public ImmutableSortedMap<K, V> insert(K k4, V v4) {
        int iFindKey = findKey(k4);
        if (iFindKey != -1) {
            K[] kArr = this.keys;
            if (kArr[iFindKey] == k4 && this.values[iFindKey] == v4) {
                return this;
            }
            return new ArraySortedMap(this.comparator, replaceInArray(kArr, iFindKey, k4), replaceInArray(this.values, iFindKey, v4));
        }
        if (this.keys.length <= 25) {
            int iFindKeyOrInsertPosition = findKeyOrInsertPosition(k4);
            return new ArraySortedMap(this.comparator, addToArray(this.keys, iFindKeyOrInsertPosition, k4), addToArray(this.values, iFindKeyOrInsertPosition, v4));
        }
        HashMap map = new HashMap(this.keys.length + 1);
        int i4 = 0;
        while (true) {
            K[] kArr2 = this.keys;
            if (i4 >= kArr2.length) {
                map.put(k4, v4);
                return RBTreeSortedMap.fromMap(map, this.comparator);
            }
            map.put(kArr2[i4], this.values[i4]);
            i4++;
        }
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public boolean isEmpty() {
        return this.keys.length == 0;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Iterator<Map.Entry<K, V>> iteratorFrom(K k4) {
        return iterator(findKeyOrInsertPosition(k4), false);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public ImmutableSortedMap<K, V> remove(K k4) {
        int iFindKey = findKey(k4);
        if (iFindKey == -1) {
            return this;
        }
        return new ArraySortedMap(this.comparator, removeFromArray(this.keys, iFindKey), removeFromArray(this.values, iFindKey));
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Iterator<Map.Entry<K, V>> reverseIterator() {
        return iterator(this.keys.length - 1, true);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Iterator<Map.Entry<K, V>> reverseIteratorFrom(K k4) {
        int iFindKeyOrInsertPosition = findKeyOrInsertPosition(k4);
        K[] kArr = this.keys;
        return (iFindKeyOrInsertPosition >= kArr.length || this.comparator.compare(kArr[iFindKeyOrInsertPosition], k4) != 0) ? iterator(iFindKeyOrInsertPosition - 1, true) : iterator(iFindKeyOrInsertPosition, true);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public int size() {
        return this.keys.length;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return iterator(0, false);
    }

    private ArraySortedMap(Comparator<K> comparator, K[] kArr, V[] vArr) {
        this.keys = kArr;
        this.values = vArr;
        this.comparator = comparator;
    }
}
