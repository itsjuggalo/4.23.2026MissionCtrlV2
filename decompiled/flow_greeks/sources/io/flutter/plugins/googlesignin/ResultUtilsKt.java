package io.flutter.plugins.googlesignin;

import cd.h0;
import cd.r;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0006\u001a\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u00002\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a/\u0010\n\u001a\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0001\u0012\u0004\u0012\u00020\u00030\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\f\u001a\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0001\u0012\u0004\u0012\u00020\u00030\u0000¢\u0006\u0004\b\f\u0010\r\u001a/\u0010\u000f\u001a\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0001\u0012\u0004\u0012\u00020\u00030\u00002\u0006\u0010\t\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010\u001a/\u0010\u0013\u001a\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0001\u0012\u0004\u0012\u00020\u00030\u00002\u0006\u0010\u0005\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014\u001a/\u0010\u0016\u001a\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0001\u0012\u0004\u0012\u00020\u00030\u00002\u0006\u0010\t\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lkotlin/Function1;", "Lcd/r;", "Lio/flutter/plugins/googlesignin/GetCredentialResult;", "Lcd/h0;", "callback", "result", "completeWithGetGetCredentialResult", "(Lpd/k;Lio/flutter/plugins/googlesignin/GetCredentialResult;)V", "Lio/flutter/plugins/googlesignin/GetCredentialFailure;", "failure", "completeWithGetCredentialFailure", "(Lpd/k;Lio/flutter/plugins/googlesignin/GetCredentialFailure;)V", "completeWithUnitSuccess", "(Lpd/k;)V", "Lio/flutter/plugins/googlesignin/FlutterError;", "completeWithUnitError", "(Lpd/k;Lio/flutter/plugins/googlesignin/FlutterError;)V", "Lio/flutter/plugins/googlesignin/AuthorizeResult;", "Lio/flutter/plugins/googlesignin/PlatformAuthorizationResult;", "completeWithAuthorizationResult", "(Lpd/k;Lio/flutter/plugins/googlesignin/PlatformAuthorizationResult;)V", "Lio/flutter/plugins/googlesignin/AuthorizeFailure;", "completeWithAuthorizeFailure", "(Lpd/k;Lio/flutter/plugins/googlesignin/AuthorizeFailure;)V", "google_sign_in_android_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ResultUtilsKt {
    public static final void completeWithAuthorizationResult(pd.k callback, PlatformAuthorizationResult result) {
        kotlin.jvm.internal.t.f(callback, "callback");
        kotlin.jvm.internal.t.f(result, "result");
        callback.invoke(r.a(r.b(result)));
    }

    public static final void completeWithAuthorizeFailure(pd.k callback, AuthorizeFailure failure) {
        kotlin.jvm.internal.t.f(callback, "callback");
        kotlin.jvm.internal.t.f(failure, "failure");
        callback.invoke(r.a(r.b(failure)));
    }

    public static final void completeWithGetCredentialFailure(pd.k callback, GetCredentialFailure failure) {
        kotlin.jvm.internal.t.f(callback, "callback");
        kotlin.jvm.internal.t.f(failure, "failure");
        callback.invoke(r.a(r.b(failure)));
    }

    public static final void completeWithGetGetCredentialResult(pd.k callback, GetCredentialResult result) {
        kotlin.jvm.internal.t.f(callback, "callback");
        kotlin.jvm.internal.t.f(result, "result");
        callback.invoke(r.a(r.b(result)));
    }

    public static final void completeWithUnitError(pd.k callback, FlutterError failure) {
        kotlin.jvm.internal.t.f(callback, "callback");
        kotlin.jvm.internal.t.f(failure, "failure");
        r.a aVar = r.f3870b;
        callback.invoke(r.a(r.b(cd.s.a(failure))));
    }

    public static final void completeWithUnitSuccess(pd.k callback) {
        kotlin.jvm.internal.t.f(callback, "callback");
        r.a aVar = r.f3870b;
        callback.invoke(r.a(r.b(h0.f3852a)));
    }
}
