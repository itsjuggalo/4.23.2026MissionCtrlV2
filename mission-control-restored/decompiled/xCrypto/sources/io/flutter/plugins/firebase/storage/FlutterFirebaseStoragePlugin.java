package io.flutter.plugins.firebase.storage;

import android.net.Uri;
import android.util.Base64;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import io.flutter.plugins.firebase.crashlytics.Constants;
import io.flutter.plugins.firebase.storage.GeneratedAndroidFirebaseStorage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class FlutterFirebaseStoragePlugin implements FlutterFirebasePlugin, FlutterPlugin, GeneratedAndroidFirebaseStorage.FirebaseStorageHostApi {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final String DEFAULT_ERROR_CODE = "firebase_storage";
    static final String STORAGE_METHOD_CHANNEL_NAME = "plugins.flutter.io/firebase_storage";
    static final String STORAGE_TASK_EVENT_NAME = "taskEvent";
    static final Map<String, EventChannel> eventChannels = new HashMap();
    static final Map<String, EventChannel.StreamHandler> streamHandlers = new HashMap();
    private MethodChannel channel;
    private BinaryMessenger messenger;

    private GeneratedAndroidFirebaseStorage.PigeonStorageReference convertToPigeonReference(StorageReference storageReference) {
        return new GeneratedAndroidFirebaseStorage.PigeonStorageReference.Builder().setBucket(storageReference.getBucket()).setFullPath(storageReference.getPath()).setName(storageReference.getName()).build();
    }

    public static Map<String, String> getExceptionDetails(Exception exc) {
        HashMap map = new HashMap();
        GeneratedAndroidFirebaseStorage.FlutterError flutterError = FlutterFirebaseStorageException.parserExceptionToFlutter(exc);
        map.put("code", flutterError.code);
        map.put(Constants.MESSAGE, flutterError.getMessage());
        return map;
    }

    private StorageReference getReferenceFromPigeon(GeneratedAndroidFirebaseStorage.PigeonStorageFirebaseApp pigeonStorageFirebaseApp, GeneratedAndroidFirebaseStorage.PigeonStorageReference pigeonStorageReference) {
        return getStorageFromPigeon(pigeonStorageFirebaseApp).getReference(pigeonStorageReference.getFullPath());
    }

    private FirebaseStorage getStorageFromPigeon(GeneratedAndroidFirebaseStorage.PigeonStorageFirebaseApp pigeonStorageFirebaseApp) {
        return FirebaseStorage.getInstance(FirebaseApp.getInstance(pigeonStorageFirebaseApp.getAppName()), "gs://" + pigeonStorageFirebaseApp.getBucket());
    }

    private void initInstance(BinaryMessenger binaryMessenger) {
        FlutterFirebasePluginRegistry.registerPlugin(STORAGE_METHOD_CHANNEL_NAME, this);
        this.channel = new MethodChannel(binaryMessenger, STORAGE_METHOD_CHANNEL_NAME);
        GeneratedAndroidFirebaseStorage.FirebaseStorageHostApi.setup(binaryMessenger, this);
        this.messenger = binaryMessenger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didReinitializeFirebaseCore$8(TaskCompletionSource taskCompletionSource) {
        FlutterFirebaseStorageTask.cancelInProgressTasks();
        taskCompletionSource.setResult(null);
        removeEventListeners();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$referenceGetMetaData$3(GeneratedAndroidFirebaseStorage.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(convertToPigeonMetaData((StorageMetadata) task.getResult()));
        } else {
            result.error(FlutterFirebaseStorageException.parserExceptionToFlutter(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$referenceList$4(GeneratedAndroidFirebaseStorage.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(convertToPigeonListResult((ListResult) task.getResult()));
        } else {
            result.error(FlutterFirebaseStorageException.parserExceptionToFlutter(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$referenceListAll$5(GeneratedAndroidFirebaseStorage.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(convertToPigeonListResult((ListResult) task.getResult()));
        } else {
            result.error(FlutterFirebaseStorageException.parserExceptionToFlutter(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$referenceUpdateMetadata$6(GeneratedAndroidFirebaseStorage.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(convertToPigeonMetaData((StorageMetadata) task.getResult()));
        } else {
            result.error(FlutterFirebaseStorageException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static Map<String, Object> parseMetadataToMap(StorageMetadata storageMetadata) {
        if (storageMetadata == null) {
            return null;
        }
        HashMap map = new HashMap();
        if (storageMetadata.getName() != null) {
            map.put("name", storageMetadata.getName());
        }
        if (storageMetadata.getBucket() != null) {
            map.put("bucket", storageMetadata.getBucket());
        }
        if (storageMetadata.getGeneration() != null) {
            map.put("generation", storageMetadata.getGeneration());
        }
        if (storageMetadata.getMetadataGeneration() != null) {
            map.put("metadataGeneration", storageMetadata.getMetadataGeneration());
        }
        map.put("fullPath", storageMetadata.getPath());
        map.put("size", Long.valueOf(storageMetadata.getSizeBytes()));
        map.put("creationTimeMillis", Long.valueOf(storageMetadata.getCreationTimeMillis()));
        map.put("updatedTimeMillis", Long.valueOf(storageMetadata.getUpdatedTimeMillis()));
        if (storageMetadata.getMd5Hash() != null) {
            map.put("md5Hash", storageMetadata.getMd5Hash());
        }
        if (storageMetadata.getCacheControl() != null) {
            map.put("cacheControl", storageMetadata.getCacheControl());
        }
        if (storageMetadata.getContentDisposition() != null) {
            map.put("contentDisposition", storageMetadata.getContentDisposition());
        }
        if (storageMetadata.getContentEncoding() != null) {
            map.put("contentEncoding", storageMetadata.getContentEncoding());
        }
        if (storageMetadata.getContentLanguage() != null) {
            map.put("contentLanguage", storageMetadata.getContentLanguage());
        }
        if (storageMetadata.getContentType() != null) {
            map.put("contentType", storageMetadata.getContentType());
        }
        HashMap map2 = new HashMap();
        for (String str : storageMetadata.getCustomMetadataKeys()) {
            if (storageMetadata.getCustomMetadata(str) == null) {
                map2.put(str, "");
            } else {
                String customMetadata = storageMetadata.getCustomMetadata(str);
                Objects.requireNonNull(customMetadata);
                map2.put(str, customMetadata);
            }
        }
        map.put("customMetadata", map2);
        return map;
    }

    private String registerEventChannel(String str, String str2, EventChannel.StreamHandler streamHandler) {
        EventChannel eventChannel = new EventChannel(this.messenger, str + RemoteSettings.FORWARD_SLASH_STRING + str2);
        eventChannel.setStreamHandler(streamHandler);
        eventChannels.put(str2, eventChannel);
        streamHandlers.put(str2, streamHandler);
        return str2;
    }

    private synchronized void removeEventListeners() {
        try {
            for (String str : new ArrayList(eventChannels.keySet())) {
                Map<String, EventChannel> map = eventChannels;
                EventChannel eventChannel = map.get(str);
                if (eventChannel != null) {
                    eventChannel.setStreamHandler(null);
                }
                map.remove(str);
            }
            for (String str2 : new ArrayList(streamHandlers.keySet())) {
                Map<String, EventChannel.StreamHandler> map2 = streamHandlers;
                EventChannel.StreamHandler streamHandler = map2.get(str2);
                if (streamHandler != null) {
                    streamHandler.onCancel(null);
                }
                map2.remove(str2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private byte[] stringToByteData(String str, int i4) {
        if (i4 == 1) {
            return Base64.decode(str, 0);
        }
        if (i4 != 2) {
            return null;
        }
        return Base64.decode(str, 8);
    }

    public static /* synthetic */ void t(GeneratedAndroidFirebaseStorage.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success((byte[]) task.getResult());
        } else {
            result.error(FlutterFirebaseStorageException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void y(GeneratedAndroidFirebaseStorage.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(((Uri) task.getResult()).toString());
        } else {
            result.error(FlutterFirebaseStorageException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void z(GeneratedAndroidFirebaseStorage.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(null);
        } else {
            result.error(FlutterFirebaseStorageException.parserExceptionToFlutter(task.getException()));
        }
    }

    public GeneratedAndroidFirebaseStorage.PigeonListResult convertToPigeonListResult(ListResult listResult) {
        ArrayList arrayList = new ArrayList();
        Iterator<StorageReference> it = listResult.getItems().iterator();
        while (it.hasNext()) {
            arrayList.add(convertToPigeonReference(it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<StorageReference> it2 = listResult.getPrefixes().iterator();
        while (it2.hasNext()) {
            arrayList2.add(convertToPigeonReference(it2.next()));
        }
        return new GeneratedAndroidFirebaseStorage.PigeonListResult.Builder().setItems(arrayList).setPageToken(listResult.getPageToken()).setPrefixs(arrayList2).build();
    }

    public GeneratedAndroidFirebaseStorage.PigeonFullMetaData convertToPigeonMetaData(StorageMetadata storageMetadata) {
        return new GeneratedAndroidFirebaseStorage.PigeonFullMetaData.Builder().setMetadata(parseMetadataToMap(storageMetadata)).build();
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Void> didReinitializeFirebaseCore() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.storage.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f12728a.lambda$didReinitializeFirebaseCore$8(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public StorageMetadata getMetaDataFromPigeon(GeneratedAndroidFirebaseStorage.PigeonSettableMetadata pigeonSettableMetadata) {
        StorageMetadata.Builder builder = new StorageMetadata.Builder();
        if (pigeonSettableMetadata.getContentType() != null) {
            builder.setContentType(pigeonSettableMetadata.getContentType());
        }
        if (pigeonSettableMetadata.getCacheControl() != null) {
            builder.setCacheControl(pigeonSettableMetadata.getCacheControl());
        }
        if (pigeonSettableMetadata.getContentDisposition() != null) {
            builder.setContentDisposition(pigeonSettableMetadata.getContentDisposition());
        }
        if (pigeonSettableMetadata.getContentEncoding() != null) {
            builder.setContentEncoding(pigeonSettableMetadata.getContentEncoding());
        }
        if (pigeonSettableMetadata.getContentLanguage() != null) {
            builder.setContentLanguage(pigeonSettableMetadata.getContentLanguage());
        }
        Map<String, String> customMetadata = pigeonSettableMetadata.getCustomMetadata();
        if (customMetadata != null) {
            for (Map.Entry<String, String> entry : customMetadata.entrySet()) {
                builder.setCustomMetadata(entry.getKey(), entry.getValue());
            }
        }
        return builder.build();
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Map<String, Object>> getPluginConstantsForFirebaseApp(FirebaseApp firebaseApp) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.storage.h
            @Override // java.lang.Runnable
            public final void run() {
                taskCompletionSource.setResult(new HashMap());
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // io.flutter.plugins.firebase.storage.GeneratedAndroidFirebaseStorage.FirebaseStorageHostApi
    public void getReferencebyPath(GeneratedAndroidFirebaseStorage.PigeonStorageFirebaseApp pigeonStorageFirebaseApp, String str, String str2, GeneratedAndroidFirebaseStorage.Result<GeneratedAndroidFirebaseStorage.PigeonStorageReference> result) {
        result.success(convertToPigeonReference(getStorageFromPigeon(pigeonStorageFirebaseApp).getReference(str)));
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        initInstance(flutterPluginBinding.getBinaryMessenger());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        FlutterFirebaseStorageTask.cancelInProgressTasks();
        this.channel.setMethodCallHandler(null);
        GeneratedAndroidFirebaseStorage.FirebaseStorageHostApi.setup(this.messenger, null);
        this.channel = null;
        this.messenger = null;
        removeEventListeners();
    }

    @Override // io.flutter.plugins.firebase.storage.GeneratedAndroidFirebaseStorage.FirebaseStorageHostApi
    public void referenceDelete(GeneratedAndroidFirebaseStorage.PigeonStorageFirebaseApp pigeonStorageFirebaseApp, GeneratedAndroidFirebaseStorage.PigeonStorageReference pigeonStorageReference, final GeneratedAndroidFirebaseStorage.Result<Void> result) {
        getStorageFromPigeon(pigeonStorageFirebaseApp).getReference(pigeonStorageReference.getFullPath()).delete().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.storage.a
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseStoragePlugin.z(result, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.storage.GeneratedAndroidFirebaseStorage.FirebaseStorageHostApi
    public void referenceDownloadFile(GeneratedAndroidFirebaseStorage.PigeonStorageFirebaseApp pigeonStorageFirebaseApp, GeneratedAndroidFirebaseStorage.PigeonStorageReference pigeonStorageReference, String str, Long l4, GeneratedAndroidFirebaseStorage.Result<String> result) {
        FlutterFirebaseStorageTask flutterFirebaseStorageTaskDownloadFile = FlutterFirebaseStorageTask.downloadFile(l4.intValue(), getReferenceFromPigeon(pigeonStorageFirebaseApp, pigeonStorageReference), new File(str));
        try {
            String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
            result.success(registerEventChannel("plugins.flutter.io/firebase_storage/taskEvent", lowerCase, flutterFirebaseStorageTaskDownloadFile.startTaskWithMethodChannel(this.channel, lowerCase)));
        } catch (Exception e4) {
            result.error(FlutterFirebaseStorageException.parserExceptionToFlutter(e4));
        }
    }

    @Override // io.flutter.plugins.firebase.storage.GeneratedAndroidFirebaseStorage.FirebaseStorageHostApi
    public void referenceGetData(GeneratedAndroidFirebaseStorage.PigeonStorageFirebaseApp pigeonStorageFirebaseApp, GeneratedAndroidFirebaseStorage.PigeonStorageReference pigeonStorageReference, Long l4, final GeneratedAndroidFirebaseStorage.Result<byte[]> result) {
        getStorageFromPigeon(pigeonStorageFirebaseApp).getReference(pigeonStorageReference.getFullPath()).getBytes(l4.longValue()).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.storage.b
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseStoragePlugin.t(result, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.storage.GeneratedAndroidFirebaseStorage.FirebaseStorageHostApi
    public void referenceGetDownloadURL(GeneratedAndroidFirebaseStorage.PigeonStorageFirebaseApp pigeonStorageFirebaseApp, GeneratedAndroidFirebaseStorage.PigeonStorageReference pigeonStorageReference, final GeneratedAndroidFirebaseStorage.Result<String> result) {
        getStorageFromPigeon(pigeonStorageFirebaseApp).getReference(pigeonStorageReference.getFullPath()).getDownloadUrl().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.storage.c
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseStoragePlugin.y(result, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.storage.GeneratedAndroidFirebaseStorage.FirebaseStorageHostApi
    public void referenceGetMetaData(GeneratedAndroidFirebaseStorage.PigeonStorageFirebaseApp pigeonStorageFirebaseApp, GeneratedAndroidFirebaseStorage.PigeonStorageReference pigeonStorageReference, final GeneratedAndroidFirebaseStorage.Result<GeneratedAndroidFirebaseStorage.PigeonFullMetaData> result) {
        getStorageFromPigeon(pigeonStorageFirebaseApp).getReference(pigeonStorageReference.getFullPath()).getMetadata().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.storage.g
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f12732a.lambda$referenceGetMetaData$3(result, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.storage.GeneratedAndroidFirebaseStorage.FirebaseStorageHostApi
    public void referenceList(GeneratedAndroidFirebaseStorage.PigeonStorageFirebaseApp pigeonStorageFirebaseApp, GeneratedAndroidFirebaseStorage.PigeonStorageReference pigeonStorageReference, GeneratedAndroidFirebaseStorage.PigeonListOptions pigeonListOptions, final GeneratedAndroidFirebaseStorage.Result<GeneratedAndroidFirebaseStorage.PigeonListResult> result) {
        StorageReference reference = getStorageFromPigeon(pigeonStorageFirebaseApp).getReference(pigeonStorageReference.getFullPath());
        (pigeonListOptions.getPageToken() != null ? reference.list(pigeonListOptions.getMaxResults().intValue(), pigeonListOptions.getPageToken()) : reference.list(pigeonListOptions.getMaxResults().intValue())).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.storage.i
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f12735a.lambda$referenceList$4(result, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.storage.GeneratedAndroidFirebaseStorage.FirebaseStorageHostApi
    public void referenceListAll(GeneratedAndroidFirebaseStorage.PigeonStorageFirebaseApp pigeonStorageFirebaseApp, GeneratedAndroidFirebaseStorage.PigeonStorageReference pigeonStorageReference, final GeneratedAndroidFirebaseStorage.Result<GeneratedAndroidFirebaseStorage.PigeonListResult> result) {
        getStorageFromPigeon(pigeonStorageFirebaseApp).getReference(pigeonStorageReference.getFullPath()).listAll().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.storage.f
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f12730a.lambda$referenceListAll$5(result, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.storage.GeneratedAndroidFirebaseStorage.FirebaseStorageHostApi
    public void referencePutData(GeneratedAndroidFirebaseStorage.PigeonStorageFirebaseApp pigeonStorageFirebaseApp, GeneratedAndroidFirebaseStorage.PigeonStorageReference pigeonStorageReference, byte[] bArr, GeneratedAndroidFirebaseStorage.PigeonSettableMetadata pigeonSettableMetadata, Long l4, GeneratedAndroidFirebaseStorage.Result<String> result) {
        FlutterFirebaseStorageTask flutterFirebaseStorageTaskUploadBytes = FlutterFirebaseStorageTask.uploadBytes(l4.intValue(), getReferenceFromPigeon(pigeonStorageFirebaseApp, pigeonStorageReference), bArr, getMetaDataFromPigeon(pigeonSettableMetadata));
        try {
            String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
            result.success(registerEventChannel("plugins.flutter.io/firebase_storage/taskEvent", lowerCase, flutterFirebaseStorageTaskUploadBytes.startTaskWithMethodChannel(this.channel, lowerCase)));
        } catch (Exception e4) {
            result.error(FlutterFirebaseStorageException.parserExceptionToFlutter(e4));
        }
    }

    @Override // io.flutter.plugins.firebase.storage.GeneratedAndroidFirebaseStorage.FirebaseStorageHostApi
    public void referencePutFile(GeneratedAndroidFirebaseStorage.PigeonStorageFirebaseApp pigeonStorageFirebaseApp, GeneratedAndroidFirebaseStorage.PigeonStorageReference pigeonStorageReference, String str, GeneratedAndroidFirebaseStorage.PigeonSettableMetadata pigeonSettableMetadata, Long l4, GeneratedAndroidFirebaseStorage.Result<String> result) {
        FlutterFirebaseStorageTask flutterFirebaseStorageTaskUploadFile = FlutterFirebaseStorageTask.uploadFile(l4.intValue(), getReferenceFromPigeon(pigeonStorageFirebaseApp, pigeonStorageReference), Uri.fromFile(new File(str)), pigeonSettableMetadata == null ? null : getMetaDataFromPigeon(pigeonSettableMetadata));
        try {
            String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
            result.success(registerEventChannel("plugins.flutter.io/firebase_storage/taskEvent", lowerCase, flutterFirebaseStorageTaskUploadFile.startTaskWithMethodChannel(this.channel, lowerCase)));
        } catch (Exception e4) {
            result.error(FlutterFirebaseStorageException.parserExceptionToFlutter(e4));
        }
    }

    @Override // io.flutter.plugins.firebase.storage.GeneratedAndroidFirebaseStorage.FirebaseStorageHostApi
    public void referencePutString(GeneratedAndroidFirebaseStorage.PigeonStorageFirebaseApp pigeonStorageFirebaseApp, GeneratedAndroidFirebaseStorage.PigeonStorageReference pigeonStorageReference, String str, Long l4, GeneratedAndroidFirebaseStorage.PigeonSettableMetadata pigeonSettableMetadata, Long l5, GeneratedAndroidFirebaseStorage.Result<String> result) {
        FlutterFirebaseStorageTask flutterFirebaseStorageTaskUploadBytes = FlutterFirebaseStorageTask.uploadBytes(l5.intValue(), getReferenceFromPigeon(pigeonStorageFirebaseApp, pigeonStorageReference), stringToByteData(str, l4.intValue()), getMetaDataFromPigeon(pigeonSettableMetadata));
        try {
            String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
            result.success(registerEventChannel("plugins.flutter.io/firebase_storage/taskEvent", lowerCase, flutterFirebaseStorageTaskUploadBytes.startTaskWithMethodChannel(this.channel, lowerCase)));
        } catch (Exception e4) {
            result.error(FlutterFirebaseStorageException.parserExceptionToFlutter(e4));
        }
    }

    @Override // io.flutter.plugins.firebase.storage.GeneratedAndroidFirebaseStorage.FirebaseStorageHostApi
    public void referenceUpdateMetadata(GeneratedAndroidFirebaseStorage.PigeonStorageFirebaseApp pigeonStorageFirebaseApp, GeneratedAndroidFirebaseStorage.PigeonStorageReference pigeonStorageReference, GeneratedAndroidFirebaseStorage.PigeonSettableMetadata pigeonSettableMetadata, final GeneratedAndroidFirebaseStorage.Result<GeneratedAndroidFirebaseStorage.PigeonFullMetaData> result) {
        getStorageFromPigeon(pigeonStorageFirebaseApp).getReference(pigeonStorageReference.getFullPath()).updateMetadata(getMetaDataFromPigeon(pigeonSettableMetadata)).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.storage.d
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f12726a.lambda$referenceUpdateMetadata$6(result, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.storage.GeneratedAndroidFirebaseStorage.FirebaseStorageHostApi
    public void setMaxDownloadRetryTime(GeneratedAndroidFirebaseStorage.PigeonStorageFirebaseApp pigeonStorageFirebaseApp, Long l4, GeneratedAndroidFirebaseStorage.Result<Void> result) {
        getStorageFromPigeon(pigeonStorageFirebaseApp).setMaxDownloadRetryTimeMillis(l4.longValue());
        result.success(null);
    }

    @Override // io.flutter.plugins.firebase.storage.GeneratedAndroidFirebaseStorage.FirebaseStorageHostApi
    public void setMaxOperationRetryTime(GeneratedAndroidFirebaseStorage.PigeonStorageFirebaseApp pigeonStorageFirebaseApp, Long l4, GeneratedAndroidFirebaseStorage.Result<Void> result) {
        getStorageFromPigeon(pigeonStorageFirebaseApp).setMaxOperationRetryTimeMillis(l4.longValue());
        result.success(null);
    }

    @Override // io.flutter.plugins.firebase.storage.GeneratedAndroidFirebaseStorage.FirebaseStorageHostApi
    public void setMaxUploadRetryTime(GeneratedAndroidFirebaseStorage.PigeonStorageFirebaseApp pigeonStorageFirebaseApp, Long l4, GeneratedAndroidFirebaseStorage.Result<Void> result) {
        getStorageFromPigeon(pigeonStorageFirebaseApp).setMaxUploadRetryTimeMillis(l4.longValue());
        result.success(null);
    }

    @Override // io.flutter.plugins.firebase.storage.GeneratedAndroidFirebaseStorage.FirebaseStorageHostApi
    public void taskCancel(GeneratedAndroidFirebaseStorage.PigeonStorageFirebaseApp pigeonStorageFirebaseApp, Long l4, GeneratedAndroidFirebaseStorage.Result<Map<String, Object>> result) {
        FlutterFirebaseStorageTask inProgressTaskForHandle = FlutterFirebaseStorageTask.getInProgressTaskForHandle(l4.intValue());
        if (inProgressTaskForHandle == null) {
            result.error(new GeneratedAndroidFirebaseStorage.FlutterError("unknown", "Cancel operation was called on a task which does not exist.", null));
            return;
        }
        try {
            boolean zCancel = inProgressTaskForHandle.getAndroidTask().cancel();
            HashMap map = new HashMap();
            map.put("status", Boolean.valueOf(zCancel));
            if (zCancel) {
                map.put("snapshot", FlutterFirebaseStorageTask.parseTaskSnapshot(inProgressTaskForHandle.getSnapshot()));
            }
            result.success(map);
        } catch (Exception e4) {
            result.error(FlutterFirebaseStorageException.parserExceptionToFlutter(e4));
        }
    }

    @Override // io.flutter.plugins.firebase.storage.GeneratedAndroidFirebaseStorage.FirebaseStorageHostApi
    public void taskPause(GeneratedAndroidFirebaseStorage.PigeonStorageFirebaseApp pigeonStorageFirebaseApp, Long l4, GeneratedAndroidFirebaseStorage.Result<Map<String, Object>> result) {
        FlutterFirebaseStorageTask inProgressTaskForHandle = FlutterFirebaseStorageTask.getInProgressTaskForHandle(l4.intValue());
        if (inProgressTaskForHandle == null) {
            result.error(new GeneratedAndroidFirebaseStorage.FlutterError("unknown", "Pause operation was called on a task which does not exist.", null));
            return;
        }
        HashMap map = new HashMap();
        try {
            boolean zPause = inProgressTaskForHandle.getAndroidTask().pause();
            map.put("status", Boolean.valueOf(zPause));
            if (zPause) {
                map.put("snapshot", FlutterFirebaseStorageTask.parseTaskSnapshot(inProgressTaskForHandle.getSnapshot()));
            }
            result.success(map);
        } catch (Exception e4) {
            result.error(FlutterFirebaseStorageException.parserExceptionToFlutter(e4));
        }
    }

    @Override // io.flutter.plugins.firebase.storage.GeneratedAndroidFirebaseStorage.FirebaseStorageHostApi
    public void taskResume(GeneratedAndroidFirebaseStorage.PigeonStorageFirebaseApp pigeonStorageFirebaseApp, Long l4, GeneratedAndroidFirebaseStorage.Result<Map<String, Object>> result) {
        FlutterFirebaseStorageTask inProgressTaskForHandle = FlutterFirebaseStorageTask.getInProgressTaskForHandle(l4.intValue());
        if (inProgressTaskForHandle == null) {
            result.error(new GeneratedAndroidFirebaseStorage.FlutterError("unknown", "Resume operation was called on a task which does not exist.", null));
            return;
        }
        try {
            boolean zResume = inProgressTaskForHandle.getAndroidTask().resume();
            HashMap map = new HashMap();
            map.put("status", Boolean.valueOf(zResume));
            if (zResume) {
                map.put("snapshot", FlutterFirebaseStorageTask.parseTaskSnapshot(inProgressTaskForHandle.getSnapshot()));
            }
            result.success(map);
        } catch (Exception e4) {
            result.error(FlutterFirebaseStorageException.parserExceptionToFlutter(e4));
        }
    }

    @Override // io.flutter.plugins.firebase.storage.GeneratedAndroidFirebaseStorage.FirebaseStorageHostApi
    public void useStorageEmulator(GeneratedAndroidFirebaseStorage.PigeonStorageFirebaseApp pigeonStorageFirebaseApp, String str, Long l4, GeneratedAndroidFirebaseStorage.Result<Void> result) {
        try {
            getStorageFromPigeon(pigeonStorageFirebaseApp).useEmulator(str, l4.intValue());
            result.success(null);
        } catch (Exception e4) {
            result.error(FlutterFirebaseStorageException.parserExceptionToFlutter(e4));
        }
    }
}
