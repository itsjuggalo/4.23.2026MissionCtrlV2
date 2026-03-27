package e5;

import com.google.firebase.firestore.f;

/* JADX INFO: renamed from: e5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C1508a extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13659b;

    /* JADX INFO: renamed from: e5.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0235a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13660a;

        static {
            int[] iArr = new int[f.a.values().length];
            f13660a = iArr;
            try {
                iArr[f.a.ABORTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13660a[f.a.ALREADY_EXISTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13660a[f.a.CANCELLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13660a[f.a.DATA_LOSS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13660a[f.a.DEADLINE_EXCEEDED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13660a[f.a.FAILED_PRECONDITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13660a[f.a.INTERNAL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13660a[f.a.INVALID_ARGUMENT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13660a[f.a.NOT_FOUND.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f13660a[f.a.OUT_OF_RANGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f13660a[f.a.PERMISSION_DENIED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f13660a[f.a.RESOURCE_EXHAUSTED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f13660a[f.a.UNAUTHENTICATED.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f13660a[f.a.UNAVAILABLE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f13660a[f.a.UNIMPLEMENTED.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f13660a[f.a.UNKNOWN.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C1508a(com.google.firebase.firestore.f r38, java.lang.Throwable r39) {
        /*
            Method dump skipped, instruction units count: 708
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e5.C1508a.<init>(com.google.firebase.firestore.f, java.lang.Throwable):void");
    }

    public String a() {
        return this.f13658a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f13659b;
    }
}
