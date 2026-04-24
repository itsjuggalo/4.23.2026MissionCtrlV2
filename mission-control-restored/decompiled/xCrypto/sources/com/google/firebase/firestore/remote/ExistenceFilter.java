package com.google.firebase.firestore.remote;

import p2.C1710g;

/* JADX INFO: loaded from: classes.dex */
public final class ExistenceFilter {
    private final int count;
    private C1710g unchangedNames;

    public ExistenceFilter(int i4) {
        this.count = i4;
    }

    public int getCount() {
        return this.count;
    }

    public C1710g getUnchangedNames() {
        return this.unchangedNames;
    }

    public String toString() {
        return "ExistenceFilter{count=" + this.count + ", unchangedNames=" + this.unchangedNames + '}';
    }

    public ExistenceFilter(int i4, C1710g c1710g) {
        this.count = i4;
        this.unchangedNames = c1710g;
    }
}
