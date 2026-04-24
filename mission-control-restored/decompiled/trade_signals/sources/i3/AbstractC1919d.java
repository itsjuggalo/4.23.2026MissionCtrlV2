package i3;

import h3.C1875k;
import p3.C2548b;

/* JADX INFO: renamed from: i3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1919d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f18783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1920e f18784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C1875k f18785c;

    /* JADX INFO: renamed from: i3.d$a */
    public enum a {
        Overwrite,
        Merge,
        AckUserWrite,
        ListenComplete
    }

    public AbstractC1919d(a aVar, C1920e c1920e, C1875k c1875k) {
        this.f18783a = aVar;
        this.f18784b = c1920e;
        this.f18785c = c1875k;
    }

    public C1875k a() {
        return this.f18785c;
    }

    public C1920e b() {
        return this.f18784b;
    }

    public a c() {
        return this.f18783a;
    }

    public abstract AbstractC1919d d(C2548b c2548b);
}
