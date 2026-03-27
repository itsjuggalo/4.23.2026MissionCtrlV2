package com.google.firebase.firestore.remote;

import K2.l0;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.util.Assert;
import com.google.protobuf.AbstractC1062i;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class WatchChange {

    public static final class DocumentChange extends WatchChange {
        private final DocumentKey documentKey;
        private final MutableDocument newDocument;
        private final List<Integer> removedTargetIds;
        private final List<Integer> updatedTargetIds;

        public DocumentChange(List<Integer> list, List<Integer> list2, DocumentKey documentKey, MutableDocument mutableDocument) {
            super();
            this.updatedTargetIds = list;
            this.removedTargetIds = list2;
            this.documentKey = documentKey;
            this.newDocument = mutableDocument;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && DocumentChange.class == obj.getClass()) {
                DocumentChange documentChange = (DocumentChange) obj;
                if (!this.updatedTargetIds.equals(documentChange.updatedTargetIds) || !this.removedTargetIds.equals(documentChange.removedTargetIds) || !this.documentKey.equals(documentChange.documentKey)) {
                    return false;
                }
                MutableDocument mutableDocument = this.newDocument;
                MutableDocument mutableDocument2 = documentChange.newDocument;
                if (mutableDocument != null) {
                    return mutableDocument.equals(mutableDocument2);
                }
                if (mutableDocument2 == null) {
                    return true;
                }
            }
            return false;
        }

        public DocumentKey getDocumentKey() {
            return this.documentKey;
        }

        public MutableDocument getNewDocument() {
            return this.newDocument;
        }

        public List<Integer> getRemovedTargetIds() {
            return this.removedTargetIds;
        }

        public List<Integer> getUpdatedTargetIds() {
            return this.updatedTargetIds;
        }

        public int hashCode() {
            int iHashCode = ((((this.updatedTargetIds.hashCode() * 31) + this.removedTargetIds.hashCode()) * 31) + this.documentKey.hashCode()) * 31;
            MutableDocument mutableDocument = this.newDocument;
            return iHashCode + (mutableDocument != null ? mutableDocument.hashCode() : 0);
        }

        public String toString() {
            return "DocumentChange{updatedTargetIds=" + this.updatedTargetIds + ", removedTargetIds=" + this.removedTargetIds + ", key=" + this.documentKey + ", newDocument=" + this.newDocument + '}';
        }
    }

    public static final class ExistenceFilterWatchChange extends WatchChange {
        private final ExistenceFilter existenceFilter;
        private final int targetId;

        public ExistenceFilterWatchChange(int i4, ExistenceFilter existenceFilter) {
            super();
            this.targetId = i4;
            this.existenceFilter = existenceFilter;
        }

        public ExistenceFilter getExistenceFilter() {
            return this.existenceFilter;
        }

        public int getTargetId() {
            return this.targetId;
        }

        public String toString() {
            return "ExistenceFilterWatchChange{targetId=" + this.targetId + ", existenceFilter=" + this.existenceFilter + '}';
        }
    }

    public static final class WatchTargetChange extends WatchChange {
        private final l0 cause;
        private final WatchTargetChangeType changeType;
        private final AbstractC1062i resumeToken;
        private final List<Integer> targetIds;

        public WatchTargetChange(WatchTargetChangeType watchTargetChangeType, List<Integer> list) {
            this(watchTargetChangeType, list, WatchStream.EMPTY_RESUME_TOKEN, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && WatchTargetChange.class == obj.getClass()) {
                WatchTargetChange watchTargetChange = (WatchTargetChange) obj;
                if (this.changeType != watchTargetChange.changeType || !this.targetIds.equals(watchTargetChange.targetIds) || !this.resumeToken.equals(watchTargetChange.resumeToken)) {
                    return false;
                }
                l0 l0Var = this.cause;
                if (l0Var != null) {
                    return watchTargetChange.cause != null && l0Var.m().equals(watchTargetChange.cause.m());
                }
                if (watchTargetChange.cause == null) {
                    return true;
                }
            }
            return false;
        }

        public l0 getCause() {
            return this.cause;
        }

        public WatchTargetChangeType getChangeType() {
            return this.changeType;
        }

        public AbstractC1062i getResumeToken() {
            return this.resumeToken;
        }

        public List<Integer> getTargetIds() {
            return this.targetIds;
        }

        public int hashCode() {
            int iHashCode = ((((this.changeType.hashCode() * 31) + this.targetIds.hashCode()) * 31) + this.resumeToken.hashCode()) * 31;
            l0 l0Var = this.cause;
            return iHashCode + (l0Var != null ? l0Var.m().hashCode() : 0);
        }

        public String toString() {
            return "WatchTargetChange{changeType=" + this.changeType + ", targetIds=" + this.targetIds + '}';
        }

        public WatchTargetChange(WatchTargetChangeType watchTargetChangeType, List<Integer> list, AbstractC1062i abstractC1062i) {
            this(watchTargetChangeType, list, abstractC1062i, null);
        }

        public WatchTargetChange(WatchTargetChangeType watchTargetChangeType, List<Integer> list, AbstractC1062i abstractC1062i, l0 l0Var) {
            super();
            Assert.hardAssert(l0Var == null || watchTargetChangeType == WatchTargetChangeType.Removed, "Got cause for a target change that was not a removal", new Object[0]);
            this.changeType = watchTargetChangeType;
            this.targetIds = list;
            this.resumeToken = abstractC1062i;
            if (l0Var != null && !l0Var.o()) {
                this.cause = l0Var;
            } else {
                this.cause = null;
            }
        }
    }

    public enum WatchTargetChangeType {
        NoChange,
        Added,
        Removed,
        Current,
        Reset
    }

    private WatchChange() {
    }
}
