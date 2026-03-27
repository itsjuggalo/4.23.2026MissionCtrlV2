package com.google.android.play.core.integrity;

import X1.A;
import X1.AbstractC0749j;
import X1.C0745f;
import X1.G;
import X1.N;
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
    final C0745f f10088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final G f10089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final at f10091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final k f10092e;

    public aj(Context context, G g4, at atVar, k kVar) {
        this.f10090c = context.getPackageName();
        this.f10089b = g4;
        this.f10091d = atVar;
        this.f10092e = kVar;
        if (AbstractC0749j.b(context)) {
            this.f10088a = new C0745f(context, g4, "IntegrityService", ak.f10093a, new N() { // from class: com.google.android.play.core.integrity.ae
                @Override // X1.N
                public final Object a(IBinder iBinder) {
                    return A.b(iBinder);
                }
            }, null);
        } else {
            g4.b("Phonesky is not installed.", new Object[0]);
            this.f10088a = null;
        }
    }

    public static /* bridge */ /* synthetic */ Bundle a(aj ajVar, byte[] bArr, Long l4, Parcelable parcelable) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", ajVar.f10090c);
        bundle.putByteArray("nonce", bArr);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 3);
        bundle.putInt("playcore.integrity.version.patch", 0);
        if (l4 != null) {
            bundle.putLong("cloud.prj", l4.longValue());
        }
        ArrayList arrayList = new ArrayList();
        X1.r.b(3, arrayList);
        bundle.putParcelableArrayList("event_timestamps", new ArrayList<>(X1.r.a(arrayList)));
        return bundle;
    }

    public final Task b(Activity activity, Bundle bundle) {
        if (this.f10088a == null) {
            return Tasks.forException(new IntegrityServiceException(-2, null));
        }
        int i4 = bundle.getInt("dialog.intent.type");
        this.f10089b.d("requestAndShowDialog(%s, %s)", this.f10090c, Integer.valueOf(i4));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f10088a.t(new ag(this, taskCompletionSource, bundle, activity, taskCompletionSource, i4), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public final Task c(IntegrityTokenRequest integrityTokenRequest) {
        if (this.f10088a == null) {
            return Tasks.forException(new IntegrityServiceException(-2, null));
        }
        try {
            byte[] bArrDecode = Base64.decode(integrityTokenRequest.nonce(), 10);
            Long lCloudProjectNumber = integrityTokenRequest.cloudProjectNumber();
            if (integrityTokenRequest instanceof ao) {
            }
            this.f10089b.d("requestIntegrityToken(%s)", integrityTokenRequest);
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.f10088a.t(new af(this, taskCompletionSource, bArrDecode, lCloudProjectNumber, null, taskCompletionSource, integrityTokenRequest), taskCompletionSource);
            return taskCompletionSource.getTask();
        } catch (IllegalArgumentException e4) {
            return Tasks.forException(new IntegrityServiceException(-13, e4));
        }
    }
}
