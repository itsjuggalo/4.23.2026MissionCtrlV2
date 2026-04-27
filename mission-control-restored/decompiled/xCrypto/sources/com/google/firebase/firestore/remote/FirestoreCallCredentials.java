package com.google.firebase.firestore.remote;

import K2.AbstractC0354b;
import K2.Z;
import K2.l0;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.firestore.auth.CredentialsProvider;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class FirestoreCallCredentials extends AbstractC0354b {
    private static final Z.g AUTHORIZATION_HEADER;
    private static final String LOG_TAG = "FirestoreCallCredentials";
    private static final Z.g X_FIREBASE_APPCHECK;
    private final CredentialsProvider<String> appCheckProvider;
    private final CredentialsProvider<User> authProvider;

    static {
        Z.d dVar = Z.f1097e;
        AUTHORIZATION_HEADER = Z.g.e("Authorization", dVar);
        X_FIREBASE_APPCHECK = Z.g.e("x-firebase-appcheck", dVar);
    }

    public FirestoreCallCredentials(CredentialsProvider<User> credentialsProvider, CredentialsProvider<String> credentialsProvider2) {
        this.authProvider = credentialsProvider;
        this.appCheckProvider = credentialsProvider2;
    }

    public static /* synthetic */ void a(Task task, AbstractC0354b.a aVar, Task task2, Task task3) {
        Z z4 = new Z();
        if (task.isSuccessful()) {
            String str = (String) task.getResult();
            Logger.debug(LOG_TAG, "Successfully fetched auth token.", new Object[0]);
            if (str != null) {
                z4.p(AUTHORIZATION_HEADER, "Bearer " + str);
            }
        } else {
            Exception exception = task.getException();
            if (exception instanceof FirebaseApiNotAvailableException) {
                Logger.debug(LOG_TAG, "Firebase Auth API not available, not using authentication.", new Object[0]);
            } else {
                if (!(exception instanceof FirebaseNoSignedInUserException)) {
                    Logger.warn(LOG_TAG, "Failed to get auth token: %s.", exception);
                    aVar.b(l0.f1223m.p(exception));
                    return;
                }
                Logger.debug(LOG_TAG, "No user signed in, not using authentication.", new Object[0]);
            }
        }
        if (task2.isSuccessful()) {
            String str2 = (String) task2.getResult();
            if (str2 != null && !str2.isEmpty()) {
                Logger.debug(LOG_TAG, "Successfully fetched AppCheck token.", new Object[0]);
                z4.p(X_FIREBASE_APPCHECK, str2);
            }
        } else {
            Exception exception2 = task2.getException();
            if (!(exception2 instanceof FirebaseApiNotAvailableException)) {
                Logger.warn(LOG_TAG, "Failed to get AppCheck token: %s.", exception2);
                aVar.b(l0.f1223m.p(exception2));
                return;
            }
            Logger.debug(LOG_TAG, "Firebase AppCheck API not available.", new Object[0]);
        }
        aVar.a(z4);
    }

    @Override // K2.AbstractC0354b
    public void applyRequestMetadata(AbstractC0354b.AbstractC0030b abstractC0030b, Executor executor, final AbstractC0354b.a aVar) {
        final Task<String> token = this.authProvider.getToken();
        final Task<String> token2 = this.appCheckProvider.getToken();
        Tasks.whenAll((Task<?>[]) new Task[]{token, token2}).addOnCompleteListener(Executors.DIRECT_EXECUTOR, new OnCompleteListener() { // from class: com.google.firebase.firestore.remote.k
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirestoreCallCredentials.a(token, aVar, token2, task);
            }
        });
    }

    public void thisUsesUnstableApi() {
    }
}
