package com.google.firebase.firestore;

import a3.AbstractC0787c;
import b3.InterfaceC0868f;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.FirestoreKt;
import com.google.firebase.firestore.MemoryCacheSettings;
import com.google.firebase.firestore.MemoryEagerGcSettings;
import com.google.firebase.firestore.MemoryLruGcSettings;
import com.google.firebase.firestore.PersistentCacheSettings;
import com.google.firebase.firestore.util.Executors;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
public final class FirestoreKt {

    /* JADX INFO: renamed from: com.google.firebase.firestore.FirestoreKt$snapshots$1, reason: invalid class name */
    @InterfaceC0868f(c = "com.google.firebase.firestore.FirestoreKt$snapshots$1", f = "Firestore.kt", l = {243}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends b3.l implements i3.o {
        final /* synthetic */ MetadataChanges $metadataChanges;
        final /* synthetic */ DocumentReference $this_snapshots;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.google.firebase.firestore.FirestoreKt$snapshots$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01531 extends kotlin.jvm.internal.s implements Function0 {
            final /* synthetic */ ListenerRegistration $registration;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01531(ListenerRegistration listenerRegistration) {
                super(0);
                this.$registration = listenerRegistration;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m12invoke();
                return W2.E.f5463a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m12invoke() {
                this.$registration.remove();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DocumentReference documentReference, MetadataChanges metadataChanges, Z2.e eVar) {
            super(2, eVar);
            this.$this_snapshots = documentReference;
            this.$metadataChanges = metadataChanges;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(v3.s sVar, DocumentSnapshot documentSnapshot, FirebaseFirestoreException firebaseFirestoreException) {
            if (firebaseFirestoreException != null) {
                t3.M.c(sVar, "Error getting DocumentReference snapshot", firebaseFirestoreException);
            } else if (documentSnapshot != null) {
                v3.k.b(sVar, documentSnapshot);
            }
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_snapshots, this.$metadataChanges, eVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.label;
            if (i4 == 0) {
                W2.q.b(obj);
                final v3.s sVar = (v3.s) this.L$0;
                ListenerRegistration listenerRegistrationAddSnapshotListener = this.$this_snapshots.addSnapshotListener(Executors.BACKGROUND_EXECUTOR, this.$metadataChanges, new EventListener() { // from class: com.google.firebase.firestore.F
                    @Override // com.google.firebase.firestore.EventListener
                    public final void onEvent(Object obj2, FirebaseFirestoreException firebaseFirestoreException) {
                        FirestoreKt.AnonymousClass1.invokeSuspend$lambda$0(sVar, (DocumentSnapshot) obj2, firebaseFirestoreException);
                    }
                });
                kotlin.jvm.internal.r.e(listenerRegistrationAddSnapshotListener, "addSnapshotListener(BACK…apshot)\n        }\n      }");
                C01531 c01531 = new C01531(listenerRegistrationAddSnapshotListener);
                this.label = 1;
                if (v3.q.a(sVar, c01531, this) == objE) {
                    return objE;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                W2.q.b(obj);
            }
            return W2.E.f5463a;
        }

        @Override // i3.o
        public final Object invoke(v3.s sVar, Z2.e eVar) {
            return ((AnonymousClass1) create(sVar, eVar)).invokeSuspend(W2.E.f5463a);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.firestore.FirestoreKt$snapshots$2, reason: invalid class name */
    @InterfaceC0868f(c = "com.google.firebase.firestore.FirestoreKt$snapshots$2", f = "Firestore.kt", l = {267}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends b3.l implements i3.o {
        final /* synthetic */ MetadataChanges $metadataChanges;
        final /* synthetic */ Query $this_snapshots;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.google.firebase.firestore.FirestoreKt$snapshots$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends kotlin.jvm.internal.s implements Function0 {
            final /* synthetic */ ListenerRegistration $registration;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ListenerRegistration listenerRegistration) {
                super(0);
                this.$registration = listenerRegistration;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m13invoke();
                return W2.E.f5463a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m13invoke() {
                this.$registration.remove();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Query query, MetadataChanges metadataChanges, Z2.e eVar) {
            super(2, eVar);
            this.$this_snapshots = query;
            this.$metadataChanges = metadataChanges;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(v3.s sVar, QuerySnapshot querySnapshot, FirebaseFirestoreException firebaseFirestoreException) {
            if (firebaseFirestoreException != null) {
                t3.M.c(sVar, "Error getting Query snapshot", firebaseFirestoreException);
            } else if (querySnapshot != null) {
                v3.k.b(sVar, querySnapshot);
            }
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_snapshots, this.$metadataChanges, eVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.label;
            if (i4 == 0) {
                W2.q.b(obj);
                final v3.s sVar = (v3.s) this.L$0;
                ListenerRegistration listenerRegistrationAddSnapshotListener = this.$this_snapshots.addSnapshotListener(Executors.BACKGROUND_EXECUTOR, this.$metadataChanges, new EventListener() { // from class: com.google.firebase.firestore.G
                    @Override // com.google.firebase.firestore.EventListener
                    public final void onEvent(Object obj2, FirebaseFirestoreException firebaseFirestoreException) {
                        FirestoreKt.AnonymousClass2.invokeSuspend$lambda$0(sVar, (QuerySnapshot) obj2, firebaseFirestoreException);
                    }
                });
                kotlin.jvm.internal.r.e(listenerRegistrationAddSnapshotListener, "addSnapshotListener(BACK…apshot)\n        }\n      }");
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(listenerRegistrationAddSnapshotListener);
                this.label = 1;
                if (v3.q.a(sVar, anonymousClass1, this) == objE) {
                    return objE;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                W2.q.b(obj);
            }
            return W2.E.f5463a;
        }

        @Override // i3.o
        public final Object invoke(v3.s sVar, Z2.e eVar) {
            return ((AnonymousClass2) create(sVar, eVar)).invokeSuspend(W2.E.f5463a);
        }
    }

    public static final /* synthetic */ <T> w3.d dataObjects(Query query, MetadataChanges metadataChanges) {
        kotlin.jvm.internal.r.f(query, "<this>");
        kotlin.jvm.internal.r.f(metadataChanges, "metadataChanges");
        w3.d dVarSnapshots = snapshots(query, metadataChanges);
        kotlin.jvm.internal.r.j();
        return new FirestoreKt$dataObjects$$inlined$map$1(dVarSnapshots);
    }

    public static /* synthetic */ w3.d dataObjects$default(Query query, MetadataChanges metadataChanges, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            metadataChanges = MetadataChanges.EXCLUDE;
        }
        kotlin.jvm.internal.r.f(query, "<this>");
        kotlin.jvm.internal.r.f(metadataChanges, "metadataChanges");
        w3.d dVarSnapshots = snapshots(query, metadataChanges);
        kotlin.jvm.internal.r.j();
        return new FirestoreKt$dataObjects$$inlined$map$1(dVarSnapshots);
    }

    public static final FirebaseFirestore firestore(Firebase firebase, FirebaseApp app) {
        kotlin.jvm.internal.r.f(firebase, "<this>");
        kotlin.jvm.internal.r.f(app, "app");
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance(app);
        kotlin.jvm.internal.r.e(firebaseFirestore, "getInstance(app)");
        return firebaseFirestore;
    }

    public static final FirebaseFirestoreSettings firestoreSettings(i3.k init) {
        kotlin.jvm.internal.r.f(init, "init");
        FirebaseFirestoreSettings.Builder builder = new FirebaseFirestoreSettings.Builder();
        init.invoke(builder);
        FirebaseFirestoreSettings firebaseFirestoreSettingsBuild = builder.build();
        kotlin.jvm.internal.r.e(firebaseFirestoreSettingsBuild, "builder.build()");
        return firebaseFirestoreSettingsBuild;
    }

    public static final /* synthetic */ <T> T getField(DocumentSnapshot documentSnapshot, String field) {
        kotlin.jvm.internal.r.f(documentSnapshot, "<this>");
        kotlin.jvm.internal.r.f(field, "field");
        kotlin.jvm.internal.r.k(4, "T");
        return (T) documentSnapshot.get(field, Object.class);
    }

    public static final FirebaseFirestore getFirestore(Firebase firebase) {
        kotlin.jvm.internal.r.f(firebase, "<this>");
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        kotlin.jvm.internal.r.e(firebaseFirestore, "getInstance()");
        return firebaseFirestore;
    }

    public static final MemoryCacheSettings memoryCacheSettings(i3.k init) {
        kotlin.jvm.internal.r.f(init, "init");
        MemoryCacheSettings.Builder builderNewBuilder = MemoryCacheSettings.newBuilder();
        kotlin.jvm.internal.r.e(builderNewBuilder, "newBuilder()");
        init.invoke(builderNewBuilder);
        MemoryCacheSettings memoryCacheSettingsBuild = builderNewBuilder.build();
        kotlin.jvm.internal.r.e(memoryCacheSettingsBuild, "builder.build()");
        return memoryCacheSettingsBuild;
    }

    public static final MemoryEagerGcSettings memoryEagerGcSettings(i3.k init) {
        kotlin.jvm.internal.r.f(init, "init");
        MemoryEagerGcSettings.Builder builderNewBuilder = MemoryEagerGcSettings.newBuilder();
        kotlin.jvm.internal.r.e(builderNewBuilder, "newBuilder()");
        init.invoke(builderNewBuilder);
        MemoryEagerGcSettings memoryEagerGcSettingsBuild = builderNewBuilder.build();
        kotlin.jvm.internal.r.e(memoryEagerGcSettingsBuild, "builder.build()");
        return memoryEagerGcSettingsBuild;
    }

    public static final MemoryLruGcSettings memoryLruGcSettings(i3.k init) {
        kotlin.jvm.internal.r.f(init, "init");
        MemoryLruGcSettings.Builder builderNewBuilder = MemoryLruGcSettings.newBuilder();
        kotlin.jvm.internal.r.e(builderNewBuilder, "newBuilder()");
        init.invoke(builderNewBuilder);
        MemoryLruGcSettings memoryLruGcSettingsBuild = builderNewBuilder.build();
        kotlin.jvm.internal.r.e(memoryLruGcSettingsBuild, "builder.build()");
        return memoryLruGcSettingsBuild;
    }

    public static final PersistentCacheSettings persistentCacheSettings(i3.k init) {
        kotlin.jvm.internal.r.f(init, "init");
        PersistentCacheSettings.Builder builderNewBuilder = PersistentCacheSettings.newBuilder();
        kotlin.jvm.internal.r.e(builderNewBuilder, "newBuilder()");
        init.invoke(builderNewBuilder);
        PersistentCacheSettings persistentCacheSettingsBuild = builderNewBuilder.build();
        kotlin.jvm.internal.r.e(persistentCacheSettingsBuild, "builder.build()");
        return persistentCacheSettingsBuild;
    }

    public static final w3.d snapshots(DocumentReference documentReference, MetadataChanges metadataChanges) {
        kotlin.jvm.internal.r.f(documentReference, "<this>");
        kotlin.jvm.internal.r.f(metadataChanges, "metadataChanges");
        return w3.f.c(new AnonymousClass1(documentReference, metadataChanges, null));
    }

    public static /* synthetic */ w3.d snapshots$default(DocumentReference documentReference, MetadataChanges metadataChanges, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            metadataChanges = MetadataChanges.EXCLUDE;
        }
        return snapshots(documentReference, metadataChanges);
    }

    public static final /* synthetic */ <T> T toObject(DocumentSnapshot documentSnapshot) {
        kotlin.jvm.internal.r.f(documentSnapshot, "<this>");
        kotlin.jvm.internal.r.k(4, "T");
        return (T) documentSnapshot.toObject(Object.class);
    }

    public static final /* synthetic */ <T> List<T> toObjects(QuerySnapshot querySnapshot) {
        kotlin.jvm.internal.r.f(querySnapshot, "<this>");
        kotlin.jvm.internal.r.k(4, "T");
        List<T> objects = querySnapshot.toObjects(Object.class);
        kotlin.jvm.internal.r.e(objects, "toObjects(T::class.java)");
        return objects;
    }

    public static final FirebaseFirestore firestore(Firebase firebase, FirebaseApp app, String database) {
        kotlin.jvm.internal.r.f(firebase, "<this>");
        kotlin.jvm.internal.r.f(app, "app");
        kotlin.jvm.internal.r.f(database, "database");
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance(app, database);
        kotlin.jvm.internal.r.e(firebaseFirestore, "getInstance(app, database)");
        return firebaseFirestore;
    }

    public static final /* synthetic */ <T> T getField(DocumentSnapshot documentSnapshot, String field, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        kotlin.jvm.internal.r.f(documentSnapshot, "<this>");
        kotlin.jvm.internal.r.f(field, "field");
        kotlin.jvm.internal.r.f(serverTimestampBehavior, "serverTimestampBehavior");
        kotlin.jvm.internal.r.k(4, "T");
        return (T) documentSnapshot.get(field, Object.class, serverTimestampBehavior);
    }

    public static final w3.d snapshots(Query query, MetadataChanges metadataChanges) {
        kotlin.jvm.internal.r.f(query, "<this>");
        kotlin.jvm.internal.r.f(metadataChanges, "metadataChanges");
        return w3.f.c(new AnonymousClass2(query, metadataChanges, null));
    }

    public static final /* synthetic */ <T> T toObject(DocumentSnapshot documentSnapshot, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        kotlin.jvm.internal.r.f(documentSnapshot, "<this>");
        kotlin.jvm.internal.r.f(serverTimestampBehavior, "serverTimestampBehavior");
        kotlin.jvm.internal.r.k(4, "T");
        return (T) documentSnapshot.toObject(Object.class, serverTimestampBehavior);
    }

    public static final /* synthetic */ <T> List<T> toObjects(QuerySnapshot querySnapshot, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        kotlin.jvm.internal.r.f(querySnapshot, "<this>");
        kotlin.jvm.internal.r.f(serverTimestampBehavior, "serverTimestampBehavior");
        kotlin.jvm.internal.r.k(4, "T");
        List<T> objects = querySnapshot.toObjects(Object.class, serverTimestampBehavior);
        kotlin.jvm.internal.r.e(objects, "toObjects(T::class.java, serverTimestampBehavior)");
        return objects;
    }

    public static final /* synthetic */ <T> w3.d dataObjects(DocumentReference documentReference, MetadataChanges metadataChanges) {
        kotlin.jvm.internal.r.f(documentReference, "<this>");
        kotlin.jvm.internal.r.f(metadataChanges, "metadataChanges");
        w3.d dVarSnapshots = snapshots(documentReference, metadataChanges);
        kotlin.jvm.internal.r.j();
        return new FirestoreKt$dataObjects$$inlined$map$2(dVarSnapshots);
    }

    public static final FirebaseFirestore firestore(Firebase firebase, String database) {
        kotlin.jvm.internal.r.f(firebase, "<this>");
        kotlin.jvm.internal.r.f(database, "database");
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance(database);
        kotlin.jvm.internal.r.e(firebaseFirestore, "getInstance(database)");
        return firebaseFirestore;
    }

    public static final /* synthetic */ <T> T getField(DocumentSnapshot documentSnapshot, FieldPath fieldPath) {
        kotlin.jvm.internal.r.f(documentSnapshot, "<this>");
        kotlin.jvm.internal.r.f(fieldPath, "fieldPath");
        kotlin.jvm.internal.r.k(4, "T");
        return (T) documentSnapshot.get(fieldPath, Object.class);
    }

    public static /* synthetic */ w3.d snapshots$default(Query query, MetadataChanges metadataChanges, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            metadataChanges = MetadataChanges.EXCLUDE;
        }
        return snapshots(query, metadataChanges);
    }

    public static final /* synthetic */ <T> T toObject(QueryDocumentSnapshot queryDocumentSnapshot) {
        kotlin.jvm.internal.r.f(queryDocumentSnapshot, "<this>");
        kotlin.jvm.internal.r.k(4, "T");
        T t4 = (T) queryDocumentSnapshot.toObject(Object.class);
        kotlin.jvm.internal.r.e(t4, "toObject(T::class.java)");
        return t4;
    }

    public static final /* synthetic */ <T> T getField(DocumentSnapshot documentSnapshot, FieldPath fieldPath, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        kotlin.jvm.internal.r.f(documentSnapshot, "<this>");
        kotlin.jvm.internal.r.f(fieldPath, "fieldPath");
        kotlin.jvm.internal.r.f(serverTimestampBehavior, "serverTimestampBehavior");
        kotlin.jvm.internal.r.k(4, "T");
        return (T) documentSnapshot.get(fieldPath, Object.class, serverTimestampBehavior);
    }

    public static final /* synthetic */ <T> T toObject(QueryDocumentSnapshot queryDocumentSnapshot, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        kotlin.jvm.internal.r.f(queryDocumentSnapshot, "<this>");
        kotlin.jvm.internal.r.f(serverTimestampBehavior, "serverTimestampBehavior");
        kotlin.jvm.internal.r.k(4, "T");
        T t4 = (T) queryDocumentSnapshot.toObject(Object.class, serverTimestampBehavior);
        kotlin.jvm.internal.r.e(t4, "toObject(T::class.java, serverTimestampBehavior)");
        return t4;
    }

    public static /* synthetic */ w3.d dataObjects$default(DocumentReference documentReference, MetadataChanges metadataChanges, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            metadataChanges = MetadataChanges.EXCLUDE;
        }
        kotlin.jvm.internal.r.f(documentReference, "<this>");
        kotlin.jvm.internal.r.f(metadataChanges, "metadataChanges");
        w3.d dVarSnapshots = snapshots(documentReference, metadataChanges);
        kotlin.jvm.internal.r.j();
        return new FirestoreKt$dataObjects$$inlined$map$2(dVarSnapshots);
    }
}
