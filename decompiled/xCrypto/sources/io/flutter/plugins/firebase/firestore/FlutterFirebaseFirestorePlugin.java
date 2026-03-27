package io.flutter.plugins.firebase.firestore;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.AggregateField;
import com.google.firebase.firestore.AggregateQuery;
import com.google.firebase.firestore.AggregateQuerySnapshot;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.MemoryCacheSettings;
import com.google.firebase.firestore.PersistentCacheIndexManager;
import com.google.firebase.firestore.PersistentCacheSettings;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.firestore.Source;
import com.google.firebase.firestore.Transaction;
import com.google.firebase.firestore.WriteBatch;
import com.google.firebase.sessions.settings.RemoteSettings;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore;
import io.flutter.plugins.firebase.firestore.streamhandler.DocumentSnapshotsStreamHandler;
import io.flutter.plugins.firebase.firestore.streamhandler.LoadBundleStreamHandler;
import io.flutter.plugins.firebase.firestore.streamhandler.OnTransactionResultListener;
import io.flutter.plugins.firebase.firestore.streamhandler.QuerySnapshotsStreamHandler;
import io.flutter.plugins.firebase.firestore.streamhandler.SnapshotsInSyncStreamHandler;
import io.flutter.plugins.firebase.firestore.streamhandler.TransactionStreamHandler;
import io.flutter.plugins.firebase.firestore.utils.ExceptionConverter;
import io.flutter.plugins.firebase.firestore.utils.PigeonParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public class FlutterFirebaseFirestorePlugin implements FlutterFirebasePlugin, FlutterPlugin, ActivityAware, GeneratedAndroidFirebaseFirestore.FirebaseFirestoreHostApi {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String DEFAULT_ERROR_CODE = "firebase_firestore";
    private static final String METHOD_CHANNEL_NAME = "plugins.flutter.io/firebase_firestore";
    public static final String TAG = "FlutterFirestorePlugin";
    protected static final HashMap<FirebaseFirestore, FlutterFirebaseFirestoreExtension> firestoreInstanceCache = new HashMap<>();
    public static final Map<Integer, DocumentSnapshot.ServerTimestampBehavior> serverTimestampBehaviorHashMap = new HashMap();
    private BinaryMessenger binaryMessenger;
    final StandardMethodCodec MESSAGE_CODEC = new StandardMethodCodec(FlutterFirebaseFirestoreMessageCodec.INSTANCE);
    private final AtomicReference<Activity> activity = new AtomicReference<>(null);
    private final Map<String, Transaction> transactions = new HashMap();
    private final Map<String, EventChannel> eventChannels = new HashMap();
    private final Map<String, EventChannel.StreamHandler> streamHandlers = new HashMap();
    private final Map<String, OnTransactionResultListener> transactionHandlers = new HashMap();

    /* JADX INFO: renamed from: io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestorePlugin$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$AggregateType;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$PersistenceCacheIndexManagerRequest;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$PigeonTransactionType;

        static {
            int[] iArr = new int[GeneratedAndroidFirebaseFirestore.PersistenceCacheIndexManagerRequest.values().length];
            $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$PersistenceCacheIndexManagerRequest = iArr;
            try {
                iArr[GeneratedAndroidFirebaseFirestore.PersistenceCacheIndexManagerRequest.ENABLE_INDEX_AUTO_CREATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$PersistenceCacheIndexManagerRequest[GeneratedAndroidFirebaseFirestore.PersistenceCacheIndexManagerRequest.DISABLE_INDEX_AUTO_CREATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$PersistenceCacheIndexManagerRequest[GeneratedAndroidFirebaseFirestore.PersistenceCacheIndexManagerRequest.DELETE_ALL_INDEXES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[GeneratedAndroidFirebaseFirestore.PigeonTransactionType.values().length];
            $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$PigeonTransactionType = iArr2;
            try {
                iArr2[GeneratedAndroidFirebaseFirestore.PigeonTransactionType.DELETE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$PigeonTransactionType[GeneratedAndroidFirebaseFirestore.PigeonTransactionType.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$PigeonTransactionType[GeneratedAndroidFirebaseFirestore.PigeonTransactionType.SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[GeneratedAndroidFirebaseFirestore.AggregateType.values().length];
            $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$AggregateType = iArr3;
            try {
                iArr3[GeneratedAndroidFirebaseFirestore.AggregateType.COUNT.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$AggregateType[GeneratedAndroidFirebaseFirestore.AggregateType.SUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$AggregateType[GeneratedAndroidFirebaseFirestore.AggregateType.AVERAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public static /* synthetic */ void A(GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, GeneratedAndroidFirebaseFirestore.Result result) {
        try {
            Tasks.await(getFirestoreFromPigeon(firestorePigeonFirebaseApp).disableNetwork());
            result.success(null);
        } catch (Exception e4) {
            ExceptionConverter.sendErrorToFlutter(result, e4);
        }
    }

    public static /* synthetic */ void B(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    public static /* synthetic */ void C(GeneratedAndroidFirebaseFirestore.PigeonGetOptions pigeonGetOptions, GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, String str, Boolean bool, GeneratedAndroidFirebaseFirestore.PigeonQueryParameters pigeonQueryParameters, GeneratedAndroidFirebaseFirestore.Result result) {
        try {
            Source pigeonSource = PigeonParser.parsePigeonSource(pigeonGetOptions.getSource());
            Query query = PigeonParser.parseQuery(getFirestoreFromPigeon(firestorePigeonFirebaseApp), str, bool.booleanValue(), pigeonQueryParameters);
            if (query == null) {
                result.error(new GeneratedAndroidFirebaseFirestore.FlutterError("invalid_query", "An error occurred while parsing query arguments, see native logs for more information. Please report this issue.", null));
            } else {
                result.success(PigeonParser.toPigeonQuerySnapshot((QuerySnapshot) Tasks.await(query.get(pigeonSource)), PigeonParser.parsePigeonServerTimestampBehavior(pigeonGetOptions.getServerTimestampBehavior())));
            }
        } catch (Exception e4) {
            ExceptionConverter.sendErrorToFlutter(result, e4);
        }
    }

    public static /* synthetic */ void D(GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, GeneratedAndroidFirebaseFirestore.DocumentReferenceRequest documentReferenceRequest, GeneratedAndroidFirebaseFirestore.Result result) {
        Task<Void> task;
        try {
            DocumentReference documentReferenceDocument = getFirestoreFromPigeon(firestorePigeonFirebaseApp).document(documentReferenceRequest.getPath());
            Map<Object, Object> data = documentReferenceRequest.getData();
            Objects.requireNonNull(data);
            Map<Object, Object> map = data;
            if (documentReferenceRequest.getOption().getMerge() != null && documentReferenceRequest.getOption().getMerge().booleanValue()) {
                task = documentReferenceDocument.set(map, SetOptions.merge());
            } else if (documentReferenceRequest.getOption().getMergeFields() != null) {
                List<List<String>> mergeFields = documentReferenceRequest.getOption().getMergeFields();
                Objects.requireNonNull(mergeFields);
                task = documentReferenceDocument.set(map, SetOptions.mergeFieldPaths(PigeonParser.parseFieldPath(mergeFields)));
            } else {
                task = documentReferenceDocument.set(map);
            }
            result.success((Void) Tasks.await(task));
        } catch (Exception e4) {
            ExceptionConverter.sendErrorToFlutter(result, e4);
        }
    }

    public static /* synthetic */ void E(GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, GeneratedAndroidFirebaseFirestore.Result result) {
        try {
            Tasks.await(getFirestoreFromPigeon(firestorePigeonFirebaseApp).clearPersistence());
            result.success(null);
        } catch (Exception e4) {
            ExceptionConverter.sendErrorToFlutter(result, e4);
        }
    }

    public static /* synthetic */ void H(GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, List list, GeneratedAndroidFirebaseFirestore.Result result) {
        try {
            FirebaseFirestore firestoreFromPigeon = getFirestoreFromPigeon(firestorePigeonFirebaseApp);
            WriteBatch writeBatchBatch = firestoreFromPigeon.batch();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                GeneratedAndroidFirebaseFirestore.PigeonTransactionCommand pigeonTransactionCommand = (GeneratedAndroidFirebaseFirestore.PigeonTransactionCommand) it.next();
                GeneratedAndroidFirebaseFirestore.PigeonTransactionType type = pigeonTransactionCommand.getType();
                Objects.requireNonNull(type);
                String path = pigeonTransactionCommand.getPath();
                Objects.requireNonNull(path);
                Map<String, Object> data = pigeonTransactionCommand.getData();
                DocumentReference documentReferenceDocument = firestoreFromPigeon.document(path);
                int i4 = AnonymousClass1.$SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$PigeonTransactionType[type.ordinal()];
                if (i4 == 1) {
                    writeBatchBatch = writeBatchBatch.delete(documentReferenceDocument);
                } else if (i4 == 2) {
                    Objects.requireNonNull(data);
                    writeBatchBatch = writeBatchBatch.update(documentReferenceDocument, data);
                } else if (i4 == 3) {
                    GeneratedAndroidFirebaseFirestore.PigeonDocumentOption option = pigeonTransactionCommand.getOption();
                    Objects.requireNonNull(option);
                    if (option.getMerge() != null && option.getMerge().booleanValue()) {
                        Objects.requireNonNull(data);
                        writeBatchBatch = writeBatchBatch.set(documentReferenceDocument, data, SetOptions.merge());
                    } else if (option.getMergeFields() != null) {
                        List<List<String>> mergeFields = option.getMergeFields();
                        Objects.requireNonNull(mergeFields);
                        List<FieldPath> fieldPath = PigeonParser.parseFieldPath(mergeFields);
                        Objects.requireNonNull(data);
                        writeBatchBatch = writeBatchBatch.set(documentReferenceDocument, data, SetOptions.mergeFieldPaths(fieldPath));
                    } else {
                        Objects.requireNonNull(data);
                        writeBatchBatch = writeBatchBatch.set(documentReferenceDocument, data);
                    }
                }
            }
            Tasks.await(writeBatchBatch.commit());
            result.success(null);
        } catch (Exception e4) {
            ExceptionConverter.sendErrorToFlutter(result, e4);
        }
    }

    public static /* synthetic */ void I(GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, GeneratedAndroidFirebaseFirestore.Result result) {
        try {
            Tasks.await(getFirestoreFromPigeon(firestorePigeonFirebaseApp).waitForPendingWrites());
            result.success(null);
        } catch (Exception e4) {
            ExceptionConverter.sendErrorToFlutter(result, e4);
        }
    }

    public static /* synthetic */ void J(GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, GeneratedAndroidFirebaseFirestore.DocumentReferenceRequest documentReferenceRequest, GeneratedAndroidFirebaseFirestore.Result result) {
        try {
            DocumentReference documentReferenceDocument = getFirestoreFromPigeon(firestorePigeonFirebaseApp).document(documentReferenceRequest.getPath());
            Map<Object, Object> data = documentReferenceRequest.getData();
            Objects.requireNonNull(data);
            Map<Object, Object> map = data;
            HashMap map2 = new HashMap();
            for (Object obj : map.keySet()) {
                if (obj instanceof String) {
                    map2.put(FieldPath.of((String) obj), map.get(obj));
                } else {
                    if (!(obj instanceof FieldPath)) {
                        throw new IllegalArgumentException("Invalid key type in update data. Supported types are String and FieldPath.");
                    }
                    map2.put((FieldPath) obj, map.get(obj));
                }
            }
            FieldPath fieldPath = (FieldPath) map2.keySet().iterator().next();
            Object obj2 = map2.get(fieldPath);
            ArrayList arrayList = new ArrayList();
            for (FieldPath fieldPath2 : map2.keySet()) {
                if (!fieldPath2.equals(fieldPath)) {
                    arrayList.add(fieldPath2);
                    arrayList.add(map2.get(fieldPath2));
                }
            }
            result.success((Void) Tasks.await(documentReferenceDocument.update(fieldPath, obj2, arrayList.toArray())));
        } catch (Exception e4) {
            ExceptionConverter.sendErrorToFlutter(result, e4);
        }
    }

    public static /* synthetic */ void L(GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, String str, GeneratedAndroidFirebaseFirestore.Result result) {
        try {
            Tasks.await(getFirestoreFromPigeon(firestorePigeonFirebaseApp).setIndexConfiguration(str));
            result.success(null);
        } catch (Exception e4) {
            ExceptionConverter.sendErrorToFlutter(result, e4);
        }
    }

    public static /* synthetic */ void M(AggregateQuery aggregateQuery, GeneratedAndroidFirebaseFirestore.AggregateSource aggregateSource, List list, GeneratedAndroidFirebaseFirestore.Result result) {
        try {
            AggregateQuerySnapshot aggregateQuerySnapshot = (AggregateQuerySnapshot) Tasks.await(aggregateQuery.get(PigeonParser.parseAggregateSource(aggregateSource)));
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                GeneratedAndroidFirebaseFirestore.AggregateQuery aggregateQuery2 = (GeneratedAndroidFirebaseFirestore.AggregateQuery) it.next();
                int i4 = AnonymousClass1.$SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$AggregateType[aggregateQuery2.getType().ordinal()];
                if (i4 == 1) {
                    GeneratedAndroidFirebaseFirestore.AggregateQueryResponse.Builder builder = new GeneratedAndroidFirebaseFirestore.AggregateQueryResponse.Builder();
                    builder.setType(GeneratedAndroidFirebaseFirestore.AggregateType.COUNT);
                    builder.setValue(Double.valueOf(aggregateQuerySnapshot.getCount()));
                    arrayList.add(builder.build());
                } else if (i4 == 2) {
                    GeneratedAndroidFirebaseFirestore.AggregateQueryResponse.Builder builder2 = new GeneratedAndroidFirebaseFirestore.AggregateQueryResponse.Builder();
                    builder2.setType(GeneratedAndroidFirebaseFirestore.AggregateType.SUM);
                    Object obj = aggregateQuerySnapshot.get(AggregateField.sum(aggregateQuery2.getField()));
                    Objects.requireNonNull(obj);
                    builder2.setValue(Double.valueOf(((Number) obj).doubleValue()));
                    builder2.setField(aggregateQuery2.getField());
                    arrayList.add(builder2.build());
                } else if (i4 == 3) {
                    GeneratedAndroidFirebaseFirestore.AggregateQueryResponse.Builder builder3 = new GeneratedAndroidFirebaseFirestore.AggregateQueryResponse.Builder();
                    builder3.setType(GeneratedAndroidFirebaseFirestore.AggregateType.AVERAGE);
                    builder3.setValue(aggregateQuerySnapshot.get(AggregateField.average(aggregateQuery2.getField())));
                    builder3.setField(aggregateQuery2.getField());
                    arrayList.add(builder3.build());
                }
            }
            result.success(arrayList);
        } catch (Exception e4) {
            ExceptionConverter.sendErrorToFlutter(result, e4);
        }
    }

    public static /* synthetic */ void N(GeneratedAndroidFirebaseFirestore.DocumentReferenceRequest documentReferenceRequest, GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, GeneratedAndroidFirebaseFirestore.Result result) {
        try {
            result.success(PigeonParser.toPigeonDocumentSnapshot((DocumentSnapshot) Tasks.await(getFirestoreFromPigeon(firestorePigeonFirebaseApp).document(documentReferenceRequest.getPath()).get(PigeonParser.parsePigeonSource(documentReferenceRequest.getSource()))), PigeonParser.parsePigeonServerTimestampBehavior(documentReferenceRequest.getServerTimestampBehavior())));
        } catch (Exception e4) {
            ExceptionConverter.sendErrorToFlutter(result, e4);
        }
    }

    public static /* synthetic */ void O(GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, GeneratedAndroidFirebaseFirestore.Result result) {
        try {
            FirebaseFirestore firestoreFromPigeon = getFirestoreFromPigeon(firestorePigeonFirebaseApp);
            Tasks.await(firestoreFromPigeon.terminate());
            destroyCachedFirebaseFirestoreInstanceForKey(firestoreFromPigeon);
            result.success(null);
        } catch (Exception e4) {
            ExceptionConverter.sendErrorToFlutter(result, e4);
        }
    }

    public static /* synthetic */ void P(Boolean bool, GeneratedAndroidFirebaseFirestore.Result result) {
        try {
            FirebaseFirestore.setLoggingEnabled(bool.booleanValue());
            result.success(null);
        } catch (Exception e4) {
            ExceptionConverter.sendErrorToFlutter(result, e4);
        }
    }

    public static /* synthetic */ void Q(GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, String str, GeneratedAndroidFirebaseFirestore.Result result, GeneratedAndroidFirebaseFirestore.PigeonGetOptions pigeonGetOptions) {
        try {
            Query query = (Query) Tasks.await(getFirestoreFromPigeon(firestorePigeonFirebaseApp).getNamedQuery(str));
            if (query == null) {
                result.error(new NullPointerException("Named query has not been found. Please check it has been loaded properly via loadBundle()."));
            } else {
                result.success(PigeonParser.toPigeonQuerySnapshot((QuerySnapshot) Tasks.await(query.get(PigeonParser.parsePigeonSource(pigeonGetOptions.getSource()))), PigeonParser.parsePigeonServerTimestampBehavior(pigeonGetOptions.getServerTimestampBehavior())));
            }
        } catch (Exception e4) {
            ExceptionConverter.sendErrorToFlutter(result, e4);
        }
    }

    private void attachToActivity(ActivityPluginBinding activityPluginBinding) {
        this.activity.set(activityPluginBinding.getActivity());
    }

    private static void destroyCachedFirebaseFirestoreInstanceForKey(FirebaseFirestore firebaseFirestore) {
        HashMap<FirebaseFirestore, FlutterFirebaseFirestoreExtension> map = firestoreInstanceCache;
        synchronized (map) {
            try {
                if (map.get(firebaseFirestore) != null) {
                    map.remove(firebaseFirestore);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void detachToActivity() {
        this.activity.set(null);
    }

    public static FlutterFirebaseFirestoreExtension getCachedFirebaseFirestoreInstanceForKey(FirebaseFirestore firebaseFirestore) {
        FlutterFirebaseFirestoreExtension flutterFirebaseFirestoreExtension;
        HashMap<FirebaseFirestore, FlutterFirebaseFirestoreExtension> map = firestoreInstanceCache;
        synchronized (map) {
            flutterFirebaseFirestoreExtension = map.get(firebaseFirestore);
        }
        return flutterFirebaseFirestoreExtension;
    }

    public static FirebaseFirestore getFirestoreFromPigeon(GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp) {
        synchronized (firestoreInstanceCache) {
            try {
                FirebaseFirestore firestoreInstanceByNameAndDatabaseUrl = getFirestoreInstanceByNameAndDatabaseUrl(firestorePigeonFirebaseApp.getAppName(), firestorePigeonFirebaseApp.getDatabaseURL());
                if (firestoreInstanceByNameAndDatabaseUrl != null) {
                    return firestoreInstanceByNameAndDatabaseUrl;
                }
                FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance(FirebaseApp.getInstance(firestorePigeonFirebaseApp.getAppName()), firestorePigeonFirebaseApp.getDatabaseURL());
                firebaseFirestore.setFirestoreSettings(getSettingsFromPigeon(firestorePigeonFirebaseApp));
                setCachedFirebaseFirestoreInstanceForKey(firebaseFirestore, firestorePigeonFirebaseApp.getDatabaseURL());
                return firebaseFirestore;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static FirebaseFirestore getFirestoreInstanceByNameAndDatabaseUrl(String str, String str2) {
        HashMap<FirebaseFirestore, FlutterFirebaseFirestoreExtension> map = firestoreInstanceCache;
        synchronized (map) {
            try {
                for (Map.Entry<FirebaseFirestore, FlutterFirebaseFirestoreExtension> entry : map.entrySet()) {
                    if (entry.getValue().getInstance().getApp().getName().equals(str) && entry.getValue().getDatabaseURL().equals(str2)) {
                        return entry.getKey();
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static FirebaseFirestoreSettings getSettingsFromPigeon(GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp) {
        FirebaseFirestoreSettings.Builder builder = new FirebaseFirestoreSettings.Builder();
        if (firestorePigeonFirebaseApp.getSettings().getHost() != null) {
            builder.setHost(firestorePigeonFirebaseApp.getSettings().getHost());
        }
        if (firestorePigeonFirebaseApp.getSettings().getSslEnabled() != null) {
            builder.setSslEnabled(firestorePigeonFirebaseApp.getSettings().getSslEnabled().booleanValue());
        }
        if (firestorePigeonFirebaseApp.getSettings().getPersistenceEnabled() != null) {
            if (firestorePigeonFirebaseApp.getSettings().getPersistenceEnabled().booleanValue()) {
                Long cacheSizeBytes = firestorePigeonFirebaseApp.getSettings().getCacheSizeBytes();
                builder.setLocalCacheSettings(PersistentCacheSettings.newBuilder().setSizeBytes((cacheSizeBytes == null || cacheSizeBytes.longValue() == -1) ? 104857600L : cacheSizeBytes.longValue()).build());
            } else {
                builder.setLocalCacheSettings(MemoryCacheSettings.newBuilder().build());
            }
        }
        return builder.build();
    }

    private void initInstance(BinaryMessenger binaryMessenger) {
        this.binaryMessenger = binaryMessenger;
        FlutterFirebasePluginRegistry.registerPlugin(METHOD_CHANNEL_NAME, this);
        GeneratedAndroidFirebaseFirestore.FirebaseFirestoreHostApi.setup(this.binaryMessenger, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didReinitializeFirebaseCore$1(TaskCompletionSource taskCompletionSource) {
        try {
            HashMap<FirebaseFirestore, FlutterFirebaseFirestoreExtension> map = firestoreInstanceCache;
            synchronized (map) {
                try {
                    Iterator<Map.Entry<FirebaseFirestore, FlutterFirebaseFirestoreExtension>> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        FirebaseFirestore key = it.next().getKey();
                        Tasks.await(key.terminate());
                        destroyCachedFirebaseFirestoreInstanceForKey(key);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            removeEventListeners();
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$transactionCreate$11(String str, Transaction transaction) {
        this.transactions.put(str, transaction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$transactionGet$12(GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, String str, String str2, GeneratedAndroidFirebaseFirestore.Result result) {
        try {
            DocumentReference documentReferenceDocument = getFirestoreFromPigeon(firestorePigeonFirebaseApp).document(str);
            Transaction transaction = this.transactions.get(str2);
            if (transaction != null) {
                result.success(PigeonParser.toPigeonDocumentSnapshot(transaction.get(documentReferenceDocument), DocumentSnapshot.ServerTimestampBehavior.NONE));
                return;
            }
            result.error(new Exception("Transaction.getDocument(): No transaction handler exists for ID: " + str2));
        } catch (Exception e4) {
            ExceptionConverter.sendErrorToFlutter(result, e4);
        }
    }

    private String registerEventChannel(String str, EventChannel.StreamHandler streamHandler) {
        return registerEventChannel(str, UUID.randomUUID().toString().toLowerCase(Locale.US), streamHandler);
    }

    private void removeEventListeners() {
        synchronized (this.eventChannels) {
            try {
                Iterator<String> it = this.eventChannels.keySet().iterator();
                while (it.hasNext()) {
                    EventChannel eventChannel = this.eventChannels.get(it.next());
                    Objects.requireNonNull(eventChannel);
                    eventChannel.setStreamHandler(null);
                }
                this.eventChannels.clear();
            } finally {
            }
        }
        synchronized (this.streamHandlers) {
            try {
                Iterator<String> it2 = this.streamHandlers.keySet().iterator();
                while (it2.hasNext()) {
                    EventChannel.StreamHandler streamHandler = this.streamHandlers.get(it2.next());
                    Objects.requireNonNull(streamHandler);
                    streamHandler.onCancel(null);
                }
                this.streamHandlers.clear();
            } finally {
            }
        }
        this.transactionHandlers.clear();
    }

    public static void setCachedFirebaseFirestoreInstanceForKey(FirebaseFirestore firebaseFirestore, String str) {
        HashMap<FirebaseFirestore, FlutterFirebaseFirestoreExtension> map = firestoreInstanceCache;
        synchronized (map) {
            try {
                if (map.get(firebaseFirestore) == null) {
                    map.put(firebaseFirestore, new FlutterFirebaseFirestoreExtension(firebaseFirestore, str));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ void x(GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, GeneratedAndroidFirebaseFirestore.DocumentReferenceRequest documentReferenceRequest, GeneratedAndroidFirebaseFirestore.Result result) {
        try {
            result.success((Void) Tasks.await(getFirestoreFromPigeon(firestorePigeonFirebaseApp).document(documentReferenceRequest.getPath()).delete()));
        } catch (Exception e4) {
            ExceptionConverter.sendErrorToFlutter(result, e4);
        }
    }

    public static /* synthetic */ void y(GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, GeneratedAndroidFirebaseFirestore.PersistenceCacheIndexManagerRequest persistenceCacheIndexManagerRequest, GeneratedAndroidFirebaseFirestore.Result result) {
        PersistentCacheIndexManager persistentCacheIndexManager = getFirestoreFromPigeon(firestorePigeonFirebaseApp).getPersistentCacheIndexManager();
        if (persistentCacheIndexManager != null) {
            int i4 = AnonymousClass1.$SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$PersistenceCacheIndexManagerRequest[persistenceCacheIndexManagerRequest.ordinal()];
            if (i4 == 1) {
                persistentCacheIndexManager.enableIndexAutoCreation();
            } else if (i4 == 2) {
                persistentCacheIndexManager.disableIndexAutoCreation();
            } else if (i4 == 3) {
                persistentCacheIndexManager.deleteAllIndexes();
            }
        } else {
            Log.d(TAG, "`PersistentCacheIndexManager` is not available.");
        }
        result.success(null);
    }

    public static /* synthetic */ void z(GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, GeneratedAndroidFirebaseFirestore.Result result) {
        try {
            Tasks.await(getFirestoreFromPigeon(firestorePigeonFirebaseApp).enableNetwork());
            result.success(null);
        } catch (Exception e4) {
            ExceptionConverter.sendErrorToFlutter(result, e4);
        }
    }

    @Override // io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore.FirebaseFirestoreHostApi
    public void aggregateQuery(GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, String str, GeneratedAndroidFirebaseFirestore.PigeonQueryParameters pigeonQueryParameters, final GeneratedAndroidFirebaseFirestore.AggregateSource aggregateSource, final List<GeneratedAndroidFirebaseFirestore.AggregateQuery> list, Boolean bool, final GeneratedAndroidFirebaseFirestore.Result<List<GeneratedAndroidFirebaseFirestore.AggregateQueryResponse>> result) {
        Query query = PigeonParser.parseQuery(getFirestoreFromPigeon(firestorePigeonFirebaseApp), str, bool.booleanValue(), pigeonQueryParameters);
        ArrayList arrayList = new ArrayList();
        for (GeneratedAndroidFirebaseFirestore.AggregateQuery aggregateQuery : list) {
            int i4 = AnonymousClass1.$SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$AggregateType[aggregateQuery.getType().ordinal()];
            if (i4 == 1) {
                arrayList.add(AggregateField.count());
            } else if (i4 == 2) {
                arrayList.add(AggregateField.sum(aggregateQuery.getField()));
            } else if (i4 == 3) {
                arrayList.add(AggregateField.average(aggregateQuery.getField()));
            }
        }
        final AggregateQuery aggregateQueryAggregate = query.aggregate((AggregateField) arrayList.get(0), (AggregateField[]) arrayList.subList(1, arrayList.size()).toArray(new AggregateField[0]));
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.firestore.q
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseFirestorePlugin.M(aggregateQueryAggregate, aggregateSource, list, result);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore.FirebaseFirestoreHostApi
    public void clearPersistence(final GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, final GeneratedAndroidFirebaseFirestore.Result<Void> result) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.firestore.c
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseFirestorePlugin.E(firestorePigeonFirebaseApp, result);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Void> didReinitializeFirebaseCore() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.firestore.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f12605a.lambda$didReinitializeFirebaseCore$1(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore.FirebaseFirestoreHostApi
    public void disableNetwork(final GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, final GeneratedAndroidFirebaseFirestore.Result<Void> result) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.firestore.e
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseFirestorePlugin.A(firestorePigeonFirebaseApp, result);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore.FirebaseFirestoreHostApi
    public void documentReferenceDelete(final GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, final GeneratedAndroidFirebaseFirestore.DocumentReferenceRequest documentReferenceRequest, final GeneratedAndroidFirebaseFirestore.Result<Void> result) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.firestore.g
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseFirestorePlugin.x(firestorePigeonFirebaseApp, documentReferenceRequest, result);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore.FirebaseFirestoreHostApi
    public void documentReferenceGet(final GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, final GeneratedAndroidFirebaseFirestore.DocumentReferenceRequest documentReferenceRequest, final GeneratedAndroidFirebaseFirestore.Result<GeneratedAndroidFirebaseFirestore.PigeonDocumentSnapshot> result) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.firestore.i
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseFirestorePlugin.N(documentReferenceRequest, firestorePigeonFirebaseApp, result);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore.FirebaseFirestoreHostApi
    public void documentReferenceSet(final GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, final GeneratedAndroidFirebaseFirestore.DocumentReferenceRequest documentReferenceRequest, final GeneratedAndroidFirebaseFirestore.Result<Void> result) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.firestore.h
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseFirestorePlugin.D(firestorePigeonFirebaseApp, documentReferenceRequest, result);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore.FirebaseFirestoreHostApi
    public void documentReferenceSnapshot(GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, GeneratedAndroidFirebaseFirestore.DocumentReferenceRequest documentReferenceRequest, Boolean bool, GeneratedAndroidFirebaseFirestore.ListenSource listenSource, GeneratedAndroidFirebaseFirestore.Result<String> result) {
        result.success(registerEventChannel("plugins.flutter.io/firebase_firestore/document", new DocumentSnapshotsStreamHandler(getFirestoreFromPigeon(firestorePigeonFirebaseApp), getFirestoreFromPigeon(firestorePigeonFirebaseApp).document(documentReferenceRequest.getPath()), bool, PigeonParser.parsePigeonServerTimestampBehavior(documentReferenceRequest.getServerTimestampBehavior()), PigeonParser.parseListenSource(listenSource))));
    }

    @Override // io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore.FirebaseFirestoreHostApi
    public void documentReferenceUpdate(final GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, final GeneratedAndroidFirebaseFirestore.DocumentReferenceRequest documentReferenceRequest, final GeneratedAndroidFirebaseFirestore.Result<Void> result) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.firestore.s
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseFirestorePlugin.J(firestorePigeonFirebaseApp, documentReferenceRequest, result);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore.FirebaseFirestoreHostApi
    public void enableNetwork(final GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, final GeneratedAndroidFirebaseFirestore.Result<Void> result) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.firestore.l
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseFirestorePlugin.z(firestorePigeonFirebaseApp, result);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Map<String, Object>> getPluginConstantsForFirebaseApp(FirebaseApp firebaseApp) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.firestore.a
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseFirestorePlugin.B(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore.FirebaseFirestoreHostApi
    public void loadBundle(GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, byte[] bArr, GeneratedAndroidFirebaseFirestore.Result<String> result) {
        result.success(registerEventChannel("plugins.flutter.io/firebase_firestore/loadBundle", new LoadBundleStreamHandler(getFirestoreFromPigeon(firestorePigeonFirebaseApp), bArr)));
    }

    @Override // io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore.FirebaseFirestoreHostApi
    public void namedQueryGet(final GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, final String str, final GeneratedAndroidFirebaseFirestore.PigeonGetOptions pigeonGetOptions, final GeneratedAndroidFirebaseFirestore.Result<GeneratedAndroidFirebaseFirestore.PigeonQuerySnapshot> result) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.firestore.b
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseFirestorePlugin.Q(firestorePigeonFirebaseApp, str, result, pigeonGetOptions);
            }
        });
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        attachToActivity(activityPluginBinding);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        initInstance(flutterPluginBinding.getBinaryMessenger());
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        detachToActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        detachToActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        removeEventListeners();
        this.binaryMessenger = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        attachToActivity(activityPluginBinding);
    }

    @Override // io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore.FirebaseFirestoreHostApi
    public void persistenceCacheIndexManagerRequest(final GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, final GeneratedAndroidFirebaseFirestore.PersistenceCacheIndexManagerRequest persistenceCacheIndexManagerRequest, final GeneratedAndroidFirebaseFirestore.Result<Void> result) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.firestore.r
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseFirestorePlugin.y(firestorePigeonFirebaseApp, persistenceCacheIndexManagerRequest, result);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore.FirebaseFirestoreHostApi
    public void queryGet(final GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, final String str, final Boolean bool, final GeneratedAndroidFirebaseFirestore.PigeonQueryParameters pigeonQueryParameters, final GeneratedAndroidFirebaseFirestore.PigeonGetOptions pigeonGetOptions, final GeneratedAndroidFirebaseFirestore.Result<GeneratedAndroidFirebaseFirestore.PigeonQuerySnapshot> result) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.firestore.m
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseFirestorePlugin.C(pigeonGetOptions, firestorePigeonFirebaseApp, str, bool, pigeonQueryParameters, result);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore.FirebaseFirestoreHostApi
    public void querySnapshot(GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, String str, Boolean bool, GeneratedAndroidFirebaseFirestore.PigeonQueryParameters pigeonQueryParameters, GeneratedAndroidFirebaseFirestore.PigeonGetOptions pigeonGetOptions, Boolean bool2, GeneratedAndroidFirebaseFirestore.ListenSource listenSource, GeneratedAndroidFirebaseFirestore.Result<String> result) {
        Query query = PigeonParser.parseQuery(getFirestoreFromPigeon(firestorePigeonFirebaseApp), str, bool.booleanValue(), pigeonQueryParameters);
        if (query == null) {
            result.error(new GeneratedAndroidFirebaseFirestore.FlutterError("invalid_query", "An error occurred while parsing query arguments, see native logs for more information. Please report this issue.", null));
        } else {
            result.success(registerEventChannel("plugins.flutter.io/firebase_firestore/query", new QuerySnapshotsStreamHandler(query, bool2, PigeonParser.parsePigeonServerTimestampBehavior(pigeonGetOptions.getServerTimestampBehavior()), PigeonParser.parseListenSource(listenSource))));
        }
    }

    @Override // io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore.FirebaseFirestoreHostApi
    public void setIndexConfiguration(final GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, final String str, final GeneratedAndroidFirebaseFirestore.Result<Void> result) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.firestore.t
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseFirestorePlugin.L(firestorePigeonFirebaseApp, str, result);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore.FirebaseFirestoreHostApi
    public void setLoggingEnabled(final Boolean bool, final GeneratedAndroidFirebaseFirestore.Result<Void> result) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.firestore.j
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseFirestorePlugin.P(bool, result);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore.FirebaseFirestoreHostApi
    public void snapshotsInSyncSetup(GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, GeneratedAndroidFirebaseFirestore.Result<String> result) {
        result.success(registerEventChannel("plugins.flutter.io/firebase_firestore/snapshotsInSync", new SnapshotsInSyncStreamHandler(getFirestoreFromPigeon(firestorePigeonFirebaseApp))));
    }

    @Override // io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore.FirebaseFirestoreHostApi
    public void terminate(final GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, final GeneratedAndroidFirebaseFirestore.Result<Void> result) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.firestore.p
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseFirestorePlugin.O(firestorePigeonFirebaseApp, result);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore.FirebaseFirestoreHostApi
    public void transactionCreate(GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, Long l4, Long l5, GeneratedAndroidFirebaseFirestore.Result<String> result) {
        FirebaseFirestore firestoreFromPigeon = getFirestoreFromPigeon(firestorePigeonFirebaseApp);
        final String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        TransactionStreamHandler transactionStreamHandler = new TransactionStreamHandler(new TransactionStreamHandler.OnTransactionStartedListener() { // from class: io.flutter.plugins.firebase.firestore.k
            @Override // io.flutter.plugins.firebase.firestore.streamhandler.TransactionStreamHandler.OnTransactionStartedListener
            public final void onStarted(Transaction transaction) {
                this.f12618a.lambda$transactionCreate$11(lowerCase, transaction);
            }
        }, firestoreFromPigeon, lowerCase, l4, l5);
        registerEventChannel("plugins.flutter.io/firebase_firestore/transaction", lowerCase, transactionStreamHandler);
        this.transactionHandlers.put(lowerCase, transactionStreamHandler);
        result.success(lowerCase);
    }

    @Override // io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore.FirebaseFirestoreHostApi
    public void transactionGet(final GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, final String str, final String str2, final GeneratedAndroidFirebaseFirestore.Result<GeneratedAndroidFirebaseFirestore.PigeonDocumentSnapshot> result) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.firestore.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f12598a.lambda$transactionGet$12(firestorePigeonFirebaseApp, str2, str, result);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore.FirebaseFirestoreHostApi
    public void transactionStoreResult(String str, GeneratedAndroidFirebaseFirestore.PigeonTransactionResult pigeonTransactionResult, List<GeneratedAndroidFirebaseFirestore.PigeonTransactionCommand> list, GeneratedAndroidFirebaseFirestore.Result<Void> result) {
        OnTransactionResultListener onTransactionResultListener = this.transactionHandlers.get(str);
        Objects.requireNonNull(onTransactionResultListener);
        onTransactionResultListener.receiveTransactionResponse(pigeonTransactionResult, list);
        result.success(null);
    }

    @Override // io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore.FirebaseFirestoreHostApi
    public void waitForPendingWrites(final GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, final GeneratedAndroidFirebaseFirestore.Result<Void> result) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.firestore.n
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseFirestorePlugin.I(firestorePigeonFirebaseApp, result);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore.FirebaseFirestoreHostApi
    public void writeBatchCommit(final GeneratedAndroidFirebaseFirestore.FirestorePigeonFirebaseApp firestorePigeonFirebaseApp, final List<GeneratedAndroidFirebaseFirestore.PigeonTransactionCommand> list, final GeneratedAndroidFirebaseFirestore.Result<Void> result) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.firestore.o
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseFirestorePlugin.H(firestorePigeonFirebaseApp, list, result);
            }
        });
    }

    private String registerEventChannel(String str, String str2, EventChannel.StreamHandler streamHandler) {
        EventChannel eventChannel = new EventChannel(this.binaryMessenger, str + RemoteSettings.FORWARD_SLASH_STRING + str2, this.MESSAGE_CODEC);
        eventChannel.setStreamHandler(streamHandler);
        this.eventChannels.put(str2, eventChannel);
        this.streamHandlers.put(str2, streamHandler);
        return str2;
    }
}
