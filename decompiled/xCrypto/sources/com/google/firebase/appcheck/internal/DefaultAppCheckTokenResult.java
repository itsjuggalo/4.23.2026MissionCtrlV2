package com.google.firebase.appcheck.internal;

import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.FirebaseException;
import com.google.firebase.appcheck.AppCheckToken;
import com.google.firebase.appcheck.AppCheckTokenResult;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultAppCheckTokenResult extends AppCheckTokenResult {
    static final String DUMMY_TOKEN = "eyJlcnJvciI6IlVOS05PV05fRVJST1IifQ==";
    private final FirebaseException error;
    private final String token;

    private DefaultAppCheckTokenResult(String str, FirebaseException firebaseException) {
        AbstractC0940s.e(str);
        this.token = str;
        this.error = firebaseException;
    }

    public static DefaultAppCheckTokenResult constructFromAppCheckToken(AppCheckToken appCheckToken) {
        AbstractC0940s.k(appCheckToken);
        return new DefaultAppCheckTokenResult(appCheckToken.getToken(), null);
    }

    public static DefaultAppCheckTokenResult constructFromError(FirebaseException firebaseException) {
        return new DefaultAppCheckTokenResult(DUMMY_TOKEN, (FirebaseException) AbstractC0940s.k(firebaseException));
    }

    @Override // com.google.firebase.appcheck.AppCheckTokenResult
    public Exception getError() {
        return this.error;
    }

    @Override // com.google.firebase.appcheck.AppCheckTokenResult
    public String getToken() {
        return this.token;
    }
}
