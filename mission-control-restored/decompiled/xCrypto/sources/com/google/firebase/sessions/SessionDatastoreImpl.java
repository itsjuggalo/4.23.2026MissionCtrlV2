package com.google.firebase.sessions;

import S.InterfaceC0523i;
import V.f;
import V.j;
import W2.E;
import W2.q;
import Z2.e;
import Z2.i;
import a3.AbstractC0787c;
import android.util.Log;
import b3.AbstractC0866d;
import b3.InterfaceC0868f;
import b3.l;
import com.google.firebase.annotations.concurrent.Background;
import i3.o;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import t3.AbstractC1822k;
import t3.L;
import t3.M;

/* JADX INFO: loaded from: classes.dex */
public final class SessionDatastoreImpl implements SessionDatastore {
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "FirebaseSessionsRepo";
    private final i backgroundDispatcher;
    private final AtomicReference<FirebaseSessionsData> currentSessionFromDatastore;
    private final InterfaceC0523i dataStore;
    private final w3.d firebaseSessionDataFlow;

    /* JADX INFO: renamed from: com.google.firebase.sessions.SessionDatastoreImpl$1, reason: invalid class name */
    @InterfaceC0868f(c = "com.google.firebase.sessions.SessionDatastoreImpl$1", f = "SessionDatastore.kt", l = {84}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends l implements o {
        int label;

        public AnonymousClass1(e eVar) {
            super(2, eVar);
        }

        @Override // b3.AbstractC0863a
        public final e create(Object obj, e eVar) {
            return SessionDatastoreImpl.this.new AnonymousClass1(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.label;
            if (i4 == 0) {
                q.b(obj);
                w3.d dVar = SessionDatastoreImpl.this.firebaseSessionDataFlow;
                final SessionDatastoreImpl sessionDatastoreImpl = SessionDatastoreImpl.this;
                w3.e eVar = new w3.e() { // from class: com.google.firebase.sessions.SessionDatastoreImpl.1.1
                    @Override // w3.e
                    public final Object emit(FirebaseSessionsData firebaseSessionsData, e eVar2) {
                        sessionDatastoreImpl.currentSessionFromDatastore.set(firebaseSessionsData);
                        return E.f5463a;
                    }
                };
                this.label = 1;
                if (dVar.collect(eVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.b(obj);
            }
            return E.f5463a;
        }

        @Override // i3.o
        public final Object invoke(L l4, e eVar) {
            return ((AnonymousClass1) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        private Companion() {
        }
    }

    public static final class FirebaseSessionDataKeys {
        public static final FirebaseSessionDataKeys INSTANCE = new FirebaseSessionDataKeys();
        private static final f.a SESSION_ID = V.i.g("session_id");

        private FirebaseSessionDataKeys() {
        }

        public final f.a getSESSION_ID() {
            return SESSION_ID;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.SessionDatastoreImpl$updateSessionId$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC0868f(c = "com.google.firebase.sessions.SessionDatastoreImpl$updateSessionId$1", f = "SessionDatastore.kt", l = {91}, m = "invokeSuspend")
    public static final class C10461 extends l implements o {
        final /* synthetic */ String $sessionId;
        int label;

        /* JADX INFO: renamed from: com.google.firebase.sessions.SessionDatastoreImpl$updateSessionId$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC0868f(c = "com.google.firebase.sessions.SessionDatastoreImpl$updateSessionId$1$1", f = "SessionDatastore.kt", l = {}, m = "invokeSuspend")
        public static final class C01561 extends l implements o {
            final /* synthetic */ String $sessionId;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01561(String str, e eVar) {
                super(2, eVar);
                this.$sessionId = str;
            }

            @Override // b3.AbstractC0863a
            public final e create(Object obj, e eVar) {
                C01561 c01561 = new C01561(this.$sessionId, eVar);
                c01561.L$0 = obj;
                return c01561;
            }

            @Override // i3.o
            public final Object invoke(V.c cVar, e eVar) {
                return ((C01561) create(cVar, eVar)).invokeSuspend(E.f5463a);
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) throws Throwable {
                AbstractC0787c.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.b(obj);
                ((V.c) this.L$0).j(FirebaseSessionDataKeys.INSTANCE.getSESSION_ID(), this.$sessionId);
                return E.f5463a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10461(String str, e eVar) {
            super(2, eVar);
            this.$sessionId = str;
        }

        @Override // b3.AbstractC0863a
        public final e create(Object obj, e eVar) {
            return SessionDatastoreImpl.this.new C10461(this.$sessionId, eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.label;
            try {
                if (i4 == 0) {
                    q.b(obj);
                    InterfaceC0523i interfaceC0523i = SessionDatastoreImpl.this.dataStore;
                    C01561 c01561 = new C01561(this.$sessionId, null);
                    this.label = 1;
                    if (j.a(interfaceC0523i, c01561, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.b(obj);
                }
            } catch (IOException e4) {
                Log.w(SessionDatastoreImpl.TAG, "Failed to update session Id: " + e4);
            }
            return E.f5463a;
        }

        @Override // i3.o
        public final Object invoke(L l4, e eVar) {
            return ((C10461) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    public SessionDatastoreImpl(@Background i backgroundDispatcher, @SessionDetailsDataStore InterfaceC0523i dataStore) {
        r.f(backgroundDispatcher, "backgroundDispatcher");
        r.f(dataStore, "dataStore");
        this.backgroundDispatcher = backgroundDispatcher;
        this.dataStore = dataStore;
        this.currentSessionFromDatastore = new AtomicReference<>();
        final w3.d dVarD = w3.f.d(dataStore.getData(), new SessionDatastoreImpl$firebaseSessionDataFlow$1(null));
        this.firebaseSessionDataFlow = new w3.d() { // from class: com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1

            /* JADX INFO: renamed from: com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements w3.e {
                final /* synthetic */ w3.e $this_unsafeFlow;
                final /* synthetic */ SessionDatastoreImpl this$0;

                /* JADX INFO: renamed from: com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2$1, reason: invalid class name */
                @InterfaceC0868f(c = "com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2", f = "SessionDatastore.kt", l = {223}, m = "emit")
                public static final class AnonymousClass1 extends AbstractC0866d {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(e eVar) {
                        super(eVar);
                    }

                    @Override // b3.AbstractC0863a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(w3.e eVar, SessionDatastoreImpl sessionDatastoreImpl) {
                    this.$this_unsafeFlow = eVar;
                    this.this$0 = sessionDatastoreImpl;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // w3.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, Z2.e r6) throws java.lang.Throwable {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2$1 r0 = (com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2$1 r0 = new com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = a3.AbstractC0787c.e()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        W2.q.b(r6)
                        goto L47
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        W2.q.b(r6)
                        w3.e r6 = r4.$this_unsafeFlow
                        V.f r5 = (V.f) r5
                        com.google.firebase.sessions.SessionDatastoreImpl r2 = r4.this$0
                        com.google.firebase.sessions.FirebaseSessionsData r5 = com.google.firebase.sessions.SessionDatastoreImpl.access$mapSessionsData(r2, r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L47
                        return r1
                    L47:
                        W2.E r5 = W2.E.f5463a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, Z2.e):java.lang.Object");
                }
            }

            @Override // w3.d
            public Object collect(w3.e eVar, e eVar2) {
                Object objCollect = dVarD.collect(new AnonymousClass2(eVar, this), eVar2);
                return objCollect == AbstractC0787c.e() ? objCollect : E.f5463a;
            }
        };
        AbstractC1822k.d(M.a(backgroundDispatcher), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FirebaseSessionsData mapSessionsData(f fVar) {
        return new FirebaseSessionsData((String) fVar.b(FirebaseSessionDataKeys.INSTANCE.getSESSION_ID()));
    }

    @Override // com.google.firebase.sessions.SessionDatastore
    public String getCurrentSessionId() {
        FirebaseSessionsData firebaseSessionsData = this.currentSessionFromDatastore.get();
        if (firebaseSessionsData != null) {
            return firebaseSessionsData.getSessionId();
        }
        return null;
    }

    @Override // com.google.firebase.sessions.SessionDatastore
    public void updateSessionId(String sessionId) {
        r.f(sessionId, "sessionId");
        AbstractC1822k.d(M.a(this.backgroundDispatcher), null, null, new C10461(sessionId, null), 3, null);
    }
}
