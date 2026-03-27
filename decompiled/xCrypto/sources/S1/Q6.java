package S1;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class Q6 implements E2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f4214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b7 f4215c;

    public Q6(b7 b7Var, String str, List list) {
        this.f4213a = str;
        this.f4214b = list;
        Objects.requireNonNull(b7Var);
        this.f4215c = b7Var;
    }

    @Override // S1.E2
    public final void a(String str, int i4, Throwable th, byte[] bArr, Map map) {
        this.f4215c.z(true, i4, th, bArr, this.f4213a, this.f4214b);
    }
}
