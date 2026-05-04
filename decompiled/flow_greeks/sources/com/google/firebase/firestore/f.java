package com.google.firebase.firestore;

import android.util.SparseArray;
import n9.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f extends a7.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f6154a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum a {
        OK(0),
        CANCELLED(1),
        UNKNOWN(2),
        INVALID_ARGUMENT(3),
        DEADLINE_EXCEEDED(4),
        NOT_FOUND(5),
        ALREADY_EXISTS(6),
        PERMISSION_DENIED(7),
        RESOURCE_EXHAUSTED(8),
        FAILED_PRECONDITION(9),
        ABORTED(10),
        OUT_OF_RANGE(11),
        UNIMPLEMENTED(12),
        INTERNAL(13),
        UNAVAILABLE(14),
        DATA_LOSS(15),
        UNAUTHENTICATED(16);


        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final SparseArray f6172s = b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6174a;

        a(int i10) {
            this.f6174a = i10;
        }

        public static SparseArray b() {
            SparseArray sparseArray = new SparseArray();
            for (a aVar : values()) {
                a aVar2 = (a) sparseArray.get(aVar.h());
                if (aVar2 != null) {
                    throw new IllegalStateException("Code value duplication between " + aVar2 + "&" + aVar.name());
                }
                sparseArray.put(aVar.h(), aVar);
            }
            return sparseArray;
        }

        public static a c(int i10) {
            return (a) f6172s.get(i10, UNKNOWN);
        }

        public int h() {
            return this.f6174a;
        }
    }

    public f(String str, a aVar) {
        super(str);
        x.c(str, "Provided message must not be null.");
        n9.b.d(aVar != a.OK, "A FirebaseFirestoreException should never be thrown for OK", new Object[0]);
        this.f6154a = (a) x.c(aVar, "Provided code must not be null.");
    }

    public a a() {
        return this.f6154a;
    }

    public f(String str, a aVar, Throwable th) {
        super(str, th);
        x.c(str, "Provided message must not be null.");
        n9.b.d(aVar != a.OK, "A FirebaseFirestoreException should never be thrown for OK", new Object[0]);
        this.f6154a = (a) x.c(aVar, "Provided code must not be null.");
    }
}
