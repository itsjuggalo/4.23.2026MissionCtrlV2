package com.google.android.gms.auth.api.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AbstractC0924b;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Collections;
import java.util.HashSet;
import u1.C1863b;
import u1.C1864c;
import v1.q;
import v1.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static C1863b a(Context context, GoogleSignInOptions googleSignInOptions) {
        return new C1863b(context, (GoogleSignInOptions) AbstractC0940s.k(googleSignInOptions));
    }

    public static GoogleSignInAccount b(Context context) {
        return r.c(context).a();
    }

    public static Task c(Intent intent) {
        C1864c c1864cD = q.d(intent);
        GoogleSignInAccount googleSignInAccountA = c1864cD.a();
        return (!c1864cD.getStatus().o() || googleSignInAccountA == null) ? Tasks.forException(AbstractC0924b.a(c1864cD.getStatus())) : Tasks.forResult(googleSignInAccountA);
    }

    public static boolean d(GoogleSignInAccount googleSignInAccount, Scope... scopeArr) {
        if (googleSignInAccount == null) {
            return false;
        }
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, scopeArr);
        return googleSignInAccount.l().containsAll(hashSet);
    }

    public static void e(Activity activity, int i4, GoogleSignInAccount googleSignInAccount, Scope... scopeArr) {
        AbstractC0940s.l(activity, "Please provide a non-null Activity");
        AbstractC0940s.l(scopeArr, "Please provide at least one scope");
        activity.startActivityForResult(f(activity, googleSignInAccount, scopeArr), i4);
    }

    public static Intent f(Activity activity, GoogleSignInAccount googleSignInAccount, Scope... scopeArr) {
        GoogleSignInOptions.a aVar = new GoogleSignInOptions.a();
        if (scopeArr.length > 0) {
            aVar.f(scopeArr[0], scopeArr);
        }
        if (googleSignInAccount != null && !TextUtils.isEmpty(googleSignInAccount.getEmail())) {
            aVar.h((String) AbstractC0940s.k(googleSignInAccount.getEmail()));
        }
        return new C1863b(activity, aVar.a()).d();
    }
}
