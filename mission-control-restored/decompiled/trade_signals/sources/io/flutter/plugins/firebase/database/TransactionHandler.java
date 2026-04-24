package io.flutter.plugins.firebase.database;

import android.util.Log;
import c3.r;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import l2.AbstractC2328l;
import l2.C2329m;

/* JADX INFO: loaded from: classes.dex */
public class TransactionHandler implements r.b {
    private final MethodChannel channel;
    private final C2329m transactionCompletionSource = new C2329m();
    private final int transactionKey;

    public TransactionHandler(MethodChannel methodChannel, int i8) {
        this.channel = methodChannel;
        this.transactionKey = i8;
    }

    @Override // c3.r.b
    public r.c doTransaction(c3.m mVar) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map.put("key", mVar.a());
        map.put("value", mVar.c());
        map2.put(Constants.SNAPSHOT, map);
        map2.put(Constants.TRANSACTION_KEY, Integer.valueOf(this.transactionKey));
        try {
            Object objExecute = new TransactionExecutor(this.channel).execute(map2);
            Objects.requireNonNull(objExecute);
            Map map3 = (Map) objExecute;
            Object obj = map3.get("aborted");
            Objects.requireNonNull(obj);
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            Object obj2 = map3.get("exception");
            Objects.requireNonNull(obj2);
            boolean zBooleanValue2 = ((Boolean) obj2).booleanValue();
            if (!zBooleanValue && !zBooleanValue2) {
                mVar.d(map3.get("value"));
                return c3.r.b(mVar);
            }
            return c3.r.a();
        } catch (Exception e8) {
            Log.e("firebase_database", "An unexpected exception occurred for a transaction.", e8);
            return c3.r.a();
        }
    }

    public AbstractC2328l getTask() {
        return this.transactionCompletionSource.a();
    }

    @Override // c3.r.b
    public void onComplete(c3.c cVar, boolean z7, c3.b bVar) {
        if (cVar != null) {
            this.transactionCompletionSource.b(FlutterFirebaseDatabaseException.fromDatabaseError(cVar));
        } else if (bVar != null) {
            FlutterDataSnapshotPayload flutterDataSnapshotPayload = new FlutterDataSnapshotPayload(bVar);
            HashMap map = new HashMap();
            map.put(Constants.COMMITTED, Boolean.valueOf(z7));
            this.transactionCompletionSource.c(flutterDataSnapshotPayload.withAdditionalParams(map).toMap());
        }
    }
}
