package com.google.firebase.database.collection;

import java.lang.Comparable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class StandardComparator<A extends Comparable<A>> implements Comparator<A> {
    private static StandardComparator INSTANCE = new StandardComparator();

    private StandardComparator() {
    }

    public static <T extends Comparable<T>> StandardComparator<T> getComparator(Class<T> cls) {
        return INSTANCE;
    }

    @Override // java.util.Comparator
    public int compare(A a4, A a5) {
        return a4.compareTo(a5);
    }
}
