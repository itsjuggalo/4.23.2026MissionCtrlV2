package io.flutter.plugins.webviewflutter;

import io.flutter.plugins.webviewflutter.ResultCompat;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public final class ResultCompat<T> {
    public static final Companion Companion = new Companion(null);
    private final Throwable exception;
    private final boolean isFailure;
    private final boolean isSuccess;
    private final Object result;
    private final T value;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final W2.E asCompatCallback$lambda$0(i3.k kVar, W2.p pVar) {
            kVar.invoke(new ResultCompat(pVar.j()));
            return W2.E.f5463a;
        }

        public final <T> i3.k asCompatCallback(final i3.k result) {
            kotlin.jvm.internal.r.f(result, "result");
            return new i3.k() { // from class: io.flutter.plugins.webviewflutter.M2
                @Override // i3.k
                public final Object invoke(Object obj) {
                    return ResultCompat.Companion.asCompatCallback$lambda$0(result, (W2.p) obj);
                }
            };
        }

        public final <T> void success(T t4, Object callback) {
            kotlin.jvm.internal.r.f(callback, "callback");
            ((i3.k) kotlin.jvm.internal.K.b(callback, 1)).invoke(W2.p.a(W2.p.b(t4)));
        }

        private Companion() {
        }
    }

    public ResultCompat(Object obj) {
        this.result = obj;
        this.value = W2.p.g(obj) ? null : (T) obj;
        this.exception = W2.p.e(obj);
        this.isSuccess = W2.p.h(obj);
        this.isFailure = W2.p.g(obj);
    }

    public static final <T> i3.k asCompatCallback(i3.k kVar) {
        return Companion.asCompatCallback(kVar);
    }

    public static final <T> void success(T t4, Object obj) {
        Companion.success(t4, obj);
    }

    public final Throwable exceptionOrNull() {
        return this.exception;
    }

    public final T getOrNull() {
        return this.value;
    }

    /* JADX INFO: renamed from: getResult-d1pmJ48, reason: not valid java name */
    public final Object m220getResultd1pmJ48() {
        return this.result;
    }

    public final boolean isFailure() {
        return this.isFailure;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }
}
