package com.amazon.a.a.n.a;

import android.os.Binder;
import android.os.RemoteException;
import com.amazon.d.a.j;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RemoteException f8615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private j f8616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.amazon.d.a.h f8617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.amazon.d.a.f f8618e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.amazon.d.a.g f8619f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f8620g = Binder.getCallingUid();

    public c(j jVar) {
        this.f8616c = jVar;
        try {
            this.f8614a = jVar.a();
        } catch (RemoteException e4) {
            this.f8615b = e4;
        }
    }

    public String a() throws RemoteException {
        RemoteException remoteException = this.f8615b;
        if (remoteException == null) {
            return this.f8614a;
        }
        throw remoteException;
    }

    public j b() {
        return this.f8616c;
    }

    public com.amazon.d.a.h c() {
        return this.f8617d;
    }

    public com.amazon.d.a.f d() {
        return this.f8618e;
    }

    public com.amazon.d.a.g e() {
        return this.f8619f;
    }

    public int f() {
        return this.f8620g;
    }

    public String toString() {
        return "CommandResult: [CallingUid: " + this.f8620g + ", SuccessResult: " + this.f8616c + ", FailureResult: " + this.f8617d + ", DecisionResult: " + this.f8618e + ", ExceptionResult: " + this.f8619f + "]";
    }

    public c(com.amazon.d.a.h hVar) {
        this.f8617d = hVar;
        try {
            this.f8614a = hVar.a();
        } catch (RemoteException e4) {
            this.f8615b = e4;
        }
    }

    public c(com.amazon.d.a.f fVar) {
        this.f8618e = fVar;
        try {
            this.f8614a = fVar.a();
        } catch (RemoteException e4) {
            this.f8615b = e4;
        }
    }

    public c(com.amazon.d.a.g gVar) {
        this.f8619f = gVar;
    }
}
