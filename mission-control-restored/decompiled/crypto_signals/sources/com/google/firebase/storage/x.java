package com.google.firebase.storage;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z f5625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ r f5627d;

    public /* synthetic */ x(z zVar, Object obj, r rVar, int i) {
        this.f5624a = i;
        this.f5625b = zVar;
        this.f5626c = obj;
        this.f5627d = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5624a) {
            case 0:
                ((y) this.f5625b.f5632f).a(this.f5626c, this.f5627d);
                break;
            default:
                ((y) this.f5625b.f5632f).a(this.f5626c, this.f5627d);
                break;
        }
    }
}
