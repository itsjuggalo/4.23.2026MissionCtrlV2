package com.amazon.a.a.n.a;

import android.os.Binder;
import android.os.RemoteException;
import com.amazon.d.a.j;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RemoteException f4427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private j f4428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.amazon.d.a.h f4429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.amazon.d.a.f f4430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.amazon.d.a.g f4431f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f4432g = Binder.getCallingUid();

    public c(j jVar) {
        this.f4428c = jVar;
        try {
            this.f4426a = jVar.a();
        } catch (RemoteException e10) {
            this.f4427b = e10;
        }
    }

    public String a() throws RemoteException {
        RemoteException remoteException = this.f4427b;
        if (remoteException == null) {
            return this.f4426a;
        }
        throw remoteException;
    }

    public j b() {
        return this.f4428c;
    }

    public com.amazon.d.a.h c() {
        return this.f4429d;
    }

    public com.amazon.d.a.f d() {
        return this.f4430e;
    }

    public com.amazon.d.a.g e() {
        return this.f4431f;
    }

    public int f() {
        return this.f4432g;
    }

    public String toString() {
        return "CommandResult: [CallingUid: " + this.f4432g + ", SuccessResult: " + this.f4428c + ", FailureResult: " + this.f4429d + ", DecisionResult: " + this.f4430e + ", ExceptionResult: " + this.f4431f + "]";
    }

    public c(com.amazon.d.a.h hVar) {
        this.f4429d = hVar;
        try {
            this.f4426a = hVar.a();
        } catch (RemoteException e10) {
            this.f4427b = e10;
        }
    }

    public c(com.amazon.d.a.f fVar) {
        this.f4430e = fVar;
        try {
            this.f4426a = fVar.a();
        } catch (RemoteException e10) {
            this.f4427b = e10;
        }
    }

    public c(com.amazon.d.a.g gVar) {
        this.f4431f = gVar;
    }
}
