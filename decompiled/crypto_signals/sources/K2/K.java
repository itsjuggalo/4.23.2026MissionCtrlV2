package K2;

/* JADX INFO: loaded from: classes.dex */
public final class K extends Z1.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final J f852a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(String str, J j4, Exception exc) {
        super(str, exc);
        com.google.android.gms.common.internal.I.e(str, "Detail message must not be empty");
        s3.D.k(str, "Provided message must not be null.");
        D1.b.w("A FirebaseFirestoreException should never be thrown for OK", j4 != J.OK, new Object[0]);
        s3.D.k(j4, "Provided code must not be null.");
        this.f852a = j4;
    }

    public K(String str, J j4) {
        super(str);
        s3.D.k(str, "Provided message must not be null.");
        D1.b.w("A FirebaseFirestoreException should never be thrown for OK", j4 != J.OK, new Object[0]);
        this.f852a = j4;
    }
}
