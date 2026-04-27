package com.google.firebase.firestore.model;

import com.google.firebase.firestore.model.FieldIndex;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_FieldIndex_Segment extends FieldIndex.Segment {
    private final FieldPath fieldPath;
    private final FieldIndex.Segment.Kind kind;

    public AutoValue_FieldIndex_Segment(FieldPath fieldPath, FieldIndex.Segment.Kind kind) {
        if (fieldPath == null) {
            throw new NullPointerException("Null fieldPath");
        }
        this.fieldPath = fieldPath;
        if (kind == null) {
            throw new NullPointerException("Null kind");
        }
        this.kind = kind;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FieldIndex.Segment) {
            FieldIndex.Segment segment = (FieldIndex.Segment) obj;
            if (this.fieldPath.equals(segment.getFieldPath()) && this.kind.equals(segment.getKind())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex.Segment
    public FieldPath getFieldPath() {
        return this.fieldPath;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex.Segment
    public FieldIndex.Segment.Kind getKind() {
        return this.kind;
    }

    public int hashCode() {
        return ((this.fieldPath.hashCode() ^ 1000003) * 1000003) ^ this.kind.hashCode();
    }

    public String toString() {
        return "Segment{fieldPath=" + this.fieldPath + ", kind=" + this.kind + "}";
    }
}
