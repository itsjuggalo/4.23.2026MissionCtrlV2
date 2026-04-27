package S1;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzdf;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class N4 implements Application.ActivityLifecycleCallbacks, L4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f4128a;

    public N4(C0540b5 c0540b5) {
        Objects.requireNonNull(c0540b5);
        this.f4128a = c0540b5;
    }

    @Override // S1.L4
    public final void a(zzdf zzdfVar) {
        C0658q3 c0658q3 = this.f4128a.f4245a;
        c0658q3.I().x(zzdfVar);
        C0708w6 c0708w6Z = c0658q3.z();
        C0658q3 c0658q32 = c0708w6Z.f4245a;
        c0658q32.b().t(new RunnableC0645o6(c0708w6Z, c0658q32.f().a()));
    }

    @Override // S1.L4
    public final void b(zzdf zzdfVar) {
        this.f4128a.f4245a.I().z(zzdfVar);
    }

    @Override // S1.L4
    public final void c(zzdf zzdfVar, Bundle bundle) {
        this.f4128a.f4245a.I().y(zzdfVar, bundle);
    }

    @Override // S1.L4
    public final void d(zzdf zzdfVar) {
        C0658q3 c0658q3 = this.f4128a.f4245a;
        C0708w6 c0708w6Z = c0658q3.z();
        C0658q3 c0658q32 = c0708w6Z.f4245a;
        c0658q32.b().t(new RunnableC0637n6(c0708w6Z, c0658q32.f().a()));
        c0658q3.I().w(zzdfVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0082  */
    @Override // S1.L4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(com.google.android.gms.internal.measurement.zzdf r8, android.os.Bundle r9) throws java.lang.Throwable {
        /*
            r7 = this;
            S1.b5 r0 = r7.f4128a     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            S1.q3 r1 = r0.f4245a     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            S1.C2 r2 = r1.a()     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            S1.A2 r2 = r2.w()     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            java.lang.String r3 = "onActivityCreated"
            r2.a(r3)     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            android.content.Intent r2 = r8.zzc     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            if (r2 == 0) goto L4c
            android.net.Uri r3 = r2.getData()     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            if (r3 == 0) goto L2c
            boolean r4 = r3.isHierarchical()     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            if (r4 != 0) goto L22
            goto L2c
        L22:
            r4 = r3
            goto L44
        L24:
            r0 = move-exception
            r2 = r7
            goto Lb6
        L28:
            r0 = move-exception
            r2 = r7
            goto La0
        L2c:
            android.os.Bundle r3 = r2.getExtras()     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            r4 = 0
            if (r3 == 0) goto L44
            java.lang.String r5 = "com.android.vending.referral_url"
            java.lang.String r3 = r3.getString(r5)     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            if (r5 != 0) goto L44
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            goto L22
        L44:
            if (r4 == 0) goto L4c
            boolean r3 = r4.isHierarchical()     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            if (r3 != 0) goto L4e
        L4c:
            r2 = r7
            goto L96
        L4e:
            r1.C()     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            java.lang.String r0 = "android.intent.extra.REFERRER_NAME"
            java.lang.String r0 = r2.getStringExtra(r0)     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            java.lang.String r2 = "android-app://com.google.android.googlequicksearchbox/https/www.google.com"
            boolean r2 = r2.equals(r0)     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            if (r2 != 0) goto L74
            java.lang.String r2 = "https://www.google.com"
            boolean r2 = r2.equals(r0)     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            if (r2 != 0) goto L74
            java.lang.String r2 = "android-app://com.google.appcrawler"
            boolean r0 = r2.equals(r0)     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            if (r0 == 0) goto L70
            goto L74
        L70:
            java.lang.String r0 = "auto"
        L72:
            r5 = r0
            goto L77
        L74:
            java.lang.String r0 = "gs"
            goto L72
        L77:
            java.lang.String r0 = "referrer"
            java.lang.String r6 = r4.getQueryParameter(r0)     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            if (r9 != 0) goto L82
            r0 = 1
        L80:
            r3 = r0
            goto L84
        L82:
            r0 = 0
            goto L80
        L84:
            S1.i3 r0 = r1.b()     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            S1.M4 r1 = new S1.M4     // Catch: java.lang.Throwable -> L24 java.lang.RuntimeException -> L28
            r2 = r7
            r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L92 java.lang.RuntimeException -> L94
            r0.t(r1)     // Catch: java.lang.Throwable -> L92 java.lang.RuntimeException -> L94
            goto Lb1
        L92:
            r0 = move-exception
            goto Lb6
        L94:
            r0 = move-exception
            goto La0
        L96:
            S1.q3 r0 = r0.f4245a
        L98:
            S1.u5 r0 = r0.I()
            r0.v(r8, r9)
            return
        La0:
            S1.b5 r1 = r2.f4128a     // Catch: java.lang.Throwable -> L92
            S1.q3 r1 = r1.f4245a     // Catch: java.lang.Throwable -> L92
            S1.C2 r1 = r1.a()     // Catch: java.lang.Throwable -> L92
            S1.A2 r1 = r1.o()     // Catch: java.lang.Throwable -> L92
            java.lang.String r3 = "Throwable caught in onActivityCreated"
            r1.b(r3, r0)     // Catch: java.lang.Throwable -> L92
        Lb1:
            S1.b5 r0 = r2.f4128a
            S1.q3 r0 = r0.f4245a
            goto L98
        Lb6:
            S1.b5 r1 = r2.f4128a
            S1.q3 r1 = r1.f4245a
            S1.u5 r1 = r1.I()
            r1.v(r8, r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.N4.e(com.google.android.gms.internal.measurement.zzdf, android.os.Bundle):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) throws Throwable {
        e(zzdf.zza(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        b(zzdf.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(zzdf.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        d(zzdf.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        c(zzdf.zza(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
