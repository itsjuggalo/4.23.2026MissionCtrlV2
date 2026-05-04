package com.google.android.play.core.integrity;

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
import n6.c1;
import n6.g0;
import n6.p0;
import n6.v0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final n6.f f5905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final v0 f5906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f5907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f5908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final at f5909e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final k f5910f;

    public aj(Context context, v0 v0Var, at atVar, k kVar) {
        this.f5907c = context.getPackageName();
        this.f5906b = v0Var;
        this.f5909e = atVar;
        this.f5910f = kVar;
        this.f5908d = context;
        if (n6.j.b(context)) {
            this.f5905a = new n6.f(context, v0Var, "IntegrityService", ak.f5911a, new c1() { // from class: com.google.android.play.core.integrity.ae
                @Override // n6.c1
                public final Object a(IBinder iBinder) {
                    return p0.H(iBinder);
                }
            }, null);
        } else {
            v0Var.b("Phonesky is not installed.", new Object[0]);
            this.f5905a = null;
        }
    }

    public static /* bridge */ /* synthetic */ Bundle a(aj ajVar, byte[] bArr, Long l10, Parcelable parcelable) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", ajVar.f5907c);
        bundle.putByteArray("nonce", bArr);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 4);
        bundle.putInt("playcore.integrity.version.patch", 0);
        if (l10 != null) {
            bundle.putLong("cloud.prj", l10.longValue());
        }
        if (parcelable != null) {
            bundle.putParcelable("network", parcelable);
        }
        ArrayList arrayList = new ArrayList();
        g0.b(3, arrayList);
        bundle.putParcelableArrayList("event_timestamps", new ArrayList<>(g0.a(arrayList)));
        return bundle;
    }

    public final Task b(Activity activity, Bundle bundle) {
        if (this.f5905a == null) {
            return Tasks.forException(new IntegrityServiceException(-2, null));
        }
        int i10 = bundle.getInt("dialog.intent.type");
        this.f5906b.d("requestAndShowDialog(%s, %s)", this.f5907c, Integer.valueOf(i10));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f5905a.t(new ag(this, taskCompletionSource, bundle, activity, taskCompletionSource, i10), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public final Task c(IntegrityTokenRequest integrityTokenRequest) {
        if (this.f5905a == null) {
            return Tasks.forException(new IntegrityServiceException(-2, null));
        }
        if (n6.j.a(this.f5908d) < 82380000) {
            return Tasks.forException(new IntegrityServiceException(-14, null));
        }
        try {
            byte[] bArrDecode = Base64.decode(integrityTokenRequest.nonce(), 10);
            Long lCloudProjectNumber = integrityTokenRequest.cloudProjectNumber();
            if (integrityTokenRequest instanceof ao) {
            }
            this.f5906b.d("requestIntegrityToken(%s)", integrityTokenRequest);
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.f5905a.t(new af(this, taskCompletionSource, bArrDecode, lCloudProjectNumber, null, taskCompletionSource, integrityTokenRequest), taskCompletionSource);
            return taskCompletionSource.getTask();
        } catch (IllegalArgumentException e10) {
            return Tasks.forException(new IntegrityServiceException(-13, e10));
        }
    }
}
