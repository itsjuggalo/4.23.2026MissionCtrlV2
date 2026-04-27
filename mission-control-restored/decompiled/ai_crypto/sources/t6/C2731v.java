package t6;

/* JADX INFO: renamed from: t6.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2731v extends C2723m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s6.a f24337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f24338d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2731v(T writer, s6.a json) {
        super(writer);
        kotlin.jvm.internal.r.f(writer, "writer");
        kotlin.jvm.internal.r.f(json, "json");
        this.f24337c = json;
    }

    @Override // t6.C2723m
    public void b() {
        n(true);
        this.f24338d++;
    }

    @Override // t6.C2723m
    public void c() {
        n(false);
        j("\n");
        int i7 = this.f24338d;
        for (int i8 = 0; i8 < i7; i8++) {
            j(this.f24337c.f().j());
        }
    }

    @Override // t6.C2723m
    public void o() {
        e(' ');
    }

    @Override // t6.C2723m
    public void p() {
        this.f24338d--;
    }
}
