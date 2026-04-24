package F4;

import F4.C0487a;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import v2.AbstractC2848n;

/* JADX INFO: renamed from: F4.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0509x {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0487a.c f1910d = C0487a.c.a("io.grpc.EquivalentAddressGroup.ATTR_AUTHORITY_OVERRIDE");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f1911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0487a f1912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1913c;

    public C0509x(SocketAddress socketAddress) {
        this(socketAddress, C0487a.f1724c);
    }

    public List a() {
        return this.f1911a;
    }

    public C0487a b() {
        return this.f1912b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0509x)) {
            return false;
        }
        C0509x c0509x = (C0509x) obj;
        if (this.f1911a.size() != c0509x.f1911a.size()) {
            return false;
        }
        for (int i8 = 0; i8 < this.f1911a.size(); i8++) {
            if (!((SocketAddress) this.f1911a.get(i8)).equals(c0509x.f1911a.get(i8))) {
                return false;
            }
        }
        return this.f1912b.equals(c0509x.f1912b);
    }

    public int hashCode() {
        return this.f1913c;
    }

    public String toString() {
        return "[" + this.f1911a + "/" + this.f1912b + "]";
    }

    public C0509x(SocketAddress socketAddress, C0487a c0487a) {
        this(Collections.singletonList(socketAddress), c0487a);
    }

    public C0509x(List list, C0487a c0487a) {
        AbstractC2848n.e(!list.isEmpty(), "addrs is empty");
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.f1911a = listUnmodifiableList;
        this.f1912b = (C0487a) AbstractC2848n.o(c0487a, "attrs");
        this.f1913c = listUnmodifiableList.hashCode();
    }
}
