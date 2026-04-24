package com.google.firebase.sessions;

import W2.E;
import W2.q;
import X2.AbstractC0769p;
import X2.x;
import Z2.e;
import Z2.i;
import a3.AbstractC0787c;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import b3.InterfaceC0868f;
import b3.l;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import i3.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import t3.AbstractC1822k;
import t3.InterfaceC1846w0;
import t3.L;
import t3.M;

/* JADX INFO: loaded from: classes.dex */
public final class SessionLifecycleClient {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_QUEUED_MESSAGES = 20;
    public static final String TAG = "SessionLifecycleClient";
    private final i backgroundDispatcher;
    private final LinkedBlockingDeque<Message> queuedMessages;
    private Messenger service;
    private boolean serviceBound;
    private final SessionLifecycleClient$serviceConnection$1 serviceConnection;

    public static final class ClientUpdateHandler extends Handler {
        private final i backgroundDispatcher;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClientUpdateHandler(i backgroundDispatcher) {
            super(Looper.getMainLooper());
            r.f(backgroundDispatcher, "backgroundDispatcher");
            this.backgroundDispatcher = backgroundDispatcher;
        }

        private final void handleSessionUpdate(String str) {
            Log.d(SessionLifecycleClient.TAG, "Session update received.");
            AbstractC1822k.d(M.a(this.backgroundDispatcher), null, null, new SessionLifecycleClient$ClientUpdateHandler$handleSessionUpdate$1(str, null), 3, null);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            String string;
            r.f(msg, "msg");
            if (msg.what == 3) {
                Bundle data = msg.getData();
                if (data == null || (string = data.getString(SessionLifecycleService.SESSION_UPDATE_EXTRA)) == null) {
                    string = "";
                }
                handleSessionUpdate(string);
                return;
            }
            Log.w(SessionLifecycleClient.TAG, "Received unexpected event from the SessionLifecycleService: " + msg);
            super.handleMessage(msg);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.SessionLifecycleClient$sendLifecycleEvents$1, reason: invalid class name */
    @InterfaceC0868f(c = "com.google.firebase.sessions.SessionLifecycleClient$sendLifecycleEvents$1", f = "SessionLifecycleClient.kt", l = {151}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends l implements o {
        final /* synthetic */ List<Message> $messages;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List<Message> list, e eVar) {
            super(2, eVar);
            this.$messages = list;
        }

        @Override // b3.AbstractC0863a
        public final e create(Object obj, e eVar) {
            return SessionLifecycleClient.this.new AnonymousClass1(this.$messages, eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.label;
            if (i4 == 0) {
                q.b(obj);
                FirebaseSessionsDependencies firebaseSessionsDependencies = FirebaseSessionsDependencies.INSTANCE;
                this.label = 1;
                obj = firebaseSessionsDependencies.getRegisteredSubscribers$com_google_firebase_firebase_sessions(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.b(obj);
            }
            Map map = (Map) obj;
            if (map.isEmpty()) {
                Log.d(SessionLifecycleClient.TAG, "Sessions SDK did not have any dependent SDKs register as dependencies. Events will not be sent.");
            } else {
                Collection collectionValues = map.values();
                if (collectionValues == null || !collectionValues.isEmpty()) {
                    Iterator it = collectionValues.iterator();
                    while (it.hasNext()) {
                        if (((SessionSubscriber) it.next()).isDataCollectionEnabled()) {
                            List listZ = x.Z(x.E(AbstractC0769p.m(SessionLifecycleClient.this.getLatestByCode(this.$messages, 2), SessionLifecycleClient.this.getLatestByCode(this.$messages, 1))), new Comparator() { // from class: com.google.firebase.sessions.SessionLifecycleClient$sendLifecycleEvents$1$invokeSuspend$$inlined$sortedBy$1
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // java.util.Comparator
                                public final int compare(T t4, T t5) {
                                    return Y2.a.a(Long.valueOf(((Message) t4).getWhen()), Long.valueOf(((Message) t5).getWhen()));
                                }
                            });
                            SessionLifecycleClient sessionLifecycleClient = SessionLifecycleClient.this;
                            Iterator it2 = listZ.iterator();
                            while (it2.hasNext()) {
                                sessionLifecycleClient.sendMessageToServer((Message) it2.next());
                            }
                        }
                    }
                    Log.d(SessionLifecycleClient.TAG, "Data Collection is disabled for all subscribers. Skipping this Event");
                } else {
                    Log.d(SessionLifecycleClient.TAG, "Data Collection is disabled for all subscribers. Skipping this Event");
                }
            }
            return E.f5463a;
        }

        @Override // i3.o
        public final Object invoke(L l4, e eVar) {
            return ((AnonymousClass1) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.google.firebase.sessions.SessionLifecycleClient$serviceConnection$1] */
    public SessionLifecycleClient(i backgroundDispatcher) {
        r.f(backgroundDispatcher, "backgroundDispatcher");
        this.backgroundDispatcher = backgroundDispatcher;
        this.queuedMessages = new LinkedBlockingDeque<>(20);
        this.serviceConnection = new ServiceConnection() { // from class: com.google.firebase.sessions.SessionLifecycleClient$serviceConnection$1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.d(SessionLifecycleClient.TAG, "Connected to SessionLifecycleService. Queue size " + this.this$0.queuedMessages.size());
                this.this$0.service = new Messenger(iBinder);
                this.this$0.serviceBound = true;
                SessionLifecycleClient sessionLifecycleClient = this.this$0;
                sessionLifecycleClient.sendLifecycleEvents(sessionLifecycleClient.drainQueue());
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Log.d(SessionLifecycleClient.TAG, "Disconnected from SessionLifecycleService");
                this.this$0.service = null;
                this.this$0.serviceBound = false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Message> drainQueue() {
        ArrayList arrayList = new ArrayList();
        this.queuedMessages.drainTo(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Message getLatestByCode(List<Message> list, int i4) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (((Message) obj2).what == i4) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                long when = ((Message) next).getWhen();
                do {
                    Object next2 = it.next();
                    long when2 = ((Message) next2).getWhen();
                    if (when < when2) {
                        next = next2;
                        when = when2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (Message) obj;
    }

    private final void queueMessage(Message message) {
        if (!this.queuedMessages.offer(message)) {
            Log.d(TAG, "Failed to enqueue message " + message.what + ". Dropping.");
            return;
        }
        Log.d(TAG, "Queued message " + message.what + ". Queue size " + this.queuedMessages.size());
    }

    private final void sendLifecycleEvent(int i4) {
        List<Message> listDrainQueue = drainQueue();
        Message messageObtain = Message.obtain(null, i4, 0, 0);
        r.e(messageObtain, "obtain(null, messageCode, 0, 0)");
        listDrainQueue.add(messageObtain);
        sendLifecycleEvents(listDrainQueue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC1846w0 sendLifecycleEvents(List<Message> list) {
        return AbstractC1822k.d(M.a(this.backgroundDispatcher), null, null, new AnonymousClass1(list, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendMessageToServer(Message message) {
        if (this.service == null) {
            queueMessage(message);
            return;
        }
        try {
            Log.d(TAG, "Sending lifecycle " + message.what + " to service");
            Messenger messenger = this.service;
            if (messenger != null) {
                messenger.send(message);
            }
        } catch (RemoteException e4) {
            Log.w(TAG, "Unable to deliver message: " + message.what, e4);
            queueMessage(message);
        }
    }

    public final void backgrounded() {
        sendLifecycleEvent(2);
    }

    public final void bindToService(SessionLifecycleServiceBinder sessionLifecycleServiceBinder) {
        r.f(sessionLifecycleServiceBinder, "sessionLifecycleServiceBinder");
        sessionLifecycleServiceBinder.bindToService(new Messenger(new ClientUpdateHandler(this.backgroundDispatcher)), this.serviceConnection);
    }

    public final void foregrounded() {
        sendLifecycleEvent(1);
    }
}
