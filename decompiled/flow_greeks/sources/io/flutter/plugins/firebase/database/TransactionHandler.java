package io.flutter.plugins.firebase.database;

import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import e8.r;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t0\b¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0017¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0019\u001a\u00020\u00182\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u00152\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001cR(\u0010\u001e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lio/flutter/plugins/firebase/database/TransactionHandler;", "Le8/r$b;", "Lio/flutter/plugin/common/MethodChannel;", "channel", "", Constants.TRANSACTION_KEY, "<init>", "(Lio/flutter/plugin/common/MethodChannel;I)V", "Lcom/google/android/gms/tasks/Task;", "", "", "", "getTask", "()Lcom/google/android/gms/tasks/Task;", "Le8/m;", "currentData", "Le8/r$c;", "doTransaction", "(Le8/m;)Le8/r$c;", "Le8/c;", "error", "", Constants.COMMITTED, "Le8/b;", "Lcd/h0;", "onComplete", "(Le8/c;ZLe8/b;)V", "Lio/flutter/plugin/common/MethodChannel;", "I", "Lcom/google/android/gms/tasks/TaskCompletionSource;", "transactionCompletionSource", "Lcom/google/android/gms/tasks/TaskCompletionSource;", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TransactionHandler implements r.b {
    private final MethodChannel channel;
    private final TaskCompletionSource<Map<String, Object>> transactionCompletionSource;
    private final int transactionKey;

    public TransactionHandler(MethodChannel channel, int i10) {
        kotlin.jvm.internal.t.f(channel, "channel");
        this.channel = channel;
        this.transactionKey = i10;
        this.transactionCompletionSource = new TaskCompletionSource<>();
    }

    @Override // e8.r.b
    public r.c doTransaction(e8.m currentData) {
        Map mapH;
        r.c cVarA;
        kotlin.jvm.internal.t.f(currentData, "currentData");
        String strA = currentData.a();
        if (strA == null) {
            strA = "";
        }
        try {
            Object objExecute = new TransactionExecutor(this.channel).execute(dd.o0.l(cd.w.a(Constants.SNAPSHOT, dd.o0.l(cd.w.a("key", strA), cd.w.a("value", currentData.c()))), cd.w.a(Constants.TRANSACTION_KEY, Integer.valueOf(this.transactionKey))));
            if (objExecute instanceof Map) {
                kotlin.jvm.internal.t.d(objExecute, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
                mapH = (Map) objExecute;
            } else if (objExecute == null) {
                mapH = dd.o0.h();
            } else {
                Log.e("firebase_database", "Unexpected transaction result type: " + objExecute.getClass());
                mapH = dd.o0.h();
            }
            Object obj = mapH.get("aborted");
            Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
            boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
            Object obj2 = mapH.get("exception");
            Boolean bool2 = obj2 instanceof Boolean ? (Boolean) obj2 : null;
            boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : false;
            if (zBooleanValue || zBooleanValue2) {
                cVarA = r.a();
            } else {
                if (mapH.containsKey("value")) {
                    currentData.d(mapH.get("value"));
                }
                cVarA = r.b(currentData);
            }
            kotlin.jvm.internal.t.c(cVarA);
            return cVarA;
        } catch (Exception e10) {
            Log.e("firebase_database", "An unexpected exception occurred for a transaction.", e10);
            r.c cVarA2 = r.a();
            kotlin.jvm.internal.t.c(cVarA2);
            return cVarA2;
        }
    }

    public final Task<Map<String, Object>> getTask() {
        Task<Map<String, Object>> task = this.transactionCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    @Override // e8.r.b
    public void onComplete(e8.c error, boolean committed, e8.b currentData) {
        if (error != null) {
            this.transactionCompletionSource.setException(FlutterFirebaseDatabaseException.INSTANCE.fromDatabaseError(error));
        } else {
            if (currentData == null) {
                this.transactionCompletionSource.setResult(dd.o0.h());
                return;
            }
            this.transactionCompletionSource.setResult(new FlutterDataSnapshotPayload(currentData).withAdditionalParams(dd.o0.n(cd.w.a(Constants.COMMITTED, Boolean.valueOf(committed)))).toMap());
        }
    }
}
