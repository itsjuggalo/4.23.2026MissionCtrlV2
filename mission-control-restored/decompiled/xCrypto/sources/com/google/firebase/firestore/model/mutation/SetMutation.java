package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.ObjectValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p2.C1698D;

/* JADX INFO: loaded from: classes.dex */
public final class SetMutation extends Mutation {
    private final ObjectValue value;

    public SetMutation(DocumentKey documentKey, ObjectValue objectValue, Precondition precondition) {
        this(documentKey, objectValue, precondition, new ArrayList());
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public FieldMask applyToLocalView(MutableDocument mutableDocument, FieldMask fieldMask, Timestamp timestamp) {
        verifyKeyMatches(mutableDocument);
        if (!getPrecondition().isValidFor(mutableDocument)) {
            return fieldMask;
        }
        Map<FieldPath, C1698D> mapLocalTransformResults = localTransformResults(timestamp, mutableDocument);
        ObjectValue objectValueM16clone = this.value.m16clone();
        objectValueM16clone.setAll(mapLocalTransformResults);
        mutableDocument.convertToFoundDocument(mutableDocument.getVersion(), objectValueM16clone).setHasLocalMutations();
        return null;
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public void applyToRemoteDocument(MutableDocument mutableDocument, MutationResult mutationResult) {
        verifyKeyMatches(mutableDocument);
        ObjectValue objectValueM16clone = this.value.m16clone();
        objectValueM16clone.setAll(serverTransformResults(mutableDocument, mutationResult.getTransformResults()));
        mutableDocument.convertToFoundDocument(mutationResult.getVersion(), objectValueM16clone).setHasCommittedMutations();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SetMutation.class == obj.getClass()) {
            SetMutation setMutation = (SetMutation) obj;
            if (hasSameKeyAndPrecondition(setMutation) && this.value.equals(setMutation.value) && getFieldTransforms().equals(setMutation.getFieldTransforms())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public FieldMask getFieldMask() {
        return null;
    }

    public ObjectValue getValue() {
        return this.value;
    }

    public int hashCode() {
        return (keyAndPreconditionHashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return "SetMutation{" + keyAndPreconditionToString() + ", value=" + this.value + "}";
    }

    public SetMutation(DocumentKey documentKey, ObjectValue objectValue, Precondition precondition, List<FieldTransform> list) {
        super(documentKey, precondition, list);
        this.value = objectValue;
    }
}
