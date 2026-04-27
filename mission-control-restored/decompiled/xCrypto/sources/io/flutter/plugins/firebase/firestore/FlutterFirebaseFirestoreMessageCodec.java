package io.flutter.plugins.firebase.firestore;

import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.Blob;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.Filter;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.LoadBundleTaskProgress;
import com.google.firebase.firestore.MemoryCacheSettings;
import com.google.firebase.firestore.PersistentCacheSettings;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SnapshotMetadata;
import com.google.firebase.firestore.VectorValue;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.firebase.analytics.Constants;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
class FlutterFirebaseFirestoreMessageCodec extends StandardMessageCodec {
    private static final byte DATA_TYPE_ARRAY_REMOVE = -71;
    private static final byte DATA_TYPE_ARRAY_UNION = -72;
    private static final byte DATA_TYPE_BLOB = -73;
    private static final byte DATA_TYPE_DATE_TIME = -76;
    private static final byte DATA_TYPE_DELETE = -70;
    private static final byte DATA_TYPE_DOCUMENT_ID = -65;
    private static final byte DATA_TYPE_DOCUMENT_REFERENCE = -74;
    private static final byte DATA_TYPE_FIELD_PATH = -64;
    private static final byte DATA_TYPE_FIRESTORE_INSTANCE = -60;
    private static final byte DATA_TYPE_FIRESTORE_QUERY = -59;
    private static final byte DATA_TYPE_FIRESTORE_SETTINGS = -58;
    private static final byte DATA_TYPE_GEO_POINT = -75;
    private static final byte DATA_TYPE_INCREMENT_DOUBLE = -67;
    private static final byte DATA_TYPE_INCREMENT_INTEGER = -66;
    private static final byte DATA_TYPE_INFINITY = -62;
    private static final byte DATA_TYPE_NAN = -63;
    private static final byte DATA_TYPE_NEGATIVE_INFINITY = -61;
    private static final byte DATA_TYPE_SERVER_TIMESTAMP = -69;
    private static final byte DATA_TYPE_TIMESTAMP = -68;
    private static final byte DATA_TYPE_VECTOR_VALUE = -57;
    public static final FlutterFirebaseFirestoreMessageCodec INSTANCE = new FlutterFirebaseFirestoreMessageCodec();

    /* JADX INFO: renamed from: io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestoreMessageCodec$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$DocumentChange$Type;
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$LoadBundleTaskProgress$TaskState;

        static {
            int[] iArr = new int[LoadBundleTaskProgress.TaskState.values().length];
            $SwitchMap$com$google$firebase$firestore$LoadBundleTaskProgress$TaskState = iArr;
            try {
                iArr[LoadBundleTaskProgress.TaskState.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$LoadBundleTaskProgress$TaskState[LoadBundleTaskProgress.TaskState.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$LoadBundleTaskProgress$TaskState[LoadBundleTaskProgress.TaskState.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[DocumentChange.Type.values().length];
            $SwitchMap$com$google$firebase$firestore$DocumentChange$Type = iArr2;
            try {
                iArr2[DocumentChange.Type.ADDED.ordinal()] = 1;
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
        }
    }

    private Filter filterFromJson(Map<String, Object> map) {
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

    private FirebaseFirestore readFirestoreInstance(ByteBuffer byteBuffer) {
        String str = (String) readValue(byteBuffer);
        String str2 = (String) readValue(byteBuffer);
        FirebaseFirestoreSettings firebaseFirestoreSettings = (FirebaseFirestoreSettings) readValue(byteBuffer);
        synchronized (FlutterFirebaseFirestorePlugin.firestoreInstanceCache) {
            try {
                FirebaseFirestore firestoreInstanceByNameAndDatabaseUrl = FlutterFirebaseFirestorePlugin.getFirestoreInstanceByNameAndDatabaseUrl(str, str2);
                if (firestoreInstanceByNameAndDatabaseUrl != null) {
                    return firestoreInstanceByNameAndDatabaseUrl;
                }
                FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance(FirebaseApp.getInstance(str), str2);
                firebaseFirestore.setFirestoreSettings(firebaseFirestoreSettings);
                FlutterFirebaseFirestorePlugin.setCachedFirebaseFirestoreInstanceForKey(firebaseFirestore, str2);
                return firebaseFirestore;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private Query readFirestoreQuery(ByteBuffer byteBuffer) {
        try {
            Map map = (Map) readValue(byteBuffer);
            Object obj = map.get("firestore");
            Objects.requireNonNull(obj);
            FirebaseFirestore firebaseFirestore = (FirebaseFirestore) obj;
            Object obj2 = map.get("path");
            Objects.requireNonNull(obj2);
            String str = (String) obj2;
            boolean zBooleanValue = ((Boolean) map.get("isCollectionGroup")).booleanValue();
            Map map2 = (Map) map.get(Constants.PARAMETERS);
            Query queryCollectionGroup = zBooleanValue ? firebaseFirestore.collectionGroup(str) : firebaseFirestore.collection(str);
            if (map2 == null) {
                return queryCollectionGroup;
            }
            if (map2.containsKey("filters")) {
                Object obj3 = map2.get("filters");
                Objects.requireNonNull(obj3);
                queryCollectionGroup = queryCollectionGroup.where(filterFromJson((Map) obj3));
            }
            Object obj4 = map2.get("where");
            Objects.requireNonNull(obj4);
            for (List list : (List) obj4) {
                FieldPath fieldPath = (FieldPath) list.get(0);
                String str2 = (String) list.get(1);
                Object obj5 = list.get(2);
                if ("==".equals(str2)) {
                    queryCollectionGroup = queryCollectionGroup.whereEqualTo(fieldPath, obj5);
                } else if ("!=".equals(str2)) {
                    queryCollectionGroup = queryCollectionGroup.whereNotEqualTo(fieldPath, obj5);
                } else if ("<".equals(str2)) {
                    queryCollectionGroup = queryCollectionGroup.whereLessThan(fieldPath, obj5);
                } else if ("<=".equals(str2)) {
                    queryCollectionGroup = queryCollectionGroup.whereLessThanOrEqualTo(fieldPath, obj5);
                } else if (">".equals(str2)) {
                    queryCollectionGroup = queryCollectionGroup.whereGreaterThan(fieldPath, obj5);
                } else if (">=".equals(str2)) {
                    queryCollectionGroup = queryCollectionGroup.whereGreaterThanOrEqualTo(fieldPath, obj5);
                } else if ("array-contains".equals(str2)) {
                    queryCollectionGroup = queryCollectionGroup.whereArrayContains(fieldPath, obj5);
                } else if ("array-contains-any".equals(str2)) {
                    queryCollectionGroup = queryCollectionGroup.whereArrayContainsAny(fieldPath, (List<? extends Object>) obj5);
                } else if ("in".equals(str2)) {
                    queryCollectionGroup = queryCollectionGroup.whereIn(fieldPath, (List<? extends Object>) obj5);
                } else if ("not-in".equals(str2)) {
                    queryCollectionGroup = queryCollectionGroup.whereNotIn(fieldPath, (List<? extends Object>) obj5);
                } else {
                    Log.w("FLTFirestoreMsgCodec", "An invalid query operator " + str2 + " was received but not handled.");
                }
            }
            Number number = (Number) map2.get("limit");
            if (number != null) {
                queryCollectionGroup = queryCollectionGroup.limit(number.longValue());
            }
            Number number2 = (Number) map2.get("limitToLast");
            if (number2 != null) {
                queryCollectionGroup = queryCollectionGroup.limitToLast(number2.longValue());
            }
            List<List> list2 = (List) map2.get("orderBy");
            if (list2 == null) {
                return queryCollectionGroup;
            }
            for (List list3 : list2) {
                queryCollectionGroup = queryCollectionGroup.orderBy((FieldPath) list3.get(0), ((Boolean) list3.get(1)).booleanValue() ? Query.Direction.DESCENDING : Query.Direction.ASCENDING);
            }
            List list4 = (List) map2.get("startAt");
            if (list4 != null) {
                Object[] array = list4.toArray();
                Objects.requireNonNull(array);
                queryCollectionGroup = queryCollectionGroup.startAt(array);
            }
            List list5 = (List) map2.get("startAfter");
            if (list5 != null) {
                Object[] array2 = list5.toArray();
                Objects.requireNonNull(array2);
                queryCollectionGroup = queryCollectionGroup.startAfter(array2);
            }
            List list6 = (List) map2.get("endAt");
            if (list6 != null) {
                Object[] array3 = list6.toArray();
                Objects.requireNonNull(array3);
                queryCollectionGroup = queryCollectionGroup.endAt(array3);
            }
            List list7 = (List) map2.get("endBefore");
            if (list7 == null) {
                return queryCollectionGroup;
            }
            Object[] array4 = list7.toArray();
            Objects.requireNonNull(array4);
            return queryCollectionGroup.endBefore(array4);
        } catch (Exception e4) {
            Log.e("FLTFirestoreMsgCodec", "An error occurred while parsing query arguments, this is most likely an error with this SDK.", e4);
            return null;
        }
    }

    private FirebaseFirestoreSettings readFirestoreSettings(ByteBuffer byteBuffer) {
        Map map = (Map) readValue(byteBuffer);
        FirebaseFirestoreSettings.Builder builder = new FirebaseFirestoreSettings.Builder();
        if (map.get("persistenceEnabled") != null) {
            if (Boolean.TRUE.equals((Boolean) map.get("persistenceEnabled"))) {
                PersistentCacheSettings.Builder builderNewBuilder = PersistentCacheSettings.newBuilder();
                if (map.get("cacheSizeBytes") != null) {
                    Long lValueOf = 104857600L;
                    Object obj = map.get("cacheSizeBytes");
                    if (obj instanceof Long) {
                        lValueOf = (Long) obj;
                    } else if (obj instanceof Integer) {
                        lValueOf = Long.valueOf(((Integer) obj).intValue());
                    }
                    if (lValueOf.longValue() == -1) {
                        builderNewBuilder.setSizeBytes(-1L);
                    } else {
                        builderNewBuilder.setSizeBytes(lValueOf.longValue());
                    }
                }
                builder.setLocalCacheSettings(builderNewBuilder.build());
            } else {
                builder.setLocalCacheSettings(MemoryCacheSettings.newBuilder().build());
            }
        }
        if (map.get(DiagnosticsTracker.HOST_KEY) != null) {
            Object obj2 = map.get(DiagnosticsTracker.HOST_KEY);
            Objects.requireNonNull(obj2);
            builder.setHost((String) obj2);
            if (map.get("sslEnabled") != null) {
                Object obj3 = map.get("sslEnabled");
                Objects.requireNonNull(obj3);
                builder.setSslEnabled(((Boolean) obj3).booleanValue());
            }
        }
        return builder.build();
    }

    private Object[] toArray(Object obj) {
        if (obj instanceof List) {
            return ((List) obj).toArray();
        }
        if (obj == null) {
            return new ArrayList().toArray();
        }
        throw new IllegalArgumentException(String.format("java.util.List was expected, unable to convert '%s' to an object array", obj.getClass().getCanonicalName()));
    }

    private void writeDocumentChange(ByteArrayOutputStream byteArrayOutputStream, DocumentChange documentChange) {
        HashMap map = new HashMap();
        int i4 = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$DocumentChange$Type[documentChange.getType().ordinal()];
        map.put("type", i4 != 1 ? i4 != 2 ? i4 != 3 ? null : "DocumentChangeType.removed" : "DocumentChangeType.modified" : "DocumentChangeType.added");
        map.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, documentChange.getDocument().getData());
        map.put("path", documentChange.getDocument().getReference().getPath());
        map.put("oldIndex", Integer.valueOf(documentChange.getOldIndex()));
        map.put("newIndex", Integer.valueOf(documentChange.getNewIndex()));
        map.put("metadata", documentChange.getDocument().getMetadata());
        writeValue(byteArrayOutputStream, map);
    }

    private void writeDocumentSnapshot(ByteArrayOutputStream byteArrayOutputStream, DocumentSnapshot documentSnapshot) {
        HashMap map = new HashMap();
        map.put("path", documentSnapshot.getReference().getPath());
        if (documentSnapshot.exists()) {
            DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior = FlutterFirebaseFirestorePlugin.serverTimestampBehaviorHashMap.get(Integer.valueOf(documentSnapshot.hashCode()));
            if (serverTimestampBehavior != null) {
                map.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, documentSnapshot.getData(serverTimestampBehavior));
            } else {
                map.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, documentSnapshot.getData());
            }
        } else {
            map.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, null);
        }
        map.put("metadata", documentSnapshot.getMetadata());
        FlutterFirebaseFirestorePlugin.serverTimestampBehaviorHashMap.remove(Integer.valueOf(documentSnapshot.hashCode()));
        writeValue(byteArrayOutputStream, map);
    }

    private void writeLoadBundleTaskProgress(ByteArrayOutputStream byteArrayOutputStream, LoadBundleTaskProgress loadBundleTaskProgress) {
        HashMap map = new HashMap();
        map.put("bytesLoaded", Long.valueOf(loadBundleTaskProgress.getBytesLoaded()));
        map.put("documentsLoaded", Integer.valueOf(loadBundleTaskProgress.getDocumentsLoaded()));
        map.put("totalBytes", Long.valueOf(loadBundleTaskProgress.getTotalBytes()));
        map.put("totalDocuments", Integer.valueOf(loadBundleTaskProgress.getTotalDocuments()));
        int i4 = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$LoadBundleTaskProgress$TaskState[loadBundleTaskProgress.getTaskState().ordinal()];
        String str = "running";
        if (i4 != 1) {
            if (i4 == 2) {
                str = "success";
            } else if (i4 == 3) {
                str = com.google.firebase.messaging.Constants.IPC_BUNDLE_KEY_SEND_ERROR;
            }
        }
        map.put("taskState", str);
        writeValue(byteArrayOutputStream, map);
    }

    private void writeQuerySnapshot(ByteArrayOutputStream byteArrayOutputStream, QuerySnapshot querySnapshot) {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior = FlutterFirebaseFirestorePlugin.serverTimestampBehaviorHashMap.get(Integer.valueOf(querySnapshot.hashCode()));
        for (DocumentSnapshot documentSnapshot : querySnapshot.getDocuments()) {
            arrayList.add(documentSnapshot.getReference().getPath());
            if (serverTimestampBehavior != null) {
                arrayList2.add(documentSnapshot.getData(serverTimestampBehavior));
            } else {
                arrayList2.add(documentSnapshot.getData());
            }
            arrayList3.add(documentSnapshot.getMetadata());
        }
        map.put("paths", arrayList);
        map.put("documents", arrayList2);
        map.put("metadatas", arrayList3);
        map.put("documentChanges", querySnapshot.getDocumentChanges());
        map.put("metadata", querySnapshot.getMetadata());
        FlutterFirebaseFirestorePlugin.serverTimestampBehaviorHashMap.remove(Integer.valueOf(querySnapshot.hashCode()));
        writeValue(byteArrayOutputStream, map);
    }

    private void writeSnapshotMetadata(ByteArrayOutputStream byteArrayOutputStream, SnapshotMetadata snapshotMetadata) {
        HashMap map = new HashMap();
        map.put("hasPendingWrites", Boolean.valueOf(snapshotMetadata.hasPendingWrites()));
        map.put("isFromCache", Boolean.valueOf(snapshotMetadata.isFromCache()));
        writeValue(byteArrayOutputStream, map);
    }

    @Override // io.flutter.plugin.common.StandardMessageCodec
    public Object readValueOfType(byte b4, ByteBuffer byteBuffer) {
        switch (b4) {
            case -76:
                return new Date(byteBuffer.getLong());
            case -75:
                StandardMessageCodec.readAlignment(byteBuffer, 8);
                return new GeoPoint(byteBuffer.getDouble(), byteBuffer.getDouble());
            case -74:
                return ((FirebaseFirestore) readValue(byteBuffer)).document((String) readValue(byteBuffer));
            case -73:
                return Blob.fromBytes(StandardMessageCodec.readBytes(byteBuffer));
            case -72:
                return FieldValue.arrayUnion(toArray(readValue(byteBuffer)));
            case -71:
                return FieldValue.arrayRemove(toArray(readValue(byteBuffer)));
            case -70:
                return FieldValue.delete();
            case -69:
                return FieldValue.serverTimestamp();
            case -68:
                return new Timestamp(byteBuffer.getLong(), byteBuffer.getInt());
            case -67:
                return FieldValue.increment(((Number) readValue(byteBuffer)).doubleValue());
            case -66:
                return FieldValue.increment(((Number) readValue(byteBuffer)).intValue());
            case -65:
                return FieldPath.documentId();
            case -64:
                int size = StandardMessageCodec.readSize(byteBuffer);
                ArrayList arrayList = new ArrayList(size);
                for (int i4 = 0; i4 < size; i4++) {
                    arrayList.add(readValue(byteBuffer));
                }
                return FieldPath.of((String[]) arrayList.toArray(new String[0]));
            case -63:
                return Double.valueOf(Double.NaN);
            case -62:
                return Double.valueOf(Double.POSITIVE_INFINITY);
            case -61:
                return Double.valueOf(Double.NEGATIVE_INFINITY);
            case -60:
                return readFirestoreInstance(byteBuffer);
            case -59:
                return readFirestoreQuery(byteBuffer);
            case -58:
                return readFirestoreSettings(byteBuffer);
            case -57:
                ArrayList arrayList2 = (ArrayList) readValue(byteBuffer);
                double[] dArr = new double[arrayList2.size()];
                for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                    Double d4 = (Double) arrayList2.get(i5);
                    Objects.requireNonNull(d4, "Null value at index " + i5);
                    dArr[i5] = d4.doubleValue();
                }
                return FieldValue.vector(dArr);
            default:
                return super.readValueOfType(b4, byteBuffer);
        }
    }

    @Override // io.flutter.plugin.common.StandardMessageCodec
    public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        String databaseURL;
        if (obj instanceof Date) {
            byteArrayOutputStream.write(-76);
            StandardMessageCodec.writeLong(byteArrayOutputStream, ((Date) obj).getTime());
            return;
        }
        if (obj instanceof Timestamp) {
            byteArrayOutputStream.write(-68);
            Timestamp timestamp = (Timestamp) obj;
            StandardMessageCodec.writeLong(byteArrayOutputStream, timestamp.getSeconds());
            StandardMessageCodec.writeInt(byteArrayOutputStream, timestamp.getNanoseconds());
            return;
        }
        if (obj instanceof GeoPoint) {
            byteArrayOutputStream.write(-75);
            StandardMessageCodec.writeAlignment(byteArrayOutputStream, 8);
            GeoPoint geoPoint = (GeoPoint) obj;
            StandardMessageCodec.writeDouble(byteArrayOutputStream, geoPoint.getLatitude());
            StandardMessageCodec.writeDouble(byteArrayOutputStream, geoPoint.getLongitude());
            return;
        }
        if (obj instanceof VectorValue) {
            byteArrayOutputStream.write(-57);
            writeValue(byteArrayOutputStream, ((VectorValue) obj).toArray());
            return;
        }
        if (obj instanceof DocumentReference) {
            byteArrayOutputStream.write(-74);
            DocumentReference documentReference = (DocumentReference) obj;
            FirebaseFirestore firestore = documentReference.getFirestore();
            writeValue(byteArrayOutputStream, firestore.getApp().getName());
            writeValue(byteArrayOutputStream, documentReference.getPath());
            synchronized (FlutterFirebaseFirestorePlugin.firestoreInstanceCache) {
                databaseURL = FlutterFirebaseFirestorePlugin.getCachedFirebaseFirestoreInstanceForKey(firestore).getDatabaseURL();
            }
            writeValue(byteArrayOutputStream, databaseURL);
            return;
        }
        if (obj instanceof DocumentSnapshot) {
            writeDocumentSnapshot(byteArrayOutputStream, (DocumentSnapshot) obj);
            return;
        }
        if (obj instanceof QuerySnapshot) {
            writeQuerySnapshot(byteArrayOutputStream, (QuerySnapshot) obj);
            return;
        }
        if (obj instanceof DocumentChange) {
            writeDocumentChange(byteArrayOutputStream, (DocumentChange) obj);
            return;
        }
        if (obj instanceof LoadBundleTaskProgress) {
            writeLoadBundleTaskProgress(byteArrayOutputStream, (LoadBundleTaskProgress) obj);
            return;
        }
        if (obj instanceof SnapshotMetadata) {
            writeSnapshotMetadata(byteArrayOutputStream, (SnapshotMetadata) obj);
            return;
        }
        if (obj instanceof Blob) {
            byteArrayOutputStream.write(-73);
            StandardMessageCodec.writeBytes(byteArrayOutputStream, ((Blob) obj).toBytes());
            return;
        }
        if (!(obj instanceof Double)) {
            super.writeValue(byteArrayOutputStream, obj);
            return;
        }
        Double d4 = (Double) obj;
        if (Double.isNaN(d4.doubleValue())) {
            byteArrayOutputStream.write(-63);
            return;
        }
        if (d4.equals(Double.valueOf(Double.NEGATIVE_INFINITY))) {
            byteArrayOutputStream.write(-61);
        } else if (d4.equals(Double.valueOf(Double.POSITIVE_INFINITY))) {
            byteArrayOutputStream.write(-62);
        } else {
            super.writeValue(byteArrayOutputStream, obj);
        }
    }
}
