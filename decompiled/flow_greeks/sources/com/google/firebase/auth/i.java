package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import java.util.Objects;
import n7.s0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f6088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f6089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth f6090c;

    public i(FirebaseAuth firebaseAuth, String str, String str2) {
        this.f6088a = str;
        this.f6089b = str2;
        Objects.requireNonNull(firebaseAuth);
        this.f6090c = firebaseAuth;
    }

    @Override // n7.s0
    public final Task c(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.i("FirebaseAuth", "Creating user with " + this.f6088a + " with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for sign up with email " + this.f6088a);
        }
        FirebaseAuth firebaseAuth = this.f6090c;
        return firebaseAuth.f6027e.zza(firebaseAuth.f6023a, this.f6088a, this.f6089b, this.f6090c.f6033k, str, new FirebaseAuth.c(this.f6090c));
    }
}
