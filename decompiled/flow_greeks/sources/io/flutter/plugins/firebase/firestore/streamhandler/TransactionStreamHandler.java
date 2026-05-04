package io.flutter.plugins.firebase.firestore.streamhandler;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.f;
import com.google.firebase.firestore.l;
import d9.q1;
import d9.w1;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestoreTransactionResult;
import io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore;
import io.flutter.plugins.firebase.firestore.utils.ExceptionConverter;
import io.flutter.plugins.firebase.firestore.utils.PigeonParser;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class TransactionStreamHandler implements OnTransactionResultListener, EventChannel.StreamHandler {
    private List<GeneratedAndroidFirebaseFirestore.PigeonTransactionCommand> commands;
    final FirebaseFirestore firestore;
    final Long maxAttempts;
    final OnTransactionStartedListener onTransactionStartedListener;
    private GeneratedAndroidFirebaseFirestore.PigeonTransactionResult resultType;
    final Long timeout;
    final String transactionId;
    final Semaphore semaphore = new Semaphore(0);
    final Handler mainLooper = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: io.flutter.plugins.firebase.firestore.streamhandler.TransactionStreamHandler$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$PigeonTransactionType;

        static {
            int[] iArr = new int[GeneratedAndroidFirebaseFirestore.PigeonTransactionType.values().length];
            $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$PigeonTransactionType = iArr;
            try {
                iArr[GeneratedAndroidFirebaseFirestore.PigeonTransactionType.DELETE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$PigeonTransactionType[GeneratedAndroidFirebaseFirestore.PigeonTransactionType.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$PigeonTransactionType[GeneratedAndroidFirebaseFirestore.PigeonTransactionType.SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface OnTransactionStartedListener {
        void onStarted(l lVar);
    }

    public TransactionStreamHandler(OnTransactionStartedListener onTransactionStartedListener, FirebaseFirestore firebaseFirestore, String str, Long l10, Long l11) {
        this.onTransactionStartedListener = onTransactionStartedListener;
        this.firestore = firebaseFirestore;
        this.transactionId = str;
        this.timeout = l10;
        this.maxAttempts = l11;
    }

    public static /* synthetic */ void a(EventChannel.EventSink eventSink, HashMap map) {
        eventSink.success(map);
        eventSink.endOfStream();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ FlutterFirebaseFirestoreTransactionResult lambda$onListen$1(final EventChannel.EventSink eventSink, l lVar) {
        q1 q1VarD;
        this.onTransactionStartedListener.onStarted(lVar);
        final HashMap map = new HashMap();
        map.put("appName", this.firestore.A().q());
        this.mainLooper.post(new Runnable() { // from class: io.flutter.plugins.firebase.firestore.streamhandler.g
            @Override // java.lang.Runnable
            public final void run() {
                eventSink.success(map);
            }
        });
        try {
            if (!this.semaphore.tryAcquire(this.timeout.longValue(), TimeUnit.MILLISECONDS)) {
                return FlutterFirebaseFirestoreTransactionResult.failed(new com.google.firebase.firestore.f("timed out", f.a.DEADLINE_EXCEEDED));
            }
            if (this.commands.isEmpty()) {
                return FlutterFirebaseFirestoreTransactionResult.complete();
            }
            if (this.resultType == GeneratedAndroidFirebaseFirestore.PigeonTransactionResult.FAILURE) {
                return FlutterFirebaseFirestoreTransactionResult.complete();
            }
            for (GeneratedAndroidFirebaseFirestore.PigeonTransactionCommand pigeonTransactionCommand : this.commands) {
                com.google.firebase.firestore.c cVarY = this.firestore.y(pigeonTransactionCommand.getPath());
                int i10 = AnonymousClass1.$SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$PigeonTransactionType[pigeonTransactionCommand.getType().ordinal()];
                if (i10 == 1) {
                    lVar.b(cVarY);
                } else if (i10 == 2) {
                    Map<String, Object> data = pigeonTransactionCommand.getData();
                    Objects.requireNonNull(data);
                    lVar.h(cVarY, data);
                } else if (i10 == 3) {
                    GeneratedAndroidFirebaseFirestore.PigeonDocumentOption option = pigeonTransactionCommand.getOption();
                    Objects.requireNonNull(option);
                    if (option.getMerge() != null && option.getMerge().booleanValue()) {
                        q1VarD = q1.c();
                    } else if (option.getMergeFields() != null) {
                        List<List<String>> mergeFields = option.getMergeFields();
                        Objects.requireNonNull(mergeFields);
                        q1VarD = q1.d(PigeonParser.parseFieldPath(mergeFields));
                    } else {
                        q1VarD = null;
                    }
                    Map<String, Object> data2 = pigeonTransactionCommand.getData();
                    Objects.requireNonNull(data2);
                    Map<String, Object> map2 = data2;
                    if (q1VarD == null) {
                        lVar.e(cVarY, map2);
                    } else {
                        lVar.f(cVarY, map2, q1VarD);
                    }
                }
            }
            return FlutterFirebaseFirestoreTransactionResult.complete();
        } catch (InterruptedException unused) {
            return FlutterFirebaseFirestoreTransactionResult.failed(new com.google.firebase.firestore.f("interrupted", f.a.DEADLINE_EXCEEDED));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onListen$3(final EventChannel.EventSink eventSink, Task task) {
        final HashMap map = new HashMap();
        if (task.getException() != null || ((FlutterFirebaseFirestoreTransactionResult) task.getResult()).exception != null) {
            Exception exception = task.getException() != null ? task.getException() : ((FlutterFirebaseFirestoreTransactionResult) task.getResult()).exception;
            map.put("appName", this.firestore.A().q());
            map.put("error", ExceptionConverter.createDetails(exception));
        } else if (task.getResult() != null) {
            map.put("complete", Boolean.TRUE);
        }
        this.mainLooper.post(new Runnable() { // from class: io.flutter.plugins.firebase.firestore.streamhandler.f
            @Override // java.lang.Runnable
            public final void run() {
                TransactionStreamHandler.a(eventSink, map);
            }
        });
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onCancel(Object obj) {
        this.semaphore.release();
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onListen(Object obj, final EventChannel.EventSink eventSink) {
        this.firestore.L(new w1.b().b(this.maxAttempts.intValue()).a(), new l.a() { // from class: io.flutter.plugins.firebase.firestore.streamhandler.h
            @Override // com.google.firebase.firestore.l.a
            public final Object a(l lVar) {
                return this.f13061a.lambda$onListen$1(eventSink, lVar);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.firestore.streamhandler.i
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f13063a.lambda$onListen$3(eventSink, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.firestore.streamhandler.OnTransactionResultListener
    public void receiveTransactionResponse(GeneratedAndroidFirebaseFirestore.PigeonTransactionResult pigeonTransactionResult, List<GeneratedAndroidFirebaseFirestore.PigeonTransactionCommand> list) {
        this.resultType = pigeonTransactionResult;
        this.commands = list;
        this.semaphore.release();
    }
}
