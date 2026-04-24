package com.google.firebase.appcheck.internal;

import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.appcheck.AppCheckProvider;
import com.google.firebase.appcheck.AppCheckProviderFactory;
import com.google.firebase.appcheck.AppCheckToken;
import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.appcheck.FirebaseAppCheck;
import com.google.firebase.appcheck.internal.util.Clock;
import com.google.firebase.appcheck.interop.AppCheckTokenListener;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class DefaultFirebaseAppCheck extends FirebaseAppCheck {
    private static final long BUFFER_TIME_MILLIS = 300000;
    private final List<FirebaseAppCheck.AppCheckListener> appCheckListenerList;
    private AppCheckProvider appCheckProvider;
    private AppCheckProviderFactory appCheckProviderFactory;
    private final List<AppCheckTokenListener> appCheckTokenListenerList;
    private final Executor backgroundExecutor;
    private AppCheckToken cachedToken;
    private Task<AppCheckToken> cachedTokenTask;
    private final Clock clock;
    private final FirebaseApp firebaseApp;
    private final Provider<HeartBeatController> heartbeatControllerProvider;
    private final Executor liteExecutor;
    private final Task<Void> retrieveStoredTokenTask;
    private final StorageHelper storageHelper;
    private final TokenRefreshManager tokenRefreshManager;
    private final Executor uiExecutor;

    public DefaultFirebaseAppCheck(FirebaseApp firebaseApp, Provider<HeartBeatController> provider, Executor executor, Executor executor2, Executor executor3, ScheduledExecutorService scheduledExecutorService) {
        AbstractC0940s.k(firebaseApp);
        AbstractC0940s.k(provider);
        this.firebaseApp = firebaseApp;
        this.heartbeatControllerProvider = provider;
        this.appCheckTokenListenerList = new ArrayList();
        this.appCheckListenerList = new ArrayList();
        this.storageHelper = new StorageHelper(firebaseApp.getApplicationContext(), firebaseApp.getPersistenceKey());
        this.tokenRefreshManager = new TokenRefreshManager(firebaseApp.getApplicationContext(), this, executor2, scheduledExecutorService);
        this.uiExecutor = executor;
        this.liteExecutor = executor2;
        this.backgroundExecutor = executor3;
        this.retrieveStoredTokenTask = retrieveStoredAppCheckTokenInBackground(executor3);
        this.clock = new Clock.DefaultClock();
    }

    public static /* synthetic */ Task b(Task task) {
        return task.isSuccessful() ? Tasks.forResult(DefaultAppCheckTokenResult.constructFromAppCheckToken((AppCheckToken) task.getResult())) : Tasks.forResult(DefaultAppCheckTokenResult.constructFromError(new FirebaseException(task.getException().getMessage(), task.getException())));
    }

    public static /* synthetic */ Task c(DefaultFirebaseAppCheck defaultFirebaseAppCheck, AppCheckToken appCheckToken) {
        defaultFirebaseAppCheck.updateStoredToken(appCheckToken);
        Iterator<FirebaseAppCheck.AppCheckListener> it = defaultFirebaseAppCheck.appCheckListenerList.iterator();
        while (it.hasNext()) {
            it.next().onAppCheckTokenChanged(appCheckToken);
        }
        DefaultAppCheckTokenResult defaultAppCheckTokenResultConstructFromAppCheckToken = DefaultAppCheckTokenResult.constructFromAppCheckToken(appCheckToken);
        Iterator<AppCheckTokenListener> it2 = defaultFirebaseAppCheck.appCheckTokenListenerList.iterator();
        while (it2.hasNext()) {
            it2.next().onAppCheckTokenChanged(defaultAppCheckTokenResultConstructFromAppCheckToken);
        }
        return Tasks.forResult(appCheckToken);
    }

    public static /* synthetic */ Task d(DefaultFirebaseAppCheck defaultFirebaseAppCheck, boolean z4, Task task) {
        if (!z4 && defaultFirebaseAppCheck.hasValidToken()) {
            return Tasks.forResult(DefaultAppCheckTokenResult.constructFromAppCheckToken(defaultFirebaseAppCheck.cachedToken));
        }
        if (defaultFirebaseAppCheck.appCheckProvider == null) {
            return Tasks.forResult(DefaultAppCheckTokenResult.constructFromError(new FirebaseException("No AppCheckProvider installed.")));
        }
        Task<AppCheckToken> task2 = defaultFirebaseAppCheck.cachedTokenTask;
        if (task2 == null || task2.isComplete() || defaultFirebaseAppCheck.cachedTokenTask.isCanceled()) {
            defaultFirebaseAppCheck.cachedTokenTask = defaultFirebaseAppCheck.fetchTokenFromProvider();
        }
        return defaultFirebaseAppCheck.cachedTokenTask.continueWithTask(defaultFirebaseAppCheck.liteExecutor, new Continuation() { // from class: com.google.firebase.appcheck.internal.c
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task3) {
                return DefaultFirebaseAppCheck.b(task3);
            }
        });
    }

    public static /* synthetic */ Task e(DefaultFirebaseAppCheck defaultFirebaseAppCheck, boolean z4, Task task) {
        if (!z4 && defaultFirebaseAppCheck.hasValidToken()) {
            return Tasks.forResult(defaultFirebaseAppCheck.cachedToken);
        }
        if (defaultFirebaseAppCheck.appCheckProvider == null) {
            return Tasks.forException(new FirebaseException("No AppCheckProvider installed."));
        }
        Task<AppCheckToken> task2 = defaultFirebaseAppCheck.cachedTokenTask;
        if (task2 == null || task2.isComplete() || defaultFirebaseAppCheck.cachedTokenTask.isCanceled()) {
            defaultFirebaseAppCheck.cachedTokenTask = defaultFirebaseAppCheck.fetchTokenFromProvider();
        }
        return defaultFirebaseAppCheck.cachedTokenTask;
    }

    public static /* synthetic */ Task f(Task task) {
        return task.isSuccessful() ? Tasks.forResult(DefaultAppCheckTokenResult.constructFromAppCheckToken((AppCheckToken) task.getResult())) : Tasks.forResult(DefaultAppCheckTokenResult.constructFromError(new FirebaseException(task.getException().getMessage(), task.getException())));
    }

    public static /* synthetic */ void g(DefaultFirebaseAppCheck defaultFirebaseAppCheck, TaskCompletionSource taskCompletionSource) {
        AppCheckToken appCheckTokenRetrieveAppCheckToken = defaultFirebaseAppCheck.storageHelper.retrieveAppCheckToken();
        if (appCheckTokenRetrieveAppCheckToken != null) {
            defaultFirebaseAppCheck.setCachedToken(appCheckTokenRetrieveAppCheckToken);
        }
        taskCompletionSource.setResult(null);
    }

    private boolean hasValidToken() {
        AppCheckToken appCheckToken = this.cachedToken;
        return appCheckToken != null && appCheckToken.getExpireTimeMillis() - this.clock.currentTimeMillis() > BUFFER_TIME_MILLIS;
    }

    private Task<Void> retrieveStoredAppCheckTokenInBackground(Executor executor) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new Runnable() { // from class: com.google.firebase.appcheck.internal.b
            @Override // java.lang.Runnable
            public final void run() {
                DefaultFirebaseAppCheck.g(this.f10210a, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    private void updateStoredToken(final AppCheckToken appCheckToken) {
        this.backgroundExecutor.execute(new Runnable() { // from class: com.google.firebase.appcheck.internal.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f10208a.storageHelper.saveAppCheckToken(appCheckToken);
            }
        });
        setCachedToken(appCheckToken);
        this.tokenRefreshManager.maybeScheduleTokenRefresh(appCheckToken);
    }

    @Override // com.google.firebase.appcheck.FirebaseAppCheck
    public void addAppCheckListener(FirebaseAppCheck.AppCheckListener appCheckListener) {
        AbstractC0940s.k(appCheckListener);
        this.appCheckListenerList.add(appCheckListener);
        this.tokenRefreshManager.onListenerCountChanged(this.appCheckTokenListenerList.size() + this.appCheckListenerList.size());
        if (hasValidToken()) {
            appCheckListener.onAppCheckTokenChanged(this.cachedToken);
        }
    }

    @Override // com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider
    public void addAppCheckTokenListener(AppCheckTokenListener appCheckTokenListener) {
        AbstractC0940s.k(appCheckTokenListener);
        this.appCheckTokenListenerList.add(appCheckTokenListener);
        this.tokenRefreshManager.onListenerCountChanged(this.appCheckTokenListenerList.size() + this.appCheckListenerList.size());
        if (hasValidToken()) {
            appCheckTokenListener.onAppCheckTokenChanged(DefaultAppCheckTokenResult.constructFromAppCheckToken(this.cachedToken));
        }
    }

    public Task<AppCheckToken> fetchTokenFromProvider() {
        return this.appCheckProvider.getToken().onSuccessTask(this.uiExecutor, new SuccessContinuation() { // from class: com.google.firebase.appcheck.internal.g
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return DefaultFirebaseAppCheck.c(this.f10216a, (AppCheckToken) obj);
            }
        });
    }

    @Override // com.google.firebase.appcheck.FirebaseAppCheck
    public Task<AppCheckToken> getAppCheckToken(final boolean z4) {
        return this.retrieveStoredTokenTask.continueWithTask(this.liteExecutor, new Continuation() { // from class: com.google.firebase.appcheck.internal.d
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return DefaultFirebaseAppCheck.e(this.f10212a, z4, task);
            }
        });
    }

    public Provider<HeartBeatController> getHeartbeatControllerProvider() {
        return this.heartbeatControllerProvider;
    }

    public AppCheckProviderFactory getInstalledAppCheckProviderFactory() {
        return this.appCheckProviderFactory;
    }

    @Override // com.google.firebase.appcheck.FirebaseAppCheck
    public Task<AppCheckToken> getLimitedUseAppCheckToken() {
        AppCheckProvider appCheckProvider = this.appCheckProvider;
        return appCheckProvider == null ? Tasks.forException(new FirebaseException("No AppCheckProvider installed.")) : appCheckProvider.getToken();
    }

    @Override // com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider
    public Task<AppCheckTokenResult> getLimitedUseToken() {
        return getLimitedUseAppCheckToken().continueWithTask(this.liteExecutor, new Continuation() { // from class: com.google.firebase.appcheck.internal.e
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return DefaultFirebaseAppCheck.f(task);
            }
        });
    }

    @Override // com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider
    public Task<AppCheckTokenResult> getToken(final boolean z4) {
        return this.retrieveStoredTokenTask.continueWithTask(this.liteExecutor, new Continuation() { // from class: com.google.firebase.appcheck.internal.f
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return DefaultFirebaseAppCheck.d(this.f10214a, z4, task);
            }
        });
    }

    @Override // com.google.firebase.appcheck.FirebaseAppCheck
    public void installAppCheckProviderFactory(AppCheckProviderFactory appCheckProviderFactory) {
        installAppCheckProviderFactory(appCheckProviderFactory, this.firebaseApp.isDataCollectionDefaultEnabled());
    }

    @Override // com.google.firebase.appcheck.FirebaseAppCheck
    public void removeAppCheckListener(FirebaseAppCheck.AppCheckListener appCheckListener) {
        AbstractC0940s.k(appCheckListener);
        this.appCheckListenerList.remove(appCheckListener);
        this.tokenRefreshManager.onListenerCountChanged(this.appCheckTokenListenerList.size() + this.appCheckListenerList.size());
    }

    @Override // com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider
    public void removeAppCheckTokenListener(AppCheckTokenListener appCheckTokenListener) {
        AbstractC0940s.k(appCheckTokenListener);
        this.appCheckTokenListenerList.remove(appCheckTokenListener);
        this.tokenRefreshManager.onListenerCountChanged(this.appCheckTokenListenerList.size() + this.appCheckListenerList.size());
    }

    public void resetAppCheckState() {
        this.appCheckProviderFactory = null;
        this.appCheckProvider = null;
        this.cachedToken = null;
        this.storageHelper.clearSharedPrefs();
    }

    public void setCachedToken(AppCheckToken appCheckToken) {
        this.cachedToken = appCheckToken;
    }

    @Override // com.google.firebase.appcheck.FirebaseAppCheck
    public void setTokenAutoRefreshEnabled(boolean z4) {
        this.tokenRefreshManager.setIsAutoRefreshEnabled(z4);
    }

    @Override // com.google.firebase.appcheck.FirebaseAppCheck
    public void installAppCheckProviderFactory(AppCheckProviderFactory appCheckProviderFactory, boolean z4) {
        AbstractC0940s.k(appCheckProviderFactory);
        this.appCheckProviderFactory = appCheckProviderFactory;
        this.appCheckProvider = appCheckProviderFactory.create(this.firebaseApp);
        this.tokenRefreshManager.setIsAutoRefreshEnabled(z4);
    }
}
