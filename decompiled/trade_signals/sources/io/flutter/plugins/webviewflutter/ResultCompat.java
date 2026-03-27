package io.flutter.plugins.webviewflutter;

import io.flutter.plugins.webviewflutter.ResultCompat;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;
import o5.C2490r;

/* JADX INFO: loaded from: classes.dex */
public final class ResultCompat<T> {
    public static final Companion Companion = new Companion(null);
    private final Throwable exception;
    private final boolean isFailure;
    private final boolean isSuccess;
    private final Object result;
    private final T value;

    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C2470H asCompatCallback$lambda$0(B5.k kVar, C2490r c2490r) {
            kVar.invoke(new ResultCompat(c2490r.j()));
            return C2470H.f21956a;
        }

        public final <T> B5.k asCompatCallback(final B5.k result) {
            AbstractC2304t.f(result, "result");
            return new B5.k() { // from class: io.flutter.plugins.webviewflutter.J2
                @Override // B5.k
                public final Object invoke(Object obj) {
                    return ResultCompat.Companion.asCompatCallback$lambda$0(result, (C2490r) obj);
                }
            };
        }

        public final <T> void success(T t8, Object callback) {
            AbstractC2304t.f(callback, "callback");
            ((B5.k) kotlin.jvm.internal.V.c(callback, 1)).invoke(C2490r.a(C2490r.b(t8)));
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public ResultCompat(Object obj) {
        this.result = obj;
        this.value = C2490r.g(obj) ? null : (T) obj;
        this.exception = C2490r.e(obj);
        this.isSuccess = C2490r.h(obj);
        this.isFailure = C2490r.g(obj);
    }

    public static final <T> B5.k asCompatCallback(B5.k kVar) {
        return Companion.asCompatCallback(kVar);
    }

    public static final <T> void success(T t8, Object obj) {
        Companion.success(t8, obj);
    }

    public final Throwable exceptionOrNull() {
        return this.exception;
    }

    public final T getOrNull() {
        return this.value;
    }

    /* JADX INFO: renamed from: getResult-d1pmJ48, reason: not valid java name */
    public final Object m183getResultd1pmJ48() {
        return this.result;
    }

    public final boolean isFailure() {
        return this.isFailure;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }
}
