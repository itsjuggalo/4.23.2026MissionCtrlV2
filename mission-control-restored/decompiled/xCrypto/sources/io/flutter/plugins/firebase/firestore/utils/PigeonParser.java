package io.flutter.plugins.firebase.firestore.utils;

import android.util.Log;
import com.google.firebase.firestore.AggregateSource;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.Filter;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ListenSource;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SnapshotMetadata;
import com.google.firebase.firestore.Source;
import io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class PigeonParser {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX INFO: renamed from: io.flutter.plugins.firebase.firestore.utils.PigeonParser$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$DocumentChange$Type;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$AggregateSource;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$ListenSource;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$ServerTimestampBehavior;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$Source;

        static {
            int[] iArr = new int[GeneratedAndroidFirebaseFirestore.AggregateSource.values().length];
            $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$AggregateSource = iArr;
            try {
                iArr[GeneratedAndroidFirebaseFirestore.AggregateSource.SERVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            int[] iArr2 = new int[GeneratedAndroidFirebaseFirestore.ListenSource.values().length];
            $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$ListenSource = iArr2;
            try {
                iArr2[GeneratedAndroidFirebaseFirestore.ListenSource.DEFAULT_SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$ListenSource[GeneratedAndroidFirebaseFirestore.ListenSource.CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr3 = new int[DocumentChange.Type.values().length];
            $SwitchMap$com$google$firebase$firestore$DocumentChange$Type = iArr3;
            try {
                iArr3[DocumentChange.Type.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$DocumentChange$Type[DocumentChange.Type.MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$DocumentChange$Type[DocumentChange.Type.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr4 = new int[GeneratedAndroidFirebaseFirestore.ServerTimestampBehavior.values().length];
            $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$ServerTimestampBehavior = iArr4;
            try {
                iArr4[GeneratedAndroidFirebaseFirestore.ServerTimestampBehavior.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$ServerTimestampBehavior[GeneratedAndroidFirebaseFirestore.ServerTimestampBehavior.ESTIMATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$ServerTimestampBehavior[GeneratedAndroidFirebaseFirestore.ServerTimestampBehavior.PREVIOUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr5 = new int[GeneratedAndroidFirebaseFirestore.Source.values().length];
            $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$Source = iArr5;
            try {
                iArr5[GeneratedAndroidFirebaseFirestore.Source.CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$Source[GeneratedAndroidFirebaseFirestore.Source.SERVER_AND_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$Source[GeneratedAndroidFirebaseFirestore.Source.SERVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private static Filter filterFromJson(Map<String, Object> map) {
        FieldPath fieldPath;
        Object obj;
        if (!map.containsKey("fieldPath")) {
            String str = (String) map.get("op");
            List list = (List) map.get("queries");
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(filterFromJson((Map) it.next()));
            }
            if (str.equals("OR")) {
                return Filter.or((Filter[]) arrayList.toArray(new Filter[0]));
            }
            if (str.equals("AND")) {
                return Filter.and((Filter[]) arrayList.toArray(new Filter[0]));
            }
            throw new Error("Invalid operator");
        }
        String str2 = (String) map.get("op");
        fieldPath = (FieldPath) map.get("fieldPath");
        obj = map.get("value");
        str2.getClass();
        switch (str2) {
            case "not-in":
                return Filter.notInArray(fieldPath, (List<? extends Object>) obj);
            case "<":
                return Filter.lessThan(fieldPath, obj);
            case ">":
                return Filter.greaterThan(fieldPath, obj);
            case "!=":
                return Filter.notEqualTo(fieldPath, obj);
            case "<=":
                return Filter.lessThanOrEqualTo(fieldPath, obj);
            case "==":
                return Filter.equalTo(fieldPath, obj);
            case ">=":
                return Filter.greaterThanOrEqualTo(fieldPath, obj);
            case "in":
                return Filter.inArray(fieldPath, (List<? extends Object>) obj);
            case "array-contains":
                return Filter.arrayContains(fieldPath, obj);
            case "array-contains-any":
                return Filter.arrayContainsAny(fieldPath, (List<? extends Object>) obj);
            default:
                throw new Error("Invalid operator");
        }
    }

    public static AggregateSource parseAggregateSource(GeneratedAndroidFirebaseFirestore.AggregateSource aggregateSource) {
        if (AnonymousClass1.$SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$AggregateSource[aggregateSource.ordinal()] == 1) {
            return AggregateSource.SERVER;
        }
        throw new IllegalArgumentException("Unknown AggregateSource value: " + aggregateSource);
    }

    public static List<FieldPath> parseFieldPath(List<List<String>> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<List<String>> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(FieldPath.of((String[]) it.next().toArray(new String[0])));
        }
        return arrayList;
    }

    public static ListenSource parseListenSource(GeneratedAndroidFirebaseFirestore.ListenSource listenSource) {
        int i4 = AnonymousClass1.$SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$ListenSource[listenSource.ordinal()];
        if (i4 == 1) {
            return ListenSource.DEFAULT;
        }
        if (i4 == 2) {
            return ListenSource.CACHE;
        }
        throw new IllegalArgumentException("Unknown ListenSource value: " + listenSource);
    }

    public static DocumentSnapshot.ServerTimestampBehavior parsePigeonServerTimestampBehavior(GeneratedAndroidFirebaseFirestore.ServerTimestampBehavior serverTimestampBehavior) {
        if (serverTimestampBehavior == null) {
            return DocumentSnapshot.ServerTimestampBehavior.NONE;
        }
        int i4 = AnonymousClass1.$SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$ServerTimestampBehavior[serverTimestampBehavior.ordinal()];
        if (i4 == 1) {
            return DocumentSnapshot.ServerTimestampBehavior.NONE;
        }
        if (i4 == 2) {
            return DocumentSnapshot.ServerTimestampBehavior.ESTIMATE;
        }
        if (i4 == 3) {
            return DocumentSnapshot.ServerTimestampBehavior.PREVIOUS;
        }
        throw new IllegalArgumentException("Unknown server timestamp behavior: " + serverTimestampBehavior);
    }

    public static Source parsePigeonSource(GeneratedAndroidFirebaseFirestore.Source source) {
        int i4 = AnonymousClass1.$SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$Source[source.ordinal()];
        if (i4 == 1) {
            return Source.CACHE;
        }
        if (i4 == 2) {
            return Source.DEFAULT;
        }
        if (i4 == 3) {
            return Source.SERVER;
        }
        throw new IllegalArgumentException("Unknown source: " + source);
    }

    public static Query parseQuery(FirebaseFirestore firebaseFirestore, String str, boolean z4, GeneratedAndroidFirebaseFirestore.PigeonQueryParameters pigeonQueryParameters) {
        try {
            Query queryCollectionGroup = z4 ? firebaseFirestore.collectionGroup(str) : firebaseFirestore.collection(str);
            if (pigeonQueryParameters == null) {
                return queryCollectionGroup;
            }
            if (pigeonQueryParameters.getFilters() != null) {
                queryCollectionGroup = queryCollectionGroup.where(filterFromJson(pigeonQueryParameters.getFilters()));
            }
            List<List<Object>> where = pigeonQueryParameters.getWhere();
            Objects.requireNonNull(where);
            for (List<Object> list : where) {
                FieldPath fieldPath = (FieldPath) list.get(0);
                String str2 = (String) list.get(1);
                Object obj = list.get(2);
                if ("==".equals(str2)) {
                    queryCollectionGroup = queryCollectionGroup.whereEqualTo(fieldPath, obj);
                } else if ("!=".equals(str2)) {
                    queryCollectionGroup = queryCollectionGroup.whereNotEqualTo(fieldPath, obj);
                } else if ("<".equals(str2)) {
                    queryCollectionGroup = queryCollectionGroup.whereLessThan(fieldPath, obj);
                } else if ("<=".equals(str2)) {
                    queryCollectionGroup = queryCollectionGroup.whereLessThanOrEqualTo(fieldPath, obj);
                } else if (">".equals(str2)) {
                    queryCollectionGroup = queryCollectionGroup.whereGreaterThan(fieldPath, obj);
                } else if (">=".equals(str2)) {
                    queryCollectionGroup = queryCollectionGroup.whereGreaterThanOrEqualTo(fieldPath, obj);
                } else if ("array-contains".equals(str2)) {
                    queryCollectionGroup = queryCollectionGroup.whereArrayContains(fieldPath, obj);
                } else if ("array-contains-any".equals(str2)) {
                    queryCollectionGroup = queryCollectionGroup.whereArrayContainsAny(fieldPath, (List<? extends Object>) obj);
                } else if ("in".equals(str2)) {
                    queryCollectionGroup = queryCollectionGroup.whereIn(fieldPath, (List<? extends Object>) obj);
                } else if ("not-in".equals(str2)) {
                    queryCollectionGroup = queryCollectionGroup.whereNotIn(fieldPath, (List<? extends Object>) obj);
                } else {
                    Log.w("FLTFirestoreMsgCodec", "An invalid query operator " + str2 + " was received but not handled.");
                }
            }
            Long limit = pigeonQueryParameters.getLimit();
            if (limit != null) {
                queryCollectionGroup = queryCollectionGroup.limit(limit.longValue());
            }
            Long limitToLast = pigeonQueryParameters.getLimitToLast();
            if (limitToLast != null) {
                queryCollectionGroup = queryCollectionGroup.limitToLast(limitToLast.longValue());
            }
            List<List<Object>> orderBy = pigeonQueryParameters.getOrderBy();
            if (orderBy == null) {
                return queryCollectionGroup;
            }
            for (List<Object> list2 : orderBy) {
                queryCollectionGroup = queryCollectionGroup.orderBy((FieldPath) list2.get(0), ((Boolean) list2.get(1)).booleanValue() ? Query.Direction.DESCENDING : Query.Direction.ASCENDING);
            }
            List<Object> startAt = pigeonQueryParameters.getStartAt();
            if (startAt != null) {
                Object[] array = startAt.toArray();
                Objects.requireNonNull(array);
                queryCollectionGroup = queryCollectionGroup.startAt(array);
            }
            List<Object> startAfter = pigeonQueryParameters.getStartAfter();
            if (startAfter != null) {
                Object[] array2 = startAfter.toArray();
                Objects.requireNonNull(array2);
                queryCollectionGroup = queryCollectionGroup.startAfter(array2);
            }
            List<Object> endAt = pigeonQueryParameters.getEndAt();
            if (endAt != null) {
                Object[] array3 = endAt.toArray();
                Objects.requireNonNull(array3);
                queryCollectionGroup = queryCollectionGroup.endAt(array3);
            }
            List<Object> endBefore = pigeonQueryParameters.getEndBefore();
            if (endBefore == null) {
                return queryCollectionGroup;
            }
            Object[] array4 = endBefore.toArray();
            Objects.requireNonNull(array4);
            return queryCollectionGroup.endBefore(array4);
        } catch (Exception e4) {
            Log.e("FLTFirestoreMsgCodec", "An error occurred while parsing query arguments, this is most likely an error with this SDK.", e4);
            return null;
        }
    }

    public static GeneratedAndroidFirebaseFirestore.PigeonDocumentChange toPigeonDocumentChange(DocumentChange documentChange, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        GeneratedAndroidFirebaseFirestore.PigeonDocumentChange.Builder builder = new GeneratedAndroidFirebaseFirestore.PigeonDocumentChange.Builder();
        builder.setType(toPigeonDocumentChangeType(documentChange.getType()));
        builder.setOldIndex(Long.valueOf(documentChange.getOldIndex()));
        builder.setNewIndex(Long.valueOf(documentChange.getNewIndex()));
        builder.setDocument(toPigeonDocumentSnapshot(documentChange.getDocument(), serverTimestampBehavior));
        return builder.build();
    }

    public static GeneratedAndroidFirebaseFirestore.DocumentChangeType toPigeonDocumentChangeType(DocumentChange.Type type) {
        int i4 = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$DocumentChange$Type[type.ordinal()];
        if (i4 == 1) {
            return GeneratedAndroidFirebaseFirestore.DocumentChangeType.ADDED;
        }
        if (i4 == 2) {
            return GeneratedAndroidFirebaseFirestore.DocumentChangeType.MODIFIED;
        }
        if (i4 == 3) {
            return GeneratedAndroidFirebaseFirestore.DocumentChangeType.REMOVED;
        }
        throw new IllegalArgumentException("Unknown change type: " + type);
    }

    public static List<GeneratedAndroidFirebaseFirestore.PigeonDocumentChange> toPigeonDocumentChanges(List<DocumentChange> list, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<DocumentChange> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(toPigeonDocumentChange(it.next(), serverTimestampBehavior));
        }
        return arrayList;
    }

    public static GeneratedAndroidFirebaseFirestore.PigeonDocumentSnapshot toPigeonDocumentSnapshot(DocumentSnapshot documentSnapshot, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        GeneratedAndroidFirebaseFirestore.PigeonDocumentSnapshot.Builder builder = new GeneratedAndroidFirebaseFirestore.PigeonDocumentSnapshot.Builder();
        builder.setMetadata(toPigeonSnapshotMetadata(documentSnapshot.getMetadata()));
        builder.setData(documentSnapshot.getData(serverTimestampBehavior));
        builder.setPath(documentSnapshot.getReference().getPath());
        return builder.build();
    }

    public static List<GeneratedAndroidFirebaseFirestore.PigeonDocumentSnapshot> toPigeonDocumentSnapshots(List<DocumentSnapshot> list, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<DocumentSnapshot> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(toPigeonDocumentSnapshot(it.next(), serverTimestampBehavior));
        }
        return arrayList;
    }

    public static GeneratedAndroidFirebaseFirestore.PigeonQuerySnapshot toPigeonQuerySnapshot(QuerySnapshot querySnapshot, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        GeneratedAndroidFirebaseFirestore.PigeonQuerySnapshot.Builder builder = new GeneratedAndroidFirebaseFirestore.PigeonQuerySnapshot.Builder();
        builder.setMetadata(toPigeonSnapshotMetadata(querySnapshot.getMetadata()));
        builder.setDocumentChanges(toPigeonDocumentChanges(querySnapshot.getDocumentChanges(), serverTimestampBehavior));
        builder.setDocuments(toPigeonDocumentSnapshots(querySnapshot.getDocuments(), serverTimestampBehavior));
        return builder.build();
    }

    public static GeneratedAndroidFirebaseFirestore.PigeonSnapshotMetadata toPigeonSnapshotMetadata(SnapshotMetadata snapshotMetadata) {
        GeneratedAndroidFirebaseFirestore.PigeonSnapshotMetadata.Builder builder = new GeneratedAndroidFirebaseFirestore.PigeonSnapshotMetadata.Builder();
        builder.setHasPendingWrites(Boolean.valueOf(snapshotMetadata.hasPendingWrites()));
        builder.setIsFromCache(Boolean.valueOf(snapshotMetadata.isFromCache()));
        return builder.build();
    }
}
