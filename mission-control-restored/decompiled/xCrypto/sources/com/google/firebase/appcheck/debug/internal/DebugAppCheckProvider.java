package com.google.firebase.appcheck.debug.internal;

import android.util.Log;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.AppCheckProvider;
import com.google.firebase.appcheck.AppCheckToken;
import com.google.firebase.appcheck.debug.InternalDebugSecretProvider;
import com.google.firebase.appcheck.internal.AppCheckTokenResponse;
import com.google.firebase.appcheck.internal.DefaultAppCheckToken;
import com.google.firebase.appcheck.internal.NetworkClient;
import com.google.firebase.appcheck.internal.RetryManager;
import com.google.firebase.inject.Provider;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class DebugAppCheckProvider implements AppCheckProvider {
    private static final String TAG = "com.google.firebase.appcheck.debug.internal.DebugAppCheckProvider";
    private static final String UTF_8 = "UTF-8";
    private final Executor blockingExecutor;
    private final Task<String> debugSecretTask;
    private final Executor liteExecutor;
    private final NetworkClient networkClient;
    private final RetryManager retryManager;

    public DebugAppCheckProvider(FirebaseApp firebaseApp, Provider<InternalDebugSecretProvider> provider, Executor executor, Executor executor2, Executor executor3) {
        AbstractC0940s.k(firebaseApp);
        this.networkClient = new NetworkClient(firebaseApp);
        this.liteExecutor = executor;
        this.blockingExecutor = executor3;
        this.retryManager = new RetryManager();
        String debugSecret = provider.get() != null ? provider.get().getDebugSecret() : null;
        this.debugSecretTask = debugSecret == null ? determineDebugSecret(firebaseApp, executor2) : Tasks.forResult(debugSecret);
    }

    public static /* synthetic */ Task a(final DebugAppCheckProvider debugAppCheckProvider, String str) {
        debugAppCheckProvider.getClass();
        final ExchangeDebugTokenRequest exchangeDebugTokenRequest = new ExchangeDebugTokenRequest(str);
        return Tasks.call(debugAppCheckProvider.blockingExecutor, new Callable() { // from class: com.google.firebase.appcheck.debug.internal.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                DebugAppCheckProvider debugAppCheckProvider2 = this.f10204a;
                return debugAppCheckProvider2.networkClient.exchangeAttestationForAppCheckToken(exchangeDebugTokenRequest.toJsonString().getBytes(DebugAppCheckProvider.UTF_8), 2, debugAppCheckProvider2.retryManager);
            }
        });
    }

    public static /* synthetic */ void d(FirebaseApp firebaseApp, TaskCompletionSource taskCompletionSource) {
        StorageHelper storageHelper = new StorageHelper(firebaseApp.getApplicationContext(), firebaseApp.getPersistenceKey());
        String strRetrieveDebugSecret = storageHelper.retrieveDebugSecret();
        if (strRetrieveDebugSecret == null) {
            strRetrieveDebugSecret = UUID.randomUUID().toString();
            storageHelper.saveDebugSecret(strRetrieveDebugSecret);
        }
        Log.d(TAG, "Enter this debug secret into the allow list in the Firebase Console for your project: " + strRetrieveDebugSecret);
        taskCompletionSource.setResult(strRetrieveDebugSecret);
    }

    public static Task<String> determineDebugSecret(final FirebaseApp firebaseApp, Executor executor) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new Runnable() { // from class: com.google.firebase.appcheck.debug.internal.d
            @Override // java.lang.Runnable
            public final void run() {
                DebugAppCheckProvider.d(firebaseApp, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // com.google.firebase.appcheck.AppCheckProvider
    public Task<AppCheckToken> getToken() {
        return this.debugSecretTask.onSuccessTask(this.liteExecutor, new SuccessContinuation() { // from class: com.google.firebase.appcheck.debug.internal.a
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return DebugAppCheckProvider.a(this.f10203a, (String) obj);
            }
        }).onSuccessTask(this.liteExecutor, new SuccessContinuation() { // from class: com.google.firebase.appcheck.debug.internal.b
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return Tasks.forResult(DefaultAppCheckToken.constructFromAppCheckTokenResponse((AppCheckTokenResponse) obj));
            }
        });
    }

    public DebugAppCheckProvider(String str, NetworkClient networkClient, Executor executor, Executor executor2, RetryManager retryManager) {
        this.networkClient = networkClient;
        this.liteExecutor = executor;
        this.blockingExecutor = executor2;
        this.retryManager = retryManager;
        this.debugSecretTask = Tasks.forResult(str);
    }
}
