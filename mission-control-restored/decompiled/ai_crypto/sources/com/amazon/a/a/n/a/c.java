package com.amazon.a.a.n.a;

import android.os.Binder;
import android.os.RemoteException;
import com.amazon.d.a.j;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RemoteException f9800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private j f9801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.amazon.d.a.h f9802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.amazon.d.a.f f9803e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.amazon.d.a.g f9804f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f9805g = Binder.getCallingUid();

    public c(j jVar) {
        this.f9801c = jVar;
        try {
            this.f9799a = jVar.a();
        } catch (RemoteException e7) {
            this.f9800b = e7;
        }
    }

    public String a() throws RemoteException {
        RemoteException remoteException = this.f9800b;
        if (remoteException == null) {
            return this.f9799a;
        }
        throw remoteException;
    }

    public j b() {
        return this.f9801c;
    }

    public com.amazon.d.a.h c() {
        return this.f9802d;
    }

    public com.amazon.d.a.f d() {
        return this.f9803e;
    }

    public com.amazon.d.a.g e() {
        return this.f9804f;
    }

    public int f() {
        return this.f9805g;
    }

    public String toString() {
        return "CommandResult: [CallingUid: " + this.f9805g + ", SuccessResult: " + this.f9801c + ", FailureResult: " + this.f9802d + ", DecisionResult: " + this.f9803e + ", ExceptionResult: " + this.f9804f + "]";
    }

    public c(com.amazon.d.a.h hVar) {
        this.f9802d = hVar;
        try {
            this.f9799a = hVar.a();
        } catch (RemoteException e7) {
            this.f9800b = e7;
        }
    }

    public c(com.amazon.d.a.f fVar) {
        this.f9803e = fVar;
        try {
            this.f9799a = fVar.a();
        } catch (RemoteException e7) {
            this.f9800b = e7;
        }
    }

    public c(com.amazon.d.a.g gVar) {
        this.f9804f = gVar;
    }
}
