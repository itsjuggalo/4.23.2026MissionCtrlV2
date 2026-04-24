package com.google.firebase.firestore;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.core.FirestoreClient;
import com.google.firebase.firestore.core.UserData;
import com.google.firebase.firestore.model.mutation.DeleteMutation;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class WriteBatch {
    private final FirebaseFirestore firestore;
    private final ArrayList<Mutation> mutations = new ArrayList<>();
    private boolean committed = false;

    public interface Function {
        void apply(WriteBatch writeBatch);
    }

    public WriteBatch(FirebaseFirestore firebaseFirestore) {
        this.firestore = (FirebaseFirestore) Preconditions.checkNotNull(firebaseFirestore);
    }

    private void verifyNotCommitted() {
        if (this.committed) {
            throw new IllegalStateException("A write batch can no longer be used after commit() has been called.");
        }
    }

    public Task<Void> commit() {
        verifyNotCommitted();
        this.committed = true;
        return !this.mutations.isEmpty() ? (Task) this.firestore.callClient(new com.google.firebase.firestore.util.Function() { // from class: com.google.firebase.firestore.V
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                return ((FirestoreClient) obj).write(this.f10392a.mutations);
            }
        }) : Tasks.forResult(null);
    }

    public WriteBatch delete(DocumentReference documentReference) {
        this.firestore.validateReference(documentReference);
        verifyNotCommitted();
        this.mutations.add(new DeleteMutation(documentReference.getKey(), Precondition.NONE));
        return this;
    }

    public WriteBatch set(DocumentReference documentReference, Object obj) {
        return set(documentReference, obj, SetOptions.OVERWRITE);
    }

    public WriteBatch update(DocumentReference documentReference, Map<String, Object> map) {
        return update(documentReference, this.firestore.getUserDataReader().parseUpdateData(map));
    }

    public WriteBatch set(DocumentReference documentReference, Object obj, SetOptions setOptions) {
        this.firestore.validateReference(documentReference);
        Preconditions.checkNotNull(obj, "Provided data must not be null.");
        Preconditions.checkNotNull(setOptions, "Provided options must not be null.");
        verifyNotCommitted();
        this.mutations.add((setOptions.isMerge() ? this.firestore.getUserDataReader().parseMergeData(obj, setOptions.getFieldMask()) : this.firestore.getUserDataReader().parseSetData(obj)).toMutation(documentReference.getKey(), Precondition.NONE));
        return this;
    }

    public WriteBatch update(DocumentReference documentReference, String str, Object obj, Object... objArr) {
        return update(documentReference, this.firestore.getUserDataReader().parseUpdateData(Util.collectUpdateArguments(1, str, obj, objArr)));
    }

    public WriteBatch update(DocumentReference documentReference, FieldPath fieldPath, Object obj, Object... objArr) {
        return update(documentReference, this.firestore.getUserDataReader().parseUpdateData(Util.collectUpdateArguments(1, fieldPath, obj, objArr)));
    }

    private WriteBatch update(DocumentReference documentReference, UserData.ParsedUpdateData parsedUpdateData) {
        this.firestore.validateReference(documentReference);
        verifyNotCommitted();
        this.mutations.add(parsedUpdateData.toMutation(documentReference.getKey(), Precondition.exists(true)));
        return this;
    }
}
