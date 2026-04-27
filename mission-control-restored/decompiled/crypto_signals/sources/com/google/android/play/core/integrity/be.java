package com.google.android.play.core.integrity;

import S1.A;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class be extends A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f5378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ bn f5379b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(bn bnVar, TaskCompletionSource taskCompletionSource, Context context) {
        super(taskCompletionSource);
        this.f5379b = bnVar;
        this.f5378a = context;
    }

    @Override // S1.A
    public final void b() {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        Context context = this.f5378a;
        TaskCompletionSource taskCompletionSource = this.f5379b.f5402d;
        S1.z zVar = S1.g.f2872a;
        try {
            packageInfo = context.getPackageManager().getPackageInfo("com.android.vending", 64);
            applicationInfo = packageInfo.applicationInfo;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        int i = (applicationInfo != null && applicationInfo.enabled && S1.g.a(packageInfo.signatures)) ? packageInfo.versionCode : 0;
        taskCompletionSource.trySetResult(Integer.valueOf(i));
    }
}
