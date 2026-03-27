package com.google.firebase.storage;

import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f5594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f5595b;

    public r(s sVar, i iVar) {
        this.f5595b = sVar;
        if (iVar != null) {
            this.f5594a = iVar;
            return;
        }
        if (sVar.isCanceled()) {
            this.f5594a = i.a(Status.f5061m);
        } else if (sVar.f5604h == 64) {
            this.f5594a = i.a(Status.f5059k);
        } else {
            this.f5594a = null;
        }
    }
}
