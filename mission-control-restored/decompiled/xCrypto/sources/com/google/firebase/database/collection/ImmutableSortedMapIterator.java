package com.google.firebase.database.collection;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableSortedMapIterator<K, V> implements Iterator<Map.Entry<K, V>> {
    private final boolean isReverse;
    private final ArrayDeque<LLRBValueNode<K, V>> nodeStack = new ArrayDeque<>();

    public ImmutableSortedMapIterator(LLRBNode<K, V> lLRBNode, K k4, Comparator<K> comparator, boolean z4) {
        this.isReverse = z4;
        while (!lLRBNode.isEmpty()) {
            int iCompare = k4 != null ? z4 ? comparator.compare(k4, lLRBNode.getKey()) : comparator.compare(lLRBNode.getKey(), k4) : 1;
            if (iCompare < 0) {
                lLRBNode = z4 ? lLRBNode.getLeft() : lLRBNode.getRight();
            } else if (iCompare == 0) {
                this.nodeStack.push((LLRBValueNode) lLRBNode);
                return;
            } else {
                this.nodeStack.push((LLRBValueNode) lLRBNode);
                lLRBNode = z4 ? lLRBNode.getRight() : lLRBNode.getLeft();
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.nodeStack.size() > 0;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }

    @Override // java.util.Iterator
    public Map.Entry<K, V> next() {
        try {
            LLRBValueNode<K, V> lLRBValueNodePop = this.nodeStack.pop();
            AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(lLRBValueNodePop.getKey(), lLRBValueNodePop.getValue());
            if (this.isReverse) {
                for (LLRBNode<K, V> left = lLRBValueNodePop.getLeft(); !left.isEmpty(); left = left.getRight()) {
                    this.nodeStack.push((LLRBValueNode) left);
                }
            } else {
                for (LLRBNode<K, V> right = lLRBValueNodePop.getRight(); !right.isEmpty(); right = right.getLeft()) {
                    this.nodeStack.push((LLRBValueNode) right);
                }
            }
            return simpleEntry;
        } catch (EmptyStackException unused) {
            throw new NoSuchElementException();
        }
    }
}
