package com.google.android.play.core.integrity;

import S1.C0236e;
import S1.E;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class bn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final C0236e f5399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final S1.z f5400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f5401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TaskCompletionSource f5402d;
    private final at e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final k f5403f;

    public bn(Context context, S1.z zVar, at atVar, k kVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f5402d = taskCompletionSource;
        this.f5401c = context.getPackageName();
        this.f5400b = zVar;
        this.e = atVar;
        this.f5403f = kVar;
        C0236e c0236e = new C0236e(context, zVar, "ExpressIntegrityService", bo.f5404a, new E() { // from class: com.google.android.play.core.integrity.bd
            @Override // S1.E
            public final Object a(IBinder iBinder) {
                int i = S1.o.i;
                if (iBinder == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.integrity.protocol.IExpressIntegrityService");
                return iInterfaceQueryLocalInterface instanceof S1.p ? (S1.p) iInterfaceQueryLocalInterface : new S1.n(iBinder, "com.google.android.play.core.integrity.protocol.IExpressIntegrityService");
            }
        });
        this.f5399a = c0236e;
        c0236e.a().post(new be(this, taskCompletionSource, context));
    }

    public static Bundle a(bn bnVar, String str, long j4, long j6, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", bnVar.f5401c);
        bundle.putLong("cloud.prj", j4);
        bundle.putString("nonce", str);
        bundle.putLong("warm.up.sid", j6);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 3);
        bundle.putInt("playcore.integrity.version.patch", 0);
        bundle.putInt("webview.request.mode", 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new S1.m(5, System.currentTimeMillis()));
        bundle.putParcelableArrayList("event_timestamps", new ArrayList<>(D1.b.a(arrayList)));
        return bundle;
    }

    public static Bundle b(bn bnVar, long j4, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", bnVar.f5401c);
        bundle.putLong("cloud.prj", j4);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 3);
        bundle.putInt("playcore.integrity.version.patch", 0);
        bundle.putInt("webview.request.mode", 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new S1.m(4, System.currentTimeMillis()));
        bundle.putParcelableArrayList("event_timestamps", new ArrayList<>(D1.b.a(arrayList)));
        return bundle;
    }

    public static /* bridge */ /* synthetic */ boolean k(bn bnVar) {
        return bnVar.f5402d.getTask().isSuccessful() && ((Integer) bnVar.f5402d.getTask().getResult()).intValue() == 0;
    }

    public final Task c(Activity activity, Bundle bundle) {
        int i = bundle.getInt("dialog.intent.type");
        this.f5400b.b("requestAndShowDialog(%s)", Integer.valueOf(i));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f5399a.c(new bh(this, taskCompletionSource, bundle, activity, taskCompletionSource, i), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public final Task d(String str, long j4, long j6, int i) {
        this.f5400b.b("requestExpressIntegrityToken(%s)", Long.valueOf(j6));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f5399a.c(new bg(this, taskCompletionSource, 0, str, j4, j6, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public final Task e(long j4, int i) {
        this.f5400b.b("warmUpIntegrityToken(%s)", Long.valueOf(j4));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f5399a.c(new bf(this, taskCompletionSource, 0, j4, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.getTask();
    }
}
