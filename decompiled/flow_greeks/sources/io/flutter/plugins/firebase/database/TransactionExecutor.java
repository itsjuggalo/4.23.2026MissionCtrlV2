package io.flutter.plugins.firebase.database;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import io.flutter.plugin.common.MethodChannel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lio/flutter/plugins/firebase/database/TransactionExecutor;", "", "channel", "Lio/flutter/plugin/common/MethodChannel;", "<init>", "(Lio/flutter/plugin/common/MethodChannel;)V", "completion", "Lcom/google/android/gms/tasks/TaskCompletionSource;", "execute", "arguments", "", "", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TransactionExecutor {
    private final MethodChannel channel;
    private final TaskCompletionSource<Object> completion;

    public TransactionExecutor(MethodChannel channel) {
        kotlin.jvm.internal.t.f(channel, "channel");
        this.channel = channel;
        this.completion = new TaskCompletionSource<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execute$lambda$0(final TransactionExecutor transactionExecutor, Map map) {
        transactionExecutor.channel.invokeMethod(Constants.METHOD_CALL_TRANSACTION_HANDLER, map, new MethodChannel.Result() { // from class: io.flutter.plugins.firebase.database.TransactionExecutor$execute$1$1
            @Override // io.flutter.plugin.common.MethodChannel.Result
            public void error(String errorCode, String errorMessage, Object errorDetails) {
                kotlin.jvm.internal.t.f(errorCode, "errorCode");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (errorMessage == null) {
                    errorMessage = FlutterFirebaseDatabaseException.UNKNOWN_ERROR_MESSAGE;
                }
                if (errorDetails instanceof Map) {
                    linkedHashMap.putAll((Map) errorDetails);
                }
                this.this$0.completion.setException(new FlutterFirebaseDatabaseException(errorCode, errorMessage, linkedHashMap));
            }

            @Override // io.flutter.plugin.common.MethodChannel.Result
            public void success(Object result) {
                this.this$0.completion.setResult(result);
            }

            @Override // io.flutter.plugin.common.MethodChannel.Result
            public void notImplemented() {
            }
        });
    }

    public final Object execute(final Map<String, ? extends Object> arguments) throws InterruptedException {
        kotlin.jvm.internal.t.f(arguments, "arguments");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.flutter.plugins.firebase.database.v1
            @Override // java.lang.Runnable
            public final void run() {
                TransactionExecutor.execute$lambda$0(this.f12923a, arguments);
            }
        });
        Object objAwait = Tasks.await(this.completion.getTask());
        kotlin.jvm.internal.t.e(objAwait, "await(...)");
        return objAwait;
    }
}
