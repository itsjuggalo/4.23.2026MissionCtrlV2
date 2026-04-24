package O;

import java.io.FileInputStream;

/* JADX INFO: loaded from: classes.dex */
public final class T extends K4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f2155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FileInputStream f2156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ U f2158d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T(U u6, K4.c cVar) {
        super(cVar);
        this.f2158d = u6;
    }

    @Override // K4.a
    public final Object invokeSuspend(Object obj) {
        this.f2157c = obj;
        this.e |= Integer.MIN_VALUE;
        return U.c(this.f2158d, this);
    }
}
