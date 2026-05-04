package io.flutter.plugins.webviewflutter;

import cd.r;
import io.flutter.plugins.webviewflutter.ResultCompat;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u0016*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0016B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\bR\u0016\u0010\u000e\u001a\u0004\u0018\u00018\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u0017\u0010\u0015\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0015\u0010\u0014¨\u0006\u0017"}, d2 = {"Lio/flutter/plugins/webviewflutter/ResultCompat;", "T", "", "Lcd/r;", "result", "<init>", "(Ljava/lang/Object;)V", "getOrNull", "()Ljava/lang/Object;", "", "exceptionOrNull", "()Ljava/lang/Throwable;", "Ljava/lang/Object;", "getResult-d1pmJ48", "value", "exception", "Ljava/lang/Throwable;", "", "isSuccess", "Z", "()Z", "isFailure", "Companion", "webview_flutter_android_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResultCompat<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Throwable exception;
    private final boolean isFailure;
    private final boolean isSuccess;
    private final Object result;
    private final T value;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\b\u001a\u00020\u0007\"\u0004\b\u0001\u0010\u00042\u0006\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\b\u0010\tJA\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0004\u0012\u00020\u00070\n\"\u0004\b\u0001\u0010\u00042\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0004\u0012\u00020\u00070\nH\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/flutter/plugins/webviewflutter/ResultCompat$Companion;", "", "<init>", "()V", "T", "value", "callback", "Lcd/h0;", "success", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Lkotlin/Function1;", "Lio/flutter/plugins/webviewflutter/ResultCompat;", "result", "Lcd/r;", "asCompatCallback", "(Lpd/k;)Lpd/k;", "webview_flutter_android_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final cd.h0 asCompatCallback$lambda$0(pd.k kVar, r rVar) {
            kVar.invoke(new ResultCompat(rVar.j()));
            return cd.h0.f3852a;
        }

        public final <T> pd.k asCompatCallback(final pd.k result) {
            kotlin.jvm.internal.t.f(result, "result");
            return new pd.k() { // from class: io.flutter.plugins.webviewflutter.k6
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return ResultCompat.Companion.asCompatCallback$lambda$0(result, (r) obj);
                }
            };
        }

        public final <T> void success(T value, Object callback) {
            kotlin.jvm.internal.t.f(callback, "callback");
            ((pd.k) kotlin.jvm.internal.t0.c(callback, 1)).invoke(r.a(r.b(value)));
        }

        private Companion() {
        }
    }

    public ResultCompat(Object obj) {
        this.result = obj;
        this.value = r.g(obj) ? null : (T) obj;
        this.exception = r.e(obj);
        this.isSuccess = r.h(obj);
        this.isFailure = r.g(obj);
    }

    public static final <T> pd.k asCompatCallback(pd.k kVar) {
        return INSTANCE.asCompatCallback(kVar);
    }

    public static final <T> void success(T t10, Object obj) {
        INSTANCE.success(t10, obj);
    }

    /* JADX INFO: renamed from: exceptionOrNull, reason: from getter */
    public final Throwable getException() {
        return this.exception;
    }

    public final T getOrNull() {
        return this.value;
    }

    /* JADX INFO: renamed from: getResult-d1pmJ48, reason: not valid java name and from getter */
    public final Object getResult() {
        return this.result;
    }

    /* JADX INFO: renamed from: isFailure, reason: from getter */
    public final boolean getIsFailure() {
        return this.isFailure;
    }

    /* JADX INFO: renamed from: isSuccess, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }
}
