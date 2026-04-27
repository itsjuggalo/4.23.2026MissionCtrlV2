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
import w.AbstractC1897a;
import x.AbstractC1909a;

/* JADX INFO: loaded from: classes.dex */
public abstract class A extends AbstractC0834w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f7230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f7231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f7232c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f7233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final I f7234f;

    public A(Activity activity, Context context, Handler handler, int i4) {
        kotlin.jvm.internal.r.f(context, "context");
        kotlin.jvm.internal.r.f(handler, "handler");
        this.f7230a = activity;
        this.f7231b = context;
        this.f7232c = handler;
        this.f7233e = i4;
        this.f7234f = new J();
    }

    public final Activity e() {
        return this.f7230a;
    }

    public final Context f() {
        return this.f7231b;
    }

    public final I g() {
        return this.f7234f;
    }

    public final Handler h() {
        return this.f7232c;
    }

    public abstract void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract Object j();

    public abstract LayoutInflater k();

    public void l(AbstractComponentCallbacksC0828p fragment, String[] permissions, int i4) {
        kotlin.jvm.internal.r.f(fragment, "fragment");
        kotlin.jvm.internal.r.f(permissions, "permissions");
    }

    public abstract boolean m(String str);

    public void n(AbstractComponentCallbacksC0828p fragment, Intent intent, int i4, Bundle bundle) {
        kotlin.jvm.internal.r.f(fragment, "fragment");
        kotlin.jvm.internal.r.f(intent, "intent");
        if (i4 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        AbstractC1909a.startActivity(this.f7231b, intent, bundle);
    }

    public void o(AbstractComponentCallbacksC0828p fragment, IntentSender intent, int i4, Intent intent2, int i5, int i6, int i7, Bundle bundle) {
        kotlin.jvm.internal.r.f(fragment, "fragment");
        kotlin.jvm.internal.r.f(intent, "intent");
        if (i4 != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        Activity activity = this.f7230a;
        if (activity == null) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        AbstractC1897a.h(activity, intent, i4, intent2, i5, i6, i7, bundle);
    }

    public abstract void p();

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public A(AbstractActivityC0832u activity) {
        this(activity, activity, new Handler(), 0);
        kotlin.jvm.internal.r.f(activity, "activity");
    }
}
