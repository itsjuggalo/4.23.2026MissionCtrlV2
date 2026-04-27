package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.remote.TestingHooks;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_TestingHooks_ExistenceFilterBloomFilterInfo extends TestingHooks.ExistenceFilterBloomFilterInfo {
    private final boolean applied;
    private final int bitmapLength;
    private final BloomFilter bloomFilter;
    private final int hashCount;
    private final int padding;

    public AutoValue_TestingHooks_ExistenceFilterBloomFilterInfo(BloomFilter bloomFilter, boolean z4, int i4, int i5, int i6) {
        this.bloomFilter = bloomFilter;
        this.applied = z4;
        this.hashCount = i4;
        this.bitmapLength = i5;
        this.padding = i6;
    }

    @Override // com.google.firebase.firestore.remote.TestingHooks.ExistenceFilterBloomFilterInfo
    public boolean applied() {
        return this.applied;
    }

    @Override // com.google.firebase.firestore.remote.TestingHooks.ExistenceFilterBloomFilterInfo
    public int bitmapLength() {
        return this.bitmapLength;
    }

    @Override // com.google.firebase.firestore.remote.TestingHooks.ExistenceFilterBloomFilterInfo
    public BloomFilter bloomFilter() {
        return this.bloomFilter;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TestingHooks.ExistenceFilterBloomFilterInfo) {
            TestingHooks.ExistenceFilterBloomFilterInfo existenceFilterBloomFilterInfo = (TestingHooks.ExistenceFilterBloomFilterInfo) obj;
            BloomFilter bloomFilter = this.bloomFilter;
            if (bloomFilter != null ? bloomFilter.equals(existenceFilterBloomFilterInfo.bloomFilter()) : existenceFilterBloomFilterInfo.bloomFilter() == null) {
                if (this.applied == existenceFilterBloomFilterInfo.applied() && this.hashCount == existenceFilterBloomFilterInfo.hashCount() && this.bitmapLength == existenceFilterBloomFilterInfo.bitmapLength() && this.padding == existenceFilterBloomFilterInfo.padding()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        BloomFilter bloomFilter = this.bloomFilter;
        return (((((((((bloomFilter == null ? 0 : bloomFilter.hashCode()) ^ 1000003) * 1000003) ^ (this.applied ? 1231 : 1237)) * 1000003) ^ this.hashCount) * 1000003) ^ this.bitmapLength) * 1000003) ^ this.padding;
    }

    @Override // com.google.firebase.firestore.remote.TestingHooks.ExistenceFilterBloomFilterInfo
    public int hashCount() {
        return this.hashCount;
    }

    @Override // com.google.firebase.firestore.remote.TestingHooks.ExistenceFilterBloomFilterInfo
    public int padding() {
        return this.padding;
    }

    public String toString() {
        return "ExistenceFilterBloomFilterInfo{bloomFilter=" + this.bloomFilter + ", applied=" + this.applied + ", hashCount=" + this.hashCount + ", bitmapLength=" + this.bitmapLength + ", padding=" + this.padding + "}";
    }
}
