package com.google.android.gms.auth;

import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC0940s;
import n1.C1618d;
import n1.EnumC1631q;

/* JADX INFO: loaded from: classes.dex */
public class UserRecoverableAuthException extends C1618d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f9564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PendingIntent f9565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EnumC1631q f9566c;

    public UserRecoverableAuthException(String str, Intent intent) {
        this(str, intent, null, EnumC1631q.LEGACY);
    }

    public static UserRecoverableAuthException b(String str, Intent intent, PendingIntent pendingIntent) {
        AbstractC0940s.k(intent);
        AbstractC0940s.k(pendingIntent);
        return new UserRecoverableAuthException(str, intent, pendingIntent, EnumC1631q.AUTH_INSTANTIATION);
    }

    public Intent a() {
        Intent intent = this.f9564a;
        if (intent != null) {
            return new Intent(intent);
        }
        int iOrdinal = this.f9566c.ordinal();
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

    public UserRecoverableAuthException(String str, Intent intent, PendingIntent pendingIntent, EnumC1631q enumC1631q) {
        super(str);
        this.f9565b = pendingIntent;
        this.f9564a = intent;
        this.f9566c = (EnumC1631q) AbstractC0940s.k(enumC1631q);
    }
}
