package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import java.util.Objects;
import m7.a0;
import n7.s0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class n extends s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f6106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f6107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a0 f6108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f6109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f6110e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth f6111f;

    public n(FirebaseAuth firebaseAuth, String str, boolean z10, a0 a0Var, String str2, String str3) {
        this.f6106a = str;
        this.f6107b = z10;
        this.f6108c = a0Var;
        this.f6109d = str2;
        this.f6110e = str3;
        Objects.requireNonNull(firebaseAuth);
        this.f6111f = firebaseAuth;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.google.firebase.auth.FirebaseAuth$d, n7.k1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // n7.s0
    public final Task c(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.i("FirebaseAuth", "Logging in as " + this.f6106a + " with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for login with email " + this.f6106a);
        }
        if (this.f6107b) {
            FirebaseAuth firebaseAuth = this.f6111f;
            return firebaseAuth.f6027e.zzb(firebaseAuth.f6023a, (a0) s.k(this.f6108c), this.f6106a, this.f6109d, this.f6110e, str, new FirebaseAuth.d(this.f6111f));
        }
        FirebaseAuth firebaseAuth2 = this.f6111f;
        return firebaseAuth2.f6027e.zzb(firebaseAuth2.f6023a, this.f6106a, this.f6109d, this.f6110e, str, new FirebaseAuth.c(this.f6111f));
    }
}
