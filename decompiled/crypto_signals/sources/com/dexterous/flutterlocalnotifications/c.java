package com.dexterous.flutterlocalnotifications;

import Z3.p;

/* JADX INFO: loaded from: classes.dex */
public final class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f4976b;

    public /* synthetic */ c(p pVar, int i) {
        this.f4975a = i;
        this.f4976b = pVar;
    }

    @Override // com.dexterous.flutterlocalnotifications.i
    public final void b(boolean z6) {
        switch (this.f4975a) {
            case 0:
                this.f4976b.c(Boolean.valueOf(z6));
                break;
            default:
                this.f4976b.c(Boolean.valueOf(z6));
                break;
        }
    }

    @Override // com.dexterous.flutterlocalnotifications.i
    public final void d() {
        switch (this.f4975a) {
            case 0:
                this.f4976b.a(null, "permissionRequestInProgress", "Another permission request is already in progress");
                break;
            default:
                this.f4976b.a(null, "permissionRequestInProgress", "Another permission request is already in progress");
                break;
        }
    }
}
