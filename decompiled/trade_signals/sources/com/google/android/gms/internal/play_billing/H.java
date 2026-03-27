package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public abstract class H extends AbstractC1327e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15166b;

    public H(int i8, int i9) {
        A.b(i9, i8, FirebaseAnalytics.Param.INDEX);
        this.f15165a = i8;
        this.f15166b = i9;
    }

    public abstract Object b(int i8);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f15166b < this.f15165a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f15166b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i8 = this.f15166b;
        this.f15166b = i8 + 1;
        return b(i8);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f15166b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i8 = this.f15166b - 1;
        this.f15166b = i8;
        return b(i8);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f15166b - 1;
    }
}
