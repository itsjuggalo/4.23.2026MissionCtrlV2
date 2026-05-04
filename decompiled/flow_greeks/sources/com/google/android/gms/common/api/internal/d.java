package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d extends BasePendingResult implements e {
    private final com.google.android.gms.common.api.a api;
    private final a.c clientKey;

    public d(com.google.android.gms.common.api.a aVar, com.google.android.gms.common.api.g gVar) {
        super((com.google.android.gms.common.api.g) com.google.android.gms.common.internal.s.l(gVar, "GoogleApiClient must not be null"));
        com.google.android.gms.common.internal.s.l(aVar, "Api must not be null");
        this.clientKey = aVar.b();
        this.api = aVar;
    }

    public final void c(RemoteException remoteException) {
        setFailedResult(new Status(8, remoteException.getLocalizedMessage(), (PendingIntent) null));
    }

    public abstract void doExecute(a.b bVar);

    public final com.google.android.gms.common.api.a getApi() {
        return this.api;
    }

    public final a.c getClientKey() {
        return this.clientKey;
    }

    public final void run(a.b bVar) throws DeadObjectException {
        try {
            doExecute(bVar);
        } catch (DeadObjectException e10) {
            c(e10);
            throw e10;
        } catch (RemoteException e11) {
            c(e11);
        }
    }

    public final void setFailedResult(Status status) {
        com.google.android.gms.common.internal.s.b(!status.V(), "Failed result must not be success");
        com.google.android.gms.common.api.k kVarCreateFailedResult = createFailedResult(status);
        setResult(kVarCreateFailedResult);
        onSetFailedResult(kVarCreateFailedResult);
    }

    public void onSetFailedResult(com.google.android.gms.common.api.k kVar) {
    }
}
