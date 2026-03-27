package com.google.android.gms.auth;

import E1.d;
import E1.q;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public class UserRecoverableAuthException extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f10749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PendingIntent f10750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q f10751c;

    public UserRecoverableAuthException(String str, Intent intent) {
        this(str, intent, null, q.LEGACY);
    }

    public static UserRecoverableAuthException b(String str, Intent intent, PendingIntent pendingIntent) {
        AbstractC1207s.k(intent);
        AbstractC1207s.k(pendingIntent);
        return new UserRecoverableAuthException(str, intent, pendingIntent, q.AUTH_INSTANTIATION);
    }

    public Intent a() {
        Intent intent = this.f10749a;
        if (intent != null) {
            return new Intent(intent);
        }
        int iOrdinal = this.f10751c.ordinal();
        if (iOrdinal == 0) {
            Log.w("Auth", "Make sure that an intent was provided to class instantiation.");
            return null;
        }
        if (iOrdinal == 1) {
            Log.e("Auth", "This shouldn't happen. Gms API throwing this exception should support the recovery Intent.");
            return null;
        }
        if (iOrdinal != 2) {
            return null;
        }
        Log.e("Auth", "this instantiation of UserRecoverableAuthException doesn't support an Intent.");
        return null;
    }

    public UserRecoverableAuthException(String str, Intent intent, PendingIntent pendingIntent, q qVar) {
        super(str);
        this.f10750b = pendingIntent;
        this.f10749a = intent;
        this.f10751c = (q) AbstractC1207s.k(qVar);
    }
}
