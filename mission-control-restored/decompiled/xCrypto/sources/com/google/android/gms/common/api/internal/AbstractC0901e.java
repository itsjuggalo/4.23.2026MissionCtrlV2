package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0901e extends BasePendingResult implements InterfaceC0902f {
    private final com.google.android.gms.common.api.a api;
    private final a.c clientKey;

    public AbstractC0901e(com.google.android.gms.common.api.a aVar, com.google.android.gms.common.api.f fVar) {
        super((com.google.android.gms.common.api.f) AbstractC0940s.l(fVar, "GoogleApiClient must not be null"));
        AbstractC0940s.l(aVar, "Api must not be null");
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
        } catch (DeadObjectException e4) {
            c(e4);
            throw e4;
        } catch (RemoteException e5) {
            c(e5);
        }
    }

    public final void setFailedResult(Status status) {
        AbstractC0940s.b(!status.o(), "Failed result must not be success");
        com.google.android.gms.common.api.k kVarCreateFailedResult = createFailedResult(status);
        setResult(kVarCreateFailedResult);
        onSetFailedResult(kVarCreateFailedResult);
    }
}
