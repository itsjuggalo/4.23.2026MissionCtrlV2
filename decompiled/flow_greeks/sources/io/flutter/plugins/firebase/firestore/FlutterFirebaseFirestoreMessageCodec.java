package io.flutter.plugins.firebase.firestore;

import android.util.Log;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.d;
import com.google.firebase.firestore.g;
import com.google.firebase.firestore.i;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import d9.g;
import d9.h1;
import d9.s1;
import d9.w0;
import d9.y0;
import d9.y1;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.firebase.database.Constants;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$DocumentChange$Type;
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$LoadBundleTaskProgress$TaskState;

        static {
            int[] iArr = new int[w0.a.values().length];
            $SwitchMap$com$google$firebase$firestore$LoadBundleTaskProgress$TaskState = iArr;
            try {
                iArr[w0.a.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$LoadBundleTaskProgress$TaskState[w0.a.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$LoadBundleTaskProgress$TaskState[w0.a.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[g.b.values().length];
            $SwitchMap$com$google$firebase$firestore$DocumentChange$Type = iArr2;
            try {
                iArr2[g.b.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$DocumentChange$Type[g.b.MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$DocumentChange$Type[g.b.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private com.google.firebase.firestore.e filterFromJson(Map<String, Object> map) {
        d9.t tVar;
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
                return com.google.firebase.firestore.e.l((com.google.firebase.firestore.e[]) arrayList.toArray(new com.google.firebase.firestore.e[0]));
            }
            if (str.equals("AND")) {
                return com.google.firebase.firestore.e.a((com.google.firebase.firestore.e[]) arrayList.toArray(new com.google.firebase.firestore.e[0]));
            }
            throw new Error("Invalid operator");
        }
        String str2 = (String) map.get("op");
        tVar = (d9.t) map.get("fieldPath");
        obj = map.get("value");
        str2.getClass();
        switch (str2) {
            case "not-in":
                return com.google.firebase.firestore.e.k(tVar, (List) obj);
            case "<":
                return com.google.firebase.firestore.e.h(tVar, obj);
            case ">":
                return com.google.firebase.firestore.e.e(tVar, obj);
            case "!=":
                return com.google.firebase.firestore.e.j(tVar, obj);
            case "<=":
                return com.google.firebase.firestore.e.i(tVar, obj);
            case "==":
                return com.google.firebase.firestore.e.d(tVar, obj);
            case ">=":
                return com.google.firebase.firestore.e.f(tVar, obj);
            case "in":
                return com.google.firebase.firestore.e.g(tVar, (List) obj);
            case "array-contains":
                return com.google.firebase.firestore.e.b(tVar, obj);
            case "array-contains-any":
                return com.google.firebase.firestore.e.c(tVar, (List) obj);
            default:
                throw new Error("Invalid operator");
        }
    }

    private FirebaseFirestore readFirestoreInstance(ByteBuffer byteBuffer) {
        String str = (String) readValue(byteBuffer);
        String str2 = (String) readValue(byteBuffer);
        com.google.firebase.firestore.g gVar = (com.google.firebase.firestore.g) readValue(byteBuffer);
        synchronized (FlutterFirebaseFirestorePlugin.firestoreInstanceCache) {
            try {
                FirebaseFirestore firestoreInstanceByNameAndDatabaseUrl = FlutterFirebaseFirestorePlugin.getFirestoreInstanceByNameAndDatabaseUrl(str, str2);
                if (firestoreInstanceByNameAndDatabaseUrl != null) {
                    return firestoreInstanceByNameAndDatabaseUrl;
                }
                FirebaseFirestore firebaseFirestoreC = FirebaseFirestore.C(a7.g.p(str), str2);
                firebaseFirestoreC.N(gVar);
                FlutterFirebaseFirestorePlugin.setCachedFirebaseFirestoreInstanceForKey(firebaseFirestoreC, str2);
                return firebaseFirestoreC;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private com.google.firebase.firestore.i readFirestoreQuery(ByteBuffer byteBuffer) {
        try {
            Map map = (Map) readValue(byteBuffer);
            Object obj = map.get("firestore");
            Objects.requireNonNull(obj);
            FirebaseFirestore firebaseFirestore = (FirebaseFirestore) obj;
            Object obj2 = map.get(Constants.PATH);
            Objects.requireNonNull(obj2);
            String str = (String) obj2;
            boolean zBooleanValue = ((Boolean) map.get("isCollectionGroup")).booleanValue();
            Map map2 = (Map) map.get(io.flutter.plugins.firebase.analytics.Constants.PARAMETERS);
            com.google.firebase.firestore.i iVarW = zBooleanValue ? firebaseFirestore.w(str) : firebaseFirestore.v(str);
            if (map2 == null) {
                return iVarW;
            }
            if (map2.containsKey("filters")) {
                Object obj3 = map2.get("filters");
                Objects.requireNonNull(obj3);
                iVarW = iVarW.G(filterFromJson((Map) obj3));
            }
            Object obj4 = map2.get("where");
            Objects.requireNonNull(obj4);
            for (List list : (List) obj4) {
                d9.t tVar = (d9.t) list.get(0);
                String str2 = (String) list.get(1);
                Object obj5 = list.get(2);
                if ("==".equals(str2)) {
                    iVarW = iVarW.J(tVar, obj5);
                } else if ("!=".equals(str2)) {
                    iVarW = iVarW.P(tVar, obj5);
                } else if ("<".equals(str2)) {
                    iVarW = iVarW.N(tVar, obj5);
                } else if ("<=".equals(str2)) {
                    iVarW = iVarW.O(tVar, obj5);
                } else if (">".equals(str2)) {
                    iVarW = iVarW.K(tVar, obj5);
                } else if (">=".equals(str2)) {
                    iVarW = iVarW.L(tVar, obj5);
                } else if ("array-contains".equals(str2)) {
                    iVarW = iVarW.H(tVar, obj5);
                } else if ("array-contains-any".equals(str2)) {
                    iVarW = iVarW.I(tVar, (List) obj5);
                } else if ("in".equals(str2)) {
                    iVarW = iVarW.M(tVar, (List) obj5);
                } else if ("not-in".equals(str2)) {
                    iVarW = iVarW.Q(tVar, (List) obj5);
                } else {
                    Log.w("FLTFirestoreMsgCodec", "An invalid query operator " + str2 + " was received but not handled.");
                }
            }
            Number number = (Number) map2.get(Constants.LIMIT);
            if (number != null) {
                iVarW = iVarW.s(number.longValue());
            }
            Number number2 = (Number) map2.get(Constants.LIMIT_TO_LAST);
            if (number2 != null) {
                iVarW = iVarW.t(number2.longValue());
            }
            List<List> list2 = (List) map2.get(Constants.ORDER_BY);
            if (list2 == null) {
                return iVarW;
            }
            for (List list3 : list2) {
                iVarW = iVarW.u((d9.t) list3.get(0), ((Boolean) list3.get(1)).booleanValue() ? i.c.DESCENDING : i.c.ASCENDING);
            }
            List list4 = (List) map2.get(Constants.START_AT);
            if (list4 != null) {
                Object[] array = list4.toArray();
                Objects.requireNonNull(array);
                iVarW = iVarW.B(array);
            }
            List list5 = (List) map2.get(Constants.START_AFTER);
            if (list5 != null) {
                Object[] array2 = list5.toArray();
                Objects.requireNonNull(array2);
                iVarW = iVarW.A(array2);
            }
            List list6 = (List) map2.get(Constants.END_AT);
            if (list6 != null) {
                Object[] array3 = list6.toArray();
                Objects.requireNonNull(array3);
                iVarW = iVarW.l(array3);
            }
            List list7 = (List) map2.get(Constants.END_BEFORE);
            if (list7 == null) {
                return iVarW;
            }
            Object[] array4 = list7.toArray();
            Objects.requireNonNull(array4);
            return iVarW.m(array4);
        } catch (Exception e10) {
            Log.e("FLTFirestoreMsgCodec", "An error occurred while parsing query arguments, this is most likely an error with this SDK.", e10);
            return null;
        }
    }

    private com.google.firebase.firestore.g readFirestoreSettings(ByteBuffer byteBuffer) {
        Map map = (Map) readValue(byteBuffer);
        g.b bVar = new g.b();
        if (map.get(Constants.DATABASE_PERSISTENCE_ENABLED) != null) {
            if (Boolean.TRUE.equals((Boolean) map.get(Constants.DATABASE_PERSISTENCE_ENABLED))) {
                h1.b bVarB = h1.b();
                if (map.get(Constants.DATABASE_CACHE_SIZE_BYTES) != null) {
                    Long lValueOf = 104857600L;
                    Object obj = map.get(Constants.DATABASE_CACHE_SIZE_BYTES);
                    if (obj instanceof Long) {
                        lValueOf = (Long) obj;
                    } else if (obj instanceof Integer) {
                        lValueOf = Long.valueOf(((Integer) obj).intValue());
                    }
                    if (lValueOf.longValue() == -1) {
                        bVarB.b(-1L);
                    } else {
                        bVarB.b(lValueOf.longValue());
                    }
                }
                bVar.h(bVarB.a());
            } else {
                bVar.h(y0.b().a());
            }
        }
        if (map.get(DiagnosticsTracker.HOST_KEY) != null) {
            Object obj2 = map.get(DiagnosticsTracker.HOST_KEY);
            Objects.requireNonNull(obj2);
            bVar.g((String) obj2);
            if (map.get("sslEnabled") != null) {
                Object obj3 = map.get("sslEnabled");
                Objects.requireNonNull(obj3);
                bVar.i(((Boolean) obj3).booleanValue());
            }
        }
        return bVar.f();
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

    private void writeDocumentChange(ByteArrayOutputStream byteArrayOutputStream, d9.g gVar) {
        HashMap map = new HashMap();
        int i10 = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$DocumentChange$Type[gVar.e().ordinal()];
        map.put("type", i10 != 1 ? i10 != 2 ? i10 != 3 ? null : "DocumentChangeType.removed" : "DocumentChangeType.modified" : "DocumentChangeType.added");
        map.put("data", gVar.b().d());
        map.put(Constants.PATH, gVar.b().g().r());
        map.put("oldIndex", Integer.valueOf(gVar.d()));
        map.put("newIndex", Integer.valueOf(gVar.c()));
        map.put("metadata", gVar.b().f());
        writeValue(byteArrayOutputStream, map);
    }

    private void writeDocumentSnapshot(ByteArrayOutputStream byteArrayOutputStream, com.google.firebase.firestore.d dVar) {
        HashMap map = new HashMap();
        map.put(Constants.PATH, dVar.g().r());
        if (dVar.a()) {
            d.a aVar = FlutterFirebaseFirestorePlugin.serverTimestampBehaviorHashMap.get(Integer.valueOf(dVar.hashCode()));
            if (aVar != null) {
                map.put("data", dVar.e(aVar));
            } else {
                map.put("data", dVar.d());
            }
        } else {
            map.put("data", null);
        }
        map.put("metadata", dVar.f());
        FlutterFirebaseFirestorePlugin.serverTimestampBehaviorHashMap.remove(Integer.valueOf(dVar.hashCode()));
        writeValue(byteArrayOutputStream, map);
    }

    private void writeLoadBundleTaskProgress(ByteArrayOutputStream byteArrayOutputStream, w0 w0Var) {
        HashMap map = new HashMap();
        map.put("bytesLoaded", Long.valueOf(w0Var.c()));
        map.put("documentsLoaded", Integer.valueOf(w0Var.d()));
        map.put("totalBytes", Long.valueOf(w0Var.f()));
        map.put("totalDocuments", Integer.valueOf(w0Var.g()));
        int i10 = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$LoadBundleTaskProgress$TaskState[w0Var.e().ordinal()];
        String str = "running";
        if (i10 != 1) {
            if (i10 == 2) {
                str = "success";
            } else if (i10 == 3) {
                str = "error";
            }
        }
        map.put("taskState", str);
        writeValue(byteArrayOutputStream, map);
    }

    private void writeQuerySnapshot(ByteArrayOutputStream byteArrayOutputStream, com.google.firebase.firestore.k kVar) {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        d.a aVar = FlutterFirebaseFirestorePlugin.serverTimestampBehaviorHashMap.get(Integer.valueOf(kVar.hashCode()));
        for (com.google.firebase.firestore.d dVar : kVar.f()) {
            arrayList.add(dVar.g().r());
            if (aVar != null) {
                arrayList2.add(dVar.e(aVar));
            } else {
                arrayList2.add(dVar.d());
            }
            arrayList3.add(dVar.f());
        }
        map.put("paths", arrayList);
        map.put("documents", arrayList2);
        map.put("metadatas", arrayList3);
        map.put("documentChanges", kVar.d());
        map.put("metadata", kVar.g());
        FlutterFirebaseFirestorePlugin.serverTimestampBehaviorHashMap.remove(Integer.valueOf(kVar.hashCode()));
        writeValue(byteArrayOutputStream, map);
    }

    private void writeSnapshotMetadata(ByteArrayOutputStream byteArrayOutputStream, s1 s1Var) {
        HashMap map = new HashMap();
        map.put("hasPendingWrites", Boolean.valueOf(s1Var.a()));
        map.put("isFromCache", Boolean.valueOf(s1Var.b()));
        writeValue(byteArrayOutputStream, map);
    }

    @Override // io.flutter.plugin.common.StandardMessageCodec
    public Object readValueOfType(byte b10, ByteBuffer byteBuffer) {
        switch (b10) {
            case -76:
                return new Date(byteBuffer.getLong());
            case -75:
                StandardMessageCodec.readAlignment(byteBuffer, 8);
                return new d9.q0(byteBuffer.getDouble(), byteBuffer.getDouble());
            case -74:
                return ((FirebaseFirestore) readValue(byteBuffer)).y((String) readValue(byteBuffer));
            case -73:
                return d9.e.c(StandardMessageCodec.readBytes(byteBuffer));
            case -72:
                return d9.u.b(toArray(readValue(byteBuffer)));
            case -71:
                return d9.u.a(toArray(readValue(byteBuffer)));
            case -70:
                return d9.u.c();
            case -69:
                return d9.u.g();
            case -68:
                return new a7.s(byteBuffer.getLong(), byteBuffer.getInt());
            case -67:
                return d9.u.e(((Number) readValue(byteBuffer)).doubleValue());
            case -66:
                return d9.u.f(((Number) readValue(byteBuffer)).intValue());
            case -65:
                return d9.t.a();
            case -64:
                int size = StandardMessageCodec.readSize(byteBuffer);
                ArrayList arrayList = new ArrayList(size);
                for (int i10 = 0; i10 < size; i10++) {
                    arrayList.add(readValue(byteBuffer));
                }
                return d9.t.d((String[]) arrayList.toArray(new String[0]));
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
                for (int i11 = 0; i11 < arrayList2.size(); i11++) {
                    Double d10 = (Double) arrayList2.get(i11);
                    Objects.requireNonNull(d10, "Null value at index " + i11);
                    dArr[i11] = d10.doubleValue();
                }
                return d9.u.h(dArr);
            default:
                return super.readValueOfType(b10, byteBuffer);
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
        if (obj instanceof a7.s) {
            byteArrayOutputStream.write(-68);
            a7.s sVar = (a7.s) obj;
            StandardMessageCodec.writeLong(byteArrayOutputStream, sVar.h());
            StandardMessageCodec.writeInt(byteArrayOutputStream, sVar.b());
            return;
        }
        if (obj instanceof d9.q0) {
            byteArrayOutputStream.write(-75);
            StandardMessageCodec.writeAlignment(byteArrayOutputStream, 8);
            d9.q0 q0Var = (d9.q0) obj;
            StandardMessageCodec.writeDouble(byteArrayOutputStream, q0Var.b());
            StandardMessageCodec.writeDouble(byteArrayOutputStream, q0Var.c());
            return;
        }
        if (obj instanceof y1) {
            byteArrayOutputStream.write(-57);
            writeValue(byteArrayOutputStream, ((y1) obj).a());
            return;
        }
        if (obj instanceof com.google.firebase.firestore.c) {
            byteArrayOutputStream.write(-74);
            com.google.firebase.firestore.c cVar = (com.google.firebase.firestore.c) obj;
            FirebaseFirestore firebaseFirestoreP = cVar.p();
            writeValue(byteArrayOutputStream, firebaseFirestoreP.A().q());
            writeValue(byteArrayOutputStream, cVar.r());
            synchronized (FlutterFirebaseFirestorePlugin.firestoreInstanceCache) {
                databaseURL = FlutterFirebaseFirestorePlugin.getCachedFirebaseFirestoreInstanceForKey(firebaseFirestoreP).getDatabaseURL();
            }
            writeValue(byteArrayOutputStream, databaseURL);
            return;
        }
        if (obj instanceof com.google.firebase.firestore.d) {
            writeDocumentSnapshot(byteArrayOutputStream, (com.google.firebase.firestore.d) obj);
            return;
        }
        if (obj instanceof com.google.firebase.firestore.k) {
            writeQuerySnapshot(byteArrayOutputStream, (com.google.firebase.firestore.k) obj);
            return;
        }
        if (obj instanceof d9.g) {
            writeDocumentChange(byteArrayOutputStream, (d9.g) obj);
            return;
        }
        if (obj instanceof w0) {
            writeLoadBundleTaskProgress(byteArrayOutputStream, (w0) obj);
            return;
        }
        if (obj instanceof s1) {
            writeSnapshotMetadata(byteArrayOutputStream, (s1) obj);
            return;
        }
        if (obj instanceof d9.e) {
            byteArrayOutputStream.write(-73);
            StandardMessageCodec.writeBytes(byteArrayOutputStream, ((d9.e) obj).i());
            return;
        }
        if (!(obj instanceof Double)) {
            super.writeValue(byteArrayOutputStream, obj);
            return;
        }
        Double d10 = (Double) obj;
        if (Double.isNaN(d10.doubleValue())) {
            byteArrayOutputStream.write(-63);
            return;
        }
        if (d10.equals(Double.valueOf(Double.NEGATIVE_INFINITY))) {
            byteArrayOutputStream.write(-61);
        } else if (d10.equals(Double.valueOf(Double.POSITIVE_INFINITY))) {
            byteArrayOutputStream.write(-62);
        } else {
            super.writeValue(byteArrayOutputStream, obj);
        }
    }
}
