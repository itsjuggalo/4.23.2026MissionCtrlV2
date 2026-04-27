package t;

import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence[] f9808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f9810d;
    public final HashSet e;

    public d0(String str, CharSequence[] charSequenceArr, boolean z6, Bundle bundle, HashSet hashSet) {
        this.f9807a = str;
        this.f9808b = charSequenceArr;
        this.f9809c = z6;
        this.f9810d = bundle;
        this.e = hashSet;
    }

    public static RemoteInput a(d0 d0Var) {
        d0Var.getClass();
        RemoteInput.Builder builderAddExtras = new RemoteInput.Builder("FlutterLocalNotificationsPluginInputResult").setLabel(d0Var.f9807a).setChoices(d0Var.f9808b).setAllowFreeFormInput(d0Var.f9809c).addExtras(d0Var.f9810d);
        if (Build.VERSION.SDK_INT >= 26) {
            Iterator it = d0Var.e.iterator();
            while (it.hasNext()) {
                b0.d(builderAddExtras, (String) it.next(), true);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            c0.b(builderAddExtras, 0);
        }
        return builderAddExtras.build();
    }
}
