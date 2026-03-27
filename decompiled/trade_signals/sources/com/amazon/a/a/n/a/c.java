package com.amazon.a.a.n.a;

import android.os.Binder;
import android.os.RemoteException;
import com.amazon.d.a.j;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f13910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RemoteException f13911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private j f13912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.amazon.d.a.h f13913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.amazon.d.a.f f13914e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.amazon.d.a.g f13915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f13916g = Binder.getCallingUid();

    public c(com.amazon.d.a.f fVar) {
        this.f13914e = fVar;
        try {
            this.f13910a = fVar.a();
        } catch (RemoteException e8) {
            this.f13911b = e8;
        }
    }

    public String a() throws RemoteException {
        RemoteException remoteException = this.f13911b;
        if (remoteException == null) {
            return this.f13910a;
        }
        throw remoteException;
    }

    public j b() {
        return this.f13912c;
    }

    public com.amazon.d.a.h c() {
        return this.f13913d;
    }

    public com.amazon.d.a.f d() {
        return this.f13914e;
    }

    public com.amazon.d.a.g e() {
        return this.f13915f;
    }

    public int f() {
        return this.f13916g;
    }

    public String toString() {
        return "CommandResult: [CallingUid: " + this.f13916g + ", SuccessResult: " + this.f13912c + ", FailureResult: " + this.f13913d + ", DecisionResult: " + this.f13914e + ", ExceptionResult: " + this.f13915f + "]";
    }

    public c(com.amazon.d.a.g gVar) {
        this.f13915f = gVar;
    }

    public c(com.amazon.d.a.h hVar) {
        this.f13913d = hVar;
        try {
            this.f13910a = hVar.a();
        } catch (RemoteException e8) {
            this.f13911b = e8;
        }
    }

    public c(j jVar) {
        this.f13912c = jVar;
        try {
            this.f13910a = jVar.a();
        } catch (RemoteException e8) {
            this.f13911b = e8;
        }
    }
}
