package io.flutter.plugins.firebase.database;

import android.os.Handler;
import android.os.Looper;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
import l2.AbstractC2331o;
import l2.C2329m;

/* JADX INFO: loaded from: classes.dex */
public class TransactionExecutor {
    private final MethodChannel channel;
    private final C2329m completion = new C2329m();

    public TransactionExecutor(MethodChannel methodChannel) {
        this.channel = methodChannel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$execute$0(Map map) {
        this.channel.invokeMethod(Constants.METHOD_CALL_TRANSACTION_HANDLER, map, new MethodChannel.Result() { // from class: io.flutter.plugins.firebase.database.TransactionExecutor.1
            @Override // io.flutter.plugin.common.MethodChannel.Result
            public void error(String str, String str2, Object obj) {
                Map map2 = new HashMap();
                if (str2 == null) {
                    str2 = FlutterFirebaseDatabaseException.UNKNOWN_ERROR_MESSAGE;
                }
                if (obj instanceof Map) {
                    map2 = (Map) obj;
                }
                TransactionExecutor.this.completion.b(new FlutterFirebaseDatabaseException(str, str2, map2));
            }

            @Override // io.flutter.plugin.common.MethodChannel.Result
            public void notImplemented() {
            }

            @Override // io.flutter.plugin.common.MethodChannel.Result
            public void success(Object obj) {
                TransactionExecutor.this.completion.c(obj);
            }
        });
    }

    public Object execute(final Map<String, Object> map) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.flutter.plugins.firebase.database.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f19157a.lambda$execute$0(map);
            }
        });
        return AbstractC2331o.a(this.completion.a());
    }
}
