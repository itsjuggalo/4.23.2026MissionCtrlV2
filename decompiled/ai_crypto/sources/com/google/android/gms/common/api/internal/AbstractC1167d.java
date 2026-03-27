package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1167d extends BasePendingResult implements InterfaceC1168e {
    private final com.google.android.gms.common.api.a api;
    private final a.c clientKey;

    public AbstractC1167d(com.google.android.gms.common.api.a aVar, com.google.android.gms.common.api.f fVar) {
        super((com.google.android.gms.common.api.f) AbstractC1207s.l(fVar, "GoogleApiClient must not be null"));
        AbstractC1207s.l(aVar, "Api must not be null");
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

    public void onSetFailedResult(com.google.android.gms.common.api.k kVar) {
    }

    public final void run(a.b bVar) throws DeadObjectException {
        try {
            doExecute(bVar);
        } catch (DeadObjectException e7) {
            c(e7);
            throw e7;
        } catch (RemoteException e8) {
            c(e8);
        }
    }

    public final void setFailedResult(Status status) {
        AbstractC1207s.b(!status.F(), "Failed result must not be success");
        com.google.android.gms.common.api.k kVarCreateFailedResult = createFailedResult(status);
        setResult(kVarCreateFailedResult);
        onSetFailedResult(kVarCreateFailedResult);
    }
}
