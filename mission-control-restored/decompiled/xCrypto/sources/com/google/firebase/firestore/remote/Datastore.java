package com.google.firebase.firestore.remote;

import K2.l0;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.AggregateField;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationResult;
import com.google.firebase.firestore.remote.FirestoreChannel;
import com.google.firebase.firestore.remote.WatchStream;
import com.google.firebase.firestore.remote.WriteStream;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLHandshakeException;
import p2.C1695A;
import p2.C1698D;
import p2.C1707d;
import p2.C1708e;
import p2.C1711h;
import p2.C1712i;
import p2.w;

/* JADX INFO: loaded from: classes.dex */
public class Datastore {
    static final String SSL_DEPENDENCY_ERROR_MESSAGE = "The Cloud Firestore client failed to establish a secure connection. This is likely a problem with your app, rather than with Cloud Firestore itself. See https://bit.ly/2XFpdma for instructions on how to enable TLS on Android 4.x devices.";
    static final Set<String> WHITE_LISTED_HEADERS = new HashSet(Arrays.asList("date", "x-google-backends", "x-google-netmon-label", "x-google-service", "x-google-gfe-request-trace"));
    private final FirestoreChannel channel;
    protected final RemoteSerializer serializer;
    private final AsyncQueue workerQueue;

    /* JADX INFO: renamed from: com.google.firebase.firestore.remote.Datastore$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code;

        static {
            int[] iArr = new int[FirebaseFirestoreException.Code.values().length];
            $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code = iArr;
            try {
                iArr[FirebaseFirestoreException.Code.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.CANCELLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.DEADLINE_EXCEEDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.RESOURCE_EXHAUSTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.INTERNAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.UNAVAILABLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.UNAUTHENTICATED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.INVALID_ARGUMENT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.NOT_FOUND.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.ALREADY_EXISTS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.PERMISSION_DENIED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.FAILED_PRECONDITION.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.ABORTED.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.OUT_OF_RANGE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.UNIMPLEMENTED.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.DATA_LOSS.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public Datastore(AsyncQueue asyncQueue, RemoteSerializer remoteSerializer, FirestoreChannel firestoreChannel) {
        this.workerQueue = asyncQueue;
        this.serializer = remoteSerializer;
        this.channel = firestoreChannel;
    }

    public static /* synthetic */ List a(Datastore datastore, Task task) throws Exception {
        datastore.getClass();
        if (!task.isSuccessful()) {
            if ((task.getException() instanceof FirebaseFirestoreException) && ((FirebaseFirestoreException) task.getException()).getCode() == FirebaseFirestoreException.Code.UNAUTHENTICATED) {
                datastore.channel.invalidateToken();
            }
            throw task.getException();
        }
        C1712i c1712i = (C1712i) task.getResult();
        SnapshotVersion snapshotVersionDecodeVersion = datastore.serializer.decodeVersion(c1712i.k());
        int iN = c1712i.n();
        ArrayList arrayList = new ArrayList(iN);
        for (int i4 = 0; i4 < iN; i4++) {
            arrayList.add(datastore.serializer.decodeMutationResult(c1712i.m(i4), snapshotVersionDecodeVersion));
        }
        return arrayList;
    }

    public static /* synthetic */ Map b(Datastore datastore, HashMap map, Task task) throws Exception {
        datastore.getClass();
        if (!task.isSuccessful()) {
            if ((task.getException() instanceof FirebaseFirestoreException) && ((FirebaseFirestoreException) task.getException()).getCode() == FirebaseFirestoreException.Code.UNAUTHENTICATED) {
                datastore.channel.invalidateToken();
            }
            throw task.getException();
        }
        HashMap map2 = new HashMap();
        for (Map.Entry entry : ((p2.x) task.getResult()).l().k().entrySet()) {
            Assert.hardAssert(map.containsKey(entry.getKey()), "%s not present in aliasMap", entry.getKey());
            map2.put((String) map.get(entry.getKey()), (C1698D) entry.getValue());
        }
        return map2;
    }

    public static boolean isMissingSslCiphers(l0 l0Var) {
        l0Var.m();
        Throwable thL = l0Var.l();
        if (!(thL instanceof SSLHandshakeException)) {
            return false;
        }
        thL.getMessage().contains("no ciphers available");
        return false;
    }

    public static boolean isPermanentError(l0 l0Var) {
        return isPermanentError(FirebaseFirestoreException.Code.fromValue(l0Var.m().g()));
    }

    public static boolean isPermanentWriteError(l0 l0Var) {
        return isPermanentError(l0Var) && !l0Var.m().equals(l0.b.ABORTED);
    }

    public Task<List<MutationResult>> commit(List<Mutation> list) {
        C1711h.b bVarN = C1711h.n();
        bVarN.g(this.serializer.databaseName());
        Iterator<Mutation> it = list.iterator();
        while (it.hasNext()) {
            bVarN.f(this.serializer.encodeMutation(it.next()));
        }
        return this.channel.runRpc(p2.r.b(), (C1711h) bVarN.build()).continueWith(this.workerQueue.getExecutor(), new Continuation() { // from class: com.google.firebase.firestore.remote.j
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return Datastore.a(this.f10677a, task);
            }
        });
    }

    public WatchStream createWatchStream(WatchStream.Callback callback) {
        return new WatchStream(this.channel, this.workerQueue, this.serializer, callback);
    }

    public WriteStream createWriteStream(WriteStream.Callback callback) {
        return new WriteStream(this.channel, this.workerQueue, this.serializer, callback);
    }

    public AsyncQueue getWorkerQueue() {
        return this.workerQueue;
    }

    public Task<List<MutableDocument>> lookup(final List<DocumentKey> list) {
        C1707d.b bVarP = C1707d.p();
        bVarP.g(this.serializer.databaseName());
        Iterator<DocumentKey> it = list.iterator();
        while (it.hasNext()) {
            bVarP.f(this.serializer.encodeKey(it.next()));
        }
        final ArrayList arrayList = new ArrayList();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.channel.runStreamingResponseRpc(p2.r.a(), (C1707d) bVarP.build(), new FirestoreChannel.StreamingListener<C1708e>() { // from class: com.google.firebase.firestore.remote.Datastore.1
            @Override // com.google.firebase.firestore.remote.FirestoreChannel.StreamingListener
            public void onClose(l0 l0Var) {
                if (l0Var.o()) {
                    taskCompletionSource.trySetResult(Collections.EMPTY_LIST);
                    return;
                }
                FirebaseFirestoreException firebaseFirestoreExceptionExceptionFromStatus = Util.exceptionFromStatus(l0Var);
                if (firebaseFirestoreExceptionExceptionFromStatus.getCode() == FirebaseFirestoreException.Code.UNAUTHENTICATED) {
                    Datastore.this.channel.invalidateToken();
                }
                taskCompletionSource.trySetException(firebaseFirestoreExceptionExceptionFromStatus);
            }

            @Override // com.google.firebase.firestore.remote.FirestoreChannel.StreamingListener
            public void onMessage(C1708e c1708e) {
                arrayList.add(c1708e);
                if (arrayList.size() == list.size()) {
                    HashMap map = new HashMap();
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        MutableDocument mutableDocumentDecodeMaybeDocument = Datastore.this.serializer.decodeMaybeDocument((C1708e) it2.next());
                        map.put(mutableDocumentDecodeMaybeDocument.getKey(), mutableDocumentDecodeMaybeDocument);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it3 = list.iterator();
                    while (it3.hasNext()) {
                        arrayList2.add((MutableDocument) map.get((DocumentKey) it3.next()));
                    }
                    taskCompletionSource.trySetResult(arrayList2);
                }
            }
        });
        return taskCompletionSource.getTask();
    }

    public Task<Map<String, C1698D>> runAggregateQuery(Query query, List<AggregateField> list) {
        C1695A.d dVarEncodeQueryTarget = this.serializer.encodeQueryTarget(query.toAggregateTarget());
        final HashMap<String, String> map = new HashMap<>();
        p2.y yVarEncodeStructuredAggregationQuery = this.serializer.encodeStructuredAggregationQuery(dVarEncodeQueryTarget, list, map);
        w.b bVarN = p2.w.n();
        bVarN.f(dVarEncodeQueryTarget.n());
        bVarN.g(yVarEncodeStructuredAggregationQuery);
        return this.channel.runRpc(p2.r.d(), (p2.w) bVarN.build()).continueWith(this.workerQueue.getExecutor(), new Continuation() { // from class: com.google.firebase.firestore.remote.i
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return Datastore.b(this.f10675a, map, task);
            }
        });
    }

    public void shutdown() {
        this.channel.shutdown();
    }

    public static boolean isPermanentError(FirebaseFirestoreException.Code code) {
        switch (AnonymousClass2.$SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[code.ordinal()]) {
            case 1:
                throw new IllegalArgumentException("Treated status OK as error");
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return false;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
            case 16:
            case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return true;
            default:
                throw new IllegalArgumentException("Unknown gRPC status code: " + code);
        }
    }
}
