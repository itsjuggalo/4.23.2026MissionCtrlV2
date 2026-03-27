package com.google.firebase.firestore.core;

import com.google.firebase.firestore.util.Assert;

/* JADX INFO: loaded from: classes.dex */
public class TargetIdGenerator {
    private static final int QUERY_CACHE_ID = 0;
    private static final int RESERVED_BITS = 1;
    private static final int SYNC_ENGINE_ID = 1;
    private int generatorId;
    private int nextId;

    public TargetIdGenerator(int i4, int i5) {
        Assert.hardAssert((i4 & 1) == i4, "Generator ID %d contains more than %d reserved bits", Integer.valueOf(i4), 1);
        this.generatorId = i4;
        seek(i5);
    }

    public static TargetIdGenerator forSyncEngine() {
        return new TargetIdGenerator(1, 1);
    }

    public static TargetIdGenerator forTargetCache(int i4) {
        TargetIdGenerator targetIdGenerator = new TargetIdGenerator(0, i4);
        targetIdGenerator.nextId();
        return targetIdGenerator;
    }

    private void seek(int i4) {
        Assert.hardAssert((i4 & 1) == this.generatorId, "Cannot supply target ID from different generator ID", new Object[0]);
        this.nextId = i4;
    }

    public int nextId() {
        int i4 = this.nextId;
        this.nextId = i4 + 2;
        return i4;
    }
}
