package io.flutter.plugins.firebase.firestore.streamhandler;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.firestore.Transaction;
import com.google.firebase.firestore.TransactionOptions;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugins.firebase.auth.Constants;
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

    public interface OnTransactionStartedListener {
        void onStarted(Transaction transaction);
    }

    public TransactionStreamHandler(OnTransactionStartedListener onTransactionStartedListener, FirebaseFirestore firebaseFirestore, String str, Long l4, Long l5) {
        this.onTransactionStartedListener = onTransactionStartedListener;
        this.firestore = firebaseFirestore;
        this.transactionId = str;
        this.timeout = l4;
        this.maxAttempts = l5;
    }

    public static /* synthetic */ void a(EventChannel.EventSink eventSink, HashMap map) {
        eventSink.success(map);
        eventSink.endOfStream();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ FlutterFirebaseFirestoreTransactionResult lambda$onListen$1(final EventChannel.EventSink eventSink, Transaction transaction) {
        SetOptions setOptionsMergeFieldPaths;
        this.onTransactionStartedListener.onStarted(transaction);
        final HashMap map = new HashMap();
        map.put(Constants.APP_NAME, this.firestore.getApp().getName());
        this.mainLooper.post(new Runnable() { // from class: io.flutter.plugins.firebase.firestore.streamhandler.g
            @Override // java.lang.Runnable
            public final void run() {
                eventSink.success(map);
            }
        });
        try {
            if (!this.semaphore.tryAcquire(this.timeout.longValue(), TimeUnit.MILLISECONDS)) {
                return FlutterFirebaseFirestoreTransactionResult.failed(new FirebaseFirestoreException("timed out", FirebaseFirestoreException.Code.DEADLINE_EXCEEDED));
            }
            if (this.commands.isEmpty()) {
                return FlutterFirebaseFirestoreTransactionResult.complete();
            }
            if (this.resultType == GeneratedAndroidFirebaseFirestore.PigeonTransactionResult.FAILURE) {
                return FlutterFirebaseFirestoreTransactionResult.complete();
            }
            for (GeneratedAndroidFirebaseFirestore.PigeonTransactionCommand pigeonTransactionCommand : this.commands) {
                DocumentReference documentReferenceDocument = this.firestore.document(pigeonTransactionCommand.getPath());
                int i4 = AnonymousClass1.$SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$PigeonTransactionType[pigeonTransactionCommand.getType().ordinal()];
                if (i4 == 1) {
                    transaction.delete(documentReferenceDocument);
                } else if (i4 == 2) {
                    Map<String, Object> data = pigeonTransactionCommand.getData();
                    Objects.requireNonNull(data);
                    transaction.update(documentReferenceDocument, data);
                } else if (i4 == 3) {
                    GeneratedAndroidFirebaseFirestore.PigeonDocumentOption option = pigeonTransactionCommand.getOption();
                    Objects.requireNonNull(option);
                    if (option.getMerge() != null && option.getMerge().booleanValue()) {
                        setOptionsMergeFieldPaths = SetOptions.merge();
                    } else if (option.getMergeFields() != null) {
                        List<List<String>> mergeFields = option.getMergeFields();
                        Objects.requireNonNull(mergeFields);
                        setOptionsMergeFieldPaths = SetOptions.mergeFieldPaths(PigeonParser.parseFieldPath(mergeFields));
                    } else {
                        setOptionsMergeFieldPaths = null;
                    }
                    Map<String, Object> data2 = pigeonTransactionCommand.getData();
                    Objects.requireNonNull(data2);
                    Map<String, Object> map2 = data2;
                    if (setOptionsMergeFieldPaths == null) {
                        transaction.set(documentReferenceDocument, map2);
                    } else {
                        transaction.set(documentReferenceDocument, map2, setOptionsMergeFieldPaths);
                    }
                }
            }
            return FlutterFirebaseFirestoreTransactionResult.complete();
        } catch (InterruptedException unused) {
            return FlutterFirebaseFirestoreTransactionResult.failed(new FirebaseFirestoreException("interrupted", FirebaseFirestoreException.Code.DEADLINE_EXCEEDED));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onListen$3(final EventChannel.EventSink eventSink, Task task) {
        final HashMap map = new HashMap();
        if (task.getException() != null || ((FlutterFirebaseFirestoreTransactionResult) task.getResult()).exception != null) {
            Exception exception = task.getException() != null ? task.getException() : ((FlutterFirebaseFirestoreTransactionResult) task.getResult()).exception;
            map.put(Constants.APP_NAME, this.firestore.getApp().getName());
            map.put(com.google.firebase.messaging.Constants.IPC_BUNDLE_KEY_SEND_ERROR, ExceptionConverter.createDetails(exception));
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
        this.firestore.runTransaction(new TransactionOptions.Builder().setMaxAttempts(this.maxAttempts.intValue()).build(), new Transaction.Function() { // from class: io.flutter.plugins.firebase.firestore.streamhandler.h
            @Override // com.google.firebase.firestore.Transaction.Function
            public final Object apply(Transaction transaction) {
                return this.f12657a.lambda$onListen$1(eventSink, transaction);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.firestore.streamhandler.i
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f12659a.lambda$onListen$3(eventSink, task);
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
