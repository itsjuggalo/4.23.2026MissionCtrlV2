package com.google.android.gms.auth;

import android.content.Intent;
import com.google.android.gms.common.annotation.KeepName;
import e3.v;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public class UserRecoverableAuthException extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f5001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5002b;

    public UserRecoverableAuthException(int i, String str, Intent intent) {
        super(str);
        this.f5001a = intent;
        if (i == 0) {
            throw new NullPointerException("null reference");
        }
        this.f5002b = i;
    }
}
