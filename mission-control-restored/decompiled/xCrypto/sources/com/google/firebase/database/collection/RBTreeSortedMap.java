package com.google.firebase.database.collection;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.LLRBNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class RBTreeSortedMap<K, V> extends ImmutableSortedMap<K, V> {
    private Comparator<K> comparator;
    private LLRBNode<K, V> root;

    public static class Builder<A, B, C> {
        private final ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator;
        private final List<A> keys;
        private LLRBValueNode<A, C> leaf;
        private LLRBValueNode<A, C> root;
        private final Map<B, C> values;

        public static class Base1_2 implements Iterable<BooleanChunk> {
            private final int length;
            private long value;

            public Base1_2(int i4) {
                int i5 = i4 + 1;
                int iFloor = (int) Math.floor(Math.log(i5) / Math.log(2.0d));
                this.length = iFloor;
                this.value = (((long) Math.pow(2.0d, iFloor)) - 1) & ((long) i5);
            }

            @Override // java.lang.Iterable
            public Iterator<BooleanChunk> iterator() {
                return new Iterator<BooleanChunk>() { // from class: com.google.firebase.database.collection.RBTreeSortedMap.Builder.Base1_2.1
                    private int current;

                    {
                        this.current = Base1_2.this.length - 1;
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.current >= 0;
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.Iterator
                    public BooleanChunk next() {
                        long j4 = Base1_2.this.value & ((long) (1 << this.current));
                        BooleanChunk booleanChunk = new BooleanChunk();
                        booleanChunk.isOne = j4 == 0;
                        booleanChunk.chunkSize = (int) Math.pow(2.0d, this.current);
                        this.current--;
                        return booleanChunk;
                    }
                };
            }
        }

        public static class BooleanChunk {
            public int chunkSize;
            public boolean isOne;
        }

        private Builder(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator) {
            this.keys = list;
            this.values = map;
            this.keyTranslator = keyTranslator;
        }

        private LLRBNode<A, C> buildBalancedTree(int i4, int i5) {
            if (i5 == 0) {
                return LLRBEmptyNode.getInstance();
            }
            if (i5 == 1) {
                A a4 = this.keys.get(i4);
                return new LLRBBlackValueNode(a4, getValue(a4), null, null);
            }
            int i6 = i5 / 2;
            int i7 = i4 + i6;
            LLRBNode<A, C> lLRBNodeBuildBalancedTree = buildBalancedTree(i4, i6);
            LLRBNode<A, C> lLRBNodeBuildBalancedTree2 = buildBalancedTree(i7 + 1, i6);
            A a5 = this.keys.get(i7);
            return new LLRBBlackValueNode(a5, getValue(a5), lLRBNodeBuildBalancedTree, lLRBNodeBuildBalancedTree2);
        }

        public static <A, B, C> RBTreeSortedMap<A, C> buildFrom(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator, Comparator<A> comparator) {
            Builder builder = new Builder(list, map, keyTranslator);
            Collections.sort(list, comparator);
            int size = list.size();
            for (BooleanChunk booleanChunk : new Base1_2(list.size())) {
                int i4 = booleanChunk.chunkSize;
                size -= i4;
                if (booleanChunk.isOne) {
                    builder.buildPennant(LLRBNode.Color.BLACK, i4, size);
                } else {
                    builder.buildPennant(LLRBNode.Color.BLACK, i4, size);
                    int i5 = booleanChunk.chunkSize;
                    size -= i5;
                    builder.buildPennant(LLRBNode.Color.RED, i5, size);
                }
            }
            LLRBNode lLRBEmptyNode = builder.root;
            if (lLRBEmptyNode == null) {
                lLRBEmptyNode = LLRBEmptyNode.getInstance();
            }
            return new RBTreeSortedMap<>(lLRBEmptyNode, comparator);
        }

        private void buildPennant(LLRBNode.Color color, int i4, int i5) {
            LLRBNode<A, C> lLRBNodeBuildBalancedTree = buildBalancedTree(i5 + 1, i4 - 1);
            A a4 = this.keys.get(i5);
            LLRBValueNode<A, C> lLRBRedValueNode = color == LLRBNode.Color.RED ? new LLRBRedValueNode<>(a4, getValue(a4), null, lLRBNodeBuildBalancedTree) : new LLRBBlackValueNode<>(a4, getValue(a4), null, lLRBNodeBuildBalancedTree);
            if (this.root == null) {
                this.root = lLRBRedValueNode;
                this.leaf = lLRBRedValueNode;
            } else {
                this.leaf.setLeft(lLRBRedValueNode);
                this.leaf = lLRBRedValueNode;
            }
        }

        private C getValue(A a4) {
            return this.values.get(this.keyTranslator.translate(a4));
        }
    }

    public static <A, B, C> RBTreeSortedMap<A, C> buildFrom(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator, Comparator<A> comparator) {
        return Builder.buildFrom(list, map, keyTranslator, comparator);
    }

    public static <A, B> RBTreeSortedMap<A, B> fromMap(Map<A, B> map, Comparator<A> comparator) {
        return Builder.buildFrom(new ArrayList(map.keySet()), map, ImmutableSortedMap.Builder.identityTranslator(), comparator);
    }

    private LLRBNode<K, V> getNode(K k4) {
        LLRBNode<K, V> left = this.root;
        while (!left.isEmpty()) {
            int iCompare = this.comparator.compare(k4, left.getKey());
            if (iCompare < 0) {
                left = left.getLeft();
            } else {
                if (iCompare == 0) {
                    return left;
                }
                left = left.getRight();
            }
        }
        return null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public boolean containsKey(K k4) {
        return getNode(k4) != null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public V get(K k4) {
        LLRBNode<K, V> node = getNode(k4);
        if (node != null) {
            return node.getValue();
        }
        return null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Comparator<K> getComparator() {
        return this.comparator;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getMaxKey() {
        return this.root.getMax().getKey();
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getMinKey() {
        return this.root.getMin().getKey();
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getPredecessorKey(K k4) {
        LLRBNode<K, V> left = this.root;
        LLRBNode<K, V> lLRBNode = null;
        while (!left.isEmpty()) {
            int iCompare = this.comparator.compare(k4, left.getKey());
            if (iCompare == 0) {
                if (left.getLeft().isEmpty()) {
                    if (lLRBNode != null) {
                        return lLRBNode.getKey();
                    }
                    return null;
                }
                LLRBNode<K, V> left2 = left.getLeft();
                while (!left2.getRight().isEmpty()) {
                    left2 = left2.getRight();
                }
                return left2.getKey();
            }
            if (iCompare < 0) {
                left = left.getLeft();
            } else {
                lLRBNode = left;
                left = left.getRight();
            }
        }
        throw new IllegalArgumentException("Couldn't find predecessor key of non-present key: " + k4);
    }

    public LLRBNode<K, V> getRoot() {
        return this.root;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getSuccessorKey(K k4) {
        LLRBNode<K, V> right = this.root;
        LLRBNode<K, V> lLRBNode = null;
        while (!right.isEmpty()) {
            int iCompare = this.comparator.compare(right.getKey(), k4);
            if (iCompare == 0) {
                if (right.getRight().isEmpty()) {
                    if (lLRBNode != null) {
                        return lLRBNode.getKey();
                    }
                    return null;
                }
                LLRBNode<K, V> right2 = right.getRight();
                while (!right2.getLeft().isEmpty()) {
                    right2 = right2.getLeft();
                }
                return right2.getKey();
            }
            if (iCompare < 0) {
                right = right.getRight();
            } else {
                lLRBNode = right;
                right = right.getLeft();
            }
        }
        throw new IllegalArgumentException("Couldn't find successor key of non-present key: " + k4);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public void inOrderTraversal(LLRBNode.NodeVisitor<K, V> nodeVisitor) {
        this.root.inOrderTraversal(nodeVisitor);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public int indexOf(K k4) {
        LLRBNode<K, V> left = this.root;
        int size = 0;
        while (!left.isEmpty()) {
            int iCompare = this.comparator.compare(k4, left.getKey());
            if (iCompare == 0) {
                return size + left.getLeft().size();
            }
            if (iCompare < 0) {
                left = left.getLeft();
            } else {
                size += left.getLeft().size() + 1;
                left = left.getRight();
            }
        }
        return -1;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public ImmutableSortedMap<K, V> insert(K k4, V v4) {
        return new RBTreeSortedMap(this.root.insert(k4, v4, this.comparator).copy(null, null, LLRBNode.Color.BLACK, null, null), this.comparator);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public boolean isEmpty() {
        return this.root.isEmpty();
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new ImmutableSortedMapIterator(this.root, null, this.comparator, false);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Iterator<Map.Entry<K, V>> iteratorFrom(K k4) {
        return new ImmutableSortedMapIterator(this.root, k4, this.comparator, false);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public ImmutableSortedMap<K, V> remove(K k4) {
        return !containsKey(k4) ? this : new RBTreeSortedMap(this.root.remove(k4, this.comparator).copy(null, null, LLRBNode.Color.BLACK, null, null), this.comparator);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Iterator<Map.Entry<K, V>> reverseIterator() {
        return new ImmutableSortedMapIterator(this.root, null, this.comparator, true);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Iterator<Map.Entry<K, V>> reverseIteratorFrom(K k4) {
        return new ImmutableSortedMapIterator(this.root, k4, this.comparator, true);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public int size() {
        return this.root.size();
    }

    public RBTreeSortedMap(Comparator<K> comparator) {
        this.root = LLRBEmptyNode.getInstance();
        this.comparator = comparator;
    }

    private RBTreeSortedMap(LLRBNode<K, V> lLRBNode, Comparator<K> comparator) {
        this.root = lLRBNode;
        this.comparator = comparator;
    }
}
