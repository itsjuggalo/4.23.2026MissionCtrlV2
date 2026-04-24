package L3;

/* JADX INFO: renamed from: L3.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0398v extends C0390m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final K3.a f1544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1545d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0398v(T writer, K3.a json) {
        super(writer);
        kotlin.jvm.internal.r.f(writer, "writer");
        kotlin.jvm.internal.r.f(json, "json");
        this.f1544c = json;
    }

    @Override // L3.C0390m
    public void b() {
        n(true);
        this.f1545d++;
    }

    @Override // L3.C0390m
    public void c() {
        n(false);
        j("\n");
        int i4 = this.f1545d;
        for (int i5 = 0; i5 < i4; i5++) {
            j(this.f1544c.f().j());
        }
    }

    @Override // L3.C0390m
    public void o() {
        e(' ');
    }

    @Override // L3.C0390m
    public void p() {
        this.f1545d--;
    }
}
