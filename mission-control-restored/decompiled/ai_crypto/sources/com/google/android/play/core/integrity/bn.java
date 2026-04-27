package com.google.android.play.core.integrity;

import F2.C0468f;
import F2.G;
import F2.N;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class bn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final C0468f f11934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final G f11935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f11936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TaskCompletionSource f11937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final at f11938e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final k f11939f;

    public bn(Context context, G g7, at atVar, k kVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f11937d = taskCompletionSource;
        this.f11936c = context.getPackageName();
        this.f11935b = g7;
        this.f11938e = atVar;
        this.f11939f = kVar;
        C0468f c0468f = new C0468f(context, g7, "ExpressIntegrityService", bo.f11940a, new N() { // from class: com.google.android.play.core.integrity.bd
            @Override // F2.N
            public final Object a(IBinder iBinder) {
                return F2.v.b(iBinder);
            }
        }, null);
        this.f11934a = c0468f;
        c0468f.c().post(new be(this, taskCompletionSource, context));
    }

    public static /* bridge */ /* synthetic */ Bundle a(bn bnVar, String str, long j7, long j8, int i7) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", bnVar.f11936c);
        bundle.putLong("cloud.prj", j7);
        bundle.putString("nonce", str);
        bundle.putLong("warm.up.sid", j8);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 3);
        bundle.putInt("playcore.integrity.version.patch", 0);
        bundle.putInt("webview.request.mode", 0);
        ArrayList arrayList = new ArrayList();
        F2.r.b(5, arrayList);
        bundle.putParcelableArrayList("event_timestamps", new ArrayList<>(F2.r.a(arrayList)));
        return bundle;
    }

    public static /* bridge */ /* synthetic */ Bundle b(bn bnVar, long j7, int i7) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", bnVar.f11936c);
        bundle.putLong("cloud.prj", j7);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 3);
        bundle.putInt("playcore.integrity.version.patch", 0);
        bundle.putInt("webview.request.mode", 0);
        ArrayList arrayList = new ArrayList();
        F2.r.b(4, arrayList);
        bundle.putParcelableArrayList("event_timestamps", new ArrayList<>(F2.r.a(arrayList)));
        return bundle;
    }

    public static /* bridge */ /* synthetic */ boolean k(bn bnVar) {
        return bnVar.f11937d.getTask().isSuccessful() && ((Integer) bnVar.f11937d.getTask().getResult()).intValue() == 0;
    }

    public final Task c(Activity activity, Bundle bundle) {
        int i7 = bundle.getInt("dialog.intent.type");
        this.f11935b.d("requestAndShowDialog(%s)", Integer.valueOf(i7));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f11934a.t(new bh(this, taskCompletionSource, bundle, activity, taskCompletionSource, i7), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public final Task d(String str, long j7, long j8, int i7) {
        this.f11935b.d("requestExpressIntegrityToken(%s)", Long.valueOf(j8));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f11934a.t(new bg(this, taskCompletionSource, 0, str, j7, j8, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public final Task e(long j7, int i7) {
        this.f11935b.d("warmUpIntegrityToken(%s)", Long.valueOf(j7));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f11934a.t(new bf(this, taskCompletionSource, 0, j7, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.getTask();
    }
}
