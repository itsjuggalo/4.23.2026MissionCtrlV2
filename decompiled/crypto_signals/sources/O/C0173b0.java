package O;

import java.io.FileOutputStream;

/* JADX INFO: renamed from: O.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0173b0 extends K4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FileOutputStream f2186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FileOutputStream f2187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0175c0 f2189d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0173b0(C0175c0 c0175c0, K4.c cVar) {
        super(cVar);
        this.f2189d = c0175c0;
    }

    @Override // K4.a
    public final Object invokeSuspend(Object obj) {
        this.f2188c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.f2189d.a(null, this);
    }
}
