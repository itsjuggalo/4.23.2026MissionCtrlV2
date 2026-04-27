package com.google.android.play.core.integrity;

import S1.C0236e;
import S1.E;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final C0236e f5341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final S1.z f5342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f5343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final at f5344d;
    private final k e;

    public aj(Context context, S1.z zVar, at atVar, k kVar) {
        this.f5343c = context.getPackageName();
        this.f5342b = zVar;
        this.f5344d = atVar;
        this.e = kVar;
        S1.z zVar2 = S1.g.f2872a;
        try {
            if (context.getPackageManager().getApplicationInfo("com.android.vending", 0).enabled) {
                if (S1.g.a(context.getPackageManager().getPackageInfo("com.android.vending", 64).signatures)) {
                    this.f5341a = new C0236e(context, zVar, "IntegrityService", ak.f5345a, new E() { // from class: com.google.android.play.core.integrity.ae
                        @Override // S1.E
                        public final Object a(IBinder iBinder) {
                            int i = S1.t.i;
                            if (iBinder == null) {
                                return null;
                            }
                            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.integrity.protocol.IIntegrityService");
                            return iInterfaceQueryLocalInterface instanceof S1.u ? (S1.u) iInterfaceQueryLocalInterface : new S1.s(iBinder, "com.google.android.play.core.integrity.protocol.IIntegrityService");
                        }
                    });
                    return;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        Object[] objArr = new Object[0];
        zVar.getClass();
        if (Log.isLoggable("PlayCore", 6)) {
            Log.e("PlayCore", S1.z.c(zVar.f2879a, "Phonesky is not installed.", objArr));
        }
        this.f5341a = null;
    }

    public static Bundle a(aj ajVar, byte[] bArr, Long l6, Parcelable parcelable) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", ajVar.f5343c);
        bundle.putByteArray("nonce", bArr);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 3);
        bundle.putInt("playcore.integrity.version.patch", 0);
        if (l6 != null) {
            bundle.putLong("cloud.prj", l6.longValue());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new S1.m(3, System.currentTimeMillis()));
        bundle.putParcelableArrayList("event_timestamps", new ArrayList<>(D1.b.a(arrayList)));
        return bundle;
    }

    public final Task b(Activity activity, Bundle bundle) {
        if (this.f5341a == null) {
            return Tasks.forException(new IntegrityServiceException(-2, null));
        }
        int i = bundle.getInt("dialog.intent.type");
        this.f5342b.b("requestAndShowDialog(%s, %s)", this.f5343c, Integer.valueOf(i));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f5341a.c(new ag(this, taskCompletionSource, bundle, activity, taskCompletionSource, i), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public final Task c(IntegrityTokenRequest integrityTokenRequest) {
        if (this.f5341a == null) {
            return Tasks.forException(new IntegrityServiceException(-2, null));
        }
        try {
            byte[] bArrDecode = Base64.decode(integrityTokenRequest.nonce(), 10);
            Long lCloudProjectNumber = integrityTokenRequest.cloudProjectNumber();
            if (integrityTokenRequest instanceof ao) {
            }
            this.f5342b.b("requestIntegrityToken(%s)", integrityTokenRequest);
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.f5341a.c(new af(this, taskCompletionSource, bArrDecode, lCloudProjectNumber, null, taskCompletionSource, integrityTokenRequest), taskCompletionSource);
            return taskCompletionSource.getTask();
        } catch (IllegalArgumentException e) {
            return Tasks.forException(new IntegrityServiceException(-13, e));
        }
    }
}
