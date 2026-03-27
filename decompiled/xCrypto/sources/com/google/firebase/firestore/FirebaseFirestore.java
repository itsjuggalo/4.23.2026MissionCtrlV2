package com.google.firebase.firestore;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.emulators.EmulatedServiceSettings;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.Transaction;
import com.google.firebase.firestore.WriteBatch;
import com.google.firebase.firestore.auth.CredentialsProvider;
import com.google.firebase.firestore.auth.FirebaseAppCheckTokenProvider;
import com.google.firebase.firestore.auth.FirebaseAuthCredentialsProvider;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.core.ActivityScope;
import com.google.firebase.firestore.core.AsyncEventListener;
import com.google.firebase.firestore.core.ComponentProvider;
import com.google.firebase.firestore.core.DatabaseInfo;
import com.google.firebase.firestore.core.FirestoreClient;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.remote.FirestoreChannel;
import com.google.firebase.firestore.remote.GrpcMetadataProvider;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.ByteBufferInputStream;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Function;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firebase.inject.Deferred;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.revenuecat.purchases.common.Constants;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class FirebaseFirestore {
    private static final String TAG = "FirebaseFirestore";
    private final CredentialsProvider<String> appCheckProvider;
    private final CredentialsProvider<User> authProvider;
    private final Function<FirebaseFirestoreSettings, ComponentProvider> componentProviderFactory;
    private final Context context;
    private final DatabaseId databaseId;
    private EmulatedServiceSettings emulatorSettings;
    private final FirebaseApp firebaseApp;
    private final InstanceRegistry instanceRegistry;
    private final GrpcMetadataProvider metadataProvider;
    private final String persistenceKey;
    private PersistentCacheIndexManager persistentCacheIndexManager;
    private final UserDataReader userDataReader;
    final FirestoreClientProvider clientProvider = new FirestoreClientProvider(new Function() { // from class: com.google.firebase.firestore.r
        @Override // com.google.firebase.firestore.util.Function
        public final Object apply(Object obj) {
            return this.f10658a.newClient((AsyncQueue) obj);
        }
    });
    private FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder().build();

    public interface InstanceRegistry {
        void remove(String str);
    }

    public FirebaseFirestore(Context context, DatabaseId databaseId, String str, CredentialsProvider<User> credentialsProvider, CredentialsProvider<String> credentialsProvider2, Function<FirebaseFirestoreSettings, ComponentProvider> function, FirebaseApp firebaseApp, InstanceRegistry instanceRegistry, GrpcMetadataProvider grpcMetadataProvider) {
        this.context = (Context) Preconditions.checkNotNull(context);
        this.databaseId = (DatabaseId) Preconditions.checkNotNull((DatabaseId) Preconditions.checkNotNull(databaseId));
        this.userDataReader = new UserDataReader(databaseId);
        this.persistenceKey = (String) Preconditions.checkNotNull(str);
        this.authProvider = (CredentialsProvider) Preconditions.checkNotNull(credentialsProvider);
        this.appCheckProvider = (CredentialsProvider) Preconditions.checkNotNull(credentialsProvider2);
        this.componentProviderFactory = (Function) Preconditions.checkNotNull(function);
        this.firebaseApp = firebaseApp;
        this.instanceRegistry = instanceRegistry;
        this.metadataProvider = grpcMetadataProvider;
    }

    public static /* synthetic */ void a(FirebaseFirestore firebaseFirestore, TaskCompletionSource taskCompletionSource) {
        firebaseFirestore.getClass();
        try {
            SQLitePersistence.clearPersistence(firebaseFirestore.context, firebaseFirestore.databaseId, firebaseFirestore.persistenceKey);
            taskCompletionSource.setResult(null);
        } catch (FirebaseFirestoreException e4) {
            taskCompletionSource.setException(e4);
        }
    }

    public static /* synthetic */ Query b(FirebaseFirestore firebaseFirestore, Task task) {
        firebaseFirestore.getClass();
        com.google.firebase.firestore.core.Query query = (com.google.firebase.firestore.core.Query) task.getResult();
        if (query != null) {
            return new Query(query, firebaseFirestore);
        }
        return null;
    }

    public static /* synthetic */ void c(AsyncEventListener asyncEventListener, FirestoreClient firestoreClient) {
        asyncEventListener.mute();
        firestoreClient.removeSnapshotsInSyncListener(asyncEventListener);
    }

    public static /* synthetic */ Task f(final FirebaseFirestore firebaseFirestore, Executor executor, final Transaction.Function function, final com.google.firebase.firestore.core.Transaction transaction) {
        firebaseFirestore.getClass();
        return Tasks.call(executor, new Callable() { // from class: com.google.firebase.firestore.q
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FirebaseFirestore.j(this.f10655a, function, transaction);
            }
        });
    }

    public static /* synthetic */ ListenerRegistration g(final AsyncEventListener asyncEventListener, Activity activity, final FirestoreClient firestoreClient) {
        firestoreClient.addSnapshotsInSyncListener(asyncEventListener);
        return ActivityScope.bind(activity, new ListenerRegistration() { // from class: com.google.firebase.firestore.u
            @Override // com.google.firebase.firestore.ListenerRegistration
            public final void remove() {
                FirebaseFirestore.c(asyncEventListener, firestoreClient);
            }
        });
    }

    private static FirebaseApp getDefaultFirebaseApp() {
        FirebaseApp firebaseApp = FirebaseApp.getInstance();
        if (firebaseApp != null) {
            return firebaseApp;
        }
        throw new IllegalStateException("You must call FirebaseApp.initializeApp first.");
    }

    public static FirebaseFirestore getInstance() {
        return getInstance(getDefaultFirebaseApp(), "(default)");
    }

    public static /* synthetic */ void h(Runnable runnable, Void r22, FirebaseFirestoreException firebaseFirestoreException) {
        Assert.hardAssert(firebaseFirestoreException == null, "snapshots-in-sync listeners should never get errors.", new Object[0]);
        runnable.run();
    }

    public static /* synthetic */ Object j(FirebaseFirestore firebaseFirestore, Transaction.Function function, com.google.firebase.firestore.core.Transaction transaction) {
        firebaseFirestore.getClass();
        return function.apply(new Transaction(transaction, firebaseFirestore));
    }

    private FirebaseFirestoreSettings mergeEmulatorSettings(FirebaseFirestoreSettings firebaseFirestoreSettings, EmulatedServiceSettings emulatedServiceSettings) {
        if (emulatedServiceSettings == null) {
            return firebaseFirestoreSettings;
        }
        if (!FirebaseFirestoreSettings.DEFAULT_HOST.equals(firebaseFirestoreSettings.getHost())) {
            Logger.warn(TAG, "Host has been set in FirebaseFirestoreSettings and useEmulator, emulator host will be used.", new Object[0]);
        }
        return new FirebaseFirestoreSettings.Builder(firebaseFirestoreSettings).setHost(emulatedServiceSettings.getHost() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + emulatedServiceSettings.getPort()).setSslEnabled(false).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FirestoreClient newClient(AsyncQueue asyncQueue) {
        FirestoreClient firestoreClient;
        synchronized (this.clientProvider) {
            firestoreClient = new FirestoreClient(this.context, new DatabaseInfo(this.databaseId, this.persistenceKey, this.settings.getHost(), this.settings.isSslEnabled()), this.authProvider, this.appCheckProvider, asyncQueue, this.metadataProvider, this.componentProviderFactory.apply(this.settings));
        }
        return firestoreClient;
    }

    public static FirebaseFirestore newInstance(Context context, FirebaseApp firebaseApp, Deferred<InternalAuthProvider> deferred, Deferred<InteropAppCheckTokenProvider> deferred2, String str, InstanceRegistry instanceRegistry, GrpcMetadataProvider grpcMetadataProvider) {
        String projectId = firebaseApp.getOptions().getProjectId();
        if (projectId == null) {
            throw new IllegalArgumentException("FirebaseOptions.getProjectId() cannot be null");
        }
        return new FirebaseFirestore(context, DatabaseId.forDatabase(projectId, str), firebaseApp.getName(), new FirebaseAuthCredentialsProvider(deferred), new FirebaseAppCheckTokenProvider(deferred2), new Function() { // from class: com.google.firebase.firestore.t
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                return ComponentProvider.defaultFactory((FirebaseFirestoreSettings) obj);
            }
        }, firebaseApp, instanceRegistry, grpcMetadataProvider);
    }

    private <ResultT> Task<ResultT> runTransaction(final TransactionOptions transactionOptions, final Transaction.Function<ResultT> function, final Executor executor) {
        this.clientProvider.ensureConfigured();
        final Function function2 = new Function() { // from class: com.google.firebase.firestore.z
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                return FirebaseFirestore.f(this.f10739a, executor, function, (com.google.firebase.firestore.core.Transaction) obj);
            }
        };
        return (Task) this.clientProvider.call(new Function() { // from class: com.google.firebase.firestore.A
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                return ((FirestoreClient) obj).transaction(transactionOptions, function2);
            }
        });
    }

    public static void setClientLanguage(String str) {
        FirestoreChannel.setClientLanguage(str);
    }

    public static void setLoggingEnabled(boolean z4) {
        if (z4) {
            Logger.setLogLevel(Logger.Level.DEBUG);
        } else {
            Logger.setLogLevel(Logger.Level.WARN);
        }
    }

    public ListenerRegistration addSnapshotsInSyncListener(Runnable runnable) {
        return addSnapshotsInSyncListener(Executors.DEFAULT_CALLBACK_EXECUTOR, runnable);
    }

    public WriteBatch batch() {
        this.clientProvider.ensureConfigured();
        return new WriteBatch(this);
    }

    public <T> T callClient(Function<FirestoreClient, T> function) {
        return (T) this.clientProvider.call(function);
    }

    public Task<Void> clearPersistence() {
        return (Task) this.clientProvider.executeIfShutdown(new Function() { // from class: com.google.firebase.firestore.x
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                return this.f10738a.clearPersistence((Executor) obj);
            }
        }, new Function() { // from class: com.google.firebase.firestore.y
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                return Tasks.forException(new FirebaseFirestoreException("Persistence cannot be cleared while the firestore instance is running.", FirebaseFirestoreException.Code.FAILED_PRECONDITION));
            }
        });
    }

    public CollectionReference collection(String str) {
        Preconditions.checkNotNull(str, "Provided collection path must not be null.");
        this.clientProvider.ensureConfigured();
        return new CollectionReference(ResourcePath.fromString(str), this);
    }

    public Query collectionGroup(String str) {
        Preconditions.checkNotNull(str, "Provided collection ID must not be null.");
        if (str.contains(RemoteSettings.FORWARD_SLASH_STRING)) {
            throw new IllegalArgumentException(String.format("Invalid collectionId '%s'. Collection IDs must not contain '/'.", str));
        }
        this.clientProvider.ensureConfigured();
        return new Query(new com.google.firebase.firestore.core.Query(ResourcePath.EMPTY, str), this);
    }

    public Task<Void> disableNetwork() {
        return (Task) this.clientProvider.call(new Function() { // from class: com.google.firebase.firestore.s
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                return ((FirestoreClient) obj).disableNetwork();
            }
        });
    }

    public DocumentReference document(String str) {
        Preconditions.checkNotNull(str, "Provided document path must not be null.");
        this.clientProvider.ensureConfigured();
        return DocumentReference.forPath(ResourcePath.fromString(str), this);
    }

    public Task<Void> enableNetwork() {
        return (Task) this.clientProvider.call(new Function() { // from class: com.google.firebase.firestore.o
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                return ((FirestoreClient) obj).enableNetwork();
            }
        });
    }

    public FirebaseApp getApp() {
        return this.firebaseApp;
    }

    public DatabaseId getDatabaseId() {
        return this.databaseId;
    }

    public FirebaseFirestoreSettings getFirestoreSettings() {
        return this.settings;
    }

    public Task<Query> getNamedQuery(final String str) {
        return ((Task) this.clientProvider.call(new Function() { // from class: com.google.firebase.firestore.v
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                return ((FirestoreClient) obj).getNamedQuery(str);
            }
        })).continueWith(new Continuation() { // from class: com.google.firebase.firestore.w
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return FirebaseFirestore.b(this.f10737a, task);
            }
        });
    }

    public PersistentCacheIndexManager getPersistentCacheIndexManager() {
        this.clientProvider.ensureConfigured();
        if (this.persistentCacheIndexManager == null && (this.settings.isPersistenceEnabled() || (this.settings.getCacheSettings() instanceof PersistentCacheSettings))) {
            this.persistentCacheIndexManager = new PersistentCacheIndexManager(this.clientProvider);
        }
        return this.persistentCacheIndexManager;
    }

    public UserDataReader getUserDataReader() {
        return this.userDataReader;
    }

    public LoadBundleTask loadBundle(final InputStream inputStream) {
        final LoadBundleTask loadBundleTask = new LoadBundleTask();
        this.clientProvider.procedure(new G.a() { // from class: com.google.firebase.firestore.n
            @Override // G.a
            public final void accept(Object obj) {
                ((FirestoreClient) obj).loadBundle(inputStream, loadBundleTask);
            }
        });
        return loadBundleTask;
    }

    public Task<Void> runBatch(WriteBatch.Function function) {
        WriteBatch writeBatchBatch = batch();
        function.apply(writeBatchBatch);
        return writeBatchBatch.commit();
    }

    public void setFirestoreSettings(FirebaseFirestoreSettings firebaseFirestoreSettings) {
        Preconditions.checkNotNull(firebaseFirestoreSettings, "Provided settings must not be null.");
        synchronized (this.databaseId) {
            try {
                FirebaseFirestoreSettings firebaseFirestoreSettingsMergeEmulatorSettings = mergeEmulatorSettings(firebaseFirestoreSettings, this.emulatorSettings);
                if (this.clientProvider.isConfigured() && !this.settings.equals(firebaseFirestoreSettingsMergeEmulatorSettings)) {
                    throw new IllegalStateException("FirebaseFirestore has already been started and its settings can no longer be changed. You can only call setFirestoreSettings() before calling any other methods on a FirebaseFirestore object.");
                }
                this.settings = firebaseFirestoreSettingsMergeEmulatorSettings;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Deprecated
    public Task<Void> setIndexConfiguration(String str) {
        this.clientProvider.ensureConfigured();
        Preconditions.checkState(this.settings.isPersistenceEnabled(), "Cannot enable indexes when persistence is disabled");
        final ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("indexes")) {
                JSONArray jSONArray = jSONObject.getJSONArray("indexes");
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                    String string = jSONObject2.getString("collectionGroup");
                    ArrayList arrayList2 = new ArrayList();
                    JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("fields");
                    for (int i5 = 0; jSONArrayOptJSONArray != null && i5 < jSONArrayOptJSONArray.length(); i5++) {
                        JSONObject jSONObject3 = jSONArrayOptJSONArray.getJSONObject(i5);
                        com.google.firebase.firestore.model.FieldPath fieldPathFromServerFormat = com.google.firebase.firestore.model.FieldPath.fromServerFormat(jSONObject3.getString("fieldPath"));
                        if ("CONTAINS".equals(jSONObject3.optString("arrayConfig"))) {
                            arrayList2.add(FieldIndex.Segment.create(fieldPathFromServerFormat, FieldIndex.Segment.Kind.CONTAINS));
                        } else if ("ASCENDING".equals(jSONObject3.optString("order"))) {
                            arrayList2.add(FieldIndex.Segment.create(fieldPathFromServerFormat, FieldIndex.Segment.Kind.ASCENDING));
                        } else {
                            arrayList2.add(FieldIndex.Segment.create(fieldPathFromServerFormat, FieldIndex.Segment.Kind.DESCENDING));
                        }
                    }
                    arrayList.add(FieldIndex.create(-1, string, arrayList2, FieldIndex.INITIAL_STATE));
                }
            }
            return (Task) this.clientProvider.call(new Function() { // from class: com.google.firebase.firestore.D
                @Override // com.google.firebase.firestore.util.Function
                public final Object apply(Object obj) {
                    return ((FirestoreClient) obj).configureFieldIndexes(arrayList);
                }
            });
        } catch (JSONException e4) {
            throw new IllegalArgumentException("Failed to parse index configuration", e4);
        }
    }

    public Task<Void> terminate() {
        this.instanceRegistry.remove(getDatabaseId().getDatabaseId());
        return this.clientProvider.terminate();
    }

    public void useEmulator(String str, int i4) {
        synchronized (this.clientProvider) {
            try {
                if (this.clientProvider.isConfigured()) {
                    throw new IllegalStateException("Cannot call useEmulator() after instance has already been initialized.");
                }
                EmulatedServiceSettings emulatedServiceSettings = new EmulatedServiceSettings(str, i4);
                this.emulatorSettings = emulatedServiceSettings;
                this.settings = mergeEmulatorSettings(this.settings, emulatedServiceSettings);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void validateReference(DocumentReference documentReference) {
        Preconditions.checkNotNull(documentReference, "Provided DocumentReference must not be null.");
        if (documentReference.getFirestore() != this) {
            throw new IllegalArgumentException("Provided document reference is from a different Cloud Firestore instance.");
        }
    }

    public Task<Void> waitForPendingWrites() {
        return (Task) this.clientProvider.call(new Function() { // from class: com.google.firebase.firestore.m
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                return ((FirestoreClient) obj).waitForPendingWrites();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task<Void> clearPersistence(Executor executor) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new Runnable() { // from class: com.google.firebase.firestore.p
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseFirestore.a(this.f10653a, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public static FirebaseFirestore getInstance(FirebaseApp firebaseApp) {
        return getInstance(firebaseApp, "(default)");
    }

    public ListenerRegistration addSnapshotsInSyncListener(Activity activity, Runnable runnable) {
        return addSnapshotsInSyncListener(Executors.DEFAULT_CALLBACK_EXECUTOR, activity, runnable);
    }

    public static FirebaseFirestore getInstance(String str) {
        return getInstance(getDefaultFirebaseApp(), str);
    }

    public ListenerRegistration addSnapshotsInSyncListener(Executor executor, Runnable runnable) {
        return addSnapshotsInSyncListener(executor, null, runnable);
    }

    public LoadBundleTask loadBundle(byte[] bArr) {
        return loadBundle(new ByteArrayInputStream(bArr));
    }

    private ListenerRegistration addSnapshotsInSyncListener(Executor executor, final Activity activity, final Runnable runnable) {
        final AsyncEventListener asyncEventListener = new AsyncEventListener(executor, new EventListener() { // from class: com.google.firebase.firestore.B
            @Override // com.google.firebase.firestore.EventListener
            public final void onEvent(Object obj, FirebaseFirestoreException firebaseFirestoreException) {
                FirebaseFirestore.h(runnable, (Void) obj, firebaseFirestoreException);
            }
        });
        return (ListenerRegistration) this.clientProvider.call(new Function() { // from class: com.google.firebase.firestore.C
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                return FirebaseFirestore.g(asyncEventListener, activity, (FirestoreClient) obj);
            }
        });
    }

    public static FirebaseFirestore getInstance(FirebaseApp firebaseApp, String str) {
        Preconditions.checkNotNull(firebaseApp, "Provided FirebaseApp must not be null.");
        Preconditions.checkNotNull(str, "Provided database name must not be null.");
        FirestoreMultiDbComponent firestoreMultiDbComponent = (FirestoreMultiDbComponent) firebaseApp.get(FirestoreMultiDbComponent.class);
        Preconditions.checkNotNull(firestoreMultiDbComponent, "Firestore component is not present.");
        return firestoreMultiDbComponent.get(str);
    }

    public LoadBundleTask loadBundle(ByteBuffer byteBuffer) {
        return loadBundle(new ByteBufferInputStream(byteBuffer));
    }

    public <TResult> Task<TResult> runTransaction(Transaction.Function<TResult> function) {
        return runTransaction(TransactionOptions.DEFAULT, function);
    }

    public <TResult> Task<TResult> runTransaction(TransactionOptions transactionOptions, Transaction.Function<TResult> function) {
        Preconditions.checkNotNull(function, "Provided transaction update function must not be null.");
        return runTransaction(transactionOptions, function, com.google.firebase.firestore.core.Transaction.getDefaultExecutor());
    }
}
