package com.google.firebase.firestore;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ServerTimestamps;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Logger;
import com.google.protobuf.u0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p2.C1698D;
import p2.C1705b;

/* JADX INFO: loaded from: classes.dex */
public class UserDataWriter {
    private final FirebaseFirestore firestore;
    private final DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior;

    /* JADX INFO: renamed from: com.google.firebase.firestore.UserDataWriter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$DocumentSnapshot$ServerTimestampBehavior;

        static {
            int[] iArr = new int[DocumentSnapshot.ServerTimestampBehavior.values().length];
            $SwitchMap$com$google$firebase$firestore$DocumentSnapshot$ServerTimestampBehavior = iArr;
            try {
                iArr[DocumentSnapshot.ServerTimestampBehavior.PREVIOUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$DocumentSnapshot$ServerTimestampBehavior[DocumentSnapshot.ServerTimestampBehavior.ESTIMATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public UserDataWriter(FirebaseFirestore firebaseFirestore, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        this.firestore = firebaseFirestore;
        this.serverTimestampBehavior = serverTimestampBehavior;
    }

    private List<Object> convertArray(C1705b c1705b) {
        ArrayList arrayList = new ArrayList(c1705b.s());
        Iterator it = c1705b.a().iterator();
        while (it.hasNext()) {
            arrayList.add(convertValue((C1698D) it.next()));
        }
        return arrayList;
    }

    private Object convertReference(C1698D c1698d) {
        DatabaseId databaseIdFromName = DatabaseId.fromName(c1698d.D());
        DocumentKey documentKeyFromName = DocumentKey.fromName(c1698d.D());
        DatabaseId databaseId = this.firestore.getDatabaseId();
        if (!databaseIdFromName.equals(databaseId)) {
            Logger.warn("DocumentSnapshot", "Document %s contains a document reference within a different database (%s/%s) which is not supported. It will be treated as a reference in the current database (%s/%s) instead.", documentKeyFromName.getPath(), databaseIdFromName.getProjectId(), databaseIdFromName.getDatabaseId(), databaseId.getProjectId(), databaseId.getDatabaseId());
        }
        return new DocumentReference(documentKeyFromName, this.firestore);
    }

    private Object convertServerTimestamp(C1698D c1698d) {
        int i4 = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$DocumentSnapshot$ServerTimestampBehavior[this.serverTimestampBehavior.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                return null;
            }
            return convertTimestamp(ServerTimestamps.getLocalWriteTime(c1698d));
        }
        C1698D previousValue = ServerTimestamps.getPreviousValue(c1698d);
        if (previousValue == null) {
            return null;
        }
        return convertValue(previousValue);
    }

    private Object convertTimestamp(u0 u0Var) {
        return new Timestamp(u0Var.o(), u0Var.n());
    }

    public Map<String, Object> convertObject(Map<String, C1698D> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, C1698D> entry : map.entrySet()) {
            map2.put(entry.getKey(), convertValue(entry.getValue()));
        }
        return map2;
    }

    public Object convertValue(C1698D c1698d) {
        switch (Values.typeOrder(c1698d)) {
            case 0:
                return null;
            case 1:
                return Boolean.valueOf(c1698d.w());
            case 2:
                return c1698d.G().equals(C1698D.c.INTEGER_VALUE) ? Long.valueOf(c1698d.B()) : Double.valueOf(c1698d.z());
            case 3:
                return convertTimestamp(c1698d.F());
            case 4:
                return convertServerTimestamp(c1698d);
            case 5:
                return c1698d.E();
            case 6:
                return Blob.fromByteString(c1698d.x());
            case 7:
                return convertReference(c1698d);
            case 8:
                return new GeoPoint(c1698d.A().n(), c1698d.A().o());
            case 9:
                return convertArray(c1698d.v());
            case 10:
                return convertVectorValue(c1698d.C().n());
            case 11:
                return convertObject(c1698d.C().n());
            default:
                throw Assert.fail("Unknown value type: " + c1698d.G(), new Object[0]);
        }
    }

    public VectorValue convertVectorValue(Map<String, C1698D> map) {
        List listA = map.get("value").v().a();
        double[] dArr = new double[listA.size()];
        for (int i4 = 0; i4 < listA.size(); i4++) {
            dArr[i4] = ((C1698D) listA.get(i4)).z();
        }
        return new VectorValue(dArr);
    }
}
