package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.h0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1342h0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C1342h0 f15417b = new C1342h0(new a("Failure occurred while trying to finish a future."));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C1342h0 f15418c = new C1342h0(new b("Failure.exception is unexpectedly null."));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f15419a;

    /* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.h0$a */
    public class a extends Throwable {
        public a(String str) {
            super("Failure occurred while trying to finish a future.");
        }

        @Override // java.lang.Throwable
        public final Throwable fillInStackTrace() {
            return this;
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.h0$b */
    public class b extends Throwable {
        public b(String str) {
            super("Failure.exception is unexpectedly null.");
        }

        @Override // java.lang.Throwable
        public final Throwable fillInStackTrace() {
            return this;
        }
    }

    public C1342h0(Throwable th) {
        th.getClass();
        this.f15419a = th;
    }
}
