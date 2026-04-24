package com.google.firebase.firestore;

import a3.AbstractC0787c;
import b3.AbstractC0866d;
import b3.InterfaceC0868f;

/* JADX INFO: loaded from: classes.dex */
public final class FirestoreKt$dataObjects$$inlined$map$2 implements w3.d {
    final /* synthetic */ w3.d $this_unsafeTransform$inlined;

    /* JADX INFO: renamed from: com.google.firebase.firestore.FirestoreKt$dataObjects$$inlined$map$2$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements w3.e {
        final /* synthetic */ w3.e $this_unsafeFlow;

        /* JADX INFO: renamed from: com.google.firebase.firestore.FirestoreKt$dataObjects$$inlined$map$2$2$1, reason: invalid class name */
        @InterfaceC0868f(c = "com.google.firebase.firestore.FirestoreKt$dataObjects$$inlined$map$2$2", f = "Firestore.kt", l = {223}, m = "emit")
        public static final class AnonymousClass1 extends AbstractC0866d {
            Object L$0;
            int label;
            /* synthetic */ Object result;

            public AnonymousClass1(Z2.e eVar) {
                super(eVar);
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass2.this.emit(null, this);
            }
        }

        public AnonymousClass2(w3.e eVar) {
            this.$this_unsafeFlow = eVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // w3.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(java.lang.Object r6, Z2.e r7) throws java.lang.Throwable {
            /*
                r5 = this;
                boolean r0 = r7 instanceof com.google.firebase.firestore.FirestoreKt$dataObjects$$inlined$map$2.AnonymousClass2.AnonymousClass1
                if (r0 == 0) goto L13
                r0 = r7
                com.google.firebase.firestore.FirestoreKt$dataObjects$$inlined$map$2$2$1 r0 = (com.google.firebase.firestore.FirestoreKt$dataObjects$$inlined$map$2.AnonymousClass2.AnonymousClass1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.google.firebase.firestore.FirestoreKt$dataObjects$$inlined$map$2$2$1 r0 = new com.google.firebase.firestore.FirestoreKt$dataObjects$$inlined$map$2$2$1
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.result
                java.lang.Object r1 = a3.AbstractC0787c.e()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                W2.q.b(r7)
                goto L4d
            L29:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L31:
                W2.q.b(r7)
                w3.e r7 = r5.$this_unsafeFlow
                com.google.firebase.firestore.DocumentSnapshot r6 = (com.google.firebase.firestore.DocumentSnapshot) r6
                r2 = 4
                java.lang.String r4 = "T"
                kotlin.jvm.internal.r.k(r2, r4)
                java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
                java.lang.Object r6 = r6.toObject(r2)
                r0.label = r3
                java.lang.Object r6 = r7.emit(r6, r0)
                if (r6 != r1) goto L4d
                return r1
            L4d:
                W2.E r6 = W2.E.f5463a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.FirestoreKt$dataObjects$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, Z2.e):java.lang.Object");
        }

        public final Object emit$$forInline(Object obj, Z2.e eVar) {
            kotlin.jvm.internal.p.a(4);
            new AnonymousClass1(eVar);
            kotlin.jvm.internal.p.a(5);
            w3.e eVar2 = this.$this_unsafeFlow;
            kotlin.jvm.internal.r.k(4, "T");
            Object object = ((DocumentSnapshot) obj).toObject(Object.class);
            kotlin.jvm.internal.p.a(0);
            eVar2.emit(object, eVar);
            kotlin.jvm.internal.p.a(1);
            return W2.E.f5463a;
        }
    }

    public FirestoreKt$dataObjects$$inlined$map$2(w3.d dVar) {
        this.$this_unsafeTransform$inlined = dVar;
    }

    @Override // w3.d
    public Object collect(w3.e eVar, Z2.e eVar2) {
        w3.d dVar = this.$this_unsafeTransform$inlined;
        kotlin.jvm.internal.r.j();
        Object objCollect = dVar.collect(new AnonymousClass2(eVar), eVar2);
        return objCollect == AbstractC0787c.e() ? objCollect : W2.E.f5463a;
    }

    public Object collect$$forInline(w3.e eVar, Z2.e eVar2) {
        kotlin.jvm.internal.p.a(4);
        new AbstractC0866d(eVar2) { // from class: com.google.firebase.firestore.FirestoreKt$dataObjects$$inlined$map$2.1
            int label;
            /* synthetic */ Object result;

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FirestoreKt$dataObjects$$inlined$map$2.this.collect(null, this);
            }
        };
        kotlin.jvm.internal.p.a(5);
        w3.d dVar = this.$this_unsafeTransform$inlined;
        kotlin.jvm.internal.r.j();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(eVar);
        kotlin.jvm.internal.p.a(0);
        dVar.collect(anonymousClass2, eVar2);
        kotlin.jvm.internal.p.a(1);
        return W2.E.f5463a;
    }
}
