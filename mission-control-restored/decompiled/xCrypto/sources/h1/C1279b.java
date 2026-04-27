package h1;

import java.util.Map;
import k1.InterfaceC1567a;

/* JADX INFO: renamed from: h1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1279b extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1567a f12093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f12094b;

    public C1279b(InterfaceC1567a interfaceC1567a, Map map) {
        if (interfaceC1567a == null) {
            throw new NullPointerException("Null clock");
        }
        this.f12093a = interfaceC1567a;
        if (map == null) {
            throw new NullPointerException("Null values");
        }
        this.f12094b = map;
    }

    @Override // h1.f
    public InterfaceC1567a e() {
        return this.f12093a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.f12093a.equals(fVar.e()) && this.f12094b.equals(fVar.h())) {
                return true;
            }
        }
        return false;
    }

    @Override // h1.f
    public Map h() {
        return this.f12094b;
    }

    public int hashCode() {
        return ((this.f12093a.hashCode() ^ 1000003) * 1000003) ^ this.f12094b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f12093a + ", values=" + this.f12094b + "}";
    }
}
