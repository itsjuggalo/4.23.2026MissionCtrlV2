package com.google.android.play.core.integrity;

import X1.C0745f;
import X1.G;
import X1.N;
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
    final C0745f f10151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final G f10152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TaskCompletionSource f10154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final at f10155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final k f10156f;

    public bn(Context context, G g4, at atVar, k kVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f10154d = taskCompletionSource;
        this.f10153c = context.getPackageName();
        this.f10152b = g4;
        this.f10155e = atVar;
        this.f10156f = kVar;
        C0745f c0745f = new C0745f(context, g4, "ExpressIntegrityService", bo.f10157a, new N() { // from class: com.google.android.play.core.integrity.bd
            @Override // X1.N
            public final Object a(IBinder iBinder) {
                return X1.v.b(iBinder);
            }
        }, null);
        this.f10151a = c0745f;
        c0745f.c().post(new be(this, taskCompletionSource, context));
    }

    public static /* bridge */ /* synthetic */ Bundle a(bn bnVar, String str, long j4, long j5, int i4) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", bnVar.f10153c);
        bundle.putLong("cloud.prj", j4);
        bundle.putString("nonce", str);
        bundle.putLong("warm.up.sid", j5);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 3);
        bundle.putInt("playcore.integrity.version.patch", 0);
        bundle.putInt("webview.request.mode", 0);
        ArrayList arrayList = new ArrayList();
        X1.r.b(5, arrayList);
        bundle.putParcelableArrayList("event_timestamps", new ArrayList<>(X1.r.a(arrayList)));
        return bundle;
    }

    public static /* bridge */ /* synthetic */ Bundle b(bn bnVar, long j4, int i4) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", bnVar.f10153c);
        bundle.putLong("cloud.prj", j4);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 3);
        bundle.putInt("playcore.integrity.version.patch", 0);
        bundle.putInt("webview.request.mode", 0);
        ArrayList arrayList = new ArrayList();
        X1.r.b(4, arrayList);
        bundle.putParcelableArrayList("event_timestamps", new ArrayList<>(X1.r.a(arrayList)));
        return bundle;
    }

    public static /* bridge */ /* synthetic */ boolean k(bn bnVar) {
        return bnVar.f10154d.getTask().isSuccessful() && ((Integer) bnVar.f10154d.getTask().getResult()).intValue() == 0;
    }

    public final Task c(Activity activity, Bundle bundle) {
        int i4 = bundle.getInt("dialog.intent.type");
        this.f10152b.d("requestAndShowDialog(%s)", Integer.valueOf(i4));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f10151a.t(new bh(this, taskCompletionSource, bundle, activity, taskCompletionSource, i4), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public final Task d(String str, long j4, long j5, int i4) {
        this.f10152b.d("requestExpressIntegrityToken(%s)", Long.valueOf(j5));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f10151a.t(new bg(this, taskCompletionSource, 0, str, j4, j5, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public final Task e(long j4, int i4) {
        this.f10152b.d("warmUpIntegrityToken(%s)", Long.valueOf(j4));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f10151a.t(new bf(this, taskCompletionSource, 0, j4, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.getTask();
    }
}
