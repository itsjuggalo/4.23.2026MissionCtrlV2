package com.google.firebase.firestore;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Preconditions;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class QueryDocumentSnapshot extends DocumentSnapshot {
    private QueryDocumentSnapshot(FirebaseFirestore firebaseFirestore, DocumentKey documentKey, Document document, boolean z4, boolean z5) {
        super(firebaseFirestore, documentKey, document, z4, z5);
    }

    public static QueryDocumentSnapshot fromDocument(FirebaseFirestore firebaseFirestore, Document document, boolean z4, boolean z5) {
        return new QueryDocumentSnapshot(firebaseFirestore, document.getKey(), document, z4, z5);
    }

    @Override // com.google.firebase.firestore.DocumentSnapshot
    public Map<String, Object> getData() {
        Map<String, Object> data = super.getData();
        Assert.hardAssert(data != null, "Data in a QueryDocumentSnapshot should be non-null", new Object[0]);
        return data;
    }

    @Override // com.google.firebase.firestore.DocumentSnapshot
    public <T> T toObject(Class<T> cls) {
        T t4 = (T) super.toObject(cls);
        Assert.hardAssert(t4 != null, "Object in a QueryDocumentSnapshot should be non-null", new Object[0]);
        return t4;
    }

    @Override // com.google.firebase.firestore.DocumentSnapshot
    public Map<String, Object> getData(DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        Preconditions.checkNotNull(serverTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
        Map<String, Object> data = super.getData(serverTimestampBehavior);
        Assert.hardAssert(data != null, "Data in a QueryDocumentSnapshot should be non-null", new Object[0]);
        return data;
    }

    @Override // com.google.firebase.firestore.DocumentSnapshot
    public <T> T toObject(Class<T> cls, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        Preconditions.checkNotNull(serverTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
        T t4 = (T) super.toObject(cls, serverTimestampBehavior);
        Assert.hardAssert(t4 != null, "Object in a QueryDocumentSnapshot should be non-null", new Object[0]);
        return t4;
    }
}
