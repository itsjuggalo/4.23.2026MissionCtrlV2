package r5;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import r5.C2585a;

/* JADX INFO: renamed from: r5.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2607x {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C2585a.c f22812d = C2585a.c.a("io.grpc.EquivalentAddressGroup.ATTR_AUTHORITY_OVERRIDE");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f22813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2585a f22814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f22815c;

    public C2607x(List list, C2585a c2585a) {
        H2.m.e(!list.isEmpty(), "addrs is empty");
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.f22813a = listUnmodifiableList;
        this.f22814b = (C2585a) H2.m.o(c2585a, "attrs");
        this.f22815c = listUnmodifiableList.hashCode();
    }

    public List a() {
        return this.f22813a;
    }

    public C2585a b() {
        return this.f22814b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2607x)) {
            return false;
        }
        C2607x c2607x = (C2607x) obj;
        if (this.f22813a.size() != c2607x.f22813a.size()) {
            return false;
        }
        for (int i7 = 0; i7 < this.f22813a.size(); i7++) {
            if (!((SocketAddress) this.f22813a.get(i7)).equals(c2607x.f22813a.get(i7))) {
                return false;
            }
        }
        return this.f22814b.equals(c2607x.f22814b);
    }

    public int hashCode() {
        return this.f22815c;
    }

    public String toString() {
        return "[" + this.f22813a + "/" + this.f22814b + "]";
    }

    public C2607x(SocketAddress socketAddress) {
        this(socketAddress, C2585a.f22601c);
    }

    public C2607x(SocketAddress socketAddress, C2585a c2585a) {
        this(Collections.singletonList(socketAddress), c2585a);
    }
}
