package com.google.firebase.firestore;

import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentSet;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DocumentChange {
    private final QueryDocumentSnapshot document;
    private final int newIndex;
    private final int oldIndex;
    private final Type type;

    /* JADX INFO: renamed from: com.google.firebase.firestore.DocumentChange$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type;

        static {
            int[] iArr = new int[DocumentViewChange.Type.values().length];
            $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type = iArr;
            try {
                iArr[DocumentViewChange.Type.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type[DocumentViewChange.Type.METADATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type[DocumentViewChange.Type.MODIFIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type[DocumentViewChange.Type.REMOVED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum Type {
        ADDED,
        MODIFIED,
        REMOVED
    }

    public DocumentChange(QueryDocumentSnapshot queryDocumentSnapshot, Type type, int i4, int i5) {
        this.type = type;
        this.document = queryDocumentSnapshot;
        this.oldIndex = i4;
        this.newIndex = i5;
    }

    public static List<DocumentChange> changesFromSnapshot(FirebaseFirestore firebaseFirestore, MetadataChanges metadataChanges, ViewSnapshot viewSnapshot) {
        int iIndexOf;
        int iIndexOf2;
        ArrayList arrayList = new ArrayList();
        if (viewSnapshot.getOldDocuments().isEmpty()) {
            Document document = null;
            int i4 = 0;
            for (DocumentViewChange documentViewChange : viewSnapshot.getChanges()) {
                Document document2 = documentViewChange.getDocument();
                QueryDocumentSnapshot queryDocumentSnapshotFromDocument = QueryDocumentSnapshot.fromDocument(firebaseFirestore, document2, viewSnapshot.isFromCache(), viewSnapshot.getMutatedKeys().contains(document2.getKey()));
                Assert.hardAssert(documentViewChange.getType() == DocumentViewChange.Type.ADDED, "Invalid added event for first snapshot", new Object[0]);
                Assert.hardAssert(document == null || viewSnapshot.getQuery().comparator().compare(document, document2) < 0, "Got added events in wrong order", new Object[0]);
                arrayList.add(new DocumentChange(queryDocumentSnapshotFromDocument, Type.ADDED, -1, i4));
                document = document2;
                i4++;
            }
        } else {
            DocumentSet oldDocuments = viewSnapshot.getOldDocuments();
            for (DocumentViewChange documentViewChange2 : viewSnapshot.getChanges()) {
                if (metadataChanges != MetadataChanges.EXCLUDE || documentViewChange2.getType() != DocumentViewChange.Type.METADATA) {
                    Document document3 = documentViewChange2.getDocument();
                    QueryDocumentSnapshot queryDocumentSnapshotFromDocument2 = QueryDocumentSnapshot.fromDocument(firebaseFirestore, document3, viewSnapshot.isFromCache(), viewSnapshot.getMutatedKeys().contains(document3.getKey()));
                    Type type = getType(documentViewChange2);
                    if (type != Type.ADDED) {
                        iIndexOf = oldDocuments.indexOf(document3.getKey());
                        Assert.hardAssert(iIndexOf >= 0, "Index for document not found", new Object[0]);
                        oldDocuments = oldDocuments.remove(document3.getKey());
                    } else {
                        iIndexOf = -1;
                    }
                    if (type != Type.REMOVED) {
                        oldDocuments = oldDocuments.add(document3);
                        iIndexOf2 = oldDocuments.indexOf(document3.getKey());
                        Assert.hardAssert(iIndexOf2 >= 0, "Index for document not found", new Object[0]);
                    } else {
                        iIndexOf2 = -1;
                    }
                    arrayList.add(new DocumentChange(queryDocumentSnapshotFromDocument2, type, iIndexOf, iIndexOf2));
                }
            }
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DocumentChange) {
            DocumentChange documentChange = (DocumentChange) obj;
            if (this.type.equals(documentChange.type) && this.document.equals(documentChange.document) && this.oldIndex == documentChange.oldIndex && this.newIndex == documentChange.newIndex) {
                return true;
            }
        }
        return false;
    }

    public QueryDocumentSnapshot getDocument() {
        return this.document;
    }

    public int getNewIndex() {
        return this.newIndex;
    }

    public int getOldIndex() {
        return this.oldIndex;
    }

    public Type getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((this.type.hashCode() * 31) + this.document.hashCode()) * 31) + this.oldIndex) * 31) + this.newIndex;
    }

    private static Type getType(DocumentViewChange documentViewChange) {
        int i4 = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type[documentViewChange.getType().ordinal()];
        if (i4 == 1) {
            return Type.ADDED;
        }
        if (i4 == 2 || i4 == 3) {
            return Type.MODIFIED;
        }
        if (i4 == 4) {
            return Type.REMOVED;
        }
        throw new IllegalArgumentException("Unknown view change type: " + documentViewChange.getType());
    }
}
