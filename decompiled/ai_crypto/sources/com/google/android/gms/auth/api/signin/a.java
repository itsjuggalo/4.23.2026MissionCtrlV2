package com.google.android.gms.auth.api.signin;

import L1.b;
import L1.c;
import M1.q;
import M1.r;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AbstractC1191b;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Collections;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static b a(Context context, GoogleSignInOptions googleSignInOptions) {
        return new b(context, (GoogleSignInOptions) AbstractC1207s.k(googleSignInOptions));
    }

    public static GoogleSignInAccount b(Context context) {
        return r.c(context).a();
    }

    public static Task c(Intent intent) {
        c cVarD = q.d(intent);
        GoogleSignInAccount googleSignInAccountA = cVarD.a();
        return (!cVarD.getStatus().F() || googleSignInAccountA == null) ? Tasks.forException(AbstractC1191b.a(cVarD.getStatus())) : Tasks.forResult(googleSignInAccountA);
    }

    public static boolean d(GoogleSignInAccount googleSignInAccount, Scope... scopeArr) {
        if (googleSignInAccount == null) {
            return false;
        }
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, scopeArr);
        return googleSignInAccount.C().containsAll(hashSet);
    }

    public static void e(Activity activity, int i7, GoogleSignInAccount googleSignInAccount, Scope... scopeArr) {
        AbstractC1207s.l(activity, "Please provide a non-null Activity");
        AbstractC1207s.l(scopeArr, "Please provide at least one scope");
        activity.startActivityForResult(f(activity, googleSignInAccount, scopeArr), i7);
    }

    public static Intent f(Activity activity, GoogleSignInAccount googleSignInAccount, Scope... scopeArr) {
        GoogleSignInOptions.a aVar = new GoogleSignInOptions.a();
        if (scopeArr.length > 0) {
            aVar.f(scopeArr[0], scopeArr);
        }
        if (googleSignInAccount != null && !TextUtils.isEmpty(googleSignInAccount.x())) {
            aVar.h((String) AbstractC1207s.k(googleSignInAccount.x()));
        }
        return new b(activity, aVar.a()).d();
    }
}
