package com.google.firebase.firestore.local;

import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.remote.WatchStream;
import com.google.firebase.firestore.util.Preconditions;
import com.google.protobuf.AbstractC1062i;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class TargetData {
    private final Integer expectedCount;
    private final SnapshotVersion lastLimboFreeSnapshotVersion;
    private final QueryPurpose purpose;
    private final AbstractC1062i resumeToken;
    private final long sequenceNumber;
    private final SnapshotVersion snapshotVersion;
    private final Target target;
    private final int targetId;

    public TargetData(Target target, int i4, long j4, QueryPurpose queryPurpose, SnapshotVersion snapshotVersion, SnapshotVersion snapshotVersion2, AbstractC1062i abstractC1062i, Integer num) {
        this.target = (Target) Preconditions.checkNotNull(target);
        this.targetId = i4;
        this.sequenceNumber = j4;
        this.lastLimboFreeSnapshotVersion = snapshotVersion2;
        this.purpose = queryPurpose;
        this.snapshotVersion = (SnapshotVersion) Preconditions.checkNotNull(snapshotVersion);
        this.resumeToken = (AbstractC1062i) Preconditions.checkNotNull(abstractC1062i);
        this.expectedCount = num;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && TargetData.class == obj.getClass()) {
            TargetData targetData = (TargetData) obj;
            if (this.target.equals(targetData.target) && this.targetId == targetData.targetId && this.sequenceNumber == targetData.sequenceNumber && this.purpose.equals(targetData.purpose) && this.snapshotVersion.equals(targetData.snapshotVersion) && this.lastLimboFreeSnapshotVersion.equals(targetData.lastLimboFreeSnapshotVersion) && this.resumeToken.equals(targetData.resumeToken) && Objects.equals(this.expectedCount, targetData.expectedCount)) {
                return true;
            }
        }
        return false;
    }

    public Integer getExpectedCount() {
        return this.expectedCount;
    }

    public SnapshotVersion getLastLimboFreeSnapshotVersion() {
        return this.lastLimboFreeSnapshotVersion;
    }

    public QueryPurpose getPurpose() {
        return this.purpose;
    }

    public AbstractC1062i getResumeToken() {
        return this.resumeToken;
    }

    public long getSequenceNumber() {
        return this.sequenceNumber;
    }

    public SnapshotVersion getSnapshotVersion() {
        return this.snapshotVersion;
    }

    public Target getTarget() {
        return this.target;
    }

    public int getTargetId() {
        return this.targetId;
    }

    public int hashCode() {
        return (((((((((((((this.target.hashCode() * 31) + this.targetId) * 31) + ((int) this.sequenceNumber)) * 31) + this.purpose.hashCode()) * 31) + this.snapshotVersion.hashCode()) * 31) + this.lastLimboFreeSnapshotVersion.hashCode()) * 31) + this.resumeToken.hashCode()) * 31) + Objects.hashCode(this.expectedCount);
    }

    public String toString() {
        return "TargetData{target=" + this.target + ", targetId=" + this.targetId + ", sequenceNumber=" + this.sequenceNumber + ", purpose=" + this.purpose + ", snapshotVersion=" + this.snapshotVersion + ", lastLimboFreeSnapshotVersion=" + this.lastLimboFreeSnapshotVersion + ", resumeToken=" + this.resumeToken + ", expectedCount=" + this.expectedCount + '}';
    }

    public TargetData withExpectedCount(Integer num) {
        return new TargetData(this.target, this.targetId, this.sequenceNumber, this.purpose, this.snapshotVersion, this.lastLimboFreeSnapshotVersion, this.resumeToken, num);
    }

    public TargetData withLastLimboFreeSnapshotVersion(SnapshotVersion snapshotVersion) {
        return new TargetData(this.target, this.targetId, this.sequenceNumber, this.purpose, this.snapshotVersion, snapshotVersion, this.resumeToken, this.expectedCount);
    }

    public TargetData withResumeToken(AbstractC1062i abstractC1062i, SnapshotVersion snapshotVersion) {
        return new TargetData(this.target, this.targetId, this.sequenceNumber, this.purpose, snapshotVersion, this.lastLimboFreeSnapshotVersion, abstractC1062i, null);
    }

    public TargetData withSequenceNumber(long j4) {
        return new TargetData(this.target, this.targetId, j4, this.purpose, this.snapshotVersion, this.lastLimboFreeSnapshotVersion, this.resumeToken, this.expectedCount);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TargetData(Target target, int i4, long j4, QueryPurpose queryPurpose) {
        SnapshotVersion snapshotVersion = SnapshotVersion.NONE;
        this(target, i4, j4, queryPurpose, snapshotVersion, snapshotVersion, WatchStream.EMPTY_RESUME_TOKEN, null);
    }
}
