package io.flutter.plugin.platform;

import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class t extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f7208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public A f7209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f7210c;

    public t(Context context, A a6, Context context2) {
        super(context);
        this.f7208a = a6;
        this.f7210c = context2;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"window".equals(str)) {
            return super.getSystemService(str);
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTrace.length && i < 11; i++) {
            if (stackTrace[i].getClassName().equals(AlertDialog.class.getCanonicalName()) && stackTrace[i].getMethodName().equals("<init>")) {
                return this.f7210c.getSystemService(str);
            }
        }
        if (this.f7209b == null) {
            this.f7209b = this.f7208a;
        }
        return this.f7209b;
    }
}
