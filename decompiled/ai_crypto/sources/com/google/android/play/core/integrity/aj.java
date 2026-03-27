package com.google.android.play.core.integrity;

import F2.A;
import F2.AbstractC0472j;
import F2.C0468f;
import F2.G;
import F2.N;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final C0468f f11871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final G f11872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f11873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final at f11874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final k f11875e;

    public aj(Context context, G g7, at atVar, k kVar) {
        this.f11873c = context.getPackageName();
        this.f11872b = g7;
        this.f11874d = atVar;
        this.f11875e = kVar;
        if (AbstractC0472j.b(context)) {
            this.f11871a = new C0468f(context, g7, "IntegrityService", ak.f11876a, new N() { // from class: com.google.android.play.core.integrity.ae
                @Override // F2.N
                public final Object a(IBinder iBinder) {
                    return A.b(iBinder);
                }
            }, null);
        } else {
            g7.b("Phonesky is not installed.", new Object[0]);
            this.f11871a = null;
        }
    }

    public static /* bridge */ /* synthetic */ Bundle a(aj ajVar, byte[] bArr, Long l7, Parcelable parcelable) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", ajVar.f11873c);
        bundle.putByteArray("nonce", bArr);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 3);
        bundle.putInt("playcore.integrity.version.patch", 0);
        if (l7 != null) {
            bundle.putLong("cloud.prj", l7.longValue());
        }
        ArrayList arrayList = new ArrayList();
        F2.r.b(3, arrayList);
        bundle.putParcelableArrayList("event_timestamps", new ArrayList<>(F2.r.a(arrayList)));
        return bundle;
    }

    public final Task b(Activity activity, Bundle bundle) {
        if (this.f11871a == null) {
            return Tasks.forException(new IntegrityServiceException(-2, null));
        }
        int i7 = bundle.getInt("dialog.intent.type");
        this.f11872b.d("requestAndShowDialog(%s, %s)", this.f11873c, Integer.valueOf(i7));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f11871a.t(new ag(this, taskCompletionSource, bundle, activity, taskCompletionSource, i7), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public final Task c(IntegrityTokenRequest integrityTokenRequest) {
        if (this.f11871a == null) {
            return Tasks.forException(new IntegrityServiceException(-2, null));
        }
        try {
            byte[] bArrDecode = Base64.decode(integrityTokenRequest.nonce(), 10);
            Long lCloudProjectNumber = integrityTokenRequest.cloudProjectNumber();
            if (integrityTokenRequest instanceof ao) {
            }
            this.f11872b.d("requestIntegrityToken(%s)", integrityTokenRequest);
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.f11871a.t(new af(this, taskCompletionSource, bArrDecode, lCloudProjectNumber, null, taskCompletionSource, integrityTokenRequest), taskCompletionSource);
            return taskCompletionSource.getTask();
        } catch (IllegalArgumentException e7) {
            return Tasks.forException(new IntegrityServiceException(-13, e7));
        }
    }
}
