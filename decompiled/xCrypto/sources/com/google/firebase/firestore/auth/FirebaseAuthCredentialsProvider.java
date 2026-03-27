package com.google.firebase.firestore.auth;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Listener;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.InternalTokenResult;

/* JADX INFO: loaded from: classes.dex */
public final class FirebaseAuthCredentialsProvider extends CredentialsProvider<User> {
    private static final String LOG_TAG = "FirebaseAuthCredentialsProvider";
    private Listener<User> changeListener;
    private boolean forceRefresh;
    private final IdTokenListener idTokenListener = new IdTokenListener() { // from class: com.google.firebase.firestore.auth.d
        @Override // com.google.firebase.auth.internal.IdTokenListener
        public final void onIdTokenChanged(InternalTokenResult internalTokenResult) {
            this.f10396a.onIdTokenChanged();
        }
    };
    private InternalAuthProvider internalAuthProvider;
    private int tokenCounter;

    public FirebaseAuthCredentialsProvider(Deferred<InternalAuthProvider> deferred) {
        deferred.whenAvailable(new Deferred.DeferredHandler() { // from class: com.google.firebase.firestore.auth.e
            @Override // com.google.firebase.inject.Deferred.DeferredHandler
            public final void handle(Provider provider) {
                FirebaseAuthCredentialsProvider.b(this.f10397a, provider);
            }
        });
    }

    public static /* synthetic */ Task a(FirebaseAuthCredentialsProvider firebaseAuthCredentialsProvider, int i4, Task task) {
        synchronized (firebaseAuthCredentialsProvider) {
            try {
                if (i4 != firebaseAuthCredentialsProvider.tokenCounter) {
                    Logger.debug(LOG_TAG, "getToken aborted due to token change", new Object[0]);
                    return firebaseAuthCredentialsProvider.getToken();
                }
                if (task.isSuccessful()) {
                    return Tasks.forResult(((GetTokenResult) task.getResult()).getToken());
                }
                return Tasks.forException(task.getException());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ void b(FirebaseAuthCredentialsProvider firebaseAuthCredentialsProvider, Provider provider) {
        synchronized (firebaseAuthCredentialsProvider) {
            firebaseAuthCredentialsProvider.internalAuthProvider = (InternalAuthProvider) provider.get();
            firebaseAuthCredentialsProvider.onIdTokenChanged();
            firebaseAuthCredentialsProvider.internalAuthProvider.addIdTokenListener(firebaseAuthCredentialsProvider.idTokenListener);
        }
    }

    private synchronized User getUser() {
        String uid;
        try {
            InternalAuthProvider internalAuthProvider = this.internalAuthProvider;
            uid = internalAuthProvider == null ? null : internalAuthProvider.getUid();
        } catch (Throwable th) {
            throw th;
        }
        return uid != null ? new User(uid) : User.UNAUTHENTICATED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onIdTokenChanged() {
        this.tokenCounter++;
        Listener<User> listener = this.changeListener;
        if (listener != null) {
            listener.onValue(getUser());
        }
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public synchronized Task<String> getToken() {
        InternalAuthProvider internalAuthProvider = this.internalAuthProvider;
        if (internalAuthProvider == null) {
            return Tasks.forException(new FirebaseApiNotAvailableException("auth is not available"));
        }
        Task<GetTokenResult> accessToken = internalAuthProvider.getAccessToken(this.forceRefresh);
        this.forceRefresh = false;
        final int i4 = this.tokenCounter;
        return accessToken.continueWithTask(Executors.DIRECT_EXECUTOR, new Continuation() { // from class: com.google.firebase.firestore.auth.f
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return FirebaseAuthCredentialsProvider.a(this.f10398a, i4, task);
            }
        });
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public synchronized void invalidateToken() {
        this.forceRefresh = true;
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public synchronized void removeChangeListener() {
        this.changeListener = null;
        InternalAuthProvider internalAuthProvider = this.internalAuthProvider;
        if (internalAuthProvider != null) {
            internalAuthProvider.removeIdTokenListener(this.idTokenListener);
        }
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public synchronized void setChangeListener(Listener<User> listener) {
        this.changeListener = listener;
        listener.onValue(getUser());
    }
}
