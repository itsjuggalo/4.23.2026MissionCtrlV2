package com.google.firebase.firestore.ktx;

import W2.E;
import W2.q;
import Z2.e;
import a3.AbstractC0787c;
import b3.InterfaceC0868f;
import b3.l;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.MemoryCacheSettings;
import com.google.firebase.firestore.MemoryEagerGcSettings;
import com.google.firebase.firestore.MemoryLruGcSettings;
import com.google.firebase.firestore.MetadataChanges;
import com.google.firebase.firestore.PersistentCacheSettings;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.ktx.FirestoreKt;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.ktx.Firebase;
import i3.o;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import t3.M;
import v3.k;
import w3.d;
import w3.f;

/* JADX INFO: loaded from: classes.dex */
public final class FirestoreKt {

    /* JADX INFO: renamed from: com.google.firebase.firestore.ktx.FirestoreKt$snapshots$1, reason: invalid class name */
    @InterfaceC0868f(c = "com.google.firebase.firestore.ktx.FirestoreKt$snapshots$1", f = "Firestore.kt", l = {412}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends l implements o {
        final /* synthetic */ MetadataChanges $metadataChanges;
        final /* synthetic */ DocumentReference $this_snapshots;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.google.firebase.firestore.ktx.FirestoreKt$snapshots$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01541 extends s implements Function0 {
            final /* synthetic */ ListenerRegistration $registration;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01541(ListenerRegistration listenerRegistration) {
                super(0);
                this.$registration = listenerRegistration;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m14invoke();
                return E.f5463a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m14invoke() {
                this.$registration.remove();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DocumentReference documentReference, MetadataChanges metadataChanges, e eVar) {
            super(2, eVar);
            this.$this_snapshots = documentReference;
            this.$metadataChanges = metadataChanges;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(v3.s sVar, DocumentSnapshot documentSnapshot, FirebaseFirestoreException firebaseFirestoreException) {
            if (firebaseFirestoreException != null) {
                M.c(sVar, "Error getting DocumentReference snapshot", firebaseFirestoreException);
            } else if (documentSnapshot != null) {
                k.b(sVar, documentSnapshot);
            }
        }

        @Override // b3.AbstractC0863a
        public final e create(Object obj, e eVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_snapshots, this.$metadataChanges, eVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.label;
            if (i4 == 0) {
                q.b(obj);
                final v3.s sVar = (v3.s) this.L$0;
                ListenerRegistration listenerRegistrationAddSnapshotListener = this.$this_snapshots.addSnapshotListener(Executors.BACKGROUND_EXECUTOR, this.$metadataChanges, new EventListener() { // from class: com.google.firebase.firestore.ktx.a
                    @Override // com.google.firebase.firestore.EventListener
                    public final void onEvent(Object obj2, FirebaseFirestoreException firebaseFirestoreException) {
                        FirestoreKt.AnonymousClass1.invokeSuspend$lambda$0(sVar, (DocumentSnapshot) obj2, firebaseFirestoreException);
                    }
                });
                r.e(listenerRegistrationAddSnapshotListener, "addSnapshotListener(BACK…apshot)\n        }\n      }");
                C01541 c01541 = new C01541(listenerRegistrationAddSnapshotListener);
                this.label = 1;
                if (v3.q.a(sVar, c01541, this) == objE) {
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
        public final Object invoke(v3.s sVar, e eVar) {
            return ((AnonymousClass1) create(sVar, eVar)).invokeSuspend(E.f5463a);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.firestore.ktx.FirestoreKt$snapshots$2, reason: invalid class name */
    @InterfaceC0868f(c = "com.google.firebase.firestore.ktx.FirestoreKt$snapshots$2", f = "Firestore.kt", l = {445}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends l implements o {
        final /* synthetic */ MetadataChanges $metadataChanges;
        final /* synthetic */ Query $this_snapshots;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.google.firebase.firestore.ktx.FirestoreKt$snapshots$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements Function0 {
            final /* synthetic */ ListenerRegistration $registration;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ListenerRegistration listenerRegistration) {
                super(0);
                this.$registration = listenerRegistration;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m15invoke();
                return E.f5463a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m15invoke() {
                this.$registration.remove();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Query query, MetadataChanges metadataChanges, e eVar) {
            super(2, eVar);
            this.$this_snapshots = query;
            this.$metadataChanges = metadataChanges;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(v3.s sVar, QuerySnapshot querySnapshot, FirebaseFirestoreException firebaseFirestoreException) {
            if (firebaseFirestoreException != null) {
                M.c(sVar, "Error getting Query snapshot", firebaseFirestoreException);
            } else if (querySnapshot != null) {
                k.b(sVar, querySnapshot);
            }
        }

        @Override // b3.AbstractC0863a
        public final e create(Object obj, e eVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_snapshots, this.$metadataChanges, eVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.label;
            if (i4 == 0) {
                q.b(obj);
                final v3.s sVar = (v3.s) this.L$0;
                ListenerRegistration listenerRegistrationAddSnapshotListener = this.$this_snapshots.addSnapshotListener(Executors.BACKGROUND_EXECUTOR, this.$metadataChanges, new EventListener() { // from class: com.google.firebase.firestore.ktx.b
                    @Override // com.google.firebase.firestore.EventListener
                    public final void onEvent(Object obj2, FirebaseFirestoreException firebaseFirestoreException) {
                        FirestoreKt.AnonymousClass2.invokeSuspend$lambda$0(sVar, (QuerySnapshot) obj2, firebaseFirestoreException);
                    }
                });
                r.e(listenerRegistrationAddSnapshotListener, "addSnapshotListener(BACK…apshot)\n        }\n      }");
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(listenerRegistrationAddSnapshotListener);
                this.label = 1;
                if (v3.q.a(sVar, anonymousClass1, this) == objE) {
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
        public final Object invoke(v3.s sVar, e eVar) {
            return ((AnonymousClass2) create(sVar, eVar)).invokeSuspend(E.f5463a);
        }
    }

    public static final /* synthetic */ <T> d dataObjects(Query query, MetadataChanges metadataChanges) {
        r.f(query, "<this>");
        r.f(metadataChanges, "metadataChanges");
        d dVarSnapshots = snapshots(query, metadataChanges);
        r.j();
        return new FirestoreKt$dataObjects$$inlined$map$1(dVarSnapshots);
    }

    public static /* synthetic */ d dataObjects$default(Query query, MetadataChanges metadataChanges, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            metadataChanges = MetadataChanges.EXCLUDE;
        }
        r.f(query, "<this>");
        r.f(metadataChanges, "metadataChanges");
        d dVarSnapshots = snapshots(query, metadataChanges);
        r.j();
        return new FirestoreKt$dataObjects$$inlined$map$1(dVarSnapshots);
    }

    public static final FirebaseFirestore firestore(Firebase firebase, FirebaseApp app) {
        r.f(firebase, "<this>");
        r.f(app, "app");
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance(app);
        r.e(firebaseFirestore, "getInstance(app)");
        return firebaseFirestore;
    }

    public static final FirebaseFirestoreSettings firestoreSettings(i3.k init) {
        r.f(init, "init");
        FirebaseFirestoreSettings.Builder builder = new FirebaseFirestoreSettings.Builder();
        init.invoke(builder);
        FirebaseFirestoreSettings firebaseFirestoreSettingsBuild = builder.build();
        r.e(firebaseFirestoreSettingsBuild, "builder.build()");
        return firebaseFirestoreSettingsBuild;
    }

    public static final /* synthetic */ <T> T getField(DocumentSnapshot documentSnapshot, String field) {
        r.f(documentSnapshot, "<this>");
        r.f(field, "field");
        r.k(4, "T");
        return (T) documentSnapshot.get(field, Object.class);
    }

    public static final FirebaseFirestore getFirestore(Firebase firebase) {
        r.f(firebase, "<this>");
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        r.e(firebaseFirestore, "getInstance()");
        return firebaseFirestore;
    }

    public static final MemoryCacheSettings memoryCacheSettings(i3.k init) {
        r.f(init, "init");
        MemoryCacheSettings.Builder builderNewBuilder = MemoryCacheSettings.newBuilder();
        r.e(builderNewBuilder, "newBuilder()");
        init.invoke(builderNewBuilder);
        MemoryCacheSettings memoryCacheSettingsBuild = builderNewBuilder.build();
        r.e(memoryCacheSettingsBuild, "builder.build()");
        return memoryCacheSettingsBuild;
    }

    public static final MemoryEagerGcSettings memoryEagerGcSettings(i3.k init) {
        r.f(init, "init");
        MemoryEagerGcSettings.Builder builderNewBuilder = MemoryEagerGcSettings.newBuilder();
        r.e(builderNewBuilder, "newBuilder()");
        init.invoke(builderNewBuilder);
        MemoryEagerGcSettings memoryEagerGcSettingsBuild = builderNewBuilder.build();
        r.e(memoryEagerGcSettingsBuild, "builder.build()");
        return memoryEagerGcSettingsBuild;
    }

    public static final MemoryLruGcSettings memoryLruGcSettings(i3.k init) {
        r.f(init, "init");
        MemoryLruGcSettings.Builder builderNewBuilder = MemoryLruGcSettings.newBuilder();
        r.e(builderNewBuilder, "newBuilder()");
        init.invoke(builderNewBuilder);
        MemoryLruGcSettings memoryLruGcSettingsBuild = builderNewBuilder.build();
        r.e(memoryLruGcSettingsBuild, "builder.build()");
        return memoryLruGcSettingsBuild;
    }

    public static final PersistentCacheSettings persistentCacheSettings(i3.k init) {
        r.f(init, "init");
        PersistentCacheSettings.Builder builderNewBuilder = PersistentCacheSettings.newBuilder();
        r.e(builderNewBuilder, "newBuilder()");
        init.invoke(builderNewBuilder);
        PersistentCacheSettings persistentCacheSettingsBuild = builderNewBuilder.build();
        r.e(persistentCacheSettingsBuild, "builder.build()");
        return persistentCacheSettingsBuild;
    }

    public static final d snapshots(DocumentReference documentReference, MetadataChanges metadataChanges) {
        r.f(documentReference, "<this>");
        r.f(metadataChanges, "metadataChanges");
        return f.c(new AnonymousClass1(documentReference, metadataChanges, null));
    }

    public static /* synthetic */ d snapshots$default(DocumentReference documentReference, MetadataChanges metadataChanges, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            metadataChanges = MetadataChanges.EXCLUDE;
        }
        return snapshots(documentReference, metadataChanges);
    }

    public static final /* synthetic */ <T> T toObject(DocumentSnapshot documentSnapshot) {
        r.f(documentSnapshot, "<this>");
        r.k(4, "T");
        return (T) documentSnapshot.toObject(Object.class);
    }

    public static final /* synthetic */ <T> List<T> toObjects(QuerySnapshot querySnapshot) {
        r.f(querySnapshot, "<this>");
        r.k(4, "T");
        List<T> objects = querySnapshot.toObjects(Object.class);
        r.e(objects, "toObjects(T::class.java)");
        return objects;
    }

    public static final FirebaseFirestore firestore(Firebase firebase, FirebaseApp app, String database) {
        r.f(firebase, "<this>");
        r.f(app, "app");
        r.f(database, "database");
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance(app, database);
        r.e(firebaseFirestore, "getInstance(app, database)");
        return firebaseFirestore;
    }

    public static final /* synthetic */ <T> T getField(DocumentSnapshot documentSnapshot, String field, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        r.f(documentSnapshot, "<this>");
        r.f(field, "field");
        r.f(serverTimestampBehavior, "serverTimestampBehavior");
        r.k(4, "T");
        return (T) documentSnapshot.get(field, Object.class, serverTimestampBehavior);
    }

    public static final d snapshots(Query query, MetadataChanges metadataChanges) {
        r.f(query, "<this>");
        r.f(metadataChanges, "metadataChanges");
        return f.c(new AnonymousClass2(query, metadataChanges, null));
    }

    public static final /* synthetic */ <T> T toObject(DocumentSnapshot documentSnapshot, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        r.f(documentSnapshot, "<this>");
        r.f(serverTimestampBehavior, "serverTimestampBehavior");
        r.k(4, "T");
        return (T) documentSnapshot.toObject(Object.class, serverTimestampBehavior);
    }

    public static final /* synthetic */ <T> List<T> toObjects(QuerySnapshot querySnapshot, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        r.f(querySnapshot, "<this>");
        r.f(serverTimestampBehavior, "serverTimestampBehavior");
        r.k(4, "T");
        List<T> objects = querySnapshot.toObjects(Object.class, serverTimestampBehavior);
        r.e(objects, "toObjects(T::class.java, serverTimestampBehavior)");
        return objects;
    }

    public static final /* synthetic */ <T> d dataObjects(DocumentReference documentReference, MetadataChanges metadataChanges) {
        r.f(documentReference, "<this>");
        r.f(metadataChanges, "metadataChanges");
        d dVarSnapshots = snapshots(documentReference, metadataChanges);
        r.j();
        return new FirestoreKt$dataObjects$$inlined$map$2(dVarSnapshots);
    }

    public static final FirebaseFirestore firestore(Firebase firebase, String database) {
        r.f(firebase, "<this>");
        r.f(database, "database");
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance(database);
        r.e(firebaseFirestore, "getInstance(database)");
        return firebaseFirestore;
    }

    public static final /* synthetic */ <T> T getField(DocumentSnapshot documentSnapshot, FieldPath fieldPath) {
        r.f(documentSnapshot, "<this>");
        r.f(fieldPath, "fieldPath");
        r.k(4, "T");
        return (T) documentSnapshot.get(fieldPath, Object.class);
    }

    public static /* synthetic */ d snapshots$default(Query query, MetadataChanges metadataChanges, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            metadataChanges = MetadataChanges.EXCLUDE;
        }
        return snapshots(query, metadataChanges);
    }

    public static final /* synthetic */ <T> T toObject(QueryDocumentSnapshot queryDocumentSnapshot) {
        r.f(queryDocumentSnapshot, "<this>");
        r.k(4, "T");
        T t4 = (T) queryDocumentSnapshot.toObject(Object.class);
        r.e(t4, "toObject(T::class.java)");
        return t4;
    }

    public static final /* synthetic */ <T> T getField(DocumentSnapshot documentSnapshot, FieldPath fieldPath, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        r.f(documentSnapshot, "<this>");
        r.f(fieldPath, "fieldPath");
        r.f(serverTimestampBehavior, "serverTimestampBehavior");
        r.k(4, "T");
        return (T) documentSnapshot.get(fieldPath, Object.class, serverTimestampBehavior);
    }

    public static final /* synthetic */ <T> T toObject(QueryDocumentSnapshot queryDocumentSnapshot, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        r.f(queryDocumentSnapshot, "<this>");
        r.f(serverTimestampBehavior, "serverTimestampBehavior");
        r.k(4, "T");
        T t4 = (T) queryDocumentSnapshot.toObject(Object.class, serverTimestampBehavior);
        r.e(t4, "toObject(T::class.java, serverTimestampBehavior)");
        return t4;
    }

    public static /* synthetic */ d dataObjects$default(DocumentReference documentReference, MetadataChanges metadataChanges, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            metadataChanges = MetadataChanges.EXCLUDE;
        }
        r.f(documentReference, "<this>");
        r.f(metadataChanges, "metadataChanges");
        d dVarSnapshots = snapshots(documentReference, metadataChanges);
        r.j();
        return new FirestoreKt$dataObjects$$inlined$map$2(dVarSnapshots);
    }
}
