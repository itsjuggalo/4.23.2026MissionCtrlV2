package Z3;

import F5.AbstractC0556n;
import a4.C0891a;
import a4.InterfaceC0892b;
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
import b6.AbstractC1077k;
import b6.InterfaceC1101w0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes.dex */
public final class E {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f5855f = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H5.g f5856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Messenger f5857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedBlockingDeque f5859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f5860e;

    public static final class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final H5.g f5861a;

        /* JADX INFO: renamed from: Z3.E$a$a, reason: collision with other inner class name */
        public static final class C0105a extends J5.l implements Q5.o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f5862a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f5863b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0105a(String str, H5.d dVar) {
                super(2, dVar);
                this.f5863b = str;
            }

            @Override // J5.a
            public final H5.d create(Object obj, H5.d dVar) {
                return new C0105a(this.f5863b, dVar);
            }

            @Override // Q5.o
            public final Object invoke(b6.L l7, H5.d dVar) {
                return ((C0105a) create(l7, dVar)).invokeSuspend(E5.E.f1657a);
            }

            @Override // J5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE = I5.c.e();
                int i7 = this.f5862a;
                if (i7 == 0) {
                    E5.q.b(obj);
                    C0891a c0891a = C0891a.f6297a;
                    this.f5862a = 1;
                    obj = c0891a.c(this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i7 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    E5.q.b(obj);
                }
                Collection<InterfaceC0892b> collectionValues = ((Map) obj).values();
                String str = this.f5863b;
                for (InterfaceC0892b interfaceC0892b : collectionValues) {
                    interfaceC0892b.a(new InterfaceC0892b.C0114b(str));
                    Log.d("SessionLifecycleClient", "Notified " + interfaceC0892b.c() + " of new session " + str);
                }
                return E5.E.f1657a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(H5.g backgroundDispatcher) {
            super(Looper.getMainLooper());
            kotlin.jvm.internal.r.f(backgroundDispatcher, "backgroundDispatcher");
            this.f5861a = backgroundDispatcher;
        }

        public final void a(String str) {
            Log.d("SessionLifecycleClient", "Session update received.");
            AbstractC1077k.d(b6.M.a(this.f5861a), null, null, new C0105a(str, null), 3, null);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            String string;
            kotlin.jvm.internal.r.f(msg, "msg");
            if (msg.what == 3) {
                Bundle data = msg.getData();
                if (data == null || (string = data.getString("SessionUpdateExtra")) == null) {
                    string = "";
                }
                a(string);
                return;
            }
            Log.w("SessionLifecycleClient", "Received unexpected event from the SessionLifecycleService: " + msg);
            super.handleMessage(msg);
        }
    }

    public static final class b {
        public /* synthetic */ b(AbstractC2148j abstractC2148j) {
            this();
        }

        public b() {
        }
    }

    public static final class c extends J5.l implements Q5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5864a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f5866c;

        public static final class a implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return G5.a.a(Long.valueOf(((Message) obj).getWhen()), Long.valueOf(((Message) obj2).getWhen()));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(List list, H5.d dVar) {
            super(2, dVar);
            this.f5866c = list;
        }

        @Override // J5.a
        public final H5.d create(Object obj, H5.d dVar) {
            return E.this.new c(this.f5866c, dVar);
        }

        @Override // Q5.o
        public final Object invoke(b6.L l7, H5.d dVar) {
            return ((c) create(l7, dVar)).invokeSuspend(E5.E.f1657a);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = I5.c.e();
            int i7 = this.f5864a;
            if (i7 == 0) {
                E5.q.b(obj);
                C0891a c0891a = C0891a.f6297a;
                this.f5864a = 1;
                obj = c0891a.c(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                E5.q.b(obj);
            }
            Map map = (Map) obj;
            if (map.isEmpty()) {
                Log.d("SessionLifecycleClient", "Sessions SDK did not have any dependent SDKs register as dependencies. Events will not be sent.");
            } else {
                Collection collectionValues = map.values();
                if (collectionValues == null || !collectionValues.isEmpty()) {
                    Iterator it = collectionValues.iterator();
                    while (it.hasNext()) {
                        if (((InterfaceC0892b) it.next()).b()) {
                            List listA0 = F5.v.a0(F5.v.F(AbstractC0556n.m(E.this.l(this.f5866c, 2), E.this.l(this.f5866c, 1))), new a());
                            E e7 = E.this;
                            Iterator it2 = listA0.iterator();
                            while (it2.hasNext()) {
                                e7.p((Message) it2.next());
                            }
                        }
                    }
                    Log.d("SessionLifecycleClient", "Data Collection is disabled for all subscribers. Skipping this Event");
                } else {
                    Log.d("SessionLifecycleClient", "Data Collection is disabled for all subscribers. Skipping this Event");
                }
            }
            return E5.E.f1657a;
        }
    }

    public static final class d implements ServiceConnection {
        public d() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d("SessionLifecycleClient", "Connected to SessionLifecycleService. Queue size " + E.this.f5859d.size());
            E.this.f5857b = new Messenger(iBinder);
            E.this.f5858c = true;
            E e7 = E.this;
            e7.o(e7.j());
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d("SessionLifecycleClient", "Disconnected from SessionLifecycleService");
            E.this.f5857b = null;
            E.this.f5858c = false;
        }
    }

    public E(H5.g backgroundDispatcher) {
        kotlin.jvm.internal.r.f(backgroundDispatcher, "backgroundDispatcher");
        this.f5856a = backgroundDispatcher;
        this.f5859d = new LinkedBlockingDeque(20);
        this.f5860e = new d();
    }

    public final void h() {
        n(2);
    }

    public final void i(F sessionLifecycleServiceBinder) {
        kotlin.jvm.internal.r.f(sessionLifecycleServiceBinder, "sessionLifecycleServiceBinder");
        sessionLifecycleServiceBinder.a(new Messenger(new a(this.f5856a)), this.f5860e);
    }

    public final List j() {
        ArrayList arrayList = new ArrayList();
        this.f5859d.drainTo(arrayList);
        return arrayList;
    }

    public final void k() {
        n(1);
    }

    public final Message l(List list, int i7) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (((Message) obj2).what == i7) {
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

    public final void m(Message message) {
        if (!this.f5859d.offer(message)) {
            Log.d("SessionLifecycleClient", "Failed to enqueue message " + message.what + ". Dropping.");
            return;
        }
        Log.d("SessionLifecycleClient", "Queued message " + message.what + ". Queue size " + this.f5859d.size());
    }

    public final void n(int i7) {
        List listJ = j();
        Message messageObtain = Message.obtain(null, i7, 0, 0);
        kotlin.jvm.internal.r.e(messageObtain, "obtain(null, messageCode, 0, 0)");
        listJ.add(messageObtain);
        o(listJ);
    }

    public final InterfaceC1101w0 o(List list) {
        return AbstractC1077k.d(b6.M.a(this.f5856a), null, null, new c(list, null), 3, null);
    }

    public final void p(Message message) {
        if (this.f5857b == null) {
            m(message);
            return;
        }
        try {
            Log.d("SessionLifecycleClient", "Sending lifecycle " + message.what + " to service");
            Messenger messenger = this.f5857b;
            if (messenger != null) {
                messenger.send(message);
            }
        } catch (RemoteException e7) {
            Log.w("SessionLifecycleClient", "Unable to deliver message: " + message.what, e7);
            m(message);
        }
    }
}
