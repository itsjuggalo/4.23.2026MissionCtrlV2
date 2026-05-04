package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a0 extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f2024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f2025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f2026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i0 f2028e;

    public a0(Activity activity, Context context, Handler handler, int i10) {
        kotlin.jvm.internal.t.f(context, "context");
        kotlin.jvm.internal.t.f(handler, "handler");
        this.f2024a = activity;
        this.f2025b = context;
        this.f2026c = handler;
        this.f2027d = i10;
        this.f2028e = new j0();
    }

    public final Activity e() {
        return this.f2024a;
    }

    public final Context f() {
        return this.f2025b;
    }

    public final i0 g() {
        return this.f2028e;
    }

    public final Handler h() {
        return this.f2026c;
    }

    public abstract void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract Object j();

    public abstract LayoutInflater k();

    public void l(p fragment, String[] permissions, int i10) {
        kotlin.jvm.internal.t.f(fragment, "fragment");
        kotlin.jvm.internal.t.f(permissions, "permissions");
    }

    public abstract boolean m(String str);

    public void n(p fragment, Intent intent, int i10, Bundle bundle) {
        kotlin.jvm.internal.t.f(fragment, "fragment");
        kotlin.jvm.internal.t.f(intent, "intent");
        if (i10 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        i0.a.n(this.f2025b, intent, bundle);
    }

    public void o(p fragment, IntentSender intent, int i10, Intent intent2, int i11, int i12, int i13, Bundle bundle) {
        kotlin.jvm.internal.t.f(fragment, "fragment");
        kotlin.jvm.internal.t.f(intent, "intent");
        if (i10 != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        Activity activity = this.f2024a;
        if (activity == null) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        h0.a.w(activity, intent, i10, intent2, i11, i12, i13, bundle);
    }

    public abstract void p();

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a0(u activity) {
        this(activity, activity, new Handler(), 0);
        kotlin.jvm.internal.t.f(activity, "activity");
    }
}
