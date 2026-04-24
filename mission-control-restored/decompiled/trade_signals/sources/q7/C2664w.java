package q7;

import kotlin.jvm.internal.AbstractC2304t;
import p7.AbstractC2609b;

/* JADX INFO: renamed from: q7.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2664w extends C2656n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC2609b f22902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f22903d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2664w(A writer, AbstractC2609b json) {
        super(writer);
        AbstractC2304t.f(writer, "writer");
        AbstractC2304t.f(json, "json");
        this.f22902c = json;
    }

    @Override // q7.C2656n
    public void b() {
        o(true);
        this.f22903d++;
    }

    @Override // q7.C2656n
    public void c() {
        o(false);
        k("\n");
        int i8 = this.f22903d;
        for (int i9 = 0; i9 < i8; i9++) {
            k(this.f22902c.f().n());
        }
    }

    @Override // q7.C2656n
    public void d() {
        if (a()) {
            o(false);
        } else {
            c();
        }
    }

    @Override // q7.C2656n
    public void p() {
        f(' ');
    }

    @Override // q7.C2656n
    public void q() {
        this.f22903d--;
    }
}
