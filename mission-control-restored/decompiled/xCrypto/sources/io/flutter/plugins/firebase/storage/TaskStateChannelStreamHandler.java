package io.flutter.plugins.firebase.storage;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnPausedListener;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageException;
import com.google.firebase.storage.StorageTask;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugins.firebase.auth.Constants;
import io.flutter.plugins.firebase.storage.GeneratedAndroidFirebaseStorage;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class TaskStateChannelStreamHandler implements EventChannel.StreamHandler {
    private final FirebaseStorage androidStorage;
    private final StorageTask<?> androidTask;
    private final FlutterFirebaseStorageTask flutterTask;
    private final String identifier;
    private final String TASK_STATE_NAME = "taskState";
    private final String TASK_APP_NAME = Constants.APP_NAME;
    private final String TASK_SNAPSHOT = "snapshot";
    private final String TASK_ERROR = com.google.firebase.messaging.Constants.IPC_BUNDLE_KEY_SEND_ERROR;

    public TaskStateChannelStreamHandler(FlutterFirebaseStorageTask flutterFirebaseStorageTask, FirebaseStorage firebaseStorage, StorageTask storageTask, String str) {
        this.flutterTask = flutterFirebaseStorageTask;
        this.androidStorage = firebaseStorage;
        this.androidTask = storageTask;
        this.identifier = str;
    }

    private Map<String, Object> getTaskEventMap(Object obj, Exception exc) {
        HashMap map = new HashMap();
        map.put(Constants.APP_NAME, this.androidStorage.getApp().getName());
        if (obj != null) {
            map.put("snapshot", FlutterFirebaseStorageTask.parseTaskSnapshot(obj));
        }
        if (exc != null) {
            map.put(com.google.firebase.messaging.Constants.IPC_BUNDLE_KEY_SEND_ERROR, FlutterFirebaseStoragePlugin.getExceptionDetails(exc));
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onListen$0(EventChannel.EventSink eventSink, StorageTask.ProvideError provideError) {
        if (this.flutterTask.isDestroyed()) {
            return;
        }
        Map<String, Object> taskEventMap = getTaskEventMap(provideError, null);
        taskEventMap.put("taskState", Integer.valueOf(GeneratedAndroidFirebaseStorage.PigeonStorageTaskState.RUNNING.index));
        eventSink.success(taskEventMap);
        this.flutterTask.notifyResumeObjects();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onListen$1(EventChannel.EventSink eventSink, StorageTask.ProvideError provideError) {
        if (this.flutterTask.isDestroyed()) {
            return;
        }
        Map<String, Object> taskEventMap = getTaskEventMap(provideError, null);
        taskEventMap.put("taskState", Integer.valueOf(GeneratedAndroidFirebaseStorage.PigeonStorageTaskState.PAUSED.index));
        eventSink.success(taskEventMap);
        this.flutterTask.notifyPauseObjects();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onListen$2(EventChannel.EventSink eventSink, StorageTask.ProvideError provideError) {
        if (this.flutterTask.isDestroyed()) {
            return;
        }
        Map<String, Object> taskEventMap = getTaskEventMap(provideError, null);
        taskEventMap.put("taskState", Integer.valueOf(GeneratedAndroidFirebaseStorage.PigeonStorageTaskState.SUCCESS.index));
        eventSink.success(taskEventMap);
        this.flutterTask.destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onListen$3(EventChannel.EventSink eventSink) {
        if (this.flutterTask.isDestroyed()) {
            return;
        }
        Map<String, Object> taskEventMap = getTaskEventMap(null, null);
        taskEventMap.put("taskState", Integer.valueOf(GeneratedAndroidFirebaseStorage.PigeonStorageTaskState.ERROR.index));
        HashMap map = new HashMap();
        map.put("code", FlutterFirebaseStorageException.getCode(StorageException.ERROR_CANCELED));
        map.put(io.flutter.plugins.firebase.crashlytics.Constants.MESSAGE, FlutterFirebaseStorageException.getMessage(StorageException.ERROR_CANCELED));
        taskEventMap.put(com.google.firebase.messaging.Constants.IPC_BUNDLE_KEY_SEND_ERROR, map);
        eventSink.success(taskEventMap);
        this.flutterTask.notifyCancelObjects();
        this.flutterTask.destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onListen$4(EventChannel.EventSink eventSink, Exception exc) {
        if (this.flutterTask.isDestroyed()) {
            return;
        }
        Map<String, Object> taskEventMap = getTaskEventMap(null, exc);
        taskEventMap.put("taskState", Integer.valueOf(GeneratedAndroidFirebaseStorage.PigeonStorageTaskState.ERROR.index));
        eventSink.success(taskEventMap);
        this.flutterTask.destroy();
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onCancel(Object obj) {
        if (!this.androidTask.isCanceled()) {
            this.androidTask.cancel();
        }
        if (!this.flutterTask.isDestroyed()) {
            this.flutterTask.destroy();
        }
        Map<String, EventChannel> map = FlutterFirebaseStoragePlugin.eventChannels;
        EventChannel eventChannel = map.get(this.identifier);
        if (eventChannel != null) {
            eventChannel.setStreamHandler(null);
            map.remove(this.identifier);
        }
        Map<String, EventChannel.StreamHandler> map2 = FlutterFirebaseStoragePlugin.streamHandlers;
        if (map2.get(this.identifier) != null) {
            map2.remove(this.identifier);
        }
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onListen(Object obj, final EventChannel.EventSink eventSink) {
        this.androidTask.addOnProgressListener((OnProgressListener) new OnProgressListener() { // from class: io.flutter.plugins.firebase.storage.C
            @Override // com.google.firebase.storage.OnProgressListener
            public final void onProgress(Object obj2) {
                this.f12713a.lambda$onListen$0(eventSink, (StorageTask.ProvideError) obj2);
            }
        });
        this.androidTask.addOnPausedListener((OnPausedListener) new OnPausedListener() { // from class: io.flutter.plugins.firebase.storage.D
            @Override // com.google.firebase.storage.OnPausedListener
            public final void onPaused(Object obj2) {
                this.f12715a.lambda$onListen$1(eventSink, (StorageTask.ProvideError) obj2);
            }
        });
        this.androidTask.addOnSuccessListener((OnSuccessListener) new OnSuccessListener() { // from class: io.flutter.plugins.firebase.storage.E
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj2) {
                this.f12717a.lambda$onListen$2(eventSink, (StorageTask.ProvideError) obj2);
            }
        });
        this.androidTask.addOnCanceledListener(new OnCanceledListener() { // from class: io.flutter.plugins.firebase.storage.F
            @Override // com.google.android.gms.tasks.OnCanceledListener
            public final void onCanceled() {
                this.f12719a.lambda$onListen$3(eventSink);
            }
        });
        this.androidTask.addOnFailureListener(new OnFailureListener() { // from class: io.flutter.plugins.firebase.storage.G
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.f12721a.lambda$onListen$4(eventSink, exc);
            }
        });
    }
}
