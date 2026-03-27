package com.google.firebase.firestore.remote;

import K2.AbstractC0359g;
import K2.Z;
import K2.a0;
import K2.l0;
import android.content.Context;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.BuildConfig;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.auth.CredentialsProvider;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.core.DatabaseInfo;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Util;

/* JADX INFO: loaded from: classes.dex */
public class FirestoreChannel {
    private static final Z.g RESOURCE_PREFIX_HEADER;
    private static final Z.g X_GOOG_API_CLIENT_HEADER;
    private static final Z.g X_GOOG_REQUEST_PARAMS_HEADER;
    private static volatile String clientLanguage;
    private final CredentialsProvider<String> appCheckProvider;
    private final AsyncQueue asyncQueue;
    private final CredentialsProvider<User> authProvider;
    private final GrpcCallProvider callProvider;
    private final GrpcMetadataProvider metadataProvider;
    private final String resourcePrefixValue;

    static {
        Z.d dVar = Z.f1097e;
        X_GOOG_API_CLIENT_HEADER = Z.g.e("x-goog-api-client", dVar);
        RESOURCE_PREFIX_HEADER = Z.g.e("google-cloud-resource-prefix", dVar);
        X_GOOG_REQUEST_PARAMS_HEADER = Z.g.e("x-goog-request-params", dVar);
        clientLanguage = "gl-java/";
    }

    public FirestoreChannel(AsyncQueue asyncQueue, Context context, CredentialsProvider<User> credentialsProvider, CredentialsProvider<String> credentialsProvider2, DatabaseInfo databaseInfo, GrpcMetadataProvider grpcMetadataProvider) {
        this(asyncQueue, credentialsProvider, credentialsProvider2, databaseInfo.getDatabaseId(), grpcMetadataProvider, getGrpcCallProvider(asyncQueue, context, credentialsProvider, credentialsProvider2, databaseInfo));
    }

    public static /* synthetic */ void a(FirestoreChannel firestoreChannel, final StreamingListener streamingListener, Object obj, Task task) {
        firestoreChannel.getClass();
        final AbstractC0359g abstractC0359g = (AbstractC0359g) task.getResult();
        abstractC0359g.start(new AbstractC0359g.a() { // from class: com.google.firebase.firestore.remote.FirestoreChannel.3
            @Override // K2.AbstractC0359g.a
            public void onClose(l0 l0Var, Z z4) {
                streamingListener.onClose(l0Var);
            }

            @Override // K2.AbstractC0359g.a
            public void onMessage(RespT respt) {
                streamingListener.onMessage(respt);
                abstractC0359g.request(1);
            }
        }, firestoreChannel.requestHeaders());
        abstractC0359g.request(1);
        abstractC0359g.sendMessage(obj);
        abstractC0359g.halfClose();
    }

    public static /* synthetic */ void b(FirestoreChannel firestoreChannel, final TaskCompletionSource taskCompletionSource, Object obj, Task task) {
        firestoreChannel.getClass();
        AbstractC0359g abstractC0359g = (AbstractC0359g) task.getResult();
        abstractC0359g.start(new AbstractC0359g.a() { // from class: com.google.firebase.firestore.remote.FirestoreChannel.4
            @Override // K2.AbstractC0359g.a
            public void onClose(l0 l0Var, Z z4) {
                if (!l0Var.o()) {
                    taskCompletionSource.setException(FirestoreChannel.this.exceptionFromStatus(l0Var));
                } else {
                    if (taskCompletionSource.getTask().isComplete()) {
                        return;
                    }
                    taskCompletionSource.setException(new FirebaseFirestoreException("Received onClose with status OK, but no message.", FirebaseFirestoreException.Code.INTERNAL));
                }
            }

            @Override // K2.AbstractC0359g.a
            public void onMessage(RespT respt) {
                taskCompletionSource.setResult(respt);
            }
        }, firestoreChannel.requestHeaders());
        abstractC0359g.request(2);
        abstractC0359g.sendMessage(obj);
        abstractC0359g.halfClose();
    }

    public static /* synthetic */ void c(FirestoreChannel firestoreChannel, final AbstractC0359g[] abstractC0359gArr, final IncomingStreamObserver incomingStreamObserver, Task task) {
        firestoreChannel.getClass();
        AbstractC0359g abstractC0359g = (AbstractC0359g) task.getResult();
        abstractC0359gArr[0] = abstractC0359g;
        abstractC0359g.start(new AbstractC0359g.a() { // from class: com.google.firebase.firestore.remote.FirestoreChannel.1
            @Override // K2.AbstractC0359g.a
            public void onClose(l0 l0Var, Z z4) {
                try {
                    incomingStreamObserver.onClose(l0Var);
                } catch (Throwable th) {
                    FirestoreChannel.this.asyncQueue.panic(th);
                }
            }

            @Override // K2.AbstractC0359g.a
            public void onHeaders(Z z4) {
                try {
                    incomingStreamObserver.onHeaders(z4);
                } catch (Throwable th) {
                    FirestoreChannel.this.asyncQueue.panic(th);
                }
            }

            @Override // K2.AbstractC0359g.a
            public void onMessage(RespT respt) {
                try {
                    incomingStreamObserver.onNext(respt);
                    abstractC0359gArr[0].request(1);
                } catch (Throwable th) {
                    FirestoreChannel.this.asyncQueue.panic(th);
                }
            }

            @Override // K2.AbstractC0359g.a
            public void onReady() {
            }
        }, firestoreChannel.requestHeaders());
        incomingStreamObserver.onOpen();
        abstractC0359gArr[0].request(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FirebaseFirestoreException exceptionFromStatus(l0 l0Var) {
        return Datastore.isMissingSslCiphers(l0Var) ? new FirebaseFirestoreException("The Cloud Firestore client failed to establish a secure connection. This is likely a problem with your app, rather than with Cloud Firestore itself. See https://bit.ly/2XFpdma for instructions on how to enable TLS on Android 4.x devices.", FirebaseFirestoreException.Code.fromValue(l0Var.m().g()), l0Var.l()) : Util.exceptionFromStatus(l0Var);
    }

    private String getGoogApiClientValue() {
        return String.format("%s fire/%s grpc/", clientLanguage, BuildConfig.VERSION_NAME);
    }

    private static GrpcCallProvider getGrpcCallProvider(AsyncQueue asyncQueue, Context context, CredentialsProvider<User> credentialsProvider, CredentialsProvider<String> credentialsProvider2, DatabaseInfo databaseInfo) {
        return new GrpcCallProvider(asyncQueue, context, databaseInfo, new FirestoreCallCredentials(credentialsProvider, credentialsProvider2));
    }

    private Z requestHeaders() {
        Z z4 = new Z();
        z4.p(X_GOOG_API_CLIENT_HEADER, getGoogApiClientValue());
        z4.p(RESOURCE_PREFIX_HEADER, this.resourcePrefixValue);
        z4.p(X_GOOG_REQUEST_PARAMS_HEADER, this.resourcePrefixValue);
        GrpcMetadataProvider grpcMetadataProvider = this.metadataProvider;
        if (grpcMetadataProvider != null) {
            grpcMetadataProvider.updateMetadata(z4);
        }
        return z4;
    }

    public static void setClientLanguage(String str) {
        clientLanguage = str;
    }

    public void invalidateToken() {
        this.authProvider.invalidateToken();
        this.appCheckProvider.invalidateToken();
    }

    public <ReqT, RespT> AbstractC0359g runBidiStreamingRpc(a0 a0Var, final IncomingStreamObserver<RespT> incomingStreamObserver) {
        final AbstractC0359g[] abstractC0359gArr = {null};
        final Task<AbstractC0359g> taskCreateClientCall = this.callProvider.createClientCall(a0Var);
        taskCreateClientCall.addOnCompleteListener(this.asyncQueue.getExecutor(), new OnCompleteListener() { // from class: com.google.firebase.firestore.remote.l
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirestoreChannel.c(this.f10681a, abstractC0359gArr, incomingStreamObserver, task);
            }
        });
        return new K2.A() { // from class: com.google.firebase.firestore.remote.FirestoreChannel.2
            @Override // K2.A, K2.f0
            public AbstractC0359g delegate() {
                Assert.hardAssert(abstractC0359gArr[0] != null, "ClientCall used before onOpen() callback", new Object[0]);
                return abstractC0359gArr[0];
            }

            @Override // K2.A, K2.f0, K2.AbstractC0359g
            public void halfClose() {
                if (abstractC0359gArr[0] == null) {
                    taskCreateClientCall.addOnSuccessListener(FirestoreChannel.this.asyncQueue.getExecutor(), new OnSuccessListener() { // from class: com.google.firebase.firestore.remote.o
                        @Override // com.google.android.gms.tasks.OnSuccessListener
                        public final void onSuccess(Object obj) {
                            ((AbstractC0359g) obj).halfClose();
                        }
                    });
                } else {
                    super.halfClose();
                }
            }
        };
    }

    public <ReqT, RespT> Task<RespT> runRpc(a0 a0Var, final ReqT reqt) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.callProvider.createClientCall(a0Var).addOnCompleteListener(this.asyncQueue.getExecutor(), new OnCompleteListener() { // from class: com.google.firebase.firestore.remote.m
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirestoreChannel.b(this.f10684a, taskCompletionSource, reqt, task);
            }
        });
        return taskCompletionSource.getTask();
    }

    public <ReqT, RespT> void runStreamingResponseRpc(a0 a0Var, final ReqT reqt, final StreamingListener<RespT> streamingListener) {
        this.callProvider.createClientCall(a0Var).addOnCompleteListener(this.asyncQueue.getExecutor(), new OnCompleteListener() { // from class: com.google.firebase.firestore.remote.n
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirestoreChannel.a(this.f10687a, streamingListener, reqt, task);
            }
        });
    }

    public void shutdown() {
        this.callProvider.shutdown();
    }

    public FirestoreChannel(AsyncQueue asyncQueue, CredentialsProvider<User> credentialsProvider, CredentialsProvider<String> credentialsProvider2, DatabaseId databaseId, GrpcMetadataProvider grpcMetadataProvider, GrpcCallProvider grpcCallProvider) {
        this.asyncQueue = asyncQueue;
        this.metadataProvider = grpcMetadataProvider;
        this.authProvider = credentialsProvider;
        this.appCheckProvider = credentialsProvider2;
        this.callProvider = grpcCallProvider;
        this.resourcePrefixValue = String.format("projects/%s/databases/%s", databaseId.getProjectId(), databaseId.getDatabaseId());
    }

    public static abstract class StreamingListener<T> {
        public void onMessage(T t4) {
        }

        public void onClose(l0 l0Var) {
        }
    }
}
