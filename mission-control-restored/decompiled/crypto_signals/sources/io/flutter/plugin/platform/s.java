package io.flutter.plugin.platform;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.Display;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: loaded from: classes.dex */
public final class s extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputMethodManager f7207a;

    public s(Context context, InputMethodManager inputMethodManager) {
        super(context);
        this.f7207a = inputMethodManager == null ? (InputMethodManager) context.getSystemService("input_method") : inputMethodManager;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context createDisplayContext(Display display) {
        return new s(super.createDisplayContext(display), this.f7207a);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return "input_method".equals(str) ? this.f7207a : super.getSystemService(str);
    }
}
