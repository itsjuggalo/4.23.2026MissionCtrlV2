package rb;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rb.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class x {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a.c f19736d = a.c.a("io.grpc.EquivalentAddressGroup.ATTR_AUTHORITY_OVERRIDE");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f19737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f19738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f19739c;

    public x(List list, a aVar) {
        p6.n.e(!list.isEmpty(), "addrs is empty");
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.f19737a = listUnmodifiableList;
        this.f19738b = (a) p6.n.o(aVar, "attrs");
        this.f19739c = listUnmodifiableList.hashCode();
    }

    public List a() {
        return this.f19737a;
    }

    public a b() {
        return this.f19738b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        if (this.f19737a.size() != xVar.f19737a.size()) {
            return false;
        }
        for (int i10 = 0; i10 < this.f19737a.size(); i10++) {
            if (!((SocketAddress) this.f19737a.get(i10)).equals(xVar.f19737a.get(i10))) {
                return false;
            }
        }
        return this.f19738b.equals(xVar.f19738b);
    }

    public int hashCode() {
        return this.f19739c;
    }

    public String toString() {
        return "[" + this.f19737a + "/" + this.f19738b + "]";
    }

    public x(SocketAddress socketAddress) {
        this(socketAddress, a.f19462c);
    }

    public x(SocketAddress socketAddress, a aVar) {
        this(Collections.singletonList(socketAddress), aVar);
    }
}
